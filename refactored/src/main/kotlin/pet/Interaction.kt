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

        val playWithToys = Interaction { pet ->
            VirtualPet(hunger = pet.hunger + 2, happiness = pet.happiness + 20, energy = pet.energy - 10)
        }

        val feedWithMeat = Interaction { pet ->
            VirtualPet(hunger = pet.hunger - 20, happiness = pet.happiness, energy = pet.energy + 15)
        }

        val feedWithVegetables = Interaction { pet ->
            VirtualPet(hunger = pet.hunger - 10, happiness = pet.happiness, energy = pet.energy + 5)
        }
    }
}