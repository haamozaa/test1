package com.example.firebase1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebase1.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            var name = binding.txtName.text.toString()
            var number = binding.txtNumber.text.toString()
            var age = binding.txtAge.text.toString()
            // Create a new user with a first and last name
            val person = hashMapOf(
                "name" to name,
                "number" to number,
                "age" to age
            )
            //120200524   Hamza Nabhan
            //Hamza Branch
            // Add a new document with a generated ID
            db.collection("Person")
                .add(person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(applicationContext,"${documentReference.id}",Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(applicationContext,"Data didn't add successfully",Toast.LENGTH_LONG).show()
                }
        }
    }
}