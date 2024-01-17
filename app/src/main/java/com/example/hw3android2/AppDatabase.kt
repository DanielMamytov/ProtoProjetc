package com.example.hw3android2

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.hw3android2.noteapp.data.local.room.converters.DateConverters
import com.example.hw3android2.noteapp.data.local.room.dao.NoteDao
import com.example.hw3android2.noteapp.data.local.room.dao.entities.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao

}