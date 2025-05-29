package wa.umiushi.k_sboot.bean

import jakarta.annotation.PreDestroy
import org.springframework.beans.factory.DisposableBean
import org.springframework.stereotype.Component

@Component
class PreBeanDestoryInvoke {

    @PreDestroy
    fun PreDestroy() {
        println("pre destroy")
    }
}

@Component
class DisposableBeanInvoke : DisposableBean {
    override fun destroy() {
        println("disposable bean")
    }
}