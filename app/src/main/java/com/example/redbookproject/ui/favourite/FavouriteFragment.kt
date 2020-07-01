package com.example.redbookproject.ui.favourite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.redbookproject.MainActivity
import com.example.redbookproject.NatureListAdapter
import com.example.redbookproject.R
import com.example.redbookproject.data.RedBookDatabase
import com.example.redbookproject.data.dao.NatureDao
import com.example.redbookproject.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_favourite.*

class FavouriteFragment : Fragment(R.layout.fragment_favourite){
    private val adapter: NatureListAdapter = NatureListAdapter()
    private lateinit var dao: NatureDao
    private lateinit var presenter: FavouritePresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.setOnItemClickListener {
            val mIntent = Intent(requireActivity(), DetailActivity:: class.java)
            mIntent.putExtra(DetailActivity.NATURE_ID, it)
            startActivity(mIntent)
        }
        rcv_favourite.adapter = adapter
        rcv_favourite.addItemDecoration(
            DividerItemDecoration(
                requireContext(), DividerItemDecoration.VERTICAL
            )
        )
        dao = RedBookDatabase.getInstance(requireContext()).natureDao()
        presenter = FavouritePresenter(dao)
    }

    override fun onStart() {
        super.onStart()
        val isFavourite = arguments?.getInt(MainActivity.IS_FAVOURITE) ?: 0
        presenter.setDataFunction {
            adapter.models = it
        }
        presenter.isFavourite(isFavourite)
    }

}