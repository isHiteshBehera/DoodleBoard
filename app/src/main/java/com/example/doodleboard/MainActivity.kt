package com.example.doodleboard

import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object {
        var path = Path()
        var stylusNib = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var redBtn = findViewById<ImageButton>(R.id.redColor);
        var blueBtn = findViewById<ImageButton>(R.id.blueColor);
        var blackBtn = findViewById<ImageButton>(R.id.blackColor);
        var eraserBtn = findViewById<ImageButton>(R.id.whiteColor);

        redBtn.setOnClickListener {
            Toast.makeText(this, "Clicked Red", Toast.LENGTH_SHORT).show()
        }

        blueBtn.setOnClickListener {
            Toast.makeText(this, "Clicked Blue", Toast.LENGTH_SHORT).show()
        }

        blackBtn.setOnClickListener {
            Toast.makeText(this, "Clicked Black", Toast.LENGTH_SHORT).show()
        }

        eraserBtn.setOnClickListener {
            Toast.makeText(this, "Clicked Eraser", Toast.LENGTH_SHORT).show()
        }
    }
}