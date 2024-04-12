package pet

fun interface Interaction {
    operator fun invoke(pet: VirtualPet): VirtualPet

    companion object {
        val playHideAndSeek = Interaction { pet ->
            VirtualPet(hunger = pet.hunger + 10, happiness = pet.happiness + 15, energy = pet.energy - 15)
        }
    }
}