package com.loguito.clase5.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.loguito.clase5.db.dao.ProductDAO
import com.loguito.clase5.db.entity.Product

//TODO 5: Declaramos el singleton de la base de datos, para evitar que se inicialice multiples veces desde diferentes hilos.

@Database(entities = [Product::class], version = 1, exportSchema = false)
public abstract class Clase5DB : RoomDatabase() {
    abstract fun productDao(): ProductDAO

    companion object {
        @Volatile
        private var INSTANCE: Clase5DB? = null

        fun getDatabase(context: Context): Clase5DB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Clase5DB::class.java,
                    "clase_5_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}