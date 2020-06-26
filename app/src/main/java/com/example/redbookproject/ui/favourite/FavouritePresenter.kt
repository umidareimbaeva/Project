package com.example.redbookproject.ui.favourite

import com.example.redbookproject.data.dao.NatureDao
import com.example.redbookproject.ui.nature.Presenter

class FavouritePresenter(private val dao: NatureDao, private val view: Presenter) {
    fun isFavourite(isFavourite: Int){
        view.setData(dao.isFavourite(isFavourite))
    }
}