package com.hoarauthomas.hiltwithroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hoarauthomas.hiltwithroom.models.UserModel

@Database(entities = [UserModel::class], version = 3, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: com.hoarauthomas.hiltwithroom.database.Database? = null

        fun getDatabase(context: Context): com.hoarauthomas.hiltwithroom.database.Database {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    com.hoarauthomas.hiltwithroom.database.Database::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}