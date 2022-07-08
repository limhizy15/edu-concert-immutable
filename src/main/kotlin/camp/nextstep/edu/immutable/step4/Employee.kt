package camp.nextstep.edu.immutable.step4

import java.time.LocalDate

data class Employee(
    val name: EmployeeName,
    val vacations: Vacations,
) {
    fun useVacation(date: LocalDate): Employee {
        return copy(vacations = vacations.useVacation(date))
    }

    fun useVacation(dates: List<LocalDate>): Employee {
        return dates.fold(this, Employee::useVacation)
    }

    companion object {
        fun of(
            name: EmployeeName,
            unusedVacationCount: Int,
        ): Employee {
            return Employee(
                name = name,
                vacations = Vacations.of(unusedVacationCount),
            )
        }
    }
}
