package com.example.hirehub.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hirehub.models.Profile
import com.example.hirehub.models.User
import com.example.hirehub.repositories.ProfileRepository
import kotlinx.coroutines.Dispatchers
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
}
