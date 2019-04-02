package com.example.learnviewmodel.views

import android.graphics.Paint
import android.widget.TextView

fun TextView.setStrikeThough() {
    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
}

fun TextView.removeStrikeThough() {
    paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
}