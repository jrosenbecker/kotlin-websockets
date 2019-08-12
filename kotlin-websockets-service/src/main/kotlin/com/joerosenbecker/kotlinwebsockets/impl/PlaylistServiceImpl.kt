package com.joerosenbecker.kotlinwebsockets.impl

import com.joerosenbecker.kotlinwebsockets.contracts.PlaylistService
import com.joerosenbecker.kotlinwebsockets.data.repository.PlaylistRepository
import com.joerosenbecker.kotlinwebsockets.viewmodels.PlaylistViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlaylistServiceImpl : PlaylistService{
    @Autowired
    lateinit var playlistRepository: PlaylistRepository

    override fun getPlaylist(id: Number): PlaylistViewModel {
        return PlaylistViewModel.makePlaylistViewModel(this.playlistRepository.getPlaylist(id.toInt()))
    }

    override fun addTrackToPlaylist(playlistId: Int, trackIds: List<Int>): PlaylistViewModel {
        this.playlistRepository.addTracksToPlaylist(playlistId, trackIds);
        return this.getPlaylist(playlistId);
    }
}