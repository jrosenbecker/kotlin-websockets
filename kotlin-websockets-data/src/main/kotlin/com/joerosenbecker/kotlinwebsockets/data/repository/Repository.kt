package com.joerosenbecker.kotlinwebsockets.data.repository

import org.jetbrains.exposed.sql.Database
import org.springframework.beans.factory.annotation.Autowired

abstract class Repository {
    init {
        val jdbc = "jdbc:mysql://localhost:3306/music-store"
        val driver = "com.mysql.cj.jdbc.Driver"
        Database.connect(jdbc, driver = driver, user = "root", password = "superdupersecret")
    }
}