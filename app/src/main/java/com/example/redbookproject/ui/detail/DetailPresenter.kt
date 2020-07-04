package com.example.redbookproject.ui.detail

import com.example.redbookproject.data.dao.NatureDao
import com.example.redbookproject.data.model.Nature

class DetailPresenter(val dao: NatureDao, var view: DetailView){

    fun getSelectedNature(id: Int){
       view.setDetailInfo(dao.getSelectedNature(id))
    }
    fun update(nature: Nature){
        dao.updateNature(nature)
    }
}