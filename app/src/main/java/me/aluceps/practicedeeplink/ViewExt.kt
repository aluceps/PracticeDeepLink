package me.aluceps.practicedeeplink

import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("text_from")
fun TextView.setLaunchFrom(value: LaunchBy?) {
    value?.toString().let { text = it }
}

@BindingAdapter("text_scheme")
fun TextView.setScheme(value: Uri?) {
    value?.scheme?.let { text = it }
}

@BindingAdapter("text_host")
fun TextView.setHost(value: Uri?) {
    value?.host?.let { text = it }
}

@BindingAdapter("text_path")
fun TextView.setPath(value: Uri?) {
    value?.path?.let { text = it }
}

@BindingAdapter("text_datetime")
fun TextView.setPath(value: Date?) {
    value?.let { text = it.toReadableString() }
}

fun Date.toReadableString(): String = SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(this)