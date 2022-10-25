package com.example.curriculumvitaev2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.curriculumvitaev2.data.Company


@Dao
interface CompanyDAO {
    @Insert
    fun insert(company: Company)

    @Insert
    fun upddate(company: Company)

    @Insert
    fun delete(company: Company)

    @Query("select * from Company")
    fun getAllComp(): List<Company>
}