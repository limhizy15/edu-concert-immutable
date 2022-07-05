package camp.nextstep.edu.immutable.step4

fun main() {
    print("명령어를 입력하세요: ")

    val arguments = readln().split(" ")
    val rawCommand = arguments.first()
    val command = Command.find(rawCommand)
        ?: throw UnsupportedOperationException("Unsupported command: $rawCommand")

    when (command) {
        Command.SHOW -> TODO("구현해보세요 :)")
        Command.VACATION -> TODO("구현해보세요 :)")
    }

}