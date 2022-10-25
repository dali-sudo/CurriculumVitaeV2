package com.example.curriculumvitaev2

import android.content.Intent.parseUri
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculumvitaev2.data.University
import org.w3c.dom.Text

lateinit var deleteBut:ImageView
class AdapterEducation(private var eList: MutableList<University>) : RecyclerView.Adapter<AdapterEducation.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterEducation.ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_education_card ,parent, false)
        deleteBut=view.findViewById(R.id.deleteIcon)

        return AdapterEducation.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterEducation.ViewHolder, position: Int) {

        val ItemsViewModel = eList[position]

        // sets the image to the imageview from our itemHolder class
      //  holder.imageView.setImageResource(ItemsViewModel.uniPic)

        // sets the text to the textview from our itemHolder class
        holder.compName.text = ItemsViewModel.uniName
        holder.StartDate.text = "ItemsViewModel.StartDate"
        holder.EndDate.text = "ItemsViewModel.EndDate"
        holder.compAdress.text = ItemsViewModel.uniAdress
        holder.imageView.setImageURI(Uri.parse(ItemsViewModel.uniPic))

        deleteBut.setOnClickListener()
        {

            dataBase.UniversityDAO().delete(eList[position])
            eList.removeAt(position)
            notifyDataSetChanged()
        }



    }

    override fun getItemCount(): Int {
        return eList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.EduPic)
        val StartDate: TextView = itemView.findViewById(R.id.EduStartDate)
        val EndDate: TextView = itemView.findViewById(R.id.EduEndDate)
        val compName: TextView = itemView.findViewById(R.id.EduName)
        val compAdress: TextView = itemView.findViewById(R.id.Eduaddress)


    }


}