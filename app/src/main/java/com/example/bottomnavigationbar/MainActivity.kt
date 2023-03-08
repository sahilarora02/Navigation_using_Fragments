package com.example.bottomnavigationbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavigationbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {    
            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.profile-> replaceFragment(Profile())
                R.id.settings->replaceFragment(Settings())
                else ->{

                }
            }
            true
        }
    }


    private fun replaceFragment(fragment: Fragment){
        var fragmentmanager = supportFragmentManager
        var fragmentTransiction = fragmentmanager.beginTransaction()
        fragmentTransiction.replace(R.id.frame_layout , fragment)
            fragmentTransiction.commit()
    }
}