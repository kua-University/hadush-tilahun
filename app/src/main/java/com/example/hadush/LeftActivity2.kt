package com.example.hadush

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LeftActivity2: AppCompatActivity() {

    private lateinit var mediaPlayer1: MediaPlayer
    private lateinit var mediaPlayer3: MediaPlayer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_left2)

        mediaPlayer1 = MediaPlayer.create(this, R.raw.angergary)
        mediaPlayer3 = MediaPlayer.create(this, R.raw.tedros)

        val button1 = findViewById<Button>(R.id.xxx)
        val button3 = findViewById<Button>(R.id.bu)
        val backButton = findViewById<ImageView>(R.id.backButtonn)


        // Audio Button 1
        button1.setOnClickListener {
            if (mediaPlayer1.isPlaying) {
                mediaPlayer1.pause()
                button1.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.aaa, 0, 0, 0)  // Update drawable
            } else {
                mediaPlayer1.start()
                button1.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.bbb, 0, 0, 0)  // Update drawable
            }
        }

        // Audio Button 3
        button3.setOnClickListener {
            if (mediaPlayer3.isPlaying) {
                mediaPlayer3.pause()
                button3.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.aaa, 0, 0, 0)  // Update drawable
            } else {
                mediaPlayer3.start()
                button3.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.bbb, 0, 0, 0)  // Update drawable
            }
        }

        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer1.release()
        mediaPlayer3.release()
    }
}