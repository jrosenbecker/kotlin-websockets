package com.joerosenbecker.kotlinwebsockets.viewmodels

import com.joerosenbecker.kotlinwebsockets.data.models.Album
import com.joerosenbecker.kotlinwebsockets.data.models.Artist
import com.joerosenbecker.kotlinwebsockets.data.models.Track
import org.jetbrains.exposed.sql.ResultRow
import java.lang.Exception

class TrackViewModel(
        val id: Number,
        val name: String,
        val album: AlbumViewModel
) {
    companion object TrackViewModelFactory {
        fun makeTrackViewModel(record: ResultRow?): TrackViewModel {
            if (record == null) {
                throw Exception();
            }
            return TrackViewModel(
                id = record[Track.id],
                name = record[Track.name],
                album = AlbumViewModel(
                    id = record[Album.id],
                    name = record[Album.name],
                    artist = ArtistViewModel(
                            id = record[Artist.id],
                            name = record[Artist.name]
                    )
                )
            )
        }
    }
}
