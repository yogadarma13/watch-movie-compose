package com.yogadarma.watchmovie.utils

import org.joda.time.format.DateTimeFormat

fun String.formatDate(fromFormat: String, targetFormat: String): String {
    val dateTime = DateTimeFormat
        .forPattern(fromFormat)
        .parseDateTime(this)

    return DateTimeFormat
        .forPattern(targetFormat)
        .print(dateTime.millis)
}