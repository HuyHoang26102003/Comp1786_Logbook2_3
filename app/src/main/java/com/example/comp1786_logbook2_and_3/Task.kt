package com.example.comp1786_logbook2_and_3


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // Auto-generated ID
    var name: String, // Task name
    var isCompleted: Boolean = false // Completion status, defaults to false
)