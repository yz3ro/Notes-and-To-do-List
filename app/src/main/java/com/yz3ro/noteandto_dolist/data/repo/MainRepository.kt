package com.yz3ro.noteandto_dolist.data.repo

import com.yz3ro.noteandto_dolist.data.datasource.MainDataSouce
import com.yz3ro.noteandto_dolist.data.entity.Notes
import com.yz3ro.noteandto_dolist.data.entity.Todo

class MainRepository(var mds : MainDataSouce) {

    suspend fun getNotes() : List<Notes> = mds.getNotes()

    suspend fun addNote(note_title : String,note : String) = mds.addNote(note_title,note)

    suspend fun getTodo() : List<Todo> = mds.getTodo()

    suspend fun addTodo(todo_title :String,todo_date:String,todo:String) = mds.addTodo(todo_title,todo_date,todo)
}