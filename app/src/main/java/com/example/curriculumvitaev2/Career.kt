package com.example.curriculumvitaev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculumvitaev2.utils.AppDataBase
import com.google.android.material.appbar.MaterialToolbar
import kotlin.system.exitProcess



class Career : AppCompatActivity() {
    val EF=ExperienceFragment()
    val EE= EducationFragment()
    lateinit var toolbar: MaterialToolbar
    private lateinit var expBut: Button
    private lateinit var edubut:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        dataBase = AppDataBase.getDatabase(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_career)
        expBut = findViewById(R.id.ExperienceButton)
        edubut = findViewById(R.id.EducationButton)
        toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)


        supportFragmentManager.beginTransaction().apply {

            replace(R.id.fr,EF)
            commit()
        }

    expBut.setOnClickListener{
        supportFragmentManager.beginTransaction().apply {

            replace(R.id.fr, EF)
            commit()

        }
    }

        edubut.setOnClickListener {
            println("Button Works***************************************")
            supportFragmentManager.beginTransaction().apply {

                replace(R.id.fr, EE)
                commit()
            }
        }
         toolbar.setNavigationOnClickListener {

             finish()

         }
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.AddEduItem -> {
                    // Handle favorite icon press
                    val intent = Intent(this, AddEducation::class.java)

                    startActivityForResult(intent,10001)
                    true
                }
                R.id.Logout -> {
                    // Handle favorite icon press
                    val sharedPreferences = getSharedPreferences("sharedPrefs", 0)
                    sharedPreferences.edit().clear().commit()

                    exitProcess(0)
                    true
                }
                R.id.AddCompItem -> {
                    // Handle favorite icon press
                    val intent = Intent(this, AddExperience::class.java)

                    startActivityForResult(intent,10002)
                    true
                }


                else -> false
            }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode == 10001) && (resultCode == 10001) ){
            supportFragmentManager.beginTransaction().apply {

                replace(R.id.fr, EE)
                commit()
            }
        }
        if ((requestCode == 10002) && (resultCode == 10002) ){
            supportFragmentManager.beginTransaction().apply {

                replace(R.id.fr, EF)
                commit()
            }
        }
    }


}




