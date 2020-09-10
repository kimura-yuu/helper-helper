package com.example.helper_helper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_entrance.*


class Entrance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

        GoToInput.setOnClickListener {
            val intent = Intent(application, Inputs::class.java)
            startActivity(intent)
        }
        GoToOutput.setOnClickListener {
            val intent = Intent(application, Outputs::class.java)
            startActivity(intent)
        }
    }
}