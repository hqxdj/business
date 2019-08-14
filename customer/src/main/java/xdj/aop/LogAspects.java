package xdj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.rmi.RemoteException;
import java.util.Arrays;

/**
 * @author xdj
 * @version V1.0
 * @ProjectName: business
 * @Description:
 * @Date 2019/8/12 14:09
 * Copyright (c)   xdj
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(* xdj.aop.MathCalculator.div(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("" + joinPoint.getSignature().getName() + "的@before。。开始打印日志");
    }


    @After("xdj.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("" + joinPoint.getSignature().getName() + "的@After。。开始打印日志"+Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result) {
        System.out.println("" + joinPoint.getSignature().getName() + "的@AfterReturning。。开始打印日志"+ "返回结果是：{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception) {
        System.out.println("" + joinPoint.getSignature().getName() + "的@AfterThrowing。。开始打印日志"+"异常信息{"+exception+"}");
    }


    public void logAround() {
        System.out.println("");
    }
}
