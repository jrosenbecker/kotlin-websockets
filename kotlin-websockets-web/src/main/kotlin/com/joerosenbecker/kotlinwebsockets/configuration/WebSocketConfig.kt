package com.joerosenbecker.kotlinwebsockets.configuration

import com.joerosenbecker.kotlinwebsockets.handlers.PlaylistHandler
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfig : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(PlaylistHandler(), "/api/ws/playlists").withSockJS()
    }
}