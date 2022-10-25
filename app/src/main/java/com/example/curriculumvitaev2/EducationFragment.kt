package com.example.curriculumvitaev2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculumvitaev2.data.University


class EducationFragment : Fragment(R.layout.fragment_education){
    companion object {
         lateinit var UniList:MutableList<University>
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {



UniList=  dataBase.UniversityDAO().getAllComp().toMutableList()


        var EducList: List<EducationData>

        EducList= listOf(

            EducationData(R.drawable.ic_logo_microsoft,"99/10/2000","99/10/2000","microsoft","nbm"),
            EducationData(R.drawable.ic_logo_massachusetts,"99/10/2000","99/10/2000","massachusetts","nbm"),
            EducationData(R.drawable.ic_logo_stanford,"99/10/2000","99/10/2000","stanford","nbm"),
            EducationData(R.drawable.ic_logo_amazon,"99/10/2000","99/10/2000","amazon","nbm"),
            EducationData(R.drawable.ic_logo_cambridge,"99/10/2000","99/10/2000","cambridge","nbm"),
            EducationData(R.drawable.ic_logo_esprit,"99/10/2000","99/10/2000","esprit","nbm"),
            EducationData(R.drawable.ic_logo_facebook,"99/10/2000","99/10/2000","facebook","nbm"),
            EducationData(R.drawable.ic_logo_linkedin,"99/10/2000","99/10/2000","linkedin","nbm"),
            EducationData(R.drawable.ic_logo_oxford,"99/10/2000","99/10/2000","oxford","nbm"),
            EducationData(R.drawable.ic_logo_google,"99/10/2000","99/10/2000","google","nbm"),


        )


        // Inflates the custom fragment layout
        val view: View = inflater.inflate(R.layout.fragment_education, container, false)
        val recyclerview = view?.findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview?.layoutManager = LinearLayoutManager(context)
        val adapter = AdapterEducation(UniList)
        recyclerview?.adapter=adapter


        // Finds the TextView in the custom fragment


        // Gets the data from the passed bundle

        // Sets the derived data (type String) in the TextView


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = view?.findViewById<RecyclerView>(R.id.recyclerview)



        UniList=  dataBase.UniversityDAO().getAllComp().toMutableList()



        val adapter = AdapterEducation(UniList)
        recyclerview?.adapter=adapter
        recyclerview?.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL ,false)

    }



}