package com.joerosenbecker.kotlinwebsockets.controllers

import com.joerosenbecker.kotlinwebsockets.models.Track
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/tracks")
class TrackController {
    @GetMapping("")
    fun root(model: Model): Track {
        val track = Track();
        track.title = "Jaws Theme Swimming";
        track.artist = "Brand New";
        track.album = "Deja Entendu";
        return track;
    }
}