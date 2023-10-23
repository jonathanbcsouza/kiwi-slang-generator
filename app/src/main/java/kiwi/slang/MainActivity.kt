package kiwi.slang

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val getOther = Slangs()
    private var btnChangeMsg: TextView? = null
    private var randomMsg: TextView? = null
    private var backgroundColorAnimation: RelativeLayout? = null
    private val colorsBackground = ColorsBackground()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.slang_layout)
        Log.v(TAG, "Activity created!")

        val title = findViewById<TextView>(R.id.title)
        randomMsg = findViewById(R.id.msg)
        btnChangeMsg = findViewById<View>(R.id.button) as Button
        backgroundColorAnimation = findViewById<View>(R.id.background) as RelativeLayout

        btnChangeMsg!!.setOnClickListener {
            val getClass = getOther.getSlangs()
            randomMsg!!.text = getClass
            val colors = colorsBackground.color
            backgroundColorAnimation!!.setBackgroundColor(colors)
            btnChangeMsg!!.setTextColor(colors)
        }
    }

    companion object {

        val TAG = MainActivity::class.java.simpleName
    }
}
