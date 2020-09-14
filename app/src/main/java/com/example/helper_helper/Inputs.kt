package com.example.helper_helper

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_inputs.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter


val db = FirebaseFirestore.getInstance()

class Inputs : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inputs)

        val colorGroup: RadioGroup = findViewById(R.id.clean_group)
        colorGroup.setOnCheckedChangeListener { _, checkedId: Int ->
            when (checkedId) {
                R.id.clean1 -> Toast.makeText(this, "掃除機がけが選ばれています", Toast.LENGTH_SHORT).show()
                R.id.clean2 -> Toast.makeText(this, "雑巾がけが選ばれています", Toast.LENGTH_SHORT).show()
                R.id.clean3 -> Toast.makeText(this, "モップがけが選ばれています", Toast.LENGTH_SHORT).show()
                else -> throw IllegalArgumentException("not supported")
            }
        }
        val user=hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )


        val id= LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        db.collection("users").document(id as String).set(user)

        returnButton.setOnClickListener{
            finish()
        }

        SButton.setOnClickListener{

        }
    }
}