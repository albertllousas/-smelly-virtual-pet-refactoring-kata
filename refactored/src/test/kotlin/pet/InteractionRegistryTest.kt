package pet

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class InteractionRegistryTest {

    @Test
    fun `should extend the default interactions with new ones`() {
        val playBasketball = Interaction { VirtualPet(it.hunger + 15, it.happiness + 15, it.energy - 15) }
        val virtualPet = VirtualPet(
            interactionRegistry = InteractionRegistry.default.register(
                action = "play basketball",
                interaction = playBasketball
            )
        )

        val result = virtualPet.apply { interact("play basketball") }

        result shouldBe VirtualPet(hunger = 65, happiness = 65, energy = 35)
    }
}
