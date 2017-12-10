package com.mobiledev.lambdalombok.utils;

import android.util.Log;

/**
 * Created by manu on 12/10/2017.
 */

public class LogUtils {
    /**
     * Verbose
     *
     * @param mMessage
     */
    public static void logError(String mMessage) {
        Log.e("TAG ERROR", mMessage);
    }

    /***
     * Info
     *
     * @param mMessage
     */
    public static void logInfo(String mMessage) {
        Log.i("TAG ERROR", mMessage);
    }

    /***
     * Debug
     *
     * @param mMessage
     */
    public static void logDebug(String mMessage) {
        Log.d("TAG ERROR", mMessage);
    }

    /****
     * Verbose
     *
     * @param mMessage
     */
    public static void logVerbose(String mMessage) {
        Log.v("TAG ERROR", mMessage);
    }


    /***
     * Warning
     *
     * @param mMessage
     */
    public static void logWarning(String mMessage) {
        Log.w("TAG ERROR", mMessage);
    }
}