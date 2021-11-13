package com.hoarauthomas.hiltwithroom.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hoarauthomas.hiltwithroom.models.UserModel
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM UserModel")
    fun getAll(): Flow<List<UserModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userModel: UserModel)
}