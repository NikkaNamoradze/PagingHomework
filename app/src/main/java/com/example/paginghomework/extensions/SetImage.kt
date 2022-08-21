package com.example.paginghomework.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.paginghomework.R

fun ImageView.setImage(url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(context).load(url).placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(this)
    } else {
        setImageResource(R.drawable.ic_launcher_background)
    }
}