package com.example.curriculumvitaev2

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.google.android.material.textfield.TextInputLayout
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

lateinit var name:TextView
lateinit var Oname:TextInputLayout
lateinit var email:TextView
lateinit var Oemail:TextInputLayout
lateinit var age:TextView
lateinit var Oage:TextInputLayout
lateinit var nextButton: Button
lateinit var male: RadioButton
lateinit var female: RadioButton
lateinit var profileview : ImageView


class MainActivity : AppCompatActivity() {
    private val pickImage = 100
    private var imageUri: Uri? = null
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

        nextButton.setOnClickListener() {

         if (valid())
         {
             Toast.makeText(this, "done", Toast.LENGTH_SHORT).show()

             lateinit var gender: String
             if (male.isChecked)
             {
                 gender="male"
             } else gender ="female"

            val intent = Intent(this, skills::class.java)
             intent.putExtra("Name", name.text.toString())
             intent.putExtra("Email", email.text.toString())
             intent.putExtra("Age", age.text.toString())
             intent.putExtra("Gender", gender)
             intent.putExtra("imageURI",imageUri)
             startActivity(intent)

         }


        }
        profileview= findViewById<ImageView>(R.id.imageView)
        profileview.setOnClickListener() {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)

        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            profileview.setImageURI(imageUri)
        }
    }



}
fun valid():Boolean
{  var x=0;
    if ( name.text.isEmpty() )

    {
        Oname.error = " Must be not Empty !!"

    }
    else {
        x++
        Oname.error = null
    };

    if (email.text.isEmpty())
    {
        Oemail.error = " Must be not Empty !!"

    }
    else if (!EMAIL_ADDRESS.matcher(email.text!!).matches())

    {
        Oemail.error = " Check your Email format !!"

    }

    else {
        x++
        Oemail.error = null
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