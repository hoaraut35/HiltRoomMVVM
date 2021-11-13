package com.hoarauthomas.hiltwithroom.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel(

    @PrimaryKey(autoGenerate = true) val id : Int?=null,
    val name : String?=null
)