package tads.eaj.ufrn.segundaprovacontatos.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tads.eaj.ufrn.segundaprovacontatos.dao.ContactDao
import tads.eaj.ufrn.segundaprovacontatos.model.Contact

@Database(entities = [Contact::class], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao():ContactDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "contatos_database.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}