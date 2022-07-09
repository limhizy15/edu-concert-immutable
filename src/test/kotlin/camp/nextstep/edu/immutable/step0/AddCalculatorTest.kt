package camp.nextstep.edu.immutable.step0

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AddCalculatorTest {
    @Test
    fun `1과 2를 더하면 3이 나와야 한다`() {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.add(first = 1, second = 2)

        // then
        assertThat(result).isEqualTo(3)
    }
}

class Calculator {

    fun add(first: Int, second: Int): Int {
        return first + second
    }
}
