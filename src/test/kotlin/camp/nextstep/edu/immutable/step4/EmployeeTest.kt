package camp.nextstep.edu.immutable.step4

import org.junit.jupiter.api.Test

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
        TODO()
    }

    @Test
    fun `1년 이하의 사원이면 1달마다 1일의 휴가가 부여된다`() {
        TODO()
    }

    @Test
    fun `1년 이상 근속한 사원에게 15일의 휴가가 부여된다`() {
        TODO()
    }

    @Test
    fun `김씨 사원에게만 특별 휴가 1일이 부여된다`() {
        TODO()
    }
}
