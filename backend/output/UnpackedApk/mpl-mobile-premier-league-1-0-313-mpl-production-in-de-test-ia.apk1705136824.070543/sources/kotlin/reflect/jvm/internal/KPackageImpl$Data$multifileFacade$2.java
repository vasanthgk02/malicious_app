package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPackageImpl.Data;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Class;", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KPackageImpl.kt */
public final class KPackageImpl$Data$multifileFacade$2 extends Lambda implements Function0<Class<?>> {
    public final /* synthetic */ Data this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KPackageImpl$Data$multifileFacade$2(Data data) {
        // this.this$0 = data;
        super(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke() {
        /*
            r6 = this;
            kotlin.reflect.jvm.internal.KPackageImpl$Data r0 = r6.this$0
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass r0 = kotlin.reflect.jvm.internal.KPackageImpl.Data.access$getKotlinClass$p(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0012
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r0.classHeader
            if (r0 == 0) goto L_0x0012
            java.lang.String r0 = r0.getMultifileClassName()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            if (r0 == 0) goto L_0x0038
            int r2 = r0.length()
            r3 = 0
            if (r2 <= 0) goto L_0x001e
            r2 = 1
            goto L_0x001f
        L_0x001e:
            r2 = 0
        L_0x001f:
            if (r2 == 0) goto L_0x0038
            kotlin.reflect.jvm.internal.KPackageImpl$Data r1 = r6.this$0
            kotlin.reflect.jvm.internal.KPackageImpl r1 = kotlin.reflect.jvm.internal.KPackageImpl.this
            java.lang.Class<?> r1 = r1.jClass
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r2 = 47
            r4 = 46
            r5 = 4
            java.lang.String r0 = kotlin.text.CharsKt__CharKt.replace$default(r0, r2, r4, r3, r5)
            java.lang.Class r1 = r1.loadClass(r0)
        L_0x0038:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPackageImpl$Data$multifileFacade$2.invoke():java.lang.Object");
    }
}
