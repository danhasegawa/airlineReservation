package com.falconairlines.menu

import java.util.*

fun showMainMenu() {
    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    println("*                                      *")
    println("*      Welcome to Falcon Airlines      *")
    println("*                                      *")
    println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    println()

    // Task 6: add a date time stamp
    var date: Date = Calendar.getInstance().time
    println("It is now $date")


    println()
    println("**** MAIN MENU ****")
    println()
    println("1 = Book a seat")
    println("2 = Add crew member")
    println("3 = Manifest")
    println("4 = Cancel a reservation")
    println("5 = Reset Flight")
    println("X = Exit")
    println()
    println("What would you like to do?")
    println("Please enter an option:")
}