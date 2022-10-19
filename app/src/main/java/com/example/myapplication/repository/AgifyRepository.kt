package com.example.myapplication.repository

import androidx.lifecycle.MutableLiveData
import com.myworksamples.agify.data.remote.ApiService
import com.example.myapplication.model.PersonModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class AgifyRepository @Inject  constructor(val apiService: ApiService){
    var result=MutableLiveData<PersonModel>()








     fun getAge(str:String): MutableLiveData<PersonModel> {

        val response=apiService.getAge(str)
        response.enqueue(object: retrofit2.Callback<PersonModel>{
            override fun onResponse(call: Call<PersonModel>, response: Response<PersonModel>) {
                if (response.isSuccessful)
                    result.value=response.body()

            }

            override fun onFailure(call: Call<PersonModel>, t: Throwable) {

            }

        })
        return result

    }

}