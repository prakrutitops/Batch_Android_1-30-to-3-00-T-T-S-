package com.example.project1.Other

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{



    companion object
    {
        var retrofit: Retrofit? = null
        var myurl="https://vyasprakruti.000webhostapp.com/Project_API/"

        fun getapiclient() :Retrofit
        {
            if(retrofit==null)
            {
                retrofit=Retrofit.Builder()
                    .baseUrl(myurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!
        }
    }

}