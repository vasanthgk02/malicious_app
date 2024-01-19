package org.jboss.netty.logging;

import org.apache.commons.logging.Log;

public class CommonsLogger extends AbstractInternalLogger {
    public final Log logger;
    public final String loggerName;

    public CommonsLogger(Log log, String str) {
        this.logger = log;
        this.loggerName = str;
    }

    public void debug(String str) {
        this.logger.debug(str);
    }

    public void error(String str) {
        this.logger.error(str);
    }

    public void info(String str) {
        this.logger.info(str);
    }

    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    public String toString() {
        return this.loggerName;
    }

    public void warn(String str) {
        this.logger.warn(str);
    }

    public void debug(String str, Throwable th) {
        this.logger.debug(str, th);
    }

    public void error(String str, Throwable th) {
        this.logger.error(str, th);
    }

    public void info(String str, Throwable th) {
        this.logger.info(str, th);
    }

    public void warn(String str, Throwable th) {
        this.logger.warn(str, th);
    }
}
