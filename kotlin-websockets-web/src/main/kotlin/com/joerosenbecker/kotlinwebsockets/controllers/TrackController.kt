package com.joerosenbecker.kotlinwebsockets.controllers

import com.joerosenbecker.kotlinwebsockets.contracts.TracksService
import com.joerosenbecker.kotlinwebsockets.viewmodels.TrackViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/api/tracks")
class TrackController {

    @Autowired
    lateinit var tracksService: TracksService;

    @GetMapping("")
    fun getAllTracks(): MutableList<TrackViewModel> {
        return this.tracksService.getAllTracks()
    }

    @GetMapping("/{trackId}")
    fun getTrack(@PathVariable("trackId") trackId: Int): TrackViewModel {
        val track = this.tracksService.getTrack(trackId);
        return track;
    }
}