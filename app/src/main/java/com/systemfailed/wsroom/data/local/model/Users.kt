package com.systemfailed.wsroom.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class Users(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "lastname") var lastName: String,
    @ColumnInfo(name = "dni") var dni: String,
    @ColumnInfo(name = "username") var username: String,
    @ColumnInfo(name = "password") var password: String
)
