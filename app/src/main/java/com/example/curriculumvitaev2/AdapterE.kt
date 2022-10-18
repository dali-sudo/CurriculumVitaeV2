package com.example.curriculumvitaev2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterE (private var mList: List<ExperienceData>) : RecyclerView.Adapter<AdapterE.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.experience_card ,parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.compName.text = ItemsViewModel.CompanyName
        holder.compAdress.text = ItemsViewModel.CompanyAdress
        holder.desc.text = ItemsViewModel.Description

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.myImageView)
        val compName: TextView = itemView.findViewById(R.id.CompanyNameTV)
        val compAdress: TextView = itemView.findViewById(R.id.CompanyAdressTv)
        val desc: TextView = itemView.findViewById(R.id.DescTV)
    }
}