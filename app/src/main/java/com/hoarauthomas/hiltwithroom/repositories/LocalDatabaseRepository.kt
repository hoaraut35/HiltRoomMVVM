package com.hoarauthomas.hiltwithroom.repositories

import com.hoarauthomas.hiltwithroom.database.UserDao
import com.hoarauthomas.hiltwithroom.models.UserModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDatabaseRepository @Inject constructor(private val userDao: UserDao) {

    fun allUser() = userDao.getAll()

    fun insert(userModel: UserModel ){
        userDao.insert(userModel)
    }

}