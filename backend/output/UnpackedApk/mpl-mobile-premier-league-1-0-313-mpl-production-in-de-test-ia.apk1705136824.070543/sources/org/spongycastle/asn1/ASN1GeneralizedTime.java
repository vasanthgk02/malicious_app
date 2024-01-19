package org.spongycastle.asn1;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

public class ASN1GeneralizedTime extends ASN1Primitive {
    public byte[] time;

    public ASN1GeneralizedTime(byte[] bArr) {
        this.time = bArr;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1GeneralizedTime)) {
            return false;
        }
        return TypeUtilsKt.areEqual(this.time, ((ASN1GeneralizedTime) aSN1Primitive).time);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(24, this.time);
    }

    public int encodedLength() {
        int length = this.time.length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public int hashCode() {
        return TypeUtilsKt.hashCode(this.time);
    }

    public boolean isConstructed() {
        return false;
    }
}
