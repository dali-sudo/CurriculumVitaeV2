package com.example.curriculumvitaev2.utils

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import com.example.curriculumvitaev2.dao.CompanyDAO
import com.example.curriculumvitaev2.dao.UniversityDAO
import com.example.curriculumvitaev2.data.Company
import com.example.curriculumvitaev2.data.University


@Database(
    entities = [Company::class,University::class],
    version = 4,

   )
abstract class AppDataBase :RoomDatabase() {


    abstract fun CompanyDAO(): CompanyDAO
    abstract fun UniversityDAO(): UniversityDAO

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, AppDataBase::class.java, "Curriculum")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return instance!!
        }
    }


}