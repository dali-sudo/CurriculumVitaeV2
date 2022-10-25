package com.example.curriculumvitaev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout
import java.util.*

lateinit var compName: TextView
lateinit var OcompName: TextInputLayout
lateinit var compAdress: TextView
lateinit var OcompAdress: TextInputLayout

lateinit var compStartdate: TextView
lateinit var OcompStartdate: TextInputLayout
lateinit var compendDate: TextView
lateinit var OcompendDate: TextInputLayout
lateinit var AddCompButt: Button
lateinit var calendar: Calendar
class AddExperience : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_experience)
        calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)+1
        val day = calendar.get(Calendar.DAY_OF_MONTH)


        compName= findViewById(R.id.ExpNameTv)
        OcompName= findViewById(R.id.ExpNameOutlinedTextField)
        compAdress = findViewById(R.id.ExperienceAdressTv)
        OcompAdress = findViewById(R.id.AdressOutlinedTextField)
        compStartdate = findViewById(R.id.ExpStartDateTV)
        OcompStartdate = findViewById(R.id.ExpStartDateoutlinedTextField)
        compendDate = findViewById(R.id.ExpEndtDateTV)
        OcompendDate = findViewById(R.id.ExpEndtDateoutlinedTextField)
        AddCompButt= findViewById(R.id.addExp)

        compStartdate.text= day.toString()+ "/"+ month.toString() + "/" +year.toString()
        compendDate.text= day.toString()+ "/"+ month.toString() + "/" +year.toString()

        compStartdate.setOnClickListener{

            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())

                    .build()
            datePicker.addOnPositiveButtonClickListener {
                compStartdate.text= datePicker.headerText
            }

            datePicker.show(supportFragmentManager, "tag");



        }



        compendDate.setOnClickListener {

            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())

                    .build()
            datePicker.addOnPositiveButtonClickListener {
                compendDate.text= datePicker.headerText
            }

            datePicker.show(supportFragmentManager, "tag");




        }

        AddCompButt.setOnClickListener{

            if (validate()) {
                Toast.makeText(this, "Company Addedd!!!", Toast.LENGTH_SHORT).show()

            }


        }
    }

    fun validate():Boolean {
        var x=0;
        if (compName.text.isEmpty() )

        {
            OcompName.error = " Must be not Empty !!"

        }
        else {
            x++
            OcompName.error = null
        };

        if ( compAdress.text.isEmpty())
        {
            OcompAdress.error = " Must be not Empty !!"

        } else {
            x++
            OcompAdress.error = null
        };


        return x.equals(2);

    }



    }
