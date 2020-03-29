package com.example.challange40

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.batuPlayer1
import kotlinx.android.synthetic.main.activity_main.guntingPlayer1
import kotlinx.android.synthetic.main.activity_main.home
import kotlinx.android.synthetic.main.activity_main.kertasPlayer1
import kotlinx.android.synthetic.main.activity_main.logout
import kotlinx.android.synthetic.main.activity_main.reset
import kotlinx.android.synthetic.main.activity_main.versus
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity(), CallBack {

    private lateinit var playName: String

    var view1: View? = null
    var view2: View? = null


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        playName = intent.extras?.getString(PLAYER_NAME).toString().capitalize()

        var idGambar1 = mutableListOf(batuPlayer1, guntingPlayer1, kertasPlayer1)
        var idGambar2 = mutableListOf(batuPlayer2, guntingPlayer2, kertasPlayer2)
        var suit = mutableListOf("Batup1", "Guntingp1", "Kertasp1")
        var suit2 = mutableListOf("Batup2", "Guntingp2", "Kertasp2")
        var state1 = true
        var state2 = true
        var player1 = ""
        var player2 = ""
        var dataChoosen = mutableListOf<String>()

        var controller = Controller(this)



        for (id in idGambar1) {
            id.setOnClickListener {
                if (state1) {
                    state1 = false
                    view1 = id
                    var index = id.contentDescription.toString().toInt()
                    player1 = suit[index].toString()
                    dataChoosen.add(player1)
                    id.setBackgroundColor(getColor(R.color.colorAccent))
                    if (state1 == false && state2 == false) {
                        controller.checkPemenang(dataChoosen)
                    }
                } else {
                    Toast.makeText(this, "Reset dulu mazz", Toast.LENGTH_SHORT).show()
                }
            }
        }

        for (id in idGambar2) {
            id.setOnClickListener {
                if (state2) {
                    state2 = false
                    view2 = id
                    var index = id.contentDescription.toString().toInt()
                    player2 = suit2[index].toString()
                    dataChoosen.add(player2)
                    id.setBackgroundColor(getColor(R.color.colorAccent))
                    if (state1 == false && state2 == false) {
                        controller.checkPemenang(dataChoosen)
                    }
                } else {
                    Toast.makeText(this, "Reset dulu mazz", Toast.LENGTH_SHORT).show()
                }
            }
        }

        reset.setOnClickListener {
            player1 = ""
            dataChoosen.clear()
            state1 = true
            state2 = true
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
            batuPlayer2.setBackgroundColor(getColor(R.color.colorAccent))
            view2 = batuPlayer2
        } else if (pilihanComputer == "Gunting") {
            guntingPlayer2.setBackgroundColor(getColor(R.color.colorAccent))
            view2 = guntingPlayer2
        } else {
            kertasPlayer2.setBackgroundColor(getColor(R.color.colorAccent))
            view2 = kertasPlayer2
        }
        versus.setImageResource(hasil)
    }
}
