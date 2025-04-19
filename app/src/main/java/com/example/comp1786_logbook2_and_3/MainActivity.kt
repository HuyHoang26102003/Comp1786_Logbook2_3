package com.example.comp1786_logbook2_and_3

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comp1786_logbook2_and_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskAdapter: TaskAdapter
    private val tasks = mutableListOf<Task>()
    private lateinit var taskDao: TaskDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
        val db = AppDatabase.getDatabase(this)
        taskDao = db.taskDao()

     
        tasks.addAll(taskDao.getAll())

   
        taskAdapter = TaskAdapter(
            tasks,
            { task -> editTask(task) }, 
            { task -> deleteTask(task) }, 
            { task, isCompleted -> // Completion callback
                task.isCompleted = isCompleted
                taskDao.update(task)
            }
        )
        binding.recyclerViewTasks.adapter = taskAdapter
        binding.recyclerViewTasks.layoutManager = LinearLayoutManager(this)

        // Add button 
        binding.buttonAdd.setOnClickListener {
            val taskName = binding.editTextTask.text.toString()
            if (taskName.isNotEmpty()) {
                val task = Task(name = taskName)
                taskDao.insert(task) 
                tasks.add(task) // Add to list
                taskAdapter.notifyItemInserted(tasks.size - 1) // UI
                binding.editTextTask.text.clear() 
            }
        }
    }

    private fun deleteTask(task: Task) {
        taskDao.delete(task) 
        val position = tasks.indexOf(task)
        if (position != -1) {
            tasks.removeAt(position) 
            taskAdapter.notifyItemRemoved(position) 
        }
    }

    private fun editTask(task: Task) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Edit Task")

        val input = EditText(this)
        input.setText(task.name)
        builder.setView(input)

        builder.setPositiveButton("OK") { _, _ ->
            val newName = input.text.toString()
            if (newName.isNotEmpty()) {
                task.name = newName
                taskDao.update(task) 
                taskAdapter.notifyItemChanged(tasks.indexOf(task)) 
            }
        }
        builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }

        builder.show()
    }
}
