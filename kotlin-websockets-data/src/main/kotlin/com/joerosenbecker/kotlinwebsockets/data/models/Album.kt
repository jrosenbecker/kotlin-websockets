package com.joerosenbecker.kotlinwebsockets.data.models

import org.jetbrains.exposed.sql.Table

object Album : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val artistId = integer("artistId").references(Artist.id)
    val name = varchar("name", length = 500);
}