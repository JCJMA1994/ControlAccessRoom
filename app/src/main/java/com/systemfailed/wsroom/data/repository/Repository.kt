package com.systemfailed.wsroom.data.repository

import com.systemfailed.wsroom.data.local.dao.UsersDAO
import com.systemfailed.wsroom.data.local.model.Users
import kotlinx.coroutines.flow.Flow

class Repository(private val usersDAO: UsersDAO) {

    suspend fun insertUser(users: Users) {
        usersDAO.saveUser(users)
    }

    suspend fun updateUser(users: Users) {
        usersDAO.updateUser(users)
    }

    suspend fun deleteUser(users: Users) {
        usersDAO.deleteUser(users)
    }

    suspend fun getAllUsers(): Flow<List<Users>> = usersDAO.getUsers()

}