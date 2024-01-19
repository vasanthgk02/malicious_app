package com.badlogic.gdx.math;

import com.android.tools.r8.GeneratedOutlineSupport;

public abstract class Interpolation {
    public static final Interpolation circle = new Interpolation() {
        public float apply(float f2) {
            if (f2 <= 0.5f) {
                float f3 = f2 * 2.0f;
                return (1.0f - ((float) Math.sqrt((double) (1.0f - (f3 * f3))))) / 2.0f;
            }
            float f4 = (f2 - 1.0f) * 2.0f;
            return (((float) Math.sqrt((double) (1.0f - (f4 * f4)))) + 1.0f) / 2.0f;
        }
    };
    public static final Interpolation circleIn = new Interpolation() {
        public float apply(float f2) {
            return 1.0f - ((float) Math.sqrt((double) (1.0f - (f2 * f2))));
        }
    };
    public static final Interpolation fade;
    public static final PowOut fastSlow;
    public static final PowIn pow2In = new PowIn(2);
    public static final PowOut pow2Out;
    public static final Interpolation smoother;

    public static class Bounce extends BounceOut {
        public Bounce(int i) {
            super(i);
        }

        public float apply(float f2) {
            if (f2 <= 0.5f) {
                return (1.0f - out(1.0f - (f2 * 2.0f))) / 2.0f;
            }
            return (out((f2 * 2.0f) - 1.0f) / 2.0f) + 0.5f;
        }

        public final float out(float f2) {
            float[] fArr = this.widths;
            float f3 = (fArr[0] / 2.0f) + f2;
            if (f3 < fArr[0]) {
                return (f3 / (fArr[0] / 2.0f)) - 1.0f;
            }
            return super.apply(f2);
        }
    }

    public static class BounceIn extends BounceOut {
        public BounceIn(int i) {
            super(i);
        }

        public float apply(float f2) {
            return 1.0f - super.apply(1.0f - f2);
        }
    }

    public static class BounceOut extends Interpolation {
        public final float[] heights;
        public final float[] widths;

        public BounceOut(int i) {
            if (i < 2 || i > 5) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("bounces cannot be < 2 or > 5: ", i));
            }
            float[] fArr = new float[i];
            this.widths = fArr;
            float[] fArr2 = new float[i];
            this.heights = fArr2;
            fArr2[0] = 1.0f;
            if (i == 2) {
                fArr[0] = 0.6f;
                fArr[1] = 0.4f;
                fArr2[1] = 0.33f;
            } else if (i == 3) {
                fArr[0] = 0.4f;
                fArr[1] = 0.4f;
                fArr[2] = 0.2f;
                fArr2[1] = 0.33f;
                fArr2[2] = 0.1f;
            } else if (i == 4) {
                fArr[0] = 0.34f;
                fArr[1] = 0.34f;
                fArr[2] = 0.2f;
                fArr[3] = 0.15f;
                fArr2[1] = 0.26f;
                fArr2[2] = 0.11f;
                fArr2[3] = 0.03f;
            } else if (i == 5) {
                fArr[0] = 0.3f;
                fArr[1] = 0.3f;
                fArr[2] = 0.2f;
                fArr[3] = 0.1f;
                fArr[4] = 0.1f;
                fArr2[1] = 0.45f;
                fArr2[2] = 0.3f;
                fArr2[3] = 0.15f;
                fArr2[4] = 0.06f;
            }
            float[] fArr3 = this.widths;
            fArr3[0] = fArr3[0] * 2.0f;
        }

        public float apply(float f2) {
            if (f2 == 1.0f) {
                return 1.0f;
            }
            float[] fArr = this.widths;
            int i = 0;
            float f3 = (fArr[0] / 2.0f) + f2;
            int length = fArr.length;
            float f4 = 0.0f;
            float f5 = 0.0f;
            while (true) {
                if (i >= length) {
                    break;
                }
                f5 = this.widths[i];
                if (f3 <= f5) {
                    f4 = this.heights[i];
                    break;
                }
                f3 -= f5;
                i++;
            }
            float f6 = f3 / f5;
            float f7 = (4.0f / f5) * f4 * f6;
            return 1.0f - ((f7 - (f6 * f7)) * f5);
        }
    }

    public static class Elastic extends Interpolation {
        public final float bounces;
        public final float power;
        public final float scale;
        public final float value;

        public Elastic(float f2, float f3, int i, float f4) {
            this.value = f2;
            this.power = f3;
            this.scale = f4;
            this.bounces = ((float) i) * 3.1415927f * ((float) (i % 2 == 0 ? 1 : -1));
        }

        public float apply(float f2) {
            if (f2 <= 0.5f) {
                float f3 = f2 * 2.0f;
                float f4 = f3 - 1.0f;
                return ((MathUtils.sin(f3 * this.bounces) * ((float) Math.pow((double) this.value, (double) (f4 * this.power)))) * this.scale) / 2.0f;
            }
            float f5 = (1.0f - f2) * 2.0f;
            float f6 = f5 - 1.0f;
            return 1.0f - (((MathUtils.sin(f5 * this.bounces) * ((float) Math.pow((double) this.value, (double) (f6 * this.power)))) * this.scale) / 2.0f);
        }
    }

    public static class ElasticIn extends Elastic {
        public ElasticIn(float f2, float f3, int i, float f4) {
            super(f2, f3, i, f4);
        }

        public float apply(float f2) {
            if (((double) f2) >= 0.99d) {
                return 1.0f;
            }
            float f3 = f2 - 1.0f;
            return MathUtils.sin(f2 * this.bounces) * ((float) Math.pow((double) this.value, (double) (f3 * this.power))) * this.scale;
        }
    }

    public static class ElasticOut extends Elastic {
        public ElasticOut(float f2, float f3, int i, float f4) {
            super(f2, f3, i, f4);
        }

        public float apply(float f2) {
            if (f2 == 0.0f) {
                return 0.0f;
            }
            float f3 = 1.0f - f2;
            float f4 = f3 - 1.0f;
            return 1.0f - ((MathUtils.sin(f3 * this.bounces) * ((float) Math.pow((double) this.value, (double) (f4 * this.power)))) * this.scale);
        }
    }

    public static class Exp extends Interpolation {
        public final float min;
        public final float power;
        public final float scale;
        public final float value;

        public Exp(float f2, float f3) {
            this.value = f2;
            this.power = f3;
            float pow = (float) Math.pow((double) f2, (double) (-f3));
            this.min = pow;
            this.scale = 1.0f / (1.0f - pow);
        }

        public float apply(float f2) {
            float pow;
            if (f2 <= 0.5f) {
                pow = (((float) Math.pow((double) this.value, (double) (((f2 * 2.0f) - 1.0f) * this.power))) - this.min) * this.scale;
            } else {
                pow = 2.0f - ((((float) Math.pow((double) this.value, (double) (((f2 * 2.0f) - 1.0f) * (-this.power)))) - this.min) * this.scale);
            }
            return pow / 2.0f;
        }
    }

    public static class ExpIn extends Exp {
        public ExpIn(float f2, float f3) {
            super(f2, f3);
        }

        public float apply(float f2) {
            return (((float) Math.pow((double) this.value, (double) ((f2 - 1.0f) * this.power))) - this.min) * this.scale;
        }
    }

    public static class ExpOut extends Exp {
        public ExpOut(float f2, float f3) {
            super(f2, f3);
        }

        public float apply(float f2) {
            return 1.0f - ((((float) Math.pow((double) this.value, (double) ((-this.power) * f2))) - this.min) * this.scale);
        }
    }

    public static class Pow extends Interpolation {
        public final int power;

        public Pow(int i) {
            this.power = i;
        }
    }

    public static class PowIn extends Pow {
        public PowIn(int i) {
            super(i);
        }

        public float apply(float f2) {
            return (float) Math.pow((double) f2, (double) this.power);
        }
    }

    public static class PowOut extends Pow {
        public PowOut(int i) {
            super(i);
        }

        public float apply(float f2) {
            return (((float) Math.pow((double) (f2 - 1.0f), (double) this.power)) * ((float) (this.power % 2 == 0 ? -1 : 1))) + 1.0f;
        }
    }

    static {
        AnonymousClass4 r0 = new Interpolation() {
            public float apply(float f2) {
                return ((((6.0f * f2) - 15.0f) * f2) + 10.0f) * f2 * f2 * f2;
            }
        };
        smoother = r0;
        fade = r0;
        PowOut powOut = new PowOut(2);
        pow2Out = powOut;
        fastSlow = powOut;
        new Exp(2.0f, 10.0f);
        new ExpIn(2.0f, 10.0f);
        new ExpOut(2.0f, 10.0f);
        new Exp(2.0f, 5.0f);
        new ExpIn(2.0f, 5.0f);
        new ExpOut(2.0f, 5.0f);
        new Elastic(2.0f, 10.0f, 7, 1.0f);
        new ElasticIn(2.0f, 10.0f, 6, 1.0f);
        new ElasticOut(2.0f, 10.0f, 7, 1.0f);
        new Bounce(4);
        new BounceIn(4);
        new BounceOut(4);
    }

    public abstract float apply(float f2);
}
