package com.joerosenbecker.kotlinwebsockets.contracts

import com.joerosenbecker.kotlinwebsockets.viewmodels.PlaylistViewModel

interface PlaylistService {
    fun getPlaylist(id: Number): PlaylistViewModel

    fun addTrackToPlaylist(playlistId: Int, trackIds: List<Int>): PlaylistViewModel
}