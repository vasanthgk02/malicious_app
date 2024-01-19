package org.spongycastle.asn1;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.spongycastle.util.Strings;

public class DERPrintableString extends ASN1Primitive {
    public final byte[] string;

    public DERPrintableString(byte[] bArr) {
        this.string = bArr;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERPrintableString)) {
            return false;
        }
        return TypeUtilsKt.areEqual(this.string, ((DERPrintableString) aSN1Primitive).string);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(19, this.string);
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

    public String toString() {
        return Strings.fromByteArray(this.string);
    }
}
