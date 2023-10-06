package com.example.hirehub.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hirehub.daos.UserDao
import com.example.hirehub.models.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    // Abstracte functie om een UserDao-object te krijgen
    abstract fun userDao(): UserDao


    //Dit definieert een metgezel-object,
    // wat betekent dat het wordt gedeeld over alle instanties van UserDatabase.
    // Het wordt gebruikt om de database-instantie bij te houden zodat er slechts één instantie van de database wordt gemaakt.
    companion object {
        private var INSTANCE: UserDatabase? = null

        // Methode om een UserDatabase-object te verkrijgen
        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                // Database bouwen als deze nog niet is geïnstantieerd
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
