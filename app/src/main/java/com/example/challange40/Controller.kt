package com.example.challange40

import android.util.Log

class Controller(var callBack: CallBack) {


    fun checkPemenang(data: MutableList<String>) {
        var suit = mutableListOf("Batu", "Gunting", "Kertas")

        var player2Raw = data.find { it.contains("p2") }
        var player1Raw = data.find { it.contains("p1") }
        var player1 = player1Raw!!.replace("p1", "")
        var player2 = player2Raw!!.replace("p2", "")


        if (player1 == suit[0] && player2 == suit[2] ||
            player1 == suit[1] && player2 == suit[0] ||
            player1 == suit[2] && player2 == suit[1]
        ) {
            callBack.resultSuit(R.drawable.comwinner, player2)
            Log.d("RESULT", "$player2 WIN ")
        } else if (
            player1 == suit[0] && player2 == suit[1] ||
            player1 == suit[1] && player2 == suit[2] ||
            player1 == suit[2] && player2 == suit[0]
        ) {
            callBack.resultSuit(R.drawable.pemainwinner, player2)
            Log.d("RESULT", "$player1 WIN")

        } else {
            callBack.resultSuit(R.drawable.draw, player2)
            Log.d("RESULT", "DRAW $player1 == $player2 ")
        }
    }
}
