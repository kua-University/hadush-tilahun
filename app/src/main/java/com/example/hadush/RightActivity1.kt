package com.example.hadush

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RightActivity1 : AppCompatActivity() {

    private lateinit var mediaPlayer1: MediaPlayer
    private lateinit var mediaPlayer3: MediaPlayer
    private lateinit var mediaPlayer4: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_right1)

        // Initialize MediaPlayer with audio files from res/raw
        mediaPlayer1 = MediaPlayer.create(this, R.raw.angergary) // Replace with actual file
        mediaPlayer3 = MediaPlayer.create(this, R.raw.tedros) // Replace with actual file
        mediaPlayer4 = MediaPlayer.create(this, R.raw.kidaasie) // Missing one fixed

        // Find buttons by their IDs
        val button1 = findViewById<Button>(R.id.button111)
        val button2 = findViewById<Button>(R.id.button222)
        val button3 = findViewById<Button>(R.id.button333)
        val button4 = findViewById<Button>(R.id.button444)
        val backButton = findViewById<ImageView>(R.id.backButton)

        // Set OnClickListeners for media buttons
        button1.setOnClickListener { toggleMediaPlayer(mediaPlayer1) }
        button2.setOnClickListener { toggleMediaPlayer(mediaPlayer3) }
        button3.setOnClickListener { toggleMediaPlayer(mediaPlayer3) }
        button4.setOnClickListener { toggleMediaPlayer(mediaPlayer3) }

        // Set OnClickListener for backButton
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close current activity
        }
    }

    private fun toggleMediaPlayer(mediaPlayer: MediaPlayer) {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            mediaPlayer.seekTo(0) // Rewind to the start
        } else {
            mediaPlayer.start()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        // Release MediaPlayer resources
        mediaPlayer1.release()
        mediaPlayer3.release()
        mediaPlayer4.release()
    }
}
