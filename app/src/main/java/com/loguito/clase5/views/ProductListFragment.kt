package com.loguito.clase5.views

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.loguito.clase5.R
import com.loguito.clase5.adapters.ProductListAdapter
import com.loguito.clase5.viewmodels.ProductListViewModel


class ProductListFragment : Fragment(R.layout.fragment_product_list) {
    private lateinit var productRecyclerView: RecyclerView

    private lateinit var viewModel: ProductListViewModel
    private val adapter = ProductListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(ProductListViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productRecyclerView = view.findViewById(R.id.productRecyclerView)
        productRecyclerView.adapter = adapter

        viewModel.fetchProducts().observe(viewLifecycleOwner) {
            adapter.productList = it
        }
    }
}