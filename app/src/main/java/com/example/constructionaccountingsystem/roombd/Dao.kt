package com.example.constructionaccountingsystem.roombd

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
 interface Dao {
     @Insert
     suspend fun insertItem ( dataEntity:DataEntity)
     @Delete
     suspend fun deleteItem ( dataEntity: DataEntity)

     @Query("SELECT * FROM name_table")
     fun getAllItems(): Flow<List<DataEntity>>

}