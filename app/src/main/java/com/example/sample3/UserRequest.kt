package com.example.sample3

data class UserRequest(
    val name: String,
    val salary: String,
    val age: String
)

data class UserResponse(
    val status: String,
    val data: UserData,
    val message: String
)

data class UserData(
    val name: String,
    val salary: String,
    val age: String,
    val id: Int
)
