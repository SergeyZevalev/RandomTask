package com.example.randomtask

interface ResultCallback {

    fun provideSuccess(data: Task)
    fun provideError(error: Error)
}