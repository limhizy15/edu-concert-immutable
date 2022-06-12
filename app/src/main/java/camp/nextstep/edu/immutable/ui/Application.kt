package camp.nextstep.edu.immutable.ui

fun main() {
    println("명령어를 입력해주세요. (${Command.RAW_COMMANDS})")

    val rawCommand = readln()
    val command = Command.find(rawCommand)
        ?: throw UnsupportedOperationException("Unsupported command: $rawCommand")

    when (command) {
        Command.SHOW_ALL -> println(EmployeeDatabase.loadEmployees())
    }
}

