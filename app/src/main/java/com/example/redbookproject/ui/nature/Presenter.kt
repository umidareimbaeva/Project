package com.example.redbookproject.ui.nature

import com.example.redbookproject.data.model.Nature

interface Presenter {
    fun setData(models: List<Nature>)
}