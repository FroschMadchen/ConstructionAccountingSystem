package com.example.constructionaccountingsystem.model.accounts.entities

import com.example.constructionaccountingsystem.model.EmptyFieldException
import com.example.constructionaccountingsystem.model.Field
import com.example.constructionaccountingsystem.model.PasswordMismatchException


/**
 * Fields that should be provided during creating a new account.
 */
data class SignUpData(
    val username: String,
    val email: String,
    val password: String,
    val repeatPassword: String
) {
    fun validate() {
        if (email.isBlank()) throw EmptyFieldException(Field.Email)
        if (username.isBlank()) throw EmptyFieldException(Field.Username)
        if (password.isBlank()) throw EmptyFieldException(Field.Password)
        if (password != repeatPassword) throw PasswordMismatchException()
    }
}