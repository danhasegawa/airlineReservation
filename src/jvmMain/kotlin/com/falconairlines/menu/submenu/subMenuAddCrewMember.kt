package com.falconairlines.menu.submenu

var captain: String? = null
var firstOfficer: String? = null
var attendants = ArrayList<String>()

fun subMenuAddCrewMember() {

    println("*** Add Crew Member ***")

    var subMenuDone = false

    do {

        println("1. Captain")
        println("2. First Officer")
        println("3. Flight Attendant")
        println("X. Back to Main Menu")
        println()
        println("Please select the role to add:")

        var role: String?

        var roleLoopDone = false

        do {
            role = readLine() ?: ""

            when (role) {

                "1" -> {
                    var captainName: String?

                    do {
                        println("Please enter the captain's name (min. 2 characters):")
                        captainName = readLine()
                    } while (captainName == null || captainName.length < 2)

                    captain = captainName asRole "Captain" // Task 7 and 8
                    printCrew()
                    roleLoopDone = true
                }

                "2" -> {
                    var firstOfficerName: String?
                    do {
                        println("Please enter the first officer's name (min. 2 characters):")
                        firstOfficerName = readLine()
                    } while (firstOfficerName == null || firstOfficerName.length < 2)

                    firstOfficer = firstOfficerName asRole "First Officer" // Task 7 and 8
                    printCrew()
                    roleLoopDone = true
                }

                "3" -> {
                    var attendantName: String?
                    do {
                        println("Please enter the flight attendant's name (min. 2 characters):")
                        attendantName = readLine()
                    } while (attendantName == null || attendantName.length < 2)

                    attendants.add(attendantName asRole "Attendants") // Task 7 and 8
                    printCrew()
                    roleLoopDone = true
                }

                "X", "x" -> {
                    roleLoopDone = true
                    subMenuDone = true
                }

                else -> println(">>> Invalid crew role. Please try again. <<<")

            }

        } while (!roleLoopDone)

    } while (!subMenuDone)

}

infix fun String.asRole(role: String): String {
    return role + " - " + this
}

fun printCrew() {

    println("** Flight Crew **")
    println(captain ?: "<No captain assigned>")
    println(firstOfficer ?: "<No first officer assigned>")

    if (attendants.count() == 0) {
        println("<No flight attendants assigned>")
    } else {
        attendants.forEach { println(it) }
    }
    println()
}