package com.desafio.indra.movieapp.util

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.squareup.picasso.Picasso

@BindingAdapter("clearError")
fun TextInputLayout.clearErrorOnChange(text: String?) {
    isErrorEnabled = false
}

@BindingAdapter("urlImage")
fun AppCompatImageView.showUrlImage(urlImage: String?) {
    urlImage?.let {
        Picasso.get()
            .load(Constants.BASE_IMAGE_URL_API + urlImage)
            .into(this)
    }
}
