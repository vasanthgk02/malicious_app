package org.spongycastle.asn1;

import java.util.Vector;

public class BERFactory {
    public static final BERSequence EMPTY_SEQUENCE = new BERSequence();

    static {
        new Vector();
    }

    public static BERSequence createSequence(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.size() < 1 ? EMPTY_SEQUENCE : new BERSequence(aSN1EncodableVector);
    }
}
