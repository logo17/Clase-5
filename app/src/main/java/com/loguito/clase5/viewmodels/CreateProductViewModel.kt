package com.loguito.clase5.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.loguito.clase5.db.Clase5DB
import com.loguito.clase5.db.entity.Product
import com.loguito.clase5.repository.ProductRepository
import kotlinx.coroutines.launch
import java.util.*

//TODO 7: Creamos el viewmodel (Encargado de comunicarse con el fragmento, maneja el ciclo de vida)
class CreateProductViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var repository: ProductRepository

    init {
        val db = Clase5DB.getDatabase(application.applicationContext)
        repository = ProductRepository(db.productDao())
    }

    fun insert(name: String, quantity: Int) = viewModelScope.launch {
        repository.insert(Product(UUID.randomUUID().toString(), name, quantity))
    }
}