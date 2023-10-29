package com.example.constructionaccountingsystem.presentation

import android.app.Application
import android.content.Context
import com.example.constructionaccountingsystem.locator.ServiceLocator
import com.example.constructionaccountingsystem.locator.locate
import com.example.constructionaccountingsystem.model.accounts.AccountsRepository
import com.example.constructionaccountingsystem.model.accounts.room.AccountsDataBase

import com.example.constructionaccountingsystem.model.accounts.room.AccountsDatabaseImpl


class App: Application() {

    override fun onCreate() {
        super.onCreate()

        ServiceLocator.register<Context>(this)
        ServiceLocator.register<AccountsDataBase>(AccountsDatabaseImpl.create(locate()))
        ServiceLocator.register(AccountsRepository(locate()))
    }
}

