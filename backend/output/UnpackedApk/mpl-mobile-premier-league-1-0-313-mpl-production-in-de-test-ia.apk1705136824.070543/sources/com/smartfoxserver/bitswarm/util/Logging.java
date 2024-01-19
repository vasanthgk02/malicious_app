package com.smartfoxserver.bitswarm.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging {
    public static final String NEW_LINE = System.getProperty("line.separator");
    public static final String TAB = "\t";

    public static void changeConsoleHandlerFormatter(Formatter formatter) {
        Handler[] handlers = Logger.getLogger("").getHandlers();
        if (handlers.length > 0) {
            Handler handler = handlers[0];
            if (handler == null || !(handler instanceof ConsoleHandler)) {
                throw new RuntimeException("Could not change the ConsoleHandler's formatter!");
            }
            handler.setFormatter(formatter);
        }
    }

    public static void changeConsoleHandlerLevel(Level level) {
        Handler[] handlers = Logger.getLogger("").getHandlers();
        if (handlers.length > 0) {
            Handler handler = handlers[0];
            if (handler != null && (handler instanceof ConsoleHandler)) {
                handler.setLevel(level);
            }
        }
    }

    public static String formatStackTrace(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement append : stackTraceElementArr) {
            sb.append(append);
            sb.append(NEW_LINE);
        }
        return sb.toString();
    }

    public static Level getConsoleHandlerLevel() {
        Handler[] handlers = Logger.getLogger("").getHandlers();
        if (handlers.length > 0) {
            Handler handler = handlers[0];
            if (handler != null && (handler instanceof ConsoleHandler)) {
                return handler.getLevel();
            }
        }
        return null;
    }

    public static void logStackTrace(org.slf4j.Logger logger, Throwable th) {
        logStackTrace(logger, th.toString(), th.getStackTrace());
    }

    public static void logStackTrace(org.slf4j.Logger logger, StackTraceElement[] stackTraceElementArr) {
        logStackTrace(logger, null, stackTraceElementArr);
    }

    public static void logStackTrace(org.slf4j.Logger logger, String str, StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
            sb.append(NEW_LINE);
        }
        for (StackTraceElement append : stackTraceElementArr) {
            sb.append(TAB);
            sb.append(append);
            sb.append(NEW_LINE);
        }
        logger.warn(sb.toString());
    }
}
