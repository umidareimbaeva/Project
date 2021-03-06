package com.example.redbookproject.ui.nature

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.redbookproject.MainActivity
import com.example.redbookproject.NatureListAdapter
import com.example.redbookproject.R
import com.example.redbookproject.data.RedBookDatabase
import com.example.redbookproject.data.dao.NatureDao
import com.example.redbookproject.data.model.Nature
import com.example.redbookproject.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_nature.*

class NatureFragment : Fragment(R.layout.fragment_nature){
    private val adapter: NatureListAdapter = NatureListAdapter()
    private lateinit var dao: NatureDao
    private lateinit var presenter: NaturePresenter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.setOnItemClickListener {
            val mIntent = Intent(requireActivity(), DetailActivity:: class.java)
            mIntent.putExtra(DetailActivity.NATURE_ID, it)
            startActivity(mIntent)
        }
        rcv_recycler.adapter = adapter
        rcv_recycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        val type = arguments?.getInt(MainActivity.TYPE_ID) ?: 1
        dao = RedBookDatabase.getInstance(requireContext()).natureDao()
        presenter = NaturePresenter(dao)
        presenter.setDataFunction {
            adapter.models = it
        }
        presenter.getAllNature(type)

        et_search.addTextChangedListener{
            val searchResult: List<Nature> = dao.searchNatureByName(type, "${it.toString()}%")
            adapter.models = searchResult
        }
    }

//    private fun setData(type: Int) {
//        adapter.models = dao.getAllNature(type)
//    }

//    override fun natureItemClick(id: Int) {
//        val mIntent = Intent(requireActivity(), DetailActivity:: class.java)
//        mIntent.putExtra(DetailActivity.NATURE_ID, id)
//        startActivity(mIntent)
//    }
}