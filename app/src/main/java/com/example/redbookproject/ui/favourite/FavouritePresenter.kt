package com.example.redbookproject.ui.favourite

import com.example.redbookproject.data.dao.NatureDao
import com.example.redbookproject.data.model.Nature

class FavouritePresenter(private val dao: NatureDao) {
    private var setData: (models: List<Nature>) -> Unit = {
        println("")
    }

    fun setDataFunction(setData: (models:List<Nature>) -> Unit){
        this.setData = setData
    }

    fun isFavourite(isFavourite: Int){
        setData.invoke(dao.isFavourite(isFavourite))
    }
}