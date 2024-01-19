package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 4, 1})
/* compiled from: -Utf8.kt */
public final class _Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(str, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[(str.length() * 4)];
        int length = str.length();
        int i4 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (Intrinsics.compare((int) charAt, 128) >= 0) {
                int length2 = str.length();
                int i5 = i;
                while (i < length2) {
                    char charAt2 = str.charAt(i);
                    if (Intrinsics.compare((int) charAt2, 128) < 0) {
                        int i6 = i5 + 1;
                        bArr[i5] = (byte) charAt2;
                        i++;
                        while (i < length2 && Intrinsics.compare((int) str.charAt(i), 128) < 0) {
                            bArr[i6] = (byte) str.charAt(i);
                            i++;
                            i6++;
                        }
                        i5 = i6;
                    } else {
                        if (Intrinsics.compare((int) charAt2, 2048) < 0) {
                            int i7 = i5 + 1;
                            bArr[i5] = (byte) ((charAt2 >> 6) | 192);
                            i2 = i7 + 1;
                            bArr[i7] = (byte) ((charAt2 & '?') | 128);
                        } else if (55296 > charAt2 || 57343 < charAt2) {
                            int i8 = i5 + 1;
                            bArr[i5] = (byte) ((charAt2 >> Tokenizer.FF) | 224);
                            int i9 = i8 + 1;
                            bArr[i8] = (byte) (((charAt2 >> 6) & 63) | 128);
                            i2 = i9 + 1;
                            bArr[i9] = (byte) ((charAt2 & '?') | 128);
                        } else {
                            if (Intrinsics.compare((int) charAt2, 56319) <= 0) {
                                int i10 = i + 1;
                                if (length2 > i10) {
                                    char charAt3 = str.charAt(i10);
                                    if (56320 <= charAt3 && 57343 >= charAt3) {
                                        int charAt4 = (str.charAt(i10) + (charAt2 << 10)) - 56613888;
                                        int i11 = i5 + 1;
                                        bArr[i5] = (byte) ((charAt4 >> 18) | 240);
                                        int i12 = i11 + 1;
                                        bArr[i11] = (byte) (((charAt4 >> 12) & 63) | 128);
                                        int i13 = i12 + 1;
                                        bArr[i12] = (byte) (((charAt4 >> 6) & 63) | 128);
                                        i2 = i13 + 1;
                                        bArr[i13] = (byte) ((charAt4 & 63) | 128);
                                        i3 = i + 2;
                                        i5 = i2;
                                    }
                                }
                            }
                            i2 = i5 + 1;
                            bArr[i5] = Utf8.REPLACEMENT_BYTE;
                        }
                        i3 = i + 1;
                        i5 = i2;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i5);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i] = (byte) charAt;
            i4 = i + 1;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkNotNullExpressionValue(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008d, code lost:
        if (((r12[r2] & 192) == 128) == false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0109, code lost:
        if (((r12[r2] & 192) == 128) == false) goto L_0x0133;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String commonToUtf8String(byte[] r12, int r13, int r14) {
        /*
            java.lang.String r0 = "$this$commonToUtf8String"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            if (r13 < 0) goto L_0x019f
            int r0 = r12.length
            if (r14 > r0) goto L_0x019f
            if (r13 > r14) goto L_0x019f
            int r0 = r14 - r13
            char[] r0 = new char[r0]
            r1 = 0
            r2 = 0
        L_0x0012:
            if (r13 >= r14) goto L_0x0199
            byte r3 = r12[r13]
            if (r3 < 0) goto L_0x0033
            char r3 = (char) r3
            int r4 = r2 + 1
            r0[r2] = r3
            int r13 = r13 + 1
        L_0x001f:
            if (r13 >= r14) goto L_0x0031
            byte r2 = r12[r13]
            if (r2 < 0) goto L_0x0031
            int r2 = r13 + 1
            byte r13 = r12[r13]
            char r13 = (char) r13
            int r3 = r4 + 1
            r0[r4] = r13
            r13 = r2
            r4 = r3
            goto L_0x001f
        L_0x0031:
            r2 = r4
            goto L_0x0012
        L_0x0033:
            int r4 = r3 >> 5
            r5 = -2
            r6 = 128(0x80, float:1.8E-43)
            r7 = 65533(0xfffd, float:9.1831E-41)
            if (r4 != r5) goto L_0x006d
            int r3 = r13 + 1
            if (r14 > r3) goto L_0x0047
            char r3 = (char) r7
            int r4 = r2 + 1
            r0[r2] = r3
            goto L_0x00a4
        L_0x0047:
            byte r4 = r12[r13]
            byte r3 = r12[r3]
            r5 = r3 & 192(0xc0, float:2.69E-43)
            if (r5 != r6) goto L_0x0051
            r5 = 1
            goto L_0x0052
        L_0x0051:
            r5 = 0
        L_0x0052:
            if (r5 != 0) goto L_0x005a
            char r3 = (char) r7
            int r4 = r2 + 1
            r0[r2] = r3
            goto L_0x00a4
        L_0x005a:
            r3 = r3 ^ 3968(0xf80, float:5.56E-42)
            int r4 = r4 << 6
            r3 = r3 ^ r4
            if (r3 >= r6) goto L_0x0067
            char r3 = (char) r7
            int r4 = r2 + 1
            r0[r2] = r3
            goto L_0x00b6
        L_0x0067:
            char r3 = (char) r3
            int r4 = r2 + 1
            r0[r2] = r3
            goto L_0x00b6
        L_0x006d:
            int r4 = r3 >> 4
            r8 = 55296(0xd800, float:7.7486E-41)
            r9 = 57343(0xdfff, float:8.0355E-41)
            if (r4 != r5) goto L_0x00e0
            int r3 = r13 + 2
            if (r14 > r3) goto L_0x0090
            char r3 = (char) r7
            int r4 = r2 + 1
            r0[r2] = r3
            int r2 = r13 + 1
            if (r14 <= r2) goto L_0x00a4
            byte r2 = r12[r2]
            r2 = r2 & 192(0xc0, float:2.69E-43)
            if (r2 != r6) goto L_0x008c
            r2 = 1
            goto L_0x008d
        L_0x008c:
            r2 = 0
        L_0x008d:
            if (r2 != 0) goto L_0x00b6
            goto L_0x00a4
        L_0x0090:
            byte r4 = r12[r13]
            int r5 = r13 + 1
            byte r5 = r12[r5]
            r10 = r5 & 192(0xc0, float:2.69E-43)
            if (r10 != r6) goto L_0x009c
            r10 = 1
            goto L_0x009d
        L_0x009c:
            r10 = 0
        L_0x009d:
            if (r10 != 0) goto L_0x00a6
            char r3 = (char) r7
            int r4 = r2 + 1
            r0[r2] = r3
        L_0x00a4:
            r2 = 1
            goto L_0x00dd
        L_0x00a6:
            byte r3 = r12[r3]
            r10 = r3 & 192(0xc0, float:2.69E-43)
            if (r10 != r6) goto L_0x00ae
            r6 = 1
            goto L_0x00af
        L_0x00ae:
            r6 = 0
        L_0x00af:
            if (r6 != 0) goto L_0x00b8
            char r3 = (char) r7
            int r4 = r2 + 1
            r0[r2] = r3
        L_0x00b6:
            r2 = 2
            goto L_0x00dd
        L_0x00b8:
            r6 = -123008(0xfffffffffffe1f80, float:NaN)
            r3 = r3 ^ r6
            int r5 = r5 << 6
            r3 = r3 ^ r5
            int r4 = r4 << 12
            r3 = r3 ^ r4
            r4 = 2048(0x800, float:2.87E-42)
            if (r3 >= r4) goto L_0x00cc
            char r3 = (char) r7
            int r4 = r2 + 1
            r0[r2] = r3
            goto L_0x00dc
        L_0x00cc:
            if (r8 <= r3) goto L_0x00cf
            goto L_0x00d7
        L_0x00cf:
            if (r9 < r3) goto L_0x00d7
            char r3 = (char) r7
            int r4 = r2 + 1
            r0[r2] = r3
            goto L_0x00dc
        L_0x00d7:
            char r3 = (char) r3
            int r4 = r2 + 1
            r0[r2] = r3
        L_0x00dc:
            r2 = 3
        L_0x00dd:
            int r13 = r13 + r2
            goto L_0x0031
        L_0x00e0:
            int r3 = r3 >> 3
            if (r3 != r5) goto L_0x0190
            int r3 = r13 + 3
            if (r14 > r3) goto L_0x010c
            int r3 = r2 + 1
            r0[r2] = r7
            int r2 = r13 + 1
            if (r14 <= r2) goto L_0x011f
            byte r2 = r12[r2]
            r2 = r2 & 192(0xc0, float:2.69E-43)
            if (r2 != r6) goto L_0x00f8
            r2 = 1
            goto L_0x00f9
        L_0x00f8:
            r2 = 0
        L_0x00f9:
            if (r2 != 0) goto L_0x00fc
            goto L_0x011f
        L_0x00fc:
            int r2 = r13 + 2
            if (r14 <= r2) goto L_0x0133
            byte r2 = r12[r2]
            r2 = r2 & 192(0xc0, float:2.69E-43)
            if (r2 != r6) goto L_0x0108
            r2 = 1
            goto L_0x0109
        L_0x0108:
            r2 = 0
        L_0x0109:
            if (r2 != 0) goto L_0x0144
            goto L_0x0133
        L_0x010c:
            byte r4 = r12[r13]
            int r5 = r13 + 1
            byte r5 = r12[r5]
            r10 = r5 & 192(0xc0, float:2.69E-43)
            if (r10 != r6) goto L_0x0118
            r10 = 1
            goto L_0x0119
        L_0x0118:
            r10 = 0
        L_0x0119:
            if (r10 != 0) goto L_0x0122
            int r3 = r2 + 1
            r0[r2] = r7
        L_0x011f:
            r2 = 1
            goto L_0x018e
        L_0x0122:
            int r10 = r13 + 2
            byte r10 = r12[r10]
            r11 = r10 & 192(0xc0, float:2.69E-43)
            if (r11 != r6) goto L_0x012c
            r11 = 1
            goto L_0x012d
        L_0x012c:
            r11 = 0
        L_0x012d:
            if (r11 != 0) goto L_0x0135
            int r3 = r2 + 1
            r0[r2] = r7
        L_0x0133:
            r2 = 2
            goto L_0x018e
        L_0x0135:
            byte r3 = r12[r3]
            r11 = r3 & 192(0xc0, float:2.69E-43)
            if (r11 != r6) goto L_0x013d
            r6 = 1
            goto L_0x013e
        L_0x013d:
            r6 = 0
        L_0x013e:
            if (r6 != 0) goto L_0x0146
            int r3 = r2 + 1
            r0[r2] = r7
        L_0x0144:
            r2 = 3
            goto L_0x018e
        L_0x0146:
            r6 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r6
            int r6 = r10 << 6
            r3 = r3 ^ r6
            int r5 = r5 << 12
            r3 = r3 ^ r5
            int r4 = r4 << 18
            r3 = r3 ^ r4
            r4 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r4) goto L_0x015d
            int r3 = r2 + 1
            r0[r2] = r7
            goto L_0x018d
        L_0x015d:
            if (r8 <= r3) goto L_0x0160
            goto L_0x0167
        L_0x0160:
            if (r9 < r3) goto L_0x0167
            int r3 = r2 + 1
            r0[r2] = r7
            goto L_0x018d
        L_0x0167:
            r4 = 65536(0x10000, float:9.1835E-41)
            if (r3 >= r4) goto L_0x0170
            int r3 = r2 + 1
            r0[r2] = r7
            goto L_0x018d
        L_0x0170:
            if (r3 == r7) goto L_0x0189
            int r4 = r3 >>> 10
            r5 = 55232(0xd7c0, float:7.7397E-41)
            int r4 = r4 + r5
            char r4 = (char) r4
            int r5 = r2 + 1
            r0[r2] = r4
            r2 = r3 & 1023(0x3ff, float:1.434E-42)
            r3 = 56320(0xdc00, float:7.8921E-41)
            int r2 = r2 + r3
            char r2 = (char) r2
            int r3 = r5 + 1
            r0[r5] = r2
            goto L_0x018d
        L_0x0189:
            int r3 = r2 + 1
            r0[r2] = r7
        L_0x018d:
            r2 = 4
        L_0x018e:
            int r13 = r13 + r2
            goto L_0x0196
        L_0x0190:
            int r3 = r2 + 1
            r0[r2] = r7
            int r13 = r13 + 1
        L_0x0196:
            r2 = r3
            goto L_0x0012
        L_0x0199:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r0, r1, r2)
            return r12
        L_0x019f:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.String r1 = "size="
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r1)
            int r12 = r12.length
            r1.append(r12)
            java.lang.String r12 = " beginIndex="
            r1.append(r12)
            r1.append(r13)
            java.lang.String r12 = " endIndex="
            r1.append(r12)
            r1.append(r14)
            java.lang.String r12 = r1.toString()
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }
}
