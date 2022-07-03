package camp.nextstep.edu.immutable.step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class EmployeeManager {
    private val _employees: MutableList<Employee> = mutableListOf()
    val employees: List<Employee>
        get() = _employees

    fun addEmployee(employee: Employee) {
        _employees.add(employee)
    }
}

class DefensiveCopyTest {
    private val employeeManager = EmployeeManager()

    @Test
    fun `외부에서 접근 가능한 List와 내부의 List는 서로 변경사항이 공유되지 않아야한다`() {
        // given
        val employees = employeeManager.employees

        // when
        val employee = Employee("홍길동", 0)
        employeeManager.addEmployee(employee)

        // then
        assertAll(
            { assertThat(employees).doesNotContain(employee) },
            { assertThat(employees).isEmpty() }
        )
    }

    @Test
    fun `연봉이 바뀌지 않아야 한다`() {
        // given
        val expectedEmployee = Employee("홍길동", 100_000_000)
        employeeManager.addEmployee(expectedEmployee)

        // when
        val actualException = catchException {
            (employeeManager.employees as MutableList<Employee>)
                .replaceAll { it.copy(salary = 0) }
        }

        // then
        val actualEmployee = employeeManager.employees.find { it.name == expectedEmployee.name }
        assertAll(
            { assertThat(actualEmployee?.salary).isEqualTo(100_000_000) },
            { assertThat(actualException).isNotNull() },
        )
    }
}
