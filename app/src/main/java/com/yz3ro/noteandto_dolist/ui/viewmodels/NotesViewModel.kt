package com.yz3ro.noteandto_dolist.ui.viewmodels

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
class NotesViewModel @Inject constructor(var mp : MainRepository): ViewModel() {

    var noteList = MutableLiveData<List<Notes>>()
    fun getNote() {
        CoroutineScope(Dispatchers.Main).launch{
            noteList.value = mp.getNotes()
        }
    }
    fun deleteNote(note_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            mp.deleteNote(note_id)
            getNote()
        }
    }
}