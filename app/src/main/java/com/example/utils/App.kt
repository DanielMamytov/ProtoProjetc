package com.example.utils

import android.app.Application
import androidx.room.Room
import com.example.hw3android2.AppDatabase
private const val DATABASE_NAME = "note-database"
class App : Application() {
    companion object {
        lateinit var db: AppDatabase
        private set
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

}