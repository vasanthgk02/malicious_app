package okhttp3.internal.ws;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003JN\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", "", "perMessageDeflate", "", "clientMaxWindowBits", "", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", "other", "hashCode", "noContextTakeover", "clientOriginated", "toString", "", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: WebSocketExtensions.kt */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    public static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "()V", "HEADER_WEB_SOCKET_EXTENSION", "", "parse", "Lokhttp3/internal/ws/WebSocketExtensions;", "responseHeaders", "Lokhttp3/Headers;", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: WebSocketExtensions.kt */
    public static final class Companion {
        public Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d8, code lost:
            if (r7 == null) goto L_0x00da;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0108, code lost:
            if (r9 == null) goto L_0x00da;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final okhttp3.internal.ws.WebSocketExtensions parse(okhttp3.Headers r22) throws java.io.IOException {
            /*
                r21 = this;
                r0 = r22
                java.lang.String r1 = "responseHeaders"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                int r1 = r22.size()
                r4 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
            L_0x0012:
                if (r4 >= r1) goto L_0x0130
                java.lang.String r5 = r0.name(r4)
                java.lang.String r12 = "Sec-WebSocket-Extensions"
                r13 = 1
                boolean r5 = kotlin.text.CharsKt__CharKt.equals(r5, r12, r13)
                if (r5 != 0) goto L_0x0024
            L_0x0021:
                r15 = 0
                goto L_0x012c
            L_0x0024:
                java.lang.String r5 = r0.value(r4)
                r12 = 0
            L_0x0029:
                int r14 = r5.length()
                if (r12 >= r14) goto L_0x0021
                r15 = 44
                r17 = 0
                r18 = 4
                r19 = 0
                r14 = r5
                r16 = r12
                int r14 = okhttp3.internal.Util.delimiterOffset$default(r14, r15, r16, r17, r18, r19)
                r15 = 59
                int r2 = okhttp3.internal.Util.delimiterOffset(r5, r15, r12, r14)
                java.lang.String r12 = okhttp3.internal.Util.trimSubstring(r5, r12, r2)
                int r2 = r2 + r13
                java.lang.String r3 = "permessage-deflate"
                boolean r3 = kotlin.text.CharsKt__CharKt.equals(r12, r3, r13)
                if (r3 == 0) goto L_0x0127
                if (r6 == 0) goto L_0x0054
                r11 = 1
            L_0x0054:
                if (r2 >= r14) goto L_0x0122
                int r3 = okhttp3.internal.Util.delimiterOffset(r5, r15, r2, r14)
                r6 = 61
                int r6 = okhttp3.internal.Util.delimiterOffset(r5, r6, r2, r3)
                java.lang.String r2 = okhttp3.internal.Util.trimSubstring(r5, r2, r6)
                if (r6 >= r3) goto L_0x00bf
                int r6 = r6 + 1
                java.lang.String r6 = okhttp3.internal.Util.trimSubstring(r5, r6, r3)
                java.lang.String r12 = "\""
                java.lang.String r15 = "<this>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r15)
                java.lang.String r13 = "delimiter"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r13)
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r15)
                java.lang.String r13 = "prefix"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r13)
                java.lang.String r13 = "suffix"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r13)
                int r13 = r6.length()
                int r15 = r12.length()
                int r20 = r12.length()
                int r15 = r20 + r15
                if (r13 < r15) goto L_0x00bd
                r13 = 2
                r15 = 0
                boolean r17 = kotlin.text.CharsKt__CharKt.startsWith$default(r6, r12, r15, r13)
                if (r17 == 0) goto L_0x00c1
                boolean r13 = kotlin.text.CharsKt__CharKt.endsWith$default(r6, r12, r15, r13)
                if (r13 == 0) goto L_0x00c1
                int r13 = r12.length()
                int r17 = r6.length()
                int r12 = r12.length()
                int r12 = r17 - r12
                java.lang.String r6 = r6.substring(r13, r12)
                java.lang.String r12 = "this as java.lang.String…ing(startIndex, endIndex)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r12)
                goto L_0x00c1
            L_0x00bd:
                r15 = 0
                goto L_0x00c1
            L_0x00bf:
                r15 = 0
                r6 = 0
            L_0x00c1:
                int r3 = r3 + 1
                java.lang.String r12 = "client_max_window_bits"
                r13 = 1
                boolean r12 = kotlin.text.CharsKt__CharKt.equals(r2, r12, r13)
                if (r12 == 0) goto L_0x00dd
                if (r7 == 0) goto L_0x00cf
                r11 = 1
            L_0x00cf:
                if (r6 == 0) goto L_0x00d7
                java.lang.Integer r2 = kotlin.text.CharsKt__CharKt.toIntOrNull(r6)
                r7 = r2
                goto L_0x00d8
            L_0x00d7:
                r7 = 0
            L_0x00d8:
                if (r7 != 0) goto L_0x00db
            L_0x00da:
                r11 = 1
            L_0x00db:
                r13 = 1
                goto L_0x011d
            L_0x00dd:
                java.lang.String r12 = "client_no_context_takeover"
                r13 = 1
                boolean r12 = kotlin.text.CharsKt__CharKt.equals(r2, r12, r13)
                if (r12 == 0) goto L_0x00f4
                if (r8 == 0) goto L_0x00e9
                r11 = 1
            L_0x00e9:
                if (r6 == 0) goto L_0x00ee
                r19 = 1
                goto L_0x00f0
            L_0x00ee:
                r19 = r11
            L_0x00f0:
                r11 = r19
                r8 = 1
                goto L_0x011d
            L_0x00f4:
                java.lang.String r12 = "server_max_window_bits"
                boolean r12 = kotlin.text.CharsKt__CharKt.equals(r2, r12, r13)
                if (r12 == 0) goto L_0x010b
                if (r9 == 0) goto L_0x00ff
                r11 = 1
            L_0x00ff:
                if (r6 == 0) goto L_0x0107
                java.lang.Integer r2 = kotlin.text.CharsKt__CharKt.toIntOrNull(r6)
                r9 = r2
                goto L_0x0108
            L_0x0107:
                r9 = 0
            L_0x0108:
                if (r9 != 0) goto L_0x00db
                goto L_0x00da
            L_0x010b:
                java.lang.String r12 = "server_no_context_takeover"
                r13 = 1
                boolean r2 = kotlin.text.CharsKt__CharKt.equals(r2, r12, r13)
                if (r2 == 0) goto L_0x011c
                if (r10 == 0) goto L_0x0117
                r11 = 1
            L_0x0117:
                if (r6 == 0) goto L_0x011a
                r11 = 1
            L_0x011a:
                r10 = 1
                goto L_0x011d
            L_0x011c:
                r11 = 1
            L_0x011d:
                r2 = r3
                r15 = 59
                goto L_0x0054
            L_0x0122:
                r15 = 0
                r12 = r2
                r6 = 1
                goto L_0x0029
            L_0x0127:
                r15 = 0
                r12 = r2
                r11 = 1
                goto L_0x0029
            L_0x012c:
                int r4 = r4 + 1
                goto L_0x0012
            L_0x0130:
                okhttp3.internal.ws.WebSocketExtensions r0 = new okhttp3.internal.ws.WebSocketExtensions
                r5 = r0
                r5.<init>(r6, r7, r8, r9, r10, r11)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.Companion.parse(okhttp3.Headers):okhttp3.internal.ws.WebSocketExtensions");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        this.perMessageDeflate = z;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z2;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z3;
        this.unknownValues = z4;
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = webSocketExtensions.perMessageDeflate;
        }
        if ((i & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        Integer num3 = num;
        if ((i & 4) != 0) {
            z2 = webSocketExtensions.clientNoContextTakeover;
        }
        boolean z5 = z2;
        if ((i & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        Integer num4 = num2;
        if ((i & 16) != 0) {
            z3 = webSocketExtensions.serverNoContextTakeover;
        }
        boolean z6 = z3;
        if ((i & 32) != 0) {
            z4 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(z, num3, z5, num4, z6, z4);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        WebSocketExtensions webSocketExtensions = new WebSocketExtensions(z, num, z2, num2, z3, z4);
        return webSocketExtensions;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r2.unknownValues == r3.unknownValues) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0037
            boolean r0 = r3 instanceof okhttp3.internal.ws.WebSocketExtensions
            if (r0 == 0) goto L_0x0035
            okhttp3.internal.ws.WebSocketExtensions r3 = (okhttp3.internal.ws.WebSocketExtensions) r3
            boolean r0 = r2.perMessageDeflate
            boolean r1 = r3.perMessageDeflate
            if (r0 != r1) goto L_0x0035
            java.lang.Integer r0 = r2.clientMaxWindowBits
            java.lang.Integer r1 = r3.clientMaxWindowBits
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0035
            boolean r0 = r2.clientNoContextTakeover
            boolean r1 = r3.clientNoContextTakeover
            if (r0 != r1) goto L_0x0035
            java.lang.Integer r0 = r2.serverMaxWindowBits
            java.lang.Integer r1 = r3.serverMaxWindowBits
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0035
            boolean r0 = r2.serverNoContextTakeover
            boolean r1 = r3.serverNoContextTakeover
            if (r0 != r1) goto L_0x0035
            boolean r0 = r2.unknownValues
            boolean r3 = r3.unknownValues
            if (r0 != r3) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r3 = 0
            return r3
        L_0x0037:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        boolean z = this.perMessageDeflate;
        int i = 1;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        Integer num = this.clientMaxWindowBits;
        int i3 = 0;
        int hashCode = (i2 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z2 = this.clientNoContextTakeover;
        if (z2) {
            z2 = true;
        }
        int i4 = (hashCode + (z2 ? 1 : 0)) * 31;
        Integer num2 = this.serverMaxWindowBits;
        if (num2 != null) {
            i3 = num2.hashCode();
        }
        int i5 = (i4 + i3) * 31;
        boolean z3 = this.serverNoContextTakeover;
        if (z3) {
            z3 = true;
        }
        int i6 = (i5 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.unknownValues;
        if (!z4) {
            i = z4;
        }
        return i6 + i;
    }

    public final boolean noContextTakeover(boolean z) {
        if (z) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("WebSocketExtensions(perMessageDeflate=");
        outline73.append(this.perMessageDeflate);
        outline73.append(", clientMaxWindowBits=");
        outline73.append(this.clientMaxWindowBits);
        outline73.append(", clientNoContextTakeover=");
        outline73.append(this.clientNoContextTakeover);
        outline73.append(", serverMaxWindowBits=");
        outline73.append(this.serverMaxWindowBits);
        outline73.append(", serverNoContextTakeover=");
        outline73.append(this.serverNoContextTakeover);
        outline73.append(", unknownValues=");
        return GeneratedOutlineSupport.outline66(outline73, this.unknownValues, ")");
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WebSocketExtensions(boolean r6, java.lang.Integer r7, boolean r8, java.lang.Integer r9, boolean r10, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = 0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            r1 = 0
            if (r6 == 0) goto L_0x000f
            r2 = r1
            goto L_0x0010
        L_0x000f:
            r2 = r7
        L_0x0010:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0016
            r3 = 0
            goto L_0x0017
        L_0x0016:
            r3 = r8
        L_0x0017:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = 0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = 0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r2
            r9 = r3
            r10 = r1
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.<init>(boolean, java.lang.Integer, boolean, java.lang.Integer, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
