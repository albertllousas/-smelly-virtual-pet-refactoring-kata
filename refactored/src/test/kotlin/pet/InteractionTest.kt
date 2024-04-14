package pet

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import pet.Interaction.Companion.playChess
import pet.Interaction.Companion.playHideAndSeek
import pet.Interaction.Companion.playWithToys

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
}
