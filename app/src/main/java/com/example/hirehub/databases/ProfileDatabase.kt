import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hirehub.daos.ProfileDao
import com.example.hirehub.models.Profile

@Database(entities = [Profile::class], version = 1)
abstract class ProfileDatabase : RoomDatabase() {

    // Abstracte functie om een ProfileDao-object te krijgen
    abstract fun profileDao(): ProfileDao

    companion object {
        private var INSTANCE: ProfileDatabase? = null

        // Methode om een ProfileDatabase-object te verkrijgen
        fun getDatabase(context: Context): ProfileDatabase {
            return INSTANCE ?: synchronized(this) {
                // Database bouwen als deze nog niet is geïnstantieerd
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProfileDatabase::class.java,
                    "profile_database"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
