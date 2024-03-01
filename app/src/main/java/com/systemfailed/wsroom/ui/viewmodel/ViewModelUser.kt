package com.systemfailed.wsroom.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.systemfailed.wsroom.data.local.model.Users
import com.systemfailed.wsroom.data.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelUser(private val repository: Repository) : ViewModel() {

    private var user = MutableStateFlow(Users(0, "", "", "", "", ""))
    val _user: StateFlow<Users> = user.asStateFlow()

    fun setUser(users: Users) {
        user.value = users
    }

    suspend fun saveUser(users: Users) {
        repository.insertUser(users)
    }

    suspend fun updateUser(users: Users) {
        repository.updateUser(users)
    }

    suspend fun deleteUser(users: Users) {
        repository.deleteUser(users)
    }

    suspend fun getAllUsers() = repository.getAllUsers()

}