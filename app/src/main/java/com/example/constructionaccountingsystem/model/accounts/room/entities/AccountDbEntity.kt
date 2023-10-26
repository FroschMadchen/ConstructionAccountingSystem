package com.example.constructionaccountingsystem.model.accounts.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.constructionaccountingsystem.model.accounts.entities.Account
import com.example.constructionaccountingsystem.model.accounts.entities.SignUpData


// todo #5: Define AccountDbEntity.
//          - fields: id, email, username, password, createdAt.
//          - annotate class with @Entity annotation:
//            - use 'indices' parameter to add UNIQUE constraint for 'email' field;
//            - use 'tableName' to customize the table name for this entity;
//          - use @PrimaryKey annotation for the identifier field:
//            - use 'autoGenerate' parameter if you don't want to specify ID every time upon creating a new account;
//          - use @ColumnInfo(name='...') to customize column names and add additional
//            parameters (e.g. 'collate = ColumnInfo.NOCASE').
//          - add toAccount() method for mapping AccountDbEntity objects to Account objects.
//          - add companion object with fromSignUpData(signUpData: SignUpData) method for creating a new
//            instance of AccountDbEntity from SignUpData object.

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
    @ColumnInfo(name="create_at") val createdAt:Long
) {

    fun toAccount(): Account = Account(
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
    }
}