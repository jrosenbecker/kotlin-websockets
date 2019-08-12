package com.joerosenbecker.kotlinwebsockets.contracts

import com.joerosenbecker.kotlinwebsockets.viewmodels.AlbumViewModel

interface AlbumService {
    fun getAllAlbums(): MutableList<AlbumViewModel>

    fun getAlbum(id: Number): AlbumViewModel
}