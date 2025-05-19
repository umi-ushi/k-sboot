package wa.umiushi.k_sboot.redis

import org.junit.jupiter.api.BeforeAll
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@Testcontainers
abstract class AbstractRedisIntegrationTest {

    companion object {
        @Container
        @ServiceConnection("redis") // https://spring.pleiades.io/spring-boot/reference/testing/testcontainers.html
        val redis = GenericContainer<Nothing>("redis:8.0.0").apply {
            withExposedPorts(6379)
        }

        @BeforeAll
        @JvmStatic
        fun initRedisData() {
            redis.execInContainer("redis-cli", "HMSET", "key:value")
        }
    }
}