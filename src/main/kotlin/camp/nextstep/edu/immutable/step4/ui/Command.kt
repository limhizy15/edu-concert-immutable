package camp.nextstep.edu.immutable.step4.ui

enum class Command(
    val rawCommand: String,
) {
    ADD(rawCommand = "add"),
    SHOW(rawCommand = "show"),
    VACATION(rawCommand = "vacation"),
    ;

    companion object {
        fun find(rawCommand: String): Command? =
            values().find { it.rawCommand == rawCommand }
    }
}
