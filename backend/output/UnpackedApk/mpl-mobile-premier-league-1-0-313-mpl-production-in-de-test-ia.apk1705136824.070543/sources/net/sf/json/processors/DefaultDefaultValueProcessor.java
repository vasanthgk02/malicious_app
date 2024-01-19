package net.sf.json.processors;

public class DefaultDefaultValueProcessor implements DefaultValueProcessor {
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        if (r2.isAssignableFrom(r4) != false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0071, code lost:
        if (r2.isAssignableFrom(r4) != false) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009f, code lost:
        if (r2.isAssignableFrom(r4) != false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00d5, code lost:
        if (r2.isAssignableFrom(r4) != false) goto L_0x00d9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getDefaultValue(java.lang.Class r4) {
        /*
            r3 = this;
            boolean r0 = net.sf.json.util.JSONUtils.isArray(r4)
            if (r0 == 0) goto L_0x000c
            net.sf.json.JSONArray r4 = new net.sf.json.JSONArray
            r4.<init>()
            return r4
        L_0x000c:
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x0054
            java.lang.Class r2 = java.lang.Byte.TYPE
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 != 0) goto L_0x0052
            java.lang.Class r2 = java.lang.Short.TYPE
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 != 0) goto L_0x0052
            java.lang.Class r2 = java.lang.Integer.TYPE
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 != 0) goto L_0x0052
            java.lang.Class r2 = java.lang.Long.TYPE
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 != 0) goto L_0x0052
            java.lang.Class r2 = java.lang.Float.TYPE
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 != 0) goto L_0x0052
            java.lang.Class r2 = java.lang.Double.TYPE
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 != 0) goto L_0x0052
            java.lang.Class r2 = net.sf.json.util.JSONUtils.class$java$lang$Number
            if (r2 != 0) goto L_0x004c
            java.lang.String r2 = "java.lang.Number"
            java.lang.Class r2 = net.sf.json.util.JSONUtils.class$(r2)
            net.sf.json.util.JSONUtils.class$java$lang$Number = r2
        L_0x004c:
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 == 0) goto L_0x0054
        L_0x0052:
            r2 = 1
            goto L_0x0055
        L_0x0054:
            r2 = 0
        L_0x0055:
            if (r2 == 0) goto L_0x0085
            if (r4 == 0) goto L_0x0074
            java.lang.Class r2 = java.lang.Double.TYPE
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 != 0) goto L_0x0075
            java.lang.Class r2 = net.sf.json.util.JSONUtils.class$java$lang$Double
            if (r2 != 0) goto L_0x006d
            java.lang.String r2 = "java.lang.Double"
            java.lang.Class r2 = net.sf.json.util.JSONUtils.class$(r2)
            net.sf.json.util.JSONUtils.class$java$lang$Double = r2
        L_0x006d:
            boolean r4 = r2.isAssignableFrom(r4)
            if (r4 == 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r0 = 0
        L_0x0075:
            if (r0 == 0) goto L_0x007f
            java.lang.Double r4 = new java.lang.Double
            r0 = 0
            r4.<init>(r0)
            return r4
        L_0x007f:
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r1)
            return r4
        L_0x0085:
            if (r4 == 0) goto L_0x00a3
            java.lang.Class r2 = java.lang.Boolean.TYPE
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 != 0) goto L_0x00a1
            java.lang.Class r2 = net.sf.json.util.JSONUtils.class$java$lang$Boolean
            if (r2 != 0) goto L_0x009b
            java.lang.String r2 = "java.lang.Boolean"
            java.lang.Class r2 = net.sf.json.util.JSONUtils.class$(r2)
            net.sf.json.util.JSONUtils.class$java$lang$Boolean = r2
        L_0x009b:
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 == 0) goto L_0x00a3
        L_0x00a1:
            r2 = 1
            goto L_0x00a4
        L_0x00a3:
            r2 = 0
        L_0x00a4:
            if (r2 == 0) goto L_0x00a9
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L_0x00a9:
            if (r4 == 0) goto L_0x00d8
            java.lang.Class r2 = net.sf.json.util.JSONUtils.class$java$lang$String
            if (r2 != 0) goto L_0x00b7
            java.lang.String r2 = "java.lang.String"
            java.lang.Class r2 = net.sf.json.util.JSONUtils.class$(r2)
            net.sf.json.util.JSONUtils.class$java$lang$String = r2
        L_0x00b7:
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 != 0) goto L_0x00d9
            java.lang.Class r2 = java.lang.Character.TYPE
            boolean r2 = r2.isAssignableFrom(r4)
            if (r2 != 0) goto L_0x00d9
            java.lang.Class r2 = net.sf.json.util.JSONUtils.class$java$lang$Character
            if (r2 != 0) goto L_0x00d1
            java.lang.String r2 = "java.lang.Character"
            java.lang.Class r2 = net.sf.json.util.JSONUtils.class$(r2)
            net.sf.json.util.JSONUtils.class$java$lang$Character = r2
        L_0x00d1:
            boolean r4 = r2.isAssignableFrom(r4)
            if (r4 == 0) goto L_0x00d8
            goto L_0x00d9
        L_0x00d8:
            r0 = 0
        L_0x00d9:
            if (r0 == 0) goto L_0x00de
            java.lang.String r4 = ""
            return r4
        L_0x00de:
            net.sf.json.JSONNull r4 = net.sf.json.JSONNull.instance
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sf.json.processors.DefaultDefaultValueProcessor.getDefaultValue(java.lang.Class):java.lang.Object");
    }
}
