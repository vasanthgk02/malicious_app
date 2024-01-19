package com.cardinalcommerce.cardinalmobilesdk.models;

public enum CardinalActionCode {
    ERROR("ERROR"),
    SUCCESS("SUCCESS"),
    NOACTION("NOACTION"),
    FAILURE("FAILURE"),
    CANCEL("CANCEL"),
    TIMEOUT("TIMEOUT");
    
    public final String string;

    /* access modifiers changed from: public */
    CardinalActionCode(String str) {
        this.string = str;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode getActionCode(java.lang.String r1) {
        /*
            java.lang.String r1 = r1.toUpperCase()
            int r0 = r1.hashCode()
            switch(r0) {
                case -1149187101: goto L_0x0048;
                case -595928767: goto L_0x003e;
                case -368591510: goto L_0x0034;
                case 66247144: goto L_0x002a;
                case 1334385268: goto L_0x0020;
                case 1818912567: goto L_0x0016;
                case 1980572282: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0052
        L_0x000c:
            java.lang.String r0 = "CANCEL"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0052
            r1 = 5
            goto L_0x0053
        L_0x0016:
            java.lang.String r0 = "NOACTION"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0052
            r1 = 2
            goto L_0x0053
        L_0x0020:
            java.lang.String r0 = "NO_ACTION"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0052
            r1 = 3
            goto L_0x0053
        L_0x002a:
            java.lang.String r0 = "ERROR"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0052
            r1 = 0
            goto L_0x0053
        L_0x0034:
            java.lang.String r0 = "FAILURE"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0052
            r1 = 4
            goto L_0x0053
        L_0x003e:
            java.lang.String r0 = "TIMEOUT"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0052
            r1 = 6
            goto L_0x0053
        L_0x0048:
            java.lang.String r0 = "SUCCESS"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0052
            r1 = 1
            goto L_0x0053
        L_0x0052:
            r1 = -1
        L_0x0053:
            switch(r1) {
                case 0: goto L_0x0068;
                case 1: goto L_0x0065;
                case 2: goto L_0x0062;
                case 3: goto L_0x0062;
                case 4: goto L_0x005f;
                case 5: goto L_0x005c;
                case 6: goto L_0x0059;
                default: goto L_0x0056;
            }
        L_0x0056:
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r1 = ERROR
            return r1
        L_0x0059:
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r1 = TIMEOUT
            return r1
        L_0x005c:
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r1 = CANCEL
            return r1
        L_0x005f:
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r1 = FAILURE
            return r1
        L_0x0062:
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r1 = NOACTION
            return r1
        L_0x0065:
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r1 = SUCCESS
            return r1
        L_0x0068:
            com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode r1 = ERROR
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode.getActionCode(java.lang.String):com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode");
    }

    public String getString() {
        return this.string;
    }
}
