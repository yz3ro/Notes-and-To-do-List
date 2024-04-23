package com.yz3ro.noteandto_dolist.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.yz3ro.noteandto_dolist.R
import com.yz3ro.noteandto_dolist.databinding.FragmentAddTodoBinding
import com.yz3ro.noteandto_dolist.ui.viewmodels.AddTodoViewModel
import com.yz3ro.noteandto_dolist.ui.viewmodels.TodoListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTodoFragment : Fragment() {
    private lateinit var binding : FragmentAddTodoBinding
    private val viewModel : AddTodoViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_todo, container, false)
        return binding.root
    }
}