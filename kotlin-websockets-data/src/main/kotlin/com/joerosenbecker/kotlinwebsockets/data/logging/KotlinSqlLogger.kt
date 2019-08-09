package com.joerosenbecker.kotlinwebsockets.data.logging

import mu.KotlinLogging
import org.jetbrains.exposed.sql.SqlLogger
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.statements.StatementContext
import org.jetbrains.exposed.sql.statements.expandArgs

class KotlinSqlLogger : SqlLogger {
    private val logger = KotlinLogging.logger { };
    override fun log(context: StatementContext, transaction: Transaction) {
        logger.info { "SQL: ${context.expandArgs(transaction)}" }
    }
}