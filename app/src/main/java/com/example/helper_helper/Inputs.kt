package com.example.helper_helper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_inputs.*
import com.google.firebase.firestore.FirebaseFirestore

val db = FirebaseFirestore.getInstance()

class Inputs : AppCompatActivity() {
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
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("heavenlier", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("heavenlier", "Error adding document", e)
            }

        returnButton.setOnClickListener{
            finish()
        }

        SButton.setOnClickListener{

        }
    }
}