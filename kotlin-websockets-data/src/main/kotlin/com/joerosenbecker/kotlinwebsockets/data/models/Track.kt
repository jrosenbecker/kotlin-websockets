package com.joerosenbecker.kotlinwebsockets.data.models

import org.jetbrains.exposed.sql.Table

object Track : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val albumId = integer("albumId").references(Album.id)
    val name = varchar("name", length = 500)
}