package com.example.challange40

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_landing_page_c.*

/**
 * A simple [Fragment] subclass.
 */
class LandingPageC : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_landing_page_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_inputPlayerName.setOnClickListener {

            if (input_playerName.text.isNullOrEmpty()) {
                input_playerName.error = "Masukin nama woy"
                Toast.makeText(activity, "Masukin nama woy", Toast.LENGTH_SHORT).show()
            } else {
                val playName = input_playerName.text.toString()
                val intent = Intent(activity, Menu::class.java)
                intent.putExtra(PLAYER_NAME, playName)
                activity?.finish()
                startActivity(intent)
                Log.d(LANDING_PAGE, "Player $playName login")
            }

        }
    }

}
