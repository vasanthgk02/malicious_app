package org.eclipse.paho.client.mqttv3.logging;

import java.util.logging.Formatter;

public class SimpleLogFormatter extends Formatter {
    public static final String LS = System.getProperty("line.separator");

    public static String left(String str, int i, char c2) {
        if (str.length() >= i) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(str);
        int length = i - str.length();
        while (true) {
            length--;
            if (length < 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append(c2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ce A[SYNTHETIC, Splitter:B:20:0x00ce] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String format(java.util.logging.LogRecord r9) {
        /*
            r8 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.util.logging.Level r1 = r9.getLevel()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r1 = "\t"
            r0.append(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.util.Date r5 = new java.util.Date
            long r6 = r9.getMillis()
            r5.<init>(r6)
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "{0, date, yy-MM-dd} {0, time, kk:mm:ss.SSSS} "
            java.lang.String r4 = java.text.MessageFormat.format(r5, r4)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r2.<init>(r4)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r2 = r9.getSourceClassName()
            r4 = 32
            if (r2 == 0) goto L_0x006d
            int r5 = r2.length()
            r7 = 20
            if (r5 <= r7) goto L_0x0059
            java.lang.String r2 = r9.getSourceClassName()
            int r5 = r5 + -19
            java.lang.String r2 = r2.substring(r5)
            goto L_0x006f
        L_0x0059:
            char[] r5 = new char[r3]
            r5[r6] = r4
            java.lang.StringBuffer r7 = new java.lang.StringBuffer
            r7.<init>()
            r7.append(r2)
            r7.append(r5, r6, r3)
            java.lang.String r2 = r7.toString()
            goto L_0x006f
        L_0x006d:
            java.lang.String r2 = ""
        L_0x006f:
            r0.append(r2)
            r0.append(r1)
            java.lang.String r2 = " "
            r0.append(r2)
            java.lang.String r2 = r9.getSourceMethodName()
            r3 = 23
            java.lang.String r2 = left(r2, r3, r4)
            r0.append(r2)
            r0.append(r1)
            int r2 = r9.getThreadID()
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = r8.formatMessage(r9)
            r0.append(r1)
            java.lang.String r1 = LS
            r0.append(r1)
            java.lang.Throwable r1 = r9.getThrown()
            if (r1 == 0) goto L_0x00d2
            java.lang.String r1 = "Throwable occurred: "
            r0.append(r1)
            java.lang.Throwable r9 = r9.getThrown()
            r1 = 0
            java.io.StringWriter r2 = new java.io.StringWriter     // Catch:{ all -> 0x00cb }
            r2.<init>()     // Catch:{ all -> 0x00cb }
            java.io.PrintWriter r3 = new java.io.PrintWriter     // Catch:{ all -> 0x00cb }
            r3.<init>(r2)     // Catch:{ all -> 0x00cb }
            r9.printStackTrace(r3)     // Catch:{ all -> 0x00c8 }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x00c8 }
            r0.append(r9)     // Catch:{ all -> 0x00c8 }
            r3.close()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00d2
        L_0x00c8:
            r9 = move-exception
            r1 = r3
            goto L_0x00cc
        L_0x00cb:
            r9 = move-exception
        L_0x00cc:
            if (r1 == 0) goto L_0x00d1
            r1.close()     // Catch:{ Exception -> 0x00d1 }
        L_0x00d1:
            throw r9
        L_0x00d2:
            java.lang.String r9 = r0.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.paho.client.mqttv3.logging.SimpleLogFormatter.format(java.util.logging.LogRecord):java.lang.String");
    }
}
