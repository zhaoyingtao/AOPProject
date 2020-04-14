package com.snow.gintonic.custom;

import java.util.concurrent.TimeUnit;

/**
 * author : zyt
 * e-mail : 632105276@qq.com
 * date   : 2020-04-10
 * desc   :处理耗时的工具类==不能使用单例，同时执行，会被第二个重置
 */
public class UseTimeHelper {
    private long startTime;
    private long endTime;
    private long elapsedTime;
//    private static UseTimeHelper useTimeHelper;
//
//    public static UseTimeHelper init() {
//        if (useTimeHelper == null) {
//            synchronized (UseTimeHelper.class) {
//                if (useTimeHelper == null) {
//                    useTimeHelper = new UseTimeHelper();
//                }
//            }
//        }
//        return useTimeHelper;
//    }

    public UseTimeHelper() {

    }

    private void reset() {
        startTime = 0;
        endTime = 0;
        elapsedTime = 0;
    }

    public void start() {
        reset();
        startTime = System.nanoTime();
    }

    public void stop() {
        if (startTime != 0) {
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
        } else {
            reset();
        }
    }

    public long getTotalTimeMillis() {
        return (elapsedTime != 0) ? TimeUnit.NANOSECONDS.toMillis(endTime - startTime) : 0;
    }
}
