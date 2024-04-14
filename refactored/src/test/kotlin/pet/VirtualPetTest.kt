package pet

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class VirtualPetTest {

    @Test
    fun `should rest`() {
        VirtualPet().apply { interact("rest") } shouldBe VirtualPet(hunger = 60, happiness = 50, energy = 80)
    }

    @Test
    fun `should not apply any change on the pet for invalid inputs`() {
        VirtualPet().apply { interact("feed spaghetti") } shouldBe VirtualPet(hunger = 50, happiness = 50, energy = 50)
    }

    @Test
    fun `should not apply any change when pet is not alive`() {
        VirtualPet(hunger = 100).apply { interact("play toys") } shouldBe VirtualPet(hunger = 100, happiness = 50, energy = 50)
        VirtualPet(happiness = 0).apply { interact("play toys") } shouldBe VirtualPet(hunger = 50, happiness = 0, energy = 50)
        VirtualPet(energy = 0).apply { interact("play toys") } shouldBe VirtualPet(hunger = 50, happiness = 50, energy = 0)
    }

    @Test
    fun `should do nothing`() {
        VirtualPet().apply { interact("nothing") } shouldBe VirtualPet(hunger = 55, happiness = 45, energy = 45)
    }

    @Test
    fun `should interact with pet`() {
        VirtualPet().apply {
            interact("play hide-and-seek")
            interact("nothing")
            interact("nothing")
            interact("feed meat")
            interact("nothing")
            interact("rest")
            interact("play chess")
            interact("nothing")
            interact("feed vegetables")
            interact("rest")
            interact("nothing")
            interact("play toys")
            interact("feed candy")
            interact("nothing")
            interact("nothing")
        } shouldBe VirtualPet(hunger = 82, happiness = 55, energy = 75)
    }

    @Test
    fun `should over-feed the pet`() {
        VirtualPet().apply {
            interact("feed meat")
            interact("feed candy")
            interact("feed vegetables")
            interact("feed meat")
            interact("feed candy")
            interact("feed vegetables")
        } shouldBe VirtualPet(hunger = 0, happiness = 50, energy = 100)
    }

    @Test
    fun `should over-play with the pet`() {
        VirtualPet().apply {
            interact("play hide-and-seek")
            interact("play chess")
            interact("play toys")
            interact("play hide-and-seek")
            interact("play chess")
            interact("play toys")
        } shouldBe VirtualPet(hunger = 72, happiness = 100, energy = 0)
    }

    @Test
    fun `should over-rest the pet`() {
        VirtualPet().apply {
            interact("rest")
            interact("rest")
            interact("rest")
            interact("rest")
            interact("rest")
            interact("rest")
        } shouldBe VirtualPet(hunger = 100, happiness = 50, energy = 100)
    }
}
