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
interface TodoDao {
    @Query("SELECT * FROM todos")
    suspend fun allTodo() : List<Todo>
    @Insert
    suspend fun addTodo(todo : Todo)
    @Update
    suspend fun updateTodo(todo : Todo)
    @Delete
    suspend fun deleteTodo(todo : Todo)
}