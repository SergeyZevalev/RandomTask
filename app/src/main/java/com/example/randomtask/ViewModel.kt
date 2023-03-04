package com.example.randomtask

class ViewModel(private val baseModel: BaseModel) {

    private var textCallback: TextCallback? = null

    fun init(textCallback: TextCallback){
        this.textCallback = textCallback
        baseModel.init(object: ResultCallback{
            override fun provideSuccess(data: Task) {
                textCallback.provideText(data.getData())
            }

            override fun provideError(error: Error) {
                textCallback.provideText(error.getErrorMessage())
            }

        })
    }

    fun getTask(){
        baseModel.getTask()
    }

    fun clear(){
        textCallback = null
        baseModel.clear()
    }
}