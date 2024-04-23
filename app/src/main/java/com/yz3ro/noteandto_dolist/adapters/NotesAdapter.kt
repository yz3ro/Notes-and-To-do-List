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
import com.yz3ro.noteandto_dolist.databinding.NoteItemBinding
import com.yz3ro.noteandto_dolist.ui.fragments.NotesFragmentDirections
import com.yz3ro.noteandto_dolist.ui.viewmodels.NotesViewModel
import com.yz3ro.noteandto_dolist.util.direction

class NotesAdapter (var mContext : Context,var noteList :List<Notes>, var viewModel: NotesViewModel) : RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {
    inner class MyViewHolder(var design : NoteItemBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding:NoteItemBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
            R.layout.note_item ,parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val note= noteList.get(position)
        val t = holder.design
        t.noteObject = note
        t.noteCardView.setOnClickListener {
            val direct = NotesFragmentDirections.actionNotesFragmentToNoteDetailsFragment(note = note)
            Navigation.direction(it,direct)
        }
        t.deleteNote.setOnClickListener {
            Snackbar.make(it,"Not silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    viewModel.deleteNote(note.note_id)
                }
                .show()
        }
    }
    override fun getItemCount(): Int = noteList.size


}