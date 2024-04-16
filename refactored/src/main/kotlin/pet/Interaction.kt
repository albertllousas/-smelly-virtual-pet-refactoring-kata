package pet

fun interface Interaction {
    operator fun invoke(pet: VirtualPet): VirtualPet

    companion object {
        val playHideAndSeek = Interaction { VirtualPet(it.hunger + 10, it.happiness + 15, it.energy - 15) }

        val playChess = Interaction { VirtualPet(it.hunger, it.happiness + 10, it.energy - 5) }

        val playWithToys = Interaction { VirtualPet(it.hunger + 2, it.happiness + 20, it.energy - 10) }

        val feedWithMeat = Interaction { VirtualPet(it.hunger - 20, it.happiness, it.energy + 15) }

        val feedWithVegetables = Interaction { VirtualPet(it.hunger - 10, it.happiness, it.energy + 5) }

        val feedWithCandy = Interaction { VirtualPet(it.hunger - 5, it.happiness, it.energy + 10) }

        val rest = Interaction { VirtualPet(it.hunger + 10, 50, it.energy + 30) }

        val doNothing = Interaction { VirtualPet(it.hunger + 5, it.happiness - 5, it.energy - 5) }

        val walk: (minutes: Int) -> Interaction = { min ->
            Interaction {
                if (min > 0) VirtualPet(it.hunger + (2 * min), it.happiness - (2 * min), it.energy - (2 * min))
                else it
            }
        }
    }
}
