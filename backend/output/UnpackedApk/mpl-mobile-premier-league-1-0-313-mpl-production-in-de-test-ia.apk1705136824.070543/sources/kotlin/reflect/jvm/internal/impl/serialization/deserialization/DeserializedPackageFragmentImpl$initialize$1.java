package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedPackageFragmentImpl.kt */
public final class DeserializedPackageFragmentImpl$initialize$1 extends Lambda implements Function0<Collection<? extends Name>> {
    public final /* synthetic */ DeserializedPackageFragmentImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DeserializedPackageFragmentImpl$initialize$1(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        // this.this$0 = deserializedPackageFragmentImpl;
        super(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0013 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke() {
        /*
            r5 = this;
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl r0 = r5.this$0
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoBasedClassDataFinder r0 = r0.classDataFinder
            java.util.Map<kotlin.reflect.jvm.internal.impl.name.ClassId, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r0 = r0.classIdToProto
            java.util.Set r0 = r0.keySet()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0013:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0039
            java.lang.Object r2 = r0.next()
            r3 = r2
            kotlin.reflect.jvm.internal.impl.name.ClassId r3 = (kotlin.reflect.jvm.internal.impl.name.ClassId) r3
            boolean r4 = r3.isNestedClass()
            if (r4 != 0) goto L_0x0032
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.Companion
            java.util.Set<kotlin.reflect.jvm.internal.impl.name.ClassId> r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.BLACK_LIST
            boolean r3 = r4.contains(r3)
            if (r3 != 0) goto L_0x0032
            r3 = 1
            goto L_0x0033
        L_0x0032:
            r3 = 0
        L_0x0033:
            if (r3 == 0) goto L_0x0013
            r1.add(r2)
            goto L_0x0013
        L_0x0039:
            java.util.ArrayList r0 = new java.util.ArrayList
            r2 = 10
            int r2 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r1, r2)
            r0.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x0048:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x005c
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.name.ClassId r2 = (kotlin.reflect.jvm.internal.impl.name.ClassId) r2
            kotlin.reflect.jvm.internal.impl.name.Name r2 = r2.getShortClassName()
            r0.add(r2)
            goto L_0x0048
        L_0x005c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl$initialize$1.invoke():java.lang.Object");
    }
}
