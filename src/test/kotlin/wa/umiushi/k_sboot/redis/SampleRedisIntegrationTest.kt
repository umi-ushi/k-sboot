package wa.umiushi.k_sboot.redis

import org.junit.jupiter.api.Test
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.test.context.TestConstructor
import kotlin.test.assertEquals

@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class SampleRedisIntegrationTest(
    private val redisTemplate: RedisTemplate<String, String>
): AbstractRedisIntegrationTest() {

    @Test
    fun sampleTest() {
        redisTemplate.opsForValue().set("test:1", "test_value")
        val actual = redisTemplate.opsForValue().get("test:1")
        assertEquals("test_value", actual)
    }
}