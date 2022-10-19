package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.PersonModel
import com.example.myapplication.repository.AgifyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgifyViewModel @Inject constructor(val repository: AgifyRepository) : ViewModel() {

    var info = MutableLiveData<PersonModel>()

    fun getData(str:String):MutableLiveData<PersonModel> {
        info=repository.getAge(str)
        return info

    }
}