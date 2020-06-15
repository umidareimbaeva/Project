package com.example.redbookproject.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.redbookproject.R
import com.example.redbookproject.data.RedBookDatabase
import com.example.redbookproject.data.dao.NatureDao
import com.example.redbookproject.data.model.Nature
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        val NATURE_ID = "natureId"
    }

    private var natureId = 0
    private lateinit var currentNature: Nature
    private lateinit var dao: NatureDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"

        dao = RedBookDatabase.getInstance(this).natureDao()
        natureId = intent.getIntExtra(NATURE_ID, 0)
        currentNature = dao.getSelectedNature(natureId)
        tv_status_text.text = currentNature.status
        tv_propagation_text.text = currentNature.propagation
        tv_habitat_text.text = currentNature.habitat
        tv_quantity_text.text = currentNature.quantity
        tv_lifestyle_text.text = currentNature.lifestyle
        tv_limiting_factors_text.text = currentNature.limitingFactors
        tv_breeding_text.text = currentNature.breeding
        tv_security_text.text = currentNature.security

        Glide.with(this)
            .load(resources.getIdentifier("picture${natureId}", "drawable", packageName))
            .into(img_detail)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
