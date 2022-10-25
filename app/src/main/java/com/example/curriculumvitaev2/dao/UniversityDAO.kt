package com.example.curriculumvitaev2.dao

import androidx.room.*
import com.example.curriculumvitaev2.data.Company
import com.example.curriculumvitaev2.data.University


@Dao
interface UniversityDAO {
    @Insert
    fun insert(University : University)

    @Update
    fun upddate(University : University)

    @Delete
    fun delete(University : University)

    @Query("select * from University")
    fun getAllComp(): List<University>
}