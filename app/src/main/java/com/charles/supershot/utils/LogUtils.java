package com.charles.supershot.utils;

import android.util.Log;

import java.util.Iterator;
import java.util.Map;

public class LogUtils {
    private static final boolean DEBUG = true;

    private static final String LOG_PREFIX = "HANG5_";
    private static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();
    private static final int MAX_LOG_TAG_LENGTH = 50;


    public static String makeLogTag(String str) {
        if (str.length() > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH) {
            return LOG_PREFIX + str.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH - 1);
        }
        return LOG_PREFIX + str;
    }

    /**
     * Don't use this when obfuscating class names!
     */
    public static String makeLogTag(Class cls) {
        return makeLogTag(cls.getSimpleName());
    }

    public static void d(final String tag, String message) {
        if (DEBUG) {
            android.util.Log.d(tag, message);
        }
    }

    public static void d(final String tag, String message, Throwable cause) {
        if (DEBUG) {
            android.util.Log.d(tag, message, cause);
        }
    }

    public static void v(final String tag, String message) {
        if (DEBUG) {
            android.util.Log.v(tag, message);
        }
    }

    public static void v(final String tag, String message, Throwable cause) {
        if (android.util.Log.isLoggable(tag, android.util.Log.VERBOSE)) {
            android.util.Log.v(tag, message, cause);
        }
    }

    public static void i(final String tag, String message) {
        if (DEBUG) {
            android.util.Log.i(tag, message);
        }
    }

    public static void i(final String tag, String message, Throwable cause) {
        if (DEBUG) {
            android.util.Log.i(tag, message, cause);
        }
    }

    public static void w(final String tag, String message) {
        if (DEBUG) {
            android.util.Log.w(tag, message);
        }
    }

    public static void w(final String tag, String message, Throwable cause) {
        if (DEBUG) {
            android.util.Log.w(tag, message, cause);
        }
    }

    public static void e(final String tag, String message) {
        if (DEBUG) {
            android.util.Log.e(tag, message);
        }
    }

    public static void e(final String tag, String message, Throwable cause) {
        if (DEBUG) {
            android.util.Log.e(tag, message, cause);
        }

    }

    private LogUtils() {
    }

    public static void err(String tag, String log) {
        if (DEBUG) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String name = stackTraceElement.getMethodName();
            String className = stackTraceElement.getClassName();
            String lineNumber = stackTraceElement.getLineNumber() + "";
            typedLog(LogType.LOG_E, makeLogTag(tag), "\n[" + className + "]\n[" + name + "][" + lineNumber + "] :\n" + log);
        }
    }

    public static void err(String tag, Object o) {
        if (DEBUG) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String name = stackTraceElement.getMethodName();
            String className = stackTraceElement.getClassName();
            String lineNumber = stackTraceElement.getLineNumber() + "";
            String log = o != null ? o.toString() : "[NULL]";
            typedLog(LogType.LOG_E, makeLogTag(tag), "\n[" + className + "]\n[" + name + "][" + lineNumber + "] :\n" + log);
        }
    }

    public static void debug(String tag, String log) {
        if (DEBUG) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String name = stackTraceElement.getMethodName();
            String className = stackTraceElement.getClassName();
            String lineNumber = stackTraceElement.getLineNumber() + "";
            typedLog(LogType.LOG_D, makeLogTag(tag), "\n[" + className + "]\n[" + name + "][" + lineNumber + "] :\n" + log);
        }
    }

    public static void debug(String tag, Object o) {
        if (DEBUG) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String name = stackTraceElement.getMethodName();
            String className = stackTraceElement.getClassName();
            String lineNumber = stackTraceElement.getLineNumber() + "";
            String log = o != null ? o.toString() : "[NULL]";
            typedLog(LogType.LOG_D, makeLogTag(tag), "\n[" + className + "]\n[" + name + "][" + lineNumber + "] :\n" + log);
        }
    }

    enum LogType {
        LOG_E, LOG_D
    }

    public static void typedLog(LogType logType, String tag, String log) {
        if (DEBUG) {
            switch (logType) {
                case LOG_D:
                    android.util.Log.d(tag, log);
                    break;

                case LOG_E:
                    Log.e(tag, log);
                    break;
            }
        }
    }

    public static void log(Map<String, Object> map) {
        if (DEBUG) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> keys = map.keySet().iterator();
            for (; keys.hasNext(); ) {
                String k = keys.next();
                sb.append(k).append("=").append(map.get(k)).append("\n");
            }
            LogUtils.err("HANG5", sb.toString());
        }
    }

    public static void log(String prefix, Map<String, Object> map) {
        if (DEBUG) {
            StringBuilder sb = new StringBuilder(prefix).append("=\n");
            Iterator<String> keys = map.keySet().iterator();
            for (; keys.hasNext(); ) {
                String k = keys.next();
                sb.append(k).append("=").append(map.get(k)).append("\n");
            }
            LogUtils.err("HANG5", sb.toString());
        }
    }
}
