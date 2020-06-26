package com.example.redbookproject.ui.nature

import com.example.redbookproject.data.dao.NatureDao

class NaturePresenter(private val dao: NatureDao, private val view: Presenter){
    fun getAllNature(type: Int){
        view.setData(dao.getAllNature(type))
    }
}