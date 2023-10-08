package com.example.hirehub.models

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profiles")
data class Profile(
    @ColumnInfo(name = "firstName") var firstname: String,
    @ColumnInfo(name = "lastName") var lastname: String,
    @ColumnInfo(name = "city") var city: String? = null,
    @ColumnInfo(name = "email") var email: String? = null,
    @ColumnInfo(name = "age") var age: String? = null,
    @ColumnInfo(name = "skillOne") var skillOne: String? = null,
    @ColumnInfo(name = "certificate") var certificate: String? = null,
    @ColumnInfo(name = "mobileNumber") var mobileNumber: String? = null,
    @ColumnInfo(name = "userId") var userId: Int? = null,
    @ColumnInfo(name = "isVisible") var isVisible: Boolean = true,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
