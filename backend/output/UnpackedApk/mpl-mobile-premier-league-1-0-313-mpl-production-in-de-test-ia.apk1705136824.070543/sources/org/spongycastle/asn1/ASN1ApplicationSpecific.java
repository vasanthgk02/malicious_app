package org.spongycastle.asn1;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

public abstract class ASN1ApplicationSpecific extends ASN1Primitive {
    public final boolean isConstructed;
    public final byte[] octets;
    public final int tag;

    public ASN1ApplicationSpecific(boolean z, int i, byte[] bArr) {
        this.isConstructed = z;
        this.tag = i;
        this.octets = bArr;
    }

    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        boolean z = false;
        if (!(aSN1Primitive instanceof ASN1ApplicationSpecific)) {
            return false;
        }
        ASN1ApplicationSpecific aSN1ApplicationSpecific = (ASN1ApplicationSpecific) aSN1Primitive;
        if (this.isConstructed == aSN1ApplicationSpecific.isConstructed && this.tag == aSN1ApplicationSpecific.tag && TypeUtilsKt.areEqual(this.octets, aSN1ApplicationSpecific.octets)) {
            z = true;
        }
        return z;
    }

    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(this.isConstructed ? 96 : 64, this.tag, this.octets);
    }

    public int encodedLength() throws IOException {
        return StreamUtil.calculateBodyLength(this.octets.length) + StreamUtil.calculateTagLength(this.tag) + this.octets.length;
    }

    public int hashCode() {
        return (this.isConstructed ^ this.tag) ^ TypeUtilsKt.hashCode(this.octets) ? 1 : 0;
    }

    public boolean isConstructed() {
        return this.isConstructed;
    }
}
