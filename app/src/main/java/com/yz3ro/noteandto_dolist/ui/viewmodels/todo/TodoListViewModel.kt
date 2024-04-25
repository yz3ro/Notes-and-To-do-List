package com.yz3ro.noteandto_dolist.ui.viewmodels.todo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yz3ro.noteandto_dolist.data.entity.Notes
import com.yz3ro.noteandto_dolist.data.entity.Todo
import com.yz3ro.noteandto_dolist.data.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(var mp : MainRepository): ViewModel() {
    var todoList = MutableLiveData<List<Todo>>()

    fun getTodo(){
        CoroutineScope(Dispatchers.Main).launch{
            todoList.value = mp.getTodo()
        }
    }
    fun deleteTodo(todo_id : Int){
        CoroutineScope(Dispatchers.Main).launch {
            mp.deleteTodo(todo_id)
            getTodo()
        }
    }
}