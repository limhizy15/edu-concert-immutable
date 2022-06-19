package camp.nextstep.edu.immutable.step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private data class Employee(val name: String, val age: Int)

internal class EmployeeTest {

    @Test
    fun `사용자의 이름을 변경한다`() {
        // given
        val employee = Employee(name = "홍길동", age = 10)

        // when
        val newEmployee: Employee = TODO()

        // then
        assertThat(newEmployee.name).isEqualTo("김길동")
        assertThat(newEmployee.age).isEqualTo(10)
    }

}
