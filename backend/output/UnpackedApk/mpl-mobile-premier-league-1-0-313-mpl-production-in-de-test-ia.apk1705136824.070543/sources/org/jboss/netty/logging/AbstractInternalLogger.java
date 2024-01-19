package org.jboss.netty.logging;

public abstract class AbstractInternalLogger implements InternalLogger {

    /* renamed from: org.jboss.netty.logging.AbstractInternalLogger$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$logging$InternalLogLevel;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                org.jboss.netty.logging.InternalLogLevel[] r0 = org.jboss.netty.logging.InternalLogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jboss$netty$logging$InternalLogLevel = r0
                r1 = 1
                org.jboss.netty.logging.InternalLogLevel r2 = org.jboss.netty.logging.InternalLogLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$org$jboss$netty$logging$InternalLogLevel     // Catch:{ NoSuchFieldError -> 0x0016 }
                org.jboss.netty.logging.InternalLogLevel r3 = org.jboss.netty.logging.InternalLogLevel.INFO     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$org$jboss$netty$logging$InternalLogLevel     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jboss.netty.logging.InternalLogLevel r3 = org.jboss.netty.logging.InternalLogLevel.WARN     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jboss$netty$logging$InternalLogLevel     // Catch:{ NoSuchFieldError -> 0x0024 }
                org.jboss.netty.logging.InternalLogLevel r2 = org.jboss.netty.logging.InternalLogLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.logging.AbstractInternalLogger.AnonymousClass1.<clinit>():void");
        }
    }

    public boolean isEnabled(InternalLogLevel internalLogLevel) {
        int ordinal = internalLogLevel.ordinal();
        if (ordinal == 0) {
            return isDebugEnabled();
        }
        if (ordinal == 1) {
            return isInfoEnabled();
        }
        if (ordinal == 2) {
            return isWarnEnabled();
        }
        if (ordinal == 3) {
            return isErrorEnabled();
        }
        throw new Error();
    }

    public void log(InternalLogLevel internalLogLevel, String str, Throwable th) {
        int ordinal = internalLogLevel.ordinal();
        if (ordinal == 0) {
            debug(str, th);
        } else if (ordinal == 1) {
            info(str, th);
        } else if (ordinal == 2) {
            warn(str, th);
        } else if (ordinal == 3) {
            error(str, th);
        } else {
            throw new Error();
        }
    }

    public void log(InternalLogLevel internalLogLevel, String str) {
        int ordinal = internalLogLevel.ordinal();
        if (ordinal == 0) {
            debug(str);
        } else if (ordinal == 1) {
            info(str);
        } else if (ordinal == 2) {
            warn(str);
        } else if (ordinal == 3) {
            error(str);
        } else {
            throw new Error();
        }
    }
}
