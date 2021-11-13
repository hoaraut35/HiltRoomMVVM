package com.hoarauthomas.hiltwithroom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hoarauthomas.hiltwithroom.models.UserModel
import com.hoarauthomas.hiltwithroom.module.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [UserModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    class Callback @Inject constructor(
        private val database: Provider<AppDatabase>,//provide instance of database
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {

        //load just once for init data
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().userDao()

            applicationScope.launch {
                dao.insert(UserModel(name = "nomA"))
                dao.insert(UserModel(name = "nomB"))
                dao.insert(UserModel(name = "nomC"))

            }

        }
    }


}