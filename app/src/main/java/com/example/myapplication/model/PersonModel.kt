package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

data class PersonModel(@SerializedName("age") val age:Int,
                       @SerializedName("count")val count:Long,
                       @SerializedName("name") val name:String)
