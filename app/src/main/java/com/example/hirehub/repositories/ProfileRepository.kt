package com.example.hirehub.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Transaction
import com.example.hirehub.daos.ProfileDao
import com.example.hirehub.databases.HireHubDatabase
import com.example.hirehub.models.Profile

class ProfileRepository (private val profileDao: ProfileDao, private val database: HireHubDatabase) {

    // LiveData voor het observeren van de lijst met alle profielen
    val allProfiles: LiveData<List<Profile>> = profileDao.allProfiles()

    /**
     * Voegt een nieuw profiel toe aan de database.
     * @param profile Het profiel die moet worden toegevoegd.
     */
    @WorkerThread
    //Dit is een annotatie die aangeeft dat de annotatie ervoor zorgt dat de functies die worden aangeroepen, uitgevoerd worden op een aparte achtergrondthread (niet op de main/UI-thread).
    // Dit is belangrijk om te voorkomen dat de UI bevriest of vertraagt bij zware taken.
    fun insertProfile(profile: Profile) {
        profileDao.insertProfile(profile)
    }

    /**
     * Werkt de gegevens van een bestaande profiel bij in de database.
     * @param profile Het profiel met bijgewerkte gegevens.
     */
    @WorkerThread
    fun updateProfile(profile: Profile) {
        profileDao.updateProfile(profile)
    }

    /**
     * Verwijdert een profiel uit de database.
     * @param profile Het profiel die moet worden verwijderd.
     */
    @WorkerThread
    fun deleteProfile(profile: Profile) {
        profileDao.deleteProfile(profile)
    }
    @WorkerThread
    fun getProfileByUserId(userId: Int): LiveData<Profile?> {
        return profileDao.getProfileByUserId(userId)
    }

    @Transaction
    fun addProfilesWithTransaction(profiles: List<Profile>) {
        database.profileDao().insertProfiles(profiles)
    }

    @WorkerThread
    fun profilesExist(): Boolean {
        // Voer een query uit om te controleren of er al profielen in de database zijn
        return profileDao.getProfilesCount() > 0
    }

}
