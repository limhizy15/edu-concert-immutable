package camp.nextstep.edu.immutable.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private data class Employees(private val values: List<Employee>) {
    fun filterKim(): Employees {
        TODO("구현해보세요 :)")
    }

    fun toList(): List<Employee> = values.toList()

    companion object {
        val EMPTY = Employees(emptyList())
    }
}

/** 클래스로 분리 */
private class EmployeeManager3 {
    private val employees: Employees = Employees.EMPTY
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
        assertThat(actual).allMatch { it.name.startsWith("김") }
    }
}