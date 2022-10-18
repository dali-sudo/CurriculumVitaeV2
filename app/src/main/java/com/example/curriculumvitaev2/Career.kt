package com.example.curriculumvitaev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button



class Career : AppCompatActivity() {
    val EF=ExperienceFragment()
    private lateinit var expBut: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        //  expBut = findViewById(R.id.ExperienceButton)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career)


        supportFragmentManager.beginTransaction().apply {

            replace(R.id.fr,EF)
            commit()
        }



    }



}
