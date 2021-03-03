package com.brian.remvp3.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brian.remvp3.data.Repository
import com.brian.remvp3.data.local.Property
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var _propertyList = MutableLiveData<List<Property>>()

    val propertyList: LiveData<List<Property>>
        get() = _propertyList

    fun getPropertyListLiveData() = propertyList

    fun saveData(address: String, numberOne: Int, numberTwo: Int) {
        val property = Property(address = address,numberOne = numberOne, numberTwo = numberTwo)
        viewModelScope.launch {
            repository.insert(property)
        }
    }

    fun getAll() {
        viewModelScope.launch {
            _propertyList.value = repository.getAll()
        }
    }
}