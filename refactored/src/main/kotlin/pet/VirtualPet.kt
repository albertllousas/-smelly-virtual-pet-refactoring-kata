package pet

class VirtualPet(var hunger: Int = 50, var happiness: Int = 50, var energy: Int = 50) {

    fun interact(action: String) {

        val parts = action.split(" ")

        if (hunger != 100 && happiness != 0 && energy != 0) {
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
            hunger = hunger.coerceIn(0, 100)
            happiness = happiness.coerceIn(0, 100)
            energy = energy.coerceIn(0, 100)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VirtualPet

        if (hunger != other.hunger) return false
        if (happiness != other.happiness) return false
        if (energy != other.energy) return false

        return true
    }

    override fun hashCode(): Int {
        var result = hunger
        result = 31 * result + happiness
        result = 31 * result + energy
        return result
    }

    override fun toString(): String =  "VirtualPet(hunger=$hunger, happiness=$happiness, energy=$energy)"
}
