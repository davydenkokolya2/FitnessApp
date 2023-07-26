package com.example.fitnessapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.databinding.ItemStringBinding
import com.example.fitnessapp.domain.StringModel

class StringViewAdapter(data: List<StringModel>) : RecyclerView.Adapter<StringViewAdapter.StringViewHolder>() {

    var list: List<StringModel> = data
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class StringViewHolder(
        val binding: ItemStringBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStringBinding.inflate(inflater, parent, false)

        return StringViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        val item = list[position]
        if (item.item == "")
            holder.binding.tvItemString.visibility = View.INVISIBLE
        else
            holder.binding.tvItemString.visibility = View.VISIBLE
        holder.binding.tvItemString.text = item.item
    }
}
