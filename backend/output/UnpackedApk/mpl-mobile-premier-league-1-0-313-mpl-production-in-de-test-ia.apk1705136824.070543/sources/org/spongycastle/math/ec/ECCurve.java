package org.spongycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.ec.endo.GLVTypeBEndomorphism;
import org.spongycastle.math.field.FiniteField;
import org.spongycastle.math.field.FiniteFields;

public abstract class ECCurve {

    /* renamed from: a  reason: collision with root package name */
    public ECFieldElement f6254a;

    /* renamed from: b  reason: collision with root package name */
    public ECFieldElement f6255b;
    public BigInteger cofactor;
    public int coord = 0;
    public GLVTypeBEndomorphism endomorphism = null;
    public FiniteField field;
    public ECMultiplier multiplier = null;
    public BigInteger order;

    public static abstract class AbstractF2m extends ECCurve {
        /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public AbstractF2m(int r6, int r7, int r8, int r9) {
            /*
                r5 = this;
                if (r7 == 0) goto L_0x0049
                r0 = 2
                r1 = 1
                r2 = 3
                r3 = 0
                if (r8 != 0) goto L_0x001f
                if (r9 != 0) goto L_0x0017
                int[] r8 = new int[r2]
                r8[r3] = r3
                r8[r1] = r7
                r8[r0] = r6
                org.spongycastle.math.field.PolynomialExtensionField r6 = org.spongycastle.math.field.FiniteFields.getBinaryExtensionField(r8)
                goto L_0x0035
            L_0x0017:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "k3 must be 0 if k2 == 0"
                r6.<init>(r7)
                throw r6
            L_0x001f:
                if (r8 <= r7) goto L_0x0041
                if (r9 <= r8) goto L_0x0039
                r4 = 5
                int[] r4 = new int[r4]
                r4[r3] = r3
                r4[r1] = r7
                r4[r0] = r8
                r4[r2] = r9
                r7 = 4
                r4[r7] = r6
                org.spongycastle.math.field.PolynomialExtensionField r6 = org.spongycastle.math.field.FiniteFields.getBinaryExtensionField(r4)
            L_0x0035:
                r5.<init>(r6)
                return
            L_0x0039:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "k3 must be > k2"
                r6.<init>(r7)
                throw r6
            L_0x0041:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "k2 must be > k1"
                r6.<init>(r7)
                throw r6
            L_0x0049:
                java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
                java.lang.String r7 = "k1 must be > 0"
                r6.<init>(r7)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.ECCurve.AbstractF2m.<init>(int, int, int, int):void");
        }

        public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
            ECFieldElement fromBigInteger = fromBigInteger(bigInteger);
            ECFieldElement fromBigInteger2 = fromBigInteger(bigInteger2);
            int i = this.coord;
            if (i == 5 || i == 6) {
                if (!fromBigInteger.isZero()) {
                    fromBigInteger2 = fromBigInteger2.divide(fromBigInteger).add(fromBigInteger);
                } else if (!fromBigInteger2.square().equals(this.f6255b)) {
                    throw new IllegalArgumentException();
                }
            }
            return new org.spongycastle.math.ec.ECPoint.F2m((F2m) this, fromBigInteger, fromBigInteger2, z);
        }

        public ECPoint decompressPoint(int i, BigInteger bigInteger) {
            ECFieldElement fromBigInteger = fromBigInteger(bigInteger);
            ECFieldElement eCFieldElement = null;
            if (fromBigInteger.isZero()) {
                eCFieldElement = this.f6255b.sqrt();
            } else {
                ECFieldElement add = fromBigInteger.square().invert().multiply(this.f6255b).add(this.f6254a).add(fromBigInteger);
                if (!add.isZero()) {
                    ECFieldElement fromBigInteger2 = fromBigInteger(ECConstants.ZERO);
                    int i2 = ((F2m) this).m;
                    Random random = new Random();
                    while (true) {
                        ECFieldElement fromBigInteger3 = fromBigInteger(new BigInteger(i2, random));
                        ECFieldElement eCFieldElement2 = add;
                        ECFieldElement eCFieldElement3 = fromBigInteger2;
                        for (int i3 = 1; i3 < i2; i3++) {
                            ECFieldElement square = eCFieldElement2.square();
                            eCFieldElement3 = eCFieldElement3.square().add(square.multiply(fromBigInteger3));
                            eCFieldElement2 = square.add(add);
                        }
                        if (eCFieldElement2.isZero()) {
                            if (!eCFieldElement3.square().add(eCFieldElement3).isZero()) {
                                add = eCFieldElement3;
                                break;
                            }
                        } else {
                            add = null;
                            break;
                        }
                    }
                }
                if (add != null) {
                    if (add.testBitZero() != (i == 1)) {
                        add = add.addOne();
                    }
                    int i4 = this.coord;
                    if (i4 == 5 || i4 == 6) {
                        eCFieldElement = add.add(fromBigInteger);
                    } else {
                        eCFieldElement = add.multiply(fromBigInteger);
                    }
                }
            }
            if (eCFieldElement != null) {
                return new org.spongycastle.math.ec.ECPoint.F2m((F2m) this, fromBigInteger, eCFieldElement, true);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }
    }

    public static abstract class AbstractFp extends ECCurve {
        public AbstractFp(BigInteger bigInteger) {
            super(FiniteFields.getPrimeField(bigInteger));
        }

        public ECPoint decompressPoint(int i, BigInteger bigInteger) {
            ECFieldElement fromBigInteger = fromBigInteger(bigInteger);
            ECFieldElement sqrt = fromBigInteger.square().add(this.f6254a).multiply(fromBigInteger).add(this.f6255b).sqrt();
            if (sqrt != null) {
                if (sqrt.testBitZero() != (i == 1)) {
                    sqrt = sqrt.negate();
                }
                return new org.spongycastle.math.ec.ECPoint.Fp((Fp) this, fromBigInteger, sqrt, true);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }
    }

    public static class F2m extends AbstractF2m {
        public org.spongycastle.math.ec.ECPoint.F2m infinity;
        public int k1;
        public int k2;
        public int k3;
        public int m;

        public F2m(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        public ECCurve cloneCurve() {
            F2m f2m = new F2m(this.m, this.k1, this.k2, this.k3, this.f6254a, this.f6255b, this.order, this.cofactor);
            return f2m;
        }

        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            return new org.spongycastle.math.ec.ECPoint.F2m(this, eCFieldElement, eCFieldElement2, z);
        }

        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            org.spongycastle.math.ec.ECFieldElement.F2m f2m = new org.spongycastle.math.ec.ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, bigInteger);
            return f2m;
        }

        public int getFieldSize() {
            return this.m;
        }

        public ECPoint getInfinity() {
            return this.infinity;
        }

        public boolean supportsCoordinateSystem(int i) {
            return i == 0 || i == 1 || i == 6;
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(i, i2, i3, i4);
            this.m = i;
            this.k1 = i2;
            this.k2 = i3;
            this.k3 = i4;
            this.order = bigInteger3;
            this.cofactor = bigInteger4;
            this.infinity = new org.spongycastle.math.ec.ECPoint.F2m(this, null, null, false);
            this.f6254a = fromBigInteger(bigInteger);
            this.f6255b = fromBigInteger(bigInteger2);
            this.coord = 6;
        }

        public F2m(int i, int i2, int i3, int i4, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, BigInteger bigInteger, BigInteger bigInteger2) {
            super(i, i2, i3, i4);
            this.m = i;
            this.k1 = i2;
            this.k2 = i3;
            this.k3 = i4;
            this.order = bigInteger;
            this.cofactor = bigInteger2;
            this.infinity = new org.spongycastle.math.ec.ECPoint.F2m(this, null, null, false);
            this.f6254a = eCFieldElement;
            this.f6255b = eCFieldElement2;
            this.coord = 6;
        }
    }

    public static class Fp extends AbstractFp {
        public org.spongycastle.math.ec.ECPoint.Fp infinity = new org.spongycastle.math.ec.ECPoint.Fp(this, null, null, false);
        public BigInteger q;
        public BigInteger r;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
            super(bigInteger);
            this.q = bigInteger;
            this.r = org.spongycastle.math.ec.ECFieldElement.Fp.calculateResidue(bigInteger);
            this.f6254a = fromBigInteger(bigInteger2);
            this.f6255b = fromBigInteger(bigInteger3);
            this.order = bigInteger4;
            this.cofactor = bigInteger5;
            this.coord = 4;
        }

        public ECCurve cloneCurve() {
            Fp fp = new Fp(this.q, this.r, this.f6254a, this.f6255b, this.order, this.cofactor);
            return fp;
        }

        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            return new org.spongycastle.math.ec.ECPoint.Fp(this, eCFieldElement, eCFieldElement2, z);
        }

        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new org.spongycastle.math.ec.ECFieldElement.Fp(this.q, this.r, bigInteger);
        }

        public int getFieldSize() {
            return this.q.bitLength();
        }

        public ECPoint getInfinity() {
            return this.infinity;
        }

        public ECPoint importPoint(ECPoint eCPoint) {
            if (this != eCPoint.curve && this.coord == 2 && !eCPoint.isInfinity()) {
                int i = eCPoint.curve.coord;
                if (i == 2 || i == 3 || i == 4) {
                    org.spongycastle.math.ec.ECPoint.Fp fp = new org.spongycastle.math.ec.ECPoint.Fp(this, fromBigInteger(eCPoint.x.toBigInteger()), fromBigInteger(eCPoint.y.toBigInteger()), new ECFieldElement[]{fromBigInteger(eCPoint.zs[0].toBigInteger())}, eCPoint.withCompression);
                    return fp;
                }
            }
            return ECCurve.super.importPoint(eCPoint);
        }

        public boolean supportsCoordinateSystem(int i) {
            return i == 0 || i == 1 || i == 2 || i == 4;
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(bigInteger);
            this.q = bigInteger;
            this.r = bigInteger2;
            this.f6254a = eCFieldElement;
            this.f6255b = eCFieldElement2;
            this.order = bigInteger3;
            this.cofactor = bigInteger4;
            this.coord = 4;
        }
    }

    public ECCurve(FiniteField finiteField) {
        this.field = finiteField;
    }

    public abstract ECCurve cloneCurve();

    public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
        return createRawPoint(fromBigInteger(bigInteger), fromBigInteger(bigInteger2), z);
    }

    public abstract ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z);

    public abstract ECPoint decompressPoint(int i, BigInteger bigInteger);

    public boolean equals(ECCurve eCCurve) {
        return this == eCCurve || (eCCurve != null && this.field.equals(eCCurve.field) && this.f6254a.toBigInteger().equals(eCCurve.f6254a.toBigInteger()) && this.f6255b.toBigInteger().equals(eCCurve.f6255b.toBigInteger()));
    }

    public abstract ECFieldElement fromBigInteger(BigInteger bigInteger);

    public abstract int getFieldSize();

    public abstract ECPoint getInfinity();

    public int hashCode() {
        return (this.field.hashCode() ^ Integer.rotateLeft(this.f6254a.toBigInteger().hashCode(), 8)) ^ Integer.rotateLeft(this.f6255b.toBigInteger().hashCode(), 16);
    }

    public ECPoint importPoint(ECPoint eCPoint) {
        if (this == eCPoint.curve) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return getInfinity();
        }
        ECPoint normalize = eCPoint.normalize();
        ECPoint createPoint = createPoint(normalize.x.toBigInteger(), normalize.getYCoord().toBigInteger(), normalize.withCompression);
        if (createPoint.isValid()) {
            return createPoint;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }

    public boolean supportsCoordinateSystem(int i) {
        return i == 0;
    }

    public ECPoint validatePoint(BigInteger bigInteger, BigInteger bigInteger2) {
        ECPoint createPoint = createPoint(bigInteger, bigInteger2, false);
        if (createPoint.isValid()) {
            return createPoint;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof ECCurve) && equals((ECCurve) obj));
    }
}
