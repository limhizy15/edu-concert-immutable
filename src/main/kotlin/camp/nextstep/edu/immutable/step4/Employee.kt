package camp.nextstep.edu.immutable.step4

import java.time.LocalDate

data class Employee(
    val name: String,
    val unusedVacationCount: Int,
    val usedVacationDates: List<LocalDate>,
) {
    init {
        require(unusedVacationCount >= MIN_VACATION_COUNT)
    }

    fun useVacation(date: LocalDate): Employee {
        return copy(
            unusedVacationCount = unusedVacationCount - 1,
            usedVacationDates = usedVacationDates + date,
        )
    }

    companion object {
        private const val MIN_VACATION_COUNT = 0

        fun of(
            name: String,
            unusedVacationCount: Int,
        ): Employee {
            return Employee(
                name = name,
                unusedVacationCount = unusedVacationCount,
                usedVacationDates = emptyList(),
            )
        }
    }
}
