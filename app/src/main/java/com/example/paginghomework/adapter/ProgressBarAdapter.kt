package com.example.paginghomework.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.paginghomework.databinding.ProgressBarBinding

class ProgressBarAdapter : LoadStateAdapter<ProgressBarAdapter.LoaderViewHolder>() {

    inner class LoaderViewHolder(val binding: ProgressBarBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: LoaderViewHolder, loadState: LoadState) {
        holder.binding.root.isVisible = loadState is LoadState.Loading
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState) =
        LoaderViewHolder(
            ProgressBarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
}