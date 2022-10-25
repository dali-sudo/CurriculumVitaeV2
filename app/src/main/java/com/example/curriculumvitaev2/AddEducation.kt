package com.example.curriculumvitaev2

import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculumvitaev2.data.University
import com.example.curriculumvitaev2.utils.AppDataBase
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout
import com.nostra13.universalimageloader.core.ImageLoader
import java.lang.Exception
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

lateinit var uniName:TextView
lateinit var OuniName:TextInputLayout
lateinit var uniAdress:TextView
lateinit var OuniAdress:TextInputLayout

lateinit var startdate: TextView
lateinit var OstartDate: TextInputLayout
lateinit var endDate: TextView
lateinit var OendDate: TextInputLayout
lateinit var AddBut: Button
lateinit var EduImage: ImageView
lateinit var c: Calendar
lateinit var dataBase : AppDataBase
lateinit var image:String


class AddEducation : AppCompatActivity() {
    private val pickImage = 100
    private var imageUri: Uri? = null
companion object {
    var test= false
}
    override fun onCreate(savedInstanceState: Bundle?) {

c= Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)+1
        val day = c.get(Calendar.DAY_OF_MONTH)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_education)

        dataBase= AppDataBase.getDatabase(this)
        OstartDate =  findViewById<TextInputLayout>(R.id.StartDateoutlinedTextField)
        startdate =  findViewById<TextView>(R.id.StartDateTV)
        OendDate =  findViewById<TextInputLayout>(R.id.EndtDateoutlinedTextField)
        endDate =  findViewById<TextView>(R.id.EndtDateTV)
        uniAdress= findViewById(R.id.AdressTv)
        uniName= findViewById(R.id.nameTV)
        OuniName= findViewById(R.id.NameOutlinedTextField)
        OuniAdress= findViewById(R.id.AdressOutlinedTextField)
        AddBut = findViewById(R.id.addEdu)
        EduImage = findViewById(R.id.EducationImage)








        startdate.text= day.toString()+ "/"+ month.toString() + "/" +year.toString()
        endDate.text= day.toString()+ "/"+ month.toString() + "/" +year.toString()


        startdate.setOnClickListener{
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())

                    .build()
            datePicker.addOnPositiveButtonClickListener {
                startdate.text= datePicker.headerText
            }

            datePicker.show(supportFragmentManager, "tag");


        }
        endDate.setOnClickListener{
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())

                    .build()
            datePicker.addOnPositiveButtonClickListener {
                endDate.text= datePicker.headerText
            }

            datePicker.show(supportFragmentManager, "tag");


        }


        EduImage.setOnClickListener() {
            val gallery = Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)

        }

AddBut.setOnClickListener{

    if (validate()) {
        var university: University?=null

        val name = uniName.text.toString()
        val adress = uniAdress.text.toString()

        university= University(0, image, name,adress)
        try {

            dataBase.UniversityDAO().insert(university!!)
            setResult(10001)
            finish()



        }
    catch (ex:Exception) {
        Toast.makeText(this, "could not add the university !", Toast.LENGTH_SHORT).show()
        println("**************************"+ex)
    }



        Toast.makeText(this, "education added!!", Toast.LENGTH_SHORT).show()




    }
}

    }  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            getContentResolver().takePersistableUriPermission( imageUri!!,Intent.FLAG_GRANT_READ_URI_PERMISSION)
            EduImage.setImageURI(imageUri)
            image= imageUri.toString()

        }
    }





    fun validate(): Boolean {
         var x=0;
         if ( uniName.text.isEmpty() )

         {
             OuniName.error = " Must be not Empty !!"

         }
         else {
             x++
             OuniName.error = null
         };

         if ( uniAdress.text.isEmpty())
         {
             OuniAdress.error = " Must be not Empty !!"

         } else {
             x++
             OuniAdress.error = null
         };


         return x.equals(2);

    }
}