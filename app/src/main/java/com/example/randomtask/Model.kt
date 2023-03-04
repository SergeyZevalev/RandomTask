package com.example.randomtask

interface Model {

    fun init(resultCallback: ResultCallback)
    fun getTask()
    fun clear()
}