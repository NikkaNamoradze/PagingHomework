package com.example.paginghomework.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paginghomework.databinding.UsersItemBinding
import com.example.paginghomework.extensions.setImage
import com.example.paginghomework.model.User

class UserPagingAdapter :
    PagingDataAdapter<User.Data, UserPagingAdapter.UsersViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: UserPagingAdapter.UsersViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserPagingAdapter.UsersViewHolder {
        return UsersViewHolder(
            UsersItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    inner class UsersViewHolder(private val binding: UsersItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: User.Data) {
            binding.apply {
                uiEmail.text = item.email
                uiFirstname.text = item.firstName
                uiLastname.text = item.lastName
                uiImage.setImage(item.avatar)
            }
        }
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<User.Data>() {
        override fun areItemsTheSame(oldItem: User.Data, newItem: User.Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User.Data, newItem: User.Data): Boolean {
            return oldItem == newItem
        }

    }
}