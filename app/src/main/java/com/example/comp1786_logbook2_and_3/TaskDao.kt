package com.example.comp1786_logbook2_and_3

import androidx.room.*

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAll(): List<Task> // Get all 

    @Insert
    fun insert(task: Task): Long // Post 

    @Update
    fun update(task: Task) // Update 

    @Delete
    fun delete(task: Task) // Delete
}
