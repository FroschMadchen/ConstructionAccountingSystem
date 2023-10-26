package com.example.constructionaccountingsystem.model.accounts.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.constructionaccountingsystem.model.accounts.room.entities.AccountDbEntity
import com.example.constructionaccountingsystem.model.accounts.room.entities.AccountSignInTuple
import com.example.constructionaccountingsystem.model.accounts.room.entities.AccountUpdateUsernameTuple
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountsDao {
    @Query("SELECT id, password FROM accounts WHERE email = :email")
    suspend fun findByEmail(email: String): AccountSignInTuple?

    @Update(entity = AccountDbEntity::class)
    suspend fun updateUsername(account: AccountUpdateUsernameTuple)

    @Insert(entity = AccountDbEntity::class)
    suspend fun createAccount(accountDbEntity: AccountDbEntity)

    @Query("SELECT * FROM accounts WHERE id = :accountId")
    fun getById(accountId: Long): Flow<AccountDbEntity?>
}