package com.example.fitnessapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.databinding.ItemIntBinding
import com.example.fitnessapp.domain.IntModel

class IntViewAdapter(data: List<IntModel>) : RecyclerView.Adapter<IntViewAdapter.IntViewHolder>() {

    var list: List<IntModel> = data
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class IntViewHolder(
        val binding: ItemIntBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemIntBinding.inflate(inflater, parent, false)

        return IntViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        val item = list[position]
        if (item.item == 0)
            holder.binding.tvItemInt.visibility = View.INVISIBLE
        else
            holder.binding.tvItemInt.visibility = View.VISIBLE
        holder.binding.tvItemInt.text = item.item.toString()
    }
}
