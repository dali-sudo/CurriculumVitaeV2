package com.example.curriculumvitaev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar


lateinit private var androidSB: SeekBar
lateinit private var iosSB: SeekBar
lateinit private var flutterSB: SeekBar
lateinit private var arabic: CheckBox
lateinit private var french: CheckBox
lateinit private var english: CheckBox
lateinit private var music: CheckBox
lateinit private var sport: CheckBox
lateinit private var game: CheckBox
lateinit private var SubmitButton: Button


class skills : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.skills)

        androidSB= findViewById<SeekBar>(R.id.androidSeekbar)
        iosSB= findViewById<SeekBar>(R.id.ios_seekbar)
        flutterSB= findViewById<SeekBar>(R.id.flutterSeekbar)
        arabic= findViewById<CheckBox>(R.id.arabicCheckbox)
        french= findViewById<CheckBox>(R.id.frenchCheckbox)
        english= findViewById<CheckBox>(R.id.englishCheckbox)
        music= findViewById<CheckBox>(R.id.musicCheckbox)
        sport= findViewById<CheckBox>(R.id.sportCheckbox)
        game= findViewById<CheckBox>(R.id.gameCheckbox)
        SubmitButton= findViewById<Button>(R.id.SUBMIT)

        val intent = intent
        val name = intent.getStringExtra("Name")
        val age = intent.getStringExtra("Age")
        val mail = intent.getStringExtra("Email")
        val gender = intent.getStringExtra("Gender")

        SubmitButton.setOnClickListener {

            val Myintent = Intent(this, resume::class.java)

            val langue = when {
                arabic.isChecked && french.isChecked && english.isChecked -> "Arabic French English"
                arabic.isChecked && french.isChecked -> "Arabic French"
                arabic.isChecked && english.isChecked -> "Arabic English"
                french.isChecked && english.isChecked -> "French English"
                arabic.isChecked -> "Arabic"
                french.isChecked -> "French"
                english.isChecked -> "English"

                else -> "None"
            }


            val hobbies = when {
            music.isChecked && sport.isChecked && game.isChecked -> "Music Sport Games"
            sport.isChecked && game.isChecked -> "Sport Games"
            sport.isChecked && music.isChecked -> "Sport Music"
            game.isChecked && music.isChecked -> "Games Music"

            music.isChecked -> "Music"
            sport.isChecked -> "Sport"
            game.isChecked -> "Games"

            else -> "None"
        }
            Myintent.putExtra("Name", name)
            Myintent.putExtra("Age", age)
            Myintent.putExtra("Email", mail)
            Myintent.putExtra("Gender", gender)
            Myintent.putExtra("Android", androidSB.progress.toString())
            Myintent.putExtra("iOS", iosSB.progress.toString())
            Myintent.putExtra("Flutter", flutterSB.progress.toString())
            Myintent.putExtra("Language", langue)
            Myintent.putExtra("Hobbies", hobbies)

            startActivity(Myintent)
        }

    }
    }
