package com.d121201003.taskmanage.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tasks")
data class Task (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val category:String,
    val description:String,
    val stats:String

): Parcelable