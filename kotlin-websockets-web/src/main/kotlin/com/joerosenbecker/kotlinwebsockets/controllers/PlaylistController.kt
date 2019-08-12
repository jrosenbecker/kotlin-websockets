package com.joerosenbecker.kotlinwebsockets.controllers

import com.joerosenbecker.kotlinwebsockets.contracts.PlaylistService
import com.joerosenbecker.kotlinwebsockets.viewmodels.PlaylistViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/playlists")
class PlaylistController {
    @Autowired
    lateinit var playlistService: PlaylistService;

    @GetMapping("/{playlistId}")
    fun getPlaylist(@PathVariable("playlistId") playlistId: Int): PlaylistViewModel {
        return this.playlistService.getPlaylist(playlistId);
    }

    @PostMapping("/{playlistId}/add")
    fun addTracksToPlaylist(@PathVariable("playlistId") playlistId: Int, @RequestParam("trackId") trackIds: List<Int>): PlaylistViewModel {
        return this.playlistService.addTrackToPlaylist(playlistId, trackIds);
    }
}