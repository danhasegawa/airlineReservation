package com.falconairlines

import com.falconairlines.menu.showMainMenu
import com.falconairlines.menu.submenu.*
import java.util.*

fun main() {

    var option: String? = " "

    while (option?.uppercase(Locale.getDefault()) != "X") {

        showMainMenu()

        option = readLine() ?: " "

        when (option) {
            "1" -> subMenuBookASeat()
            "2" -> subMenuAddCrewMember()
            "3" -> subMenuManifest()
            "4" -> subMenuCancelReservation()
            "5" -> subMenuResetFlight()
            "X", "x" -> println(">>> Have a wanderful day! Bark! <<<")
            else -> println(">>> Sorry, not a valid option. Wag! <<<")
        }
    }
}
