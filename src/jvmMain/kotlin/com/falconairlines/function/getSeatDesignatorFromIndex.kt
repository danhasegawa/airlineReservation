package com.falconairlines.function

fun getSeatDesignatorFromIndex(index: Int): String? {

    // this function takes a linear array index from 0 to 35 and
    // returns the corresponding seat designator
    // e.g. 0 -> "1A"
    //      6 -> "2C"
    //     35 -> "9D"
    // returns null if the index is out of bound

    if (index !in 0..35) {
        return null
    }

    val rowValue = (index / 4) + 1
    val colValue = index % 4

    var colChar = "?"

    when (colValue) {
        0 -> colChar = "A"
        1 -> colChar = "B"
        2 -> colChar = "C"
        3 -> colChar = "D"
    }

    return rowValue.toString() + colChar
}