package com.study.pokemon.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun Context.imgShow(imgUrl: String?, imageView: ImageView){
    Glide.with(this).load(imgUrl).into(imageView)
}