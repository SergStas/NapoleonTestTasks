package com.sergstas.cupcakeapp.features.menu.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sergstas.cupcakeapp.R
import com.sergstas.cupcakeapp.domain.models.ProductInfo
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_position_bar.*

class MenuAdapter(
    private val onClickSelect: (ProductInfo) -> Unit,
    private val onClickInfo: (ProductInfo) -> Unit
) : ListAdapter<ProductInfo, MenuAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<ProductInfo>() {
        override fun areItemsTheSame(oldItem: ProductInfo, newItem: ProductInfo): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: ProductInfo, newItem: ProductInfo): Boolean =
            oldItem == newItem
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_position_bar, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        setItemView(getItem(position), holder)
    }

    private fun setItemView(product: ProductInfo, holder: ViewHolder) {
        holder.posBar_title.text = product.name
        holder.posBar_description.text = String.format(holder.containerView.context.getString(R.string.posBar_description_pattern),
            product.description, product.price)

        holder.posBar_bSelect.setOnClickListener {onClickSelect(product)}

        Picasso.get().load(product.url).into(holder.posBar_image)

        holder.posBar_bInfo.setOnClickListener {onClickInfo(product)}
    }

    class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer
}
