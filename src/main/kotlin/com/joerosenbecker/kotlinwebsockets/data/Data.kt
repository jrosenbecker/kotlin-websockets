package com.joerosenbecker.kotlinwebsockets.data

import com.joerosenbecker.kotlinwebsockets.data.models.Album
import com.joerosenbecker.kotlinwebsockets.data.models.Artist
import com.joerosenbecker.kotlinwebsockets.data.models.Track
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class Data {
    private val jdbc = "jdbc:mysql://root:root@localhost:3306/music-store";
    private val driver = "com.mysql.cj.jdbc.Driver";

    private val connection = Database.connect(jdbc, driver);

    fun main() {
        transaction {
            println("Creating database tables")
            SchemaUtils.createMissingTablesAndColumns(Artist, Album, Track)

            println("Inserting records")
            val tomPettyId = Artist.insert {
                it[name] = "Tom Petty & The Heartbreakers"
            } get Artist.id

            val damnTheTorpedoesId = Album.insert {
                it[artistId] = tomPettyId
                it[name] = "Damn the Torpedoes"
            } get Album.id

            Track.insert {
                it[albumId] = damnTheTorpedoesId
                it[name] = "Refugee"
            }

            println("Completed")
        }
    }
}