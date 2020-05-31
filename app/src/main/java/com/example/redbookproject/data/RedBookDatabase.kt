package com.example.redbookproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.redbookproject.data.dao.NatureDao
import com.example.redbookproject.data.model.Nature

@Database(entities = [Nature ::class], version = 1)
abstract class RedBookDatabase: RoomDatabase() {
    companion object{
        private lateinit var INSTANCE: RedBookDatabase

        fun getInstance(context: Context): RedBookDatabase =
            Room.databaseBuilder(
                context, RedBookDatabase ::class.java, "book-database.db"
            ).createFromAsset("").build()
    }
    abstract fun natureDao(): NatureDao
}