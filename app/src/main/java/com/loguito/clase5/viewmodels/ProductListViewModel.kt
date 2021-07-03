package com.loguito.clase5.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.loguito.clase5.db.Clase5DB
import com.loguito.clase5.db.entity.Product
import com.loguito.clase5.repository.ProductRepository

class ProductListViewModel(application: Application) : AndroidViewModel(application) {
    private val db = Clase5DB.getDatabase(application.applicationContext)
    private val repository = ProductRepository(db.productDao())

    fun fetchProducts(): LiveData<List<Product>> = repository.allProducts
}