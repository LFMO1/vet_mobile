package com.example.vetconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vetconnect.adapters.AdapterFragment
import com.example.vetconnect.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabLayout = TabLayoutMediator(binding.tblayout, binding.vpItens) { tab, position ->
            when(position){
                0 -> tab.text = "Clinicas"
                1 -> tab.text = "Animais"
                2 -> tab.text = "Serviços"
            }
        }
        binding.vpItens.adapter = AdapterFragment(this)
        tabLayout.attach()
    }
}