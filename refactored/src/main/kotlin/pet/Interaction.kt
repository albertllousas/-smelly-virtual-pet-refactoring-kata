package pet

fun interface Interaction {
    operator fun invoke(pet: VirtualPet): VirtualPet

    companion object {
        val playHideAndSeek = Interaction { pet ->
            VirtualPet(hunger = pet.hunger + 10, happiness = pet.happiness + 15, energy = pet.energy - 15)
        }

        val playChess = Interaction { pet ->
            VirtualPet(hunger = pet.hunger, happiness = pet.happiness + 10, energy = pet.energy - 5)
        }
    }
}