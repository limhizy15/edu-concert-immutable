package camp.nextstep.edu.immutable.step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class EmployeeRepositoryTest {
    private val repository = EmployeeRepository()

    @Test
    fun `사원의 휴가 정보를 조회할 수 있다`() {
        // given
        val employee = Employee(
            name = "김태현",
            unusedVacationCount = 0,
            usedVacationDates = emptyList(),
        )
        repository.save(employee)

        // when
        val actual = repository.findEmployee("김태현")

        // then
        assertAll(
            { assertThat(actual?.unusedVacationCount).isZero() },
            { assertThat(actual?.usedVacationDates).isEmpty() },
        )

    }
}
