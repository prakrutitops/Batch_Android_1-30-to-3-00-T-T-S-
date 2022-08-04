package com.example.project1.Other

import com.example.project1.Model.Dashboard_Model
import com.example.project1.Model.RegisterModel
import retrofit2.Call
import retrofit2.http.*


interface Apiinterface
{
    @FormUrlEncoded
    @POST("Project_API/register.php")
    fun insertdata(
        @Field("firstname") firstname: String?,
        @Field("lastname") lastname: String?,
        @Field("mobile") mobile: String?,
        @Field("email") email: String?,
        @Field("password") password: String?,

        ): Call<Void>

    @FormUrlEncoded
    @POST("Project_API/login.php")
    fun logindata(  @Field("mobile") mobile: String?,  @Field("password") password: String?):Call<RegisterModel>


    @get:GET("Project_API/dashboard.php")
    val viewdata: Call<List<Dashboard_Model?>?>?

}