package club.ljk.comm.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * model切面
 * Created by XKey on 2016/1/14.
 */
//@Component
@Aspect
public class ServiceAspect {

    @Pointcut("execution(* club.ljk..service..*Service*.*(..))")
    public void init() {}

    @AfterReturning(pointcut = "init()")
    public void advice() {}

    @Before("init()")
    public void before(){
        System.out.println("方法执行前执行.....");
    }

    @AfterReturning(value="init()")
    public void afterReturning(){
        System.out.println("方法执行完执行.....");
    }

    @AfterThrowing(value="init()")
    public void throwss(){
        System.out.println("方法异常时执行.....");
    }

    @After(value="init()")
    public void after(){
        System.out.println("方法最后执行.....");
    }

    @Around(value="init()")
    public Object around(ProceedingJoinPoint pjp){
        System.out.println("方法环绕start.....");
        Object o = null;
        try {
            o = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("方法环绕end.....");
        return o;
    }
}
