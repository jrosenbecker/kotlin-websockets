package com.joerosenbecker.kotlinwebsockets.handlers

import org.springframework.web.socket.*
import org.springframework.web.socket.handler.TextWebSocketHandler

class PlaylistHandler : TextWebSocketHandler() {
    override fun afterConnectionEstablished(session: WebSocketSession) {
        super.afterConnectionEstablished(session)
        println("Websocket connection established")
    }
}