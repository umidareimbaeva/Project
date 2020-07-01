package com.example.redbookproject.ui.detail

import com.example.redbookproject.data.dao.NatureDao
import com.example.redbookproject.data.model.Nature

class DetailPresenter(val dao: NatureDao, var view: DetailActivity){
    fun getSelectedNature(id: Int){
       view.currentNature = dao.getSelectedNature(id)
    }
    fun update(nature: Nature){
        dao.updateNature(nature)
    }
}