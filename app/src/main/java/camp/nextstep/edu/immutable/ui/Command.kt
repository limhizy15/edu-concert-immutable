package camp.nextstep.edu.immutable.ui

enum class Command(
    val rawCommand: String,
) {
    SHOW_ALL(rawCommand = "showAll"),
    // TODO: 명령어 추가
    ;

    companion object {
        val RAW_COMMANDS = values()
            .map(Command::rawCommand)
            .joinToString()

        fun find(rawCommand: String): Command? =
            values().find { it.rawCommand == rawCommand }
    }
}
