package com.yz3ro.noteandto_dolist.ui.viewmodels.todo

import androidx.lifecycle.ViewModel
import com.yz3ro.noteandto_dolist.data.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoDetailsViewModel @Inject constructor(var mp : MainRepository): ViewModel() {
    fun updateTodo(todo_id:Int,todo_date:String,todo:String){
        CoroutineScope(Dispatchers.Main).launch {
            mp.updateTodo(todo_id,todo_date,todo)
        }
    }
}