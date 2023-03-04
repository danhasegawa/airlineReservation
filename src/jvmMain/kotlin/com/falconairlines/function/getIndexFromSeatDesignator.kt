package com.falconairlines.function

import com.falconairlines.menu.submenu.isValidSeatDesignator

fun getIndexFromSeatDesignator(seat: String): Int? {

    // this function takes a seat designator such as "1C" or "6A" and
    // returns an index in the linear array
    // e.g. "1A" ->  0
    //      "2C" ->  6
    //      "9D" -> 35
    // returns null if the seat designator is not valid

    if (!isValidSeatDesignator(seat)) {
        return null
    }

    val row = seat.substring(0, 1)
    val col = seat.substring(1, 2).toUpperCase()

    var colValue = 0

    when (col) {
        "A" -> colValue = 0
        "B" -> colValue = 1
        "C" -> colValue = 2
        "D" -> colValue = 3
    }

    return (row.toInt() - 1) * 4 + colValue
}