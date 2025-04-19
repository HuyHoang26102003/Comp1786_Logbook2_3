package com.example.comp1786_logbook2_and_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comp1786_logbook2_and_3.R

class TaskAdapter(
    private val tasks: List<Task>,
    private val onEdit: (Task) -> Unit, 
    private val onDelete: (Task) -> Unit, 
    private val onCompleteChange: (Task, Boolean) -> Unit 
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBoxCompleted: CheckBox = itemView.findViewById(R.id.checkBoxCompleted)
        val textViewTaskName: TextView = itemView.findViewById(R.id.textViewTaskName)
        val buttonEdit: Button = itemView.findViewById(R.id.buttonEdit)
        val buttonDelete: Button = itemView.findViewById(R.id.buttonDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.checkBoxCompleted.isChecked = task.isCompleted
        holder.textViewTaskName.text = task.name
        holder.buttonEdit.setOnClickListener { onEdit(task) }
        holder.buttonDelete.setOnClickListener { onDelete(task) }
        holder.checkBoxCompleted.setOnCheckedChangeListener { _, isChecked ->
            onCompleteChange(task, isChecked)
        }
    }

    override fun getItemCount(): Int = tasks.size
}
