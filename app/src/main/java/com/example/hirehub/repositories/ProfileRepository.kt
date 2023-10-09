package com.example.hirehub.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.hirehub.daos.ProfileDao
import com.example.hirehub.models.Profile

class ProfileRepository (private val profileDao: ProfileDao) {

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
}
