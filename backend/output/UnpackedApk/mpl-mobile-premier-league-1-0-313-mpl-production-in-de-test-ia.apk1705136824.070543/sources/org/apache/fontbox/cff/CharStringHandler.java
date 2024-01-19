package org.apache.fontbox.cff;

import java.util.List;

public abstract class CharStringHandler {
    public abstract List<Integer> handleCommand(List<Integer> list, CharStringCommand charStringCommand);

    /* JADX WARNING: type inference failed for: r8v0, types: [java.util.List, java.util.List<java.lang.Object>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Integer> handleSequence(java.util.List<java.lang.Object> r8) {
        /*
            r7 = this;
            int r0 = r8.size()
            r1 = 0
            r2 = 0
            r4 = r2
            r3 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x0036
            java.lang.Object r5 = r8.get(r1)
            boolean r6 = r5 instanceof org.apache.fontbox.cff.CharStringCommand
            if (r6 == 0) goto L_0x0033
            if (r4 != 0) goto L_0x0019
            java.util.List r4 = r8.subList(r3, r1)
            goto L_0x0020
        L_0x0019:
            java.util.List r3 = r8.subList(r3, r1)
            r4.addAll(r3)
        L_0x0020:
            org.apache.fontbox.cff.CharStringCommand r5 = (org.apache.fontbox.cff.CharStringCommand) r5
            java.util.List r3 = r7.handleCommand(r4, r5)
            if (r3 == 0) goto L_0x0030
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x0030
            r4 = r3
            goto L_0x0031
        L_0x0030:
            r4 = r2
        L_0x0031:
            int r3 = r1 + 1
        L_0x0033:
            int r1 = r1 + 1
            goto L_0x0008
        L_0x0036:
            if (r4 == 0) goto L_0x003f
            boolean r8 = r4.isEmpty()
            if (r8 != 0) goto L_0x003f
            return r4
        L_0x003f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.fontbox.cff.CharStringHandler.handleSequence(java.util.List):java.util.List");
    }
}
