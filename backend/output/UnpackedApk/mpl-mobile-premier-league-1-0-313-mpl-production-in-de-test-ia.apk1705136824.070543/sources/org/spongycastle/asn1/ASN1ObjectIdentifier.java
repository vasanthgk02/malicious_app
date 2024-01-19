package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

public class ASN1ObjectIdentifier extends ASN1Primitive {
    public static final Map pool = new HashMap();
    public byte[] body;
    public final String identifier;

    public static class OidHandle {
        public final byte[] enc;
        public int key;

        public OidHandle(byte[] bArr) {
            this.key = TypeUtilsKt.hashCode(bArr);
            this.enc = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof OidHandle) {
                return TypeUtilsKt.areEqual(this.enc, ((OidHandle) obj).enc);
            }
            return false;
        }

        public int hashCode() {
            return this.key;
        }
    }

    public ASN1ObjectIdentifier(byte[] bArr) {
        byte[] bArr2 = bArr;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        long j = 0;
        BigInteger bigInteger = null;
        for (int i = 0; i != bArr2.length; i++) {
            byte b2 = bArr2[i] & 255;
            if (j <= 72057594037927808L) {
                long j2 = j + ((long) (b2 & Byte.MAX_VALUE));
                if ((b2 & 128) == 0) {
                    if (z) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j2 -= 80;
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                    j = 0;
                } else {
                    j = j2 << 7;
                }
            } else {
                BigInteger or = (bigInteger == null ? BigInteger.valueOf(j) : bigInteger).or(BigInteger.valueOf((long) (b2 & Byte.MAX_VALUE)));
                if ((b2 & 128) == 0) {
                    if (z) {
                        stringBuffer.append('2');
                        or = or.subtract(BigInteger.valueOf(80));
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(or);
                    j = 0;
                    bigInteger = null;
                } else {
                    bigInteger = or.shiftLeft(7);
                }
            }
        }
        this.identifier = stringBuffer.toString();
        this.body = TypeUtilsKt.clone(bArr);
    }

    public static ASN1ObjectIdentifier fromOctetString(byte[] bArr) {
        OidHandle oidHandle = new OidHandle(bArr);
        synchronized (pool) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) pool.get(oidHandle);
            if (aSN1ObjectIdentifier != null) {
                return aSN1ObjectIdentifier;
            }
            return new ASN1ObjectIdentifier(bArr);
        }
    }

    public static ASN1ObjectIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1ObjectIdentifier)) {
            return (ASN1ObjectIdentifier) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable) obj;
            if (aSN1Encodable.toASN1Primitive() instanceof ASN1ObjectIdentifier) {
                return (ASN1ObjectIdentifier) aSN1Encodable.toASN1Primitive();
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1ObjectIdentifier) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (IOException e2) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("failed to construct object identifier from byte[]: ");
                outline73.append(e2.getMessage());
                throw new IllegalArgumentException(outline73.toString());
            }
        } else {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("illegal object in getInstance: ");
            outline732.append(obj.getClass().getName());
            throw new IllegalArgumentException(outline732.toString());
        }
    }

    public static boolean isValidBranchID(String str, int i) {
        boolean z;
        char charAt;
        int length = str.length();
        do {
            z = false;
            while (true) {
                length--;
                if (length < i) {
                    return z;
                }
                charAt = str.charAt(length);
                if ('0' <= charAt && charAt <= '9') {
                    z = true;
                }
            }
            if (charAt != '.') {
                break;
            }
        } while (z);
        return false;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive == this) {
            return true;
        }
        if (!(aSN1Primitive instanceof ASN1ObjectIdentifier)) {
            return false;
        }
        return this.identifier.equals(((ASN1ObjectIdentifier) aSN1Primitive).identifier);
    }

    public final void doOutput(ByteArrayOutputStream byteArrayOutputStream) {
        int i;
        String str;
        int i2;
        String str2;
        String str3;
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        String str4 = this.identifier;
        int indexOf = str4.indexOf(46, 0);
        if (indexOf == -1) {
            str = str4.substring(0);
            i = -1;
        } else {
            i = indexOf + 1;
            str = str4.substring(0, indexOf);
        }
        int parseInt = Integer.parseInt(str) * 40;
        if (i == -1) {
            i2 = i;
            str2 = null;
        } else {
            int indexOf2 = str4.indexOf(46, i);
            if (indexOf2 == -1) {
                str2 = str4.substring(i);
                i2 = -1;
            } else {
                str2 = str4.substring(i, indexOf2);
                i2 = indexOf2 + 1;
            }
        }
        if (str2.length() <= 18) {
            writeField(byteArrayOutputStream2, ((long) parseInt) + Long.parseLong(str2));
        } else {
            writeField(byteArrayOutputStream2, new BigInteger(str2).add(BigInteger.valueOf((long) parseInt)));
        }
        while (true) {
            if (i2 != -1) {
                if (i2 == -1) {
                    str3 = null;
                } else {
                    int indexOf3 = str4.indexOf(46, i2);
                    if (indexOf3 == -1) {
                        str3 = str4.substring(i2);
                        i2 = -1;
                    } else {
                        String substring = str4.substring(i2, indexOf3);
                        i2 = indexOf3 + 1;
                        str3 = substring;
                    }
                }
                if (str3.length() <= 18) {
                    writeField(byteArrayOutputStream2, Long.parseLong(str3));
                } else {
                    writeField(byteArrayOutputStream2, new BigInteger(str3));
                }
            } else {
                return;
            }
        }
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] body2 = getBody();
        aSN1OutputStream.write(6);
        aSN1OutputStream.writeLength(body2.length);
        aSN1OutputStream.os.write(body2);
    }

    public int encodedLength() throws IOException {
        int length = getBody().length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public final synchronized byte[] getBody() {
        if (this.body == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            doOutput(byteArrayOutputStream);
            this.body = byteArrayOutputStream.toByteArray();
        }
        return this.body;
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }

    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return this.identifier;
    }

    public final void writeField(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    public final void writeField(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i = bitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & Byte.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, bitLength);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r1 = isValidBranchID(r4, 2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ASN1ObjectIdentifier(java.lang.String r4) {
        /*
            r3 = this;
            r3.<init>()
            int r0 = r4.length()
            r1 = 0
            r2 = 3
            if (r0 < r2) goto L_0x0027
            r0 = 1
            char r0 = r4.charAt(r0)
            r2 = 46
            if (r0 == r2) goto L_0x0015
            goto L_0x0027
        L_0x0015:
            char r0 = r4.charAt(r1)
            r2 = 48
            if (r0 < r2) goto L_0x0027
            r2 = 50
            if (r0 <= r2) goto L_0x0022
            goto L_0x0027
        L_0x0022:
            r0 = 2
            boolean r1 = isValidBranchID(r4, r0)
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r3.identifier = r4
            return
        L_0x002c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "string "
            java.lang.String r2 = " not an OID"
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r1, r4, r2)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.ASN1ObjectIdentifier.<init>(java.lang.String):void");
    }

    public ASN1ObjectIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (isValidBranchID(str, 0)) {
            this.identifier = GeneratedOutlineSupport.outline63(new StringBuilder(), aSN1ObjectIdentifier.identifier, ".", str);
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("string ", str, " not a valid OID branch"));
    }
}
