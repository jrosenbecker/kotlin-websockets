package com.joerosenbecker.kotlinwebsockets.impl

import com.joerosenbecker.kotlinwebsockets.contracts.TracksService
import com.joerosenbecker.kotlinwebsockets.data.repository.TrackRepository
import com.joerosenbecker.kotlinwebsockets.viewmodels.TrackViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TracksServiceImpl : TracksService {
    @Autowired
    lateinit var tracksRepository: TrackRepository

    override fun getAllTracks(): MutableList<TrackViewModel> {
        val tracks: MutableList<TrackViewModel> = arrayListOf()
        this.tracksRepository.getAllTracks().forEach {
            tracks.add(TrackViewModel.makeTrackViewModel(it))
        }

        return tracks;
    }

    override fun getTrack(id: Number): TrackViewModel {
        return TrackViewModel.makeTrackViewModel(this.tracksRepository.getTrack(id.toInt()));
    }
}