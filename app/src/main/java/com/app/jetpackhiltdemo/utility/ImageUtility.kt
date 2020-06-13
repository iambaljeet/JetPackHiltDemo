package com.app.jetpackhiltdemo.utility

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageFromUrl(imageUrl: String?) {
    Glide.with(this.context)
        .load(imageUrl)
        .into(this)
}

fun AppCompatImageView.loadImageFromUrl(imageUrl: String?) {
    Glide.with(this.context)
        .load(imageUrl)
        .into(this)
}