package com.kiwi.quest

import DataLoader
import Slangs
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainActivity : AppCompatActivity() {

    private lateinit var getOther: Slangs
    private lateinit var btnChangeMsg: Button
    private lateinit var randomMsg: TextView
    private lateinit var backgroundColorAnimation: ConstraintLayout
    private val colorsBackground = ColorsBackground(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v(TAG, "Activity created!")

        FirebaseApp.initializeApp(this)
        val databaseReference = FirebaseDatabase.getInstance().reference

        databaseReference.child("slangs").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val dataLoader = DataLoader()
                val slangsList = dataLoader.loadSlangs(dataSnapshot)
                getOther = Slangs(slangsList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "Failed to read data.", databaseError.toException())
            }
        })

        getOther = Slangs(listOf("" to ""))

        randomMsg = findViewById(R.id.msg)
        btnChangeMsg = findViewById(R.id.button)
        backgroundColorAnimation = findViewById(R.id.background)

        btnChangeMsg.setOnClickListener {
            val slang = getOther.getSlangs()
            val formattedSlang = "${slang.first} - ${slang.second}"
            randomMsg.text = formattedSlang
            val color = colorsBackground.color
            backgroundColorAnimation.setBackgroundColor(color)
            btnChangeMsg.setTextColor(color)
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
