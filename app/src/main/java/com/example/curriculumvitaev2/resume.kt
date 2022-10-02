package com.example.curriculumvitaev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class resume : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resume)

        val intent = intent
        val name = intent.getStringExtra("Name")
        val age = intent.getStringExtra("Age")
        val mail = intent.getStringExtra("Email")
        val gender = intent.getStringExtra("Gender")
        val android = intent.getStringExtra("Android")
        val ios = intent.getStringExtra("iOS")
        val flutter = intent.getStringExtra("Flutter")
        val languages = intent.getStringExtra("Language")
        val hobbies = intent.getStringExtra("Hobbies")

        findViewById<TextView>(R.id.name).text="Name:$name"
        findViewById<TextView>(R.id.mail).text="Email:$age"
        findViewById<TextView>(R.id.age).text="Age:$mail"
        findViewById<TextView>(R.id.gender).text="Gender:$gender"
        findViewById<TextView>(R.id.androidSkill).text="AndroidSkill:$android"
        findViewById<TextView>(R.id.iosSkill).text="iosSkill:$ios"
        findViewById<TextView>(R.id.flutterSkill).text="flutterSKILL:$flutter"
        findViewById<TextView>(R.id.Langues).text="Languages:$languages"
        findViewById<TextView>(R.id.hobbies).text="Hobbies:$hobbies"
    }
}