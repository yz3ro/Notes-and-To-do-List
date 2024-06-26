package com.yz3ro.noteandto_dolist.data.datasource

import com.yz3ro.noteandto_dolist.data.entity.Notes
import com.yz3ro.noteandto_dolist.data.entity.Todo
import com.yz3ro.noteandto_dolist.room.NoteDao
import com.yz3ro.noteandto_dolist.room.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainDataSource (var ndao : NoteDao,var tdao : TodoDao) {
    suspend fun getNotes() : List<Notes> =
        withContext(Dispatchers.IO){
            return@withContext ndao.allNotes()
        }
    suspend fun addNote(note_title : String,note : String) {
        val newNote = Notes(0,note,note_title)
        ndao.addNote(newNote)
    }
    suspend fun deleteNote(note_id:Int){
        val deletedNote = Notes(note_id,"","")
        ndao.deleteNote(deletedNote)
    }
    suspend fun updateNote(note_id:Int,note_title: String,note: String){
        val updatedNote = Notes(note_id,note_title,note)
        ndao.updateNote(updatedNote)
    }

    suspend fun getTodo() : List<Todo> =
        withContext(Dispatchers.IO){
            return@withContext tdao.allTodo()
        }
    suspend fun addTodo(todo_date:String,todo:String) {
        val newTodo = Todo(0,todo_date,todo)
        tdao.addTodo(newTodo)
    }

    suspend fun deleteTodo(todo_id:Int){
        val deletedTodo = Todo(todo_id,"","")
        tdao.deleteTodo(deletedTodo)
    }
    suspend fun updateTodo(todo_id:Int,todo_date: String,todo : String){
        val updateTodo = Todo(todo_id,todo_date,todo)
        tdao.updateTodo(updateTodo)
    }

}