package com.example.hirehub.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class SessionManager(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val SHARED_PREF_NAME = "user_session"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_USER_ROLE = "userRole"
        private const val KEY_USERNAME = "username"
    }

    fun saveUserDetails(userId: Int, userRole: String, username: String) {
        sharedPreferences.edit().putInt(KEY_USER_ID, userId).apply()
        sharedPreferences.edit().putString(KEY_USER_ROLE, userRole).apply()
        sharedPreferences.edit().putString(KEY_USERNAME, username).apply()

        // Voeg een logboekverklaring toe om de opgeslagen gegevens te controleren
        Log.d("SessionManager", "User details saved: $userId, $userRole, $username")
    }

    fun getUserId(): Int {
        return sharedPreferences.getInt(KEY_USER_ID, -1) // -1 is een standaardwaarde als er geen ID is
    }

    fun getUserRole(): String? {
        return sharedPreferences.getString(KEY_USER_ROLE, null)
    }

    fun getUsername(): String? {
        return sharedPreferences.getString(KEY_USERNAME, null)
    }
}
