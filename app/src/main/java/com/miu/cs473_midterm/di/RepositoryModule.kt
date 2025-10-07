package com.miu.cs473_midterm.di

import android.util.Log
import com.miu.cs473_midterm.data.ExpRepository
import com.miu.cs473_midterm.data.ExpRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
//    @Singleton
    fun provideAlphabetRepository(): ExpRepository {
        Log.d("RepsitoryModule", "provideExpRepository")
        return ExpRepositoryImp()
    }
}