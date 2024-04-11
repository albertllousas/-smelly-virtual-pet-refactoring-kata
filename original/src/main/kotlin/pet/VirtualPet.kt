package pet

class VirtualPet {

    var hunger = 50
    var happiness = 50
    var energy = 50

    fun interact(action: String) {

        val parts = action.split(" ")

        if (hunger != 100 && happiness != 0 && energy != 0) { // means the pet is alive
            if (parts[0] == "play") {
                if (parts[1] == "hide-and-seek") {
                    if (happiness + 15 <= 115) {
                        happiness = happiness + 15
                    }
                    if (energy - 15 >= -15) {
                        energy = energy - 15
                    }
                    if (hunger + 10 <= 110) {
                        hunger = hunger + 10
                    }
                } else if (parts[1] == "chess") {
                    if (happiness + 10 <= 110) {
                        happiness = happiness + 10
                    }
                    if (energy - 5 >= -5) {
                        energy = energy - 5
                    }
                } else if (parts[1] == "toys") {
                    if (happiness + 20 <= 120) {
                        happiness = happiness + 20
                    }
                    if (energy - 10 >= -10) {
                        energy = energy - 10
                    }
                    if (hunger + 2 <= 102) {
                        hunger = hunger + 2
                    }
                }
            } else if (parts[0] == "feed") {
                if (parts[1] == "meat") {
                    if (hunger - 20 >= -20) {
                        hunger = hunger - 20
                    }
                    if (energy + 15 <= 100) {
                        energy = energy + 15
                    }
                } else if (parts[1] == "vegetables") {
                    if (hunger - 10 >= -10) {
                        hunger = hunger - 10
                    }
                    if (energy + 5 <= 105) {
                        energy = energy + 5
                    }
                } else if (parts[1] == "candy") {
                    if (hunger - 5 >= -5) {
                        hunger = hunger - 5
                    }
                    if (energy + 10 <= 110) {
                        energy = energy + 10
                    }
                }
            } else if (parts[0] == "rest") {
                if (energy + 30 <= 130) {
                    energy = energy + 30
                }
                if (hunger + 10 <= 110) {
                    hunger = hunger + 10
                }
                happiness = 50
            } else if (parts[0] == "nothing") {
                if (hunger + 5 <= 105) {
                    hunger = hunger + 5
                }
                if (happiness - 5 >= -5) {
                    happiness = happiness - 5
                }
                if (energy - 5 >= -5) {
                    energy = energy - 5
                }
            }
            if (hunger > 100) {
                hunger = 100
            }
            if (happiness > 100) {
                happiness = 100
            }
            if (energy > 100) {
                energy = 100
            }
            if (hunger < 0) {
                hunger = 0
            }
            if (happiness < 0) {
                happiness = 0
            }
            if (energy < 0) {
                energy = 0
            }
        }
    }
}
