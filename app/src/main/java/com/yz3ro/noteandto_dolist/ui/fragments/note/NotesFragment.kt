package com.yz3ro.noteandto_dolist.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.yz3ro.noteandto_dolist.R
import com.yz3ro.noteandto_dolist.adapters.NotesAdapter
import com.yz3ro.noteandto_dolist.databinding.FragmentNotesBinding
import com.yz3ro.noteandto_dolist.ui.viewmodels.note.NotesViewModel
import com.yz3ro.noteandto_dolist.util.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : Fragment() {
    private lateinit var binding : FragmentNotesBinding
    private val viewModel : NotesViewModel by viewModels()
    private lateinit var notes : String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_notes, container, false)
        binding.fragmentNotes = this
        viewModel.noteList.observe(viewLifecycleOwner){ notes ->
            val noteAdapter =NotesAdapter(requireContext(),notes,viewModel)
            binding.noteAdapter = noteAdapter
        }
        return binding.root
    }
    fun FabClick () {
        Navigation.navigate(requireView(),R.id.action_notesFragment_to_addNotesFragment)
    }
    override fun onResume() {
        super.onResume()
        notes  = viewModel.getNote().toString()
    }
}