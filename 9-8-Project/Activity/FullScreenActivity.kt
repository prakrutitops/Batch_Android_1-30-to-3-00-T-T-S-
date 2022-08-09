package com.example.project1.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project1.R
import com.example.project1.databinding.ActivityCategoryBinding
import com.example.project1.databinding.ActivityFullScreenBinding
import com.squareup.picasso.Picasso

class FullScreenActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityFullScreenBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val i: Intent = getIntent()
        var originalUrl = i.getStringExtra("image_position")!!
        Picasso.get().load(originalUrl).into(binding.photo)


    }
}