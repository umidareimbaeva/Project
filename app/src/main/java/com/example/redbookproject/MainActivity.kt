package com.example.redbookproject

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.redbookproject.ui.favourite.FavouriteFragment
import com.example.redbookproject.ui.nature.NatureFragment

class MainActivity : AppCompatActivity() {
    companion object{
        const val  TYPE_ID = "type_id"
        const val INVERTEBRATES = 1
        const val FISHES = 2
        const val REPTILES = 3
        const val BIRDS = 4
        const val MAMMALS  = 5
        const val IS_FAVOURITE = "is_favourite"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val fragment = NatureFragment()
        val bundle = Bundle()

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        bundle.putInt(TYPE_ID, INVERTEBRATES)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.fml_fragment, fragment).commit()

        navView.setNavigationItemSelectedListener {
            val myBundle = Bundle()
            var myFragment: Fragment

            when(it.itemId){
                R.id.nav_invertebrates->{
                    myFragment = NatureFragment()
                    myBundle.putInt(TYPE_ID, INVERTEBRATES)
                    myFragment.arguments = myBundle
                }
                R.id.nav_fishes->{
                    myFragment = NatureFragment()
                    myBundle.putInt(TYPE_ID, FISHES)
                    myFragment.arguments = myBundle
                }
                R.id.nav_reptiles->{
                    myFragment = NatureFragment()
                    myBundle.putInt(TYPE_ID, REPTILES)
                    myFragment.arguments = myBundle
                }
                R.id.nav_birds->{
                    myFragment = NatureFragment()
                    myBundle.putInt(TYPE_ID, BIRDS)
                    myFragment.arguments = myBundle
                    }
                R.id.nav_mammals->{
                    myFragment = NatureFragment()
                    myBundle.putInt(TYPE_ID, MAMMALS)
                    myFragment.arguments = myBundle
                   }
                R.id.nav_favourite->{
                    myFragment = FavouriteFragment()
                    myBundle.putInt(IS_FAVOURITE, 1)
                    myFragment.arguments = myBundle
                }
                else-> return@setNavigationItemSelectedListener false
            }
            supportFragmentManager.beginTransaction().replace(R.id.fml_fragment, myFragment).commit()
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }

}
