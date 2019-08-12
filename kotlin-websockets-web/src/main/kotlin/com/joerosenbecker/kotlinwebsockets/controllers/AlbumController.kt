package com.joerosenbecker.kotlinwebsockets.controllers

import com.joerosenbecker.kotlinwebsockets.contracts.AlbumService
import com.joerosenbecker.kotlinwebsockets.viewmodels.AlbumViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/albums")
class AlbumController {
    @Autowired
    lateinit var albumService: AlbumService

    @GetMapping("")
    fun getAllAlbums(): MutableList<AlbumViewModel> {
        return this.albumService.getAllAlbums()
    }

    @GetMapping("/{albumId}")
    fun getAlbum(@PathVariable("albumId") albumId: Int): AlbumViewModel {
        return this.albumService.getAlbum(albumId);
    }
}