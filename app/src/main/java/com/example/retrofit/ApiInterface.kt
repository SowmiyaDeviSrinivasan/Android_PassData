package com.example.retrofit

import com.example.retrofit.Models.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    suspend fun getAllUsers(): Response<Users>
}