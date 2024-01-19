package org.spongycastle.asn1.x9;

import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.math.ec.ECCurve;

public class X9Curve extends ASN1Object implements X9ObjectIdentifiers {
    public ECCurve curve;
    public ASN1ObjectIdentifier fieldIdentifier = null;
    public byte[] seed;

    public X9Curve(ECCurve eCCurve, byte[] bArr) {
        this.curve = eCCurve;
        this.seed = bArr;
        if (eCCurve.field.getDimension() != 1 ? false : true) {
            this.fieldIdentifier = X9ObjectIdentifiers.prime_field;
        } else if (TypeUtilsKt.isF2mCurve(this.curve)) {
            this.fieldIdentifier = X9ObjectIdentifiers.characteristic_two_field;
        } else {
            throw new IllegalArgumentException("This type of ECCurve is not implemented");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.asn1.ASN1Primitive toASN1Primitive() {
        /*
            r6 = this;
            org.spongycastle.asn1.ASN1EncodableVector r0 = new org.spongycastle.asn1.ASN1EncodableVector
            r0.<init>()
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r6.fieldIdentifier
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.x9.X9ObjectIdentifiers.prime_field
            boolean r1 = r1.equals(r2)
            r2 = 0
            if (r1 == 0) goto L_0x007e
            org.spongycastle.math.ec.ECCurve r1 = r6.curve
            org.spongycastle.math.ec.ECFieldElement r1 = r1.f6254a
            int r3 = r1.getFieldSize()
            int r3 = r3 + 7
            int r3 = r3 / 8
            java.math.BigInteger r1 = r1.toBigInteger()
            byte[] r1 = r1.toByteArray()
            int r4 = r1.length
            if (r3 >= r4) goto L_0x0030
            byte[] r4 = new byte[r3]
            int r5 = r1.length
            int r5 = r5 - r3
            java.lang.System.arraycopy(r1, r5, r4, r2, r3)
        L_0x002e:
            r1 = r4
            goto L_0x003c
        L_0x0030:
            int r4 = r1.length
            if (r3 <= r4) goto L_0x003c
            byte[] r4 = new byte[r3]
            int r5 = r1.length
            int r3 = r3 - r5
            int r5 = r1.length
            java.lang.System.arraycopy(r1, r2, r4, r3, r5)
            goto L_0x002e
        L_0x003c:
            org.spongycastle.asn1.DEROctetString r3 = new org.spongycastle.asn1.DEROctetString
            r3.<init>(r1)
            java.util.Vector r1 = r0.v
            r1.addElement(r3)
            org.spongycastle.math.ec.ECCurve r1 = r6.curve
            org.spongycastle.math.ec.ECFieldElement r1 = r1.f6255b
            int r3 = r1.getFieldSize()
            int r3 = r3 + 7
            int r3 = r3 / 8
            java.math.BigInteger r1 = r1.toBigInteger()
            byte[] r1 = r1.toByteArray()
            int r4 = r1.length
            if (r3 >= r4) goto L_0x0066
            byte[] r4 = new byte[r3]
            int r5 = r1.length
            int r5 = r5 - r3
            java.lang.System.arraycopy(r1, r5, r4, r2, r3)
        L_0x0064:
            r1 = r4
            goto L_0x0072
        L_0x0066:
            int r4 = r1.length
            if (r3 <= r4) goto L_0x0072
            byte[] r4 = new byte[r3]
            int r5 = r1.length
            int r3 = r3 - r5
            int r5 = r1.length
            java.lang.System.arraycopy(r1, r2, r4, r3, r5)
            goto L_0x0064
        L_0x0072:
            org.spongycastle.asn1.DEROctetString r2 = new org.spongycastle.asn1.DEROctetString
            r2.<init>(r1)
            java.util.Vector r1 = r0.v
            r1.addElement(r2)
            goto L_0x00f4
        L_0x007e:
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r6.fieldIdentifier
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.x9.X9ObjectIdentifiers.characteristic_two_field
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00f4
            org.spongycastle.math.ec.ECCurve r1 = r6.curve
            org.spongycastle.math.ec.ECFieldElement r1 = r1.f6254a
            int r3 = r1.getFieldSize()
            int r3 = r3 + 7
            int r3 = r3 / 8
            java.math.BigInteger r1 = r1.toBigInteger()
            byte[] r1 = r1.toByteArray()
            int r4 = r1.length
            if (r3 >= r4) goto L_0x00a8
            byte[] r4 = new byte[r3]
            int r5 = r1.length
            int r5 = r5 - r3
            java.lang.System.arraycopy(r1, r5, r4, r2, r3)
        L_0x00a6:
            r1 = r4
            goto L_0x00b4
        L_0x00a8:
            int r4 = r1.length
            if (r3 <= r4) goto L_0x00b4
            byte[] r4 = new byte[r3]
            int r5 = r1.length
            int r3 = r3 - r5
            int r5 = r1.length
            java.lang.System.arraycopy(r1, r2, r4, r3, r5)
            goto L_0x00a6
        L_0x00b4:
            org.spongycastle.asn1.DEROctetString r3 = new org.spongycastle.asn1.DEROctetString
            r3.<init>(r1)
            java.util.Vector r1 = r0.v
            r1.addElement(r3)
            org.spongycastle.math.ec.ECCurve r1 = r6.curve
            org.spongycastle.math.ec.ECFieldElement r1 = r1.f6255b
            int r3 = r1.getFieldSize()
            int r3 = r3 + 7
            int r3 = r3 / 8
            java.math.BigInteger r1 = r1.toBigInteger()
            byte[] r1 = r1.toByteArray()
            int r4 = r1.length
            if (r3 >= r4) goto L_0x00de
            byte[] r4 = new byte[r3]
            int r5 = r1.length
            int r5 = r5 - r3
            java.lang.System.arraycopy(r1, r5, r4, r2, r3)
        L_0x00dc:
            r1 = r4
            goto L_0x00ea
        L_0x00de:
            int r4 = r1.length
            if (r3 <= r4) goto L_0x00ea
            byte[] r4 = new byte[r3]
            int r5 = r1.length
            int r3 = r3 - r5
            int r5 = r1.length
            java.lang.System.arraycopy(r1, r2, r4, r3, r5)
            goto L_0x00dc
        L_0x00ea:
            org.spongycastle.asn1.DEROctetString r2 = new org.spongycastle.asn1.DEROctetString
            r2.<init>(r1)
            java.util.Vector r1 = r0.v
            r1.addElement(r2)
        L_0x00f4:
            byte[] r1 = r6.seed
            if (r1 == 0) goto L_0x0102
            org.spongycastle.asn1.DERBitString r2 = new org.spongycastle.asn1.DERBitString
            r2.<init>(r1)
            java.util.Vector r1 = r0.v
            r1.addElement(r2)
        L_0x0102:
            org.spongycastle.asn1.DERSequence r1 = new org.spongycastle.asn1.DERSequence
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x9.X9Curve.toASN1Primitive():org.spongycastle.asn1.ASN1Primitive");
    }
}
