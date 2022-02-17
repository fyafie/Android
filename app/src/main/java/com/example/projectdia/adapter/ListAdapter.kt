package com.example.projectdia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectdia.R
import com.example.projectdia.model.JobPosition
import java.util.ArrayList

class ListAdapter(var arrayList: List<JobPosition>, private val context: Context):
    RecyclerView.Adapter<ListAdapter.JobHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobHolder {
        return JobHolder(LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false))
    }

    override fun onBindViewHolder(holder: JobHolder, position: Int) {
        val data = arrayList[holder.adapterPosition]
        holder.tv.text = data.jobName
        Glide.with(context)
            .load(data.image)
            .centerCrop()
            .into(holder.ivJobs)
    }

    override fun getItemCount(): Int = arrayList.size
    class JobHolder(view: View):RecyclerView.ViewHolder(view){
        var tv : TextView = view.findViewById(R.id.tvJobName)
        var ivJobs: ImageView = view.findViewById(R.id.ivJob)
    }



}