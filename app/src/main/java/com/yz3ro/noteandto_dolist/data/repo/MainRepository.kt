package com.yz3ro.noteandto_dolist.data.repo

import com.yz3ro.noteandto_dolist.data.datasource.MainDataSource
import com.yz3ro.noteandto_dolist.data.entity.Notes
import com.yz3ro.noteandto_dolist.data.entity.Todo

class MainRepository(var mds : MainDataSource) {

    suspend fun getNotes() : List<Notes> = mds.getNotes()

    suspend fun addNote(note_title : String,note : String) = mds.addNote(note_title,note)

    suspend fun deleteNote(note_id:Int) = mds.deleteNote(note_id)

    suspend fun updateNote(note_id:Int,note_title: String,note: String) = mds.updateNote(note_id,note_title,note)

    suspend fun getTodo() : List<Todo> = mds.getTodo()

    suspend fun addTodo(todo_date:String,todo:String) = mds.addTodo(todo_date,todo)

    suspend fun deleteTodo(todo_id:Int) = mds.deleteTodo(todo_id)

    suspend fun updateTodo(todo_id:Int,todo_date: String,todo : String) = mds.updateTodo(todo_id,todo_date,todo)

}