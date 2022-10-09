package com.example.curriculumvitaev2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar


class SkillsFragment : Fragment(R.layout.fragment_skills) {

private lateinit var android: SeekBar
private lateinit var flutter: SeekBar
private lateinit var ios: SeekBar
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        // Inflates the custom fragment layout
        val view: View = inflater.inflate(R.layout.fragment_skills, container, false)

        // Finds the TextView in the custom fragment
        android = view.findViewById<SeekBar>(R.id.androidSeekbar)
        flutter = view.findViewById<SeekBar>(R.id.flutterSeekbar)
        ios = view.findViewById<SeekBar>(R.id.ios_seekbar)

        // Gets the data from the passed bundle
        val bundle = arguments
        val Aprog = bundle!!.getInt("and")
        val Iprog = bundle!!.getInt("ios")
        val prog = bundle!!.getInt("flutter")

        // Sets the derived data (type String) in the TextView
        android.progress =Aprog
        flutter.progress =prog
        ios.progress =Iprog

        return view
    }


}