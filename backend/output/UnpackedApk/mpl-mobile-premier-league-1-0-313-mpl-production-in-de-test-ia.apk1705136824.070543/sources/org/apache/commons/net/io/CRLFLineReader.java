package org.apache.commons.net.io;

import java.io.BufferedReader;
import java.io.Reader;

public final class CRLFLineReader extends BufferedReader {
    private static final char CR = '\r';
    private static final char LF = '\n';

    public CRLFLineReader(Reader reader) {
        super(reader);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        r0 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r0.length() != 0) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String readLine() throws java.io.IOException {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Object r1 = r6.lock
            monitor-enter(r1)
            r2 = 0
            r3 = 0
        L_0x000a:
            int r4 = r6.read()     // Catch:{ all -> 0x003c }
            r5 = -1
            if (r4 == r5) goto L_0x002f
            r5 = 1
            if (r3 == 0) goto L_0x0023
            r3 = 10
            if (r4 != r3) goto L_0x0023
            int r3 = r0.length()     // Catch:{ all -> 0x003c }
            int r3 = r3 - r5
            java.lang.String r0 = r0.substring(r2, r3)     // Catch:{ all -> 0x003c }
            monitor-exit(r1)     // Catch:{ all -> 0x003c }
            return r0
        L_0x0023:
            r3 = 13
            if (r4 != r3) goto L_0x0029
            r3 = 1
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            char r4 = (char) r4     // Catch:{ all -> 0x003c }
            r0.append(r4)     // Catch:{ all -> 0x003c }
            goto L_0x000a
        L_0x002f:
            monitor-exit(r1)     // Catch:{ all -> 0x003c }
            java.lang.String r0 = r0.toString()
            int r1 = r0.length()
            if (r1 != 0) goto L_0x003b
            r0 = 0
        L_0x003b:
            return r0
        L_0x003c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003c }
            goto L_0x0040
        L_0x003f:
            throw r0
        L_0x0040:
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.io.CRLFLineReader.readLine():java.lang.String");
    }
}
