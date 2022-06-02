package com.nextstep.counter.step2

import com.google.common.truth.Truth.assertThat
import com.nextstep.counter.DefensiveCopyViewModel
import com.nextstep.counter.User
import org.junit.Test


class DefensiveCopyViewModelTest {

    private val viewModel = DefensiveCopyViewModel()

    @Test
    fun `내부에서 리스트를 변경해도 외부의 리스트는 수정되지 않아야한다`() {
        // given
        val originalUsers = viewModel.users

        // when
        viewModel.fetchUsers()

        // then
        assertThat(viewModel.users).isNotEqualTo(originalUsers)
    }

    @Test
    fun `외부에서 리스트를 변경해도 내부의 리스트는 수정되지 않아야한다`() {
        // given
        viewModel.fetchUsers()

        // when
        val externalList = viewModel.users as MutableList<User>
        externalList.clear()

        // then
        val internalList = viewModel.users
        assertThat(internalList).isNotEqualTo(externalList)
        assertThat(internalList).isNotEmpty()
        assertThat(externalList).isEmpty()
    }
}
