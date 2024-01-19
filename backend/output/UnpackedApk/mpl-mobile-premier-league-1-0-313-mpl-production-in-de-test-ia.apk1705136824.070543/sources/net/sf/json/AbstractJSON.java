package net.sf.json;

import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractJSON {
    public static /* synthetic */ Class class$java$lang$Class;
    public static /* synthetic */ Class class$net$sf$json$AbstractJSON;
    public static CycleSet cycleSet = new CycleSet(null);
    public static final Log log;

    public static class CycleSet extends ThreadLocal {
        public CycleSet(AnonymousClass1 r1) {
        }

        public Object initialValue() {
            return new SoftReference(new HashSet());
        }
    }

    static {
        Class<?> cls = class$net$sf$json$AbstractJSON;
        if (cls == null) {
            try {
                cls = Class.forName("net.sf.json.AbstractJSON");
                class$net$sf$json$AbstractJSON = cls;
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        }
        log = LogFactory.getLog(cls);
    }

    public static boolean addInstance(Object obj) {
        return getCycleSet().add(obj);
    }

    public static Set getCycleSet() {
        CycleSet cycleSet2 = cycleSet;
        Set set = (Set) ((SoftReference) cycleSet2.get()).get();
        if (set != null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        cycleSet2.set(new SoftReference(hashSet));
        return hashSet;
    }

    public static void removeInstance(Object obj) {
        Set cycleSet2 = getCycleSet();
        cycleSet2.remove(obj);
        if (cycleSet2.size() == 0) {
            cycleSet.remove();
        }
    }

    /* JADX WARNING: type inference failed for: r6v5, types: [net.sf.json.JSONNull] */
    /* JADX WARNING: type inference failed for: r6v10, types: [net.sf.json.JSON] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object _processValue(java.lang.Object r6, net.sf.json.JsonConfig r7) {
        /*
            r5 = this;
            net.sf.json.JSONNull r0 = net.sf.json.JSONNull.instance
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x000b
            net.sf.json.JSONNull r6 = net.sf.json.JSONNull.instance
            return r6
        L_0x000b:
            java.lang.Class r0 = class$java$lang$Class
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = "java.lang.Class"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0018 }
            class$java$lang$Class = r0
            goto L_0x0023
        L_0x0018:
            r6 = move-exception
            java.lang.NoClassDefFoundError r7 = new java.lang.NoClassDefFoundError
            java.lang.String r6 = r6.getMessage()
            r7.<init>(r6)
            throw r7
        L_0x0023:
            java.lang.Class r1 = r6.getClass()
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 != 0) goto L_0x012c
            boolean r0 = r6 instanceof java.lang.Class
            if (r0 == 0) goto L_0x0033
            goto L_0x012c
        L_0x0033:
            boolean r0 = net.sf.json.util.JSONUtils.isFunction(r6)
            if (r0 == 0) goto L_0x0044
            boolean r7 = r6 instanceof java.lang.String
            if (r7 == 0) goto L_0x0043
            java.lang.String r6 = (java.lang.String) r6
            net.sf.json.JSONFunction r6 = net.sf.json.JSONFunction.parse(r6)
        L_0x0043:
            return r6
        L_0x0044:
            boolean r0 = r6 instanceof net.sf.json.JSONString
            if (r0 == 0) goto L_0x004f
            net.sf.json.JSONString r6 = (net.sf.json.JSONString) r6
            net.sf.json.JSON r6 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.toJSON(r6, r7)
            return r6
        L_0x004f:
            boolean r0 = r6 instanceof net.sf.json.JSON
            if (r0 == 0) goto L_0x0058
            net.sf.json.JSON r6 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.toJSON(r6, r7)
            return r6
        L_0x0058:
            boolean r0 = net.sf.json.util.JSONUtils.isArray(r6)
            if (r0 == 0) goto L_0x0063
            net.sf.json.JSONArray r6 = net.sf.json.JSONArray.fromObject(r6, r7)
            return r6
        L_0x0063:
            boolean r0 = net.sf.json.util.JSONUtils.isString(r6)
            if (r0 == 0) goto L_0x010a
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r0 = r6.length()
            r1 = 2
            java.lang.String r2 = "\""
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto L_0x0079
            goto L_0x0095
        L_0x0079:
            java.lang.String r0 = "'"
            boolean r1 = r6.startsWith(r0)
            if (r1 == 0) goto L_0x0087
            boolean r0 = r6.endsWith(r0)
            if (r0 != 0) goto L_0x0093
        L_0x0087:
            boolean r0 = r6.startsWith(r2)
            if (r0 == 0) goto L_0x0095
            boolean r0 = r6.endsWith(r2)
            if (r0 == 0) goto L_0x0095
        L_0x0093:
            r0 = 1
            goto L_0x0096
        L_0x0095:
            r0 = 0
        L_0x0096:
            if (r0 == 0) goto L_0x00da
            java.lang.String r7 = net.sf.json.util.JSONUtils.stripQuotes(r6)
            boolean r0 = net.sf.json.util.JSONUtils.isFunction(r7)
            if (r0 == 0) goto L_0x00b5
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            r6.append(r2)
            r6.append(r7)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            return r6
        L_0x00b5:
            java.lang.String r0 = "["
            boolean r0 = r7.startsWith(r0)
            if (r0 == 0) goto L_0x00c6
            java.lang.String r0 = "]"
            boolean r0 = r7.endsWith(r0)
            if (r0 == 0) goto L_0x00c6
            return r7
        L_0x00c6:
            java.lang.String r0 = "{"
            boolean r0 = r7.startsWith(r0)
            if (r0 == 0) goto L_0x00d9
            java.lang.String r0 = "}"
            boolean r0 = r7.endsWith(r0)
            if (r0 == 0) goto L_0x00d9
            return r7
        L_0x00d9:
            return r6
        L_0x00da:
            java.lang.String r0 = "null"
            boolean r0 = r0.equals(r6)
            r1 = 0
            if (r0 != 0) goto L_0x00f8
            java.lang.String r0 = "true"
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x00f8
            java.lang.String r0 = "false"
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x00f8
            if (r7 == 0) goto L_0x00f7
            goto L_0x00f9
        L_0x00f7:
            throw r1
        L_0x00f8:
            r3 = 1
        L_0x00f9:
            if (r3 == 0) goto L_0x00ff
            if (r7 == 0) goto L_0x00fe
            return r6
        L_0x00fe:
            throw r1
        L_0x00ff:
            boolean r0 = net.sf.json.util.JSONUtils.mayBeJSON(r6)
            if (r0 == 0) goto L_0x0109
            net.sf.json.JSON r6 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.toJSON(r6, r7)     // Catch:{ JSONException -> 0x0109 }
        L_0x0109:
            return r6
        L_0x010a:
            boolean r0 = net.sf.json.util.JSONUtils.isNumber(r6)
            if (r0 == 0) goto L_0x011a
            net.sf.json.util.JSONUtils.testValidity(r6)
            java.lang.Number r6 = (java.lang.Number) r6
            java.lang.Number r6 = net.sf.json.util.JSONUtils.transformNumber(r6)
            return r6
        L_0x011a:
            boolean r0 = net.sf.json.util.JSONUtils.isBoolean(r6)
            if (r0 == 0) goto L_0x0121
            return r6
        L_0x0121:
            net.sf.json.JSONObject r6 = net.sf.json.JSONObject.fromObject(r6, r7)
            boolean r7 = r6.nullObject
            if (r7 == 0) goto L_0x012b
            net.sf.json.JSONNull r6 = net.sf.json.JSONNull.instance
        L_0x012b:
            return r6
        L_0x012c:
            java.lang.Class r6 = (java.lang.Class) r6
            java.lang.String r6 = r6.getName()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sf.json.AbstractJSON._processValue(java.lang.Object, net.sf.json.JsonConfig):java.lang.Object");
    }
}
