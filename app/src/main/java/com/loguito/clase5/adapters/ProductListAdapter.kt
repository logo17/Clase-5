package com.loguito.clase5.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.loguito.clase5.R
import com.loguito.clase5.db.entity.Product

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    var productList: List<Product> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            val quantityTV: TextView = itemView.findViewById(R.id.textView2)
            val nameTV: TextView = itemView.findViewById(R.id.textView3)

            quantityTV.text = product.quantity.toString()
            nameTV.text = product.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_list_cell, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size
}