package com.joerosenbecker.kotlinwebsockets.data.models

import org.jetbrains.exposed.sql.Table

object Playlist : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val name = varchar("name", length = 500)
}