package camp.nextstep.edu.immutable

import java.time.LocalDateTime

class Employee {
    var name: String? = null
    var salary: Int? = null
    var unusedVacationCount: Int = 0
    var usedVacations: MutableList<LocalDateTime>? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employee

        if (name != other.name) return false
        if (salary != other.salary) return false
        if (unusedVacationCount != other.unusedVacationCount) return false
        if (usedVacations != other.usedVacations) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (salary ?: 0)
        result = 31 * result + unusedVacationCount
        result = 31 * result + (usedVacations?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Employee(name=$name, salary=$salary, unusedVacationCount=$unusedVacationCount, usedVacations=$usedVacations)"
    }


}
