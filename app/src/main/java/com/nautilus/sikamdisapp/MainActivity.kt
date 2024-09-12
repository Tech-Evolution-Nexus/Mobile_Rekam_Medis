package com.nautilus.sikamdisapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import me.ibrahimsn.lib.SmoothBottomBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val smoothBottomBar = findViewById<SmoothBottomBar>(R.id.bottomNav)
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        // Hubungkan ViewPager dengan SmoothBottomBar
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                smoothBottomBar.itemActiveIndex = position
            }
        })

        // Menghubungkan SmoothBottomBar dengan ViewPager
        smoothBottomBar.onItemSelected = { position ->
            viewPager.currentItem = position
        }

    }

    class DasboardFragment : Fragment(R.layout.fragment_dashboard)
    class ProfilFragment : Fragment(R.layout.fragment_profil)

    class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return 2 // Jumlah halaman
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> DasboardFragment()
                1 -> ProfilFragment()
                else -> DasboardFragment()
            }
        }
    }
}
