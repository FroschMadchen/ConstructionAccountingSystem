package com.example.constructionaccountingsystem.model.room

import android.database.sqlite.SQLiteException
import com.example.constructionaccountingsystem.model.StorageException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext

/**
 * Converts any [SQLiteException] into in-app [StorageException]
 */
suspend fun <T> wrapSQLiteException(dispatcher: CoroutineDispatcher, block: suspend CoroutineScope.() -> T): T {
    try {
        return withContext(dispatcher, block)
    } catch (e: SQLiteException) {
        val appException = StorageException()
        appException.initCause(e)
        throw appException
    }
}