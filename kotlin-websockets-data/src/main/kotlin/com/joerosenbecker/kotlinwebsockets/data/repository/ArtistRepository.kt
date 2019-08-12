package com.joerosenbecker.kotlinwebsockets.data.repository

import com.joerosenbecker.kotlinwebsockets.data.models.Artist
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Service

@Service
class ArtistRepository : Repository() {
    fun getAllArtists(): MutableList<ResultRow> {
        var results: MutableList<ResultRow> = arrayListOf();
        transaction {
            results = Artist.selectAll().toMutableList()
        }
        return results;
    }

    fun getArtist(id: Int): ResultRow? {
        var result: ResultRow? = null;
        transaction {
            result = Artist
                    .select { Artist.id eq id }
                    .firstOrNull()
        }
        return result;
    }
}