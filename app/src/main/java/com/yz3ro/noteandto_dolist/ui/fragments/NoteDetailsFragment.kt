package com.yz3ro.noteandto_dolist.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.yz3ro.noteandto_dolist.R
import com.yz3ro.noteandto_dolist.databinding.FragmentNoteDetailsBinding
import com.yz3ro.noteandto_dolist.ui.viewmodels.NoteDetailsViewModel
import com.yz3ro.noteandto_dolist.ui.viewmodels.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteDetailsFragment : Fragment() {
    private lateinit var binding : FragmentNoteDetailsBinding
    private val viewModel : NoteDetailsViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding =DataBindingUtil.inflate(inflater,R.layout.fragment_note_details, container, false)
        binding.noteDetailsFragment = this
        val bundle:NoteDetailsFragmentArgs by navArgs()
        val direct = bundle.note
        binding.noteObject = direct
        return binding.root
    }
    fun noteUpdate(note_id : Int , note_title : String,note : String){
        viewModel.updateNote(note_id,note_title,note)
    }
    fun noteEdit(){
        binding.apply {
            noteDetailsNote.isEnabled = true
            noteDetailsTitle.isEnabled = true
            btnNoteUpdate.visibility = View.VISIBLE
        }
    }
}