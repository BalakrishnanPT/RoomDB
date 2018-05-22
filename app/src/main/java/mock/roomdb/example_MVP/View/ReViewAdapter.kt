package com.example.chandru.roomlibrary.RecyclerView


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import mock.roomdb.R
import mock.roomdb.data.db.UserKt

class ReViewAdapter(internal var ctx: Context, internal var dataModelArrayList: List<UserKt>?) : RecyclerView.Adapter<ReViewAdapter.Myholder>() {
    override fun getItemCount(): Int {
        return dataModelArrayList!!.size
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.roomtab, null)
        return Myholder(view)
    }
    override fun onBindViewHolder(holder: Myholder, position: Int) {
        val (id,name,region)= dataModelArrayList!![position]
        holder.tv_name?.setText(""+id)
        holder.tv_pass?.setText(name +"    "+ region)
    }

    fun refresh(list: List<UserKt>){
        dataModelArrayList = list
        notifyItemInserted(list.size)
    }
    inner class Myholder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_name: TextView ?=view.findViewById(R.id.li_name)
        val tv_pass: TextView ?= view.findViewById(R.id.li_region)
    }
}
