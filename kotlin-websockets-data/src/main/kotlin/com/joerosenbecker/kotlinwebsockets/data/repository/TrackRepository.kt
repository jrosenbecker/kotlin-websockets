package com.joerosenbecker.kotlinwebsockets.data.repository

import com.joerosenbecker.kotlinwebsockets.data.models.Album
import com.joerosenbecker.kotlinwebsockets.data.models.Artist
import com.joerosenbecker.kotlinwebsockets.data.models.Track
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class TrackRepository {
    private val jdbc = "jdbc:mysql://localhost:3306/music-store";
    private val driver = "com.mysql.cj.jdbc.Driver";

    private val connection = Database.connect(jdbc, driver = driver, user = "root", password = "superdupersecret");

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