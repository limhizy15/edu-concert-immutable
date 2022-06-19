package camp.nextstep.edu.immutable.live2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DefensiveCopyTest {

    data class Employee(val name: String, val salary: Int)
    class Employees(val values: List<Employee>)

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

    @Test
    fun `연봉이 바뀌지 않아야 한다`() {
        // given
        val employees = Employees(
            mutableListOf(
                Employee(name = "김태현", salary = 100_000_000),
                Employee(name = "김수현", salary = 100_000_000),
                Employee(name = "제이슨", salary = 100_000_000),
            )
        )

        // when
        (employees.values as MutableList<Employee>)
            .replaceAll { it.copy(salary = 100) }

        // then
        assertThat(employees.values)
            .allMatch { it.salary == 100_000_000 }
    }
}
