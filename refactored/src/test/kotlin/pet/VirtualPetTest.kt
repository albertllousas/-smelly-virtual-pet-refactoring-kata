package pet

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class VirtualPetTest {

    @Test
    fun `should play chess`() {
        VirtualPet().apply { interact("play chess") } shouldBe VirtualPet(hunger = 50, happiness = 60, energy = 45)
    }

    @Test
    fun `should play with toys`() {
        VirtualPet().apply { interact("play toys") } shouldBe VirtualPet(hunger = 52, happiness = 70, energy = 40)
    }

    @Test
    fun `should feed meat`() {
        VirtualPet().apply { interact("feed meat") } shouldBe VirtualPet(hunger = 30, happiness = 50, energy = 65)
    }

    @Test
    fun `should feed vegetables`() {
        VirtualPet().apply { interact("feed vegetables") } shouldBe VirtualPet(hunger = 40, happiness = 50, energy = 55)
    }

    @Test
    fun `should feed candy`() {
        VirtualPet().apply { interact("feed candy") } shouldBe VirtualPet(hunger = 45, happiness = 50, energy = 60)
    }

    @Test
    fun `should rest`() {
        VirtualPet().apply { interact("rest") } shouldBe VirtualPet(hunger = 60, happiness = 50, energy = 80)
    }

    @Test
    fun `should not apply any change on the pet for invalid inputs`() {
        VirtualPet().apply { interact("feed spaghetti") } shouldBe VirtualPet(hunger = 50, happiness = 50, energy = 50)
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
