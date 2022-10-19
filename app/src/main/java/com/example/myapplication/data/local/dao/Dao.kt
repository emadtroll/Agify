package com.example.myapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.local.table.PersonTable

@Dao
interface Dao {
    @Insert
    fun addName(person: PersonTable)

    @Query("SELECT * FROM person_table")
    fun getInformation():List<PersonTable>

}