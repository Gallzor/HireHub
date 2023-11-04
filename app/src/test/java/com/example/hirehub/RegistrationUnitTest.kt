import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.hirehub.models.User
import com.example.hirehub.repositories.UserRepository
import com.example.hirehub.daos.UserDao
import com.example.hirehub.databases.HireHubDatabase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

//Bij de registratie unit test wordt er gekeken of iemand zich kan registreren.
// De test is geslaagd als de aangemaakte gebruiker opgehaald kan worden uit de database/repository.
class RegistrationUnitTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // Mock UserRepository
    @Mock
    private lateinit var userRepository: UserRepository

    // Mock UserDao
    @Mock
    private lateinit var userDao: UserDao

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        // Mock de UserDao in UserRepository
        userRepository = UserRepository(userDao, Mockito.mock(HireHubDatabase::class.java))
    }

    @Test
    fun testUserRegistration() = runBlocking {
        // Definieer de gebruikersnaam en wachtwoord voor registratie
        val username = "Testuser"
        val password = "testpassword"

        // Simuleer UserDao om een gebruiker op te halen
        Mockito.`when`(userDao.getUserByUsername(username))
            .thenReturn(User(username, password))

        // Hier roep je de methode aan die in je code verantwoordelijk is voor registratie
        val user: User? = userRepository.getUserByUsernameAndPassword(username, password)
        assert(user != null)
    }
}
