package com.yz3ro.noteandto_dolist.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.navigate(it: View, id:Int){
    findNavController(it).navigate(id)
}
fun Navigation.direction(it:View,id: NavDirections){
    findNavController(it).navigate(id)
}