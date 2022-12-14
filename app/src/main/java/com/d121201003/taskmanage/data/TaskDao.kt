package com.d121201003.taskmanage.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.d121201003.taskmanage.model.Task

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: Task)

    @Query("SELECT * FROM tasks WHERE stats='Ongoing'")
    fun readAllData(): LiveData<List<Task>>
    @Query("SELECT * FROM tasks WHERE stats='Done'")
    fun readAllDataHistory(): LiveData<List<Task>>
    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("DELETE FROM tasks WHERE stats='Done'")
    suspend fun deleteAllHistory()


}