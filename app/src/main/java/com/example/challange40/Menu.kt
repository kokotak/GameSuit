package com.example.challange40

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {
    private lateinit var playName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        playName = intent.extras?.getString(PLAYER_NAME).toString().capitalize()
        txtPlayer.text = "$playName VS PLAYER"
        txtBOT.text = "$playName VS CPU"

        imgPlayer.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra(PLAYER_NAME, playName)
            startActivity(intent)
            Log.d("MENU", "Player $playName beranda")
        }

        imgBOT.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(PLAYER_NAME, playName)
            startActivity(intent)
            Log.d("MENU", "BOT $playName beranda")
        }

    }
}
