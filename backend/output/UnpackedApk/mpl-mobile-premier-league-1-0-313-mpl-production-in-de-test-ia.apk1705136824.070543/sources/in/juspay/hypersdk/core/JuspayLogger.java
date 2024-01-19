package in.juspay.hypersdk.core;

import androidx.annotation.Keep;

@Keep
public final class JuspayLogger {
    public static void d(String str, String str2) {
        JuspayCoreLib.isAppDebuggable();
    }

    public static void e(String str, String str2) {
        JuspayCoreLib.isAppDebuggable();
    }

    public static void e(String str, String str2, Throwable th) {
        JuspayCoreLib.isAppDebuggable();
    }

    public static void i(String str, String str2) {
        JuspayCoreLib.isAppDebuggable();
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void log(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            int r0 = r6.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case 3237038: goto L_0x0035;
                case 95458899: goto L_0x002b;
                case 96784904: goto L_0x0021;
                case 1124446108: goto L_0x0016;
                case 1952151455: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003f
        L_0x000c:
            java.lang.String r0 = "critical"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = 0
            goto L_0x0040
        L_0x0016:
            java.lang.String r0 = "warning"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = 2
            goto L_0x0040
        L_0x0021:
            java.lang.String r0 = "error"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = 1
            goto L_0x0040
        L_0x002b:
            java.lang.String r0 = "debug"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = 4
            goto L_0x0040
        L_0x0035:
            java.lang.String r0 = "info"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003f
            r6 = 3
            goto L_0x0040
        L_0x003f:
            r6 = -1
        L_0x0040:
            if (r6 == 0) goto L_0x0057
            if (r6 == r4) goto L_0x0057
            if (r6 == r3) goto L_0x0053
            if (r6 == r2) goto L_0x004f
            if (r6 == r1) goto L_0x004b
            goto L_0x005a
        L_0x004b:
            d(r5, r7)
            goto L_0x005a
        L_0x004f:
            i(r5, r7)
            goto L_0x005a
        L_0x0053:
            w(r5, r7)
            goto L_0x005a
        L_0x0057:
            e(r5, r7)
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.JuspayLogger.log(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static void w(String str, String str2) {
        JuspayCoreLib.isAppDebuggable();
    }
}
