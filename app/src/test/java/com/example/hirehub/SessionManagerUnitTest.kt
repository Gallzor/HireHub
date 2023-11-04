package com.example.hirehub

import android.content.Context
import android.content.SharedPreferences
import androidx.test.core.app.ApplicationProvider
import com.example.hirehub.utils.SessionManager
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.RobolectricTestRunner

//Bij de sessionmanager unit test wordt er gekeken of de gegevens van een ingelogde gebruiker
// wordt opgeslagen, zodat dat elke pagina weet dat de gebruiker is ingelogd.
// De test is geslaagd als de ingevulde gegevens worden opgeslagen en hetzelfde zijn als de waardes aanwezig in de sessionmanager.
@RunWith(RobolectricTestRunner::class)
class SessionManagerUnitTest {

    private lateinit var context: Context
    private lateinit var sessionManager: SessionManager
    private lateinit var sharedPreferences: SharedPreferences

    @Before
    fun setUp() {
        // Verkrijg de applicatiecontext met behulp van Robolectric
        context = ApplicationProvider.getApplicationContext()

        // Verkrijg een instantie van de SharedPreferences voor deze test
        sharedPreferences = context.getSharedPreferences("user_session", Context.MODE_PRIVATE)

        // Initialiseer een nieuwe SessionManager met de applicatiecontext
        sessionManager = SessionManager(context)
    }

    @Test
    fun testSaveAndRetrieveUserDetails() {
        // Simuleer het opslaan van gebruikersgegevens in de SessionManager
        sessionManager.saveUserDetails(20, "Sol", "testuser", "password123")

        // Verifieer of de gebruikersgegevens correct zijn opgeslagen en opgehaald
        assertEquals(20, sessionManager.getUserId())  // Controleer of de gebruikers-ID overeenkomt
        assertEquals("Sol", sessionManager.getUserRole())  // Controleer of de gebruikersrol overeenkomt
        assertEquals("testuser", sessionManager.getUsername())  // Controleer of de gebruikersnaam overeenkomt
        assertEquals("password123", sessionManager.getPassword())  // Controleer of het wachtwoord overeenkomt
    }
}
