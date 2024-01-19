package okio;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\b\u001a4\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006 "}, d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, k = 2, mv = {1, 4, 1})
/* compiled from: Utf8.kt */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = '�';
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i) {
        return (i >= 0 && 31 >= i) || (127 <= i && 159 >= i);
    }

    public static final boolean isUtf8Continuation(byte b2) {
        return (b2 & 192) == 128;
    }

    public static final int process2Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$process2Utf8Bytes");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i3 = i + 1;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b2 = bArr[i];
        byte b3 = bArr[i3];
        if (!((b3 & 192) == 128)) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b4 = (b3 ^ 3968) ^ (b2 << 6);
        if (b4 < 128) {
            function1.invoke(valueOf);
        } else {
            function1.invoke(Integer.valueOf(b4));
        }
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$process3Utf8Bytes");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i3 = i + 2;
        boolean z = false;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    z = true;
                }
                return !z ? 1 : 2;
            }
        }
        byte b2 = bArr[i];
        byte b3 = bArr[i + 1];
        if (!((b3 & 192) == 128)) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b4 = bArr[i3];
        if ((b4 & 192) == 128) {
            z = true;
        }
        if (!z) {
            function1.invoke(valueOf);
            return 2;
        }
        byte b5 = ((b4 ^ -123008) ^ (b3 << 6)) ^ (b2 << MqttWireMessage.MESSAGE_TYPE_PINGREQ);
        if (b5 < 2048) {
            function1.invoke(valueOf);
        } else if (55296 <= b5 && 57343 >= b5) {
            function1.invoke(valueOf);
        } else {
            function1.invoke(Integer.valueOf(b5));
        }
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] bArr, int i, int i2, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$process4Utf8Bytes");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i3 = i + 3;
        boolean z = false;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    int i5 = i + 2;
                    if (i2 > i5) {
                        if ((bArr[i5] & 192) == 128) {
                            z = true;
                        }
                        return !z ? 2 : 3;
                    }
                }
            }
            return 1;
        }
        byte b2 = bArr[i];
        byte b3 = bArr[i + 1];
        if (!((b3 & 192) == 128)) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b4 = bArr[i + 2];
        if (!((b4 & 192) == 128)) {
            function1.invoke(valueOf);
            return 2;
        }
        byte b5 = bArr[i3];
        if ((b5 & 192) == 128) {
            z = true;
        }
        if (!z) {
            function1.invoke(valueOf);
            return 3;
        }
        byte b6 = (((b5 ^ 3678080) ^ (b4 << 6)) ^ (b3 << MqttWireMessage.MESSAGE_TYPE_PINGREQ)) ^ (b2 << 18);
        if (b6 > 1114111) {
            function1.invoke(valueOf);
        } else if (55296 <= b6 && 57343 >= b6) {
            function1.invoke(valueOf);
        } else if (b6 < 65536) {
            function1.invoke(valueOf);
        } else {
            function1.invoke(Integer.valueOf(b6));
        }
        return 4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0093, code lost:
        if (r8 == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x010c, code lost:
        if (r8 == false) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf16Chars(byte[] r16, int r17, int r18, kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.Unit> r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.String r3 = "$this$processUtf16Chars"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "yield"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r3 = r17
        L_0x0013:
            if (r3 >= r1) goto L_0x01a0
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0037
            char r4 = (char) r4
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            int r3 = r3 + 1
        L_0x0023:
            if (r3 >= r1) goto L_0x0013
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0013
            int r4 = r3 + 1
            byte r3 = r0[r3]
            char r3 = (char) r3
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r2.invoke(r3)
            r3 = r4
            goto L_0x0023
        L_0x0037:
            int r5 = r4 >> 5
            r6 = -2
            r8 = 0
            r9 = 128(0x80, float:1.8E-43)
            r10 = 65533(0xfffd, float:9.1831E-41)
            r11 = 1
            if (r5 != r6) goto L_0x0071
            int r4 = r3 + 1
            if (r1 > r4) goto L_0x0051
        L_0x0047:
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
        L_0x004f:
            r7 = 1
            goto L_0x006f
        L_0x0051:
            byte r5 = r0[r3]
            byte r4 = r0[r4]
            r6 = r4 & 192(0xc0, float:2.69E-43)
            if (r6 != r9) goto L_0x005a
            r8 = 1
        L_0x005a:
            if (r8 != 0) goto L_0x005d
            goto L_0x0047
        L_0x005d:
            r4 = r4 ^ 3968(0xf80, float:5.56E-42)
            int r5 = r5 << 6
            r4 = r4 ^ r5
            if (r4 >= r9) goto L_0x0066
            char r4 = (char) r10
            goto L_0x0067
        L_0x0066:
            char r4 = (char) r4
        L_0x0067:
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
        L_0x006e:
            r7 = 2
        L_0x006f:
            int r3 = r3 + r7
            goto L_0x0013
        L_0x0071:
            int r5 = r4 >> 4
            r12 = 55296(0xd800, float:7.7486E-41)
            r13 = 57343(0xdfff, float:8.0355E-41)
            r14 = 3
            if (r5 != r6) goto L_0x00e1
            int r4 = r3 + 2
            if (r1 > r4) goto L_0x0096
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004f
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r9) goto L_0x0093
            r8 = 1
        L_0x0093:
            if (r8 != 0) goto L_0x006e
            goto L_0x004f
        L_0x0096:
            byte r5 = r0[r3]
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x00a2
            r15 = 1
            goto L_0x00a3
        L_0x00a2:
            r15 = 0
        L_0x00a3:
            if (r15 != 0) goto L_0x00ae
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            goto L_0x004f
        L_0x00ae:
            byte r4 = r0[r4]
            r15 = r4 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x00b5
            r8 = 1
        L_0x00b5:
            if (r8 != 0) goto L_0x00c0
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            goto L_0x006e
        L_0x00c0:
            r7 = -123008(0xfffffffffffe1f80, float:NaN)
            r4 = r4 ^ r7
            int r6 = r6 << 6
            r4 = r4 ^ r6
            int r5 = r5 << 12
            r4 = r4 ^ r5
            r5 = 2048(0x800, float:2.87E-42)
            if (r4 >= r5) goto L_0x00d7
        L_0x00ce:
            char r4 = (char) r10
        L_0x00cf:
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            goto L_0x00df
        L_0x00d7:
            if (r12 <= r4) goto L_0x00da
            goto L_0x00dd
        L_0x00da:
            if (r13 < r4) goto L_0x00dd
            goto L_0x00ce
        L_0x00dd:
            char r4 = (char) r4
            goto L_0x00cf
        L_0x00df:
            r7 = 3
            goto L_0x006f
        L_0x00e1:
            int r4 = r4 >> 3
            if (r4 != r6) goto L_0x0195
            int r4 = r3 + 3
            if (r1 > r4) goto L_0x0110
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004f
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r9) goto L_0x00fc
            r4 = 1
            goto L_0x00fd
        L_0x00fc:
            r4 = 0
        L_0x00fd:
            if (r4 != 0) goto L_0x0101
            goto L_0x004f
        L_0x0101:
            int r4 = r3 + 2
            if (r1 <= r4) goto L_0x006e
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r9) goto L_0x010c
            r8 = 1
        L_0x010c:
            if (r8 != 0) goto L_0x00df
            goto L_0x006e
        L_0x0110:
            byte r5 = r0[r3]
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x011c
            r15 = 1
            goto L_0x011d
        L_0x011c:
            r15 = 0
        L_0x011d:
            if (r15 != 0) goto L_0x0128
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            goto L_0x004f
        L_0x0128:
            int r15 = r3 + 2
            byte r15 = r0[r15]
            r7 = r15 & 192(0xc0, float:2.69E-43)
            if (r7 != r9) goto L_0x0132
            r7 = 1
            goto L_0x0133
        L_0x0132:
            r7 = 0
        L_0x0133:
            if (r7 != 0) goto L_0x013e
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            goto L_0x006e
        L_0x013e:
            byte r4 = r0[r4]
            r7 = r4 & 192(0xc0, float:2.69E-43)
            if (r7 != r9) goto L_0x0145
            r8 = 1
        L_0x0145:
            if (r8 != 0) goto L_0x014f
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            goto L_0x00df
        L_0x014f:
            r7 = 3678080(0x381f80, float:5.154088E-39)
            r4 = r4 ^ r7
            int r7 = r15 << 6
            r4 = r4 ^ r7
            int r6 = r6 << 12
            r4 = r4 ^ r6
            int r5 = r5 << 18
            r4 = r4 ^ r5
            r5 = 1114111(0x10ffff, float:1.561202E-39)
            if (r4 <= r5) goto L_0x0169
        L_0x0161:
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            goto L_0x0192
        L_0x0169:
            if (r12 <= r4) goto L_0x016c
            goto L_0x016f
        L_0x016c:
            if (r13 < r4) goto L_0x016f
            goto L_0x0161
        L_0x016f:
            r5 = 65536(0x10000, float:9.1835E-41)
            if (r4 >= r5) goto L_0x0174
            goto L_0x0161
        L_0x0174:
            if (r4 == r10) goto L_0x0161
            int r5 = r4 >>> 10
            r6 = 55232(0xd7c0, float:7.7397E-41)
            int r5 = r5 + r6
            char r5 = (char) r5
            java.lang.Character r5 = java.lang.Character.valueOf(r5)
            r2.invoke(r5)
            r4 = r4 & 1023(0x3ff, float:1.434E-42)
            r5 = 56320(0xdc00, float:7.8921E-41)
            int r4 = r4 + r5
            char r4 = (char) r4
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
        L_0x0192:
            r7 = 4
            goto L_0x006f
        L_0x0195:
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            int r3 = r3 + 1
            goto L_0x0013
        L_0x01a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final void processUtf8Bytes(String str, int i, int i2, Function1<? super Byte, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "$this$processUtf8Bytes");
        Intrinsics.checkNotNullParameter(function1, "yield");
        while (i < i2) {
            char charAt = str.charAt(i);
            if (Intrinsics.compare((int) charAt, 128) < 0) {
                function1.invoke(Byte.valueOf((byte) charAt));
                i++;
                while (i < i2 && Intrinsics.compare((int) str.charAt(i), 128) < 0) {
                    function1.invoke(Byte.valueOf((byte) str.charAt(i)));
                    i++;
                }
            } else {
                if (Intrinsics.compare((int) charAt, 2048) < 0) {
                    function1.invoke(Byte.valueOf((byte) ((charAt >> 6) | 192)));
                    function1.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                } else if (55296 > charAt || 57343 < charAt) {
                    function1.invoke(Byte.valueOf((byte) ((charAt >> Tokenizer.FF) | 224)));
                    function1.invoke(Byte.valueOf((byte) (((charAt >> 6) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                } else {
                    if (Intrinsics.compare((int) charAt, 56319) <= 0) {
                        int i3 = i + 1;
                        if (i2 > i3) {
                            char charAt2 = str.charAt(i3);
                            if (56320 <= charAt2 && 57343 >= charAt2) {
                                int charAt3 = (str.charAt(i3) + (charAt << 10)) - 56613888;
                                function1.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                                function1.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                                function1.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                                function1.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                                i += 2;
                            }
                        }
                    }
                    function1.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                }
                i++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        if (r8 == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x010a, code lost:
        if (r8 == false) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf8CodePoints(byte[] r16, int r17, int r18, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.String r3 = "$this$processUtf8CodePoints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "yield"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r3 = r17
        L_0x0013:
            if (r3 >= r1) goto L_0x0185
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0035
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.invoke(r4)
            int r3 = r3 + 1
        L_0x0022:
            if (r3 >= r1) goto L_0x0013
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0013
            int r4 = r3 + 1
            byte r3 = r0[r3]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.invoke(r3)
            r3 = r4
            goto L_0x0022
        L_0x0035:
            int r5 = r4 >> 5
            r6 = -2
            r8 = 0
            r9 = 128(0x80, float:1.8E-43)
            r10 = 65533(0xfffd, float:9.1831E-41)
            r11 = 1
            if (r5 != r6) goto L_0x0070
            int r4 = r3 + 1
            if (r1 > r4) goto L_0x004e
        L_0x0045:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
        L_0x004c:
            r7 = 1
            goto L_0x006e
        L_0x004e:
            byte r5 = r0[r3]
            byte r4 = r0[r4]
            r6 = r4 & 192(0xc0, float:2.69E-43)
            if (r6 != r9) goto L_0x0057
            r8 = 1
        L_0x0057:
            if (r8 != 0) goto L_0x005a
            goto L_0x0045
        L_0x005a:
            r4 = r4 ^ 3968(0xf80, float:5.56E-42)
            int r5 = r5 << 6
            r4 = r4 ^ r5
            if (r4 >= r9) goto L_0x0066
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            goto L_0x006a
        L_0x0066:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x006a:
            r2.invoke(r4)
        L_0x006d:
            r7 = 2
        L_0x006e:
            int r3 = r3 + r7
            goto L_0x0013
        L_0x0070:
            int r5 = r4 >> 4
            r12 = 55296(0xd800, float:7.7486E-41)
            r13 = 57343(0xdfff, float:8.0355E-41)
            r14 = 3
            if (r5 != r6) goto L_0x00df
            int r4 = r3 + 2
            if (r1 > r4) goto L_0x0094
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004c
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r9) goto L_0x0091
            r8 = 1
        L_0x0091:
            if (r8 != 0) goto L_0x006d
            goto L_0x004c
        L_0x0094:
            byte r5 = r0[r3]
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x00a0
            r15 = 1
            goto L_0x00a1
        L_0x00a0:
            r15 = 0
        L_0x00a1:
            if (r15 != 0) goto L_0x00ab
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x004c
        L_0x00ab:
            byte r4 = r0[r4]
            r15 = r4 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x00b2
            r8 = 1
        L_0x00b2:
            if (r8 != 0) goto L_0x00bc
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x006d
        L_0x00bc:
            r7 = -123008(0xfffffffffffe1f80, float:NaN)
            r4 = r4 ^ r7
            int r6 = r6 << 6
            r4 = r4 ^ r6
            int r5 = r5 << 12
            r4 = r4 ^ r5
            r5 = 2048(0x800, float:2.87E-42)
            if (r4 >= r5) goto L_0x00d2
        L_0x00ca:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
        L_0x00ce:
            r2.invoke(r4)
            goto L_0x00dd
        L_0x00d2:
            if (r12 <= r4) goto L_0x00d5
            goto L_0x00d8
        L_0x00d5:
            if (r13 < r4) goto L_0x00d8
            goto L_0x00ca
        L_0x00d8:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00ce
        L_0x00dd:
            r7 = 3
            goto L_0x006e
        L_0x00df:
            int r4 = r4 >> 3
            if (r4 != r6) goto L_0x017a
            int r4 = r3 + 3
            if (r1 > r4) goto L_0x010e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004c
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r9) goto L_0x00fa
            r4 = 1
            goto L_0x00fb
        L_0x00fa:
            r4 = 0
        L_0x00fb:
            if (r4 != 0) goto L_0x00ff
            goto L_0x004c
        L_0x00ff:
            int r4 = r3 + 2
            if (r1 <= r4) goto L_0x006d
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r9) goto L_0x010a
            r8 = 1
        L_0x010a:
            if (r8 != 0) goto L_0x00dd
            goto L_0x006d
        L_0x010e:
            byte r5 = r0[r3]
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x011a
            r15 = 1
            goto L_0x011b
        L_0x011a:
            r15 = 0
        L_0x011b:
            if (r15 != 0) goto L_0x0126
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x004c
        L_0x0126:
            int r15 = r3 + 2
            byte r15 = r0[r15]
            r7 = r15 & 192(0xc0, float:2.69E-43)
            if (r7 != r9) goto L_0x0130
            r7 = 1
            goto L_0x0131
        L_0x0130:
            r7 = 0
        L_0x0131:
            if (r7 != 0) goto L_0x013c
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x006d
        L_0x013c:
            byte r4 = r0[r4]
            r7 = r4 & 192(0xc0, float:2.69E-43)
            if (r7 != r9) goto L_0x0143
            r8 = 1
        L_0x0143:
            if (r8 != 0) goto L_0x014d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            goto L_0x00dd
        L_0x014d:
            r7 = 3678080(0x381f80, float:5.154088E-39)
            r4 = r4 ^ r7
            int r7 = r15 << 6
            r4 = r4 ^ r7
            int r6 = r6 << 12
            r4 = r4 ^ r6
            int r5 = r5 << 18
            r4 = r4 ^ r5
            r5 = 1114111(0x10ffff, float:1.561202E-39)
            if (r4 <= r5) goto L_0x0167
        L_0x015f:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
        L_0x0163:
            r2.invoke(r4)
            goto L_0x0177
        L_0x0167:
            if (r12 <= r4) goto L_0x016a
            goto L_0x016d
        L_0x016a:
            if (r13 < r4) goto L_0x016d
            goto L_0x015f
        L_0x016d:
            r5 = 65536(0x10000, float:9.1835E-41)
            if (r4 >= r5) goto L_0x0172
            goto L_0x015f
        L_0x0172:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0163
        L_0x0177:
            r7 = 4
            goto L_0x006e
        L_0x017a:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            int r3 = r3 + 1
            goto L_0x0013
        L_0x0185:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final long size(String str) {
        return size$default(str, 0, 0, 3, null);
    }

    public static final long size(String str, int i) {
        return size$default(str, i, 0, 2, null);
    }

    public static final long size(String str, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(str, "$this$utf8Size");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 > str.length()) {
                    z = false;
                }
                if (z) {
                    long j = 0;
                    while (i < i2) {
                        char charAt = str.charAt(i);
                        if (charAt < 128) {
                            j++;
                        } else {
                            if (charAt < 2048) {
                                i3 = 2;
                            } else if (charAt < 55296 || charAt > 57343) {
                                i3 = 3;
                            } else {
                                int i4 = i + 1;
                                char charAt2 = i4 < i2 ? str.charAt(i4) : 0;
                                if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                                    j++;
                                    i = i4;
                                } else {
                                    j += (long) 4;
                                    i += 2;
                                }
                            }
                            j += (long) i3;
                        }
                        i++;
                    }
                    return j;
                }
                StringBuilder outline74 = GeneratedOutlineSupport.outline74("endIndex > string.length: ", i2, " > ");
                outline74.append(str.length());
                throw new IllegalArgumentException(outline74.toString().toString());
            }
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline43("endIndex < beginIndex: ", i2, " < ", i).toString());
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("beginIndex < 0: ", i).toString());
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }
}
