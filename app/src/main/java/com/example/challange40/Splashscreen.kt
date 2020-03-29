package com.example.challange40

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splashscreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val mediaPlayer = MediaPlayer.create(this, R.raw.okaeri )
        mediaPlayer.start()

        Handler().postDelayed({
            val intent = Intent(this, LandingPage::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}


