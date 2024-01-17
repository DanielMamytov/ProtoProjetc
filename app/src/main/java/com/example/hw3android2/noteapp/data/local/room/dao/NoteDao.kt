package com.example.hw3android2.noteapp.data.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.hw3android2.noteapp.data.local.room.dao.entities.Note

@Dao
interface NoteDao {
    //Получение всех даных:
    @Query("SELECT * FROM note_table")
    fun getAllNotes(): List<Note>

    //Добавление:
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note: Note)
    //Добавление нескольких моделек:
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNotes(notes: List<Note>)
    //Обновить данные:
    @Update
    fun updateNote(note: Note)

    //Удаление база данных:
    @Delete
    fun deleteNote(note: Note)
    
}