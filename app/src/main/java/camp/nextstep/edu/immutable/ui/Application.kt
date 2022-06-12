package camp.nextstep.edu.immutable.ui

import camp.nextstep.edu.immutable.Employee

fun main() {
    println("명령어를 입력해주세요. (${Command.RAW_COMMANDS})")

    val rawCommand = readln()
    val command = Command.find(rawCommand)
        ?: throw UnsupportedOperationException("Unsupported command: $rawCommand")

    when (command) {
        Command.SHOW_ALL -> printEmployees(EmployeeDatabase.loadEmployees())
    }
}

private fun printEmployees(employees: List<Employee>) {
    employees.forEach(::printEmployee)
}

private fun printEmployee(employee: Employee) {
    val text = """
        =========================================
        이름: ${employee.name}
        연봉: ${employee.salary}
        휴가 사용일 목록: ${employee.usedVacations}
        남은 휴가일수: ${employee.unusedVacationCount}
        =========================================
    """.trimIndent()
    println(text + "\n")
}

