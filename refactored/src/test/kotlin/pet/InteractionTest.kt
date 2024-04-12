package pet

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import pet.Interaction.Companion.playHideAndSeek

class InteractionTest {

    @Test
    fun `should play hide and seek`() {
        playHideAndSeek(VirtualPet()) shouldBe VirtualPet(hunger = 60, happiness = 65, energy = 35)
    }
}
