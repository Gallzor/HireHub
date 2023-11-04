package com.example.hirehub

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.hirehub.models.Profile
import com.example.hirehub.repositories.ProfileRepository
import com.example.hirehub.viewmodels.ProfileViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class ProfileViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: ProfileRepository

    private lateinit var viewModel: ProfileViewModel

    @Before
    fun setUp() {
        // Initialiseer Mockito annotaties en bereid de viewModel voor op testen
        MockitoAnnotations.initMocks(this)
        viewModel = ProfileViewModel(repository)
    }

    @Test
    fun testInsertProfile() {
        // Maak een testprofiel aan met voorbeeldgegevens
        val testProfile = Profile(
            "John",
            "Doe",
            "New York",
            "john@example.com",
            "30",
            "Java",
            "Bachelor of Computer Science",
            "1234567890",
            1,
            true,
            1
        )

        // Maak een MutableLiveData-object van testProfile en wijs het testProfiel toe aan de waarde
        val liveDataTestProfile = MutableLiveData<Profile?>()
        liveDataTestProfile.value = testProfile

        // Stel de repository in op een niet-null waarde retourneren voor het opgegeven gebruikers-ID
        Mockito.`when`(repository.getProfileByUserId(1)).thenReturn(liveDataTestProfile)

        // Roep de methode aan om het testprofiel toe te voegen aan de ViewModel
        viewModel.addProfile(testProfile)

        // Voeg een observer toe om te controleren of het profiel is toegevoegd aan LiveData
        val observer: Observer<Profile?> = Observer { profile ->
            // Controleer of de waarden van het waargenomen profiel overeenkomen met de verwachte waarden
            assertEquals(testProfile, profile)
        }

        // Laat de observer luisteren naar wijzigingen in LiveData
        viewModel.getProfileByUserId(1).observeForever(observer)
    }
}
