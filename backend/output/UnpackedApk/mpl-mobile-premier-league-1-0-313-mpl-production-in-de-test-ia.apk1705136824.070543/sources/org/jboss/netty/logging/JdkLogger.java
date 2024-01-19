package org.jboss.netty.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JdkLogger extends AbstractInternalLogger {
    public final Logger logger;
    public final String loggerName;

    public JdkLogger(Logger logger2, String str) {
        this.logger = logger2;
        this.loggerName = str;
    }

    public void debug(String str) {
        this.logger.logp(Level.FINE, this.loggerName, null, str);
    }

    public void error(String str) {
        this.logger.logp(Level.SEVERE, this.loggerName, null, str);
    }

    public void info(String str) {
        this.logger.logp(Level.INFO, this.loggerName, null, str);
    }

    public boolean isDebugEnabled() {
        return this.logger.isLoggable(Level.FINE);
    }

    public boolean isErrorEnabled() {
        return this.logger.isLoggable(Level.SEVERE);
    }

    public boolean isInfoEnabled() {
        return this.logger.isLoggable(Level.INFO);
    }

    public boolean isWarnEnabled() {
        return this.logger.isLoggable(Level.WARNING);
    }

    public String toString() {
        return this.loggerName;
    }

    public void warn(String str) {
        this.logger.logp(Level.WARNING, this.loggerName, null, str);
    }

    public void debug(String str, Throwable th) {
        this.logger.logp(Level.FINE, this.loggerName, null, str, th);
    }

    public void error(String str, Throwable th) {
        this.logger.logp(Level.SEVERE, this.loggerName, null, str, th);
    }

    public void info(String str, Throwable th) {
        this.logger.logp(Level.INFO, this.loggerName, null, str, th);
    }

    public void warn(String str, Throwable th) {
        this.logger.logp(Level.WARNING, this.loggerName, null, str, th);
    }
}