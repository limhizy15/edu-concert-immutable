package camp.nextstep.edu.immutable.step4

import java.time.LocalDate
import java.time.Period

data class Employee(
    val name: String,
    val joinedAt: LocalDate,
    val unusedVacationCount: Int,
    val usedVacationDates: List<LocalDate>,
) {
    companion object {
        private const val FULL_VACATION_COUNT = 15
        private const val FULL_VACATION_YEAR = 1

        private const val SPECIAL_VACATION_COUNT = 1
        private const val SPECIAL_EMPLOYEE_FIRST_NAME = "김"

        fun of(
            name: String,
            joinedAt: LocalDate,
            currentDate: LocalDate = LocalDate.now(),
        ): Employee {
            return Employee(
                name = name,
                joinedAt = joinedAt,
                unusedVacationCount = calculateUnusedVacationCount(name, joinedAt, currentDate),
                usedVacationDates = emptyList(),
            )
        }

        private fun calculateUnusedVacationCount(
            name: String,
            joinedAt: LocalDate,
            currentDate: LocalDate,
        ): Int {
            val specialVacationCount = if (name.startsWith(SPECIAL_EMPLOYEE_FIRST_NAME)) {
                SPECIAL_VACATION_COUNT
            } else {
                0
            }

            val period = Period.between(joinedAt, currentDate)
            if (period.years > FULL_VACATION_YEAR) {
                return FULL_VACATION_COUNT + specialVacationCount
            }
            return period.months + specialVacationCount
        }
    }
}
