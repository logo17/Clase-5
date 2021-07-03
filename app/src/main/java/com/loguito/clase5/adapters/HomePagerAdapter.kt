package com.loguito.clase5.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.loguito.clase5.views.CreateProductFragment
import com.loguito.clase5.views.ProductListFragment

// TODO 1: Creamos el adapter para alimentar el viewpager
class HomePagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    var titles = arrayOf("Crear", "Listado")

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) CreateProductFragment() else ProductListFragment()
    }
}