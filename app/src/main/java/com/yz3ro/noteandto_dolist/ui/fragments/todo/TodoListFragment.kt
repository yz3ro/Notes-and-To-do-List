package com.yz3ro.noteandto_dolist.ui.fragments.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.yz3ro.noteandto_dolist.R
import com.yz3ro.noteandto_dolist.adapters.NotesAdapter
import com.yz3ro.noteandto_dolist.adapters.TodoAdapter
import com.yz3ro.noteandto_dolist.databinding.FragmentTodoListBinding
import com.yz3ro.noteandto_dolist.ui.viewmodels.todo.TodoListViewModel
import com.yz3ro.noteandto_dolist.util.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoListFragment : Fragment() {
    private lateinit var binding : FragmentTodoListBinding
    private val viewModel : TodoListViewModel by viewModels()
    private lateinit var todos : String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_todo_list, container, false)
        binding.fragmentTodo = this
        viewModel.todoList.observe(viewLifecycleOwner, Observer {todo ->
            val todoAdapter = TodoAdapter(requireContext(),todo,viewModel)
            binding.todoAdapter = todoAdapter
        })
        return binding.root
    }
    fun fabClick(){
        Navigation.navigate(requireView(),R.id.action_todoListFragment_to_addTodoFragment)
    }
    override fun onResume() {
        super.onResume()
        todos  = viewModel.getTodo().toString()
    }
}