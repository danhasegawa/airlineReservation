package com.falconairlines.menu.submenu

import com.falconairlines.function.printSeatChart

fun subMenuResetFlight() {

    println("*** Reset Flight ***")

    println("Are you sure you want to reset this flight? (Y/N)")

    val reply = readLine() ?: "N"

    if (reply.toUpperCase() != "Y") {
        println(">>> Reset operation canceled. <<<")
        return
    }

    captain = null
    firstOfficer = null
    attendants.clear()

    for (index in 0..35) {
        seatStatus[index] = "O"
        passengers[index] = null
    }

    printSeatChart()
    printCrew()

    println(">>> Flight reset!! <<<")
}
