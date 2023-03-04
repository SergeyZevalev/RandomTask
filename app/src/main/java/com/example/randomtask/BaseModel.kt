package com.example.randomtask

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.UnknownHostException

class BaseModel(
    private val taskService: TaskService,
    private val resourceManager: ResourceManager): Model {

    private var resultCallback: ResultCallback? = null

    private val noConnection by lazy { NoConnection(resourceManager) }
    private val serviceUnavailable by lazy { ServiceUnavailable(resourceManager) }

    override fun init(resultCallback: ResultCallback){
        this.resultCallback = resultCallback
    }

    override fun getTask(){
        taskService.getTask().enqueue(object : Callback<TaskDTO> {
            override fun onResponse(call: Call<TaskDTO>, response: Response<TaskDTO>) {
                if (response.isSuccessful){
                    resultCallback?.provideSuccess(response.body()!!.toTask())
                } else {
                    resultCallback?.provideError(serviceUnavailable)
                }
            }

            override fun onFailure(call: Call<TaskDTO>, t: Throwable) {
                if (t is UnknownHostException){
                    resultCallback?.provideError(noConnection)
                } else resultCallback?.provideError(serviceUnavailable)
            }
        })
    }

    override fun clear(){
        resultCallback = null
    }
}