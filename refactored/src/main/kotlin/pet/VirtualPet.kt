package pet

import pet.Interaction.Companion.doNothing
import pet.Interaction.Companion.feedWithCandy
import pet.Interaction.Companion.feedWithMeat
import pet.Interaction.Companion.feedWithVegetables
import pet.Interaction.Companion.playChess
import pet.Interaction.Companion.playHideAndSeek
import pet.Interaction.Companion.playWithToys
import pet.Interaction.Companion.rest

class VirtualPet(hunger: Int = 50, happiness: Int = 50, energy: Int = 50) {

    var hunger = hunger
        private set
    var happiness = happiness
        private set
    var energy = energy
        private set

    fun interact(action: String) {
        if (isAlive()) {
            when(action) {
                "play hide-and-seek" -> playHideAndSeek(this)
                "play chess" -> playChess(this)
                "play toys" -> playWithToys(this)
                "feed meat" -> feedWithMeat(this)
                "feed vegetables" -> feedWithVegetables(this)
                "feed candy" -> feedWithCandy(this)
                "rest" -> rest(this)
                "nothing" -> doNothing(this)
                else -> this
            }.let { updateWith(it) }
        }
    }

    private fun updateWith(pet: VirtualPet) {
        hunger = pet.hunger.coerceIn(0, 100)
        happiness = pet.happiness.coerceIn(0, 100)
        energy = pet.energy.coerceIn(0, 100)
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
