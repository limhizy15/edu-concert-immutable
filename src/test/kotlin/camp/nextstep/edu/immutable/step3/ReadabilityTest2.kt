package camp.nextstep.edu.immutable.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/** 확장함수로 분리 */
private class EmployeeManager2 {
    private val employees: List<Employee> = emptyList()
    val kimEmployees: List<Employee> = employees.filterKim()

    private fun List<Employee>.filterKim(): List<Employee> {
        TODO("구현해보세요 :)")
    }
}

class ReadabilityTest2 {

    @Test
    fun `김씨 직원들을 필터링해서 볼 수 있어야 한다`() {
        // given
        val employeeManager = EmployeeManager2()

        // when
        val actual = employeeManager.kimEmployees

        // then
        assertThat(actual).allMatch { it.name.startsWith("김") }
    }
}