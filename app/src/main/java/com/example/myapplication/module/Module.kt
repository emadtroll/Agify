package com.example.myapplication.module

import androidx.room.Room
import com.example.myapplication.data.local.dao.Dao
import com.myworksamples.agify.data.remote.ApiService
import com.example.myapplication.repository.AgifyRepository
import com.example.myapplication.viewmodel.AgifyViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import android.content.Context
import com.example.myapplication.data.local.database.AppDatabase
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(SingletonComponent::class)
class Module {
    @Provides
    @Singleton
    fun retrofitService():Retrofit{
        return Retrofit.Builder().baseUrl("https://api.agify.io/?name=").addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun apiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)

    }

    @Provides
    @Singleton
    fun repositoryInstance(apiService: ApiService): AgifyRepository {
        return AgifyRepository( apiService)
    }

    @Provides
    @Singleton
    fun viewModelInstance(repository: AgifyRepository): AgifyViewModel {
        return AgifyViewModel( repository)
    }

    @Provides
    @Singleton
    fun daoInstance(@ApplicationContext context:Context): Dao {
         return Room.databaseBuilder(context, AppDatabase::class.java, "person_database")
            .allowMainThreadQueries().build().daoInstance()
    }


}