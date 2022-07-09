package camp.nextstep.edu.immutable.step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

// NOTE: 보통 실무에서는 `src/main/kotlin` 디렉토리에 위치시킵니다. 실습 편의를 위해 테스트 디렉토리에 둡니다.
private data class Employee(var name: String) {

    fun changeName(name: String): Employee {
        return this.copy(name = name)
    }
}

internal class EmployeeTest {

    @Test
    fun `사용자의 이름을 변경한다`() {
        // given
        val employee = Employee(name = "홍길동")

        // when
        val newEmployee: Employee = employee.changeName("김길동")

        // then
        assertThat(employee.name).isEqualTo("홍길동")
        assertThat(newEmployee.name).isEqualTo("김길동")
    }
}
