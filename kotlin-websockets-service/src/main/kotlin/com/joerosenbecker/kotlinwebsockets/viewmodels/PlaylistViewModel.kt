package com.joerosenbecker.kotlinwebsockets.viewmodels

import com.joerosenbecker.kotlinwebsockets.data.models.Album
import com.joerosenbecker.kotlinwebsockets.data.models.Artist
import com.joerosenbecker.kotlinwebsockets.data.models.Playlist
import com.joerosenbecker.kotlinwebsockets.data.models.Track
import org.jetbrains.exposed.sql.ResultRow

class PlaylistViewModel(
        var id: Number,
        var name: String,
        var tracks: List<TrackViewModel>
) {
    companion object PlaylistViewModelFactory {
        fun makePlaylistViewModel(results: List<ResultRow>): PlaylistViewModel {
            if (results == null || results.count() === 0) {
                throw Exception()
            }

            var tracks: MutableList<TrackViewModel>  = arrayListOf()
            results.forEach {
                tracks.add(TrackViewModel(
                        id = it[Track.id],
                        name = it[Track.name],
                        album = AlbumViewModel(
                                id = it[Album.id],
                                name = it[Album.name],
                                artist = ArtistViewModel(
                                        id = it[Artist.id],
                                        name = it[Artist.name]
                                )
                        )
                ))
            }



            val playlist = PlaylistViewModel(
                    tracks = tracks,
                    name = results[0][Playlist.name],
                    id = results[0][Playlist.id]
            )

            return playlist;
        }
    }
}