package com.example.curriculumvitaev2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.Button
import android.widget.TextView
import android.widget.Toolbar
import com.google.android.material.appbar.MaterialToolbar
import kotlin.system.exitProcess


lateinit var skillsButton: Button
lateinit var hobbiesButton: Button
lateinit var careerBut: Button
lateinit var toolbar: MaterialToolbar
class resume : AppCompatActivity() {
   var skillsFragment =  SkillsFragment()
    val hobbiesFragment =  HobbiesFragment()
    val resFragment = rResumeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resume)

        careerBut= findViewById<Button>(R.id.CareerButton)
        skillsButton= findViewById<Button>(R.id.skillsBut)
        hobbiesButton= findViewById<Button>(R.id.hobbiesBut)
        toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)

        val intent = intent
        val name = intent.getStringExtra("Name")
        val age = intent.getStringExtra("Age")
        val mail = intent.getStringExtra("Email")
        val gender = intent.getStringExtra("Gender")
        val langue = intent.getStringExtra("Language")
        val hoby = intent.getStringExtra("Hobbies")
        val android = intent.getIntExtra("Android",0)
        val ios = intent.getIntExtra("iOS",0)
        val flutter = intent.getIntExtra("Flutter",0)





        careerBut.setOnClickListener {

            val intent = Intent(this, Career::class.java)
            startActivity(intent)


        }

        supportFragmentManager.beginTransaction().apply {
            val mBundle = Bundle()
            mBundle.putInt("and",android)
            mBundle.putInt("ios",ios)
            mBundle.putInt("flutter",flutter)
            skillsFragment.arguments=mBundle
            replace(R.id.flFragment,skillsFragment)
            commit()
        }


        skillsButton.setOnClickListener {

            val mBundle = Bundle()
            mBundle.putInt("and",android)
            mBundle.putInt("ios",ios)
            mBundle.putInt("flutter",flutter)
            skillsFragment.arguments=mBundle
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, skillsFragment)
                commit()

            }
        }
            hobbiesButton.setOnClickListener {
                val mBundle = Bundle()
                mBundle.putString("hoby",hoby)

                hobbiesFragment.arguments=mBundle


                supportFragmentManager.beginTransaction().apply {
              replace(R.id.flFragment,hobbiesFragment)
             commit()

                }




        }



        toolbar.setNavigationOnClickListener{

           finish()

        }
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.info -> {
                    // Handle favorite icon press
                    supportFragmentManager.beginTransaction().apply {


                        val mBundle = Bundle()
                        mBundle.putString("name",name)
                        mBundle.putString("age",age)
                        mBundle.putString("mail",mail)
                        mBundle.putString("gender",gender)

                        resFragment.arguments=mBundle


                        replace(R.id.flFragment, resFragment)
                        commit()

                    }

                    true
                }
                R.id.Logout -> {
                    // Handle favorite icon press
                    val sharedPreferences = getSharedPreferences("sharedPrefs", 0)
                    sharedPreferences.edit().clear().commit()

                    exitProcess(0)
                    true
                }


                else -> false
            }
        }



    }
}