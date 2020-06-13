package com.app.jetpackhiltdemo.utility

import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.isVisible

fun TextView.hideIfEmptyText(text: String?) {
    if (text.isNullOrBlank()) {
        this.isVisible = false
    } else {
        this.text = text
        this.isVisible = true
    }
}

fun AppCompatTextView.hideIfEmptyText(text: String?) {
    if (text.isNullOrBlank()) {
        this.isVisible = false
    } else {
        this.text = text
        this.isVisible = true
    }
}