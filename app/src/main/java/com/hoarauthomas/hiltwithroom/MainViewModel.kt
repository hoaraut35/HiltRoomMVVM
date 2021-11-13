package com.hoarauthomas.hiltwithroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.hoarauthomas.hiltwithroom.repositories.LocalDatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val localDatabaseRepository: LocalDatabaseRepository):ViewModel() {

    var allUserModel = localDatabaseRepository.allUser().asLiveData()


}