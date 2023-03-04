package com.example.randomtask

import retrofit2.Call
import retrofit2.http.GET

interface TaskService {

    @GET("https://www.boredapi.com/api/activity")
    fun getTask() : Call<TaskDTO>
}

interface ServiceCallback{
    fun returnSuccess()
    fun returnError()
}

enum class ErrorType{
    NO_CONNECTION,
    OTHER
}