package com.yz3ro.noteandto_dolist.ui.viewmodels.note

import androidx.lifecycle.ViewModel
import com.yz3ro.noteandto_dolist.data.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNotesViewModel @Inject constructor(var mp : MainRepository): ViewModel() {
     fun addNote(note_title : String,note : String) {
        CoroutineScope(Dispatchers.Main).launch{
            mp.addNote(note_title,note)
        }
     }
}