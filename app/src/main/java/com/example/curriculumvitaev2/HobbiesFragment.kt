package com.example.curriculumvitaev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.SeekBar

class HobbiesFragment : Fragment(R.layout.fragment_hobbies) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        // Inflates the custom fragment layout
        val view: View = inflater.inflate(R.layout.fragment_hobbies, container, false)
        lateinit  var music: CheckBox
        lateinit  var sport: CheckBox
        lateinit  var games: CheckBox
        // Finds the TextView in the custom fragment

        music=view.findViewById<CheckBox>(R.id.musicCheckbox)
        sport=view.findViewById<CheckBox>(R.id.sportCheckbox)
        games=view.findViewById<CheckBox>(R.id.gameCheckbox)

        // Gets the data from the passed bundle
        val bundle = arguments
        val hoby = bundle!!.getString("hoby")


        // Sets the derived data (type String) in the TextView
       when (hoby) {
           "Music"  -> music.isChecked
           "Sport"  -> sport.isChecked
           "Games"  -> games.isChecked
           "Music Sport Games" -> music.isChecked &&  sport.isChecked && games.isChecked
           "Sport Games" ->  sport.isChecked && games.isChecked
           "Sport Music" ->  sport.isChecked && music.isChecked
           "Games Music " ->  games.isChecked && music.isChecked
       }


        return view
    }


}