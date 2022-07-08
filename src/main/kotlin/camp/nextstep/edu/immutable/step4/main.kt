package camp.nextstep.edu.immutable.step4

import java.time.LocalDate

private val employeeRepository = EmployeeRepository().apply {
    val sampleEmployee = Employee
        .of(
            name = "김수현",
            unusedVacationCount = 7,
        )
    save(sampleEmployee)
}

fun main() {
    while (true) {
        readCommand()
    }
}

private fun readCommand() {
    print("명령어를 입력하세요: ")

    val arguments = readln().split(" ")
    val rawCommand = arguments.first()
    val command = Command.find(rawCommand)
        ?: throw UnsupportedOperationException("Unsupported command: $rawCommand")

    when (command) {
        Command.SHOW -> {
            val employeeName = arguments.drop(1).first()
            val employee = employeeRepository.findEmployee(employeeName)
                ?: throw IllegalArgumentException("사원을 찾지 못했습니다. employeeName: $employeeName")
            showEmployee(employee)
        }
        Command.VACATION -> {
            val employeeName = arguments.drop(1).first()
            val employee = employeeRepository.findEmployee(employeeName)
                ?: throw IllegalArgumentException("사원을 찾지 못했습니다. employeeName: $employeeName")

            val commandArguments = arguments.drop(2)
            val vacationDates = commandArguments.map(LocalDate::parse)
            val newEmployee = vacationDates.fold(employee, Employee::useVacation)
            employeeRepository.save(newEmployee)
            showEmployee(newEmployee)
        }
    }
}

private fun showEmployee(employee: Employee) {
    val usedVacations = employee.usedVacationDates.joinToString(" ")
    val text = """
        이름: ${employee.name}
        남은 휴가일수: ${employee.unusedVacationCount}
        휴가일: $usedVacations
    """.trimIndent()
    println(text)
    println()
}
