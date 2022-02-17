package com.example.projectdia.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectdia.R
import com.example.projectdia.databinding.ActivityDayLimaBinding
import com.example.projectdia.viewmodel.DayLimaViewModel

class DayLimaActivity : AppCompatActivity() {
    lateinit var binding:ActivityDayLimaBinding
//    private val adapter = AppAdapter()
    private val viewModel:DayLimaViewModel by lazy{
        ViewModelProviders.of(this).get(DayLimaViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_lima)
        binding = ActivityDayLimaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager = LinearLayoutManager(this)
        binding.rvHasil.layoutManager = layoutManager
        viewModel.getAllJob()
        setObserve()
    }

    private fun setObserve(){
        viewModel.listResponse().observe(this, Observer{
            Log.d("ListApp,",it.toString())
            /*binding.rvHasil.adapter = adapter
            adapter.initData(it.data ad ArrayList<Data>)*/
        })
    }
}