package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.apache.commons.net.ftp.FTPReply;

public abstract class ECPoint {
    public static ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];
    public ECCurve curve;
    public boolean withCompression;
    public ECFieldElement x;
    public ECFieldElement y;
    public ECFieldElement[] zs;

    public static abstract class AbstractF2m extends ECPoint {
        public AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECCurve eCCurve = this.curve;
            ECFieldElement eCFieldElement3 = this.x;
            ECFieldElement eCFieldElement4 = eCCurve.f6254a;
            ECFieldElement eCFieldElement5 = eCCurve.f6255b;
            int i = eCCurve.coord;
            if (i == 6) {
                ECFieldElement eCFieldElement6 = this.zs[0];
                boolean isOne = eCFieldElement6.isOne();
                if (eCFieldElement3.isZero()) {
                    ECFieldElement square = this.y.square();
                    if (!isOne) {
                        eCFieldElement5 = eCFieldElement5.multiply(eCFieldElement6.square());
                    }
                    return square.equals(eCFieldElement5);
                }
                ECFieldElement eCFieldElement7 = this.y;
                ECFieldElement square2 = eCFieldElement3.square();
                if (isOne) {
                    eCFieldElement2 = eCFieldElement7.square().add(eCFieldElement7).add(eCFieldElement4);
                    eCFieldElement = square2.square().add(eCFieldElement5);
                } else {
                    ECFieldElement square3 = eCFieldElement6.square();
                    ECFieldElement square4 = square3.square();
                    eCFieldElement2 = eCFieldElement7.add(eCFieldElement6).multiplyPlusProduct(eCFieldElement7, eCFieldElement4, square3);
                    eCFieldElement = square2.squarePlusProduct(eCFieldElement5, square4);
                }
                return eCFieldElement2.multiply(square2).equals(eCFieldElement);
            }
            ECFieldElement eCFieldElement8 = this.y;
            ECFieldElement multiply = eCFieldElement8.add(eCFieldElement3).multiply(eCFieldElement8);
            if (i != 0) {
                if (i == 1) {
                    ECFieldElement eCFieldElement9 = this.zs[0];
                    if (!eCFieldElement9.isOne()) {
                        ECFieldElement multiply2 = eCFieldElement9.multiply(eCFieldElement9.square());
                        multiply = multiply.multiply(eCFieldElement9);
                        eCFieldElement4 = eCFieldElement4.multiply(eCFieldElement9);
                        eCFieldElement5 = eCFieldElement5.multiply(multiply2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return multiply.equals(eCFieldElement3.add(eCFieldElement4).multiply(eCFieldElement3.square()).add(eCFieldElement5));
        }

        public AbstractF2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    public static abstract class AbstractFp extends ECPoint {
        public AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
        }

        public boolean satisfiesCurveEquation() {
            ECFieldElement eCFieldElement = this.x;
            ECFieldElement eCFieldElement2 = this.y;
            ECCurve eCCurve = this.curve;
            ECFieldElement eCFieldElement3 = eCCurve.f6254a;
            ECFieldElement eCFieldElement4 = eCCurve.f6255b;
            ECFieldElement square = eCFieldElement2.square();
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 0) {
                if (curveCoordinateSystem == 1) {
                    ECFieldElement eCFieldElement5 = this.zs[0];
                    if (!eCFieldElement5.isOne()) {
                        ECFieldElement square2 = eCFieldElement5.square();
                        ECFieldElement multiply = eCFieldElement5.multiply(square2);
                        square = square.multiply(eCFieldElement5);
                        eCFieldElement3 = eCFieldElement3.multiply(square2);
                        eCFieldElement4 = eCFieldElement4.multiply(multiply);
                    }
                } else if (curveCoordinateSystem == 2 || curveCoordinateSystem == 3 || curveCoordinateSystem == 4) {
                    ECFieldElement eCFieldElement6 = this.zs[0];
                    if (!eCFieldElement6.isOne()) {
                        ECFieldElement square3 = eCFieldElement6.square();
                        ECFieldElement square4 = square3.square();
                        ECFieldElement multiply2 = square3.multiply(square4);
                        eCFieldElement3 = eCFieldElement3.multiply(square4);
                        eCFieldElement4 = eCFieldElement4.multiply(multiply2);
                    }
                } else {
                    throw new IllegalStateException("unsupported coordinate system");
                }
            }
            return square.equals(eCFieldElement.square().add(eCFieldElement3).multiply(eCFieldElement).add(eCFieldElement4));
        }

        public AbstractFp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }
    }

    public static class F2m extends AbstractF2m {
        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            boolean z2 = true;
            if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : z2)) {
                if (eCFieldElement != null) {
                    org.spongycastle.math.ec.ECFieldElement.F2m.checkFieldElements(this.x, this.y);
                    if (eCCurve != null) {
                        org.spongycastle.math.ec.ECFieldElement.F2m.checkFieldElements(this.x, this.curve.f6254a);
                    }
                }
                this.withCompression = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        public ECPoint add(ECPoint eCPoint) {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            ECFieldElement eCFieldElement6;
            ECFieldElement eCFieldElement7;
            ECFieldElement eCFieldElement8;
            ECPoint eCPoint2 = eCPoint;
            if (isInfinity()) {
                return eCPoint2;
            }
            if (eCPoint.isInfinity()) {
                return this;
            }
            ECCurve eCCurve = this.curve;
            int i = eCCurve.coord;
            ECFieldElement eCFieldElement9 = this.x;
            ECFieldElement eCFieldElement10 = eCPoint2.x;
            if (i == 0) {
                ECFieldElement eCFieldElement11 = this.y;
                ECFieldElement eCFieldElement12 = eCPoint2.y;
                ECFieldElement add = eCFieldElement9.add(eCFieldElement10);
                ECFieldElement add2 = eCFieldElement11.add(eCFieldElement12);
                if (!add.isZero()) {
                    ECFieldElement divide = add2.divide(add);
                    ECFieldElement add3 = divide.square().add(divide).add(add).add(eCCurve.f6254a);
                    return new F2m(eCCurve, add3, divide.multiply(eCFieldElement9.add(add3)).add(add3).add(eCFieldElement11), this.withCompression);
                } else if (add2.isZero()) {
                    return twice();
                } else {
                    return eCCurve.getInfinity();
                }
            } else if (i == 1) {
                ECFieldElement eCFieldElement13 = this.y;
                ECFieldElement eCFieldElement14 = this.zs[0];
                ECFieldElement eCFieldElement15 = eCPoint2.y;
                ECFieldElement eCFieldElement16 = eCPoint2.zs[0];
                boolean isOne = eCFieldElement16.isOne();
                ECFieldElement multiply = eCFieldElement14.multiply(eCFieldElement15);
                if (isOne) {
                    eCFieldElement = eCFieldElement13;
                } else {
                    eCFieldElement = eCFieldElement13.multiply(eCFieldElement16);
                }
                ECFieldElement add4 = multiply.add(eCFieldElement);
                ECFieldElement multiply2 = eCFieldElement14.multiply(eCFieldElement10);
                if (isOne) {
                    eCFieldElement2 = eCFieldElement9;
                } else {
                    eCFieldElement2 = eCFieldElement9.multiply(eCFieldElement16);
                }
                ECFieldElement add5 = multiply2.add(eCFieldElement2);
                if (!add5.isZero()) {
                    ECFieldElement square = add5.square();
                    ECFieldElement multiply3 = square.multiply(add5);
                    if (!isOne) {
                        eCFieldElement14 = eCFieldElement14.multiply(eCFieldElement16);
                    }
                    ECFieldElement add6 = add4.add(add5);
                    ECFieldElement add7 = add6.multiplyPlusProduct(add4, square, eCCurve.f6254a).multiply(eCFieldElement14).add(multiply3);
                    ECFieldElement multiply4 = add5.multiply(add7);
                    if (!isOne) {
                        square = square.multiply(eCFieldElement16);
                    }
                    F2m f2m = new F2m(eCCurve, multiply4, add4.multiplyPlusProduct(eCFieldElement9, add5, eCFieldElement13).multiplyPlusProduct(square, add6, add7), new ECFieldElement[]{multiply3.multiply(eCFieldElement14)}, this.withCompression);
                    return f2m;
                } else if (add4.isZero()) {
                    return twice();
                } else {
                    return eCCurve.getInfinity();
                }
            } else if (i != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            } else if (!eCFieldElement9.isZero()) {
                ECFieldElement eCFieldElement17 = this.y;
                ECFieldElement eCFieldElement18 = this.zs[0];
                ECFieldElement eCFieldElement19 = eCPoint2.y;
                ECFieldElement eCFieldElement20 = eCPoint2.zs[0];
                boolean isOne2 = eCFieldElement18.isOne();
                if (!isOne2) {
                    eCFieldElement4 = eCFieldElement10.multiply(eCFieldElement18);
                    eCFieldElement3 = eCFieldElement19.multiply(eCFieldElement18);
                } else {
                    eCFieldElement4 = eCFieldElement10;
                    eCFieldElement3 = eCFieldElement19;
                }
                boolean isOne3 = eCFieldElement20.isOne();
                if (!isOne3) {
                    eCFieldElement9 = eCFieldElement9.multiply(eCFieldElement20);
                    eCFieldElement5 = eCFieldElement17.multiply(eCFieldElement20);
                } else {
                    eCFieldElement5 = eCFieldElement17;
                }
                ECFieldElement add8 = eCFieldElement5.add(eCFieldElement3);
                ECFieldElement add9 = eCFieldElement9.add(eCFieldElement4);
                if (!add9.isZero()) {
                    if (eCFieldElement10.isZero()) {
                        ECPoint normalize = normalize();
                        ECFieldElement eCFieldElement21 = normalize.x;
                        ECFieldElement yCoord = normalize.getYCoord();
                        ECFieldElement divide2 = yCoord.add(eCFieldElement19).divide(eCFieldElement21);
                        eCFieldElement6 = divide2.square().add(divide2).add(eCFieldElement21).add(eCCurve.f6254a);
                        if (eCFieldElement6.isZero()) {
                            return new F2m(eCCurve, eCFieldElement6, eCCurve.f6255b.sqrt(), this.withCompression);
                        }
                        eCFieldElement8 = divide2.multiply(eCFieldElement21.add(eCFieldElement6)).add(eCFieldElement6).add(yCoord).divide(eCFieldElement6).add(eCFieldElement6);
                        eCFieldElement7 = eCCurve.fromBigInteger(ECConstants.ONE);
                    } else {
                        ECFieldElement square2 = add9.square();
                        ECFieldElement multiply5 = add8.multiply(eCFieldElement9);
                        ECFieldElement multiply6 = add8.multiply(eCFieldElement4);
                        ECFieldElement multiply7 = multiply5.multiply(multiply6);
                        if (multiply7.isZero()) {
                            return new F2m(eCCurve, multiply7, eCCurve.f6255b.sqrt(), this.withCompression);
                        }
                        ECFieldElement multiply8 = add8.multiply(square2);
                        ECFieldElement multiply9 = !isOne3 ? multiply8.multiply(eCFieldElement20) : multiply8;
                        ECFieldElement squarePlusProduct = multiply6.add(square2).squarePlusProduct(multiply9, eCFieldElement17.add(eCFieldElement18));
                        if (!isOne2) {
                            multiply9 = multiply9.multiply(eCFieldElement18);
                        }
                        eCFieldElement6 = multiply7;
                        ECFieldElement eCFieldElement22 = squarePlusProduct;
                        eCFieldElement7 = multiply9;
                        eCFieldElement8 = eCFieldElement22;
                    }
                    F2m f2m2 = new F2m(eCCurve, eCFieldElement6, eCFieldElement8, new ECFieldElement[]{eCFieldElement7}, this.withCompression);
                    return f2m2;
                } else if (add8.isZero()) {
                    return twice();
                } else {
                    return eCCurve.getInfinity();
                }
            } else if (eCFieldElement10.isZero()) {
                return eCCurve.getInfinity();
            } else {
                return eCPoint2.add(this);
            }
        }

        public ECFieldElement getYCoord() {
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 5 && curveCoordinateSystem != 6) {
                return this.y;
            }
            ECFieldElement eCFieldElement = this.x;
            ECFieldElement eCFieldElement2 = this.y;
            if (isInfinity() || eCFieldElement.isZero()) {
                return eCFieldElement2;
            }
            ECFieldElement multiply = eCFieldElement2.add(eCFieldElement).multiply(eCFieldElement);
            if (6 == curveCoordinateSystem) {
                ECFieldElement eCFieldElement3 = this.zs[0];
                if (!eCFieldElement3.isOne()) {
                    multiply = multiply.divide(eCFieldElement3);
                }
            }
            return multiply;
        }

        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.x;
            if (eCFieldElement.isZero()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem == 0) {
                return new F2m(this.curve, eCFieldElement, this.y.add(eCFieldElement), this.withCompression);
            } else if (curveCoordinateSystem == 1) {
                ECFieldElement eCFieldElement2 = this.y;
                ECFieldElement eCFieldElement3 = this.zs[0];
                F2m f2m = new F2m(this.curve, eCFieldElement, eCFieldElement2.add(eCFieldElement), new ECFieldElement[]{eCFieldElement3}, this.withCompression);
                return f2m;
            } else if (curveCoordinateSystem == 5) {
                return new F2m(this.curve, eCFieldElement, this.y.addOne(), this.withCompression);
            } else if (curveCoordinateSystem == 6) {
                ECFieldElement eCFieldElement4 = this.y;
                ECFieldElement eCFieldElement5 = this.zs[0];
                F2m f2m2 = new F2m(this.curve, eCFieldElement, eCFieldElement4.add(eCFieldElement5), new ECFieldElement[]{eCFieldElement5}, this.withCompression);
                return f2m2;
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public ECPoint twice() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            ECFieldElement eCFieldElement6;
            ECFieldElement eCFieldElement7;
            if (isInfinity()) {
                return this;
            }
            ECCurve eCCurve = this.curve;
            ECFieldElement eCFieldElement8 = this.x;
            if (eCFieldElement8.isZero()) {
                return eCCurve.getInfinity();
            }
            int i = eCCurve.coord;
            if (i == 0) {
                ECCurve eCCurve2 = eCCurve;
                ECFieldElement add = this.y.divide(eCFieldElement8).add(eCFieldElement8);
                ECFieldElement add2 = add.square().add(add).add(eCCurve2.f6254a);
                return new F2m(eCCurve2, add2, eCFieldElement8.squarePlusProduct(add2, add.addOne()), this.withCompression);
            } else if (i == 1) {
                ECCurve eCCurve3 = eCCurve;
                ECFieldElement eCFieldElement9 = this.y;
                ECFieldElement eCFieldElement10 = this.zs[0];
                boolean isOne = eCFieldElement10.isOne();
                if (isOne) {
                    eCFieldElement = eCFieldElement8;
                } else {
                    eCFieldElement = eCFieldElement8.multiply(eCFieldElement10);
                }
                if (!isOne) {
                    eCFieldElement9 = eCFieldElement9.multiply(eCFieldElement10);
                }
                ECFieldElement square = eCFieldElement8.square();
                ECFieldElement add3 = square.add(eCFieldElement9);
                ECFieldElement square2 = eCFieldElement.square();
                ECFieldElement add4 = add3.add(eCFieldElement);
                ECCurve eCCurve4 = eCCurve3;
                ECFieldElement multiplyPlusProduct = add4.multiplyPlusProduct(add3, square2, eCCurve4.f6254a);
                F2m f2m = new F2m(eCCurve4, eCFieldElement.multiply(multiplyPlusProduct), square.square().multiplyPlusProduct(eCFieldElement, multiplyPlusProduct, add4), new ECFieldElement[]{eCFieldElement.multiply(square2)}, this.withCompression);
                return f2m;
            } else if (i == 6) {
                ECFieldElement eCFieldElement11 = this.y;
                ECFieldElement eCFieldElement12 = this.zs[0];
                boolean isOne2 = eCFieldElement12.isOne();
                if (isOne2) {
                    eCFieldElement2 = eCFieldElement11;
                } else {
                    eCFieldElement2 = eCFieldElement11.multiply(eCFieldElement12);
                }
                if (isOne2) {
                    eCFieldElement3 = eCFieldElement12;
                } else {
                    eCFieldElement3 = eCFieldElement12.square();
                }
                ECFieldElement eCFieldElement13 = eCCurve.f6254a;
                if (isOne2) {
                    eCFieldElement4 = eCFieldElement13;
                } else {
                    eCFieldElement4 = eCFieldElement13.multiply(eCFieldElement3);
                }
                ECFieldElement add5 = eCFieldElement11.square().add(eCFieldElement2).add(eCFieldElement4);
                if (add5.isZero()) {
                    return new F2m(eCCurve, add5, eCCurve.f6255b.sqrt(), this.withCompression);
                }
                ECFieldElement square3 = add5.square();
                if (isOne2) {
                    eCFieldElement5 = add5;
                } else {
                    eCFieldElement5 = add5.multiply(eCFieldElement3);
                }
                ECFieldElement eCFieldElement14 = eCCurve.f6255b;
                ECCurve eCCurve5 = eCCurve;
                if (eCFieldElement14.bitLength() < (eCCurve.getFieldSize() >> 1)) {
                    ECFieldElement square4 = eCFieldElement11.add(eCFieldElement8).square();
                    if (eCFieldElement14.isOne()) {
                        eCFieldElement7 = eCFieldElement4.add(eCFieldElement3).square();
                    } else {
                        eCFieldElement7 = eCFieldElement4.squarePlusProduct(eCFieldElement14, eCFieldElement3.square());
                    }
                    eCFieldElement6 = square4.add(add5).add(eCFieldElement3).multiply(square4).add(eCFieldElement7).add(square3);
                    if (eCFieldElement13.isZero()) {
                        eCFieldElement6 = eCFieldElement6.add(eCFieldElement5);
                    } else if (!eCFieldElement13.isOne()) {
                        eCFieldElement6 = eCFieldElement6.add(eCFieldElement13.addOne().multiply(eCFieldElement5));
                    }
                } else {
                    if (!isOne2) {
                        eCFieldElement8 = eCFieldElement8.multiply(eCFieldElement12);
                    }
                    eCFieldElement6 = eCFieldElement8.squarePlusProduct(add5, eCFieldElement2).add(square3).add(eCFieldElement5);
                }
                ECCurve eCCurve6 = eCCurve5;
                ECFieldElement eCFieldElement15 = square3;
                ECFieldElement eCFieldElement16 = eCFieldElement6;
                F2m f2m2 = new F2m(eCCurve6, eCFieldElement15, eCFieldElement16, new ECFieldElement[]{eCFieldElement5}, this.withCompression);
                return f2m2;
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
            this.withCompression = z;
        }
    }

    public static class Fp extends AbstractFp {
        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            boolean z2 = true;
            if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : z2)) {
                this.withCompression = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
            if (r1 == r6) goto L_0x0122;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.spongycastle.math.ec.ECPoint add(org.spongycastle.math.ec.ECPoint r17) {
            /*
                r16 = this;
                r0 = r16
                r1 = r17
                boolean r2 = r16.isInfinity()
                if (r2 == 0) goto L_0x000b
                return r1
            L_0x000b:
                boolean r2 = r17.isInfinity()
                if (r2 == 0) goto L_0x0012
                return r0
            L_0x0012:
                if (r0 != r1) goto L_0x0019
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x0019:
                org.spongycastle.math.ec.ECCurve r3 = r0.curve
                int r2 = r3.coord
                org.spongycastle.math.ec.ECFieldElement r4 = r0.x
                org.spongycastle.math.ec.ECFieldElement r5 = r0.y
                org.spongycastle.math.ec.ECFieldElement r6 = r1.x
                org.spongycastle.math.ec.ECFieldElement r7 = r1.y
                if (r2 == 0) goto L_0x01da
                r8 = 1
                r9 = 0
                if (r2 == r8) goto L_0x0142
                r10 = 4
                r11 = 2
                if (r2 == r11) goto L_0x003b
                if (r2 != r10) goto L_0x0032
                goto L_0x003b
            L_0x0032:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "unsupported coordinate system"
                r1.<init>(r2)
                throw r1
            L_0x003b:
                org.spongycastle.math.ec.ECFieldElement[] r12 = r0.zs
                r12 = r12[r9]
                org.spongycastle.math.ec.ECFieldElement[] r1 = r1.zs
                r1 = r1[r9]
                boolean r13 = r12.isOne()
                if (r13 != 0) goto L_0x00a2
                boolean r15 = r12.equals(r1)
                if (r15 == 0) goto L_0x00a2
                org.spongycastle.math.ec.ECFieldElement r1 = r4.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r7 = r5.subtract(r7)
                boolean r13 = r1.isZero()
                if (r13 == 0) goto L_0x006d
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x0068
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x0068:
                org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
                return r1
            L_0x006d:
                org.spongycastle.math.ec.ECFieldElement r13 = r1.square()
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiply(r13)
                org.spongycastle.math.ec.ECFieldElement r6 = r6.multiply(r13)
                org.spongycastle.math.ec.ECFieldElement r13 = r4.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r5 = r13.multiply(r5)
                org.spongycastle.math.ec.ECFieldElement r13 = r7.square()
                org.spongycastle.math.ec.ECFieldElement r13 = r13.subtract(r4)
                org.spongycastle.math.ec.ECFieldElement r6 = r13.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiply(r7)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r5)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.multiply(r12)
                r5 = r4
                r4 = r6
            L_0x009f:
                r14 = 0
                goto L_0x0122
            L_0x00a2:
                if (r13 == 0) goto L_0x00a5
                goto L_0x00b5
            L_0x00a5:
                org.spongycastle.math.ec.ECFieldElement r15 = r12.square()
                org.spongycastle.math.ec.ECFieldElement r6 = r15.multiply(r6)
                org.spongycastle.math.ec.ECFieldElement r15 = r15.multiply(r12)
                org.spongycastle.math.ec.ECFieldElement r7 = r15.multiply(r7)
            L_0x00b5:
                boolean r15 = r1.isOne()
                if (r15 == 0) goto L_0x00bc
                goto L_0x00cc
            L_0x00bc:
                org.spongycastle.math.ec.ECFieldElement r14 = r1.square()
                org.spongycastle.math.ec.ECFieldElement r4 = r14.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r14 = r14.multiply(r1)
                org.spongycastle.math.ec.ECFieldElement r5 = r14.multiply(r5)
            L_0x00cc:
                org.spongycastle.math.ec.ECFieldElement r6 = r4.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r7 = r5.subtract(r7)
                boolean r14 = r6.isZero()
                if (r14 == 0) goto L_0x00ea
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x00e5
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x00e5:
                org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
                return r1
            L_0x00ea:
                org.spongycastle.math.ec.ECFieldElement r14 = r6.square()
                org.spongycastle.math.ec.ECFieldElement r8 = r14.multiply(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r14.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r9 = r7.square()
                org.spongycastle.math.ec.ECFieldElement r9 = r9.add(r8)
                org.spongycastle.math.ec.ECFieldElement r11 = r4.add(r4)
                org.spongycastle.math.ec.ECFieldElement r9 = r9.subtract(r11)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r9)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiplyMinusProduct(r7, r8, r5)
                if (r13 != 0) goto L_0x0115
                org.spongycastle.math.ec.ECFieldElement r5 = r6.multiply(r12)
                goto L_0x0116
            L_0x0115:
                r5 = r6
            L_0x0116:
                if (r15 != 0) goto L_0x011d
                org.spongycastle.math.ec.ECFieldElement r1 = r5.multiply(r1)
                goto L_0x011e
            L_0x011d:
                r1 = r5
            L_0x011e:
                r5 = r4
                r4 = r9
                if (r1 != r6) goto L_0x009f
            L_0x0122:
                if (r2 != r10) goto L_0x0132
                org.spongycastle.math.ec.ECFieldElement r2 = r0.calculateJacobianModifiedW(r1, r14)
                r6 = 2
                org.spongycastle.math.ec.ECFieldElement[] r6 = new org.spongycastle.math.ec.ECFieldElement[r6]
                r7 = 0
                r6[r7] = r1
                r8 = 1
                r6[r8] = r2
                goto L_0x0139
            L_0x0132:
                r7 = 0
                r8 = 1
                org.spongycastle.math.ec.ECFieldElement[] r2 = new org.spongycastle.math.ec.ECFieldElement[r8]
                r2[r7] = r1
                r6 = r2
            L_0x0139:
                org.spongycastle.math.ec.ECPoint$Fp r1 = new org.spongycastle.math.ec.ECPoint$Fp
                boolean r7 = r0.withCompression
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                return r1
            L_0x0142:
                org.spongycastle.math.ec.ECFieldElement[] r2 = r0.zs
                r8 = 0
                r2 = r2[r8]
                org.spongycastle.math.ec.ECFieldElement[] r1 = r1.zs
                r1 = r1[r8]
                boolean r8 = r2.isOne()
                boolean r9 = r1.isOne()
                if (r8 == 0) goto L_0x0156
                goto L_0x015a
            L_0x0156:
                org.spongycastle.math.ec.ECFieldElement r7 = r7.multiply(r2)
            L_0x015a:
                if (r9 == 0) goto L_0x015d
                goto L_0x0161
            L_0x015d:
                org.spongycastle.math.ec.ECFieldElement r5 = r5.multiply(r1)
            L_0x0161:
                org.spongycastle.math.ec.ECFieldElement r7 = r7.subtract(r5)
                if (r8 == 0) goto L_0x0168
                goto L_0x016c
            L_0x0168:
                org.spongycastle.math.ec.ECFieldElement r6 = r6.multiply(r2)
            L_0x016c:
                if (r9 == 0) goto L_0x016f
                goto L_0x0173
            L_0x016f:
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiply(r1)
            L_0x0173:
                org.spongycastle.math.ec.ECFieldElement r6 = r6.subtract(r4)
                boolean r10 = r6.isZero()
                if (r10 == 0) goto L_0x018d
                boolean r1 = r7.isZero()
                if (r1 == 0) goto L_0x0188
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x0188:
                org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
                return r1
            L_0x018d:
                if (r8 == 0) goto L_0x0191
                r2 = r1
                goto L_0x0198
            L_0x0191:
                if (r9 == 0) goto L_0x0194
                goto L_0x0198
            L_0x0194:
                org.spongycastle.math.ec.ECFieldElement r2 = r2.multiply(r1)
            L_0x0198:
                org.spongycastle.math.ec.ECFieldElement r1 = r6.square()
                org.spongycastle.math.ec.ECFieldElement r8 = r1.multiply(r6)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r4 = r7.square()
                org.spongycastle.math.ec.ECFieldElement r4 = r4.multiply(r2)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r8)
                org.spongycastle.math.ec.ECFieldElement r9 = r1.add(r1)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r9)
                org.spongycastle.math.ec.ECFieldElement r6 = r6.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.subtract(r4)
                org.spongycastle.math.ec.ECFieldElement r5 = r1.multiplyMinusProduct(r7, r5, r8)
                org.spongycastle.math.ec.ECFieldElement r1 = r8.multiply(r2)
                org.spongycastle.math.ec.ECPoint$Fp r8 = new org.spongycastle.math.ec.ECPoint$Fp
                r2 = 1
                org.spongycastle.math.ec.ECFieldElement[] r7 = new org.spongycastle.math.ec.ECFieldElement[r2]
                r2 = 0
                r7[r2] = r1
                boolean r1 = r0.withCompression
                r2 = r8
                r4 = r6
                r6 = r7
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                return r8
            L_0x01da:
                org.spongycastle.math.ec.ECFieldElement r1 = r6.subtract(r4)
                org.spongycastle.math.ec.ECFieldElement r2 = r7.subtract(r5)
                boolean r7 = r1.isZero()
                if (r7 == 0) goto L_0x01f8
                boolean r1 = r2.isZero()
                if (r1 == 0) goto L_0x01f3
                org.spongycastle.math.ec.ECPoint r1 = r16.twice()
                return r1
            L_0x01f3:
                org.spongycastle.math.ec.ECPoint r1 = r3.getInfinity()
                return r1
            L_0x01f8:
                org.spongycastle.math.ec.ECFieldElement r1 = r2.divide(r1)
                org.spongycastle.math.ec.ECFieldElement r2 = r1.square()
                org.spongycastle.math.ec.ECFieldElement r2 = r2.subtract(r4)
                org.spongycastle.math.ec.ECFieldElement r2 = r2.subtract(r6)
                org.spongycastle.math.ec.ECFieldElement r4 = r4.subtract(r2)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.multiply(r4)
                org.spongycastle.math.ec.ECFieldElement r1 = r1.subtract(r5)
                org.spongycastle.math.ec.ECPoint$Fp r4 = new org.spongycastle.math.ec.ECPoint$Fp
                boolean r5 = r0.withCompression
                r4.<init>(r3, r2, r1, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.ECPoint.Fp.add(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
        }

        public ECFieldElement calculateJacobianModifiedW(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4 = this.curve.f6254a;
            if (eCFieldElement4.isZero() || eCFieldElement.isOne()) {
                return eCFieldElement4;
            }
            if (eCFieldElement2 == null) {
                eCFieldElement2 = eCFieldElement.square();
            }
            ECFieldElement square = eCFieldElement2.square();
            ECFieldElement negate = eCFieldElement4.negate();
            if (negate.bitLength() < eCFieldElement4.bitLength()) {
                eCFieldElement3 = square.multiply(negate).negate();
            } else {
                eCFieldElement3 = square.multiply(eCFieldElement4);
            }
            return eCFieldElement3;
        }

        public ECFieldElement four(ECFieldElement eCFieldElement) {
            ECFieldElement add = eCFieldElement.add(eCFieldElement);
            return add.add(add);
        }

        public ECFieldElement getJacobianModifiedW() {
            ECFieldElement[] eCFieldElementArr = this.zs;
            ECFieldElement eCFieldElement = eCFieldElementArr[1];
            if (eCFieldElement != null) {
                return eCFieldElement;
            }
            ECFieldElement calculateJacobianModifiedW = calculateJacobianModifiedW(eCFieldElementArr[0], null);
            eCFieldElementArr[1] = calculateJacobianModifiedW;
            return calculateJacobianModifiedW;
        }

        public ECFieldElement getZCoord(int i) {
            if (i == 1 && 4 == getCurveCoordinateSystem()) {
                return getJacobianModifiedW();
            }
            return ECPoint.super.getZCoord(i);
        }

        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECCurve eCCurve = this.curve;
            if (eCCurve.coord == 0) {
                return new Fp(eCCurve, this.x, this.y.negate(), this.withCompression);
            }
            Fp fp = new Fp(eCCurve, this.x, this.y.negate(), this.zs, this.withCompression);
            return fp;
        }

        public ECFieldElement three(ECFieldElement eCFieldElement) {
            return eCFieldElement.add(eCFieldElement).add(eCFieldElement);
        }

        public ECPoint twice() {
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            ECFieldElement eCFieldElement4;
            ECFieldElement eCFieldElement5;
            if (isInfinity()) {
                return this;
            }
            ECCurve eCCurve = this.curve;
            ECFieldElement eCFieldElement6 = this.y;
            if (eCFieldElement6.isZero()) {
                return eCCurve.getInfinity();
            }
            int i = eCCurve.coord;
            ECFieldElement eCFieldElement7 = this.x;
            if (i == 0) {
                ECFieldElement divide = three(eCFieldElement7.square()).add(this.curve.f6254a).divide(eCFieldElement6.add(eCFieldElement6));
                ECFieldElement subtract = divide.square().subtract(eCFieldElement7.add(eCFieldElement7));
                return new Fp(eCCurve, subtract, divide.multiply(eCFieldElement7.subtract(subtract)).subtract(eCFieldElement6), this.withCompression);
            } else if (i == 1) {
                ECFieldElement eCFieldElement8 = this.zs[0];
                boolean isOne = eCFieldElement8.isOne();
                ECFieldElement eCFieldElement9 = eCCurve.f6254a;
                if (!eCFieldElement9.isZero() && !isOne) {
                    eCFieldElement9 = eCFieldElement9.multiply(eCFieldElement8.square());
                }
                ECFieldElement add = eCFieldElement9.add(three(eCFieldElement7.square()));
                if (isOne) {
                    eCFieldElement = eCFieldElement6;
                } else {
                    eCFieldElement = eCFieldElement6.multiply(eCFieldElement8);
                }
                ECFieldElement square = isOne ? eCFieldElement6.square() : eCFieldElement.multiply(eCFieldElement6);
                ECFieldElement four = four(eCFieldElement7.multiply(square));
                ECFieldElement subtract2 = add.square().subtract(four.add(four));
                ECFieldElement add2 = eCFieldElement.add(eCFieldElement);
                ECFieldElement multiply = subtract2.multiply(add2);
                ECFieldElement add3 = square.add(square);
                ECFieldElement multiply2 = four.subtract(subtract2).multiply(add);
                ECFieldElement square2 = add3.square();
                ECFieldElement subtract3 = multiply2.subtract(square2.add(square2));
                if (isOne) {
                    eCFieldElement2 = add3.add(add3);
                } else {
                    eCFieldElement2 = add2.square();
                }
                Fp fp = new Fp(eCCurve, multiply, subtract3, new ECFieldElement[]{eCFieldElement2.add(eCFieldElement2).multiply(eCFieldElement)}, this.withCompression);
                return fp;
            } else if (i == 2) {
                ECFieldElement eCFieldElement10 = this.zs[0];
                boolean isOne2 = eCFieldElement10.isOne();
                ECFieldElement square3 = eCFieldElement6.square();
                ECFieldElement square4 = square3.square();
                ECFieldElement eCFieldElement11 = eCCurve.f6254a;
                ECFieldElement negate = eCFieldElement11.negate();
                if (negate.toBigInteger().equals(BigInteger.valueOf(3))) {
                    if (isOne2) {
                        eCFieldElement5 = eCFieldElement10;
                    } else {
                        eCFieldElement5 = eCFieldElement10.square();
                    }
                    eCFieldElement3 = three(eCFieldElement7.add(eCFieldElement5).multiply(eCFieldElement7.subtract(eCFieldElement5)));
                    eCFieldElement4 = four(square3.multiply(eCFieldElement7));
                } else {
                    ECFieldElement three = three(eCFieldElement7.square());
                    if (isOne2) {
                        eCFieldElement3 = three.add(eCFieldElement11);
                    } else if (!eCFieldElement11.isZero()) {
                        ECFieldElement square5 = eCFieldElement10.square().square();
                        eCFieldElement3 = negate.bitLength() < eCFieldElement11.bitLength() ? three.subtract(square5.multiply(negate)) : three.add(square5.multiply(eCFieldElement11));
                    } else {
                        eCFieldElement3 = three;
                    }
                    eCFieldElement4 = four(eCFieldElement7.multiply(square3));
                }
                ECFieldElement subtract4 = eCFieldElement3.square().subtract(eCFieldElement4.add(eCFieldElement4));
                ECFieldElement subtract5 = eCFieldElement4.subtract(subtract4).multiply(eCFieldElement3).subtract(four(square4.add(square4)));
                ECFieldElement add4 = eCFieldElement6.add(eCFieldElement6);
                if (!isOne2) {
                    add4 = add4.multiply(eCFieldElement10);
                }
                Fp fp2 = new Fp(eCCurve, subtract4, subtract5, new ECFieldElement[]{add4}, this.withCompression);
                return fp2;
            } else if (i == 4) {
                ECFieldElement eCFieldElement12 = this.y;
                ECFieldElement eCFieldElement13 = this.zs[0];
                ECFieldElement jacobianModifiedW = getJacobianModifiedW();
                ECFieldElement add5 = three(eCFieldElement7.square()).add(jacobianModifiedW);
                ECFieldElement add6 = eCFieldElement12.add(eCFieldElement12);
                ECFieldElement multiply3 = add6.multiply(eCFieldElement12);
                ECFieldElement multiply4 = eCFieldElement7.multiply(multiply3);
                ECFieldElement add7 = multiply4.add(multiply4);
                ECFieldElement subtract6 = add5.square().subtract(add7.add(add7));
                ECFieldElement square6 = multiply3.square();
                ECFieldElement add8 = square6.add(square6);
                ECFieldElement subtract7 = add5.multiply(add7.subtract(subtract6)).subtract(add8);
                ECFieldElement multiply5 = add8.multiply(jacobianModifiedW);
                ECFieldElement add9 = multiply5.add(multiply5);
                if (!eCFieldElement13.isOne()) {
                    add6 = add6.multiply(eCFieldElement13);
                }
                Fp fp3 = new Fp(this.curve, subtract6, subtract7, new ECFieldElement[]{add6, add9}, this.withCompression);
                return fp3;
            } else {
                throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
            this.withCompression = z;
        }
    }

    public ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        this.curve = eCCurve;
        this.x = eCFieldElement;
        this.y = eCFieldElement2;
        this.zs = eCFieldElementArr;
    }

    public abstract ECPoint add(ECPoint eCPoint);

    public ECPoint createScaledPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return this.curve.createRawPoint(this.x.multiply(eCFieldElement), this.y.multiply(eCFieldElement2), this.withCompression);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ff, code lost:
        if (r1.getYCoord().equals(r12.getYCoord()) != false) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x010e, code lost:
        if (r1.equals(r3) != false) goto L_0x0112;
     */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r12) {
        /*
            r11 = this;
            r0 = 1
            if (r12 != r11) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r12 instanceof org.spongycastle.math.ec.ECPoint
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            org.spongycastle.math.ec.ECPoint r12 = (org.spongycastle.math.ec.ECPoint) r12
            if (r12 != 0) goto L_0x0010
            goto L_0x0113
        L_0x0010:
            org.spongycastle.math.ec.ECCurve r1 = r11.curve
            org.spongycastle.math.ec.ECCurve r3 = r12.curve
            if (r1 != 0) goto L_0x0018
            r4 = 1
            goto L_0x0019
        L_0x0018:
            r4 = 0
        L_0x0019:
            if (r3 != 0) goto L_0x001d
            r5 = 1
            goto L_0x001e
        L_0x001d:
            r5 = 0
        L_0x001e:
            boolean r6 = r11.isInfinity()
            boolean r7 = r12.isInfinity()
            if (r6 != 0) goto L_0x0102
            if (r7 == 0) goto L_0x002c
            goto L_0x0102
        L_0x002c:
            if (r4 == 0) goto L_0x0031
            if (r5 == 0) goto L_0x0031
            goto L_0x0037
        L_0x0031:
            if (r4 == 0) goto L_0x003a
            org.spongycastle.math.ec.ECPoint r12 = r12.normalize()
        L_0x0037:
            r1 = r11
            goto L_0x00e9
        L_0x003a:
            if (r5 == 0) goto L_0x0042
            org.spongycastle.math.ec.ECPoint r1 = r11.normalize()
            goto L_0x00e9
        L_0x0042:
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x004a
            goto L_0x0113
        L_0x004a:
            r3 = 2
            org.spongycastle.math.ec.ECPoint[] r4 = new org.spongycastle.math.ec.ECPoint[r3]
            r4[r2] = r11
            org.spongycastle.math.ec.ECPoint r12 = r1.importPoint(r12)
            r4[r0] = r12
            r12 = 0
        L_0x0056:
            if (r12 >= r3) goto L_0x006e
            int r5 = r2 + r12
            r5 = r4[r5]
            if (r5 == 0) goto L_0x006b
            org.spongycastle.math.ec.ECCurve r5 = r5.curve
            if (r1 != r5) goto L_0x0063
            goto L_0x006b
        L_0x0063:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "'points' entries must be null or on this curve"
            r12.<init>(r0)
            throw r12
        L_0x006b:
            int r12 = r12 + 1
            goto L_0x0056
        L_0x006e:
            int r12 = r1.coord
            if (r12 == 0) goto L_0x00e5
            r1 = 5
            if (r12 == r1) goto L_0x00e5
            org.spongycastle.math.ec.ECFieldElement[] r12 = new org.spongycastle.math.ec.ECFieldElement[r3]
            int[] r1 = new int[r3]
            r5 = 0
            r6 = 0
        L_0x007b:
            if (r5 >= r3) goto L_0x0097
            int r7 = r2 + r5
            r8 = r4[r7]
            if (r8 == 0) goto L_0x0094
            boolean r9 = r8.isNormalized()
            if (r9 != 0) goto L_0x0094
            org.spongycastle.math.ec.ECFieldElement r8 = r8.getZCoord(r2)
            r12[r6] = r8
            int r8 = r6 + 1
            r1[r6] = r7
            r6 = r8
        L_0x0094:
            int r5 = r5 + 1
            goto L_0x007b
        L_0x0097:
            if (r6 != 0) goto L_0x009a
            goto L_0x00e5
        L_0x009a:
            org.spongycastle.math.ec.ECFieldElement[] r3 = new org.spongycastle.math.ec.ECFieldElement[r6]
            r5 = r12[r2]
            r3[r2] = r5
            r5 = 0
        L_0x00a1:
            int r5 = r5 + r0
            if (r5 >= r6) goto L_0x00b3
            int r7 = r5 + -1
            r7 = r3[r7]
            int r8 = r2 + r5
            r8 = r12[r8]
            org.spongycastle.math.ec.ECFieldElement r7 = r7.multiply(r8)
            r3[r5] = r7
            goto L_0x00a1
        L_0x00b3:
            int r5 = r5 + -1
            r7 = r3[r5]
            org.spongycastle.math.ec.ECFieldElement r7 = r7.invert()
        L_0x00bb:
            if (r5 <= 0) goto L_0x00d1
            int r8 = r5 + -1
            int r5 = r5 + 0
            r9 = r12[r5]
            r10 = r3[r8]
            org.spongycastle.math.ec.ECFieldElement r10 = r10.multiply(r7)
            r12[r5] = r10
            org.spongycastle.math.ec.ECFieldElement r7 = r7.multiply(r9)
            r5 = r8
            goto L_0x00bb
        L_0x00d1:
            r12[r2] = r7
            r3 = 0
        L_0x00d4:
            if (r3 >= r6) goto L_0x00e5
            r5 = r1[r3]
            r7 = r4[r5]
            r8 = r12[r3]
            org.spongycastle.math.ec.ECPoint r7 = r7.normalize(r8)
            r4[r5] = r7
            int r3 = r3 + 1
            goto L_0x00d4
        L_0x00e5:
            r1 = r4[r2]
            r12 = r4[r0]
        L_0x00e9:
            org.spongycastle.math.ec.ECFieldElement r3 = r1.x
            org.spongycastle.math.ec.ECFieldElement r4 = r12.x
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0111
            org.spongycastle.math.ec.ECFieldElement r1 = r1.getYCoord()
            org.spongycastle.math.ec.ECFieldElement r12 = r12.getYCoord()
            boolean r12 = r1.equals(r12)
            if (r12 == 0) goto L_0x0111
            goto L_0x0112
        L_0x0102:
            if (r6 == 0) goto L_0x0111
            if (r7 == 0) goto L_0x0111
            if (r4 != 0) goto L_0x0112
            if (r5 != 0) goto L_0x0112
            boolean r12 = r1.equals(r3)
            if (r12 == 0) goto L_0x0111
            goto L_0x0112
        L_0x0111:
            r0 = 0
        L_0x0112:
            r2 = r0
        L_0x0113:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.ECPoint.equals(java.lang.Object):boolean");
    }

    public int getCurveCoordinateSystem() {
        ECCurve eCCurve = this.curve;
        if (eCCurve == null) {
            return 0;
        }
        return eCCurve.coord;
    }

    public ECFieldElement getYCoord() {
        return this.y;
    }

    public ECFieldElement getZCoord(int i) {
        if (i >= 0) {
            ECFieldElement[] eCFieldElementArr = this.zs;
            if (i < eCFieldElementArr.length) {
                return eCFieldElementArr[i];
            }
        }
        return null;
    }

    public int hashCode() {
        int i;
        ECCurve eCCurve = this.curve;
        if (eCCurve == null) {
            i = 0;
        } else {
            i = ~eCCurve.hashCode();
        }
        if (isInfinity()) {
            return i;
        }
        ECPoint normalize = normalize();
        return (i ^ (normalize.x.hashCode() * 17)) ^ (normalize.getYCoord().hashCode() * FTPReply.PATHNAME_CREATED);
    }

    public boolean isInfinity() {
        if (!(this.x == null || this.y == null)) {
            ECFieldElement[] eCFieldElementArr = this.zs;
            if (eCFieldElementArr.length <= 0 || !eCFieldElementArr[0].isZero()) {
                return false;
            }
        }
        return true;
    }

    public boolean isNormalized() {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        if (curveCoordinateSystem == 0 || curveCoordinateSystem == 5 || isInfinity() || this.zs[0].isOne()) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        if (!isInfinity() && this.curve != null && (!satisfiesCurveEquation() || !satisfiesCofactor())) {
            return false;
        }
        return true;
    }

    public abstract ECPoint negate();

    public ECPoint normalize() {
        if (isInfinity()) {
            return this;
        }
        int curveCoordinateSystem = getCurveCoordinateSystem();
        if (curveCoordinateSystem == 0 || curveCoordinateSystem == 5) {
            return this;
        }
        ECFieldElement zCoord = getZCoord(0);
        if (zCoord.isOne()) {
            return this;
        }
        return normalize(zCoord.invert());
    }

    public boolean satisfiesCofactor() {
        BigInteger bigInteger = this.curve.cofactor;
        if (bigInteger != null && !bigInteger.equals(ECConstants.ONE)) {
            BigInteger abs = bigInteger.abs();
            ECPoint infinity = this.curve.getInfinity();
            int bitLength = abs.bitLength();
            if (bitLength > 0) {
                if (abs.testBit(0)) {
                    infinity = this;
                }
                ECPoint eCPoint = this;
                for (int i = 1; i < bitLength; i++) {
                    eCPoint = eCPoint.twice();
                    if (abs.testBit(i)) {
                        infinity = infinity.add(eCPoint);
                    }
                }
            }
            if (bigInteger.signum() < 0) {
                infinity = infinity.negate();
            }
            if (infinity.isInfinity()) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean satisfiesCurveEquation();

    public String toString() {
        if (isInfinity()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(this.x);
        stringBuffer.append(',');
        stringBuffer.append(this.y);
        for (ECFieldElement append : this.zs) {
            stringBuffer.append(',');
            stringBuffer.append(append);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public abstract ECPoint twice();

    public ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        ECFieldElement[] eCFieldElementArr;
        int i = eCCurve == null ? 0 : eCCurve.coord;
        if (i == 0 || i == 5) {
            eCFieldElementArr = EMPTY_ZS;
        } else {
            ECFieldElement fromBigInteger = eCCurve.fromBigInteger(ECConstants.ONE);
            if (!(i == 1 || i == 2)) {
                if (i == 3) {
                    eCFieldElementArr = new ECFieldElement[]{fromBigInteger, fromBigInteger, fromBigInteger};
                } else if (i == 4) {
                    eCFieldElementArr = new ECFieldElement[]{fromBigInteger, eCCurve.f6254a};
                } else if (i != 6) {
                    throw new IllegalArgumentException("unknown coordinate system");
                }
            }
            eCFieldElementArr = new ECFieldElement[]{fromBigInteger};
        }
        this.curve = eCCurve;
        this.x = eCFieldElement;
        this.y = eCFieldElement2;
        this.zs = eCFieldElementArr;
    }

    public ECPoint normalize(ECFieldElement eCFieldElement) {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        if (curveCoordinateSystem != 1) {
            if (curveCoordinateSystem == 2 || curveCoordinateSystem == 3 || curveCoordinateSystem == 4) {
                ECFieldElement square = eCFieldElement.square();
                return createScaledPoint(square, square.multiply(eCFieldElement));
            } else if (curveCoordinateSystem != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return createScaledPoint(eCFieldElement, eCFieldElement);
    }
}
