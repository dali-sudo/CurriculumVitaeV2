package com.example.curriculumvitaev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView


class rResumeFragment : Fragment(R.layout.fragment_r_resume) {
private lateinit var nametv:TextView
private lateinit var agetv:TextView
private lateinit var gendertv:TextView
private lateinit var mailtv:TextView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        // Inflates the custom fragment layout
        val view: View = inflater.inflate(R.layout.fragment_r_resume, container, false)

        // Finds the TextView in the custom fragment
        nametv = view.findViewById(R.id.name)
        mailtv = view.findViewById(R.id.email)
        agetv = view.findViewById(R.id.age)
        gendertv = view.findViewById(R.id.sexe)

        // Gets the data from the passed bundle
        val bundle = arguments
        val name = bundle!!.getString("name")
        val age = bundle!!.getString("age")
        val gender = bundle!!.getString("gender")
        val mail = bundle!!.getString("mail")


        // Sets the derived data (type String) in the TextView
        nametv.text="Hello my name is "+ name
        mailtv.text=mail
        agetv.text="i have " +age+ " years old"
        gendertv.text="and i am a " +gender
        gendertv.text=mail


        return view
    }


}