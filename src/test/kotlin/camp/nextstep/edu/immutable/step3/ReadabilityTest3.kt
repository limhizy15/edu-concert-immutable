package camp.nextstep.edu.immutable.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private data class Employees(private val values: List<Employee>) {
    fun filterKim(): Employees {
        TODO("구현해보세요 :)")
    }

    fun toList(): List<Employee> = values.toList()
}

/** 클래스로 분리 */
private class EmployeeManager3 {
    private val employees: Employees = Employees(
        listOf(
            Employee("김태현"),
            Employee("김수현"),
            Employee("박재성"),
        )
    )
    val kimEmployees: Employees = employees.filterKim()
}

class ReadabilityTest3 {

    @Test
    fun `김씨 직원들을 필터링해서 볼 수 있어야 한다`() {
        // given
        val employeeManager = EmployeeManager3()

        // when
        val actual = employeeManager.kimEmployees.toList()

        // then
        assertThat(actual).containsExactly(Employee("김태현"), Employee("김수현"))
    }
}