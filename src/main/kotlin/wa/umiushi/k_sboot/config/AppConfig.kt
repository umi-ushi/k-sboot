package wa.umiushi.k_sboot.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import java.time.Clock
import java.time.Instant
import java.time.ZoneId

@Configuration
class AppConfig {

    @Bean
    @Profile("dev")
    fun clockDev(): Clock = Clock.system(ZoneId.systemDefault())

    @Bean
    @Profile("test")
    fun clockTest(): Clock = Clock.fixed(Instant.parse("2025-01-02T03:04:05Z"), ZoneId.systemDefault())

}