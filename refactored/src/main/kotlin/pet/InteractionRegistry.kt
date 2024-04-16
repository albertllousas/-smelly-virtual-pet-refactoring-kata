package pet

data class InteractionRegistry(
    val interactions: Map<String, Interaction> = mapOf(),
    val interactionsWithAnArgument: Map<String, (argument: String) -> Interaction> = mapOf()
) {

    fun register(action: String, interaction: Interaction) = this.copy(
        interactions = interactions + (action to interaction)
    )

    fun register(action: String, interaction: (argument: String) -> Interaction) = this.copy(
        interactionsWithAnArgument = interactionsWithAnArgument + (action to interaction)
    )

    fun get(action: String): Interaction? =
        if (interactions[action] != null) interactions[action]
        else {
            val parts = action.split(" ")
            interactionsWithAnArgument[parts[0]]?.invoke(parts[1])
        }

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
            .register("walk") { min -> Interaction.walk(min.toInt()) }
    }
}
