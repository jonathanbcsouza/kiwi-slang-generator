package com.kiwi.quest

import DataLoader
import Slangs
import android.content.ContentValues.TAG
import android.os.Bundle
import android.speech.tts.TextToSpeech
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
import java.util.Locale


class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var textToSpeech: TextToSpeech

    private lateinit var getOther: Slangs
    private lateinit var btnChangeMsg: Button
    private lateinit var btnSpeak: Button
    private lateinit var randomMsg: TextView
    private lateinit var backgroundColorAnimation: ConstraintLayout
    private val colorsBackground = ColorsBackground(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textToSpeech = TextToSpeech(this, this)

        FirebaseApp.initializeApp(this)
        val databaseReference = FirebaseDatabase.getInstance().reference

        databaseReference.child("slangs").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val dataLoader = DataLoader()
                val slangsList = dataLoader.loadSlangs(dataSnapshot)
                getOther = Slangs(slangsList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("MainActivity", "Failed to read data.", databaseError.toException())
            }
        })

        getOther = Slangs(listOf("" to ""))

        randomMsg = findViewById(R.id.msg)
        btnChangeMsg = findViewById(R.id.btnCreateNew)
        backgroundColorAnimation = findViewById(R.id.background)

        btnChangeMsg.setOnClickListener {
            val slang = getOther.getSlangs()
            val formattedSlang = "${slang.first} - ${slang.second}"
            randomMsg.text = formattedSlang
            val color = colorsBackground.color
            backgroundColorAnimation.setBackgroundColor(color)
            btnChangeMsg.setTextColor(color)
        }

        btnSpeak = findViewById(R.id.btnSpeak)
        btnSpeak.setOnClickListener {
            val textToSpeak = randomMsg.text.toString()
            if (textToSpeak.isNotEmpty()) {
                textToSpeech.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }

    }

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e(TAG, "Language is not available or supported")
            } else {
                // Language is supported

            }
        } else {
            Log.e(TAG, "Initialization failed")
        }
    }

    override fun onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop()
            textToSpeech.shutdown()
        }
        super.onDestroy()
    }

}
