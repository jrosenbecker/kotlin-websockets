package com.joerosenbecker.kotlinwebsockets.controllers

import com.joerosenbecker.kotlinwebsockets.contracts.PlaylistService
import com.joerosenbecker.kotlinwebsockets.viewmodels.PlaylistViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/playlists")
@CrossOrigin
class PlaylistController {
    @Autowired
    lateinit var playlistService: PlaylistService;

    @Autowired
    lateinit var template: SimpMessagingTemplate

    @GetMapping("/{playlistId}")
    fun getPlaylist(@PathVariable("playlistId") playlistId: Int): PlaylistViewModel {
        val playlist = this.playlistService.getPlaylist(playlistId);
        return playlist;
    }

    @PostMapping("/{playlistId}/add")
    fun addTracksToPlaylist(@PathVariable("playlistId") playlistId: Int, @RequestParam("trackId") trackIds: List<Int>): PlaylistViewModel {
        val playlist = this.playlistService.addTrackToPlaylist(playlistId, trackIds)
        this.template.convertAndSend("/topic/playlist", playlist)
        return playlist
    }
}