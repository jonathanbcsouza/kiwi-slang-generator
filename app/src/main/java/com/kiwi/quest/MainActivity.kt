package com.kiwi.quest

import Slangs
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kiwi.quest.ColorsBackground

class MainActivity : AppCompatActivity() {

    private lateinit var getOther: Slangs
    private lateinit var btnChangeMsg: Button
    private lateinit var randomMsg: TextView
    private lateinit var backgroundColorAnimation: RelativeLayout
    private val colorsBackground = ColorsBackground(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v(TAG, "Activity created!")

        getOther = Slangs(this)

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
