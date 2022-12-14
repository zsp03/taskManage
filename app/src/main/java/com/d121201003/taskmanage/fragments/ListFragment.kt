package com.d121201003.taskmanage.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.d121201003.taskmanage.adapter.TaskAdapter
import com.d121201003.taskmanage.databinding.FragmentListBinding
import com.d121201003.taskmanage.viewmodel.TaskViewModel

class ListFragment : Fragment() {

    private var _binding:FragmentListBinding ?= null
    private val binding get() = _binding!!
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentListBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        taskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]

        val adapterTask = TaskAdapter()
        binding.recyclerTasks.adapter = adapterTask
        binding.recyclerTasks.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)

        taskViewModel.readAllData.observe(viewLifecycleOwner){task->
            adapterTask.setData(task)
        }

        return view
    }
}