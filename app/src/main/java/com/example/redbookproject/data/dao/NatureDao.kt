package com.example.redbookproject.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.redbookproject.data.model.Nature

@Dao
interface NatureDao{
    @Query("SELECT * FROM book WHERE type = :type")
    fun getAllNature(type: Int): List<Nature>

    @Query("SELECT * FROM book WHERE id = :id")
    fun getSelectedNature(id: Int): Nature

    @Query("SELECT * FROM book WHERE type = :type and (nameEng like :word or nameUzb like :word or nameRus like :word)")
    fun searchNatureByName(type: Int, word: String): List<Nature>
}
