package com.joerosenbecker.kotlinwebsockets.viewmodels

import com.joerosenbecker.kotlinwebsockets.data.models.Album
import com.joerosenbecker.kotlinwebsockets.data.models.Artist
import org.jetbrains.exposed.sql.ResultRow

class AlbumViewModel (
        var id: Number,
        var name: String,
        var artist: ArtistViewModel
) {
    companion object AlbumViewModelFactory {
        fun makeAlbumViewModel(record: ResultRow?): AlbumViewModel {
            if (record == null) {
                throw Exception()
            }

            return AlbumViewModel(
                    id = record[Album.id],
                    name = record[Album.name],
                    artist = ArtistViewModel(
                            id = record[Artist.id],
                            name = record[Artist.name]
                    )
            )
        }
    }
}
