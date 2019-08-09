package com.joerosenbecker.kotlinwebsockets.contracts

import com.joerosenbecker.kotlinwebsockets.viewmodels.TrackViewModel

interface TracksService {
    fun getTrack(id: Number): TrackViewModel
}