package com.hoarauthomas.hiltwithroom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.hoarauthomas.hiltwithroom.database.Database
import com.hoarauthomas.hiltwithroom.models.UserModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val db = Room.databaseBuilder(
            applicationContext,
            Database::class.java, "test-usera"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        val userDao = db.userDao()

         val userModels : List<UserModel> = userDao.getAll()

        // val user : User
          userDao.insert(UserModel(name = "tst"))


    }
}