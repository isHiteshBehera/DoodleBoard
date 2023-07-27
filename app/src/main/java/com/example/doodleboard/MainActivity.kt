package com.example.doodleboard

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.doodleboard.DoodleView.Companion.currentInk

class MainActivity : AppCompatActivity() {

    companion object {
        var path = Path()
        var stylusNib = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val redBtn = findViewById<ImageButton>(R.id.redColor)
        val blueBtn = findViewById<ImageButton>(R.id.blueColor)
        val blackBtn = findViewById<ImageButton>(R.id.blackColor)
        val eraserBtn = findViewById<ImageButton>(R.id.whiteColor)

        redBtn.setOnClickListener {
            Toast.makeText(this, "Clicked Red", Toast.LENGTH_SHORT).show()
            stylusNib.color = Color.RED
            currentColor(stylusNib.color)
        }

        blueBtn.setOnClickListener {
            Toast.makeText(this, "Clicked Blue", Toast.LENGTH_SHORT).show()
            stylusNib.color = Color.BLUE
            currentColor(stylusNib.color)
        }

        blackBtn.setOnClickListener {
            Toast.makeText(this, "Clicked Black", Toast.LENGTH_SHORT).show()
            stylusNib.color = Color.BLACK
            currentColor(stylusNib.color)
        }

        eraserBtn.setOnClickListener {
            Toast.makeText(this, "Clicked Eraser", Toast.LENGTH_SHORT).show()
            stylusNib.color = Color.WHITE
            currentColor(stylusNib.color)
        }
    }

    private fun currentColor(color: Int) {
        currentInk = color
        path = Path()
    }

}