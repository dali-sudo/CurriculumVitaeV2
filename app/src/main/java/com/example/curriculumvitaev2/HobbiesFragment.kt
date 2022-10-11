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
           "Music"  -> music.setChecked(true)
           "Sport"  -> sport.setChecked(true)
           "Games"  -> games.setChecked(true)
           "Music Sport Games" -> {
               music.setChecked(true)
               sport.setChecked(true);
               games.setChecked(true);
           }

           "Sport Games" -> {
               sport.setChecked(true)
               games.setChecked(true)
           }
           "Sport Music" ->  {
               sport.setChecked(true)
                      music.setChecked(true)
           }
           "Games Music " ->  {
               games.setChecked(true)
               music.setChecked(true)
           }
       }


        return view
    }


}