package aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.{Around, Aspect}
import play.api.Logger

@Aspect
class HomeAspect {

  @Around(value = "execution (* controllers.HomeController.index(..))")
  def indexPointcut(joinPoint: ProceedingJoinPoint): Any = {
    val result = joinPoint.proceed()
    Logger.debug(s"Pointcut on index method with the result: $result !!!! ")

    result
  }

}
