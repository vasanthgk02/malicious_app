package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.field.PolynomialExtensionField;

public class X9ECParameters extends ASN1Object implements X9ObjectIdentifiers {
    public static final BigInteger ONE = BigInteger.valueOf(1);
    public ECCurve curve;
    public X9FieldID fieldID;
    public X9ECPoint g;
    public BigInteger h;
    public BigInteger n;
    public byte[] seed;

    public X9ECParameters(ECCurve eCCurve, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, x9ECPoint, bigInteger, bigInteger2, null);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.v.addElement(new ASN1Integer(ONE));
        aSN1EncodableVector.v.addElement(this.fieldID);
        aSN1EncodableVector.v.addElement(new X9Curve(this.curve, this.seed));
        aSN1EncodableVector.v.addElement(this.g);
        aSN1EncodableVector.v.addElement(new ASN1Integer(this.n));
        BigInteger bigInteger = this.h;
        if (bigInteger != null) {
            aSN1EncodableVector.v.addElement(new ASN1Integer(bigInteger));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public X9ECParameters(ECCurve eCCurve, X9ECPoint x9ECPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        int[] iArr;
        this.curve = eCCurve;
        this.g = x9ECPoint;
        this.n = bigInteger;
        this.h = bigInteger2;
        this.seed = bArr;
        if (eCCurve.field.getDimension() == 1) {
            this.fieldID = new X9FieldID(eCCurve.field.getCharacteristic());
        } else if (TypeUtilsKt.isF2mCurve(eCCurve)) {
            int[] iArr2 = ((PolynomialExtensionField) eCCurve.field).getMinimalPolynomial().exponents;
            if (iArr2 == null) {
                iArr = null;
            } else {
                int[] iArr3 = new int[iArr2.length];
                System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
                iArr = iArr3;
            }
            if (iArr.length == 3) {
                this.fieldID = new X9FieldID(iArr[2], iArr[1], 0, 0);
            } else if (iArr.length == 5) {
                this.fieldID = new X9FieldID(iArr[4], iArr[1], iArr[2], iArr[3]);
            } else {
                throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
            }
        } else {
            throw new IllegalArgumentException("'curve' is of an unsupported type");
        }
    }
}
