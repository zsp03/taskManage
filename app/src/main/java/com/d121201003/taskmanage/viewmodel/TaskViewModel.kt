package com.d121201003.taskmanage.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.d121201003.taskmanage.model.Task
import com.d121201003.taskmanage.data.TaskDatabase
import com.d121201003.taskmanage.repo.TaskRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application):AndroidViewModel(application) {
    val readAllData:LiveData<List<Task>>
    val readAllDataHistory:LiveData<List<Task>>
    private val repository: TaskRepo
    init {
        val taskDao = TaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepo(taskDao)
        readAllData = repository.readAllData
        readAllDataHistory = repository.readAllDataHistory
    }

    fun addTask(task: Task){
        viewModelScope.launch(Dispatchers.IO){
            repository.addTask(task)
        }
    }
    fun updateTask(task: Task){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateTask(task)
        }
    }
    fun deleteTask(task: Task){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteTask(task)
        }
    }
    fun deleteAllHistory(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deletAllHistory()
        }
    }
}