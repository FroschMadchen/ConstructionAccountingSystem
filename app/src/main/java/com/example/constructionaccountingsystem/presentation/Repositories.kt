package com.example.constructionaccountingsystem.presentation

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.constructionaccountingsystem.model.accounts.AccountsRepository
import com.example.constructionaccountingsystem.model.accounts.room.RoomAccountsRepository
import com.example.constructionaccountingsystem.model.room.AppDatabase
import com.example.constructionaccountingsystem.model.settings.AppSettings
import com.example.constructionaccountingsystem.model.settings.SharedPreferencesAppSettings
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object Repositories {

    private lateinit var applicationContext: Context

    // -- stuffs

    private val database: AppDatabase by lazy<AppDatabase> {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java,"database.db").build()
    }

    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

    private val appSettings: AppSettings by lazy {
        SharedPreferencesAppSettings(applicationContext)
    }

    // --- repositories

  /*  val accountsRepository: AccountsRepository by lazy {
        RoomAccountsRepository
    }*/

    /**
     * Call this method in all application components that may be created at app startup/restoring
     * (e.g. in onCreate of activities and services)
     */
    fun init(context: Context) {
        applicationContext = context
    }
}

