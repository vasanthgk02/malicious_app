package org.jboss.netty.util;

import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentMap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.util.internal.ConcurrentIdentityWeakKeyHashMap;

public class DefaultObjectSizeEstimator implements ObjectSizeEstimator {
    public final ConcurrentMap<Class<?>, Integer> class2size;

    public DefaultObjectSizeEstimator() {
        ConcurrentIdentityWeakKeyHashMap concurrentIdentityWeakKeyHashMap = new ConcurrentIdentityWeakKeyHashMap();
        this.class2size = concurrentIdentityWeakKeyHashMap;
        Class cls = Boolean.TYPE;
        Integer valueOf = Integer.valueOf(4);
        concurrentIdentityWeakKeyHashMap.put(cls, valueOf);
        this.class2size.put(Byte.TYPE, Integer.valueOf(1));
        ConcurrentMap<Class<?>, Integer> concurrentMap = this.class2size;
        Class cls2 = Character.TYPE;
        Integer valueOf2 = Integer.valueOf(2);
        concurrentMap.put(cls2, valueOf2);
        this.class2size.put(Integer.TYPE, valueOf);
        this.class2size.put(Short.TYPE, valueOf2);
        ConcurrentMap<Class<?>, Integer> concurrentMap2 = this.class2size;
        Class cls3 = Long.TYPE;
        Integer valueOf3 = Integer.valueOf(8);
        concurrentMap2.put(cls3, valueOf3);
        this.class2size.put(Float.TYPE, valueOf);
        this.class2size.put(Double.TYPE, valueOf3);
        this.class2size.put(Void.TYPE, Integer.valueOf(0));
    }

    public static int align(int i) {
        int i2 = i % 8;
        return i2 != 0 ? i + (8 - i2) : i;
    }

    public int estimateSize(Object obj) {
        int length;
        int remaining;
        if (obj == null) {
            return 8;
        }
        int estimateSize = estimateSize(obj.getClass(), null) + 8;
        if (obj instanceof EstimatableObjectWrapper) {
            remaining = estimateSize(((EstimatableObjectWrapper) obj).unwrap());
        } else if (obj instanceof MessageEvent) {
            remaining = estimateSize(((MessageEvent) obj).getMessage());
        } else if (obj instanceof ChannelBuffer) {
            remaining = ((ChannelBuffer) obj).capacity();
        } else {
            if (obj instanceof byte[]) {
                length = ((byte[]) obj).length;
            } else if (obj instanceof ByteBuffer) {
                remaining = ((ByteBuffer) obj).remaining();
            } else if (obj instanceof CharSequence) {
                length = ((CharSequence) obj).length() << 1;
            } else {
                if (obj instanceof Iterable) {
                    for (Object estimateSize2 : (Iterable) obj) {
                        estimateSize += estimateSize(estimateSize2);
                    }
                }
                return align(estimateSize);
            }
            estimateSize += length;
            return align(estimateSize);
        }
        estimateSize += remaining;
        return align(estimateSize);
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r10v0, types: [java.lang.Class<?>, java.lang.Class, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int estimateSize(java.lang.Class r10, java.util.Set<java.lang.Class<?>> r11) {
        /*
            r9 = this;
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.lang.Integer> r0 = r9.class2size
            java.lang.Object r0 = r0.get(r10)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L_0x000f
            int r10 = r0.intValue()
            return r10
        L_0x000f:
            r0 = 0
            if (r11 == 0) goto L_0x0019
            boolean r1 = r11.contains(r10)
            if (r1 == 0) goto L_0x001e
            return r0
        L_0x0019:
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>()
        L_0x001e:
            r11.add(r10)
            r1 = 8
            r2 = r10
            r3 = 8
        L_0x0026:
            if (r2 == 0) goto L_0x004b
            java.lang.reflect.Field[] r4 = r2.getDeclaredFields()
            int r5 = r4.length
            r6 = 0
        L_0x002e:
            if (r6 >= r5) goto L_0x0046
            r7 = r4[r6]
            int r8 = r7.getModifiers()
            r8 = r8 & r1
            if (r8 == 0) goto L_0x003a
            goto L_0x0043
        L_0x003a:
            java.lang.Class r7 = r7.getType()
            int r7 = r9.estimateSize(r7, r11)
            int r3 = r3 + r7
        L_0x0043:
            int r6 = r6 + 1
            goto L_0x002e
        L_0x0046:
            java.lang.Class r2 = r2.getSuperclass()
            goto L_0x0026
        L_0x004b:
            r11.remove(r10)
            int r11 = align(r3)
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.lang.Integer> r0 = r9.class2size
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            r0.putIfAbsent(r10, r1)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.DefaultObjectSizeEstimator.estimateSize(java.lang.Class, java.util.Set):int");
    }
}
