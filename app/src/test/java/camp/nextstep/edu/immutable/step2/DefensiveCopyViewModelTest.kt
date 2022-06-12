package camp.nextstep.edu.immutable.step2

import com.google.common.truth.Truth.assertThat
import camp.nextstep.edu.immutable.DefensiveCopyViewModel
import camp.nextstep.edu.immutable.Employee
import org.junit.Test


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
