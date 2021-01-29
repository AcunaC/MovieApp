package com.desafio.indra.movieapp.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

val Context.connectivityManager: ConnectivityManager
    get() = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

@SuppressLint("SimpleDateFormat")
val dateFormatter = SimpleDateFormat("yyyy-MM-dd")

fun String.parseDate(): Date {
    try {
        return dateFormatter.parse(this)
    } catch (ex: ParseException) {
        throw  ex
    }
}

fun <T> Activity.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}