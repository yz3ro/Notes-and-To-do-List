package com.yz3ro.noteandto_dolist.ui.fragments.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.yz3ro.noteandto_dolist.R
import com.yz3ro.noteandto_dolist.databinding.FragmentTodoDetailsBinding
import com.yz3ro.noteandto_dolist.ui.fragments.note.NoteDetailsFragmentArgs
import com.yz3ro.noteandto_dolist.ui.viewmodels.note.NoteDetailsViewModel
import com.yz3ro.noteandto_dolist.ui.viewmodels.todo.TodoDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoDetailsFragment : Fragment() {
    private lateinit var binding  : FragmentTodoDetailsBinding
    private val viewModel : TodoDetailsViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_todo_details, container, false)
        binding.todoDetailsFragment= this
        val bundle: TodoDetailsFragmentArgs by navArgs()
        val direct = bundle.todo
        binding.todoObject = direct
        return binding.root
    }
    fun todoUpdate(todo_id : Int , todo_date : String,todo : String){
        viewModel.updateTodo(todo_id,todo_date,todo)
    }
    fun todoEdit(){
        binding.apply {
            txtTodo.isEnabled = true
            txtDate.isEnabled = true
            btnTodoUpdate.visibility = View.VISIBLE
        }
    }
}