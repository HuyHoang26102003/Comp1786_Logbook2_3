package com.example.comp1786_logbook2_and_3

import androidx.room.*

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAll(): List<Task> // Get all tasks

    @Insert
    fun insert(task: Task): Long // Insert a task, returns the new ID

    @Update
    fun update(task: Task) // Update a task

    @Delete
    fun delete(task: Task) // Delete a task
}