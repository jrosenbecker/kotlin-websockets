package com.joerosenbecker.kotlinwebsockets.data.models

import org.jetbrains.exposed.sql.Table

object PlaylistTrack : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val playlistId = integer("playlistId").references(Playlist.id);
    val trackId = integer("trackId").references(Track.id);
    val sortOrder = integer("sortOrder")
}