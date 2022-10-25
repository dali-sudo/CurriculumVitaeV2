package com.example.curriculumvitaev2.data

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.DatabaseView
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class University ( @PrimaryKey(autoGenerate = true)
                        var id: Int,

                        @ColumnInfo(name = PICTURE)
                        val uniPic: String,

                        @ColumnInfo(name = "UNIVERSITY_NAME")
                        val uniName: String,

                        @ColumnInfo(name = "UNIVERSITY_ADRESS")
                        val uniAdress: String


        )