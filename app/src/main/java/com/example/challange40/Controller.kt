package com.example.challange40

class Controller(var callBack: CallBack) {
    fun checkPemenang(player1: String, player2: String, type: Boolean) {
        var suit = mutableListOf("Batu","Gunting","Kertas")
        val typePlayer = if (type) {
            "Komputer"
        } else {
            "Player 2"
        }

        if (player1 == suit[1] && player2 == suit[0] ||
            player1 == suit[0] && player2 == suit[2] ||
            player1 == suit[2] && player2 == suit[1]
        ) {
            callBack.resultSuit(hasil = "Player 2 Menang")
        } else if (
            player1 == suit[1] && player2 == suit[2] ||
            player1 == suit[0] && player2 == suit[1] ||
            player1 == suit[2] && player2 == suit[1]
        ) {
            callBack.resultSuit(hasil = "Player 1 Menang")
        } else {
            callBack.resultSuit(hasil = "Draw")
        }
    }
}