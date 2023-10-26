package com.example.constructionaccountingsystem.model.dataProject.room.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "name_table")
data class DataProjectEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    val name:String,
    val image:Int,
    val leaderManager:String,
    val description:String,
    val statusCompleted:Boolean
)
