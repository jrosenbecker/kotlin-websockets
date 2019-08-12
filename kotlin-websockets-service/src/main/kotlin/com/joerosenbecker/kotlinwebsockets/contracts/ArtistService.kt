package com.joerosenbecker.kotlinwebsockets.contracts

import com.joerosenbecker.kotlinwebsockets.viewmodels.ArtistViewModel

interface ArtistService {
    fun getAllArtists(): MutableList<ArtistViewModel>

    fun getArtist(id: Number): ArtistViewModel
}