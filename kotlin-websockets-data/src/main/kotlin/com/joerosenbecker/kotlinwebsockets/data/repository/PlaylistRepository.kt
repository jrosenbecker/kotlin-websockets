package com.joerosenbecker.kotlinwebsockets.data.repository

import com.joerosenbecker.kotlinwebsockets.data.models.*
import org.jetbrains.exposed.sql.*
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

    fun addTracksToPlaylist(playlistId: Int, trackIds: List<Int>) {
        transaction {
            val largestSortOrderRecord = PlaylistTrack
                    .slice(PlaylistTrack.sortOrder.max())
                    .select {
                        PlaylistTrack.playlistId eq playlistId
                    }
                    .groupBy(PlaylistTrack.playlistId)
                    .first()

            var startingSortOrder: Int? = largestSortOrderRecord[PlaylistTrack.sortOrder.max()]
            if (startingSortOrder == null) {
                startingSortOrder = 0
            }

            trackIds.forEach { trackId ->
                PlaylistTrack.insert { item ->
                    item[PlaylistTrack.playlistId] = playlistId
                    item[PlaylistTrack.trackId] = trackId
                    item[sortOrder] = startingSortOrder
                }
                startingSortOrder++
            }
        }
    }
}