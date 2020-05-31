package com.example.redbookproject.ui.animal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.redbookproject.NatureListAdapter
import com.example.redbookproject.R
import com.example.redbookproject.data.RedBookDatabase
import com.example.redbookproject.data.dao.NatureDao
import kotlinx.android.synthetic.main.fragment_nature.*

class NatureFragment : Fragment(R.layout.fragment_nature) {
    private val adapter: NatureListAdapter = NatureListAdapter()
    private lateinit var dao: NatureDao
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcv_recycler.adapter = adapter
        rcv_recycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        dao = RedBookDatabase.getInstance(requireContext()).natureDao()
        setData()
    }

    private fun setData() {
        adapter.models = dao.getAllNature()
    }
}