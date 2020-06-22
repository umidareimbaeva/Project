package com.example.redbookproject

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.redbookproject.ui.animal.FavouriteFragment
import com.example.redbookproject.ui.animal.NatureFragment

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
            val mfragment = NatureFragment()
            val mbundle = Bundle()
            val fFragment = FavouriteFragment()
            val fBundle = Bundle()

            when(it.itemId){
                R.id.nav_invertebrates->{
                    mbundle.putInt(TYPE_ID, INVERTEBRATES)
                    mfragment.arguments = mbundle
                    supportFragmentManager.beginTransaction().replace(R.id.fml_fragment, mfragment).commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_fishes->{
                    mbundle.putInt(TYPE_ID, FISHES)
                    mfragment.arguments = mbundle
                    supportFragmentManager.beginTransaction().replace(R.id.fml_fragment, mfragment).commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_reptiles->{
                    mbundle.putInt(TYPE_ID, REPTILES)
                    mfragment.arguments = mbundle
                    supportFragmentManager.beginTransaction().replace(R.id.fml_fragment, mfragment).commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_birds->{
                    mbundle.putInt(TYPE_ID, BIRDS)
                    mfragment.arguments = mbundle
                    supportFragmentManager.beginTransaction().replace(R.id.fml_fragment, mfragment).commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    }
                R.id.nav_mammals->{
                    mbundle.putInt(TYPE_ID, MAMMALS)
                    mfragment.arguments = mbundle
                    supportFragmentManager.beginTransaction().replace(R.id.fml_fragment, mfragment).commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                   }
                R.id.nav_favourite->{
                    fBundle.putInt(IS_FAVOURITE, 1)
                    fFragment.arguments = fBundle
                    supportFragmentManager.beginTransaction().replace(R.id.fml_fragment, fFragment).commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                else-> return@setNavigationItemSelectedListener false
            }
            return@setNavigationItemSelectedListener true
        }
    }

}
