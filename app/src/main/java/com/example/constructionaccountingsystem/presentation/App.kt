package com.example.constructionaccountingsystem.presentation

import android.app.Application
import com.example.constructionaccountingsystem.model.dataProject.room.DataBase

class App: Application() {
    val database by lazy { DataBase.createDataBase(this)}
/*если инстанции нет то будет
создано, если есть выдаст готовую инстанцию*/
}