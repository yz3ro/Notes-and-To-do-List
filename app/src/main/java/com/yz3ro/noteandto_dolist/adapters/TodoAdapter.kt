package com.yz3ro.noteandto_dolist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.yz3ro.noteandto_dolist.R
import com.yz3ro.noteandto_dolist.data.entity.Notes
import com.yz3ro.noteandto_dolist.data.entity.Todo
import com.yz3ro.noteandto_dolist.databinding.ItemTodoBinding
import com.yz3ro.noteandto_dolist.ui.fragments.note.NotesFragmentDirections
import com.yz3ro.noteandto_dolist.ui.fragments.todo.TodoListFragmentDirections
import com.yz3ro.noteandto_dolist.ui.viewmodels.note.NotesViewModel
import com.yz3ro.noteandto_dolist.ui.viewmodels.todo.TodoListViewModel
import com.yz3ro.noteandto_dolist.util.direction

class TodoAdapter (var mContext : Context, var todoList :List<Todo>,var viewModel: TodoListViewModel) : RecyclerView.Adapter<TodoAdapter.MyViewHolder>(){
    inner class MyViewHolder(var design : ItemTodoBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding:ItemTodoBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.item_todo ,parent, false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val todo= todoList.get(position)
        val t = holder.design
        t.todoObject = todo
        t.todoCardView.setOnClickListener{
            val direct = TodoListFragmentDirections.actionTodoListFragmentToTodoDetailsFragment(todo = todo)
            Navigation.direction(it,direct)
        }
        t.btnDelete.setOnClickListener {
            Snackbar.make(it,"Not silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    viewModel.deleteTodo(todo.todo_id)
                }
                .show()
        }
    }
    override fun getItemCount(): Int = todoList.size
}