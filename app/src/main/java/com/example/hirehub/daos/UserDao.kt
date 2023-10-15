package com.example.hirehub.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hirehub.models.User

@Dao
interface UserDao {
    // Haalt alle gebruikers op uit de database en geeft ze terug als LiveData
    @Query("SELECT * FROM users ORDER BY id ASC")
    fun allUsers(): LiveData<List<User>>

    // Voegt een nieuwe gebruiker toe aan de database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    // Werkt een bestaande gebruiker bij in de database
    @Update
    fun updateUser(user: User)

    // Verwijdert een gebruiker uit de database
    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM users WHERE username = :username")
    fun getUserByUsername(username: String): User?

}
