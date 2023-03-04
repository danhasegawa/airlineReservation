package com.falconairlines.function

import com.falconairlines.menu.submenu.seatStatus

fun printSeatChart() {

    val rowAsString = Array(9) { "" }

    // make the seat rows from the seat Status array (note
    // the space in the middle)
    // example: "O O   O X"

    for (row in 0..8) {
        for (col in 0..3) {
            rowAsString[row] += seatStatus[row * 4 + col] + " "
            if (col == 1) {
                rowAsString[row] += "  "
            }
        }
    }

    println()
    println("            /  Front  \\")
    println("           /           \\")
    println("           | A B   C D |")
    println("           |           |")
    println("        1  | " + rowAsString[0] + "|")
    println("        2  | " + rowAsString[1] + "|")
    println("        3  | " + rowAsString[2] + "|")
    println("-----------|           |-----------")
    println("        4  | " + rowAsString[3] + "|")
    println(" WING   5  | " + rowAsString[4] + "|      WING ")
    println("---v--- 6 -| " + rowAsString[5] + "|-------v---")
    println("           |           |")
    println("        7  | " + rowAsString[6] + "|")
    println("        8  | " + rowAsString[7] + "|")
    println("       -9 -| " + rowAsString[8] + "|----")
    println("   ----    |           |    ----")
    println("-----------|   Back    |-----------")
    println("            \\    |    /")
    println("             \\   |   /")
    println("              \\  |  /")
    println("                 |")
    println(" O = available")
    println(" X = reserved")
    println()
}