package com.falconairlines.menu.submenu

import com.falconairlines.function.getIndexFromSeatDesignator
import com.falconairlines.function.printSeatChart


var seatStatus = Array(36) { "O" }
var passengers = arrayOfNulls<String>(36)

fun subMenuBookASeat() {
    println("*** Book a Seat ***")

    var subMenuDone = false

    do {

        printSeatChart()

        println("Please enter a seat you would like: (e.g. 1A, 5C, etc.)")
        println("Enter X to return to the main menu")

        var seat: String

        var reservationLoopDone = false

        do {
            seat = readLine() ?: ""

            if (seat.toUpperCase() == "X") {
                reservationLoopDone = true
                subMenuDone = true
            } else {
                if (isValidSeatDesignator(seat)) {
                    if (isSeatAvailable(seat)) {

                        // get passenger's name and store it

                        var passengerName: String

                        do {
                            println("Please enter passenger's name:")

                            passengerName = readLine() ?: ""

                            if (passengerName.length < 2) {
                                println(">>> Name must be at least 2 characters long. Please try again. <<<")
                            }

                        } while (passengerName.length < 2)

                        reserveSeat(seat, passengerName)
                        reservationLoopDone = true
                        println(">>> Reservation completed successfully! <<<")

                    } else {
                        println(">>> That seat is not available, please pick another seat. <<<")
                    }
                } else {
                    println(">>> That is not a valid seat, please try again. <<<")
                }
            }

        } while (!reservationLoopDone)

    } while (!subMenuDone)
}


fun isSeatAvailable(index: Int): Boolean {

    if (index !in 0..35) {
        return false
    }

    return seatStatus[index] == "O"
}

fun isSeatAvailable(seat: String): Boolean {

    val index = getIndexFromSeatDesignator(seat) ?: return false

    return seatStatus[index] == "O"
}

fun isValidSeatDesignator(seat: String): Boolean {

    // check to see if the seat argument is valid
    // it must be 2 characters long
    // the first character must be either any number from 1 to 9
    // the second character must be either A, a, B, b, C or c. D or d
    // returns true if valid
    // returns false if invalid

    if (seat.length != 2) {
        return false
    }

    val row = seat.substring(0, 1)
    val col = seat.substring(1, 2).toLowerCase()

    return (col in "a".."d") && (row in "1".."9")
}

fun releaseSeat(seat: String) {

    // marks the seat in the seat status array with an O
    // sets the passenger name for the seat to null

    if (isSeatAvailable(seat)) {
        return
    }

    val index = getIndexFromSeatDesignator(seat) ?: return

    seatStatus[index] = "O"
    passengers[index] = null
}


fun getPassengerAt(index: Int): String? {

// this function gets the name of the passenger at a seat
// returns null if the seat is not valid
// also returns null if the seat is not taken

    if (index !in 0..35) {
        return null
    }
    return passengers[index]
}

fun getPassengerAt(seat: String): String? {

    // this function gets the name of the passenger at a seat
    // returns null if the seat is not valid
    // also returns null if the seat is not taken

    val index = getIndexFromSeatDesignator(seat) ?: return null
    return passengers[index]
}

fun reserveSeat(seat: String, name: String) {

    // marks the seat in the seat status array with an X
    // sets the passenger name for the seat to name

    if (!isSeatAvailable(seat)) {
        return
    }

    val index = getIndexFromSeatDesignator(seat) ?: return

    seatStatus[index] = "X"
    passengers[index] = name
}

