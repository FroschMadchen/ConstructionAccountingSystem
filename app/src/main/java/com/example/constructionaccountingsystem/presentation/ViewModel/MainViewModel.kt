package com.example.constructionaccountingsystem.presentation.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.text.format.DateFormat
import androidx.lifecycle.viewModelScope
import com.example.constructionaccountingsystem.locator.locateLazy
import com.example.constructionaccountingsystem.model.accounts.AccountsRepository
import com.example.constructionaccountingsystem.model.accounts.entities.Account
import com.example.constructionaccountingsystem.model.accounts.room.entities.AccountDbEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import java.util.Date

class MainViewModel : ViewModel() {

    private val repository: AccountsRepository by locateLazy()


    val notes = repository.getAll().asLiveDataFlow()
    val newCaption = flow<String> {
        while (true) {
            emit(createCaption())
            delay(500L)
        }
    }

/*    fun saveAccount(account: AccountDbEntity) {
        viewModelScope.launch { repository.createAccount(account =account ) }
    }*/

 /*  fun delete(account: AccountDbEntity) {
        viewModelScope.launch { repository.delete(account) }
    }*/

    private fun createAccount(account: AccountDbEntity) = AccountDbEntity(
        id = account.id,
        email = account.email,
        username = account.username,
        password = account.password,
        createdAt = createCaption()
    )

    private fun createCaption(): String =
        DateFormat.format("hh:mm:ss, MMM dd, yyyy", Date()).toString()
    private fun <T> Flow<T>.asLiveDataFlow() =
        shareIn(viewModelScope, SharingStarted.Eagerly, replay = 1)
}
