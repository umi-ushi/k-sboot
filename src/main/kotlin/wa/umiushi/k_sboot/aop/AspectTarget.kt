package wa.umiushi.k_sboot.aop

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/aspect")
class aspectSample(
    private val aspectTarget: AspectTarget
) {
    @GetMapping("/test")
    fun test() {
        aspectTarget.test()
    }
}

@Component
class AspectTarget {

    @Loggable
    fun test() {
        println("test method call")
    }
}