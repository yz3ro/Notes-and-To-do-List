package com.yz3ro.noteandto_dolist.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.yz3ro.noteandto_dolist.data.datasource.MainDataSouce
import com.yz3ro.noteandto_dolist.data.repo.MainRepository
import com.yz3ro.noteandto_dolist.room.DataBase
import com.yz3ro.noteandto_dolist.room.NoteDao
import com.yz3ro.noteandto_dolist.room.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideMainDataSource(noteDao: NoteDao,todoDao: TodoDao): MainDataSouce {
        return MainDataSouce(noteDao,todoDao)
    }

    @Singleton
    @Provides
    fun provideMainRepository(mds : MainDataSouce) : MainRepository {
        return MainRepository(mds)
    }
    @Singleton
    @Provides
    fun provideNoteDao(@ApplicationContext context: Context) : NoteDao {
        val db = Room.databaseBuilder(context, DataBase::class.java,"notetodo.sqlite")
            .createFromAsset("notetodo.sqlite").build()
        return db.getNoteDao()
    }
    @Singleton
    @Provides
    fun provideTodoDao(@ApplicationContext context: Context) : TodoDao {
        val db = Room.databaseBuilder(context, DataBase::class.java,"notetodo.sqlite")
            .createFromAsset("notetodo.sqlite").build()
        return db.getTodoDao()
    }
}