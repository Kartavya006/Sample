package com.example.sample3

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/v1/create")
    fun createUser(@Body request: UserRequest): Call<UserResponse>
}