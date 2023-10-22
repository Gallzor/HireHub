package com.example.hirehub.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hirehub.models.Profile
import com.example.hirehub.repositories.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: ProfileRepository): ViewModel() {
    // LiveData voor het observeren van de lijst met profielen
    var profiles: LiveData<List<Profile>> = repository.allProfiles

    // Functie om een nieuw profiel toe te voegen aan de database
    fun addProfile(newProfile: Profile) {
        // Coroutine starten op IO-thread voor asynchrone databasebewerking
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertProfile(newProfile)
        }
    }

    // Functie om het profiel van de huidige ingelogde gebruiker op te halen
    fun getProfileByUserId(userId: Int): LiveData<Profile?> {
        return repository.getProfileByUserId(userId)
    }


    // Functie om een bestaande profiel bij te werken in de database
    fun updateProfile(profile: Profile) {
        // Coroutine starten op IO-thread voor asynchrone databasebewerking
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateProfile(profile)
        }
    }

    //     Functie om een profiel te verwijderen uit de database
    fun deleteProfile(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteProfile(profile)
        }
    }

    //  Functie om de zichtbaarheid van een profiel in de profileboard te veranderen
    fun toggleProfileVisibility(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO) {
            profile.isVisible = !profile.isVisible
            repository.updateProfile(profile)
        }
    }

    // Functie om de database te vullen met profielgegevens
    fun seedProfileDatabase() {
        GlobalScope.launch(Dispatchers.IO) {
            val profileRepository = repository

            // Lijst van profielen om toe te voegen
            val profilesToAdd = listOf(
                Profile(
                    "Henk", "Ruiter", "Amsterdam", "henk@henk.nl", "34",
                    "Python", "HBO Software Engineer", "7356234132", 1, true, 1
                ),
                Profile(
                    "Lisanne", "Withuis", "Almere", "lisanne@lisanne.nl", "21",
                    "C# en C++", "AD Software Developer", "123456789", 2, false, 2
                ),
                Profile(
                    "Willem", "Bosch", "Zwolle", "willem@willem.nl", "34",
                    "HTML", "HBO Social Work", "3459324823", 3, false, 3
                ),
                Profile(
                    "Anita", "Koning", "Groningen", "anita@anita.nl", "55",
                    "CSS", "HBO Computer Science", "734563214", 4, true, 4
                ),
                Profile(
                    "Hanneke", "Greta", "Leeuwarden", "hanneke@hanneke.nl", "23",
                    "Kotlin", "HBO Accountancy", "723672342", 5, true, 5
                ),
                Profile(
                    "Pieter", "Akkerman", "Limburg", "pieter@pieter.nl", "41",
                    "Excel", "HBO Business", "635458765", 6, true, 6
                ),
                Profile(
                    "Lisa", "Geelwante", "Rotterdam", "lisa@lisa.nl", "28",
                    "PowerPoint", "HBO Engineering", "1234568345", 7, true, 7
                ),
                Profile(
                    "Hyde", "Ziani", "Purmerend", "hyde@hyde.nl", "19",
                    "Photoshop", "HBO Communication & Media", "1623456345", 8, true, 8
                ),
                Profile(
                    "Imane", "Daoudi", "Utrecht", "imane@imane.nl", "31",
                    "Math", "HBO Civil Rights", "2345673421", 9, true, 9
                ),
            )
            profileRepository?.addProfilesWithTransaction(profilesToAdd)
        }
    }
    fun profilesExist(): Boolean {
        return repository.profilesExist()
    }
}