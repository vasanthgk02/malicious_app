package org.spongycastle.asn1;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

public class DERVideotexString extends ASN1Primitive {
    public final byte[] string;

    public DERVideotexString(byte[] bArr) {
        this.string = TypeUtilsKt.clone(bArr);
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERVideotexString)) {
            return false;
        }
        return TypeUtilsKt.areEqual(this.string, ((DERVideotexString) aSN1Primitive).string);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(21, this.string);
    }

    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    public int hashCode() {
        return TypeUtilsKt.hashCode(this.string);
    }

    public boolean isConstructed() {
        return false;
    }
}
