package com.joerosenbecker.kotlinwebsockets.seed

import com.joerosenbecker.kotlinwebsockets.data.models.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class SeedRunner

private val jdbc = "jdbc:mysql://localhost:3306/music-store";
private val driver = "com.mysql.cj.jdbc.Driver";

private val connection = Database.connect(jdbc, driver = driver, user = "root", password = "superdupersecret");

fun main(args: Array<String>) {
    transaction {
        PlaylistTrack.deleteAll()
        Playlist.deleteAll()
        Track.deleteAll()
        Album.deleteAll()
        Artist.deleteAll()


        val tomPettyId = Artist.insert {
            it[id] = 1
            it[name] = "Tom Petty & The Heartbreakers"
        } get Artist.id

        val damnTheTorpedoesId = Album.insert {
            it[id] = 1
            it[artistId] = tomPettyId
            it[name] = "Damn the Torpedoes"
        } get Album.id

        val refugeeTrackId = Track.insert {
            it[id] = 1
            it[albumId] = damnTheTorpedoesId
            it[name] = "Refugee"
        } get Track.id

        val evenTheLosersTrackId = Track.insert {
            it[id] = 2
            it[albumId] = damnTheTorpedoesId
            it[name] = "Even the Losers"
        } get Track.id

        val tomPettyPlaylistId = Playlist.insert {
            it[id] = 1
            it[name] = "Tom Petty Playlist"
        } get Playlist.id

        addTracksToPlaylist(tomPettyPlaylistId, arrayListOf(evenTheLosersTrackId, refugeeTrackId))

        val jimiHendrixId = Artist.insert {
            it[id] = 2
            it[name] = "Jimi Hendrix"
        } get Artist.id

        val areYouExperiencedId = Album.insert {
            it[id] = 2
            it[name] = "Are You Experienced"
            it[artistId] = jimiHendrixId
        } get Album.id

        val purpleHazeTrackId = Track.insert {
            it[id] = 3
            it[name] = "Purple Haze"
            it[albumId] = areYouExperiencedId
        } get Track.id

        val heyJoeTrackId = Track.insert {
            it[id] = 4
            it[name] = "Hey Joe"
            it[albumId] = areYouExperiencedId
        } get Track.id

        val classicRockPlaylistId = Playlist.insert {
            it[id] = 2
            it[name] = "Classic Rock"
        } get Playlist.id

        addTracksToPlaylist(classicRockPlaylistId, arrayListOf(refugeeTrackId, heyJoeTrackId, purpleHazeTrackId, evenTheLosersTrackId))
    }
}

fun addTracksToPlaylist(playlistIdValue: Int, trackIds: List<Int>) {
    var incrementingSortOrder = 0;
    trackIds.forEach { trackIdValue ->
        PlaylistTrack.insert {
            it[playlistId] = playlistIdValue
            it[trackId] = trackIdValue
            it[sortOrder] = incrementingSortOrder++
        }
    }
}