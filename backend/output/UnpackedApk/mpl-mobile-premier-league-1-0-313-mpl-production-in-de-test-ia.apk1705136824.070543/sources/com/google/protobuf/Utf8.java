package com.google.protobuf;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;

public final class Utf8 {
    public static final Processor processor = ((!(UnsafeUtil.HAS_UNSAFE_ARRAY_OPERATIONS && UnsafeUtil.HAS_UNSAFE_BYTEBUFFER_OPERATIONS) || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor());

    public static abstract class Processor {
        public abstract String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

        public abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2);

        public abstract int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3);
    }

    public static final class SafeProcessor extends Processor {
        public String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (r13 < i3) {
                    byte b2 = bArr[r13];
                    if (!TextAppearanceConfig.access$4001(b2)) {
                        break;
                    }
                    i = r13 + 1;
                    cArr[i4] = (char) b2;
                    i4++;
                }
                int i5 = i4;
                while (r13 < i3) {
                    int i6 = r13 + 1;
                    byte b3 = bArr[r13];
                    if (TextAppearanceConfig.access$4001(b3)) {
                        int i7 = i5 + 1;
                        cArr[i5] = (char) b3;
                        r13 = i6;
                        while (true) {
                            i5 = i7;
                            if (r13 >= i3) {
                                break;
                            }
                            byte b4 = bArr[r13];
                            if (!TextAppearanceConfig.access$4001(b4)) {
                                break;
                            }
                            r13++;
                            i7 = i5 + 1;
                            cArr[i5] = (char) b4;
                        }
                    } else {
                        if (!(b3 < -32)) {
                            if (b3 < -16) {
                                if (i6 < i3 - 1) {
                                    int i8 = i6 + 1;
                                    TextAppearanceConfig.access$9001(b3, bArr[i6], bArr[i8], cArr, i5);
                                    r13 = i8 + 1;
                                    i5++;
                                } else {
                                    throw InvalidProtocolBufferException.invalidUtf8();
                                }
                            } else if (i6 < i3 - 2) {
                                int i9 = i6 + 1;
                                byte b5 = bArr[i6];
                                int i10 = i9 + 1;
                                TextAppearanceConfig.access$10001(b3, b5, bArr[i9], bArr[i10], cArr, i5);
                                i5 = i5 + 1 + 1;
                                r13 = i10 + 1;
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        } else if (i6 < i3) {
                            TextAppearanceConfig.access$7001(b3, bArr[i6], cArr, i5);
                            r13 = i6 + 1;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }

        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int length = charSequence.length();
            int i4 = i2 + i;
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5 + i;
                if (i6 >= i4) {
                    break;
                }
                char charAt = charSequence.charAt(i5);
                if (charAt >= 128) {
                    break;
                }
                bArr[i6] = (byte) charAt;
                i5++;
            }
            if (i5 == length) {
                return i + length;
            }
            int i7 = i + i5;
            while (i5 < length) {
                char charAt2 = charSequence.charAt(i5);
                if (charAt2 < 128 && i7 < i4) {
                    i3 = i7 + 1;
                    bArr[i7] = (byte) charAt2;
                } else if (charAt2 < 2048 && i7 <= i4 - 2) {
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) ((charAt2 >>> 6) | 960);
                    i7 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 & '?') | 128);
                    i5++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i7 <= i4 - 3) {
                    int i9 = i7 + 1;
                    bArr[i7] = (byte) ((charAt2 >>> Tokenizer.FF) | 480);
                    int i10 = i9 + 1;
                    bArr[i9] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i3 = i10 + 1;
                    bArr[i10] = (byte) ((charAt2 & '?') | 128);
                } else if (i7 <= i4 - 4) {
                    int i11 = i5 + 1;
                    if (i11 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i11);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i12 = i7 + 1;
                            bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                            int i13 = i12 + 1;
                            bArr[i12] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i14 = i13 + 1;
                            bArr[i13] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i7 = i14 + 1;
                            bArr[i14] = (byte) ((codePoint & 63) | 128);
                            i5 = i11;
                            i5++;
                        } else {
                            i5 = i11;
                        }
                    }
                    throw new UnpairedSurrogateException(i5 - 1, length);
                } else {
                    if (55296 <= charAt2 && charAt2 <= 57343) {
                        int i15 = i5 + 1;
                        if (i15 == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i15))) {
                            throw new UnpairedSurrogateException(i5, length);
                        }
                    }
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i7);
                }
                i7 = i3;
                i5++;
            }
            return i7;
        }

        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v2 */
        /* JADX WARNING: type inference failed for: r3v5 */
        /* JADX WARNING: type inference failed for: r12v12 */
        /* JADX WARNING: type inference failed for: r12v13 */
        /* JADX WARNING: type inference failed for: r10v0 */
        /* JADX WARNING: type inference failed for: r12v16 */
        /* JADX WARNING: type inference failed for: r12v21 */
        /* JADX WARNING: type inference failed for: r12v25, types: [byte] */
        /* JADX WARNING: type inference failed for: r12v26 */
        /* JADX WARNING: type inference failed for: r10v1 */
        /* JADX WARNING: type inference failed for: r12v29 */
        /* JADX WARNING: type inference failed for: r3v6 */
        /* JADX WARNING: type inference failed for: r3v7 */
        /* JADX WARNING: type inference failed for: r3v8 */
        /* JADX WARNING: type inference failed for: r12v33 */
        /* JADX WARNING: type inference failed for: r12v34 */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
            if (r13[r14] > -65) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0082, code lost:
            if (r13[r14] > -65) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            if (r13[r14] > -65) goto L_0x0022;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 4 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int partialIsValidUtf8(int r12, byte[] r13, int r14, int r15) {
            /*
                r11 = this;
                r0 = -19
                r1 = -62
                r2 = -16
                r3 = 0
                r4 = -96
                r5 = -32
                r6 = -1
                r7 = -65
                if (r12 == 0) goto L_0x0085
                if (r14 < r15) goto L_0x0013
                return r12
            L_0x0013:
                byte r8 = (byte) r12
                if (r8 >= r5) goto L_0x0023
                if (r8 < r1) goto L_0x0022
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r14 <= r7) goto L_0x001f
                goto L_0x0022
            L_0x001f:
                r14 = r12
                goto L_0x0085
            L_0x0022:
                return r6
            L_0x0023:
                if (r8 >= r2) goto L_0x004a
                int r12 = r12 >> 8
                int r12 = ~r12
                byte r12 = (byte) r12
                if (r12 != 0) goto L_0x0039
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r12 < r15) goto L_0x0036
                int r12 = com.google.protobuf.Utf8.access$000(r8, r14)
                return r12
            L_0x0036:
                r10 = r14
                r14 = r12
                r12 = r10
            L_0x0039:
                if (r12 > r7) goto L_0x0049
                if (r8 != r5) goto L_0x003f
                if (r12 < r4) goto L_0x0049
            L_0x003f:
                if (r8 != r0) goto L_0x0043
                if (r12 >= r4) goto L_0x0049
            L_0x0043:
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r14 <= r7) goto L_0x001f
            L_0x0049:
                return r6
            L_0x004a:
                int r9 = r12 >> 8
                int r9 = ~r9
                byte r9 = (byte) r9
                if (r9 != 0) goto L_0x005e
                int r12 = r14 + 1
                byte r9 = r13[r14]
                if (r12 < r15) goto L_0x005b
                int r12 = com.google.protobuf.Utf8.access$000(r8, r9)
                return r12
            L_0x005b:
                r14 = r12
                r12 = 0
                goto L_0x0061
            L_0x005e:
                int r12 = r12 >> 16
                byte r12 = (byte) r12
            L_0x0061:
                if (r12 != 0) goto L_0x0071
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r12 < r15) goto L_0x006e
                int r12 = com.google.protobuf.Utf8.incompleteStateFor(r8, r9, r14)
                return r12
            L_0x006e:
                r10 = r14
                r14 = r12
                r12 = r10
            L_0x0071:
                if (r9 > r7) goto L_0x0084
                int r8 = r8 << 28
                int r9 = r9 + 112
                int r9 = r9 + r8
                int r8 = r9 >> 30
                if (r8 != 0) goto L_0x0084
                if (r12 > r7) goto L_0x0084
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r14 <= r7) goto L_0x001f
            L_0x0084:
                return r6
            L_0x0085:
                if (r14 >= r15) goto L_0x008e
                byte r12 = r13[r14]
                if (r12 < 0) goto L_0x008e
                int r14 = r14 + 1
                goto L_0x0085
            L_0x008e:
                if (r14 < r15) goto L_0x0092
                goto L_0x00ef
            L_0x0092:
                if (r14 < r15) goto L_0x0095
                goto L_0x00ef
            L_0x0095:
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r14 >= 0) goto L_0x00f0
                if (r14 >= r5) goto L_0x00aa
                if (r12 < r15) goto L_0x00a1
                r3 = r14
                goto L_0x00ef
            L_0x00a1:
                if (r14 < r1) goto L_0x00ee
                int r14 = r12 + 1
                byte r12 = r13[r12]
                if (r12 <= r7) goto L_0x0092
                goto L_0x00ee
            L_0x00aa:
                if (r14 >= r2) goto L_0x00ca
                int r8 = r15 + -1
                if (r12 < r8) goto L_0x00b5
                int r3 = com.google.protobuf.Utf8.access$1100(r13, r12, r15)
                goto L_0x00ef
            L_0x00b5:
                int r8 = r12 + 1
                byte r12 = r13[r12]
                if (r12 > r7) goto L_0x00ee
                if (r14 != r5) goto L_0x00bf
                if (r12 < r4) goto L_0x00ee
            L_0x00bf:
                if (r14 != r0) goto L_0x00c3
                if (r12 >= r4) goto L_0x00ee
            L_0x00c3:
                int r14 = r8 + 1
                byte r12 = r13[r8]
                if (r12 <= r7) goto L_0x0092
                goto L_0x00ee
            L_0x00ca:
                int r8 = r15 + -2
                if (r12 < r8) goto L_0x00d3
                int r3 = com.google.protobuf.Utf8.access$1100(r13, r12, r15)
                goto L_0x00ef
            L_0x00d3:
                int r8 = r12 + 1
                byte r12 = r13[r12]
                if (r12 > r7) goto L_0x00ee
                int r14 = r14 << 28
                int r12 = r12 + 112
                int r12 = r12 + r14
                int r12 = r12 >> 30
                if (r12 != 0) goto L_0x00ee
                int r12 = r8 + 1
                byte r14 = r13[r8]
                if (r14 > r7) goto L_0x00ee
                int r14 = r12 + 1
                byte r12 = r13[r12]
                if (r12 <= r7) goto L_0x0092
            L_0x00ee:
                r3 = -1
            L_0x00ef:
                return r3
            L_0x00f0:
                r14 = r12
                goto L_0x0092
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.SafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }
    }

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i, int i2) {
            super(GeneratedOutlineSupport.outline43("Unpaired surrogate at index ", i, " of ", i2));
        }
    }

    public static final class UnsafeProcessor extends Processor {
        public static int unsafeIncompleteStateFor(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                return Utf8.access$1200(i);
            }
            if (i2 == 1) {
                return Utf8.access$000(i, UnsafeUtil.getByte(bArr, j));
            }
            if (i2 == 2) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j), UnsafeUtil.getByte(bArr, j + 1));
            }
            throw new AssertionError();
        }

        public String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (r13 < i3) {
                    byte b2 = UnsafeUtil.getByte(bArr, (long) r13);
                    if (!TextAppearanceConfig.access$4001(b2)) {
                        break;
                    }
                    i = r13 + 1;
                    cArr[i4] = (char) b2;
                    i4++;
                }
                int i5 = i4;
                while (r13 < i3) {
                    int i6 = r13 + 1;
                    byte b3 = UnsafeUtil.getByte(bArr, (long) r13);
                    if (TextAppearanceConfig.access$4001(b3)) {
                        int i7 = i5 + 1;
                        cArr[i5] = (char) b3;
                        r13 = i6;
                        while (true) {
                            i5 = i7;
                            if (r13 >= i3) {
                                break;
                            }
                            byte b4 = UnsafeUtil.getByte(bArr, (long) r13);
                            if (!TextAppearanceConfig.access$4001(b4)) {
                                break;
                            }
                            r13++;
                            i7 = i5 + 1;
                            cArr[i5] = (char) b4;
                        }
                    } else {
                        if (!(b3 < -32)) {
                            if (b3 < -16) {
                                if (i6 < i3 - 1) {
                                    int i8 = i6 + 1;
                                    TextAppearanceConfig.access$9001(b3, UnsafeUtil.getByte(bArr, (long) i6), UnsafeUtil.getByte(bArr, (long) i8), cArr, i5);
                                    r13 = i8 + 1;
                                    i5++;
                                } else {
                                    throw InvalidProtocolBufferException.invalidUtf8();
                                }
                            } else if (i6 < i3 - 2) {
                                int i9 = i6 + 1;
                                byte b5 = UnsafeUtil.getByte(bArr, (long) i6);
                                int i10 = i9 + 1;
                                TextAppearanceConfig.access$10001(b3, b5, UnsafeUtil.getByte(bArr, (long) i9), UnsafeUtil.getByte(bArr, (long) i10), cArr, i5);
                                i5 = i5 + 1 + 1;
                                r13 = i10 + 1;
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        } else if (i6 < i3) {
                            TextAppearanceConfig.access$7001(b3, UnsafeUtil.getByte(bArr, (long) i6), cArr, i5);
                            r13 = i6 + 1;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }

        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2) {
            long j;
            char c2;
            long j2;
            long j3;
            CharSequence charSequence2 = charSequence;
            byte[] bArr2 = bArr;
            int i3 = i;
            int i4 = i2;
            long j4 = (long) i3;
            long j5 = ((long) i4) + j4;
            int length = charSequence.length();
            if (length > i4 || bArr2.length - i4 < i3) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed writing ");
                outline73.append(charSequence2.charAt(length - 1));
                outline73.append(" at index ");
                outline73.append(i3 + i4);
                throw new ArrayIndexOutOfBoundsException(outline73.toString());
            }
            int i5 = 0;
            while (true) {
                c2 = 128;
                j2 = 1;
                if (i5 >= length) {
                    break;
                }
                char charAt = charSequence2.charAt(i5);
                if (charAt >= 128) {
                    break;
                }
                UnsafeUtil.putByte(bArr2, j, (byte) charAt);
                i5++;
                j4 = 1 + j;
            }
            if (i5 == length) {
                return (int) j;
            }
            while (i5 < length) {
                char charAt2 = charSequence2.charAt(i5);
                if (charAt2 < c2 && j < j5) {
                    j3 = j + j2;
                    UnsafeUtil.putByte(bArr2, j, (byte) charAt2);
                } else if (charAt2 < 2048 && j <= j5 - 2) {
                    long j6 = j + j2;
                    UnsafeUtil.putByte(bArr2, j, (byte) ((charAt2 >>> 6) | 960));
                    UnsafeUtil.putByte(bArr2, j6, (byte) ((charAt2 & '?') | 128));
                    j = j6 + j2;
                    i5++;
                    c2 = 128;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && j <= j5 - 3) {
                    long j7 = j + j2;
                    UnsafeUtil.putByte(bArr2, j, (byte) ((charAt2 >>> Tokenizer.FF) | 480));
                    long j8 = j2 + j7;
                    UnsafeUtil.putByte(bArr2, j7, (byte) (((charAt2 >>> 6) & 63) | 128));
                    j3 = j8 + 1;
                    UnsafeUtil.putByte(bArr2, j8, (byte) ((charAt2 & '?') | 128));
                    j2 = 1;
                } else if (j <= j5 - 4) {
                    int i6 = i5 + 1;
                    if (i6 != length) {
                        char charAt3 = charSequence2.charAt(i6);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            long j9 = j + 1;
                            UnsafeUtil.putByte(bArr2, j, (byte) ((codePoint >>> 18) | 240));
                            long j10 = 1 + j9;
                            UnsafeUtil.putByte(bArr2, j9, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j11 = 1 + j10;
                            UnsafeUtil.putByte(bArr2, j10, (byte) (((codePoint >>> 6) & 63) | 128));
                            j2 = 1;
                            UnsafeUtil.putByte(bArr2, j11, (byte) ((codePoint & 63) | 128));
                            i5 = i6;
                            j = j11 + 1;
                            i5++;
                            c2 = 128;
                        } else {
                            i5 = i6;
                        }
                    }
                    throw new UnpairedSurrogateException(i5 - 1, length);
                } else {
                    if (55296 <= charAt2 && charAt2 <= 57343) {
                        int i7 = i5 + 1;
                        if (i7 == length || !Character.isSurrogatePair(charAt2, charSequence2.charAt(i7))) {
                            throw new UnpairedSurrogateException(i5, length);
                        }
                    }
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j);
                }
                j = j3;
                i5++;
                c2 = 128;
            }
            return (int) j;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r1, r8) > -65) goto L_0x003d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r1, r8) > -65) goto L_0x0069;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int partialIsValidUtf8(int r24, byte[] r25, int r26, int r27) {
            /*
                r23 = this;
                r0 = r24
                r1 = r25
                r2 = r26
                r3 = r27
                r4 = r2 | r3
                int r5 = r1.length
                int r5 = r5 - r3
                r4 = r4 | r5
                r5 = 2
                if (r4 < 0) goto L_0x0152
                long r8 = (long) r2
                long r2 = (long) r3
                r4 = -19
                r10 = -62
                r11 = -16
                r12 = 16
                r13 = -96
                r14 = -32
                r15 = -65
                r16 = -1
                r17 = 1
                if (r0 == 0) goto L_0x00b1
                int r19 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r19 < 0) goto L_0x002b
                return r0
            L_0x002b:
                byte r7 = (byte) r0
                if (r7 >= r14) goto L_0x003e
                if (r7 < r10) goto L_0x003d
                long r20 = r8 + r17
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r1, r8)
                if (r0 <= r15) goto L_0x0039
                goto L_0x003d
            L_0x0039:
                r8 = r20
                goto L_0x00b1
            L_0x003d:
                return r16
            L_0x003e:
                if (r7 >= r11) goto L_0x006a
                int r0 = r0 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L_0x0057
                long r20 = r8 + r17
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r1, r8)
                int r8 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
                if (r8 < 0) goto L_0x0055
                int r0 = com.google.protobuf.Utf8.access$000(r7, r0)
                return r0
            L_0x0055:
                r8 = r20
            L_0x0057:
                if (r0 > r15) goto L_0x0069
                if (r7 != r14) goto L_0x005d
                if (r0 < r13) goto L_0x0069
            L_0x005d:
                if (r7 != r4) goto L_0x0061
                if (r0 >= r13) goto L_0x0069
            L_0x0061:
                long r20 = r8 + r17
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r1, r8)
                if (r0 <= r15) goto L_0x0039
            L_0x0069:
                return r16
            L_0x006a:
                int r6 = r0 >> 8
                int r6 = ~r6
                byte r6 = (byte) r6
                if (r6 != 0) goto L_0x0083
                long r21 = r8 + r17
                byte r6 = com.google.protobuf.UnsafeUtil.getByte(r1, r8)
                int r0 = (r21 > r2 ? 1 : (r21 == r2 ? 0 : -1))
                if (r0 < 0) goto L_0x007f
                int r0 = com.google.protobuf.Utf8.access$000(r7, r6)
                return r0
            L_0x007f:
                r8 = r21
                r0 = 0
                goto L_0x0085
            L_0x0083:
                int r0 = r0 >> r12
                byte r0 = (byte) r0
            L_0x0085:
                if (r0 != 0) goto L_0x0098
                long r21 = r8 + r17
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r1, r8)
                int r8 = (r21 > r2 ? 1 : (r21 == r2 ? 0 : -1))
                if (r8 < 0) goto L_0x0096
                int r0 = com.google.protobuf.Utf8.incompleteStateFor(r7, r6, r0)
                return r0
            L_0x0096:
                r8 = r21
            L_0x0098:
                if (r6 > r15) goto L_0x00b0
                int r7 = r7 << 28
                int r6 = r6 + 112
                int r6 = r6 + r7
                int r6 = r6 >> 30
                if (r6 != 0) goto L_0x00b0
                if (r0 > r15) goto L_0x00b0
                long r6 = r8 + r17
                byte r0 = com.google.protobuf.UnsafeUtil.getByte(r1, r8)
                if (r0 <= r15) goto L_0x00ae
                goto L_0x00b0
            L_0x00ae:
                r8 = r6
                goto L_0x00b1
            L_0x00b0:
                return r16
            L_0x00b1:
                long r2 = r2 - r8
                int r0 = (int) r2
                if (r0 >= r12) goto L_0x00b7
                r2 = 0
                goto L_0x00ca
            L_0x00b7:
                r6 = r8
                r2 = 0
            L_0x00b9:
                if (r2 >= r0) goto L_0x00c9
                long r21 = r6 + r17
                byte r3 = com.google.protobuf.UnsafeUtil.getByte(r1, r6)
                if (r3 >= 0) goto L_0x00c4
                goto L_0x00ca
            L_0x00c4:
                int r2 = r2 + 1
                r6 = r21
                goto L_0x00b9
            L_0x00c9:
                r2 = r0
            L_0x00ca:
                int r0 = r0 - r2
                long r2 = (long) r2
                long r8 = r8 + r2
            L_0x00cd:
                r2 = 0
            L_0x00ce:
                if (r0 <= 0) goto L_0x00df
                long r2 = r8 + r17
                byte r6 = com.google.protobuf.UnsafeUtil.getByte(r1, r8)
                if (r6 < 0) goto L_0x00dd
                int r0 = r0 + -1
                r8 = r2
                r2 = r6
                goto L_0x00ce
            L_0x00dd:
                r8 = r2
                r2 = r6
            L_0x00df:
                if (r0 != 0) goto L_0x00e4
                r7 = 0
                goto L_0x0151
            L_0x00e4:
                int r0 = r0 + -1
                if (r2 >= r14) goto L_0x00fe
                if (r0 != 0) goto L_0x00ed
                r7 = r2
                goto L_0x0151
            L_0x00ed:
                int r0 = r0 + -1
                if (r2 < r10) goto L_0x00fc
                long r2 = r8 + r17
                byte r6 = com.google.protobuf.UnsafeUtil.getByte(r1, r8)
                if (r6 <= r15) goto L_0x00fa
                goto L_0x00fc
            L_0x00fa:
                r8 = r2
                goto L_0x00cd
            L_0x00fc:
                r7 = -1
                goto L_0x0151
            L_0x00fe:
                if (r2 >= r11) goto L_0x0122
                if (r0 >= r5) goto L_0x0107
                int r7 = unsafeIncompleteStateFor(r1, r2, r8, r0)
                goto L_0x0151
            L_0x0107:
                int r0 = r0 + -2
                long r6 = r8 + r17
                byte r3 = com.google.protobuf.UnsafeUtil.getByte(r1, r8)
                if (r3 > r15) goto L_0x00fc
                if (r2 != r14) goto L_0x0115
                if (r3 < r13) goto L_0x00fc
            L_0x0115:
                if (r2 != r4) goto L_0x0119
                if (r3 >= r13) goto L_0x00fc
            L_0x0119:
                long r8 = r6 + r17
                byte r2 = com.google.protobuf.UnsafeUtil.getByte(r1, r6)
                if (r2 <= r15) goto L_0x00cd
                goto L_0x00fc
            L_0x0122:
                r3 = 3
                if (r0 >= r3) goto L_0x012a
                int r7 = unsafeIncompleteStateFor(r1, r2, r8, r0)
                goto L_0x0151
            L_0x012a:
                int r0 = r0 + -3
                long r6 = r8 + r17
                byte r3 = com.google.protobuf.UnsafeUtil.getByte(r1, r8)
                if (r3 > r15) goto L_0x00fc
                int r2 = r2 << 28
                int r3 = r3 + 112
                int r3 = r3 + r2
                int r2 = r3 >> 30
                if (r2 != 0) goto L_0x00fc
                long r2 = r6 + r17
                byte r6 = com.google.protobuf.UnsafeUtil.getByte(r1, r6)
                if (r6 > r15) goto L_0x00fc
                long r6 = r2 + r17
                byte r2 = com.google.protobuf.UnsafeUtil.getByte(r1, r2)
                if (r2 <= r15) goto L_0x014e
                goto L_0x00fc
            L_0x014e:
                r8 = r6
                goto L_0x00cd
            L_0x0151:
                return r7
            L_0x0152:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                r4 = 3
                java.lang.Object[] r4 = new java.lang.Object[r4]
                int r1 = r1.length
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r6 = 0
                r4[r6] = r1
                java.lang.Integer r1 = java.lang.Integer.valueOf(r26)
                r2 = 1
                r4[r2] = r1
                java.lang.Integer r1 = java.lang.Integer.valueOf(r27)
                r4[r5] = r1
                java.lang.String r1 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r1 = java.lang.String.format(r1, r4)
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.Utf8.UnsafeProcessor.partialIsValidUtf8(int, byte[], int, int):int");
        }
    }

    public static int access$000(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int access$1100(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        byte b3 = -1;
        if (i3 == 0) {
            if (b2 > -12) {
                b2 = -1;
            }
            return b2;
        } else if (i3 == 1) {
            byte b4 = bArr[i];
            if (b2 <= -12 && b4 <= -65) {
                b3 = b2 ^ (b4 << 8);
            }
            return b3;
        } else if (i3 == 2) {
            return incompleteStateFor(b2, bArr[i], bArr[i + 1]);
        } else {
            throw new AssertionError();
        }
    }

    public static int access$1200(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bArr, i, i2);
    }

    public static int encode(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return processor.encodeUtf8(charSequence, bArr, i, i2);
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new UnpairedSurrogateException(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UTF-8 length does not fit in int: ");
        outline73.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(outline73.toString());
    }

    public static int incompleteStateFor(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i2) {
        if (processor.partialIsValidUtf8(0, bArr, i, i2) == 0) {
            return true;
        }
        return false;
    }
}
