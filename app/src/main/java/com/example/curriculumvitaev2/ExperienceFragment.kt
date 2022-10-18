package com.example.curriculumvitaev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExperienceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExperienceFragment : Fragment(R.layout.fragment_experience) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {






   var ExpList: List<ExperienceData>

   ExpList= listOf(
       ExperienceData(R.drawable.fb,"Facebook","France","Heeloooooooooooooooooooooooooooooooooooooooooooo"),
       ExperienceData(R.drawable.instagram,"Instagram","Nvm","Heeloooooooooooooooooooooooooooooooooooooooooooo"),
       ExperienceData(R.drawable.twit,"Twitter","IDK","Heeloooooooooooooooooooooooooooooooooooooooooooo"),
       ExperienceData(R.drawable.logo_esprit_ariana,"Esprit","idkk","Heeloooooooooooooooooooooooooooooooooooooooooooo")

   )


        // Inflates the custom fragment layout
        val view: View = inflater.inflate(R.layout.fragment_experience, container, false)
        val recyclerview = view?.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview?.layoutManager = LinearLayoutManager(context)
        val adapter = AdapterE(ExpList)
        recyclerview?.adapter=adapter
        // Finds the TextView in the custom fragment


        // Gets the data from the passed bundle

        // Sets the derived data (type String) in the TextView


        return view
    }
}