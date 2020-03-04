package com.example.challange40

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

const val  TAG = "MainActivity"
class MainActivity : AppCompatActivity(), CallBack {


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var idGambar = mutableListOf(batu,batuCom,kertas,kertasCom,gunting,guntingCom)
        var suit = mutableListOf("Batu","Gunting","Kertas")
        var state = false
        var player = ""
        var player2 = ""

        var controller = Controller(this)

        for (id in idGambar){
            id.setOnClickListener{
                if (state){
                    state = false

                    var index = id.contentDescription.toString().toInt()
                    player2 = suit[index]
                    id.setBackgroundColor(getColor(R.color.colorAccent))
                    controller.checkPemenang(player,player2,true)
                }else{
                    state = true

                    var index = id.contentDescription.toString().toInt()
                    player = suit[index]
                    id.setBackgroundColor(getColor(R.color.colorAccent))
                }
            }
        }

    }

    override fun resultSuit(hasil: String) {
        Toast.makeText(this,hasil,Toast.LENGTH_SHORT).show()
    }
}
