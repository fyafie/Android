package com.example.projectdia.fragment

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projectdia.databinding.FragmentHomeBinding
import com.example.projectdia.model.JobPosition
import com.example.projectdia.ultils.SQLiteHelper

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding:FragmentHomeBinding
    var adapter: com.example.projectdia.adapter.ListAdapter? = null
    var layoutManager : RecyclerView.LayoutManager? = null

    private lateinit var sqliteHelper: SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sqliteHelper = SQLiteHelper(requireContext())
        /*val listJob = listOf(
            JobPosition("Guru","https://pbs.twimg.com/profile_images/1239466105833283584/v_Pxc47W_400x400.jpg"),
            JobPosition("Programmer","https://cdngarenanow-a.akamaihd.net/webmain/static/payment_center/common/garena-logo.png")
        )*/
        layoutManager = LinearLayoutManager(context)
        adapter = com.example.projectdia.adapter.ListAdapter(sqliteHelper.getAllJobs(), requireContext())
        binding.rvList.adapter = adapter

        binding.rvList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapter
        }

        binding.btnAddData.setOnClickListener{
            addJob()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addJob(){
        val jobName = binding.etJobName.text.toString()
        val image = binding.etImage.text.toString()

        val job = JobPosition(jobName = jobName, image = image)
        val status = sqliteHelper.insertJob(job)

        if (status > -1){
            Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
            adapter?.arrayList = sqliteHelper.getAllJobs()
            adapter?.notifyDataSetChanged()

        } else {
            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}