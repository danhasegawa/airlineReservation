package com.falconairlines.menu.submenu

import com.falconairlines.function.printSeatChart

fun subMenuCancelReservation() {
    println("Cancel Reservation")

    var subMenuDone = false

    do {

        printSeatChart()

        println("Please enter a seat you would like to cancel: (e.g. 1A, 5C, etc.)")
        println("Enter X to return to the main menu")

        var seat: String

        var cancellationLoopDone = false

        do {
            seat = readLine() ?: ""

            if (seat.toUpperCase() == "X") {
                cancellationLoopDone = true
                subMenuDone = true
            } else {
                if (isValidSeatDesignator(seat)) {
                    if (!isSeatAvailable(seat)) {
                        val passenger = getPassengerAt(seat) ?: "<unknown passenger>"
                        println("Cancel reservation for : " + seat.toUpperCase() + " " + passenger + "? (Y/N)")

                        val reply = readLine() ?: "N"

                        printSeatChart()

                        if (reply.toUpperCase() == "Y") {
                            releaseSeat(seat)

                            println(">>> Reservation canceled successfully! <<<")
                        } else {
                            println(">>> Cancellation aborted! <<<")
                        }

                        cancellationLoopDone = true

                    } else {
                        println(">>> That seat is not reserved, please pick another seat. <<<")
                    }
                } else {
                    println(">>> That is not a valid seat, please try again. <<<")
                }
            }

        } while (!cancellationLoopDone)

    } while (!subMenuDone)

}