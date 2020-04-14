package com.snow.gintonic;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * author : zyt
 * e-mail : 632105276@qq.com
 * date   : 2020-04-10
 * desc   :
 */
//@Aspect
public class TraceAspect {
    public static final String TAG = "snow_aop";

    /**
     * 在所有on开头的方法前执行
     *
     * @param joinPoint
     */
    @Before("execution(* *.my*(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) {
        String key = joinPoint.getSignature().toString();
        //方法名
        String name = joinPoint.getSignature().getName();
        //方法所在的类
        String target = joinPoint.getTarget().toString();
        //方法在那个类多少行
        String s = joinPoint.getSourceLocation().toString();
        //方法中的参数，什么类型都可以，根据类型可以解析出参数的值
        Object[] args = joinPoint.getArgs();
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                if (arg instanceof UserBean) {
                    UserBean userBean = (UserBean) arg;
                    Log.e(TAG, "对象参数值:" + userBean.getName() + "===" + userBean.getAge() + "\n");
                } else {
                    String strinn = String.valueOf(arg);
                    Log.e(TAG, "参数值strinn:" + strinn + "\n");
                }
            }
        }

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

    /**
     * 在注入的方法前后执行
     *
     * @param joinPoint
     */
    @Around("execution(* android.app.Activity.on**(..))")
    public void onActivityMethodAll(ProceedingJoinPoint joinPoint) {
        Log.e(TAG, "Around=======" + "onActivityMethodBefore:");
        try {
            //joinPoint.proceed()代表执行原始的方法
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Log.e(TAG, "Around=======" + "onActivityMethodAfter:");
    }
}
