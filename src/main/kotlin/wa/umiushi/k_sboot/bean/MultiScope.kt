package wa.umiushi.k_sboot.bean

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.annotation.RequestScope
import java.time.LocalDateTime

@RestController
@RequestMapping("/multi/scope")
class Sample(
    private val service: SingletonBean
) {

    @GetMapping()
    fun test() : ResponseEntity<String> {
        service.run()
        return ResponseEntity.ok("OK")
    }
}

@Component
class SingletonBean(
    private val ok: RequestBeanOk,
) {
    fun run() {
        println("singlton: ${this}")
        ok.run()
        ok.run()
    }
}

@Component
@RequestScope
class RequestBeanOk() {
    private val value = LocalDateTime.now()

    fun run() {
        println("request: ${this}: $value")
    }
}