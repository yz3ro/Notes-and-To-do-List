package com.yz3ro.noteandto_dolist.di

import com.yz3ro.noteandto_dolist.data.datasource.MainDataSouce
import com.yz3ro.noteandto_dolist.data.repo.MainRepository
import com.yz3ro.noteandto_dolist.room.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideMainDataSource(): MainDataSouce {
        return MainDataSouce()
    }

    @Singleton
    @Provides
    fun provideMainRepository(mds : MainDataSouce) : MainRepository {
        return MainRepository(mds)
    }
}