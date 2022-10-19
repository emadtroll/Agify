package com.example.myapplication.data.local.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.local.dao.Dao
import com.example.myapplication.data.local.table.PersonTable


@Database(entities = [PersonTable::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun daoInstance(): Dao
}