package com.kiwi.quest

import android.content.Context
import com.kiwi.quest.R
import java.util.Random

class ColorsBackground(private val context: Context) {
    
    private val colors: IntArray by lazy {
        val typedArray = context.resources.obtainTypedArray(R.array.background_colors)
        val colorsArray = IntArray(typedArray.length()) {
            typedArray.getColor(it, 0)
        }
        typedArray.recycle()
        colorsArray
    }

    internal val color: Int
        get() {
            val slangGenerator = Random()
            val randomNumber = slangGenerator.nextInt(colors.size)
            return colors[randomNumber]
        }
}

