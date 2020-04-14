package com.snow.gintonic.custom;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * author : zyt
 * e-mail : 632105276@qq.com
 * date   : 2020-04-10
 * desc   :检测自定义方法的注解
 */
@Aspect
public class CustomAspect {
    /**
     * 注意此处DebugTimeConsuming是定义的注解类的路径
     */
    private static final String POINTCUT_METHOD =
            "execution(@com.snow.gintonic.custom.DebugTimeConsuming * *(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithDebugTrace() {
    }

    @Around("methodAnnotatedWithDebugTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        UseTimeHelper useTimeHelper = new UseTimeHelper();
        useTimeHelper.start();
        // 被注解的方法在这一行代码被执行
        Object result = joinPoint.proceed();
        useTimeHelper.stop();
        //打印被监听方法的执行时间
        Log.e("snow_aop", className + " --> " + methodName + " --耗时--> " + useTimeHelper.getTotalTimeMillis() + "ms");
        return result;
    }
}
