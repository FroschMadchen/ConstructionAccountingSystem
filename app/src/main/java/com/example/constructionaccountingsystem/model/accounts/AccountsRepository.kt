package com.example.constructionaccountingsystem.model.accounts

import com.example.constructionaccountingsystem.model.accounts.entities.Account
import com.example.constructionaccountingsystem.model.accounts.entities.SignUpData
import kotlinx.coroutines.flow.Flow

/**
 * Repository with account-related actions, e.g. sign-in, sign-up, edit account etc.
 */
interface AccountsRepository {

    /**
     * Whether user is signed-in or not.
     */
    suspend fun isSignedIn(): Boolean

    /**
     * Try to sign-in with the email and password.
     * @throws [EmptyFieldException]
     * @throws [AuthException]
     * @throws [StorageException]
     */
    suspend fun signIn(email: String, password: String)

    /**
     * Create a new account.
     * @throws [EmptyFieldException]
     * @throws [PasswordMismatchException]
     * @throws [AccountAlreadyExistsException]
     * @throws [StorageException]
     */
    suspend fun signUp(signUpData: SignUpData)

    /**
     * Sign-out from the app.
     */
    suspend fun logout()

    /**
     * Get the account info of the current signed-in user.
     */
    suspend fun getAccount(): Flow<Account?>

    /**
     * Change the username of the current signed-in user.
     * @throws [EmptyFieldException]
     * @throws [AuthException]
     * @throws [StorageException]
     */
    suspend fun updateAccountUsername(newUsername: String)

}