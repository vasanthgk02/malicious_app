package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

public class aq implements LoggerInterface {

    /* renamed from: a  reason: collision with root package name */
    public LoggerInterface f4413a = null;

    /* renamed from: b  reason: collision with root package name */
    public LoggerInterface f4414b = null;

    public aq(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f4413a = loggerInterface;
        this.f4414b = loggerInterface2;
    }

    public void log(String str) {
        LoggerInterface loggerInterface = this.f4413a;
        if (loggerInterface != null) {
            loggerInterface.log(str);
        }
        LoggerInterface loggerInterface2 = this.f4414b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    public void log(String str, Throwable th) {
        LoggerInterface loggerInterface = this.f4413a;
        if (loggerInterface != null) {
            loggerInterface.log(str, th);
        }
        LoggerInterface loggerInterface2 = this.f4414b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th);
        }
    }

    public void setTag(String str) {
    }
}
