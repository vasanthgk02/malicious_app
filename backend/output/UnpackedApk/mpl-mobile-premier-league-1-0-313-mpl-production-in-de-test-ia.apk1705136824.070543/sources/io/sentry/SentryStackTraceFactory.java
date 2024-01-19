package io.sentry;

import io.sentry.protocol.SentryStackFrame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SentryStackTraceFactory {
    public final List<String> inAppExcludes;
    public final List<String> inAppIncludes;

    public SentryStackTraceFactory(List<String> list, List<String> list2) {
        this.inAppExcludes = list;
        this.inAppIncludes = list2;
    }

    public List<SentryStackFrame> getStackFrames(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                if (!className.startsWith("io.sentry.") || className.startsWith("io.sentry.samples.") || className.startsWith("io.sentry.mobile.")) {
                    SentryStackFrame sentryStackFrame = new SentryStackFrame();
                    sentryStackFrame.setInApp(Boolean.valueOf(isInApp(className)));
                    sentryStackFrame.setModule(className);
                    sentryStackFrame.setFunction(stackTraceElement.getMethodName());
                    sentryStackFrame.setFilename(stackTraceElement.getFileName());
                    if (stackTraceElement.getLineNumber() >= 0) {
                        sentryStackFrame.setLineno(Integer.valueOf(stackTraceElement.getLineNumber()));
                    }
                    sentryStackFrame.setNative(Boolean.valueOf(stackTraceElement.isNativeMethod()));
                    arrayList.add(sentryStackFrame);
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public boolean isInApp(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        List<String> list = this.inAppIncludes;
        if (list != null) {
            for (String startsWith : list) {
                if (str.startsWith(startsWith)) {
                    return true;
                }
            }
        }
        List<String> list2 = this.inAppExcludes;
        if (list2 != null) {
            for (String startsWith2 : list2) {
                if (str.startsWith(startsWith2)) {
                    break;
                }
            }
        }
        return false;
    }
}
