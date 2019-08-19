package com.joerosenbecker.kotlinwebsockets

import com.joerosenbecker.kotlinwebsockets.contracts.PlaylistService
import com.joerosenbecker.kotlinwebsockets.viewmodels.PlaylistViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.Message
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class PlaylistWebSocketController {

    @Autowired
    lateinit var playlistService: PlaylistService;

    @MessageMapping("/playlist")
    @SendTo("/topic/playlist")
    fun send(@Payload message: Integer): PlaylistViewModel {
        return this.playlistService.getPlaylist(message);
    }
}