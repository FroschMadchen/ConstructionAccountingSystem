package com.example.constructionaccountingsystem.model.dataProject.room

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.constructionaccountingsystem.model.dataProject.room.entites.DataProjectEntity

@Database(
    entities = [
        DataProjectEntity::class
    ], version = 1
)
abstract class DataBase:RoomDatabase(){
    abstract val dao:Dao
    companion object {
        fun createDataBase(context:Context): DataBase { //инстанцирование бд
            return Room.databaseBuilder(
                context,
                DataBase::class.java,
                name = "test.db"
            ).build()
        }
    }
}