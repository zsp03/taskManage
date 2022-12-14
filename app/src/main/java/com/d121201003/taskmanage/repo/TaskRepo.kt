package com.d121201003.taskmanage.repo

import androidx.lifecycle.LiveData
import com.d121201003.taskmanage.model.Task
import com.d121201003.taskmanage.data.TaskDao

class TaskRepo (private val taskDao: TaskDao){
    val readAllData: LiveData<List<Task>> = taskDao.readAllData()
    val readAllDataHistory: LiveData<List<Task>> = taskDao.readAllDataHistory()
    suspend fun addTask(task: Task){
        taskDao.addTask(task)
    }
    suspend fun updateTask(task: Task){
        taskDao.updateTask(task)
    }
    suspend fun deleteTask(task: Task){
        taskDao.deleteTask(task)
    }
    suspend fun deletAllHistory(){
        taskDao.deleteAllHistory()
    }
}