package camp.nextstep.edu.immutable.step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.time.LocalDate

/**
 * - Side Effect를 끊는걸 의식적으로 연습해보기
 *     - var 키워드 하나도 쓰지않기
 *     - 클래스 또는 함수 서명(Signature)에서 Mutable 없애기
 *     - (Optional) 함수 본문에서 Mutable Collection 사용하지 않기
 *     - (Optional) 비어있는 테스트 코드 완성하기
 * - 일급 컬렉션을 공부해보고 실습해서 활용해보기
 */
class EmployeeTest {

    @Test
    fun `사원은 휴가를 소비할 수 있다`() {
        // given
        val employee = Employee.of(
            name = EmployeeName("홍길동"),
            unusedVacationCount = 2,
        )

        // when
        val actual = employee
            .useVacation(LocalDate.of(2022, 4, 4))
            .useVacation(LocalDate.of(2022, 4, 5))

        // then
        assertAll(
            { assertThat(actual.unusedVacationCount).isEqualTo(0) },
            { assertThat(actual.usedVacationDates).hasSize(2) },
            { assertThat(actual.usedVacationDates).contains(LocalDate.of(2022, 4, 4)) },
            { assertThat(actual.usedVacationDates).contains(LocalDate.of(2022, 4, 5)) },
        )
    }
}
