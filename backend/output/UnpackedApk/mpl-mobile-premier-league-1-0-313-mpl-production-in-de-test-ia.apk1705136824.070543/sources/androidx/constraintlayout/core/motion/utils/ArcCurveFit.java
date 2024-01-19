package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

public class ArcCurveFit extends CurveFit {
    public Arc[] mArcs;
    public boolean mExtrapolate = true;
    public final double[] mTime;

    public static class Arc {
        public static double[] ourPercent = new double[91];
        public boolean linear = false;
        public double mArcDistance;
        public double mArcVelocity;
        public double mEllipseA;
        public double mEllipseB;
        public double mEllipseCenterX;
        public double mEllipseCenterY;
        public double[] mLut;
        public double mOneOverDeltaTime;
        public double mTime1;
        public double mTime2;
        public double mTmpCosAngle;
        public double mTmpSinAngle;
        public boolean mVertical;
        public double mX1;
        public double mX2;
        public double mY1;
        public double mY2;

        public Arc(int i, double d2, double d3, double d4, double d5, double d6, double d7) {
            int i2 = i;
            double d8 = d2;
            double d9 = d3;
            double d10 = d4;
            double d11 = d5;
            double d12 = d6;
            double d13 = d7;
            boolean z = false;
            this.mVertical = i2 == 1 ? true : z;
            this.mTime1 = d8;
            this.mTime2 = d9;
            this.mOneOverDeltaTime = 1.0d / (d9 - d8);
            if (3 == i2) {
                this.linear = true;
            }
            double d14 = d12 - d10;
            double d15 = d13 - d11;
            if (this.linear || Math.abs(d14) < 0.001d || Math.abs(d15) < 0.001d) {
                this.linear = true;
                this.mX1 = d10;
                this.mX2 = d12;
                this.mY1 = d11;
                this.mY2 = d13;
                double hypot = Math.hypot(d15, d14);
                this.mArcDistance = hypot;
                this.mArcVelocity = hypot * this.mOneOverDeltaTime;
                double d16 = this.mTime2;
                double d17 = this.mTime1;
                this.mEllipseCenterX = d14 / (d16 - d17);
                this.mEllipseCenterY = d15 / (d16 - d17);
                return;
            }
            this.mLut = new double[101];
            this.mEllipseA = ((double) (this.mVertical ? -1 : 1)) * d14;
            this.mEllipseB = d15 * ((double) (this.mVertical ? 1 : -1));
            this.mEllipseCenterX = this.mVertical ? d12 : d10;
            this.mEllipseCenterY = this.mVertical ? d11 : d13;
            double d18 = d11 - d13;
            int i3 = 0;
            double d19 = 0.0d;
            double d20 = 0.0d;
            double d21 = 0.0d;
            while (true) {
                if (i3 >= ourPercent.length) {
                    break;
                }
                double radians = Math.toRadians((((double) i3) * 90.0d) / ((double) (r14.length - 1)));
                double sin = Math.sin(radians) * d14;
                double cos = Math.cos(radians) * d18;
                if (i3 > 0) {
                    d19 += Math.hypot(sin - d20, cos - d21);
                    ourPercent[i3] = d19;
                }
                i3++;
                d21 = cos;
                d20 = sin;
            }
            this.mArcDistance = d19;
            int i4 = 0;
            while (true) {
                double[] dArr = ourPercent;
                if (i4 >= dArr.length) {
                    break;
                }
                dArr[i4] = dArr[i4] / d19;
                i4++;
            }
            int i5 = 0;
            while (true) {
                if (i5 < this.mLut.length) {
                    double length = ((double) i5) / ((double) (r1.length - 1));
                    int binarySearch = Arrays.binarySearch(ourPercent, length);
                    if (binarySearch >= 0) {
                        this.mLut[i5] = ((double) binarySearch) / ((double) (ourPercent.length - 1));
                    } else if (binarySearch == -1) {
                        this.mLut[i5] = 0.0d;
                    } else {
                        int i6 = (-binarySearch) - 2;
                        double[] dArr2 = ourPercent;
                        this.mLut[i5] = (((length - dArr2[i6]) / (dArr2[(-binarySearch) - 1] - dArr2[i6])) + ((double) i6)) / ((double) (dArr2.length - 1));
                    }
                    i5++;
                } else {
                    this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                    return;
                }
            }
        }

        public double getDX() {
            double d2 = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d2, (-this.mEllipseB) * this.mTmpSinAngle);
            if (this.mVertical) {
                d2 = -d2;
            }
            return d2 * hypot;
        }

        public double getDY() {
            double d2 = this.mEllipseA * this.mTmpCosAngle;
            double d3 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d2, d3);
            return this.mVertical ? (-d3) * hypot : d3 * hypot;
        }

        public double getLinearX(double d2) {
            double d3 = (d2 - this.mTime1) * this.mOneOverDeltaTime;
            double d4 = this.mX1;
            return ((this.mX2 - d4) * d3) + d4;
        }

        public double getLinearY(double d2) {
            double d3 = (d2 - this.mTime1) * this.mOneOverDeltaTime;
            double d4 = this.mY1;
            return ((this.mY2 - d4) * d3) + d4;
        }

        public double getX() {
            return (this.mEllipseA * this.mTmpSinAngle) + this.mEllipseCenterX;
        }

        public double getY() {
            return (this.mEllipseB * this.mTmpCosAngle) + this.mEllipseCenterY;
        }

        public void setPoint(double d2) {
            double d3 = (this.mVertical ? this.mTime2 - d2 : d2 - this.mTime1) * this.mOneOverDeltaTime;
            double d4 = 0.0d;
            if (d3 > 0.0d) {
                d4 = 1.0d;
                if (d3 < 1.0d) {
                    double[] dArr = this.mLut;
                    double length = d3 * ((double) (dArr.length - 1));
                    int i = (int) length;
                    d4 = ((dArr[i + 1] - dArr[i]) * (length - ((double) i))) + dArr[i];
                }
            }
            double d5 = d4 * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(d5);
            this.mTmpCosAngle = Math.cos(d5);
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        int i;
        double[] dArr3 = dArr;
        this.mTime = dArr3;
        this.mArcs = new Arc[(dArr3.length - 1)];
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        while (i2 < this.mArcs.length) {
            int i5 = iArr[i2];
            if (i5 == 0) {
                i = 3;
            } else if (i5 == 1) {
                i3 = 1;
                i = 1;
            } else if (i5 == 2) {
                i3 = 2;
                i = 2;
            } else if (i5 != 3) {
                i = i4;
            } else {
                i3 = i3 == 1 ? 2 : 1;
                i = i3;
            }
            Arc[] arcArr = this.mArcs;
            int i6 = i2 + 1;
            Arc arc = new Arc(i, dArr3[i2], dArr3[i6], dArr2[i2][0], dArr2[i2][1], dArr2[i6][0], dArr2[i6][1]);
            arcArr[i2] = arc;
            i4 = i;
            i2 = i6;
        }
    }

    public void getPos(double d2, double[] dArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            if (d2 < arcArr[0].mTime1) {
                double d3 = arcArr[0].mTime1;
                double d4 = d2 - arcArr[0].mTime1;
                if (arcArr[0].linear) {
                    double linearX = arcArr[0].getLinearX(d3);
                    Arc[] arcArr2 = this.mArcs;
                    dArr[0] = (arcArr2[0].mEllipseCenterX * d4) + linearX;
                    dArr[1] = (d4 * this.mArcs[0].mEllipseCenterY) + arcArr2[0].getLinearY(d3);
                } else {
                    arcArr[0].setPoint(d3);
                    dArr[0] = (this.mArcs[0].getDX() * d4) + this.mArcs[0].getX();
                    dArr[1] = (this.mArcs[0].getDY() * d4) + this.mArcs[0].getY();
                }
                return;
            } else if (d2 > arcArr[arcArr.length - 1].mTime2) {
                double d5 = arcArr[arcArr.length - 1].mTime2;
                double d6 = d2 - d5;
                int length = arcArr.length - 1;
                if (arcArr[length].linear) {
                    double linearX2 = arcArr[length].getLinearX(d5);
                    Arc[] arcArr3 = this.mArcs;
                    dArr[0] = (arcArr3[length].mEllipseCenterX * d6) + linearX2;
                    dArr[1] = (d6 * this.mArcs[length].mEllipseCenterY) + arcArr3[length].getLinearY(d5);
                } else {
                    arcArr[length].setPoint(d2);
                    dArr[0] = (this.mArcs[length].getDX() * d6) + this.mArcs[length].getX();
                    dArr[1] = (this.mArcs[length].getDY() * d6) + this.mArcs[length].getY();
                }
                return;
            }
        } else {
            Arc[] arcArr4 = this.mArcs;
            if (d2 < arcArr4[0].mTime1) {
                d2 = arcArr4[0].mTime1;
            }
            Arc[] arcArr5 = this.mArcs;
            if (d2 > arcArr5[arcArr5.length - 1].mTime2) {
                d2 = arcArr5[arcArr5.length - 1].mTime2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr6 = this.mArcs;
            if (i >= arcArr6.length) {
                return;
            }
            if (d2 > arcArr6[i].mTime2) {
                i++;
            } else if (arcArr6[i].linear) {
                dArr[0] = arcArr6[i].getLinearX(d2);
                dArr[1] = this.mArcs[i].getLinearY(d2);
                return;
            } else {
                arcArr6[i].setPoint(d2);
                dArr[0] = this.mArcs[i].getX();
                dArr[1] = this.mArcs[i].getY();
                return;
            }
        }
    }

    public void getSlope(double d2, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        } else if (d2 > arcArr[arcArr.length - 1].mTime2) {
            d2 = arcArr[arcArr.length - 1].mTime2;
        }
        int i = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i >= arcArr2.length) {
                return;
            }
            if (d2 > arcArr2[i].mTime2) {
                i++;
            } else if (arcArr2[i].linear) {
                dArr[0] = arcArr2[i].mEllipseCenterX;
                dArr[1] = arcArr2[i].mEllipseCenterY;
                return;
            } else {
                arcArr2[i].setPoint(d2);
                dArr[0] = this.mArcs[i].getDX();
                dArr[1] = this.mArcs[i].getDY();
                return;
            }
        }
    }

    public double[] getTimePoints() {
        return this.mTime;
    }

    public double getSlope(double d2, int i) {
        Arc[] arcArr = this.mArcs;
        int i2 = 0;
        if (d2 < arcArr[0].mTime1) {
            d2 = arcArr[0].mTime1;
        }
        Arc[] arcArr2 = this.mArcs;
        if (d2 > arcArr2[arcArr2.length - 1].mTime2) {
            d2 = arcArr2[arcArr2.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i2 >= arcArr3.length) {
                return Double.NaN;
            }
            if (d2 > arcArr3[i2].mTime2) {
                i2++;
            } else if (!arcArr3[i2].linear) {
                arcArr3[i2].setPoint(d2);
                if (i == 0) {
                    return this.mArcs[i2].getDX();
                }
                return this.mArcs[i2].getDY();
            } else if (i == 0) {
                return arcArr3[i2].mEllipseCenterX;
            } else {
                return arcArr3[i2].mEllipseCenterY;
            }
        }
    }

    public void getPos(double d2, float[] fArr) {
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            if (d2 < arcArr[0].mTime1) {
                double d3 = arcArr[0].mTime1;
                double d4 = d2 - arcArr[0].mTime1;
                if (arcArr[0].linear) {
                    double linearX = arcArr[0].getLinearX(d3);
                    Arc[] arcArr2 = this.mArcs;
                    fArr[0] = (float) ((arcArr2[0].mEllipseCenterX * d4) + linearX);
                    fArr[1] = (float) ((d4 * this.mArcs[0].mEllipseCenterY) + arcArr2[0].getLinearY(d3));
                } else {
                    arcArr[0].setPoint(d3);
                    fArr[0] = (float) ((this.mArcs[0].getDX() * d4) + this.mArcs[0].getX());
                    fArr[1] = (float) ((this.mArcs[0].getDY() * d4) + this.mArcs[0].getY());
                }
                return;
            } else if (d2 > arcArr[arcArr.length - 1].mTime2) {
                double d5 = arcArr[arcArr.length - 1].mTime2;
                double d6 = d2 - d5;
                int length = arcArr.length - 1;
                if (arcArr[length].linear) {
                    double linearX2 = arcArr[length].getLinearX(d5);
                    Arc[] arcArr3 = this.mArcs;
                    fArr[0] = (float) ((arcArr3[length].mEllipseCenterX * d6) + linearX2);
                    fArr[1] = (float) ((d6 * this.mArcs[length].mEllipseCenterY) + arcArr3[length].getLinearY(d5));
                } else {
                    arcArr[length].setPoint(d2);
                    fArr[0] = (float) this.mArcs[length].getX();
                    fArr[1] = (float) this.mArcs[length].getY();
                }
                return;
            }
        } else {
            Arc[] arcArr4 = this.mArcs;
            if (d2 < arcArr4[0].mTime1) {
                d2 = arcArr4[0].mTime1;
            } else if (d2 > arcArr4[arcArr4.length - 1].mTime2) {
                d2 = arcArr4[arcArr4.length - 1].mTime2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr5 = this.mArcs;
            if (i >= arcArr5.length) {
                return;
            }
            if (d2 > arcArr5[i].mTime2) {
                i++;
            } else if (arcArr5[i].linear) {
                fArr[0] = (float) arcArr5[i].getLinearX(d2);
                fArr[1] = (float) this.mArcs[i].getLinearY(d2);
                return;
            } else {
                arcArr5[i].setPoint(d2);
                fArr[0] = (float) this.mArcs[i].getX();
                fArr[1] = (float) this.mArcs[i].getY();
                return;
            }
        }
    }

    public double getPos(double d2, int i) {
        double y;
        double dy;
        int i2 = 0;
        if (this.mExtrapolate) {
            Arc[] arcArr = this.mArcs;
            if (d2 < arcArr[0].mTime1) {
                double d3 = arcArr[0].mTime1;
                double d4 = d2 - arcArr[0].mTime1;
                if (!arcArr[0].linear) {
                    arcArr[0].setPoint(d3);
                    if (i == 0) {
                        y = this.mArcs[0].getX();
                        dy = this.mArcs[0].getDX();
                    } else {
                        y = this.mArcs[0].getY();
                        dy = this.mArcs[0].getDY();
                    }
                    return (dy * d4) + y;
                } else if (i == 0) {
                    return (d4 * this.mArcs[0].mEllipseCenterX) + arcArr[0].getLinearX(d3);
                } else {
                    return (d4 * this.mArcs[0].mEllipseCenterY) + arcArr[0].getLinearY(d3);
                }
            } else if (d2 > arcArr[arcArr.length - 1].mTime2) {
                double d5 = arcArr[arcArr.length - 1].mTime2;
                double d6 = d2 - d5;
                int length = arcArr.length - 1;
                if (i == 0) {
                    return (d6 * this.mArcs[length].mEllipseCenterX) + arcArr[length].getLinearX(d5);
                }
                return (d6 * this.mArcs[length].mEllipseCenterY) + arcArr[length].getLinearY(d5);
            }
        } else {
            Arc[] arcArr2 = this.mArcs;
            if (d2 < arcArr2[0].mTime1) {
                d2 = arcArr2[0].mTime1;
            } else if (d2 > arcArr2[arcArr2.length - 1].mTime2) {
                d2 = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i2 >= arcArr3.length) {
                return Double.NaN;
            }
            if (d2 > arcArr3[i2].mTime2) {
                i2++;
            } else if (!arcArr3[i2].linear) {
                arcArr3[i2].setPoint(d2);
                if (i == 0) {
                    return this.mArcs[i2].getX();
                }
                return this.mArcs[i2].getY();
            } else if (i == 0) {
                return arcArr3[i2].getLinearX(d2);
            } else {
                return arcArr3[i2].getLinearY(d2);
            }
        }
    }
}
