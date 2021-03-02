package com.brian.remvp3.ui

import androidx.lifecycle.ViewModel
import com.brian.remvp3.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(repository: Repository) : ViewModel() {

    fun saveData(){

    }
}