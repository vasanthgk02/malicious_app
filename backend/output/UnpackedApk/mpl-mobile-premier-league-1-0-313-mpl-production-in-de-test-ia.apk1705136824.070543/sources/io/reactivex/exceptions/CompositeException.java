package io.reactivex.exceptions;

import com.smartfoxserver.bitswarm.util.Logging;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException extends RuntimeException {
    public static final long serialVersionUID = 3026362227162912146L;
    public Throwable cause;
    public final List<Throwable> exceptions;
    public final String message;

    public static final class CompositeExceptionCausalChain extends RuntimeException {
        public static final long serialVersionUID = 3875212506787802066L;

        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    public static abstract class PrintStreamOrWriter {
        public abstract void println(Object obj);
    }

    public static final class WrappedPrintStream extends PrintStreamOrWriter {
        public final PrintStream printStream;

        public WrappedPrintStream(PrintStream printStream2) {
            this.printStream = printStream2;
        }

        public void println(Object obj) {
            this.printStream.println(obj);
        }
    }

    public static final class WrappedPrintWriter extends PrintStreamOrWriter {
        public final PrintWriter printWriter;

        public WrappedPrintWriter(PrintWriter printWriter2) {
            this.printWriter = printWriter2;
        }

        public void println(Object obj) {
            this.printWriter.println(obj);
        }
    }

    public CompositeException(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).exceptions);
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            this.exceptions = Collections.unmodifiableList(arrayList);
            this.message = this.exceptions.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    public final void appendStackTrace(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append(10);
        for (StackTraceElement append : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(append);
            sb.append(10);
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            appendStackTrace(sb, th.getCause(), "");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:10|(1:(1:13)(1:(2:14|(1:52)(1:(2:53|17)(1:18)))))(0)|19|(4:22|(2:24|55)(2:25|56)|54|20)|26|27|28|29|(1:49)(1:(2:32|50)(3:(2:33|(1:57)(1:(2:58|36)(1:37)))|38|51))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x006d */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0016 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Throwable getCause() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.Throwable r0 = r8.cause     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x0085
            io.reactivex.exceptions.CompositeException$CompositeExceptionCausalChain r0 = new io.reactivex.exceptions.CompositeException$CompositeExceptionCausalChain     // Catch:{ all -> 0x0089 }
            r0.<init>()     // Catch:{ all -> 0x0089 }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0089 }
            r1.<init>()     // Catch:{ all -> 0x0089 }
            java.util.List<java.lang.Throwable> r2 = r8.exceptions     // Catch:{ all -> 0x0089 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0089 }
            r3 = r0
        L_0x0016:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x0083
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0089 }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x0089 }
            boolean r5 = r1.contains(r4)     // Catch:{ all -> 0x0089 }
            if (r5 == 0) goto L_0x0029
            goto L_0x0016
        L_0x0029:
            r1.add(r4)     // Catch:{ all -> 0x0089 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0089 }
            r5.<init>()     // Catch:{ all -> 0x0089 }
            java.lang.Throwable r6 = r4.getCause()     // Catch:{ all -> 0x0089 }
            if (r6 == 0) goto L_0x0048
            if (r6 != r4) goto L_0x003a
            goto L_0x0048
        L_0x003a:
            r5.add(r6)     // Catch:{ all -> 0x0089 }
            java.lang.Throwable r7 = r6.getCause()     // Catch:{ all -> 0x0089 }
            if (r7 == 0) goto L_0x0048
            if (r7 != r6) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r6 = r7
            goto L_0x003a
        L_0x0048:
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0089 }
        L_0x004c:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0089 }
            if (r6 == 0) goto L_0x006a
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0089 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0089 }
            boolean r7 = r1.contains(r6)     // Catch:{ all -> 0x0089 }
            if (r7 == 0) goto L_0x0066
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x0089 }
            java.lang.String r6 = "Duplicate found in causal chain so cropping to prevent loop ..."
            r4.<init>(r6)     // Catch:{ all -> 0x0089 }
            goto L_0x004c
        L_0x0066:
            r1.add(r6)     // Catch:{ all -> 0x0089 }
            goto L_0x004c
        L_0x006a:
            r3.initCause(r4)     // Catch:{ all -> 0x006d }
        L_0x006d:
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x0016
            if (r3 != r4) goto L_0x0076
            goto L_0x0016
        L_0x0076:
            java.lang.Throwable r3 = r4.getCause()     // Catch:{ all -> 0x0089 }
            if (r3 == 0) goto L_0x0081
            if (r3 != r4) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            r4 = r3
            goto L_0x0076
        L_0x0081:
            r3 = r4
            goto L_0x0016
        L_0x0083:
            r8.cause = r0     // Catch:{ all -> 0x0089 }
        L_0x0085:
            java.lang.Throwable r0 = r8.cause     // Catch:{ all -> 0x0089 }
            monitor-exit(r8)
            return r0
        L_0x0089:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.exceptions.CompositeException.getCause():java.lang.Throwable");
    }

    public String getMessage() {
        return this.message;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        printStackTrace((PrintStreamOrWriter) new WrappedPrintStream(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace((PrintStreamOrWriter) new WrappedPrintWriter(printWriter));
    }

    public final void printStackTrace(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append(10);
        for (StackTraceElement append : getStackTrace()) {
            sb.append("\tat ");
            sb.append(append);
            sb.append(10);
        }
        int i = 1;
        for (Throwable appendStackTrace : this.exceptions) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            appendStackTrace(sb, appendStackTrace, Logging.TAB);
            i++;
        }
        printStreamOrWriter.println(sb.toString());
    }
}
