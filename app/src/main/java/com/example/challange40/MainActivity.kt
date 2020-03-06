package com.example.challange40

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), CallBack {

    var view1 : View? = null
    var view2 : View? = null
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var idGambar = mutableListOf(batu, kertas, gunting)
        var suit = mutableListOf("Batu", "Gunting", "Kertas")
        var state = true
        var player = ""

        var controller = Controller(this)

        for (id in idGambar) {
            id.setOnClickListener {
                if (state) {
                    state = false
                    view1 = id
                    var index = id.contentDescription.toString().toInt()
                    player = suit[index]
                    id.setBackgroundColor(getColor(R.color.colorAccent))
                    controller.checkPemenang(player, true)
                } else {
                    Toast.makeText(this, "Reset dulu mazz", Toast.LENGTH_SHORT).show()
                }
            }
        }

        reset.setOnClickListener{
            player = ""
            state = true
            view1?.setBackgroundColor(getColor(android.R.color.transparent))
            view2?.setBackgroundColor(getColor(android.R.color.transparent))
            versus.setImageResource(R.drawable.vs)
            view1 = null
            view2 = null
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun resultSuit(hasil: Int, pilihanComputer: String) {
        if (pilihanComputer == "Batu") {
            batuCom.setBackgroundColor(getColor(R.color.colorAccent))
            view2 = batuCom
        } else if (pilihanComputer == "Gunting") {
            guntingCom.setBackgroundColor(getColor(R.color.colorAccent))
            view2 = guntingCom
        } else {
            kertasCom.setBackgroundColor(getColor(R.color.colorAccent))
            view2 = kertasCom
        }
        versus.setImageResource(hasil)
    }
}
