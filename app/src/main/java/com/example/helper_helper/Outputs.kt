package com.example.helper_helper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_outputs.*

//val db = FirebaseFirestore.getInstance()
class Outputs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outputs)
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("heveanlier", "${document.id} => ${document["first"]}")
                    val text: String = document["first"] as String
                    textView3.setText(text)
                }
            }
            .addOnFailureListener { exception ->
                Log.d("heveanlier", "Error getting documents: ", exception)
            }
        returnButton.setOnClickListener{
            finish()
        }
    }
}