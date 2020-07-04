package com.example.redbookproject.ui.detail
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.redbookproject.R
import com.example.redbookproject.data.RedBookDatabase
import com.example.redbookproject.data.dao.NatureDao
import com.example.redbookproject.data.model.Nature
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView {
    companion object {
        const val NATURE_ID = "natureId"
    }

    private var natureId = 0
    lateinit var currentNature: Nature
    private lateinit var dao: NatureDao
    private lateinit var menuItem: MenuItem
    lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        dao = RedBookDatabase.getInstance(this).natureDao()
        natureId = intent.getIntExtra(NATURE_ID, 0)
        presenter = DetailPresenter(dao, this)
        presenter.getSelectedNature(natureId)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
            R.id.bookmark-> {
                setFavourite()
                presenter.update(currentNature)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun setFavourite(){
        if(currentNature.isFavourite == null){
            currentNature.isFavourite = 1
            setFavouriteIcon()
        }
        else{
            currentNature.isFavourite = 1 - currentNature.isFavourite!!
            setFavouriteIcon()
        }
        presenter.update(currentNature)
    }
    private fun setFavouriteIcon(){
        if(currentNature.isFavourite == 1){
            menuItem.setIcon(R.drawable.bookmark)
        }
        else{
            menuItem.setIcon(R.drawable.bookmark_empty)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        menuItem = menu!!.findItem(R.id.bookmark)
        setFavouriteIcon()
        return true
    }

    override fun setDetailInfo(nature: Nature) {
        currentNature = nature
        supportActionBar?.title = currentNature.nameUzb
        tv_status_text.text = nature.status
        tv_propagation_text.text = nature.propagation
        tv_habitat_text.text = nature.habitat
        tv_quantity_text.text = nature.quantity
        tv_lifestyle_text.text = nature.lifestyle
        tv_limiting_factors_text.text = nature.limitingFactors
        tv_breeding_text.text = nature.breeding
        tv_security_text.text = nature.security

        Glide.with(this)
            .load(resources.getIdentifier("picture${natureId}", "drawable", packageName))
            .into(img_detail)
    }
}
