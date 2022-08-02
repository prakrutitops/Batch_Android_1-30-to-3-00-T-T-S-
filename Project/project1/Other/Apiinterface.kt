package com.example.project1.Other

import com.example.project1.Model.RegisterModel
import retrofit2.Call
import retrofit2.http.*


interface Apiinterface
{
    @FormUrlEncoded
    @POST("register.php")
    fun insertdata(
        @Field("firstname") firstname: String?,
        @Field("lastname") lastname: String?,
        @Field("mobile") mobile: String?,
        @Field("email") email: String?,
        @Field("password") password: String?,

        ): Call<RegisterModel>

    @FormUrlEncoded
    @POST("login.php")
    fun logindata(  @Field("mobile") mobile: String?,  @Field("password") password: String?):Call<RegisterModel>

}