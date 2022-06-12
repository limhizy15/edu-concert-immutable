package camp.nextstep.edu.immutable.step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

private data class Employee(var name: String, var age: Int)

internal class EmployeeTest {

    @Test
    fun `사용자의 이름을 변경한다`() {
        // given
        val employee = Employee(name = "홍길동", age = 10)

        // when
        val newUser: Employee = TODO()

        // then
        assertThat(newUser.name).isEqualTo("김길동")
        assertThat(newUser.age).isEqualTo(10)
    }

}
