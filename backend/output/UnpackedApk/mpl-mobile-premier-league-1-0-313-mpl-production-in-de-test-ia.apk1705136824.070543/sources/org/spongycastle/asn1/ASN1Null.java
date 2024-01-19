package org.spongycastle.asn1;

public abstract class ASN1Null extends ASN1Primitive {
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        return aSN1Primitive instanceof ASN1Null;
    }

    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }
}
