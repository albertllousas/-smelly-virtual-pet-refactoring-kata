package pet

class VirtualPet {

    var hunger = 50
    var happiness = 50
    var energy = 50

    fun interact(action: String, item: String?) {
        if (action == "play") {
            if (item == "hide-and-seek") {
                happiness += 20
                energy -= 10
                if (happiness > 100) happiness = 100
                if (energy < 0) energy = 0
            } else if (item == "chess") {
                happiness += 10
                energy -= 5
                if (happiness > 100) happiness = 100
                if (energy < 0) energy = 0
            } else if (item == "twister") {
                happiness += 30
                energy -= 15
                if (happiness > 100) happiness = 100
                if (energy < 0) energy = 0
            }
        } else if (action == "feed") {
            if (item == "meat") {
                hunger -= 20
                happiness += 10
                if (hunger < 0) hunger = 0
            } else if (item == "vegetables") {
                hunger -= 10
                happiness += 5
                if (hunger < 0) hunger = 0
            } else if (item == "candy") {
                hunger -= 5
                happiness -= 10
                if (hunger < 0) hunger = 0
            }
        } else if (action == "rest") {
            energy += 30
            happiness -= 10
            if (energy > 100) energy = 100
            if (happiness < 0) happiness = 0
        }
    }

    fun showStatus() {
        println("Hunger: $hunger, Happiness: $happiness, Energy: $energy")
    }
}
