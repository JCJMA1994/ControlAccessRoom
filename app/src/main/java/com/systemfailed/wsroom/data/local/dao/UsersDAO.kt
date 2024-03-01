package com.systemfailed.wsroom.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.systemfailed.wsroom.data.local.model.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDAO {

    @Insert
    suspend fun saveUser(users: Users)

    @Update
    suspend fun updateUser(users: Users)

    @Delete
    suspend fun deleteUser(users: Users)

    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<Users>>

}