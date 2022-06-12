package camp.nextstep.edu.immutable.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import kotlin.concurrent.thread
import kotlin.random.Random

data class RandomInt(var value: Int)

class ConcurrencyIssueTest {
    private val randomInt = RandomInt(0)

    @Test
    fun `TODO`() {
        changeRandomInt(3000L)
        assertRandomInt(3000L)
    }

    private fun changeRandomInt(timeout: Long) {
        startTimeoutThread(timeout) {
            Thread.sleep(100L)
            randomInt.value = Random.nextInt(1, 100)
        }
    }

    private fun assertRandomInt(timeout: Long) {
        startTimeoutThread(timeout) {
            Thread.sleep(70L)
            if (randomInt.value >= 50) return@startTimeoutThread // 100
            assertThat(randomInt.value).isLessThan(50)
        }
    }

    private fun startTimeoutThread(timeout: Long, f: () -> Unit) {
        val current = System.currentTimeMillis()
        val expireAt = current + timeout
        thread {
            while (current < expireAt) {
                f()
            }
        }
    }
}
