package com.myworksamples.agify.data.remote

import com.example.myapplication.model.PersonModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(".")
    fun getAge(@Query("name")name:String): Call<PersonModel>


}