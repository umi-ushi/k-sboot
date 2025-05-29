package wa.umiushi.k_sboot

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.TestConstructor
import wa.umiushi.k_sboot.config.AppConfig
import java.time.Clock
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.test.assertEquals

@SpringBootTest
@Import(AppConfig::class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class KSbootApplicationTests(
    private val clock: Clock
) {

    @Test
    fun test() {
        assertEquals(LocalDate.of(2025, 1, 2), LocalDateTime.now(clock).toLocalDate())
        assertEquals(LocalTime.of(12, 4, 5), LocalDateTime.now(clock).toLocalTime())
    }
}
