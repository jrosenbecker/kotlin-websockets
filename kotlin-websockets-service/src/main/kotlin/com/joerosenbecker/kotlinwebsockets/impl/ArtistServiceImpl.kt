package com.joerosenbecker.kotlinwebsockets.impl

import com.joerosenbecker.kotlinwebsockets.contracts.ArtistService
import com.joerosenbecker.kotlinwebsockets.data.repository.ArtistRepository
import com.joerosenbecker.kotlinwebsockets.viewmodels.ArtistViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArtistServiceImpl : ArtistService {

    @Autowired
    lateinit var artistRepository: ArtistRepository

    override fun getAllArtists(): MutableList<ArtistViewModel> {
        val artistRows = this.artistRepository.getAllArtists();
        val viewModels: MutableList<ArtistViewModel> = arrayListOf();
        artistRows.forEach {
            viewModels.add(ArtistViewModel.makeArtistViewModel(it))
        }

        return viewModels
    }

    override fun getArtist(id: Number): ArtistViewModel {
        return ArtistViewModel.makeArtistViewModel(this.artistRepository.getArtist(id.toInt()))
    }
}