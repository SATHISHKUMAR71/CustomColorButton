package com.example.colorbutton

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton

class CustomButton(context: Context,attrs:AttributeSet):AppCompatButton(context,attrs) {

    private var currentColorIndex = 0
    private var colors = mutableListOf(Color.parseColor("#1E88E5"),
        Color.parseColor("#4F3384CB"),Color.parseColor("#00ACC1"))
    init {
        val drawable = GradientDrawable()
        drawable.cornerRadius = resources.getDimensionPixelSize(R.dimen.corner_radius).toFloat()
        background = drawable
        setColor()
        setOnClickListener{
            currentColorIndex = (currentColorIndex +1) % 3
            setColor()
        }
    }

    private fun setColor(){
        (background as GradientDrawable).setColor(colors[currentColorIndex])
    }
}