package camp.nextstep.edu.immutable.step4

import java.time.LocalDate

data class Employee(
    val name: String,
    val joinedAt: LocalDate,
    val unusedVacationCount: Int,
    val usedVacationDates: List<LocalDate>,
)
