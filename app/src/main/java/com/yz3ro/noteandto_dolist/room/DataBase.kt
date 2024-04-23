package com.yz3ro.noteandto_dolist.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yz3ro.noteandto_dolist.data.entity.Notes
import com.yz3ro.noteandto_dolist.data.entity.Todo


@Database(entities = [Notes::class,Todo::class] ,version = 1)
abstract class DataBase : RoomDatabase(){
    abstract fun getNoteDao() : NoteDao
    abstract fun getTodoDao() : TodoDao

    companion object{
        var INSTANCE : DataBase? = null
        fun accessDatabase(context: Context) : DataBase? {
            if(INSTANCE== null){
                synchronized(DataBase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        DataBase::class.java,
                        "notetodo.sqlite")
                        .createFromAsset("notetodo.sqlite")
                        .build()
                }
            }
            return INSTANCE
        }
    }
}