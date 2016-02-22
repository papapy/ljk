package club.ljk.comm.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 控制层aop
 * Created by XKey on 2016/1/27.
 */
@Component
@Aspect
public class ControllerAspect {

    @Pointcut("execution(* club.ljk..controller..*Controller*.moa(..))")
    public void init() {}

    @AfterReturning(pointcut = "init()")
    public void advice() {}

    @Before("init()")
    public void before(JoinPoint point) {
        Object[] params = point.getArgs();
        for(Object param:params) {
            System.out.println(param.toString());
            param.toString();
        }
    }
}
