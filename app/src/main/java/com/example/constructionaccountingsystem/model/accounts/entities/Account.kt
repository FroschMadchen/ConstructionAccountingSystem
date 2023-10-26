package com.example.constructionaccountingsystem.model.accounts.entities

data class Account(
    val id: Long,
    val email:String,
    val username: String,
    val createdAt: Long = UNKNOWN_CREATED_AT
) {
    companion object {
        const val UNKNOWN_CREATED_AT = 0L
    }
}
