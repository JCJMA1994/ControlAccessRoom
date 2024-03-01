package com.systemfailed.wsroom.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.systemfailed.wsroom.data.local.dao.UsersDAO
import com.systemfailed.wsroom.data.local.model.Users

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class DBRoom : RoomDatabase() {

    abstract fun usersDAO(): UsersDAO

    companion object {
        @Volatile
        private var INSTANCE: DBRoom? = null

        fun getInstance(context: Context): DBRoom {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DBRoom::class.java,
                    "room_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}