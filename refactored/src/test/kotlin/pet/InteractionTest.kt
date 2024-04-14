package pet

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import pet.Interaction.Companion.doNothing
import pet.Interaction.Companion.feedWithCandy
import pet.Interaction.Companion.feedWithMeat
import pet.Interaction.Companion.feedWithVegetables
import pet.Interaction.Companion.playChess
import pet.Interaction.Companion.playHideAndSeek
import pet.Interaction.Companion.playWithToys
import pet.Interaction.Companion.rest

class InteractionTest {

    @Test
    fun `should play hide and seek`() {
        playHideAndSeek(VirtualPet()) shouldBe VirtualPet(hunger = 60, happiness = 65, energy = 35)
    }

    @Test
    fun `should play chess`() {
        playChess(VirtualPet()) shouldBe VirtualPet(hunger = 50, happiness = 60, energy = 45)
    }

    @Test
    fun `should play with toys`() {
        playWithToys(VirtualPet()) shouldBe VirtualPet(hunger = 52, happiness = 70, energy = 40)
    }

    @Test
    fun `should feed with meat`() {
        feedWithMeat(VirtualPet()) shouldBe VirtualPet(hunger = 30, happiness = 50, energy = 65)
    }

    @Test
    fun `should feed with vegetables`() {
        feedWithVegetables(VirtualPet()) shouldBe VirtualPet(hunger = 40, happiness = 50, energy = 55)
    }

    @Test
    fun `should feed with candy`() {
        feedWithCandy(VirtualPet()) shouldBe VirtualPet(hunger = 45, happiness = 50, energy = 60)
    }

    @Test
    fun `should rest`() {
        rest(VirtualPet()) shouldBe VirtualPet(hunger = 60, happiness = 50, energy = 80)
    }

    @Test
    fun `should do nothing`() {
        doNothing(VirtualPet()) shouldBe VirtualPet(hunger = 55, happiness = 45, energy = 45)
    }
}
