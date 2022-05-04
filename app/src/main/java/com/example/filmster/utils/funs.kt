package com.example.filmster.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.filmster.R

fun placePictureInView(view: ImageView, pictureUrl: String?) {
    Glide.with(view.context).load(pictureUrl).into(view)
}