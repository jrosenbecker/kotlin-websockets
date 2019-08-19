package com.joerosenbecker.kotlinwebsockets

import com.fasterxml.jackson.core.io.JsonStringEncoder
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.joerosenbecker.kotlinwebsockets.viewmodels.PlaylistViewModel
import jdk.nashorn.internal.ir.debug.JSONWriter
import jdk.nashorn.internal.parser.JSONParser
import jdk.nashorn.internal.runtime.JSONFunctions
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import org.springframework.web.reactive.socket.WebSocketMessage
import org.springframework.web.socket.*
import org.springframework.web.socket.handler.AbstractWebSocketHandler
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.concurrent.ConcurrentHashMap

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class PlaylistHandler : AbstractWebSocketHandler() {
    private val userMap = ConcurrentHashMap<WebSocketSession, String>()
    private var nextUserNumber = 1;

    override fun afterConnectionEstablished(session: WebSocketSession) {
        val username = "User ${nextUserNumber++}";
        userMap.put(session, username);
        broadcastMessage("Server", "$username joined")
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        val username = userMap.get(session);
        if (username !== null) {
            userMap.remove(session);
            broadcastMessage("Server", "$username left");
        }
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val username = userMap.get(session)

        broadcastMessage(username, message.payload)
    }

    override fun handleBinaryMessage(session: WebSocketSession, message: BinaryMessage) {
        println("New Binary Message Received");
        session.sendMessage(message);
    }

    fun broadcastMessage(sender: String?, message: String) {
        userMap.keys.filter { it.isOpen }.forEach { session ->
            val formattedMessage = "${sender}: ${message}"
            session.sendMessage(TextMessage(formattedMessage))
        }
    }
}