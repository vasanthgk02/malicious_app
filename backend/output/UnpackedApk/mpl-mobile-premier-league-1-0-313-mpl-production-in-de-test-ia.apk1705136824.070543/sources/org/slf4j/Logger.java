package org.slf4j;

public interface Logger {
    void debug(String str);

    void debug(String str, Throwable th);

    void error(String str);

    void error(String str, Throwable th);

    String getName();

    void info(String str);

    void info(String str, Object obj);

    void info(String str, Throwable th);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isWarnEnabled();

    void warn(String str);

    void warn(String str, Throwable th);
}
