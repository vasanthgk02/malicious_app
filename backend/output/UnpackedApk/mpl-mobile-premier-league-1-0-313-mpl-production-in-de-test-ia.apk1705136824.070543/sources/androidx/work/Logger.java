package androidx.work;

public abstract class Logger {
    public static Logger sLogger;

    public static class LogcatLogger extends Logger {
        public int mLoggingLevel;

        public LogcatLogger(int i) {
            this.mLoggingLevel = i;
        }

        public void debug(String str, String str2, Throwable... thArr) {
            if (this.mLoggingLevel <= 3 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        public void error(String str, String str2, Throwable... thArr) {
            if (this.mLoggingLevel <= 6 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        public void info(String str, String str2, Throwable... thArr) {
            if (this.mLoggingLevel <= 4 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }

        public void warning(String str, String str2, Throwable... thArr) {
            if (this.mLoggingLevel <= 5 && thArr.length >= 1) {
                Throwable th = thArr[0];
            }
        }
    }

    public static synchronized Logger get() {
        Logger logger;
        synchronized (Logger.class) {
            try {
                if (sLogger == null) {
                    sLogger = new LogcatLogger(3);
                }
                logger = sLogger;
            }
        }
        return logger;
    }

    public static String tagWithPrefix(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            sb.append(str.substring(0, 20));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void debug(String str, String str2, Throwable... thArr);

    public abstract void error(String str, String str2, Throwable... thArr);

    public abstract void info(String str, String str2, Throwable... thArr);

    public abstract void warning(String str, String str2, Throwable... thArr);
}
