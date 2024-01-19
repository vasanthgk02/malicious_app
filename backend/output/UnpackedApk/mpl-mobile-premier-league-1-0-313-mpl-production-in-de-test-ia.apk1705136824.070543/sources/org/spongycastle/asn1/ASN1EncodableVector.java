package org.spongycastle.asn1;

import java.util.Vector;

public class ASN1EncodableVector {
    public final Vector v = new Vector();

    public ASN1Encodable get(int i) {
        return (ASN1Encodable) this.v.elementAt(i);
    }

    public int size() {
        return this.v.size();
    }
}
