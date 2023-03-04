package com.falconairlines.menu.submenu

import com.falconairlines.function.getSeatDesignatorFromIndex
import java.math.BigDecimal
import java.math.RoundingMode

fun subMenuManifest() {

    println("**** Manifest ****")
    println()

    val totalSeats = 36
    var seatsBooked = 0

    // list the crew

    printCrew()

    // list the passenger

    println("** Passengers **")


    // Higher order functions

    // Task 5: chain first two higher order functions together and convert passengerName as a sequence
    var lines = passengers.asSequence().mapIndexed { index, it -> getSeatDesignatorFromIndex(index) + " " + it }
        .filterIndexed { index, it -> !isSeatAvailable(index) }

    // Task 4: print all lines
    lines.forEach { println(it) }

    println()

    // Task 4: count seats booked
    seatsBooked = lines.count()


    if (seatsBooked == 0) {
        println("<No passengers have been booked on this flight.>")
        println()
    }

    println("Booked: $seatsBooked")
    println("Available: " + (totalSeats - seatsBooked))
    println("Capacity: $totalSeats")

    val percentage = (seatsBooked.toDouble() / totalSeats.toDouble()) * 100.0

    println("Percent full: " + BigDecimal(percentage).setScale(1, RoundingMode.HALF_EVEN) + "%")

    println()
    println("Press ENTER to return to the main menu.")
    readLine()
}