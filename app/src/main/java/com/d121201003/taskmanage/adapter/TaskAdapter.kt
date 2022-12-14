package com.d121201003.taskmanage.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.d121201003.taskmanage.R
import com.d121201003.taskmanage.fragments.HistoryFragment
import com.d121201003.taskmanage.model.Task
import com.d121201003.taskmanage.viewmodel.TaskViewModel
import com.google.android.material.button.MaterialButton

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private var taskList = emptyList<Task>()
    private var context : Context?= null
    private lateinit var taskViewModel: TaskViewModel
    inner class TaskViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.judul_task)
        val category: MaterialButton = itemView.findViewById(R.id.kategori_task)
        val description: TextView = itemView.findViewById(R.id.deskripsi_task)
        val datetime: TextView = itemView.findViewById(R.id.datetime)
        val option: ImageView = itemView.findViewById(R.id.opsi_task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        context = parent.context
        taskViewModel = ViewModelProvider(context as FragmentActivity)[TaskViewModel::class.java]
        return TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_tasks,parent, false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int){
        val currentTask = taskList[position]

        holder.title.text = currentTask.title
        holder.category.text = currentTask.category
        holder.description.text = currentTask.description
        holder.datetime.text = currentTask.datetime

        when(currentTask.category){
            "Penting Mendesak"->{
                holder.category.backgroundTintList = ColorStateList.valueOf(context!!.resources.getColor(R.color.md_theme_light_error))
            }
            "Tidak Penting Mendesak"->{
                holder.category.backgroundTintList = ColorStateList.valueOf(context!!.resources.getColor(R.color.md_theme_dark_onError))
            }
            "Penting Tidak Mendesak"->{
                holder.category.backgroundTintList = ColorStateList.valueOf(context!!.resources.getColor(R.color.md_theme_dark_primary))
            }
            "Tidak Penting Tidak Mendesak"->{
                holder.category.backgroundTintList = ColorStateList.valueOf(context!!.resources.getColor(R.color.md_theme_light_tertiaryContainer))
            }
        }

    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setData(task:List<Task>){
        this.taskList = task
        notifyDataSetChanged()
    }
}