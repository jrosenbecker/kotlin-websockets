package com.joerosenbecker.kotlinwebsockets.data.repository

import com.joerosenbecker.kotlinwebsockets.data.models.Album
import com.joerosenbecker.kotlinwebsockets.data.models.Artist
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class AlbumRepository {
    fun getAllAlbums(): MutableList<ResultRow> {
        var results: MutableList<ResultRow> = arrayListOf();
        transaction {
            results = (Album innerJoin Artist).selectAll().toMutableList()
        }
        return results
    }

    fun getAlbum(id: Int): ResultRow? {
        var result: ResultRow? = null;
        transaction {
            result = (Album innerJoin Artist).select { Album.id eq id }.first()
        }
        return result;
    }
}