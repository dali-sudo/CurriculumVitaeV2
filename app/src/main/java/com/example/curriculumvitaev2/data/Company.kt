package com.example.curriculumvitaev2.data

import androidx.room.*

const val PICTURE ="PICTURE"
const val COMPANY_NAME="COMPANY_NAME"
const val COMPANY_ADRESS="COMPANY_ADRESS"
const val COMPANY_STARTDATE ="COMPANY_STARTDATE"
const val COMPANY_ENDDATE ="COMPANY_ENDDATE"

@Entity
data class Company (   @PrimaryKey(autoGenerate = true)
                       val id: Int,

                       @ColumnInfo(name = PICTURE)
                       val compPic: Int,

                       @ColumnInfo(name = COMPANY_NAME)
                       val compName: String,

                       @ColumnInfo(name = COMPANY_ADRESS)
                       val compAdress: String



                       )
