package com.example.constructionaccountingsystem.model.accounts

import com.example.constructionaccountingsystem.model.accounts.entities.Account
import com.example.constructionaccountingsystem.model.accounts.room.AccountsDataBase
import com.example.constructionaccountingsystem.model.accounts.room.entities.AccountDbEntity
import kotlinx.coroutines.flow.Flow

/**
 * Repository with account-related actions, e.g. sign-in, sign-up, edit account etc.
 */
class AccountsRepository(
    private val db:AccountsDataBase,
) {
    private val dao get() = db.accountsDao

    fun getAll():Flow<List<AccountDbEntity?>> = dao.getAll()
    fun getById(id:Long): AccountDbEntity = dao.getById(accountId =id )

//    suspend fun delete(account:AccountDbEntity) = dao.delete(account)

//    suspend fun createAccount(account: AccountDbEntity) = dao.createAccount(account)

}