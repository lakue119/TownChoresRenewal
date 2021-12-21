package com.lakue.townchoresrenewal.util.mapper

import android.view.LayoutInflater
import android.view.ViewGroup
import com.lakue.townchoresrenewal.util.provider.ResourcesProvider
import com.lakue.townchoresrenewal.base.BaseViewModel
import com.lakue.townchoresrenewal.model.CellType
import com.lakue.townchoresrenewal.model.Model
import com.lakue.townchoresrenewal.viewholder.ModelViewHolder

object ModelViewHolderMapper {

    @Suppress("UNCHECKED_CAST")
    fun <M: Model> map(
        parent: ViewGroup,
        type: CellType,
        viewModel: BaseViewModel,
        resourcesProvider: ResourcesProvider
    ): ModelViewHolder<M> {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = when (type) {
            CellType.RESTAURANT_CELL ->
                RestaurantViewHolder(
                    ViewholderRestaurantBinding.inflate(inflater, parent, false),
                    viewModel,
                    resourcesProvider
                )

        }

        return viewHolder as ModelViewHolder<M>
    }

}
