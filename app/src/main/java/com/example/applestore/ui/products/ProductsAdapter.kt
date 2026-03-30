package com.example.applestore.ui.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.applestore.R
import com.example.applestore.data.model.Product

class ProductsAdapter(
    private var products: List<Product>,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView     = view.findViewById(R.id.tvName)
        val tvPrice: TextView    = view.findViewById(R.id.tvPrice)
        val tvOldPrice: TextView = view.findViewById(R.id.tvOldPrice)
        val tvStars: TextView    = view.findViewById(R.id.tvStars)
        val ivProduct: ImageView = view.findViewById(R.id.ivProduct)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]

        holder.tvName.text  = product.name
        holder.tvPrice.text = "${product.price.toInt()} ₴"
        holder.tvStars.text = "★★★★★"

        if (product.oldPrice != null) {
            holder.tvOldPrice.visibility = View.VISIBLE
            holder.tvOldPrice.text = "${product.oldPrice.toInt()} ₴"
            holder.tvOldPrice.paintFlags =
                holder.tvOldPrice.paintFlags or android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.tvOldPrice.visibility = View.GONE
        }

        Glide.with(holder.itemView.context)
            .load(product.imageUrl)
            .placeholder(R.color.surface2)
            .error(R.color.surface2)
            .centerCrop()
            .into(holder.ivProduct)

        holder.itemView.setOnClickListener { onItemClick(product) }
    }

    override fun getItemCount() = products.size

    fun updateList(newList: List<Product>) {
        products = newList
        notifyDataSetChanged()
    }
}
