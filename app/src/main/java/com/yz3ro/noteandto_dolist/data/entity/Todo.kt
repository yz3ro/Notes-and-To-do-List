package com.yz3ro.noteandto_dolist.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "todos")
data class Todo(@PrimaryKey(autoGenerate = true)
    @ColumnInfo("todo_id") @NotNull var todo_id : Int,
                @ColumnInfo("todo_date") @NotNull var todo_date : String,
                @ColumnInfo("todo") @NotNull var todo : String
) : Serializable
