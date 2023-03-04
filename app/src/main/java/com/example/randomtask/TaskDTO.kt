package com.example.randomtask

import com.google.gson.annotations.SerializedName

data class TaskDTO(
    @SerializedName("activity")
    private val task: String
) {
    fun toTask() = Task(task)
}