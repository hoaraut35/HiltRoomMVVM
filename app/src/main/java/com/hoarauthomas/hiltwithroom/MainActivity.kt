package com.hoarauthomas.hiltwithroom

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //viewmodel
    private val mainViewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //for test
        mainViewModel.allUserModel.observe(this){list ->
              Log.i("[THOMAS]","recup : ${list.size}")
        }

    }
}