package org.spongycastle.asn1;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

public class ASN1Enumerated extends ASN1Primitive {
    public static ASN1Enumerated[] cache = new ASN1Enumerated[12];
    public final byte[] bytes;

    public ASN1Enumerated(byte[] bArr) {
        this.bytes = bArr;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Enumerated)) {
            return false;
        }
        return TypeUtilsKt.areEqual(this.bytes, ((ASN1Enumerated) aSN1Primitive).bytes);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(10, this.bytes);
    }

    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.bytes.length) + 1 + this.bytes.length;
    }

    public int hashCode() {
        return TypeUtilsKt.hashCode(this.bytes);
    }

    public boolean isConstructed() {
        return false;
    }
}
