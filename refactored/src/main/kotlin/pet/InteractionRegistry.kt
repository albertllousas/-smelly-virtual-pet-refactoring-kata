package pet

data class InteractionRegistry(val interactions: Map<String, Interaction> = mapOf()) {

    fun register(action: String, interaction: Interaction) = InteractionRegistry(interactions + (action to interaction))

    fun get(name: String): Interaction? = interactions[name]

    companion object {
        val default = InteractionRegistry()
            .register("play hide-and-seek", Interaction.playHideAndSeek)
            .register("play chess", Interaction.playChess)
            .register("play toys", Interaction.playWithToys)
            .register("feed meat", Interaction.feedWithMeat)
            .register("feed vegetables", Interaction.feedWithVegetables)
            .register("feed candy", Interaction.feedWithCandy)
            .register("rest", Interaction.rest)
            .register("nothing", Interaction.doNothing)
    }
}
