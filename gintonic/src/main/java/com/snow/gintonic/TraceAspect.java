package com.snow.gintonic;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * author : zyt
 * e-mail : 632105276@qq.com
 * date   : 2020-04-10
 * desc   :
 */
@Aspect
public class TraceAspect {
    public static final String TAG = "snow_aop";

    /**
     * 在所有on开头的方法前执行
     *
     * @param joinPoint
     */
    @Before("execution(* *.on*(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) {
        String key = joinPoint.getSignature().toString();
        Log.e(TAG, "onActivityMethodBefore:" + key + "\n" + joinPoint.getThis());
    }

    /**
     * 在android.app.Activity包下的on开头的方法执行完成执行
     *
     * @param joinPoint
     */
    @After("execution(* android.app.Activity.on**(..))")
    public void onActivityMethodAfter(JoinPoint joinPoint) {
        String key = joinPoint.getSignature().toString();
        Log.e(TAG, "onActivityMethodAfter:" + key + "\n" + joinPoint.getThis());
    }
}
