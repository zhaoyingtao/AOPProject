package com.snow.gintonic;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * author : snowzhao
 * e-mail : zyt@ttsing.com
 * date   : 2020/4/17
 * desc   :切面打印生命周期
 */
@Aspect
public class LifeCycleAspect {
    @Before("execution(* android.app.Activity.on**(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) {
        //方法名
        String methodName = joinPoint.getSignature().getName();
        //方法所在的类
        String target = joinPoint.getTarget().toString();
        Log.e("snow_aop", "类名:" + target + "=====方法名：" + methodName + "\n");
    }
}
