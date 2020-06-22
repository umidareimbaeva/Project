package com.example.redbookproject.ui.animal

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


class FavouriteFragment: Fragment(R.layout.fragment_favourite), NatureItemClicked {
    private val adapter: NatureListAdapter = NatureListAdapter(this)
    private lateinit var dao: NatureDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rcv_favourite.adapter = adapter
        rcv_favourite.addItemDecoration(DividerItemDecoration(
            requireContext(), DividerItemDecoration.VERTICAL)
        )

        dao = RedBookDatabase.getInstance(requireContext()).natureDao()

    }

    override fun onStart() {
        super.onStart()
        val isFavourite = arguments?.getInt(MainActivity.IS_FAVOURITE) ?: 0
        setFavourite(isFavourite)
    }

    fun setFavourite(isFavourite: Int){
        adapter.models = dao.isFavourite(isFavourite)
    }

    override fun natureItemClick(id: Int) {
        val mIntent = Intent(requireActivity(), DetailActivity:: class.java)
        mIntent.putExtra(DetailActivity.NATURE_ID, id)
        startActivity(mIntent)
    }
}