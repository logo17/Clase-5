package com.loguito.clase5.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.loguito.clase5.db.entity.Product

//TODO 4: Creamos el Data access object, donde definimos los diferentes metodos para cada tabla.
@Dao
interface ProductDAO {
    @Insert
    suspend fun insertProduct(product: Product)

    @Query("SELECT * FROM product")
    fun getAllProducts(): LiveData<List<Product>>
}