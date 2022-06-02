package com.nextstep.counter.step2

import com.google.common.truth.Truth.assertThat
import com.nextstep.counter.DefensiveCopyViewModel
import org.junit.Test


class DefensiveCopyViewModelTest {

    private val viewModel = DefensiveCopyViewModel()

    @Test
    fun `2개의 리스트는 서로 값이 공유되지 않아야한다`() {
        // given
        val originalUsers = viewModel.users

        // when
        viewModel.fetchUsers()

        // then
        assertThat(viewModel.users).isNotEqualTo(originalUsers)
    }

}
