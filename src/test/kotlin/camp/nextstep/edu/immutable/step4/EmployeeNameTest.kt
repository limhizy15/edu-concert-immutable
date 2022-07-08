package camp.nextstep.edu.immutable.step4

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class EmployeeNameTest {
    @Test
    fun `이름은 2자 이상이어야 한다`() {
        // when
        val actual = EmployeeName("김태현")

        // then
        assertThat(actual).isNotNull
    }

    @Test
    fun `1글자 이름은 만들 수 없어야 한다`() {
        // when then
        assertThatThrownBy { EmployeeName("김") }
    }
}
