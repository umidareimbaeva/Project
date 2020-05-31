package com.example.redbookproject.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.redbookproject.data.model.Nature

@Dao
interface NatureDao{
    @Query("SELECT * FROM book")
    fun getAllNature(): List<Nature>
}
