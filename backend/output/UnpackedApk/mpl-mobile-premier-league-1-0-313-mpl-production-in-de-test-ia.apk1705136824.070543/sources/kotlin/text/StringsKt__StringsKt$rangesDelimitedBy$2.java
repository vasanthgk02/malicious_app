package kotlin.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Strings.kt */
public final class StringsKt__StringsKt$rangesDelimitedBy$2 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ List<String> $delimitersList;
    public final /* synthetic */ boolean $ignoreCase;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$2(List<String> list, boolean z) {
        // this.$delimitersList = list;
        // this.$ignoreCase = z;
        super(2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.Object r14, java.lang.Object r15) {
        /*
            r13 = this;
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.Number r15 = (java.lang.Number) r15
            int r15 = r15.intValue()
            java.lang.String r0 = "$this$$receiver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.util.List<java.lang.String> r6 = r13.$delimitersList
            boolean r7 = r13.$ignoreCase
            r8 = 0
            r0 = 0
            if (r7 != 0) goto L_0x0036
            int r1 = r6.size()
            r2 = 1
            if (r1 != r2) goto L_0x0036
            java.lang.Object r1 = kotlin.collections.ArraysKt___ArraysJvmKt.single(r6)
            java.lang.String r1 = (java.lang.String) r1
            r2 = 4
            int r14 = kotlin.text.CharsKt__CharKt.indexOf$default(r14, r1, r15, r0, r2)
            if (r14 >= 0) goto L_0x002b
            goto L_0x00ca
        L_0x002b:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            kotlin.Pair r15 = new kotlin.Pair
            r15.<init>(r14, r1)
            goto L_0x00cb
        L_0x0036:
            kotlin.ranges.IntRange r1 = new kotlin.ranges.IntRange
            if (r15 >= 0) goto L_0x003b
            r15 = 0
        L_0x003b:
            int r0 = r14.length()
            r1.<init>(r15, r0)
            boolean r15 = r14 instanceof java.lang.String
            if (r15 == 0) goto L_0x0089
            int r15 = r1.first
            int r9 = r1.last
            int r10 = r1.step
            if (r10 <= 0) goto L_0x0050
            if (r15 <= r9) goto L_0x0054
        L_0x0050:
            if (r10 >= 0) goto L_0x00ca
            if (r9 > r15) goto L_0x00ca
        L_0x0054:
            java.util.Iterator r11 = r6.iterator()
        L_0x0058:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0076
            java.lang.Object r12 = r11.next()
            r0 = r12
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            r2 = r14
            java.lang.String r2 = (java.lang.String) r2
            int r4 = r0.length()
            r3 = r15
            r5 = r7
            boolean r0 = kotlin.text.CharsKt__CharKt.regionMatches(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0058
            goto L_0x0077
        L_0x0076:
            r12 = r8
        L_0x0077:
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x0085
            java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
            kotlin.Pair r15 = new kotlin.Pair
            r15.<init>(r14, r12)
            goto L_0x00cb
        L_0x0085:
            if (r15 == r9) goto L_0x00ca
            int r15 = r15 + r10
            goto L_0x0054
        L_0x0089:
            int r15 = r1.first
            int r9 = r1.last
            int r10 = r1.step
            if (r10 <= 0) goto L_0x0093
            if (r15 <= r9) goto L_0x0097
        L_0x0093:
            if (r10 >= 0) goto L_0x00ca
            if (r9 > r15) goto L_0x00ca
        L_0x0097:
            java.util.Iterator r11 = r6.iterator()
        L_0x009b:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00b7
            java.lang.Object r12 = r11.next()
            r0 = r12
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            int r4 = r0.length()
            r2 = r14
            r3 = r15
            r5 = r7
            boolean r0 = kotlin.text.CharsKt__CharKt.regionMatchesImpl(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x009b
            goto L_0x00b8
        L_0x00b7:
            r12 = r8
        L_0x00b8:
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x00c6
            java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
            kotlin.Pair r15 = new kotlin.Pair
            r15.<init>(r14, r12)
            goto L_0x00cb
        L_0x00c6:
            if (r15 == r9) goto L_0x00ca
            int r15 = r15 + r10
            goto L_0x0097
        L_0x00ca:
            r15 = r8
        L_0x00cb:
            if (r15 == 0) goto L_0x00e0
            A r14 = r15.first
            B r15 = r15.second
            java.lang.String r15 = (java.lang.String) r15
            int r15 = r15.length()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            kotlin.Pair r8 = new kotlin.Pair
            r8.<init>(r14, r15)
        L_0x00e0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
