package com.example.challange40

import android.util.Log

class Controller(var callBack: CallBack) {

    fun checkPemenang(player1: String, type: Boolean) {
        var suit = mutableListOf("Batu", "Gunting", "Kertas")
        var player2 = suit.random()

        Log.d("Pilihan 1", player1)
        Log.d("Pilihan 2", player2)

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
            Log.d("RESULT", "$player1 WIN ")

        } else {
            callBack.resultSuit(R.drawable.draw, player2)
            Log.d("RESULT", "DRAW $player1 == $player2 ")

        }
    }
}