package com.yz3ro.noteandto_dolist.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "todo")
data class Todo(@PrimaryKey(autoGenerate = true)
    @ColumnInfo("todo_id") @NotNull var todo_id : Int,
                @ColumnInfo("todo_title") @NotNull var todo_title : String,
                @ColumnInfo("todo_date") @NotNull var todo_date : String,
                @ColumnInfo("todo") @NotNull var todo : String,
                @ColumnInfo("todo_checked") @NotNull var todo_checked : Int
)
