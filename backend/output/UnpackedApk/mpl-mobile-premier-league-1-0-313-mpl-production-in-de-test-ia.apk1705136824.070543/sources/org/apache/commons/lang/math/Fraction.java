package org.apache.commons.lang.math;

import java.math.BigInteger;

public final class Fraction extends Number implements Comparable {
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final long serialVersionUID = 65382027393090L;
    public final int denominator;
    public transient int hashCode = 0;
    public final int numerator;
    public transient String toProperString = null;
    public transient String toString = null;

    public Fraction(int i, int i2) {
        this.numerator = i;
        this.denominator = i2;
    }

    public static int addAndCheck(int i, int i2) {
        long j = ((long) i) + ((long) i2);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: add");
    }

    private Fraction addSub(Fraction fraction, boolean z) {
        int i;
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        } else if (this.numerator == 0) {
            if (!z) {
                fraction = fraction.negate();
            }
            return fraction;
        } else if (fraction.numerator == 0) {
            return this;
        } else {
            int greatestCommonDivisor = greatestCommonDivisor(this.denominator, fraction.denominator);
            if (greatestCommonDivisor == 1) {
                int mulAndCheck = mulAndCheck(this.numerator, fraction.denominator);
                int mulAndCheck2 = mulAndCheck(fraction.numerator, this.denominator);
                return new Fraction(z ? addAndCheck(mulAndCheck, mulAndCheck2) : subAndCheck(mulAndCheck, mulAndCheck2), mulPosAndCheck(this.denominator, fraction.denominator));
            }
            BigInteger multiply = BigInteger.valueOf((long) this.numerator).multiply(BigInteger.valueOf((long) (fraction.denominator / greatestCommonDivisor)));
            BigInteger multiply2 = BigInteger.valueOf((long) fraction.numerator).multiply(BigInteger.valueOf((long) (this.denominator / greatestCommonDivisor)));
            BigInteger add = z ? multiply.add(multiply2) : multiply.subtract(multiply2);
            int intValue = add.mod(BigInteger.valueOf((long) greatestCommonDivisor)).intValue();
            if (intValue == 0) {
                i = greatestCommonDivisor;
            } else {
                i = greatestCommonDivisor(intValue, greatestCommonDivisor);
            }
            BigInteger divide = add.divide(BigInteger.valueOf((long) i));
            if (divide.bitLength() <= 31) {
                return new Fraction(divide.intValue(), mulPosAndCheck(this.denominator / greatestCommonDivisor, fraction.denominator / i));
            }
            throw new ArithmeticException("overflow: numerator too large after multiply");
        }
    }

    public static Fraction getFraction(int i, int i2) {
        if (i2 != 0) {
            if (i2 < 0) {
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i = -i;
                i2 = -i2;
            }
            return new Fraction(i, i2);
        }
        throw new ArithmeticException("The denominator must not be zero");
    }

    public static Fraction getReducedFraction(int i, int i2) {
        if (i2 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        } else if (i == 0) {
            return ZERO;
        } else {
            if (i2 == Integer.MIN_VALUE && (i & 1) == 0) {
                i /= 2;
                i2 /= 2;
            }
            if (i2 < 0) {
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i = -i;
                i2 = -i2;
            }
            int greatestCommonDivisor = greatestCommonDivisor(i, i2);
            return new Fraction(i / greatestCommonDivisor, i2 / greatestCommonDivisor);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int greatestCommonDivisor(int r5, int r6) {
        /*
            int r0 = java.lang.Math.abs(r5)
            r1 = 1
            if (r0 <= r1) goto L_0x0051
            int r0 = java.lang.Math.abs(r6)
            if (r0 > r1) goto L_0x000e
            goto L_0x0051
        L_0x000e:
            if (r5 <= 0) goto L_0x0011
            int r5 = -r5
        L_0x0011:
            if (r6 <= 0) goto L_0x0014
            int r6 = -r6
        L_0x0014:
            r0 = 0
        L_0x0015:
            r2 = r5 & 1
            r3 = 31
            if (r2 != 0) goto L_0x0028
            r4 = r6 & 1
            if (r4 != 0) goto L_0x0028
            if (r0 >= r3) goto L_0x0028
            int r5 = r5 / 2
            int r6 = r6 / 2
            int r0 = r0 + 1
            goto L_0x0015
        L_0x0028:
            if (r0 == r3) goto L_0x0049
            if (r2 != r1) goto L_0x002e
            r2 = r6
            goto L_0x0031
        L_0x002e:
            int r2 = r5 / 2
            int r2 = -r2
        L_0x0031:
            r3 = r2 & 1
            if (r3 != 0) goto L_0x0038
            int r2 = r2 / 2
            goto L_0x0031
        L_0x0038:
            if (r2 <= 0) goto L_0x003c
            int r5 = -r2
            goto L_0x003d
        L_0x003c:
            r6 = r2
        L_0x003d:
            int r2 = r6 - r5
            int r2 = r2 / 2
            if (r2 != 0) goto L_0x0031
            int r5 = -r5
            int r6 = r1 << r0
            int r5 = r5 * r6
            return r5
        L_0x0049:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "overflow: gcd is 2^31"
            r5.<init>(r6)
            throw r5
        L_0x0051:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang.math.Fraction.greatestCommonDivisor(int, int):int");
    }

    public static int mulAndCheck(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: mul");
    }

    public static int mulPosAndCheck(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: mulPos");
    }

    public static int subAndCheck(int i, int i2) {
        long j = ((long) i) - ((long) i2);
        if (j >= -2147483648L && j <= 2147483647L) {
            return (int) j;
        }
        throw new ArithmeticException("overflow: add");
    }

    public Fraction abs() {
        if (this.numerator >= 0) {
            return this;
        }
        return negate();
    }

    public Fraction add(Fraction fraction) {
        return addSub(fraction, true);
    }

    public int compareTo(Object obj) {
        Fraction fraction = (Fraction) obj;
        if (this == fraction) {
            return 0;
        }
        if (this.numerator == fraction.numerator && this.denominator == fraction.denominator) {
            return 0;
        }
        int i = ((((long) this.numerator) * ((long) fraction.denominator)) > (((long) fraction.numerator) * ((long) this.denominator)) ? 1 : ((((long) this.numerator) * ((long) fraction.denominator)) == (((long) fraction.numerator) * ((long) this.denominator)) ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        return i < 0 ? -1 : 1;
    }

    public Fraction divideBy(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        } else if (fraction.numerator != 0) {
            return multiplyBy(fraction.invert());
        } else {
            throw new ArithmeticException("The fraction to divide by must not be zero");
        }
    }

    public double doubleValue() {
        return ((double) this.numerator) / ((double) this.denominator);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        if (!(getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator())) {
            z = false;
        }
        return z;
    }

    public float floatValue() {
        return ((float) this.numerator) / ((float) this.denominator);
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getProperNumerator() {
        return Math.abs(this.numerator % this.denominator);
    }

    public int getProperWhole() {
        return this.numerator / this.denominator;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = getDenominator() + ((getNumerator() + 629) * 37);
        }
        return this.hashCode;
    }

    public int intValue() {
        return this.numerator / this.denominator;
    }

    public Fraction invert() {
        int i = this.numerator;
        if (i == 0) {
            throw new ArithmeticException("Unable to invert zero.");
        } else if (i == Integer.MIN_VALUE) {
            throw new ArithmeticException("overflow: can't negate numerator");
        } else if (i < 0) {
            return new Fraction(-this.denominator, -i);
        } else {
            return new Fraction(this.denominator, i);
        }
    }

    public long longValue() {
        return ((long) this.numerator) / ((long) this.denominator);
    }

    public Fraction multiplyBy(Fraction fraction) {
        if (fraction != null) {
            int i = this.numerator;
            if (i == 0 || fraction.numerator == 0) {
                return ZERO;
            }
            int greatestCommonDivisor = greatestCommonDivisor(i, fraction.denominator);
            int greatestCommonDivisor2 = greatestCommonDivisor(fraction.numerator, this.denominator);
            return getReducedFraction(mulAndCheck(this.numerator / greatestCommonDivisor, fraction.numerator / greatestCommonDivisor2), mulPosAndCheck(this.denominator / greatestCommonDivisor2, fraction.denominator / greatestCommonDivisor));
        }
        throw new IllegalArgumentException("The fraction must not be null");
    }

    public Fraction negate() {
        int i = this.numerator;
        if (i != Integer.MIN_VALUE) {
            return new Fraction(-i, this.denominator);
        }
        throw new ArithmeticException("overflow: too large to negate");
    }

    public Fraction pow(int i) {
        if (i == 1) {
            return this;
        }
        if (i == 0) {
            return ONE;
        }
        if (i >= 0) {
            Fraction multiplyBy = multiplyBy(this);
            if (i % 2 == 0) {
                return multiplyBy.pow(i / 2);
            }
            return multiplyBy.pow(i / 2).multiplyBy(this);
        } else if (i == Integer.MIN_VALUE) {
            return invert().pow(2).pow(-(i / 2));
        } else {
            return invert().pow(-i);
        }
    }

    public Fraction reduce() {
        int i = this.numerator;
        if (i == 0) {
            return equals(ZERO) ? this : ZERO;
        }
        int greatestCommonDivisor = greatestCommonDivisor(Math.abs(i), this.denominator);
        if (greatestCommonDivisor == 1) {
            return this;
        }
        return getFraction(this.numerator / greatestCommonDivisor, this.denominator / greatestCommonDivisor);
    }

    public Fraction subtract(Fraction fraction) {
        return addSub(fraction, false);
    }

    public String toProperString() {
        if (this.toProperString == null) {
            int i = this.numerator;
            if (i == 0) {
                this.toProperString = "0";
            } else {
                int i2 = this.denominator;
                if (i == i2) {
                    this.toProperString = "1";
                } else if (i == i2 * -1) {
                    this.toProperString = "-1";
                } else {
                    if (i > 0) {
                        i = -i;
                    }
                    if (i < (-this.denominator)) {
                        int properNumerator = getProperNumerator();
                        if (properNumerator == 0) {
                            this.toProperString = Integer.toString(getProperWhole());
                        } else {
                            StringBuffer stringBuffer = new StringBuffer(32);
                            stringBuffer.append(getProperWhole());
                            stringBuffer.append(' ');
                            stringBuffer.append(properNumerator);
                            stringBuffer.append('/');
                            stringBuffer.append(getDenominator());
                            this.toProperString = stringBuffer.toString();
                        }
                    } else {
                        StringBuffer stringBuffer2 = new StringBuffer(32);
                        stringBuffer2.append(getNumerator());
                        stringBuffer2.append('/');
                        stringBuffer2.append(getDenominator());
                        this.toProperString = stringBuffer2.toString();
                    }
                }
            }
        }
        return this.toProperString;
    }

    public String toString() {
        if (this.toString == null) {
            StringBuffer stringBuffer = new StringBuffer(32);
            stringBuffer.append(getNumerator());
            stringBuffer.append('/');
            stringBuffer.append(getDenominator());
            this.toString = stringBuffer.toString();
        }
        return this.toString;
    }

    public static Fraction getFraction(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        } else if (i3 < 0) {
            throw new ArithmeticException("The denominator must not be negative");
        } else if (i2 >= 0) {
            long j = i < 0 ? (((long) i) * ((long) i3)) - ((long) i2) : (((long) i) * ((long) i3)) + ((long) i2);
            if (j >= -2147483648L && j <= 2147483647L) {
                return new Fraction((int) j, i3);
            }
            throw new ArithmeticException("Numerator too large to represent as an Integer.");
        } else {
            throw new ArithmeticException("The numerator must not be negative");
        }
    }

    public static Fraction getFraction(double d2) {
        int i;
        int i2;
        int i3 = d2 < 0.0d ? -1 : 1;
        double abs = Math.abs(d2);
        if (abs > 2.147483647E9d || Double.isNaN(abs)) {
            throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
        }
        int i4 = (int) abs;
        double d3 = abs - ((double) i4);
        int i5 = (int) d3;
        double d4 = 1.0d;
        double d5 = d3 - ((double) i5);
        double d6 = Double.MAX_VALUE;
        int i6 = i3;
        int i7 = 1;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1;
        int i11 = 1;
        while (true) {
            int i12 = (int) (d4 / d5);
            double d7 = d6;
            double d8 = d4 - (((double) i12) * d5);
            int i13 = (i5 * i7) + i8;
            int i14 = (i5 * i9) + i10;
            int i15 = i12;
            int i16 = i13;
            d6 = Math.abs(d3 - (((double) i13) / ((double) i14)));
            i = i11 + 1;
            if (d7 <= d6 || i14 > 10000 || i14 <= 0) {
                i2 = 25;
            } else {
                i2 = 25;
                if (i >= 25) {
                    break;
                }
                i11 = i;
                int i17 = i9;
                i9 = i14;
                i5 = i15;
                i8 = i7;
                i7 = i16;
                i10 = i17;
                double d9 = d8;
                d4 = d5;
                d5 = d9;
            }
        }
        if (i != i2) {
            return getReducedFraction(((i4 * i9) + i7) * i6, i9);
        }
        throw new ArithmeticException("Unable to convert double to fraction");
    }

    public static Fraction getFraction(String str) {
        if (str == null) {
            throw new IllegalArgumentException("The string must not be null");
        } else if (str.indexOf(46) >= 0) {
            return getFraction(Double.parseDouble(str));
        } else {
            int indexOf = str.indexOf(32);
            if (indexOf > 0) {
                int parseInt = Integer.parseInt(str.substring(0, indexOf));
                String substring = str.substring(indexOf + 1);
                int indexOf2 = substring.indexOf(47);
                if (indexOf2 >= 0) {
                    return getFraction(parseInt, Integer.parseInt(substring.substring(0, indexOf2)), Integer.parseInt(substring.substring(indexOf2 + 1)));
                }
                throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
            }
            int indexOf3 = str.indexOf(47);
            if (indexOf3 < 0) {
                return getFraction(Integer.parseInt(str), 1);
            }
            return getFraction(Integer.parseInt(str.substring(0, indexOf3)), Integer.parseInt(str.substring(indexOf3 + 1)));
        }
    }
}
