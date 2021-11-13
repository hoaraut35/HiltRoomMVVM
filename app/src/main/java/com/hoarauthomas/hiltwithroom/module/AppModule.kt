package com.hoarauthomas.hiltwithroom.module

import android.content.Context
import androidx.room.Room
import com.hoarauthomas.hiltwithroom.database.AppDatabase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDao(db : AppDatabase) = db.userDao()

    //Provide database
    @Provides
    @Singleton  //to get just an instance
    fun provideDatabase(
        @ApplicationContext appContext: Context, //to get application context
        callBack: AppDatabase.Callback   //to add callback
    ) = Room.databaseBuilder(appContext, AppDatabase::class.java, "realEstateDBZ")
        .fallbackToDestructiveMigration()
        .addCallback(callBack)
        .build()


    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope