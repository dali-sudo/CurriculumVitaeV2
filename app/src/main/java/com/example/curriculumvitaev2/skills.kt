package com.example.curriculumvitaev2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.Toast


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
lateinit private var rememberMe:CheckBox
const val ANDROID_PROGRESS ="ANDROID_PROGRESS"
const val IOS_PROGRESS ="IOS_PROGRESS"
const val FLUTTER_PROGRESS ="FLUTTER_PROGRESS"
const val EN ="ENGLISH"
const val FR ="FRENCH"
const val AR ="ARABIC"
const val MUSIC ="MUSIC"
const val SPORT ="SPORT"
const val GAME ="GAME"
const val REMEMBERME ="RememeberMe"

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
        rememberMe=findViewById<CheckBox>(R.id.rememberMeCheckbox)
        SubmitButton= findViewById<Button>(R.id.SUBMIT)
        loadData()


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




                saveData()




            Myintent.putExtra("Name", name)
            Myintent.putExtra("Age", age)
            Myintent.putExtra("Email", mail)
            Myintent.putExtra("Gender", gender)
            Myintent.putExtra("Android", androidSB.progress)
            Myintent.putExtra("iOS", iosSB.progress)
            Myintent.putExtra("Flutter", flutterSB.progress)
            Myintent.putExtra("Language", langue)
            Myintent.putExtra("Hobbies", hobbies)

            startActivity(Myintent)
        }




    }

    private fun saveData() {
    val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putBoolean(REMEMBERME, rememberMe.isChecked)
            putInt(ANDROID_PROGRESS,androidSB.progress)
            putInt(IOS_PROGRESS,iosSB.progress)
            putInt(FLUTTER_PROGRESS,flutterSB.progress)
            putBoolean(MUSIC,music.isChecked)
            putBoolean(GAME, game.isChecked)
            putBoolean(SPORT,sport.isChecked)
            putBoolean(EN, english.isChecked)
            putBoolean(FR, french.isChecked)
            putBoolean(AR, arabic.isChecked)

        }.apply()

        if (rememberMe.isChecked){

            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
        }


    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedAndProgress = sharedPreferences.getInt(ANDROID_PROGRESS, 0)
        val savediosProgress = sharedPreferences.getInt(IOS_PROGRESS, 0)
        val savedflutterProgress = sharedPreferences.getInt(FLUTTER_PROGRESS, 0)

        val savedMusic = sharedPreferences.getBoolean(MUSIC,false)
        val savedSport = sharedPreferences.getBoolean(SPORT,false)
        val savedGame = sharedPreferences.getBoolean(GAME,false)
        val savedEnglish= sharedPreferences.getBoolean(EN,false)
        val savedFrench= sharedPreferences.getBoolean(FR,false)
        val savedArabic= sharedPreferences.getBoolean(AR,false)

if (sharedPreferences.getBoolean(REMEMBERME,false))
{
    if(savedEnglish )  {

        english.isChecked=true
    }
     if (savedArabic) {
        arabic.isChecked=true
    }
    if(savedFrench) {
        french.isChecked=true
    }


        if(savedGame)
        {
            game.isChecked=true
        }
        if(savedMusic)
        {
            music.isChecked=true
        }
     if(savedSport) {
        sport.isChecked=true
        }

        flutterSB.progress=savedflutterProgress
        iosSB.progress=savediosProgress
        androidSB.progress=savedAndProgress




    }
    }
}