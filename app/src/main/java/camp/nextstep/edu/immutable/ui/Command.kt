package camp.nextstep.edu.immutable.ui

enum class Command(
    val rawCommand: String,
) {
    SHOW_ALL(rawCommand = "showAll"),
    ;

    companion object {
        val RAW_COMMANDS = values()
            .map(Command::rawCommand)
            .joinToString()

        fun find(rawCommand: String): Command? =
            values().find { it.rawCommand == rawCommand }
    }
}
