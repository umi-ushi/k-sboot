package wa.umiushi.k_sboot.metrics

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomMetrics(registry: MeterRegistry) {

    // localhost:8088/internal/actuator/metrics/sample
    private val counter = registry.counter("sample")

    @GetMapping("/metrics/sample")
    fun metricsSample(): ResponseEntity<String> {
        counter.increment()
        return ResponseEntity.ok("countup")
    }
}