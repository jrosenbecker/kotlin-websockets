package com.joerosenbecker.kotlinwebsockets.impl

import com.joerosenbecker.kotlinwebsockets.contracts.TracksService
import com.joerosenbecker.kotlinwebsockets.data.repository.TrackRepository
import com.joerosenbecker.kotlinwebsockets.viewmodels.TrackViewModel
import org.springframework.stereotype.Service

@Service
class TracksServiceImpl : TracksService{
    override fun getTrack(id: Number): TrackViewModel {
        val repo = TrackRepository()
        return TrackViewModel.makeTrackViewModel(repo.getTrack(id.toInt()));
    }
}