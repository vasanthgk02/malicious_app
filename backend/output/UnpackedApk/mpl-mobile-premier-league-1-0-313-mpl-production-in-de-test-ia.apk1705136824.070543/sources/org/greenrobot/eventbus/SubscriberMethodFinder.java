package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

public class SubscriberMethodFinder {
    public static final FindState[] FIND_STATE_POOL = new FindState[4];
    public static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE = new ConcurrentHashMap();
    public final boolean ignoreGeneratedIndex;
    public final boolean strictMethodVerification;
    public List<SubscriberInfoIndex> subscriberInfoIndexes;

    public static class FindState {
        public final Map<Class, Object> anyMethodByEventType = new HashMap();
        public Class<?> clazz;
        public final StringBuilder methodKeyBuilder = new StringBuilder(128);
        public boolean skipSuperClasses;
        public final Map<String, Class> subscriberClassByMethodKey = new HashMap();
        public SubscriberInfo subscriberInfo;
        public final List<SubscriberMethod> subscriberMethods = new ArrayList();

        public boolean checkAdd(Method method, Class<?> cls) {
            Object put = this.anyMethodByEventType.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (checkAddWithMethodSignature((Method) put, cls)) {
                    this.anyMethodByEventType.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return checkAddWithMethodSignature(method, cls);
        }

        public final boolean checkAddWithMethodSignature(Method method, Class<?> cls) {
            this.methodKeyBuilder.setLength(0);
            this.methodKeyBuilder.append(method.getName());
            StringBuilder sb = this.methodKeyBuilder;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.methodKeyBuilder.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.subscriberClassByMethodKey.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.subscriberClassByMethodKey.put(sb2, put);
            return false;
        }

        public void moveToSuperclass() {
            if (this.skipSuperClasses) {
                this.clazz = null;
                return;
            }
            Class<? super T> superclass = this.clazz.getSuperclass();
            this.clazz = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.clazz = null;
            }
        }
    }

    public SubscriberMethodFinder(List<SubscriberInfoIndex> list, boolean z, boolean z2) {
        this.subscriberInfoIndexes = list;
        this.strictMethodVerification = z;
        this.ignoreGeneratedIndex = z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d9, code lost:
        r15 = com.android.tools.r8.GeneratedOutlineSupport.outline35(r15.clazz, com.android.tools.r8.GeneratedOutlineSupport.outline73("Could not inspect methods of "));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e7, code lost:
        if (r14.ignoreGeneratedIndex != false) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e9, code lost:
        r15 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r15, ". Please consider using EventBus annotation processor to avoid reflection.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f0, code lost:
        r15 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r15, ". Please make this class visible to EventBus annotation processor to avoid reflection.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00fb, code lost:
        throw new org.greenrobot.eventbus.EventBusException(r15, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r1 = r15.clazz.getMethods();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r15.skipSuperClasses = true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0008 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void findUsingReflectionInSingleClass(org.greenrobot.eventbus.SubscriberMethodFinder.FindState r15) {
        /*
            r14 = this;
            r0 = 1
            java.lang.Class<?> r1 = r15.clazz     // Catch:{ all -> 0x0008 }
            java.lang.reflect.Method[] r1 = r1.getDeclaredMethods()     // Catch:{ all -> 0x0008 }
            goto L_0x0010
        L_0x0008:
            java.lang.Class<?> r1 = r15.clazz     // Catch:{ LinkageError -> 0x00d8 }
            java.lang.reflect.Method[] r1 = r1.getMethods()     // Catch:{ LinkageError -> 0x00d8 }
            r15.skipSuperClasses = r0
        L_0x0010:
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x0013:
            if (r4 >= r2) goto L_0x00d7
            r6 = r1[r4]
            int r5 = r6.getModifiers()
            r7 = r5 & 1
            java.lang.String r8 = "."
            if (r7 == 0) goto L_0x009c
            r5 = r5 & 5192(0x1448, float:7.276E-42)
            if (r5 != 0) goto L_0x009c
            java.lang.Class[] r5 = r6.getParameterTypes()
            int r7 = r5.length
            if (r7 != r0) goto L_0x005b
            java.lang.Class<org.greenrobot.eventbus.Subscribe> r7 = org.greenrobot.eventbus.Subscribe.class
            java.lang.annotation.Annotation r7 = r6.getAnnotation(r7)
            org.greenrobot.eventbus.Subscribe r7 = (org.greenrobot.eventbus.Subscribe) r7
            if (r7 == 0) goto L_0x00d3
            r8 = r5[r3]
            boolean r5 = r15.checkAdd(r6, r8)
            if (r5 == 0) goto L_0x00d3
            org.greenrobot.eventbus.ThreadMode r9 = r7.threadMode()
            java.util.List<org.greenrobot.eventbus.SubscriberMethod> r11 = r15.subscriberMethods
            org.greenrobot.eventbus.SubscriberMethod r12 = new org.greenrobot.eventbus.SubscriberMethod
            int r10 = r7.priority()
            boolean r13 = r7.sticky()
            r5 = r12
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r13
            r5.<init>(r6, r7, r8, r9, r10)
            r11.add(r12)
            goto L_0x00d3
        L_0x005b:
            boolean r7 = r14.strictMethodVerification
            if (r7 == 0) goto L_0x00d3
            java.lang.Class<org.greenrobot.eventbus.Subscribe> r7 = org.greenrobot.eventbus.Subscribe.class
            boolean r7 = r6.isAnnotationPresent(r7)
            if (r7 != 0) goto L_0x0068
            goto L_0x00d3
        L_0x0068:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.Class r0 = r6.getDeclaringClass()
            java.lang.String r0 = r0.getName()
            r15.append(r0)
            r15.append(r8)
            java.lang.String r0 = r6.getName()
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            org.greenrobot.eventbus.EventBusException r0 = new org.greenrobot.eventbus.EventBusException
            java.lang.String r1 = "@Subscribe method "
            java.lang.String r2 = "must have exactly 1 parameter but has "
            java.lang.StringBuilder r15 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r1, r15, r2)
            int r1 = r5.length
            r15.append(r1)
            java.lang.String r15 = r15.toString()
            r0.<init>(r15)
            throw r0
        L_0x009c:
            boolean r5 = r14.strictMethodVerification
            if (r5 == 0) goto L_0x00d3
            java.lang.Class<org.greenrobot.eventbus.Subscribe> r5 = org.greenrobot.eventbus.Subscribe.class
            boolean r5 = r6.isAnnotationPresent(r5)
            if (r5 != 0) goto L_0x00a9
            goto L_0x00d3
        L_0x00a9:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.Class r0 = r6.getDeclaringClass()
            java.lang.String r0 = r0.getName()
            r15.append(r0)
            r15.append(r8)
            java.lang.String r0 = r6.getName()
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            org.greenrobot.eventbus.EventBusException r0 = new org.greenrobot.eventbus.EventBusException
            java.lang.String r1 = " is a illegal @Subscribe method: must be public, non-static, and non-abstract"
            java.lang.String r15 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r15, r1)
            r0.<init>(r15)
            throw r0
        L_0x00d3:
            int r4 = r4 + 1
            goto L_0x0013
        L_0x00d7:
            return
        L_0x00d8:
            r0 = move-exception
            java.lang.String r1 = "Could not inspect methods of "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            java.lang.Class<?> r15 = r15.clazz
            java.lang.String r15 = com.android.tools.r8.GeneratedOutlineSupport.outline35(r15, r1)
            boolean r1 = r14.ignoreGeneratedIndex
            if (r1 == 0) goto L_0x00f0
            java.lang.String r1 = ". Please consider using EventBus annotation processor to avoid reflection."
            java.lang.String r15 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r15, r1)
            goto L_0x00f6
        L_0x00f0:
            java.lang.String r1 = ". Please make this class visible to EventBus annotation processor to avoid reflection."
            java.lang.String r15 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r15, r1)
        L_0x00f6:
            org.greenrobot.eventbus.EventBusException r1 = new org.greenrobot.eventbus.EventBusException
            r1.<init>(r15, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.SubscriberMethodFinder.findUsingReflectionInSingleClass(org.greenrobot.eventbus.SubscriberMethodFinder$FindState):void");
    }

    public final List<SubscriberMethod> getMethodsAndRelease(FindState findState) {
        ArrayList arrayList = new ArrayList(findState.subscriberMethods);
        findState.subscriberMethods.clear();
        findState.anyMethodByEventType.clear();
        findState.subscriberClassByMethodKey.clear();
        int i = 0;
        findState.methodKeyBuilder.setLength(0);
        findState.clazz = null;
        findState.skipSuperClasses = false;
        findState.subscriberInfo = null;
        synchronized (FIND_STATE_POOL) {
            while (true) {
                if (i >= 4) {
                    break;
                }
                try {
                    if (FIND_STATE_POOL[i] == null) {
                        FIND_STATE_POOL[i] = findState;
                        break;
                    }
                    i++;
                }
            }
        }
        return arrayList;
    }

    public final FindState prepareFindState() {
        synchronized (FIND_STATE_POOL) {
            int i = 0;
            while (i < 4) {
                try {
                    FindState findState = FIND_STATE_POOL[i];
                    if (findState != null) {
                        FIND_STATE_POOL[i] = null;
                        return findState;
                    }
                    i++;
                }
            }
            return new FindState();
        }
    }
}
