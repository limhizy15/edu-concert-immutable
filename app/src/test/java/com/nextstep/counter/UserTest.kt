package com.nextstep.counter

import com.google.common.truth.Truth.assertThat
import org.junit.Test


internal class UserTest {

    @Test
    fun `사용자의 이름을 변경한다`() {
        // given
        val user = User(name = "홍길동", age = 10)

        // when
        val newUser = user.copy("김길동")

        // then
        assertThat(newUser.name).isEqualTo("김길동")
    }

}
