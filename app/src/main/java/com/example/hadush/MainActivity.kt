package com.example.hadush


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private lateinit var leftButton1: Button
    private lateinit var leftButton2: Button
    private lateinit var rightButton1: Button
    private lateinit var rightButton2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize buttons using findViewById

        leftButton1 = findViewById(R.id.leftButton1)
        leftButton2 = findViewById(R.id.leftButton2)
        rightButton1 = findViewById(R.id.rightButton1)
        rightButton2 = findViewById(R.id.rightButton2)




        leftButton1.setOnClickListener {
            val intent = Intent(this, LeftActivity1::class.java)
            startActivity(intent)
        }

        leftButton2.setOnClickListener {
            val intent = Intent(this, LeftActivity2::class.java)
            startActivity(intent)
        }



        rightButton1.setOnClickListener {
            val intent = Intent(this, RightActivity1::class.java)
            startActivity(intent)
        }


        rightButton2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }



    }
}

