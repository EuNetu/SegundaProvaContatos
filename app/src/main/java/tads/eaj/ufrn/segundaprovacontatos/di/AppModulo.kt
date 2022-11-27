package tads.eaj.ufrn.segundaprovacontatos.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tads.eaj.ufrn.segundaprovacontatos.dao.ContactDao
import tads.eaj.ufrn.segundaprovacontatos.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getDatabase(applicationContext:Application):AppDatabase{
        return AppDatabase.invoke(applicationContext)
    }

    @Singleton
    @Provides
    fun getDao(database:AppDatabase):ContactDao{
        return database.contactDao()
    }
}