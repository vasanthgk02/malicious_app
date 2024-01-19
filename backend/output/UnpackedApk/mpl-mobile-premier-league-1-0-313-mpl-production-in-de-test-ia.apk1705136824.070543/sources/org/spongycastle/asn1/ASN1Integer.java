package org.spongycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

public class ASN1Integer extends ASN1Primitive {
    public final byte[] bytes;

    public ASN1Integer(long j) {
        this.bytes = BigInteger.valueOf(j).toByteArray();
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Integer)) {
            return false;
        }
        return TypeUtilsKt.areEqual(this.bytes, ((ASN1Integer) aSN1Primitive).bytes);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(2, this.bytes);
    }

    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.bytes.length) + 1 + this.bytes.length;
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.bytes;
            if (i == bArr.length) {
                return i2;
            }
            i2 ^= (bArr[i] & 255) << (i % 4);
            i++;
        }
    }

    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return new BigInteger(this.bytes).toString();
    }

    public ASN1Integer(BigInteger bigInteger) {
        this.bytes = bigInteger.toByteArray();
    }

    public ASN1Integer(byte[] bArr, boolean z) {
        this.bytes = z ? TypeUtilsKt.clone(bArr) : bArr;
    }
}
