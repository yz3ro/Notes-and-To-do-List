package com.yz3ro.noteandto_dolist.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.yz3ro.noteandto_dolist.data.entity.Notes
import com.yz3ro.noteandto_dolist.data.entity.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    suspend fun allNotes() : List<Notes>
    @Insert
    suspend fun addNote(note : Notes)
    @Update
    suspend fun updateNote(note : Notes)
    @Delete
    suspend fun deleteNote(note : Notes)
}