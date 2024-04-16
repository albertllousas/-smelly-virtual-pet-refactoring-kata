package pet

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class InteractionRegistryTest {

    @Test
    fun `should allow to register interactions`() {
        val playBasketball = Interaction { VirtualPet(it.hunger + 15, it.happiness + 15, it.energy - 15) }
        val registry = InteractionRegistry.default.register(
                action = "play basketball",
                interaction = playBasketball
            )

        val result = registry.get("play basketball")?.invoke(VirtualPet())

        result shouldBe VirtualPet(hunger = 65, happiness = 65, energy = 35)
    }

    @Test
    fun `should allow to registry interactions with an argument`() {
        val groom: (seconds: Int) -> Interaction = { seconds: Int ->
            Interaction { VirtualPet(hunger = it.hunger, happiness = it.happiness + seconds, energy = it.energy) }
        }
        val registry = InteractionRegistry.default.register(
            action = "groom",
            interaction = { argument -> groom(argument.toInt()) }
        )

        val result = registry.get("groom 2")?.invoke(VirtualPet())

        result shouldBe VirtualPet(hunger=50, happiness=52, energy=50)
    }
}
