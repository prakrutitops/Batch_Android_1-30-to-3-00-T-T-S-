package com.example.project1.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project1.R
import com.example.project1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnNewUser.setOnClickListener()
        {
            startActivity(Intent(this,SignupActivity::class.java))
        }

        binding.btnLogin.setOnClickListener()
        {

        }






    }
}