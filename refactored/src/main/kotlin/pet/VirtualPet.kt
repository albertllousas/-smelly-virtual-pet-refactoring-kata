package pet

class VirtualPet(
    hunger: Int = 50,
    happiness: Int = 50,
    energy: Int = 50,
    val interactionRegistry: InteractionRegistry = InteractionRegistry.default
) {

    var hunger = hunger
        private set
    var happiness = happiness
        private set
    var energy = energy
        private set

    fun interact(action: String) {
        if (isAlive()) {
            (interactionRegistry.get(action)?.let { interaction ->  interaction(this) } ?: this).let { updateWith(it) }
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
