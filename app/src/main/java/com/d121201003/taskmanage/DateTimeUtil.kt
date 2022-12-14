package com.d121201003.taskmanage

import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtil {
    fun getCurrentDate(): String {
        val date = Date()
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return formatter.format(date)
    }
}