package com.example.project1.Activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project1.Adapter.CategoryAdapter
import com.example.project1.Adapter.MyAdapter
import com.example.project1.Model.Category_Model

import com.example.project1.Other.ApiClient
import com.example.project1.Other.Apiinterface
import com.example.project1.R
import com.example.project1.databinding.ActivityCategoryBinding

import okhttp3.Request

import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList
import javax.security.auth.callback.Callback

class CategoryActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    private lateinit var binding: ActivityCategoryBinding
    lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<Category_Model>
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i=intent
        var pos=i.getIntExtra("MyPos",101)

        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        recyclerView = findViewById(R.id.recycler)
        list = ArrayList<Category_Model>()

        val rl: RecyclerView.LayoutManager = GridLayoutManager(applicationContext,2)
        recyclerView.layoutManager = rl
        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        if(pos==0)
        {
            val call = apiinterface!!.viewcategory_diwali
            call!!.enqueue(object : Call<List<Category_Model?>>,
                retrofit2.Callback<List<Category_Model?>?> {
                /*  override fun onResponse(call: Call<List<Model?>>, response: Response<List<Model?>>) {

                  }

                  override fun onFailure(call: Call<List<Model?>>, t: Throwable) {}*/
                override fun onResponse(
                    call: Call<List<Category_Model?>?>,
                    response: Response<List<Category_Model?>?>
                ) {
                    list = response.body() as MutableList<Category_Model>
                    val customAdapter = CategoryAdapter(applicationContext, list!!)
                    recyclerView.adapter = customAdapter
                }

                override fun onFailure(call: Call<List<Category_Model?>?>, t: Throwable) {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
                }

                override fun clone(): Call<List<Category_Model?>> {
                    TODO("Not yet implemented")
                }

                override fun execute(): Response<List<Category_Model?>> {
                    TODO("Not yet implemented")
                }

                override fun enqueue(callback: retrofit2.Callback<List<Category_Model?>>) {
                    TODO("Not yet implemented")
                }

                override fun isExecuted(): Boolean {
                    TODO("Not yet implemented")
                }

                override fun cancel() {
                    TODO("Not yet implemented")
                }

                override fun isCanceled(): Boolean {
                    TODO("Not yet implemented")
                }

                override fun request(): Request {
                    TODO("Not yet implemented")
                }
            })

        }
        if(pos==1)
        {
            val call = apiinterface!!.viewcategory_holi
            call!!.enqueue(object : Call<List<Category_Model?>>,
                retrofit2.Callback<List<Category_Model?>?> {
                /*  override fun onResponse(call: Call<List<Model?>>, response: Response<List<Model?>>) {

                  }

                  override fun onFailure(call: Call<List<Model?>>, t: Throwable) {}*/
                override fun onResponse(
                    call: Call<List<Category_Model?>?>,
                    response: Response<List<Category_Model?>?>
                ) {
                    list = response.body() as MutableList<Category_Model>
                    val customAdapter = CategoryAdapter(applicationContext, list!!)
                    recyclerView.adapter = customAdapter
                }

                override fun onFailure(call: Call<List<Category_Model?>?>, t: Throwable) {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
                }

                override fun clone(): Call<List<Category_Model?>> {
                    TODO("Not yet implemented")
                }

                override fun execute(): Response<List<Category_Model?>> {
                    TODO("Not yet implemented")
                }

                override fun enqueue(callback: retrofit2.Callback<List<Category_Model?>>) {
                    TODO("Not yet implemented")
                }

                override fun isExecuted(): Boolean {
                    TODO("Not yet implemented")
                }

                override fun cancel() {
                    TODO("Not yet implemented")
                }

                override fun isCanceled(): Boolean {
                    TODO("Not yet implemented")
                }

                override fun request(): Request {
                    TODO("Not yet implemented")
                }
            })
        }


    }
}