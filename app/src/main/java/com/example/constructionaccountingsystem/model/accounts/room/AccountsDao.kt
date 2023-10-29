package com.example.constructionaccountingsystem.model.accounts.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.constructionaccountingsystem.model.accounts.room.entities.AccountDbEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface AccountsDao {
/*
    @Query("SELECT id, password FROM accounts WHERE email = :email")
    suspend fun findByEmail(email: String): AccountSignInTuple?
*/

/*
    @Update(entity = AccountDbEntity::class)
    suspend fun updateUsername(account: AccountUpdateUsernameTuple)
*/

/*    @Insert(onConflict = OnConflictStrategy.REPLACE ) //создание
    suspend fun createAccount(accountDbEntity: AccountDbEntity)*/

    @Query("SELECT * FROM accounts WHERE id = :accountId") // получение по id
     fun getById(accountId: Long): AccountDbEntity

    @Query("SELECT * FROM accounts") // получить всё
    fun getAll(): Flow<List<AccountDbEntity?>>
//    @Delete
//    suspend fun delete(account: AccountDbEntity)
}