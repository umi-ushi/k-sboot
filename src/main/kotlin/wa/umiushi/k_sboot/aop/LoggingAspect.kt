package wa.umiushi.k_sboot.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.stereotype.Component

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Loggable

@Aspect
@Component
class LoggingAspect {

    @Before("@annotation(wa.umiushi.k_sboot.aop.Loggable)")
    fun before(jp: JoinPoint) {
        println("before:${jp.signature}")
    }

    @AfterReturning("@annotation(wa.umiushi.k_sboot.aop.Loggable)")
    fun afterReturn(jp: JoinPoint) {
        println("after return:${jp.signature}")
    }

    @AfterThrowing("@annotation(wa.umiushi.k_sboot.aop.Loggable)", throwing = "ex")
    fun afterException(jp: JoinPoint, ex: Exception) {
        println("after throw:${jp.signature}, ${ex.message}")
    }

    @After("@annotation(wa.umiushi.k_sboot.aop.Loggable)")
    fun after(jp: JoinPoint) {
        println("after:${jp.signature}")
    }
}