package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KTypeProjection;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/reflect/KTypeProjection;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TypeReference.kt */
public final class TypeReference$asString$args$1 extends Lambda implements Function1<KTypeProjection, CharSequence> {
    public final /* synthetic */ TypeReference this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TypeReference$asString$args$1(TypeReference typeReference) {
        // this.this$0 = typeReference;
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r4) {
        /*
            r3 = this;
            kotlin.reflect.KTypeProjection r4 = (kotlin.reflect.KTypeProjection) r4
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.TypeReference r0 = r3.this$0
            r1 = 0
            if (r0 == 0) goto L_0x004e
            kotlin.reflect.KVariance r0 = r4.variance
            if (r0 != 0) goto L_0x0013
            java.lang.String r4 = "*"
            goto L_0x004d
        L_0x0013:
            kotlin.reflect.KType r0 = r4.type
            boolean r2 = r0 instanceof kotlin.jvm.internal.TypeReference
            if (r2 == 0) goto L_0x001c
            r1 = r0
            kotlin.jvm.internal.TypeReference r1 = (kotlin.jvm.internal.TypeReference) r1
        L_0x001c:
            r0 = 1
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = r1.asString(r0)
            if (r1 != 0) goto L_0x002b
        L_0x0025:
            kotlin.reflect.KType r1 = r4.type
            java.lang.String r1 = java.lang.String.valueOf(r1)
        L_0x002b:
            kotlin.reflect.KVariance r4 = r4.variance
            int r4 = r4.ordinal()
            if (r4 == 0) goto L_0x004c
            if (r4 == r0) goto L_0x0045
            r0 = 2
            if (r4 != r0) goto L_0x003f
            java.lang.String r4 = "out "
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r4, r1)
            goto L_0x004d
        L_0x003f:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        L_0x0045:
            java.lang.String r4 = "in "
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r4, r1)
            goto L_0x004d
        L_0x004c:
            r4 = r1
        L_0x004d:
            return r4
        L_0x004e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.TypeReference$asString$args$1.invoke(java.lang.Object):java.lang.Object");
    }
}
