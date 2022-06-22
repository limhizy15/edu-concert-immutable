package camp.nextstep.edu.immutable.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/** inline 상태로 사용 */
private class EmployeeManager1 {
    private val employees: List<Employee> = listOf(
        Employee("김태현"),
        Employee("김수현"),
        Employee("박재성"),
    )

    val kimEmployees: List<Employee> = employees
        .filter { TODO("구현해보세요 :)") }
}

class ReadabilityTest1 {

    @Test
    fun `김씨 직원들을 필터링해서 볼 수 있어야 한다`() {
        // given
        val employeeManager = EmployeeManager1()

        // when
        val actual = employeeManager.kimEmployees

        // then
        assertThat(actual).containsExactly(Employee("김태현"), Employee("김수현"))
    }
}