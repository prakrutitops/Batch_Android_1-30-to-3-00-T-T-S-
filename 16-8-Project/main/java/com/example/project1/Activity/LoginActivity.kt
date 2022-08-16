package com.example.project1.Activity

import android.R.attr
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.project1.databinding.ActivityLoginBinding
import android.widget.Toast
import com.example.project1.Model.RegisterModel

import com.example.project1.Other.ApiClient
import com.example.project1.Other.Apiinterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.R.attr.password
import android.content.Context
import android.content.SharedPreferences
import android.util.Log


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var apiinterface: Apiinterface
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences=getSharedPreferences("user_session",Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("user_session", false) && !sharedPreferences.getString("mob", "")!!.isEmpty())
        {
            startActivity(Intent(this@LoginActivity, DashboardActivity::class.java))
            finish()
        }


        binding.btnNewUser.setOnClickListener()
        {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        binding.btnLogin.setOnClickListener()
        {
            var mobile = binding.edtMobile.text.toString()
            var pass = binding.edtPass.text.toString()



            var apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

            var call:Call<RegisterModel> = apiinterface.logindata(mobile,pass)
            call.enqueue(object:Callback<RegisterModel>{
                override fun onResponse(
                    call: Call<RegisterModel>,
                    response: Response<RegisterModel>
                )
                {
                    sharedPreferences.edit().putString("mob",mobile).commit()

                    sharedPreferences.edit().putBoolean("user_session",true).commit();


                    Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()

                    startActivity(Intent(applicationContext,DashboardActivity::class.java))
                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"Fail",Toast.LENGTH_LONG).show()
                }
            })

            /*val call: Call<RegisterModel> = apiinterface.logindata(mobile, pass)
            call.enqueue(object :Callback<RegisterModel>{
                override fun onResponse(call: Call<RegisterModel>, response: Response<RegisterModel>, )
                {
                        Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"Fail",Toast.LENGTH_LONG).show()
                }
            })*/




        }
    }
}

           /* call.enqueue(object : Callback<String?> {
                override fun onResponse(call: Call<String?>, response: Response<String?>) {
                    Log.i("Responsestring", response.body().toString())
                    //Toast.makeText()
                    if (response.isSuccessful) {
                        if (response.body() != null) {
                            Log.i("onSuccess", response.body().toString())
                            val jsonresponse = response.body().toString()
                            parseLoginData(jsonresponse)
                        } else {
                            Log.i("onEmptyResponse",
                                "Returned empty response") //Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                        }
                    }
                }

                override fun onFailure(call: Call<String?>, t: Throwable) {}
            })*/



