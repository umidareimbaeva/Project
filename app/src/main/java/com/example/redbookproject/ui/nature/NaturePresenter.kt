package com.example.redbookproject.ui.nature

import com.example.redbookproject.data.dao.NatureDao
import com.example.redbookproject.data.model.Nature

class NaturePresenter(private val dao: NatureDao){
    private var setData: (models: List<Nature>) -> Unit = {
        println("")
    }
    fun setDataFunction(setData: (models: List<Nature>) -> Unit){
        this.setData = setData
    }
    fun getAllNature(type: Int){
        setData.invoke(dao.getAllNature(type))
    }
}