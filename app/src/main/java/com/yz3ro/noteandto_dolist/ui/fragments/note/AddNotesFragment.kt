package com.yz3ro.noteandto_dolist.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.yz3ro.noteandto_dolist.R
import com.yz3ro.noteandto_dolist.databinding.FragmentAddNotesBinding
import com.yz3ro.noteandto_dolist.ui.viewmodels.note.AddNotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNotesFragment : Fragment() {
    private lateinit var binding : FragmentAddNotesBinding
    private val viewModel : AddNotesViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_add_notes, container, false)
        binding.fragmentAddNotes = this
        return binding.root
    }
    fun addNote(note_title : String, note : String){
        viewModel.addNote(note_title,note)
    }
}