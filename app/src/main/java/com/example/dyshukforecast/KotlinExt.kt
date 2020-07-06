package com.example.dyshukforecast

import java.text.SimpleDateFormat
import java.util.*

fun Int.toCelsius() : Int {
    val const = 273.15F
    return (this - const).toInt()
}

fun Int.toPresentableCelsius() : String {
    val const = 273.15F
    return " ${(this - const).toInt()}°"
}

fun Long.toDate() : Date {
    val calendar = Calendar.getInstance(Locale.ENGLISH)
    calendar.timeInMillis = this * 1000L
    return calendar.time
}

fun Date.toHour() : String {
    return SimpleDateFormat("h", Locale.ENGLISH).format(this)
}

fun Date.toTimeFormat() : String {
    return SimpleDateFormat("a", Locale.ENGLISH).format(this)
}

