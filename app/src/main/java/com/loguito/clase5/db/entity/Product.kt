package com.loguito.clase5.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO 3: Creamos las entidades (tablas en la db)
@Entity
data class Product(@PrimaryKey val id: String, val name: String, val quantity: Int)