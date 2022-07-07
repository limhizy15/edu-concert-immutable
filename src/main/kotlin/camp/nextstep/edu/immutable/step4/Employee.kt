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
        fun of(
            name: String,
            joinedAt: LocalDate,
            currentDate: LocalDate = LocalDate.now(),
        ): Employee {
            val unusedVacationCount = Period.between(joinedAt, currentDate).months
            return Employee(
                name = name,
                joinedAt = joinedAt,
                unusedVacationCount = unusedVacationCount,
                usedVacationDates = emptyList(),
            )
        }
    }
}
