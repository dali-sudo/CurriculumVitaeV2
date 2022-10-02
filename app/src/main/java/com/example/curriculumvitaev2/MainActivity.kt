package com.example.curriculumvitaev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.Toast

lateinit var name:TextView
lateinit var Oname:TextInputLayout
lateinit var email:TextView
lateinit var Oemail:TextInputLayout
lateinit var age:TextView
lateinit var Oage:TextInputLayout
lateinit var nextButton: Button
lateinit var male: RadioButton
lateinit var female: RadioButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = findViewById<TextView>(R.id.nameTV)
        email = findViewById<TextView>(R.id.emailTV)
        age = findViewById<TextView>(R.id.ageTV)
        Oname =findViewById<TextInputLayout>(R.id.NameOutlinedTextField)
        Oemail =findViewById<TextInputLayout>(R.id.EmailOutlinedTextField)
        Oage =findViewById<TextInputLayout>(R.id.AgeoutlinedTextField)
        nextButton =findViewById<Button>(R.id.next)
        male= findViewById<RadioButton>(R.id.homme)
        female= findViewById<RadioButton>(R.id.femme)

        nextButton!!.setOnClickListener() {

         if (valid())
         {
             Toast.makeText(this, "done", Toast.LENGTH_SHORT).show()

             lateinit var gender: String
             if (male!!.isChecked)
             {
                 gender="male"
             } else gender ="female"

            val intent = Intent(this, skills::class.java)
             intent.putExtra("Name", name!!.text.toString())
             intent.putExtra("Email", email!!.text.toString())
             intent.putExtra("Age", age!!.text.toString())
             intent.putExtra("Gender", gender)
             startActivity(intent)

         }


        }












    }



}
fun valid():Boolean
{  var x=0;
    if ( name!!.text.isEmpty() )

    {
        Oname?.error = " Must be not Empty !!"

    }
    else {
        x++
        Oname?.error = null
    };

    if (email!!.text.isEmpty())
    {
        Oemail?.error = " Must be not Empty !!"

    }
    else if (!EMAIL_ADDRESS.matcher(email?.text!!).matches())

    {
        Oemail?.error = " Check your Email format !!"

    }

    else {
        x++
        Oemail?.error = null
    };


    if (age!!.text.isEmpty())
    {
        Oage?.error = " Must be not Empty !!"
    }

    else  { x++
        Oage?.error = null
    }


    return x.equals(3);
}