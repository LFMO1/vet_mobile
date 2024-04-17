package com.example.vetconnect.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

import com.example.vetconnect.fragments.ClinicasFragment
import java.lang.RuntimeException

class AdapterFragment(activity: AppCompatActivity)  : FragmentStateAdapter(activity)  {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ClinicasFragment()
            1 -> ClinicasFragment()
            2 -> ClinicasFragment()
            else -> throw RuntimeException("Invalid position: $position" )
        }
    }
}