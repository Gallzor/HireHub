package com.example.hirehub.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Transaction
import com.example.hirehub.daos.ProfileDao
import com.example.hirehub.databases.HireHubDatabase
import com.example.hirehub.models.Profile

/**
 * ProfileRepository fungeert als een abstractielaag tussen de ViewModel en de database (via ProfileDao).
 * Het beheert de gegevensstromen en bewerkingen voor profielgegevens.
 */
class ProfileRepository (private val profileDao: ProfileDao, private val database: HireHubDatabase) {

    // LiveData voor het observeren van de lijst met alle profielen
    val allProfiles: LiveData<List<Profile>> = profileDao.allProfiles()

    /**
     * Voegt een nieuw profiel toe aan de database.
     * @param profile Het profiel dat moet worden toegevoegd.
     */
    @WorkerThread
    fun insertProfile(profile: Profile) {
        profileDao.insertProfile(profile)
    }

    /**
     * Werkt de gegevens van een bestaand profiel bij in de database.
     * @param profile Het profiel met bijgewerkte gegevens.
     */
    @WorkerThread
    fun updateProfile(profile: Profile) {
        profileDao.updateProfile(profile)
    }

    /**
     * Verwijdert een profiel uit de database.
     * @param profile Het profiel dat moet worden verwijderd.
     */
    @WorkerThread
    fun deleteProfile(profile: Profile) {
        profileDao.deleteProfile(profile)
    }

    /**
     * Haal het profiel op op basis van de gebruikers-ID en observeer wijzigingen.
     * @param userId De ID van de gebruiker wiens profiel moet worden opgehaald.
     * @return LiveData met het profiel van de gebruiker of null als er geen overeenkomst is.
     */
    @WorkerThread
    fun getProfileByUserId(userId: Int): LiveData<Profile?> {
        return profileDao.getProfileByUserId(userId)
    }

    /**
     * Voeg meerdere profielen tegelijkertijd toe aan de database met behulp van een transactie.
     * @param profiles Een lijst van profielen om toe te voegen.
     */
    @Transaction
    fun addProfilesWithTransaction(profiles: List<Profile>) {
        database.profileDao().insertProfiles(profiles)
    }

    /**
     * Controleer of er al profielen in de database aanwezig zijn.
     * @return True als er profielen aanwezig zijn, anders False.
     */
    @WorkerThread
    fun profilesExist(): Boolean {
        // Voer een query uit om te controleren of er al profielen in de database zijn
        return profileDao.getProfilesCount() > 0
    }
}
