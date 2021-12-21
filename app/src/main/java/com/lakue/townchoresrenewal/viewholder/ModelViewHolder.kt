package com.lakue.townchoresrenewal.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.lakue.townchoresrenewal.base.BaseViewModel
import com.lakue.townchoresrenewal.listener.AdapterListener
import com.lakue.townchoresrenewal.model.Model
import com.lakue.townchoresrenewal.util.provider.ResourcesProvider

abstract class ModelViewHolder<M: Model>(
    binding: ViewBinding,
    protected val viewModel: BaseViewModel,
    protected val resourcesProvider: ResourcesProvider
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun reset()

    open fun bindData(model: M) {
        reset()
    }

    abstract fun bindViews(model: M, adapterListener: AdapterListener)

}
