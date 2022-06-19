package camp.nextstep.edu.immutable.step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private data class Employee(var name: String, var age: Int)

private class DefensiveCopyViewModel {

    private val _employees: MutableList<Employee> = mutableListOf()
    val employees: List<Employee>
        get() = _employees

    fun fetchUsers() {
        _employees.add(Employee(name = "홍길동", age = 10))
        _employees.add(Employee(name = "김길동", age = 11))
    }
}

class DefensiveCopyViewModelTest {

    private val viewModel = DefensiveCopyViewModel()

    @Test
    fun `내부에서 리스트를 변경해도 외부의 리스트는 수정되지 않아야한다`() {
        // given
        val originalUsers = viewModel.employees

        // when
        viewModel.fetchUsers()

        // then
        assertThat(viewModel.employees).isNotEqualTo(originalUsers)
    }

    @Test
    fun `외부에서 리스트를 변경해도 내부의 리스트는 수정되지 않아야한다`() {
        // given
        viewModel.fetchUsers()

        // when
        val externalList = viewModel.employees as MutableList<Employee>
        externalList.clear()

        // then
        val internalList = viewModel.employees
        assertThat(internalList).isNotEqualTo(externalList)
        assertThat(internalList).isNotEmpty()
        assertThat(externalList).isEmpty()
    }
}
