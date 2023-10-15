package com.example.hirehub.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @ColumnInfo(name = "username") var username: String,
    @ColumnInfo(name = "password") var password: String,
    @ColumnInfo(name = "userRole") var userRole: String = "Sol", //Standaard waarde, Sol staat voor Sollicitant.
    @ColumnInfo(name = "profileId") var userId: Int? = null,
    @PrimaryKey (autoGenerate = true) var id: Int = 0
)

