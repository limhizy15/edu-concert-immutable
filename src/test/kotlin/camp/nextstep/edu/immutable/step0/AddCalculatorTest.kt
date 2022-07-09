package camp.nextstep.edu.immutable.step0

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AddCalculatorTest {
    private  val addCalculator = AddCalculator()
    @Test
    fun `1과 2를 더하면 3이 나와야 한다`() {
        // given

        // when
        val result = addCalculator.add(first = 1, second = 2)

        // then
        assertThat(result).isEqualTo(3)
    }
}

class AddCalculator {
    fun add(first: Int, second: Int): Int {
        return first + second;
    }
}