package org.spongycastle.asn1;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.spongycastle.util.Strings;

public class DERUTF8String extends ASN1Primitive {
    public final byte[] string;

    public DERUTF8String(byte[] bArr) {
        this.string = bArr;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERUTF8String)) {
            return false;
        }
        return TypeUtilsKt.areEqual(this.string, ((DERUTF8String) aSN1Primitive).string);
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(12, this.string);
    }

    public int encodedLength() throws IOException {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    public int hashCode() {
        return TypeUtilsKt.hashCode(this.string);
    }

    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return Strings.fromUTF8ByteArray(this.string);
    }
}
