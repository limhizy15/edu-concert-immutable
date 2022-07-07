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

        fun of(
            name: String,
            joinedAt: LocalDate,
            currentDate: LocalDate = LocalDate.now(),
        ): Employee {
            return Employee(
                name = name,
                joinedAt = joinedAt,
                unusedVacationCount = calculateUnusedVacationCount(joinedAt, currentDate),
                usedVacationDates = emptyList(),
            )
        }

        private fun calculateUnusedVacationCount(
            joinedAt: LocalDate,
            currentDate: LocalDate,
        ): Int {
            val period = Period.between(joinedAt, currentDate)
            if (period.years > FULL_VACATION_YEAR) {
                return FULL_VACATION_COUNT
            }
            return period.months
        }
    }
}
