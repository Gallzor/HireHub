package com.example.hirehub.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hirehub.daos.ProfileDao
import com.example.hirehub.daos.UserDao
import com.example.hirehub.models.Profile
import com.example.hirehub.models.User

@Database(entities = [User::class, Profile::class,], version = 1, exportSchema = false)
abstract class HireHubDatabase : RoomDatabase() {

    // Abstracte functies om de DAO-objecten te krijgen
    abstract fun userDao(): UserDao
    abstract fun profileDao(): ProfileDao

    companion object {
        private var INSTANCE: HireHubDatabase? = null

        // Methode om een AppDatabase-object te verkrijgen
        fun getDatabase(context: Context): HireHubDatabase {
            return INSTANCE ?: synchronized(this) {
                // Database bouwen als deze nog niet is geïnstantieerd
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HireHubDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
