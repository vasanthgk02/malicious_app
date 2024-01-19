package org.jboss.netty.logging;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.osgi.service.log.LogService;

public class OsgiLogger extends AbstractInternalLogger {
    public final InternalLogger fallback;
    public final String name;
    public final OsgiLoggerFactory parent;
    public final String prefix;

    public OsgiLogger(OsgiLoggerFactory osgiLoggerFactory, String str, InternalLogger internalLogger) {
        this.parent = osgiLoggerFactory;
        this.name = str;
        this.fallback = internalLogger;
        this.prefix = GeneratedOutlineSupport.outline52("[", str, "] ");
    }

    public void debug(String str) {
        LogService logService = this.parent.getLogService();
        if (logService != null) {
            logService.log(4, GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, str));
        } else {
            this.fallback.debug(str);
        }
    }

    public void error(String str) {
        LogService logService = this.parent.getLogService();
        if (logService != null) {
            logService.log(1, GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, str));
        } else {
            this.fallback.error(str);
        }
    }

    public void info(String str) {
        LogService logService = this.parent.getLogService();
        if (logService != null) {
            logService.log(3, GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, str));
        } else {
            this.fallback.info(str);
        }
    }

    public boolean isDebugEnabled() {
        return true;
    }

    public boolean isErrorEnabled() {
        return true;
    }

    public boolean isInfoEnabled() {
        return true;
    }

    public boolean isWarnEnabled() {
        return true;
    }

    public String toString() {
        return this.name;
    }

    public void warn(String str) {
        LogService logService = this.parent.getLogService();
        if (logService != null) {
            logService.log(2, GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, str));
        } else {
            this.fallback.warn(str);
        }
    }

    public void debug(String str, Throwable th) {
        LogService logService = this.parent.getLogService();
        if (logService != null) {
            logService.log(4, GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, str), th);
        } else {
            this.fallback.debug(str, th);
        }
    }

    public void error(String str, Throwable th) {
        LogService logService = this.parent.getLogService();
        if (logService != null) {
            logService.log(1, GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, str), th);
        } else {
            this.fallback.error(str, th);
        }
    }

    public void info(String str, Throwable th) {
        LogService logService = this.parent.getLogService();
        if (logService != null) {
            logService.log(3, GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, str), th);
        } else {
            this.fallback.info(str, th);
        }
    }

    public void warn(String str, Throwable th) {
        LogService logService = this.parent.getLogService();
        if (logService != null) {
            logService.log(2, GeneratedOutlineSupport.outline62(new StringBuilder(), this.prefix, str), th);
        } else {
            this.fallback.warn(str, th);
        }
    }
}
