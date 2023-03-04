package com.example.randomtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_view)
        val getRandomTaskButton = findViewById<Button>(R.id.button_get_random_task)
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)

        viewModel = (application as TaskApp).viewModel
        viewModel.init(object : TextCallback {
            override fun provideText(textData: String) = runOnUiThread{
                getRandomTaskButton.isEnabled = true
                progressBar.visibility = View.INVISIBLE
                textView.text = textData
            }

        })

        getRandomTaskButton.setOnClickListener{
            getRandomTaskButton.isEnabled = false
            progressBar.visibility = View.VISIBLE
            viewModel.getTask()
        }
    }

    override fun onDestroy() {
        viewModel.clear()
        super.onDestroy()
    }
}