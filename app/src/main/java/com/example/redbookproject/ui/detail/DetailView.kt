package com.example.redbookproject.ui.detail

import com.example.redbookproject.data.model.Nature

interface DetailView {
    fun setDetailInfo(nature: Nature)
}