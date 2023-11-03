package com.kiwi.quest

import DataLoader
import Sentences
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import java.util.Locale

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var backgroundColorAnimation: ConstraintLayout
    private lateinit var btnChangeMsg: Button
    private lateinit var btnSpeak: Button
    private lateinit var slangProvider: Sentences
    private lateinit var randomMsg: TextView
    private lateinit var textToSpeech: TextToSpeech
    private val colorsBackground = ColorsBackground(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        initializeTextToSpeech()
        initializeFirebase()
        initializeUIComponents()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item1 -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Check out this app: https://play.google.com/store/apps/details?id=$packageName")
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
                true
            }
            R.id.item2 -> {
                try {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("market://details?id=$packageName")
                    startActivity(intent)
                } catch (e: android.content.ActivityNotFoundException) {
                    // This catch block will handle the case where the Google Play Store app isn't installed on the device
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    startActivity(intent)
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initializeTextToSpeech() {
        textToSpeech = TextToSpeech(this, this)
    }

    private fun initializeFirebase() {
        FirebaseApp.initializeApp(this)
        val databaseReference = FirebaseDatabase.getInstance().reference
        databaseReference.child("slangs").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val dataLoader = DataLoader()
                val slangsList = dataLoader.loadData(dataSnapshot)
                slangProvider = Sentences(slangsList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("TextToSpeechDemo", "Failed to read data.", databaseError.toException())
            }
        })

        slangProvider = Sentences(listOf("" to ""))
    }

    private fun initializeUIComponents() {
        randomMsg = findViewById(R.id.msg)
        btnChangeMsg = findViewById(R.id.btnCreateNew)
        backgroundColorAnimation = findViewById(R.id.background)
        btnSpeak = findViewById(R.id.btnSpeak)

        btnChangeMsg.setOnClickListener {
            updateMessageAndColors()
        }

        btnSpeak.setOnClickListener {
            speakText()
        }
    }

    private fun updateMessageAndColors() {
        val slang = slangProvider.getSlangs()
        val formattedSlang = "${slang.first} - ${slang.second}"
        randomMsg.text = formattedSlang
        val color = colorsBackground.color
        backgroundColorAnimation.setBackgroundColor(color)
        btnChangeMsg.setTextColor(color)
    }

    private fun speakText() {
        val textToSpeak = randomMsg.text.toString()
        if (textToSpeak.isNotEmpty()) {
            val speakableText = textToSpeak.split("-").first().trim()
            textToSpeech.speak(speakableText, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            textToSpeech.language = Locale("en", "NZ")
            textToSpeech.setPitch(0.8f)
            textToSpeech.setSpeechRate(1.5f)
        }
    }

    override fun onDestroy() {
        textToSpeech?.let {
            it.stop()
            it.shutdown()
        }
        super.onDestroy()
    }
}
