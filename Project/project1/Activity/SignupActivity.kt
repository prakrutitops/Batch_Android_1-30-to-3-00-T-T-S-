package com.example.project1.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project1.Model.RegisterModel
import com.example.project1.Other.ApiClient
import com.example.project1.Other.Apiinterface
import com.example.project1.R
import com.example.project1.databinding.ActivityLoginBinding
import com.example.project1.databinding.ActivitySignupBinding
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity()
{

    private lateinit var binding: ActivitySignupBinding
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnRegister.setOnClickListener()
        {
            var fname=binding.edtFirstName.text.toString()
            var lname=binding.edtLastName.text.toString()
            var mobile=binding.edtPhone.text.toString()
            var email=binding.edtEmail.text.toString()
            var pass=binding.edtPassword.text.toString()
            var cpass=binding.edtConfirmPassword.text.toString()

            if(!pass.equals(cpass))
            {
               Snackbar.make(it,"Password and cofirm password are not same",Snackbar.LENGTH_LONG).show()
            }
            else
            {
                apiinterface=ApiClient.getapiclient().create(Apiinterface::class.java)
                var registercall: Call<RegisterModel> = apiinterface.insertdata(fname,lname,mobile,email,
               pass)

                registercall.enqueue(object : Callback<RegisterModel?>{
                    override fun onResponse(
                        call: Call<RegisterModel?>,
                        response: Response<RegisterModel?>,
                    ) {



                    }

                    override fun onFailure(call: Call<RegisterModel?>, t: Throwable) {


                        Toast.makeText(applicationContext,""+t,Toast.LENGTH_LONG).show()
                    }
                })
                startActivity(Intent(this,LoginActivity::class.java))


            }


        }


    }
}