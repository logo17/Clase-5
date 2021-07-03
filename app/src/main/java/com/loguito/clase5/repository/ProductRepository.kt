package com.loguito.clase5.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.loguito.clase5.db.dao.ProductDAO
import com.loguito.clase5.db.entity.Product

// TODO 6: Creamos el repository (Patron que maneja el cache y el api)
class ProductRepository(private val productDAO: ProductDAO) {
    val allProducts: LiveData<List<Product>> = productDAO.getAllProducts()

    @WorkerThread
    suspend fun insert(product: Product) {
        productDAO.insertProduct(product)
    }
}