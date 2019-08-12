package com.joerosenbecker.kotlinwebsockets.impl

import com.joerosenbecker.kotlinwebsockets.contracts.AlbumService
import com.joerosenbecker.kotlinwebsockets.data.models.Album
import com.joerosenbecker.kotlinwebsockets.data.repository.AlbumRepository
import com.joerosenbecker.kotlinwebsockets.viewmodels.AlbumViewModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class AlbumServiceImpl : AlbumService {

    @Autowired
    lateinit var albumRepository: AlbumRepository

    override fun getAllAlbums(): MutableList<AlbumViewModel> {
        val albumRecords = this.albumRepository.getAllAlbums()
        val albumViewModels: MutableList<AlbumViewModel> = arrayListOf()
        albumRecords.forEach {
            albumViewModels.add(AlbumViewModel.makeAlbumViewModel(it))
        }
        return albumViewModels;
    }

    override fun getAlbum(id: Number): AlbumViewModel {
        val album = this.albumRepository.getAlbum(id.toInt())
        return AlbumViewModel.makeAlbumViewModel(album);
    }
}