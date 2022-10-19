package com.example.myapplication.data.local.table

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class PersonTable (@PrimaryKey (autoGenerate = true) val id:Int=0,
val name:String , val age:Int)
