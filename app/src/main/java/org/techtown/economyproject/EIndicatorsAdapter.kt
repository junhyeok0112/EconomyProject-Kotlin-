package org.techtown.economyproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.techtown.economyproject.databinding.EindicatorsItemBinding

class EIndicatorsAdapter : RecyclerView.Adapter<EIndicatorsAdapter.ViewHolder>() {

    var items = ArrayList<EIndicatorsResult>()

    inner class ViewHolder(val binding:EindicatorsItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(item : EIndicatorsResult){
            binding.indicator = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<EindicatorsItemBinding>(LayoutInflater.from(parent.context) , R.layout.eindicators_item , parent , false);
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount() = items.size
}