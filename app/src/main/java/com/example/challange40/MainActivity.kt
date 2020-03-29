package com.example.challange40

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import kotlin.system.exitProcess

const val TAG = "MainActivity"


class MainActivity : AppCompatActivity(), CallBack {
    private lateinit var playName: String

    var view1: View? = null
    var view2: View? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playName = intent.extras?.getString(PLAYER_NAME).toString().capitalize()

        var dataChoosen = mutableListOf<String>()
        var idGambar = mutableListOf(batuPlayer1, kertasPlayer1, guntingPlayer1)
        var suit = mutableListOf("Batup1", "Guntingp1", "Kertasp1")
        var suit2 = mutableListOf("Batup2", "Guntingp2", "Kertasp2")
        var state = true
        var player = ""


        var controller = Controller(this)

        for (id in idGambar) {
            id.setOnClickListener {
                if (state) {
                    var player2 = suit2.random()
                    dataChoosen.add(player2)
                    state = false
                    view1 = id
                    var index = id.contentDescription.toString().toInt()
                    player = suit[index]
                    dataChoosen.add(player)
                    id.setBackgroundColor(getColor(R.color.colorAccent))
                    controller.checkPemenang(dataChoosen)
                } else {
                    Toast.makeText(this, "Reset dulu mazz", Toast.LENGTH_SHORT).show()
                }
            }
        }

        reset.setOnClickListener {
            player = ""
            state = true
            dataChoosen.clear()
            view1?.setBackgroundColor(getColor(android.R.color.transparent))
            view2?.setBackgroundColor(getColor(android.R.color.transparent))
            versus.setImageResource(R.drawable.vs)
            view1 = null
            view2 = null
        }

        home.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            intent.putExtra(PLAYER_NAME, playName)
            startActivity(intent)
            finishAffinity()
        }

        logout.setOnClickListener {
            val alertDialog = this.let {
                val builder = AlertDialog.Builder(it)
                builder.apply {
                    setPositiveButton("OK") { _, _ ->
                        finishAffinity()
                    }
                    setNegativeButton("CANCEL") { dialog, _ ->
                        dialog.cancel()
                    }
                    setTitle("KELUAR")
                    setMessage("Serius nih mau keluar?")
                }

                builder.create()

            }
            alertDialog.show()
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
