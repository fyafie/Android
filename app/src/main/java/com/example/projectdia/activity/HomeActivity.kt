package com.example.projectdia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.projectdia.R
import com.example.projectdia.databinding.ActivityHomeBinding
import com.example.projectdia.fragment.HomeFragment
import com.example.projectdia.fragment.JobFragment
import com.example.projectdia.fragment.MovieFragment
import com.example.projectdia.fragment.ProfileFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentt:Fragment = HomeFragment()
        val transactionn:FragmentTransaction = supportFragmentManager.beginTransaction()
        transactionn.replace(R.id.content,fragmentt).commit()
        binding.navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.menuSatu ->{
                    val fragment:Fragment = HomeFragment()
                    val transaction:FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.content,fragment).commit()
                    true
                }
                R.id.menuDua ->{
                    val fragment:Fragment = JobFragment()
                    val transaction:FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.content,fragment).commit()
                    true
                }
                R.id.menuTiga ->{
                    val fragment:Fragment = ProfileFragment()
                    val transaction:FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.content,fragment).commit()
                    true
                }
                R.id.menuMovie ->{
                    val fragment:Fragment = MovieFragment()
                    val transaction:FragmentTransaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.content,fragment).commit()
                    true
                }
                else -> false

            }

        }
    }
}