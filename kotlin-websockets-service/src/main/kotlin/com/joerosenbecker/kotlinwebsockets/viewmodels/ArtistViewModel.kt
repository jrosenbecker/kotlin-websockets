package com.joerosenbecker.kotlinwebsockets.viewmodels

import com.joerosenbecker.kotlinwebsockets.data.models.Artist
import org.jetbrains.exposed.sql.ResultRow
import java.lang.Exception

class ArtistViewModel(
        var id: Number,
        var name: String
) {
    companion object ArtistViewModelFactory {
        fun makeArtistViewModel(record: ResultRow?): ArtistViewModel {
            if (record == null) {
                throw Exception()
            }

            return ArtistViewModel(
                id = record[Artist.id],
                name = record[Artist.name]
            )
        }
    }
}