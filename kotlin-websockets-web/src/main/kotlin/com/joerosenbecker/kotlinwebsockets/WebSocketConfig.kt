package com.joerosenbecker.kotlinwebsockets

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.*

@Configuration
@EnableWebSocket
class WebSocketConfig : WebSocketConfigurer {

    @Autowired
    lateinit var playlistHandler: PlaylistHandler;

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        println("Registering....")
        registry.addHandler(playlistHandler,"/socket").setAllowedOrigins("*")
    }
}