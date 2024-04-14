package pet

import pet.Interaction.Companion.feedWithCandy
import pet.Interaction.Companion.feedWithMeat
import pet.Interaction.Companion.feedWithVegetables
import pet.Interaction.Companion.playChess
import pet.Interaction.Companion.playHideAndSeek
import pet.Interaction.Companion.playWithToys

class VirtualPet(hunger: Int = 50, happiness: Int = 50, energy: Int = 50) {

    var hunger = hunger
        private set
    var happiness = happiness
        private set
    var energy = energy
        private set

    fun interact(action: String) {

        val parts = action.split(" ")

        if (isAlive()) {
            if (parts[0] == "play") {
                if (parts[1] == "hide-and-seek") {
                    playHideAndSeek(this).let { updateWith(it) }
                } else if (parts[1] == "chess") {
                    playChess(this).let { updateWith(it) }
                } else if (parts[1] == "toys") {
                    playWithToys(this).let { updateWith(it) }
                }
            } else if (parts[0] == "feed") {
                if (parts[1] == "meat") {
                    feedWithMeat(this).let { updateWith(it) }
                } else if (parts[1] == "vegetables") {
                    feedWithVegetables(this).let { updateWith(it) }
                } else if (parts[1] == "candy") {
                    feedWithCandy(this).let { updateWith(it) }
                }
            } else if (parts[0] == "rest") {
                energy += 30
                hunger += 10
                happiness = 50
            } else if (parts[0] == "nothing") {
                hunger += 5
                happiness -= 5
                energy -= 5
            }
            hunger = hunger.coerceIn(0, 100)
            happiness = happiness.coerceIn(0, 100)
            energy = energy.coerceIn(0, 100)
        }
    }

    private fun updateWith(pet: VirtualPet) {
        hunger = pet.hunger
        happiness = pet.happiness
        energy = pet.energy
    }

    private fun isAlive() = hunger != 100 && happiness != 0 && energy != 0

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

    override fun toString(): String = "VirtualPet(hunger=$hunger, happiness=$happiness, energy=$energy)"
}
