package com.lakue.townchoresrenewal.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.lakue.townchoresrenewal.util.mapper.ModelViewHolderMapper
import com.lakue.townchoresrenewal.util.provider.DefaultResourcesProvider
import com.lakue.townchoresrenewal.base.BaseViewModel
import com.lakue.townchoresrenewal.listener.AdapterListener
import com.lakue.townchoresrenewal.model.CellType
import com.lakue.townchoresrenewal.model.Model
import com.lakue.townchoresrenewal.util.provider.ResourcesProvider
import com.lakue.townchoresrenewal.viewholder.ModelViewHolder
import com.lakue.townchoresrenewal.NCApplication

class ModelRecyclerAdapter<M : Model, VM: BaseViewModel>(
    private var modelList: List<Model>,
    private var viewModel: VM,
    private val resourcesProvider: ResourcesProvider = DefaultResourcesProvider(NCApplication.appContext!!),
    private val adapterListener: AdapterListener
) : ListAdapter<Model, ModelViewHolder<M>>(Model.DIFF_CALLBACK) {

    override fun getItemCount(): Int = modelList.size

    override fun getItemViewType(position: Int) = modelList[position].type.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder<M> {
        return ModelViewHolderMapper.map(parent, CellType.values()[viewType], viewModel, resourcesProvider)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: ModelViewHolder<M>, position: Int) {
        with(holder) {
            bindData(modelList[position] as M)
            bindViews(modelList[position] as M, adapterListener)
        }
    }

    override fun submitList(list: List<Model>?) {
        list?.let { modelList = it }
        super.submitList(list)
    }
}
