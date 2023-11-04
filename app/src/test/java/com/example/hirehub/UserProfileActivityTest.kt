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
        MockitoAnnotations.initMocks(this)
        viewModel = ProfileViewModel(repository)
    }

    @Test
    fun testInsertProfile() {
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

        // Maak een LiveData-object van testProfile
        val liveDataTestProfile = MutableLiveData<Profile?>()
        liveDataTestProfile.value = testProfile

        // Stub de repository om een niet-null waarde terug te geven voor de opgegeven gebruikers-ID
        Mockito.`when`(repository.getProfileByUserId(1)).thenReturn(liveDataTestProfile)

        viewModel.addProfile(testProfile)

        // Hier kun je een observer toevoegen om te controleren of het profiel is toegevoegd
        val observer: Observer<Profile?> = Observer { profile ->
            // Controleer of de waarden van het waargenomen profiel overeenkomen met de verwachte waarden
            assertEquals(testProfile, profile)
        }
        viewModel.getProfileByUserId(1).observeForever(observer)
    }
}
