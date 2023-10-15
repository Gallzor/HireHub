package com.example.hirehub.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.hirehub.models.Profile

@Dao
interface ProfileDao {
    // Haalt alle profielen op uit de database en geeft ze terug als LiveData
    @Query("SELECT * FROM profiles ORDER BY id ASC")
    fun allProfiles(): LiveData<List<Profile>>

    // Voegt een nieuwe profiel toe aan de database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(profile: Profile)

    // Werkt een bestaande profiel bij in de database
    @Update
    fun updateProfile(profile: Profile)

    // Verwijdert een profiel de database
    @Delete
    fun deleteProfile(profile: Profile)

    // Haalt data op voor de UserProfile
    @Query("SELECT * FROM profiles WHERE userId = :userId LIMIT 1")
    fun getProfileByUserId(userId: Int): LiveData<Profile?>
}
