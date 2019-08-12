package com.joerosenbecker.kotlinwebsockets.data.repository

import com.joerosenbecker.kotlinwebsockets.data.models.Album
import com.joerosenbecker.kotlinwebsockets.data.models.Artist
import com.joerosenbecker.kotlinwebsockets.data.models.Track
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class TrackRepository : Repository() {

    fun getAllTracks(): List<ResultRow> {
        var result: List<ResultRow> = arrayListOf();
        transaction {
            result = (Track innerJoin Album innerJoin Artist).selectAll().toList()
        }

        return result;
    }

    fun getTrack(id: Int): ResultRow? {
        var result: ResultRow? = null;
         transaction {
            result = (Track innerJoin Album innerJoin Artist)
                    .select { Track.id eq id }
                    .first()
        }

        return result;
    }
}