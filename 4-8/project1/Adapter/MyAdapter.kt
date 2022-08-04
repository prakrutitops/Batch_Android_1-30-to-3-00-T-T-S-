package com.example.project1.Adapter

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import android.content.Intent

import android.widget.Toast

import android.content.DialogInterface

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import com.example.project1.Model.Dashboard_Model
import com.example.project1.Other.Apiinterface
import com.example.project1.R
import com.squareup.picasso.Picasso

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MyAdapter(context: Context, dataList: List<Dashboard_Model>) :
    RecyclerView.Adapter<MyAdapter.Myview>() {
    var context: Context
    var dataList: List<Dashboard_Model>
    var api: Apiinterface? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview
    {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.desigb_dashboard, parent, false)
        return Myview(view)
    }

    override fun onBindViewHolder(holder: Myview, @SuppressLint("RecyclerView") position: Int) {
        holder.t2.setText(dataList[position].name)
        Picasso.get().load(dataList[position].image).into(holder.img)



    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class Myview(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView
        var t2: TextView


        init {
            img = itemView.findViewById(R.id.img)
            t2 = itemView.findViewById(R.id.txt)

        }
    }

    init {
        this.context = context
        this.dataList = dataList
    }
}