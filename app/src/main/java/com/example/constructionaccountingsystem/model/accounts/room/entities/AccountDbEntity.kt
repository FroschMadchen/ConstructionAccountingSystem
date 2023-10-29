package com.example.constructionaccountingsystem.model.accounts.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.constructionaccountingsystem.model.accounts.entities.Account
import com.example.constructionaccountingsystem.model.accounts.entities.SignUpData

@Entity(
    tableName = "accounts",
    indices = [
        Index("email", unique = true)
    ]
)
data class AccountDbEntity(
    @PrimaryKey(autoGenerate = true) val id:Long,
    @ColumnInfo(collate = ColumnInfo.NOCASE) val email:String,
    val username:String,
    val password:String,
    @ColumnInfo(name="create_at") val createdAt:String
) {

 /*   fun toAccount(): Account = Account(
        id=id,
        email= email,
        username = username,
        createdAt= createdAt
    )

    companion object {
        fun fromSignUpData(signUpData: SignUpData) = AccountDbEntity(
            id = 0, // SQLite generates identifier automatically if ID = 0
            email = signUpData.email,
            username = signUpData.username,
            password = signUpData.password,
            createdAt = System.currentTimeMillis()
        )
    }*/
}