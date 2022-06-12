package camp.nextstep.edu.immutable.step1

import com.google.common.truth.Truth.assertThat
import camp.nextstep.edu.immutable.Employee
import org.junit.Test


internal class EmployeeTest {

    @Test
    fun `사용자의 이름을 변경한다`() {
        // given
        val employee = Employee(name = "홍길동", age = 10)

        // when
        val newUser = employee.copy("김길동")

        // then
        assertThat(newUser.name).isEqualTo("김길동")
    }

}
