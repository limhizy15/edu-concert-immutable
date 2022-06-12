package camp.nextstep.edu.immutable

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

private data class Employee(val name: String, val age: Int)

private data class Employees(val employees: List<Employee>) {

    fun filterOlderThan30(): Employees {
        TODO()
    }
}

class EmployeesTest {

    @Test
    fun `30세 초과인 사원을 필터링할 수 있어야 한다`() {
        // given
        val employees = Employees(
            listOf(
                Employee(name = "김", age = 20),
                Employee(name = "이", age = 32),
                Employee(name = "강", age = 40),
            )
        )

        // when
        val filteredEmployees = employees.filterOlderThan30()

        // then
        assertThat(filteredEmployees.employees)
            .allMatch { it.age > 30 }
    }

}
