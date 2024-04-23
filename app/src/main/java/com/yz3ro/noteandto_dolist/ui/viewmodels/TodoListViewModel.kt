package com.yz3ro.noteandto_dolist.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.yz3ro.noteandto_dolist.data.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(var mp : MainRepository): ViewModel() {
}