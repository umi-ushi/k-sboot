package wa.umiushi.k_sboot.health

import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component

@ConditionalOnProperty(prefix = "management.endpoint.health", name = ["custom"], havingValue = "true")
@Component
class CustomHealthIndicator: HealthIndicator {
    override fun health(): Health? {
        return Health.up().build()
    }
}