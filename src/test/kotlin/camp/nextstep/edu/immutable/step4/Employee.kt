package camp.nextstep.edu.immutable.step4

import java.time.LocalDateTime

class Employee {
    var name: String? = null
    var salary: Int? = null
    var unusedVacationCount: Int = 0
    var usedVacations: MutableList<LocalDateTime>? = null
}
