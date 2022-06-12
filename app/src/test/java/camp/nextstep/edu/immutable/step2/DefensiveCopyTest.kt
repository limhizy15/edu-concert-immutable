package camp.nextstep.edu.immutable.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DefensiveCopyTest {

    @Test
    fun `2개의 리스트는 서로 값이 공유되지 않아야한다`() {
        // given
        val list1: MutableList<Int> = mutableListOf(1, 2, 3)

        // when
        val list2: List<Int> = list1
        list1.add(4)

        // then
        assertThat(list1).isNotEqualTo(list2)
        assertThat(list1).containsExactly(1, 2, 3, 4)
        assertThat(list2).containsExactly(1, 2, 3)
    }
}
