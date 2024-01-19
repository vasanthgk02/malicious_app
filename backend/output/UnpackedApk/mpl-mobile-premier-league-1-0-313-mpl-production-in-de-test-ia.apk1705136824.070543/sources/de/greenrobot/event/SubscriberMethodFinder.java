package de.greenrobot.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscriberMethodFinder {
    public static final int BRIDGE = 64;
    public static final SubscriberIndex INDEX;
    public static final Map<String, List<SubscriberMethod>> METHOD_CACHE = new HashMap();
    public static final int MODIFIERS_IGNORE = 5192;
    public static final int SYNTHETIC = 4096;
    public final boolean strictMethodVerification;

    static {
        SubscriberIndex subscriberIndex;
        try {
            subscriberIndex = (SubscriberIndex) Class.forName("de.greenrobot.event.GeneratedSubscriberIndex").newInstance();
        } catch (ClassNotFoundException unused) {
            String str = EventBus.TAG;
        } catch (Exception unused2) {
            String str2 = EventBus.TAG;
        }
        INDEX = subscriberIndex;
        subscriberIndex = null;
        INDEX = subscriberIndex;
    }

    public SubscriberMethodFinder(boolean z) {
        this.strictMethodVerification = z;
    }

    public static void clearCaches() {
        synchronized (METHOD_CACHE) {
            METHOD_CACHE.clear();
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r5v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<de.greenrobot.event.SubscriberMethod> findSubscriberMethodsWithIndex(java.lang.Class r5) {
        /*
            r4 = this;
        L_0x0000:
            if (r5 == 0) goto L_0x0041
            de.greenrobot.event.SubscriberIndex r0 = INDEX
            de.greenrobot.event.SubscriberMethod[] r0 = r0.getSubscribersFor(r5)
            if (r0 == 0) goto L_0x001f
            int r1 = r0.length
            if (r1 <= 0) goto L_0x001f
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            int r1 = r0.length
            r2 = 0
        L_0x0014:
            if (r2 >= r1) goto L_0x001e
            r3 = r0[r2]
            r5.add(r3)
            int r2 = r2 + 1
            goto L_0x0014
        L_0x001e:
            return r5
        L_0x001f:
            java.lang.String r0 = r5.getName()
            java.lang.String r1 = "java."
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x0041
            java.lang.String r1 = "javax."
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x0041
            java.lang.String r1 = "android."
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x003c
            goto L_0x0041
        L_0x003c:
            java.lang.Class r5 = r5.getSuperclass()
            goto L_0x0000
        L_0x0041:
            java.util.List r5 = java.util.Collections.EMPTY_LIST
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: de.greenrobot.event.SubscriberMethodFinder.findSubscriberMethodsWithIndex(java.lang.Class):java.util.List");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r18v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<de.greenrobot.event.SubscriberMethod> findSubscriberMethodsWithReflection(java.lang.Class r18) {
        /*
            r17 = this;
            r0 = r17
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = r18
        L_0x0013:
            if (r4 == 0) goto L_0x00ff
            java.lang.String r5 = r4.getName()
            java.lang.String r6 = "java."
            boolean r6 = r5.startsWith(r6)
            if (r6 != 0) goto L_0x00ff
            java.lang.String r6 = "javax."
            boolean r6 = r5.startsWith(r6)
            if (r6 != 0) goto L_0x00ff
            java.lang.String r6 = "android."
            boolean r6 = r5.startsWith(r6)
            if (r6 == 0) goto L_0x0033
            goto L_0x00ff
        L_0x0033:
            java.lang.reflect.Method[] r6 = r4.getDeclaredMethods()
            int r7 = r6.length
            r8 = 0
            r9 = 0
        L_0x003a:
            if (r9 >= r7) goto L_0x00f9
            r11 = r6[r9]
            int r10 = r11.getModifiers()
            r12 = r10 & 1
            java.lang.String r13 = "."
            if (r12 == 0) goto L_0x00cc
            r10 = r10 & 5192(0x1448, float:7.276E-42)
            if (r10 != 0) goto L_0x00cc
            java.lang.Class[] r10 = r11.getParameterTypes()
            int r12 = r10.length
            r14 = 1
            if (r12 != r14) goto L_0x009a
            java.lang.Class<de.greenrobot.event.Subscribe> r12 = de.greenrobot.event.Subscribe.class
            java.lang.annotation.Annotation r12 = r11.getAnnotation(r12)
            de.greenrobot.event.Subscribe r12 = (de.greenrobot.event.Subscribe) r12
            if (r12 == 0) goto L_0x00f4
            java.lang.String r13 = r11.getName()
            r14 = r10[r8]
            r3.setLength(r8)
            r3.append(r13)
            r8 = 62
            r3.append(r8)
            java.lang.String r8 = r14.getName()
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            boolean r8 = r2.add(r8)
            if (r8 == 0) goto L_0x00f4
            de.greenrobot.event.ThreadMode r13 = r12.threadMode()
            de.greenrobot.event.SubscriberMethod r8 = new de.greenrobot.event.SubscriberMethod
            int r15 = r12.priority()
            boolean r16 = r12.sticky()
            r10 = r8
            r12 = r14
            r14 = r15
            r15 = r16
            r10.<init>(r11, r12, r13, r14, r15)
            r1.add(r8)
            goto L_0x00f4
        L_0x009a:
            boolean r8 = r0.strictMethodVerification
            if (r8 == 0) goto L_0x00f4
            java.lang.Class<de.greenrobot.event.Subscribe> r8 = de.greenrobot.event.Subscribe.class
            boolean r8 = r11.isAnnotationPresent(r8)
            if (r8 != 0) goto L_0x00a7
            goto L_0x00f4
        L_0x00a7:
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline78(r5, r13)
            java.lang.String r2 = r11.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            de.greenrobot.event.EventBusException r2 = new de.greenrobot.event.EventBusException
            java.lang.String r3 = "@Subscribe method "
            java.lang.String r4 = "must have exactly 1 parameter but has "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r3, r1, r4)
            int r3 = r10.length
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x00cc:
            boolean r8 = r0.strictMethodVerification
            if (r8 == 0) goto L_0x00f4
            java.lang.Class<de.greenrobot.event.Subscribe> r8 = de.greenrobot.event.Subscribe.class
            boolean r8 = r11.isAnnotationPresent(r8)
            if (r8 != 0) goto L_0x00d9
            goto L_0x00f4
        L_0x00d9:
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline78(r5, r13)
            java.lang.String r2 = r11.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            de.greenrobot.event.EventBusException r2 = new de.greenrobot.event.EventBusException
            java.lang.String r3 = " is a illegal @Subscribe method: must be public, non-static, and non-abstract"
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r1, r3)
            r2.<init>(r1)
            throw r2
        L_0x00f4:
            int r9 = r9 + 1
            r8 = 0
            goto L_0x003a
        L_0x00f9:
            java.lang.Class r4 = r4.getSuperclass()
            goto L_0x0013
        L_0x00ff:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: de.greenrobot.event.SubscriberMethodFinder.findSubscriberMethodsWithReflection(java.lang.Class):java.util.List");
    }

    public List<SubscriberMethod> findSubscriberMethods(Class<?> cls, boolean z) {
        List<SubscriberMethod> list;
        List<SubscriberMethod> list2;
        String name = cls.getName();
        synchronized (METHOD_CACHE) {
            try {
                list = METHOD_CACHE.get(name);
            }
        }
        if (list != null) {
            return list;
        }
        if (INDEX == null || z) {
            list2 = findSubscriberMethodsWithReflection(cls);
        } else {
            list2 = findSubscriberMethodsWithIndex(cls);
            if (list2.isEmpty()) {
                list2 = findSubscriberMethodsWithReflection(cls);
            }
        }
        if (!list2.isEmpty()) {
            synchronized (METHOD_CACHE) {
                try {
                    METHOD_CACHE.put(name, list2);
                }
            }
            return list2;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }
}
