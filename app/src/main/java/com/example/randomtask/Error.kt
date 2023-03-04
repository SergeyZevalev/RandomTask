package com.example.randomtask

interface Error {

    fun getErrorMessage(): String
}

class NoConnection(private val resourceManager: ResourceManager) : Error {
    override fun getErrorMessage() = resourceManager.getString(R.string.no_connection)

}

class ServiceUnavailable(private val resourceManager: ResourceManager) : Error {
    override fun getErrorMessage() = resourceManager.getString(R.string.service_unavailable)

}