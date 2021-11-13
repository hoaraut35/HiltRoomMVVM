package com.hoarauthomas.hiltwithroom.module

import android.content.Context
import androidx.room.Room
import com.hoarauthomas.hiltwithroom.database.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDao(db : Database) = db.userDao()

    @Provides
    fun provideDatabase(
        @ApplicationContext appContext : Context
    ) = Room.databaseBuilder(appContext,
    Database::class.java,
    "testdb")
        .fallbackToDestructiveMigration()
        .build()


    @ApplicationScope
    @Provides
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope