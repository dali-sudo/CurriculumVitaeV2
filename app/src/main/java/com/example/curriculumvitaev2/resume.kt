package com.example.curriculumvitaev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toolbar
import com.google.android.material.appbar.MaterialToolbar


lateinit var skillsButton: Button
lateinit var hobbiesButton: Button
lateinit var toolbar: MaterialToolbar
class resume : AppCompatActivity() {
   var skillsFragment =  SkillsFragment()
    val hobbiesFragment =  HobbiesFragment()
    val resFragment = rResumeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resume)


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

                else -> false
            }
        }



    }
}