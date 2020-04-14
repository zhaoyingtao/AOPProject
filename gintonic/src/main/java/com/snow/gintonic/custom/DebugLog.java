package com.snow.gintonic.custom;

import android.util.Log;

/**
 * author : zyt
 * e-mail : 632105276@qq.com
 * date   : 2020-04-10
 * desc   :
 */
public class DebugLog {
    private DebugLog() {}

    /**
     * Send a debug log message
     *
     * @param tag Source of a log message.
     * @param message The message you would like logged.
     */
    public static void log(String tag, String message) {
        Log.e(tag, message);
    }
}
