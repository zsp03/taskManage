package com.d121201003.taskmanage.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.d121201003.taskmanage.databinding.FragmentHistoryBinding
import com.d121201003.taskmanage.adapter.TaskAdapter
import com.d121201003.taskmanage.viewmodel.TaskViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding?= null
    private val binding get() = _binding!!
    private lateinit var taskViewModel: TaskViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        taskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]

        val adapterTask = TaskAdapter()
        binding.recyclerTasks.adapter = adapterTask
        binding.recyclerTasks.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)

        taskViewModel.readAllDataHistory.observe(viewLifecycleOwner){task->
            adapterTask.setData(task)
        }

        binding.deleteAllHistory.setOnClickListener {
            taskViewModel.deleteAllHistory()
        }
        return view
    }
}