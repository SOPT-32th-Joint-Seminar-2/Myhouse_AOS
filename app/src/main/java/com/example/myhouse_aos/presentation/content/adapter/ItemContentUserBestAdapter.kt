package com.example.myhouse_aos.presentation.content.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myhouse_aos.databinding.ItemContentUserbestBinding
import com.example.myhouse_aos.domain.model.UserBestData
import com.example.myhouse_aos.util.extension.ItemDiffCallback

class ItemContentUserBestAdapter(
    val showScrapSnackBar: () -> Unit,
) :
    ListAdapter<UserBestData, ItemContentUserBestAdapter.ItemContentUserBestViewHolder>(
        ItemDiffCallback<UserBestData>(
            onItemsTheSame = { old, new -> old.image == new.image },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {
    class ItemContentUserBestViewHolder(private val binding: ItemContentUserbestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(
            data: UserBestData,
            showScrapSnackBar: () -> Unit,
        ) {
            binding.data = data

            binding.btnContentUserbestBookmark.setOnClickListener {
                if (binding.btnContentUserbestBookmark.isSelected) {
                    binding.btnContentUserbestBookmark.isSelected = false
                } else {
                    binding.btnContentUserbestBookmark.isSelected = true
                    showScrapSnackBar()
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ItemContentUserBestAdapter.ItemContentUserBestViewHolder {
        val binding =
            ItemContentUserbestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemContentUserBestAdapter.ItemContentUserBestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemContentUserBestViewHolder, position: Int) {
        holder.onBind(getItem(position), showScrapSnackBar)
    }

}