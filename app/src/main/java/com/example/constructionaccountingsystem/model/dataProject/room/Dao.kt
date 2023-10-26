package com.example.constructionaccountingsystem.model.dataProject.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.constructionaccountingsystem.model.dataProject.room.entites.DataProjectEntity
import kotlinx.coroutines.flow.Flow


@Dao
 interface Dao {
     @Insert
     suspend fun insertItem (dataProjectEntity: DataProjectEntity)
     @Delete
     suspend fun deleteItem (dataProjectEntity: DataProjectEntity)

     @Query("SELECT * FROM name_table")
     fun getAllItems(): Flow<List<DataProjectEntity>>

}