package wa.umiushi.k_sboot.bean

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component

@Component
class PostBeanCreationInvoke {

    @PostConstruct
    fun postConstruct() {
        println("construct done Post")
    }
}

@Component
class InitializingBeanInvoke : InitializingBean {
    override fun afterPropertiesSet() {
        println("construct done Initializing")
    }
}
