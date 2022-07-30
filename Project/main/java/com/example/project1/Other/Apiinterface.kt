package com.example.project1.Other

import com.example.project1.Model.RegisterModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("register.php")
    fun insertdata
    (
        @Field("firstname")  firstname: String?,
        @Field("lastname")  lastname: String?,
        @Field("mobile") mobile: String?,
        @Field("email") email: String?,
        @Field("password") password: String?

    ): Call<RegisterModel>

}