package com.example.constructionaccountingsystem.model.accounts.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.constructionaccountingsystem.model.accounts.room.entities.AccountDbEntity

@Database(
    entities =[
        AccountDbEntity::class
    ], version = 1
)
abstract class AccountsDatabaseImpl:RoomDatabase(),AccountsDataBase {
//    abstract val accountDao:AccountsDao

    companion object {
        fun create(context: Context) = Room.databaseBuilder(
            context,
            AccountsDatabaseImpl::class.java,
            "accounts_database"
        ).build()
    }
}


