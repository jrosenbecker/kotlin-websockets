package com.joerosenbecker.kotlinwebsockets.data.repository

import com.joerosenbecker.kotlinwebsockets.data.models.*
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class PlaylistRepository : Repository() {
    fun getPlaylist(id: Int): MutableList<ResultRow> {
        var result: MutableList<ResultRow> = arrayListOf()
        transaction {
            result = (Playlist innerJoin PlaylistTrack innerJoin Track innerJoin Album innerJoin Artist)
                    .select { Playlist.id eq id }
                    .orderBy(PlaylistTrack.sortOrder)
                    .toMutableList()
        }

        return result;
    }
}