package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class X9FieldID extends ASN1Object implements X9ObjectIdentifiers {
    public ASN1ObjectIdentifier id;
    public ASN1Primitive parameters;

    public X9FieldID(BigInteger bigInteger) {
        this.id = X9ObjectIdentifiers.prime_field;
        this.parameters = new ASN1Integer(bigInteger);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(this.id);
        aSN1EncodableVector.v.addElement(this.parameters);
        return new DERSequence(aSN1EncodableVector);
    }

    public X9FieldID(int i, int i2, int i3, int i4) {
        this.id = X9ObjectIdentifiers.characteristic_two_field;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(new ASN1Integer((long) i));
        if (i3 == 0) {
            if (i4 == 0) {
                aSN1EncodableVector.v.addElement(X9ObjectIdentifiers.tpBasis);
                aSN1EncodableVector.v.addElement(new ASN1Integer((long) i2));
            } else {
                throw new IllegalArgumentException("inconsistent k values");
            }
        } else if (i3 <= i2 || i4 <= i3) {
            throw new IllegalArgumentException("inconsistent k values");
        } else {
            aSN1EncodableVector.v.addElement(X9ObjectIdentifiers.ppBasis);
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.v.addElement(new ASN1Integer((long) i2));
            aSN1EncodableVector2.v.addElement(new ASN1Integer((long) i3));
            aSN1EncodableVector2.v.addElement(new ASN1Integer((long) i4));
            aSN1EncodableVector.v.addElement(new DERSequence(aSN1EncodableVector2));
        }
        this.parameters = new DERSequence(aSN1EncodableVector);
    }
}
