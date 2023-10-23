package kiwi.slang

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val getOther = Slangs()
    private lateinit var btnChangeMsg: Button
    private lateinit var randomMsg: TextView
    private lateinit var backgroundColorAnimation: RelativeLayout
    private val colorsBackground = ColorsBackground(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.slang_layout)
        Log.v(TAG, "Activity created!")

        randomMsg = findViewById(R.id.msg)
        btnChangeMsg = findViewById(R.id.button)
        backgroundColorAnimation = findViewById(R.id.background)

        btnChangeMsg.setOnClickListener {
            val slang = getOther.getSlangs()
            randomMsg.text = slang
            val color = colorsBackground.color
            backgroundColorAnimation.setBackgroundColor(color)
            btnChangeMsg.setTextColor(color)
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
