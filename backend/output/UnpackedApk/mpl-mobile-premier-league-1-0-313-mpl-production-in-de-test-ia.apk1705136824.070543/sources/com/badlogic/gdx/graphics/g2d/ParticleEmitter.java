package com.badlogic.gdx.graphics.g2d;

import co.hyperverge.hypersnapsdk.c.k;
import com.BV.LinearGradient.LinearGradientManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.facebook.react.modules.appstate.AppStateModule;
import com.razorpay.AnalyticsConstants;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class ParticleEmitter {
    public static final int UPDATE_ANGLE = 2;
    public static final int UPDATE_GRAVITY = 32;
    public static final int UPDATE_ROTATION = 4;
    public static final int UPDATE_SCALE = 1;
    public static final int UPDATE_SPRITE = 128;
    public static final int UPDATE_TINT = 64;
    public static final int UPDATE_VELOCITY = 8;
    public static final int UPDATE_WIND = 16;
    public float accumulator;
    public boolean[] active;
    public int activeCount;
    public boolean additive = true;
    public boolean aligned;
    public boolean allowCompletion;
    public ScaledNumericValue angleValue = new ScaledNumericValue();
    public boolean attached;
    public boolean behind;
    public BoundingBox bounds;
    public boolean cleansUpBlendFunction = true;
    public boolean continuous;
    public float delay;
    public float delayTimer;
    public RangedNumericValue delayValue = new RangedNumericValue();
    public float duration = 1.0f;
    public float durationTimer;
    public RangedNumericValue durationValue = new RangedNumericValue();
    public int emission;
    public int emissionDelta;
    public int emissionDiff;
    public ScaledNumericValue emissionValue = new ScaledNumericValue();
    public boolean firstUpdate;
    public boolean flipX;
    public boolean flipY;
    public ScaledNumericValue gravityValue = new ScaledNumericValue();
    public Array<String> imagePaths;
    public int life;
    public int lifeDiff;
    public int lifeOffset;
    public int lifeOffsetDiff;
    public IndependentScaledNumericValue lifeOffsetValue = new IndependentScaledNumericValue();
    public IndependentScaledNumericValue lifeValue = new IndependentScaledNumericValue();
    public int maxParticleCount = 4;
    public int minParticleCount;
    public RangedNumericValue[] motionValues;
    public String name;
    public Particle[] particles;
    public boolean premultipliedAlpha = false;
    public ScaledNumericValue rotationValue = new ScaledNumericValue();
    public float spawnHeight;
    public float spawnHeightDiff;
    public ScaledNumericValue spawnHeightValue = new ScaledNumericValue();
    public SpawnShapeValue spawnShapeValue = new SpawnShapeValue();
    public float spawnWidth;
    public float spawnWidthDiff;
    public ScaledNumericValue spawnWidthValue = new ScaledNumericValue();
    public SpriteMode spriteMode = SpriteMode.single;
    public Array<Sprite> sprites;
    public GradientColorValue tintValue = new GradientColorValue();
    public ScaledNumericValue transparencyValue = new ScaledNumericValue();
    public int updateFlags;
    public ScaledNumericValue velocityValue = new ScaledNumericValue();
    public ScaledNumericValue windValue = new ScaledNumericValue();
    public float x;
    public RangedNumericValue xOffsetValue = new ScaledNumericValue();
    public ScaledNumericValue xScaleValue = new ScaledNumericValue();
    public RangedNumericValue[] xSizeValues;
    public float y;
    public RangedNumericValue yOffsetValue = new ScaledNumericValue();
    public ScaledNumericValue yScaleValue = new ScaledNumericValue();
    public RangedNumericValue[] ySizeValues;

    /* renamed from: com.badlogic.gdx.graphics.g2d.ParticleEmitter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$badlogic$gdx$graphics$g2d$ParticleEmitter$SpawnEllipseSide;
        public static final /* synthetic */ int[] $SwitchMap$com$badlogic$gdx$graphics$g2d$ParticleEmitter$SpawnShape;
        public static final /* synthetic */ int[] $SwitchMap$com$badlogic$gdx$graphics$g2d$ParticleEmitter$SpriteMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|(2:1|2)|3|5|6|7|8|9|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|8|9|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0029 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpawnShape[] r0 = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$badlogic$gdx$graphics$g2d$ParticleEmitter$SpawnShape = r0
                r1 = 1
                r2 = 2
                com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpawnShape r3 = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.square     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 3
                int[] r3 = $SwitchMap$com$badlogic$gdx$graphics$g2d$ParticleEmitter$SpawnShape     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpawnShape r4 = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.ellipse     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r3 = $SwitchMap$com$badlogic$gdx$graphics$g2d$ParticleEmitter$SpawnShape     // Catch:{ NoSuchFieldError -> 0x001c }
                com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpawnShape r4 = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnShape.line     // Catch:{ NoSuchFieldError -> 0x001c }
                r3[r1] = r0     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpawnEllipseSide[] r3 = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnEllipseSide.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$badlogic$gdx$graphics$g2d$ParticleEmitter$SpawnEllipseSide = r3
                com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpawnEllipseSide r4 = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnEllipseSide.top     // Catch:{ NoSuchFieldError -> 0x0029 }
                r3[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                int[] r3 = $SwitchMap$com$badlogic$gdx$graphics$g2d$ParticleEmitter$SpawnEllipseSide     // Catch:{ NoSuchFieldError -> 0x002f }
                com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpawnEllipseSide r4 = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpawnEllipseSide.bottom     // Catch:{ NoSuchFieldError -> 0x002f }
                r3[r2] = r2     // Catch:{ NoSuchFieldError -> 0x002f }
            L_0x002f:
                com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpriteMode[] r3 = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpriteMode.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$badlogic$gdx$graphics$g2d$ParticleEmitter$SpriteMode = r3
                com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpriteMode r4 = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpriteMode.single     // Catch:{ NoSuchFieldError -> 0x003d }
                r4 = 0
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r3 = $SwitchMap$com$badlogic$gdx$graphics$g2d$ParticleEmitter$SpriteMode     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpriteMode r4 = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpriteMode.animated     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r2] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r2 = $SwitchMap$com$badlogic$gdx$graphics$g2d$ParticleEmitter$SpriteMode     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpriteMode r3 = com.badlogic.gdx.graphics.g2d.ParticleEmitter.SpriteMode.random     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.ParticleEmitter.AnonymousClass1.<clinit>():void");
        }
    }

    public static class GradientColorValue extends ParticleValue {
        public static float[] temp = new float[4];
        public float[] colors = {1.0f, 1.0f, 1.0f};
        public float[] timeline = {0.0f};

        public GradientColorValue() {
            this.alwaysActive = true;
        }

        public float[] getColor(float f2) {
            float[] fArr = this.timeline;
            int length = fArr.length;
            int i = 1;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (fArr[i] > f2) {
                    break;
                } else {
                    i2 = i;
                    i++;
                }
            }
            float f3 = fArr[i2];
            int i3 = i2 * 3;
            float[] fArr2 = this.colors;
            float f4 = fArr2[i3];
            float f5 = fArr2[i3 + 1];
            float f6 = fArr2[i3 + 2];
            if (i == -1) {
                float[] fArr3 = temp;
                fArr3[0] = f4;
                fArr3[1] = f5;
                fArr3[2] = f6;
                return fArr3;
            }
            float f7 = (f2 - f3) / (fArr[i] - f3);
            int i4 = i * 3;
            float[] fArr4 = temp;
            fArr4[0] = GeneratedOutlineSupport.outline3(fArr2[i4], f4, f7, f4);
            fArr4[1] = GeneratedOutlineSupport.outline3(fArr2[i4 + 1], f5, f7, f5);
            fArr4[2] = GeneratedOutlineSupport.outline3(fArr2[i4 + 2], f6, f7, f6);
            return fArr4;
        }

        public float[] getColors() {
            return this.colors;
        }

        public float[] getTimeline() {
            return this.timeline;
        }

        public void load(BufferedReader bufferedReader) throws IOException {
            super.load(bufferedReader);
            if (this.active) {
                this.colors = new float[ParticleEmitter.readInt(bufferedReader, "colorsCount")];
                int i = 0;
                int i2 = 0;
                while (true) {
                    float[] fArr = this.colors;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    fArr[i2] = ParticleEmitter.readFloat(bufferedReader, LinearGradientManager.PROP_COLORS + i2);
                    i2++;
                }
                this.timeline = new float[ParticleEmitter.readInt(bufferedReader, "timelineCount")];
                while (true) {
                    float[] fArr2 = this.timeline;
                    if (i < fArr2.length) {
                        fArr2[i] = ParticleEmitter.readFloat(bufferedReader, "timeline" + i);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }

        public void save(Writer writer) throws IOException {
            super.save(writer);
            if (this.active) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("colorsCount: ");
                outline73.append(this.colors.length);
                outline73.append("\n");
                writer.write(outline73.toString());
                for (int i = 0; i < this.colors.length; i++) {
                    StringBuilder outline74 = GeneratedOutlineSupport.outline74(LinearGradientManager.PROP_COLORS, i, ": ");
                    outline74.append(this.colors[i]);
                    outline74.append("\n");
                    writer.write(outline74.toString());
                }
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("timelineCount: ");
                outline732.append(this.timeline.length);
                outline732.append("\n");
                writer.write(outline732.toString());
                for (int i2 = 0; i2 < this.timeline.length; i2++) {
                    StringBuilder outline742 = GeneratedOutlineSupport.outline74("timeline", i2, ": ");
                    outline742.append(this.timeline[i2]);
                    outline742.append("\n");
                    writer.write(outline742.toString());
                }
            }
        }

        public void setColors(float[] fArr) {
            this.colors = fArr;
        }

        public void setTimeline(float[] fArr) {
            this.timeline = fArr;
        }

        public void load(GradientColorValue gradientColorValue) {
            super.load((ParticleValue) gradientColorValue);
            float[] fArr = new float[gradientColorValue.colors.length];
            this.colors = fArr;
            System.arraycopy(gradientColorValue.colors, 0, fArr, 0, fArr.length);
            float[] fArr2 = new float[gradientColorValue.timeline.length];
            this.timeline = fArr2;
            System.arraycopy(gradientColorValue.timeline, 0, fArr2, 0, fArr2.length);
        }
    }

    public static class IndependentScaledNumericValue extends ScaledNumericValue {
        public boolean independent;

        public boolean isIndependent() {
            return this.independent;
        }

        public void load(BufferedReader bufferedReader) throws IOException {
            super.load(bufferedReader);
            if (bufferedReader.markSupported()) {
                bufferedReader.mark(100);
            }
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                throw new IOException("Missing value: independent");
            } else if (readLine.contains("independent")) {
                this.independent = Boolean.parseBoolean(ParticleEmitter.readString(readLine));
            } else if (bufferedReader.markSupported()) {
                bufferedReader.reset();
            } else {
                k.app.error("ParticleEmitter", "The loaded particle effect descriptor file uses an old invalid format. Please download the latest version of the Particle Editor tool and recreate the file by loading and saving it again.");
                throw new IOException("The loaded particle effect descriptor file uses an old invalid format. Please download the latest version of the Particle Editor tool and recreate the file by loading and saving it again.");
            }
        }

        public void save(Writer writer) throws IOException {
            super.save(writer);
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("independent: ");
            outline73.append(this.independent);
            outline73.append("\n");
            writer.write(outline73.toString());
        }

        public void set(RangedNumericValue rangedNumericValue) {
            if (rangedNumericValue instanceof IndependentScaledNumericValue) {
                set((IndependentScaledNumericValue) rangedNumericValue);
            } else {
                super.set(rangedNumericValue);
            }
        }

        public void setIndependent(boolean z) {
            this.independent = z;
        }

        public void set(ScaledNumericValue scaledNumericValue) {
            if (scaledNumericValue instanceof IndependentScaledNumericValue) {
                set((IndependentScaledNumericValue) scaledNumericValue);
            } else {
                super.set(scaledNumericValue);
            }
        }

        public void set(IndependentScaledNumericValue independentScaledNumericValue) {
            super.set((ScaledNumericValue) independentScaledNumericValue);
            this.independent = independentScaledNumericValue.independent;
        }

        public void load(IndependentScaledNumericValue independentScaledNumericValue) {
            super.load((ScaledNumericValue) independentScaledNumericValue);
            this.independent = independentScaledNumericValue.independent;
        }
    }

    public static class NumericValue extends ParticleValue {
        public float value;

        public float getValue() {
            return this.value;
        }

        public void load(BufferedReader bufferedReader) throws IOException {
            super.load(bufferedReader);
            if (this.active) {
                this.value = ParticleEmitter.readFloat(bufferedReader, HSLCriteriaBuilder.VALUE);
            }
        }

        public void save(Writer writer) throws IOException {
            super.save(writer);
            if (this.active) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("value: ");
                outline73.append(this.value);
                outline73.append("\n");
                writer.write(outline73.toString());
            }
        }

        public void setValue(float f2) {
            this.value = f2;
        }

        public void load(NumericValue numericValue) {
            super.load((ParticleValue) numericValue);
            this.value = numericValue.value;
        }
    }

    public static class Particle extends Sprite {
        public float angle;
        public float angleCos;
        public float angleDiff;
        public float angleSin;
        public int currentLife;
        public int frame;
        public float gravity;
        public float gravityDiff;
        public int life;
        public float rotation;
        public float rotationDiff;
        public float[] tint;
        public float transparency;
        public float transparencyDiff;
        public float velocity;
        public float velocityDiff;
        public float wind;
        public float windDiff;
        public float xScale;
        public float xScaleDiff;
        public float yScale;
        public float yScaleDiff;

        public Particle(Sprite sprite) {
            super(sprite);
        }
    }

    public static class ParticleValue {
        public boolean active;
        public boolean alwaysActive;

        public boolean isActive() {
            return this.alwaysActive || this.active;
        }

        public boolean isAlwaysActive() {
            return this.alwaysActive;
        }

        public void load(BufferedReader bufferedReader) throws IOException {
            if (!this.alwaysActive) {
                this.active = ParticleEmitter.readBoolean(bufferedReader, AppStateModule.APP_STATE_ACTIVE);
            } else {
                this.active = true;
            }
        }

        public void save(Writer writer) throws IOException {
            if (!this.alwaysActive) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("active: ");
                outline73.append(this.active);
                outline73.append("\n");
                writer.write(outline73.toString());
                return;
            }
            this.active = true;
        }

        public void setActive(boolean z) {
            this.active = z;
        }

        public void setAlwaysActive(boolean z) {
            this.alwaysActive = z;
        }

        public void load(ParticleValue particleValue) {
            this.active = particleValue.active;
            this.alwaysActive = particleValue.alwaysActive;
        }
    }

    public static class RangedNumericValue extends ParticleValue {
        public float lowMax;
        public float lowMin;

        public float getLowMax() {
            return this.lowMax;
        }

        public float getLowMin() {
            return this.lowMin;
        }

        public void load(BufferedReader bufferedReader) throws IOException {
            super.load(bufferedReader);
            if (this.active) {
                this.lowMin = ParticleEmitter.readFloat(bufferedReader, "lowMin");
                this.lowMax = ParticleEmitter.readFloat(bufferedReader, "lowMax");
            }
        }

        public float newLowValue() {
            float f2 = this.lowMin;
            return (MathUtils.random() * (this.lowMax - f2)) + f2;
        }

        public void save(Writer writer) throws IOException {
            super.save(writer);
            if (this.active) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("lowMin: ");
                outline73.append(this.lowMin);
                outline73.append("\n");
                writer.write(outline73.toString());
                writer.write("lowMax: " + this.lowMax + "\n");
            }
        }

        public void scale(float f2) {
            this.lowMin *= f2;
            this.lowMax *= f2;
        }

        public void set(RangedNumericValue rangedNumericValue) {
            this.lowMin = rangedNumericValue.lowMin;
            this.lowMax = rangedNumericValue.lowMax;
        }

        public void setLow(float f2) {
            this.lowMin = f2;
            this.lowMax = f2;
        }

        public void setLowMax(float f2) {
            this.lowMax = f2;
        }

        public void setLowMin(float f2) {
            this.lowMin = f2;
        }

        public void setLow(float f2, float f3) {
            this.lowMin = f2;
            this.lowMax = f3;
        }

        public void load(RangedNumericValue rangedNumericValue) {
            super.load((ParticleValue) rangedNumericValue);
            this.lowMax = rangedNumericValue.lowMax;
            this.lowMin = rangedNumericValue.lowMin;
        }
    }

    public static class ScaledNumericValue extends RangedNumericValue {
        public float highMax;
        public float highMin;
        public boolean relative;
        public float[] scaling = {1.0f};
        public float[] timeline = {0.0f};

        public float getHighMax() {
            return this.highMax;
        }

        public float getHighMin() {
            return this.highMin;
        }

        public float getScale(float f2) {
            float[] fArr = this.timeline;
            int length = fArr.length;
            int i = 1;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (fArr[i] > f2) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return this.scaling[length - 1];
            }
            float[] fArr2 = this.scaling;
            int i2 = i - 1;
            float f3 = fArr2[i2];
            float f4 = fArr[i2];
            return (((f2 - f4) / (fArr[i] - f4)) * (fArr2[i] - f3)) + f3;
        }

        public float[] getScaling() {
            return this.scaling;
        }

        public float[] getTimeline() {
            return this.timeline;
        }

        public boolean isRelative() {
            return this.relative;
        }

        public void load(BufferedReader bufferedReader) throws IOException {
            super.load(bufferedReader);
            if (this.active) {
                this.highMin = ParticleEmitter.readFloat(bufferedReader, "highMin");
                this.highMax = ParticleEmitter.readFloat(bufferedReader, "highMax");
                this.relative = ParticleEmitter.readBoolean(bufferedReader, "relative");
                this.scaling = new float[ParticleEmitter.readInt(bufferedReader, "scalingCount")];
                int i = 0;
                int i2 = 0;
                while (true) {
                    float[] fArr = this.scaling;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    fArr[i2] = ParticleEmitter.readFloat(bufferedReader, "scaling" + i2);
                    i2++;
                }
                this.timeline = new float[ParticleEmitter.readInt(bufferedReader, "timelineCount")];
                while (true) {
                    float[] fArr2 = this.timeline;
                    if (i < fArr2.length) {
                        fArr2[i] = ParticleEmitter.readFloat(bufferedReader, "timeline" + i);
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }

        public float newHighValue() {
            float f2 = this.highMin;
            return (MathUtils.random() * (this.highMax - f2)) + f2;
        }

        public void save(Writer writer) throws IOException {
            super.save(writer);
            if (this.active) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("highMin: ");
                outline73.append(this.highMin);
                outline73.append("\n");
                writer.write(outline73.toString());
                writer.write("highMax: " + this.highMax + "\n");
                writer.write("relative: " + this.relative + "\n");
                writer.write("scalingCount: " + this.scaling.length + "\n");
                for (int i = 0; i < this.scaling.length; i++) {
                    StringBuilder outline74 = GeneratedOutlineSupport.outline74("scaling", i, ": ");
                    outline74.append(this.scaling[i]);
                    outline74.append("\n");
                    writer.write(outline74.toString());
                }
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("timelineCount: ");
                outline732.append(this.timeline.length);
                outline732.append("\n");
                writer.write(outline732.toString());
                for (int i2 = 0; i2 < this.timeline.length; i2++) {
                    StringBuilder outline742 = GeneratedOutlineSupport.outline74("timeline", i2, ": ");
                    outline742.append(this.timeline[i2]);
                    outline742.append("\n");
                    writer.write(outline742.toString());
                }
            }
        }

        public void scale(float f2) {
            super.scale(f2);
            this.highMin *= f2;
            this.highMax *= f2;
        }

        public void set(RangedNumericValue rangedNumericValue) {
            if (rangedNumericValue instanceof ScaledNumericValue) {
                set((ScaledNumericValue) rangedNumericValue);
            } else {
                super.set(rangedNumericValue);
            }
        }

        public void setHigh(float f2) {
            this.highMin = f2;
            this.highMax = f2;
        }

        public void setHighMax(float f2) {
            this.highMax = f2;
        }

        public void setHighMin(float f2) {
            this.highMin = f2;
        }

        public void setRelative(boolean z) {
            this.relative = z;
        }

        public void setScaling(float[] fArr) {
            this.scaling = fArr;
        }

        public void setTimeline(float[] fArr) {
            this.timeline = fArr;
        }

        public void setHigh(float f2, float f3) {
            this.highMin = f2;
            this.highMax = f3;
        }

        public void set(ScaledNumericValue scaledNumericValue) {
            super.set(scaledNumericValue);
            this.highMin = scaledNumericValue.highMin;
            this.highMax = scaledNumericValue.highMax;
            float[] fArr = this.scaling;
            int length = fArr.length;
            float[] fArr2 = scaledNumericValue.scaling;
            if (length != fArr2.length) {
                this.scaling = Arrays.copyOf(fArr2, fArr2.length);
            } else {
                System.arraycopy(fArr2, 0, fArr, 0, fArr.length);
            }
            float[] fArr3 = this.timeline;
            int length2 = fArr3.length;
            float[] fArr4 = scaledNumericValue.timeline;
            if (length2 != fArr4.length) {
                this.timeline = Arrays.copyOf(fArr4, fArr4.length);
            } else {
                System.arraycopy(fArr4, 0, fArr3, 0, fArr3.length);
            }
            this.relative = scaledNumericValue.relative;
        }

        public void load(ScaledNumericValue scaledNumericValue) {
            super.load((RangedNumericValue) scaledNumericValue);
            this.highMax = scaledNumericValue.highMax;
            this.highMin = scaledNumericValue.highMin;
            float[] fArr = new float[scaledNumericValue.scaling.length];
            this.scaling = fArr;
            System.arraycopy(scaledNumericValue.scaling, 0, fArr, 0, fArr.length);
            float[] fArr2 = new float[scaledNumericValue.timeline.length];
            this.timeline = fArr2;
            System.arraycopy(scaledNumericValue.timeline, 0, fArr2, 0, fArr2.length);
            this.relative = scaledNumericValue.relative;
        }
    }

    public enum SpawnEllipseSide {
        both,
        top,
        bottom
    }

    public enum SpawnShape {
        point,
        line,
        square,
        ellipse
    }

    public static class SpawnShapeValue extends ParticleValue {
        public boolean edges;
        public SpawnShape shape = SpawnShape.point;
        public SpawnEllipseSide side = SpawnEllipseSide.both;

        public SpawnShape getShape() {
            return this.shape;
        }

        public SpawnEllipseSide getSide() {
            return this.side;
        }

        public boolean isEdges() {
            return this.edges;
        }

        public void load(BufferedReader bufferedReader) throws IOException {
            super.load(bufferedReader);
            if (this.active) {
                SpawnShape valueOf = SpawnShape.valueOf(ParticleEmitter.readString(bufferedReader, "shape"));
                this.shape = valueOf;
                if (valueOf == SpawnShape.ellipse) {
                    this.edges = ParticleEmitter.readBoolean(bufferedReader, "edges");
                    this.side = SpawnEllipseSide.valueOf(ParticleEmitter.readString(bufferedReader, "side"));
                }
            }
        }

        public void save(Writer writer) throws IOException {
            super.save(writer);
            if (this.active) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("shape: ");
                outline73.append(this.shape);
                outline73.append("\n");
                writer.write(outline73.toString());
                if (this.shape == SpawnShape.ellipse) {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("edges: ");
                    outline732.append(this.edges);
                    outline732.append("\n");
                    writer.write(outline732.toString());
                    writer.write("side: " + this.side + "\n");
                }
            }
        }

        public void setEdges(boolean z) {
            this.edges = z;
        }

        public void setShape(SpawnShape spawnShape) {
            this.shape = spawnShape;
        }

        public void setSide(SpawnEllipseSide spawnEllipseSide) {
            this.side = spawnEllipseSide;
        }

        public void load(SpawnShapeValue spawnShapeValue) {
            super.load((ParticleValue) spawnShapeValue);
            this.shape = spawnShapeValue.shape;
            this.edges = spawnShapeValue.edges;
            this.side = spawnShapeValue.side;
        }
    }

    public enum SpriteMode {
        single,
        random,
        animated
    }

    public ParticleEmitter() {
        initialize();
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void activateParticle(int r18) {
        /*
            r17 = this;
            r0 = r17
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpriteMode r1 = r0.spriteMode
            int r1 = r1.ordinal()
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001b
            if (r1 == r3) goto L_0x0012
            if (r1 == r2) goto L_0x001b
            r1 = 0
            goto L_0x0023
        L_0x0012:
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.Sprite> r1 = r0.sprites
            java.lang.Object r1 = r1.random()
            com.badlogic.gdx.graphics.g2d.Sprite r1 = (com.badlogic.gdx.graphics.g2d.Sprite) r1
            goto L_0x0023
        L_0x001b:
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.Sprite> r1 = r0.sprites
            java.lang.Object r1 = r1.first()
            com.badlogic.gdx.graphics.g2d.Sprite r1 = (com.badlogic.gdx.graphics.g2d.Sprite) r1
        L_0x0023:
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$Particle[] r4 = r0.particles
            r5 = r4[r18]
            if (r5 != 0) goto L_0x0037
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$Particle r5 = r0.newParticle(r1)
            r4[r18] = r5
            boolean r4 = r0.flipX
            boolean r6 = r0.flipY
            r5.flip(r4, r6)
            goto L_0x003a
        L_0x0037:
            r5.set(r1)
        L_0x003a:
            float r4 = r0.durationTimer
            float r6 = r0.duration
            float r4 = r4 / r6
            int r6 = r0.updateFlags
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$IndependentScaledNumericValue r7 = r0.lifeValue
            boolean r7 = r7.independent
            if (r7 == 0) goto L_0x004a
            r17.generateLifeValues()
        L_0x004a:
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$IndependentScaledNumericValue r7 = r0.lifeOffsetValue
            boolean r7 = r7.independent
            if (r7 == 0) goto L_0x0053
            r17.generateLifeOffsetValues()
        L_0x0053:
            int r7 = r0.life
            int r8 = r0.lifeDiff
            float r8 = (float) r8
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$IndependentScaledNumericValue r9 = r0.lifeValue
            float r9 = r9.getScale(r4)
            float r9 = r9 * r8
            int r8 = (int) r9
            int r7 = r7 + r8
            r5.life = r7
            r5.currentLife = r7
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r7 = r0.velocityValue
            boolean r8 = r7.active
            if (r8 == 0) goto L_0x0089
            float r7 = r7.newLowValue()
            r5.velocity = r7
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r7 = r0.velocityValue
            float r7 = r7.newHighValue()
            r5.velocityDiff = r7
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r7 = r0.velocityValue
            boolean r7 = r7.isRelative()
            if (r7 != 0) goto L_0x0089
            float r7 = r5.velocityDiff
            float r8 = r5.velocity
            float r7 = r7 - r8
            r5.velocityDiff = r7
        L_0x0089:
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r7 = r0.angleValue
            float r7 = r7.newLowValue()
            r5.angle = r7
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r7 = r0.angleValue
            float r7 = r7.newHighValue()
            r5.angleDiff = r7
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r7 = r0.angleValue
            boolean r7 = r7.isRelative()
            if (r7 != 0) goto L_0x00a8
            float r7 = r5.angleDiff
            float r8 = r5.angle
            float r7 = r7 - r8
            r5.angleDiff = r7
        L_0x00a8:
            r6 = r6 & r2
            r7 = 0
            if (r6 != 0) goto L_0x00c8
            float r8 = r5.angle
            float r9 = r5.angleDiff
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r10 = r0.angleValue
            float r10 = r10.getScale(r7)
            float r10 = r10 * r9
            float r10 = r10 + r8
            r5.angle = r10
            float r8 = com.badlogic.gdx.math.MathUtils.cosDeg(r10)
            r5.angleCos = r8
            float r8 = com.badlogic.gdx.math.MathUtils.sinDeg(r10)
            r5.angleSin = r8
            goto L_0x00c9
        L_0x00c8:
            r10 = 0
        L_0x00c9:
            float r8 = r1.getWidth()
            float r1 = r1.getHeight()
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.xScaleValue
            float r9 = r9.newLowValue()
            float r9 = r9 / r8
            r5.xScale = r9
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.xScaleValue
            float r9 = r9.newHighValue()
            float r9 = r9 / r8
            r5.xScaleDiff = r9
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.xScaleValue
            boolean r9 = r9.isRelative()
            if (r9 != 0) goto L_0x00f2
            float r9 = r5.xScaleDiff
            float r11 = r5.xScale
            float r9 = r9 - r11
            r5.xScaleDiff = r9
        L_0x00f2:
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.yScaleValue
            boolean r11 = r9.active
            if (r11 == 0) goto L_0x0135
            float r9 = r9.newLowValue()
            float r9 = r9 / r1
            r5.yScale = r9
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.yScaleValue
            float r9 = r9.newHighValue()
            float r9 = r9 / r1
            r5.yScaleDiff = r9
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.yScaleValue
            boolean r9 = r9.isRelative()
            if (r9 != 0) goto L_0x0117
            float r9 = r5.yScaleDiff
            float r11 = r5.yScale
            float r9 = r9 - r11
            r5.yScaleDiff = r9
        L_0x0117:
            float r9 = r5.xScale
            float r11 = r5.xScaleDiff
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r12 = r0.xScaleValue
            float r12 = r12.getScale(r7)
            float r12 = r12 * r11
            float r12 = r12 + r9
            float r9 = r5.yScale
            float r11 = r5.yScaleDiff
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r13 = r0.yScaleValue
            float r13 = r13.getScale(r7)
            float r13 = r13 * r11
            float r13 = r13 + r9
            r5.setScale(r12, r13)
            goto L_0x0145
        L_0x0135:
            float r9 = r5.xScale
            float r11 = r5.xScaleDiff
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r12 = r0.xScaleValue
            float r12 = r12.getScale(r7)
            float r12 = r12 * r11
            float r12 = r12 + r9
            r5.setScale(r12)
        L_0x0145:
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.rotationValue
            boolean r11 = r9.active
            if (r11 == 0) goto L_0x017d
            float r9 = r9.newLowValue()
            r5.rotation = r9
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.rotationValue
            float r9 = r9.newHighValue()
            r5.rotationDiff = r9
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.rotationValue
            boolean r9 = r9.isRelative()
            if (r9 != 0) goto L_0x0168
            float r9 = r5.rotationDiff
            float r11 = r5.rotation
            float r9 = r9 - r11
            r5.rotationDiff = r9
        L_0x0168:
            float r9 = r5.rotation
            float r11 = r5.rotationDiff
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r12 = r0.rotationValue
            float r12 = r12.getScale(r7)
            float r12 = r12 * r11
            float r12 = r12 + r9
            boolean r9 = r0.aligned
            if (r9 == 0) goto L_0x017a
            float r12 = r12 + r10
        L_0x017a:
            r5.setRotation(r12)
        L_0x017d:
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.windValue
            boolean r10 = r9.active
            if (r10 == 0) goto L_0x01a0
            float r9 = r9.newLowValue()
            r5.wind = r9
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.windValue
            float r9 = r9.newHighValue()
            r5.windDiff = r9
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.windValue
            boolean r9 = r9.isRelative()
            if (r9 != 0) goto L_0x01a0
            float r9 = r5.windDiff
            float r10 = r5.wind
            float r9 = r9 - r10
            r5.windDiff = r9
        L_0x01a0:
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.gravityValue
            boolean r10 = r9.active
            if (r10 == 0) goto L_0x01c3
            float r9 = r9.newLowValue()
            r5.gravity = r9
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.gravityValue
            float r9 = r9.newHighValue()
            r5.gravityDiff = r9
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.gravityValue
            boolean r9 = r9.isRelative()
            if (r9 != 0) goto L_0x01c3
            float r9 = r5.gravityDiff
            float r10 = r5.gravity
            float r9 = r9 - r10
            r5.gravityDiff = r9
        L_0x01c3:
            float[] r9 = r5.tint
            r10 = 3
            if (r9 != 0) goto L_0x01cc
            float[] r9 = new float[r10]
            r5.tint = r9
        L_0x01cc:
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$GradientColorValue r11 = r0.tintValue
            float[] r11 = r11.getColor(r7)
            r12 = 0
            r13 = r11[r12]
            r9[r12] = r13
            r12 = r11[r3]
            r9[r3] = r12
            r11 = r11[r2]
            r9[r2] = r11
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.transparencyValue
            float r9 = r9.newLowValue()
            r5.transparency = r9
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r9 = r0.transparencyValue
            float r9 = r9.newHighValue()
            float r11 = r5.transparency
            float r9 = r9 - r11
            r5.transparencyDiff = r9
            float r9 = r0.x
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$RangedNumericValue r11 = r0.xOffsetValue
            boolean r12 = r11.active
            if (r12 == 0) goto L_0x01ff
            float r11 = r11.newLowValue()
            float r9 = r9 + r11
        L_0x01ff:
            float r11 = r0.y
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$RangedNumericValue r12 = r0.yOffsetValue
            boolean r13 = r12.active
            if (r13 == 0) goto L_0x020c
            float r12 = r12.newLowValue()
            float r11 = r11 + r12
        L_0x020c:
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpawnShapeValue r12 = r0.spawnShapeValue
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpawnShape r12 = r12.shape
            int r12 = r12.ordinal()
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 == r3) goto L_0x02c5
            if (r12 == r2) goto L_0x029c
            if (r12 == r10) goto L_0x021e
            goto L_0x02f6
        L_0x021e:
            float r10 = r0.spawnWidth
            float r12 = r0.spawnWidthDiff
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r14 = r0.spawnWidthValue
            float r14 = r14.getScale(r4)
            float r14 = r14 * r12
            float r14 = r14 + r10
            float r10 = r0.spawnHeight
            float r12 = r0.spawnHeightDiff
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r15 = r0.spawnHeightValue
            float r15 = r15.getScale(r4)
            float r15 = r15 * r12
            float r15 = r15 + r10
            float r10 = r14 / r13
            float r15 = r15 / r13
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x02f6
            int r7 = (r15 > r7 ? 1 : (r15 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x0245
            goto L_0x02f6
        L_0x0245:
            float r7 = r10 / r15
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpawnShapeValue r12 = r0.spawnShapeValue
            boolean r15 = r12.edges
            if (r15 == 0) goto L_0x0283
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$SpawnEllipseSide r12 = r12.side
            int r12 = r12.ordinal()
            r14 = 1127415808(0x43330000, float:179.0)
            if (r12 == r3) goto L_0x0265
            if (r12 == r2) goto L_0x0260
            r2 = 1135869952(0x43b40000, float:360.0)
            float r2 = com.badlogic.gdx.math.MathUtils.random(r2)
            goto L_0x026a
        L_0x0260:
            float r2 = com.badlogic.gdx.math.MathUtils.random(r14)
            goto L_0x026a
        L_0x0265:
            float r2 = com.badlogic.gdx.math.MathUtils.random(r14)
            float r2 = -r2
        L_0x026a:
            float r12 = com.badlogic.gdx.math.MathUtils.cosDeg(r2)
            float r14 = com.badlogic.gdx.math.MathUtils.sinDeg(r2)
            float r15 = r12 * r10
            float r9 = r9 + r15
            float r10 = r10 * r14
            float r10 = r10 / r7
            float r11 = r11 + r10
            if (r6 != 0) goto L_0x02f6
            r5.angle = r2
            r5.angleCos = r12
            r5.angleSin = r14
            goto L_0x02f6
        L_0x0283:
            float r2 = r10 * r10
        L_0x0285:
            float r6 = com.badlogic.gdx.math.MathUtils.random(r14)
            float r6 = r6 - r10
            float r12 = com.badlogic.gdx.math.MathUtils.random(r14)
            float r12 = r12 - r10
            float r15 = r6 * r6
            float r16 = r12 * r12
            float r16 = r16 + r15
            int r15 = (r16 > r2 ? 1 : (r16 == r2 ? 0 : -1))
            if (r15 > 0) goto L_0x0285
            float r9 = r9 + r6
            float r12 = r12 / r7
            goto L_0x02ed
        L_0x029c:
            float r2 = r0.spawnWidth
            float r6 = r0.spawnWidthDiff
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r7 = r0.spawnWidthValue
            float r7 = r7.getScale(r4)
            float r7 = r7 * r6
            float r7 = r7 + r2
            float r2 = r0.spawnHeight
            float r6 = r0.spawnHeightDiff
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r10 = r0.spawnHeightValue
            float r10 = r10.getScale(r4)
            float r10 = r10 * r6
            float r10 = r10 + r2
            float r2 = com.badlogic.gdx.math.MathUtils.random(r7)
            float r7 = r7 / r13
            float r2 = r2 - r7
            float r9 = r9 + r2
            float r2 = com.badlogic.gdx.math.MathUtils.random(r10)
            float r10 = r10 / r13
            float r2 = r2 - r10
        L_0x02c3:
            float r11 = r11 + r2
            goto L_0x02f6
        L_0x02c5:
            float r2 = r0.spawnWidth
            float r6 = r0.spawnWidthDiff
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r10 = r0.spawnWidthValue
            float r10 = r10.getScale(r4)
            float r10 = r10 * r6
            float r10 = r10 + r2
            float r2 = r0.spawnHeight
            float r6 = r0.spawnHeightDiff
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r12 = r0.spawnHeightValue
            float r12 = r12.getScale(r4)
            float r12 = r12 * r6
            float r12 = r12 + r2
            int r2 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x02ef
            float r2 = com.badlogic.gdx.math.MathUtils.random()
            float r2 = r2 * r10
            float r9 = r9 + r2
            float r12 = r12 / r10
            float r12 = r12 * r2
        L_0x02ed:
            float r11 = r11 + r12
            goto L_0x02f6
        L_0x02ef:
            float r2 = com.badlogic.gdx.math.MathUtils.random()
            float r2 = r2 * r12
            goto L_0x02c3
        L_0x02f6:
            float r2 = r8 / r13
            float r9 = r9 - r2
            float r2 = r1 / r13
            float r11 = r11 - r2
            r5.setBounds(r9, r11, r8, r1)
            int r1 = r0.lifeOffset
            float r1 = (float) r1
            int r2 = r0.lifeOffsetDiff
            float r2 = (float) r2
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$IndependentScaledNumericValue r6 = r0.lifeOffsetValue
            float r4 = r6.getScale(r4)
            float r4 = r4 * r2
            float r4 = r4 + r1
            int r1 = (int) r4
            if (r1 <= 0) goto L_0x031e
            int r2 = r5.currentLife
            if (r1 < r2) goto L_0x0317
            int r1 = r2 + -1
        L_0x0317:
            float r2 = (float) r1
            r3 = 1148846080(0x447a0000, float:1000.0)
            float r2 = r2 / r3
            r0.updateParticle(r5, r2, r1)
        L_0x031e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.ParticleEmitter.activateParticle(int):void");
    }

    private void generateLifeOffsetValues() {
        IndependentScaledNumericValue independentScaledNumericValue = this.lifeOffsetValue;
        this.lifeOffset = independentScaledNumericValue.active ? (int) independentScaledNumericValue.newLowValue() : 0;
        this.lifeOffsetDiff = (int) this.lifeOffsetValue.newHighValue();
        if (!this.lifeOffsetValue.isRelative()) {
            this.lifeOffsetDiff -= this.lifeOffset;
        }
    }

    private void generateLifeValues() {
        this.life = (int) this.lifeValue.newLowValue();
        this.lifeDiff = (int) this.lifeValue.newHighValue();
        if (!this.lifeValue.isRelative()) {
            this.lifeDiff -= this.life;
        }
    }

    private void initialize() {
        this.sprites = new Array<>();
        this.imagePaths = new Array<>();
        this.durationValue.setAlwaysActive(true);
        this.emissionValue.setAlwaysActive(true);
        this.lifeValue.setAlwaysActive(true);
        this.xScaleValue.setAlwaysActive(true);
        this.transparencyValue.setAlwaysActive(true);
        this.spawnShapeValue.setAlwaysActive(true);
        this.spawnWidthValue.setAlwaysActive(true);
        this.spawnHeightValue.setAlwaysActive(true);
    }

    public static boolean readBoolean(String str) throws IOException {
        return Boolean.parseBoolean(readString(str));
    }

    public static float readFloat(BufferedReader bufferedReader, String str) throws IOException {
        return Float.parseFloat(readString(bufferedReader, str));
    }

    public static int readInt(BufferedReader bufferedReader, String str) throws IOException {
        return Integer.parseInt(readString(bufferedReader, str));
    }

    public static String readString(String str) throws IOException {
        return str.substring(str.indexOf(":") + 1).trim();
    }

    private void restart() {
        RangedNumericValue rangedNumericValue = this.delayValue;
        this.delay = rangedNumericValue.active ? rangedNumericValue.newLowValue() : 0.0f;
        this.delayTimer = 0.0f;
        this.durationTimer -= this.duration;
        this.duration = this.durationValue.newLowValue();
        this.emission = (int) this.emissionValue.newLowValue();
        this.emissionDiff = (int) this.emissionValue.newHighValue();
        if (!this.emissionValue.isRelative()) {
            this.emissionDiff -= this.emission;
        }
        if (!this.lifeValue.independent) {
            generateLifeValues();
        }
        if (!this.lifeOffsetValue.independent) {
            generateLifeOffsetValues();
        }
        this.spawnWidth = this.spawnWidthValue.newLowValue();
        this.spawnWidthDiff = this.spawnWidthValue.newHighValue();
        if (!this.spawnWidthValue.isRelative()) {
            this.spawnWidthDiff -= this.spawnWidth;
        }
        this.spawnHeight = this.spawnHeightValue.newLowValue();
        this.spawnHeightDiff = this.spawnHeightValue.newHighValue();
        if (!this.spawnHeightValue.isRelative()) {
            this.spawnHeightDiff -= this.spawnHeight;
        }
        this.updateFlags = 0;
        ScaledNumericValue scaledNumericValue = this.angleValue;
        if (scaledNumericValue.active && scaledNumericValue.timeline.length > 1) {
            this.updateFlags = 0 | 2;
        }
        if (this.velocityValue.active) {
            this.updateFlags |= 8;
        }
        if (this.xScaleValue.timeline.length > 1) {
            this.updateFlags |= 1;
        }
        ScaledNumericValue scaledNumericValue2 = this.yScaleValue;
        if (scaledNumericValue2.active && scaledNumericValue2.timeline.length > 1) {
            this.updateFlags |= 1;
        }
        ScaledNumericValue scaledNumericValue3 = this.rotationValue;
        if (scaledNumericValue3.active && scaledNumericValue3.timeline.length > 1) {
            this.updateFlags |= 4;
        }
        if (this.windValue.active) {
            this.updateFlags |= 16;
        }
        if (this.gravityValue.active) {
            this.updateFlags |= 32;
        }
        if (this.tintValue.timeline.length > 1) {
            this.updateFlags |= 64;
        }
        if (this.spriteMode == SpriteMode.animated) {
            this.updateFlags |= 128;
        }
    }

    private boolean updateParticle(Particle particle, float f2, int i) {
        float[] fArr;
        float f3;
        float f4;
        int i2 = particle.currentLife - i;
        if (i2 <= 0) {
            return false;
        }
        particle.currentLife = i2;
        float f5 = 1.0f;
        float f6 = 1.0f - (((float) i2) / ((float) particle.life));
        int i3 = this.updateFlags;
        if ((i3 & 1) != 0) {
            if (this.yScaleValue.active) {
                particle.setScale((this.xScaleValue.getScale(f6) * particle.xScaleDiff) + particle.xScale, (this.yScaleValue.getScale(f6) * particle.yScaleDiff) + particle.yScale);
            } else {
                particle.setScale((this.xScaleValue.getScale(f6) * particle.xScaleDiff) + particle.xScale);
            }
        }
        if ((i3 & 8) != 0) {
            float scale = ((this.velocityValue.getScale(f6) * particle.velocityDiff) + particle.velocity) * f2;
            if ((i3 & 2) != 0) {
                float scale2 = (this.angleValue.getScale(f6) * particle.angleDiff) + particle.angle;
                f4 = MathUtils.cosDeg(scale2) * scale;
                f3 = MathUtils.sinDeg(scale2) * scale;
                if ((i3 & 4) != 0) {
                    float scale3 = (this.rotationValue.getScale(f6) * particle.rotationDiff) + particle.rotation;
                    if (this.aligned) {
                        scale3 += scale2;
                    }
                    particle.setRotation(scale3);
                }
            } else {
                f4 = particle.angleCos * scale;
                f3 = particle.angleSin * scale;
                if (this.aligned || (i3 & 4) != 0) {
                    float scale4 = (this.rotationValue.getScale(f6) * particle.rotationDiff) + particle.rotation;
                    if (this.aligned) {
                        scale4 += particle.angle;
                    }
                    particle.setRotation(scale4);
                }
            }
            if ((i3 & 16) != 0) {
                f4 += ((this.windValue.getScale(f6) * particle.windDiff) + particle.wind) * f2;
            }
            if ((i3 & 32) != 0) {
                f3 += ((this.gravityValue.getScale(f6) * particle.gravityDiff) + particle.gravity) * f2;
            }
            particle.translate(f4, f3);
        } else if ((i3 & 4) != 0) {
            particle.setRotation((this.rotationValue.getScale(f6) * particle.rotationDiff) + particle.rotation);
        }
        if ((i3 & 64) != 0) {
            fArr = this.tintValue.getColor(f6);
        } else {
            fArr = particle.tint;
        }
        if (this.premultipliedAlpha) {
            if (this.additive) {
                f5 = 0.0f;
            }
            float scale5 = (this.transparencyValue.getScale(f6) * particle.transparencyDiff) + particle.transparency;
            particle.setColor(fArr[0] * scale5, fArr[1] * scale5, fArr[2] * scale5, scale5 * f5);
        } else {
            particle.setColor(fArr[0], fArr[1], fArr[2], (this.transparencyValue.getScale(f6) * particle.transparencyDiff) + particle.transparency);
        }
        if ((i3 & 128) != 0) {
            int i4 = this.sprites.size;
            int min = Math.min((int) (f6 * ((float) i4)), i4 - 1);
            if (particle.frame != min) {
                Sprite sprite = (Sprite) this.sprites.get(min);
                float width = particle.getWidth();
                float height = particle.getHeight();
                particle.setRegion((TextureRegion) sprite);
                particle.setSize(sprite.getWidth(), sprite.getHeight());
                particle.setOrigin(sprite.getOriginX(), sprite.getOriginY());
                particle.translate((width - sprite.getWidth()) / 2.0f, (height - sprite.getHeight()) / 2.0f);
                particle.frame = min;
            }
        }
        return true;
    }

    public void addParticle() {
        int i = this.activeCount;
        if (i != this.maxParticleCount) {
            boolean[] zArr = this.active;
            int i2 = 0;
            int length = zArr.length;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (!zArr[i2]) {
                    activateParticle(i2);
                    zArr[i2] = true;
                    this.activeCount = i + 1;
                    break;
                } else {
                    i2++;
                }
            }
        }
    }

    public void addParticles(int i) {
        int min = Math.min(i, this.maxParticleCount - this.activeCount);
        if (min != 0) {
            boolean[] zArr = this.active;
            int length = zArr.length;
            int i2 = 0;
            int i3 = 0;
            loop0:
            while (i2 < min) {
                while (i3 < length) {
                    if (!zArr[i3]) {
                        activateParticle(i3);
                        zArr[i3] = true;
                        i2++;
                        i3++;
                    } else {
                        i3++;
                    }
                }
                break loop0;
            }
            this.activeCount += min;
        }
    }

    public void allowCompletion() {
        this.allowCompletion = true;
        this.durationTimer = this.duration;
    }

    public boolean cleansUpBlendFunction() {
        return this.cleansUpBlendFunction;
    }

    public void draw(Batch batch) {
        if (this.premultipliedAlpha) {
            batch.setBlendFunction(1, GL20.GL_ONE_MINUS_SRC_ALPHA);
        } else if (this.additive) {
            batch.setBlendFunction(GL20.GL_SRC_ALPHA, 1);
        } else {
            batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        }
        Particle[] particleArr = this.particles;
        boolean[] zArr = this.active;
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (zArr[i]) {
                particleArr[i].draw(batch);
            }
        }
        if (!this.cleansUpBlendFunction) {
            return;
        }
        if (this.additive || this.premultipliedAlpha) {
            batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        }
    }

    public void flipY() {
        ScaledNumericValue scaledNumericValue = this.angleValue;
        scaledNumericValue.setHigh(-scaledNumericValue.getHighMin(), -this.angleValue.getHighMax());
        ScaledNumericValue scaledNumericValue2 = this.angleValue;
        scaledNumericValue2.setLow(-scaledNumericValue2.getLowMin(), -this.angleValue.getLowMax());
        ScaledNumericValue scaledNumericValue3 = this.gravityValue;
        scaledNumericValue3.setHigh(-scaledNumericValue3.getHighMin(), -this.gravityValue.getHighMax());
        ScaledNumericValue scaledNumericValue4 = this.gravityValue;
        scaledNumericValue4.setLow(-scaledNumericValue4.getLowMin(), -this.gravityValue.getLowMax());
        ScaledNumericValue scaledNumericValue5 = this.windValue;
        scaledNumericValue5.setHigh(-scaledNumericValue5.getHighMin(), -this.windValue.getHighMax());
        ScaledNumericValue scaledNumericValue6 = this.windValue;
        scaledNumericValue6.setLow(-scaledNumericValue6.getLowMin(), -this.windValue.getLowMax());
        ScaledNumericValue scaledNumericValue7 = this.rotationValue;
        scaledNumericValue7.setHigh(-scaledNumericValue7.getHighMin(), -this.rotationValue.getHighMax());
        ScaledNumericValue scaledNumericValue8 = this.rotationValue;
        scaledNumericValue8.setLow(-scaledNumericValue8.getLowMin(), -this.rotationValue.getLowMax());
        RangedNumericValue rangedNumericValue = this.yOffsetValue;
        rangedNumericValue.setLow(-rangedNumericValue.getLowMin(), -this.yOffsetValue.getLowMax());
    }

    public int getActiveCount() {
        return this.activeCount;
    }

    public ScaledNumericValue getAngle() {
        return this.angleValue;
    }

    public BoundingBox getBoundingBox() {
        if (this.bounds == null) {
            this.bounds = new BoundingBox();
        }
        Particle[] particleArr = this.particles;
        boolean[] zArr = this.active;
        BoundingBox boundingBox = this.bounds;
        boundingBox.inf();
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (zArr[i]) {
                Rectangle boundingRectangle = particleArr[i].getBoundingRectangle();
                boundingBox.ext(boundingRectangle.x, boundingRectangle.y, 0.0f);
                boundingBox.ext(boundingRectangle.x + boundingRectangle.width, boundingRectangle.y + boundingRectangle.height, 0.0f);
            }
        }
        return boundingBox;
    }

    public RangedNumericValue getDelay() {
        return this.delayValue;
    }

    public RangedNumericValue getDuration() {
        return this.durationValue;
    }

    public ScaledNumericValue getEmission() {
        return this.emissionValue;
    }

    public ScaledNumericValue getGravity() {
        return this.gravityValue;
    }

    public Array<String> getImagePaths() {
        return this.imagePaths;
    }

    public ScaledNumericValue getLife() {
        return this.lifeValue;
    }

    public ScaledNumericValue getLifeOffset() {
        return this.lifeOffsetValue;
    }

    public int getMaxParticleCount() {
        return this.maxParticleCount;
    }

    public int getMinParticleCount() {
        return this.minParticleCount;
    }

    public RangedNumericValue[] getMotionValues() {
        if (this.motionValues == null) {
            RangedNumericValue[] rangedNumericValueArr = new RangedNumericValue[3];
            this.motionValues = rangedNumericValueArr;
            rangedNumericValueArr[0] = this.velocityValue;
            rangedNumericValueArr[1] = this.windValue;
            rangedNumericValueArr[2] = this.gravityValue;
        }
        return this.motionValues;
    }

    public String getName() {
        return this.name;
    }

    public Particle[] getParticles() {
        return this.particles;
    }

    public float getPercentComplete() {
        if (this.delayTimer < this.delay) {
            return 0.0f;
        }
        return Math.min(1.0f, this.durationTimer / this.duration);
    }

    public ScaledNumericValue getRotation() {
        return this.rotationValue;
    }

    public ScaledNumericValue getSpawnHeight() {
        return this.spawnHeightValue;
    }

    public SpawnShapeValue getSpawnShape() {
        return this.spawnShapeValue;
    }

    public ScaledNumericValue getSpawnWidth() {
        return this.spawnWidthValue;
    }

    public SpriteMode getSpriteMode() {
        return this.spriteMode;
    }

    public Array<Sprite> getSprites() {
        return this.sprites;
    }

    public GradientColorValue getTint() {
        return this.tintValue;
    }

    public ScaledNumericValue getTransparency() {
        return this.transparencyValue;
    }

    public ScaledNumericValue getVelocity() {
        return this.velocityValue;
    }

    public ScaledNumericValue getWind() {
        return this.windValue;
    }

    public float getX() {
        return this.x;
    }

    public RangedNumericValue getXOffsetValue() {
        return this.xOffsetValue;
    }

    public ScaledNumericValue getXScale() {
        return this.xScaleValue;
    }

    public RangedNumericValue[] getXSizeValues() {
        if (this.xSizeValues == null) {
            RangedNumericValue[] rangedNumericValueArr = new RangedNumericValue[3];
            this.xSizeValues = rangedNumericValueArr;
            rangedNumericValueArr[0] = this.xScaleValue;
            rangedNumericValueArr[1] = this.spawnWidthValue;
            rangedNumericValueArr[2] = this.xOffsetValue;
        }
        return this.xSizeValues;
    }

    public float getY() {
        return this.y;
    }

    public RangedNumericValue getYOffsetValue() {
        return this.yOffsetValue;
    }

    public ScaledNumericValue getYScale() {
        return this.yScaleValue;
    }

    public RangedNumericValue[] getYSizeValues() {
        if (this.ySizeValues == null) {
            RangedNumericValue[] rangedNumericValueArr = new RangedNumericValue[3];
            this.ySizeValues = rangedNumericValueArr;
            rangedNumericValueArr[0] = this.yScaleValue;
            rangedNumericValueArr[1] = this.spawnHeightValue;
            rangedNumericValueArr[2] = this.yOffsetValue;
        }
        return this.ySizeValues;
    }

    public boolean isAdditive() {
        return this.additive;
    }

    public boolean isAligned() {
        return this.aligned;
    }

    public boolean isAttached() {
        return this.attached;
    }

    public boolean isBehind() {
        return this.behind;
    }

    public boolean isComplete() {
        boolean z = false;
        if ((this.continuous && !this.allowCompletion) || this.delayTimer < this.delay) {
            return false;
        }
        if (this.durationTimer >= this.duration && this.activeCount == 0) {
            z = true;
        }
        return z;
    }

    public boolean isContinuous() {
        return this.continuous;
    }

    public boolean isPremultipliedAlpha() {
        return this.premultipliedAlpha;
    }

    public void load(BufferedReader bufferedReader) throws IOException {
        try {
            this.name = readString(bufferedReader, "name");
            bufferedReader.readLine();
            this.delayValue.load(bufferedReader);
            bufferedReader.readLine();
            this.durationValue.load(bufferedReader);
            bufferedReader.readLine();
            setMinParticleCount(readInt(bufferedReader, "minParticleCount"));
            setMaxParticleCount(readInt(bufferedReader, "maxParticleCount"));
            bufferedReader.readLine();
            this.emissionValue.load(bufferedReader);
            bufferedReader.readLine();
            this.lifeValue.load(bufferedReader);
            bufferedReader.readLine();
            this.lifeOffsetValue.load(bufferedReader);
            bufferedReader.readLine();
            this.xOffsetValue.load(bufferedReader);
            bufferedReader.readLine();
            this.yOffsetValue.load(bufferedReader);
            bufferedReader.readLine();
            this.spawnShapeValue.load(bufferedReader);
            bufferedReader.readLine();
            this.spawnWidthValue.load(bufferedReader);
            bufferedReader.readLine();
            this.spawnHeightValue.load(bufferedReader);
            if (bufferedReader.readLine().trim().equals("- Scale -")) {
                this.xScaleValue.load(bufferedReader);
                this.yScaleValue.setActive(false);
            } else {
                this.xScaleValue.load(bufferedReader);
                bufferedReader.readLine();
                this.yScaleValue.load(bufferedReader);
            }
            bufferedReader.readLine();
            this.velocityValue.load(bufferedReader);
            bufferedReader.readLine();
            this.angleValue.load(bufferedReader);
            bufferedReader.readLine();
            this.rotationValue.load(bufferedReader);
            bufferedReader.readLine();
            this.windValue.load(bufferedReader);
            bufferedReader.readLine();
            this.gravityValue.load(bufferedReader);
            bufferedReader.readLine();
            this.tintValue.load(bufferedReader);
            bufferedReader.readLine();
            this.transparencyValue.load(bufferedReader);
            bufferedReader.readLine();
            this.attached = readBoolean(bufferedReader, AnalyticsConstants.ATTACHED);
            this.continuous = readBoolean(bufferedReader, "continuous");
            this.aligned = readBoolean(bufferedReader, "aligned");
            this.additive = readBoolean(bufferedReader, "additive");
            this.behind = readBoolean(bufferedReader, "behind");
            String readLine = bufferedReader.readLine();
            if (readLine.startsWith("premultipliedAlpha")) {
                this.premultipliedAlpha = readBoolean(readLine);
                readLine = bufferedReader.readLine();
            }
            if (readLine.startsWith("spriteMode")) {
                this.spriteMode = SpriteMode.valueOf(readString(readLine));
                bufferedReader.readLine();
            }
            Array array = new Array();
            while (true) {
                String readLine2 = bufferedReader.readLine();
                if (readLine2 == null || readLine2.isEmpty()) {
                    setImagePaths(array);
                } else {
                    array.add(readLine2);
                }
            }
            setImagePaths(array);
        } catch (RuntimeException e2) {
            if (this.name == null) {
                throw e2;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error parsing emitter: ");
            outline73.append(this.name);
            throw new RuntimeException(outline73.toString(), e2);
        }
    }

    public void matchMotion(ParticleEmitter particleEmitter) {
        RangedNumericValue[] motionValues2 = getMotionValues();
        RangedNumericValue[] motionValues3 = particleEmitter.getMotionValues();
        for (int i = 0; i < motionValues2.length; i++) {
            motionValues2[i].set(motionValues3[i]);
        }
    }

    public void matchSize(ParticleEmitter particleEmitter) {
        matchXSize(particleEmitter);
        matchYSize(particleEmitter);
    }

    public void matchXSize(ParticleEmitter particleEmitter) {
        RangedNumericValue[] xSizeValues2 = getXSizeValues();
        RangedNumericValue[] xSizeValues3 = particleEmitter.getXSizeValues();
        for (int i = 0; i < xSizeValues2.length; i++) {
            xSizeValues2[i].set(xSizeValues3[i]);
        }
    }

    public void matchYSize(ParticleEmitter particleEmitter) {
        RangedNumericValue[] ySizeValues2 = getYSizeValues();
        RangedNumericValue[] ySizeValues3 = particleEmitter.getYSizeValues();
        for (int i = 0; i < ySizeValues2.length; i++) {
            ySizeValues2[i].set(ySizeValues3[i]);
        }
    }

    public Particle newParticle(Sprite sprite) {
        return new Particle(sprite);
    }

    public void preAllocateParticles() {
        int i = 0;
        if (!(this.sprites.size == 0)) {
            while (true) {
                Particle[] particleArr = this.particles;
                if (i < particleArr.length) {
                    if (particleArr[i] == null) {
                        Particle newParticle = newParticle((Sprite) this.sprites.first());
                        particleArr[i] = newParticle;
                        newParticle.flip(this.flipX, this.flipY);
                    }
                    i++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("ParticleEmitter.setSprites() must have been called before preAllocateParticles()");
        }
    }

    public void reset() {
        this.emissionDelta = 0;
        this.durationTimer = this.duration;
        boolean[] zArr = this.active;
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            zArr[i] = false;
        }
        this.activeCount = 0;
        start();
    }

    public void save(Writer writer) throws IOException {
        writer.write(this.name + "\n");
        writer.write("- Delay -\n");
        this.delayValue.save(writer);
        writer.write("- Duration - \n");
        this.durationValue.save(writer);
        writer.write("- Count - \n");
        writer.write("min: " + this.minParticleCount + "\n");
        writer.write("max: " + this.maxParticleCount + "\n");
        writer.write("- Emission - \n");
        this.emissionValue.save(writer);
        writer.write("- Life - \n");
        this.lifeValue.save(writer);
        writer.write("- Life Offset - \n");
        this.lifeOffsetValue.save(writer);
        writer.write("- X Offset - \n");
        this.xOffsetValue.save(writer);
        writer.write("- Y Offset - \n");
        this.yOffsetValue.save(writer);
        writer.write("- Spawn Shape - \n");
        this.spawnShapeValue.save(writer);
        writer.write("- Spawn Width - \n");
        this.spawnWidthValue.save(writer);
        writer.write("- Spawn Height - \n");
        this.spawnHeightValue.save(writer);
        writer.write("- X Scale - \n");
        this.xScaleValue.save(writer);
        writer.write("- Y Scale - \n");
        this.yScaleValue.save(writer);
        writer.write("- Velocity - \n");
        this.velocityValue.save(writer);
        writer.write("- Angle - \n");
        this.angleValue.save(writer);
        writer.write("- Rotation - \n");
        this.rotationValue.save(writer);
        writer.write("- Wind - \n");
        this.windValue.save(writer);
        writer.write("- Gravity - \n");
        this.gravityValue.save(writer);
        writer.write("- Tint - \n");
        this.tintValue.save(writer);
        writer.write("- Transparency - \n");
        this.transparencyValue.save(writer);
        writer.write("- Options - \n");
        writer.write("attached: " + this.attached + "\n");
        writer.write("continuous: " + this.continuous + "\n");
        writer.write("aligned: " + this.aligned + "\n");
        writer.write("additive: " + this.additive + "\n");
        writer.write("behind: " + this.behind + "\n");
        writer.write("premultipliedAlpha: " + this.premultipliedAlpha + "\n");
        writer.write("spriteMode: " + this.spriteMode.toString() + "\n");
        writer.write("- Image Paths -\n");
        ArrayIterator it = this.imagePaths.iterator();
        while (it.hasNext()) {
            writer.write(((String) it.next()) + "\n");
        }
        writer.write("\n");
    }

    public void scaleMotion(float f2) {
        if (f2 != 1.0f) {
            for (RangedNumericValue scale : getMotionValues()) {
                scale.scale(f2);
            }
        }
    }

    public void scaleSize(float f2) {
        if (f2 != 1.0f) {
            scaleSize(f2, f2);
        }
    }

    public void setAdditive(boolean z) {
        this.additive = z;
    }

    public void setAligned(boolean z) {
        this.aligned = z;
    }

    public void setAttached(boolean z) {
        this.attached = z;
    }

    public void setBehind(boolean z) {
        this.behind = z;
    }

    public void setCleansUpBlendFunction(boolean z) {
        this.cleansUpBlendFunction = z;
    }

    public void setContinuous(boolean z) {
        this.continuous = z;
    }

    public void setFlip(boolean z, boolean z2) {
        this.flipX = z;
        this.flipY = z2;
        Particle[] particleArr = this.particles;
        if (particleArr != null) {
            int length = particleArr.length;
            for (int i = 0; i < length; i++) {
                Particle particle = this.particles[i];
                if (particle != null) {
                    particle.flip(z, z2);
                }
            }
        }
    }

    public void setImagePaths(Array<String> array) {
        this.imagePaths = array;
    }

    public void setMaxParticleCount(int i) {
        this.maxParticleCount = i;
        this.active = new boolean[i];
        this.activeCount = 0;
        this.particles = new Particle[i];
    }

    public void setMinParticleCount(int i) {
        this.minParticleCount = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPosition(float f2, float f3) {
        if (this.attached) {
            float f4 = f2 - this.x;
            float f5 = f3 - this.y;
            boolean[] zArr = this.active;
            int length = zArr.length;
            for (int i = 0; i < length; i++) {
                if (zArr[i]) {
                    this.particles[i].translate(f4, f5);
                }
            }
        }
        this.x = f2;
        this.y = f3;
    }

    public void setPremultipliedAlpha(boolean z) {
        this.premultipliedAlpha = z;
    }

    public void setSpriteMode(SpriteMode spriteMode2) {
        this.spriteMode = spriteMode2;
    }

    public void setSprites(Array<Sprite> array) {
        this.sprites = array;
        if (array.size != 0) {
            for (Particle particle : this.particles) {
                if (particle == null) {
                    break;
                }
                Sprite sprite = null;
                int ordinal = this.spriteMode.ordinal();
                if (ordinal == 0) {
                    sprite = (Sprite) array.first();
                } else if (ordinal == 1) {
                    sprite = (Sprite) array.random();
                } else if (ordinal == 2) {
                    float f2 = 1.0f - (((float) particle.currentLife) / ((float) particle.life));
                    int i = array.size;
                    int min = Math.min((int) (f2 * ((float) i)), i - 1);
                    particle.frame = min;
                    sprite = (Sprite) array.get(min);
                }
                particle.setRegion((TextureRegion) sprite);
                particle.setOrigin(sprite.getOriginX(), sprite.getOriginY());
            }
        }
    }

    public void start() {
        this.firstUpdate = true;
        this.allowCompletion = false;
        restart();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(float r9) {
        /*
            r8 = this;
            float r0 = r8.accumulator
            r1 = 1148846080(0x447a0000, float:1000.0)
            float r2 = r9 * r1
            float r2 = r2 + r0
            r8.accumulator = r2
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0010
            return
        L_0x0010:
            int r0 = (int) r2
            float r3 = (float) r0
            float r2 = r2 - r3
            r8.accumulator = r2
            float r2 = r8.delayTimer
            float r4 = r8.delay
            r5 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0023
            float r2 = r2 + r3
            r8.delayTimer = r2
            goto L_0x0097
        L_0x0023:
            boolean r2 = r8.firstUpdate
            if (r2 == 0) goto L_0x002c
            r8.firstUpdate = r5
            r8.addParticle()
        L_0x002c:
            float r2 = r8.durationTimer
            float r4 = r8.duration
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0038
            float r2 = r2 + r3
            r8.durationTimer = r2
            goto L_0x0044
        L_0x0038:
            boolean r2 = r8.continuous
            if (r2 == 0) goto L_0x0046
            boolean r2 = r8.allowCompletion
            if (r2 == 0) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            r8.restart()
        L_0x0044:
            r2 = 0
            goto L_0x0047
        L_0x0046:
            r2 = 1
        L_0x0047:
            if (r2 != 0) goto L_0x0097
            int r2 = r8.emissionDelta
            int r2 = r2 + r0
            r8.emissionDelta = r2
            int r2 = r8.emission
            float r2 = (float) r2
            int r3 = r8.emissionDiff
            float r3 = (float) r3
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$ScaledNumericValue r4 = r8.emissionValue
            float r6 = r8.durationTimer
            float r7 = r8.duration
            float r6 = r6 / r7
            float r4 = r4.getScale(r6)
            float r4 = r4 * r3
            float r4 = r4 + r2
            r2 = 0
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x008d
            float r1 = r1 / r4
            int r2 = r8.emissionDelta
            float r3 = (float) r2
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x008d
            float r2 = (float) r2
            float r2 = r2 / r1
            int r2 = (int) r2
            int r3 = r8.maxParticleCount
            int r4 = r8.activeCount
            int r3 = r3 - r4
            int r2 = java.lang.Math.min(r2, r3)
            int r3 = r8.emissionDelta
            float r3 = (float) r3
            float r4 = (float) r2
            float r4 = r4 * r1
            float r3 = r3 - r4
            int r3 = (int) r3
            r8.emissionDelta = r3
            float r3 = (float) r3
            float r3 = r3 % r1
            int r1 = (int) r3
            r8.emissionDelta = r1
            r8.addParticles(r2)
        L_0x008d:
            int r1 = r8.activeCount
            int r2 = r8.minParticleCount
            if (r1 >= r2) goto L_0x0097
            int r2 = r2 - r1
            r8.addParticles(r2)
        L_0x0097:
            boolean[] r1 = r8.active
            int r2 = r8.activeCount
            com.badlogic.gdx.graphics.g2d.ParticleEmitter$Particle[] r3 = r8.particles
            int r4 = r1.length
            r6 = 0
        L_0x009f:
            if (r6 >= r4) goto L_0x00b4
            boolean r7 = r1[r6]
            if (r7 == 0) goto L_0x00b1
            r7 = r3[r6]
            boolean r7 = r8.updateParticle(r7, r9, r0)
            if (r7 != 0) goto L_0x00b1
            r1[r6] = r5
            int r2 = r2 + -1
        L_0x00b1:
            int r6 = r6 + 1
            goto L_0x009f
        L_0x00b4:
            r8.activeCount = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.ParticleEmitter.update(float):void");
    }

    public static boolean readBoolean(BufferedReader bufferedReader, String str) throws IOException {
        return Boolean.parseBoolean(readString(bufferedReader, str));
    }

    public static String readString(BufferedReader bufferedReader, String str) throws IOException {
        String readLine = bufferedReader.readLine();
        if (readLine != null) {
            return readString(readLine);
        }
        throw new IOException(GeneratedOutlineSupport.outline50("Missing value: ", str));
    }

    public void scaleSize(float f2, float f3) {
        if (f2 != 1.0f || f3 != 1.0f) {
            for (RangedNumericValue scale : getXSizeValues()) {
                scale.scale(f2);
            }
            for (RangedNumericValue scale2 : getYSizeValues()) {
                scale2.scale(f3);
            }
        }
    }

    public void draw(Batch batch, float f2) {
        float f3 = (f2 * 1000.0f) + this.accumulator;
        this.accumulator = f3;
        if (f3 < 1.0f) {
            draw(batch);
            return;
        }
        int i = (int) f3;
        float f4 = (float) i;
        this.accumulator = f3 - f4;
        if (this.premultipliedAlpha) {
            batch.setBlendFunction(1, GL20.GL_ONE_MINUS_SRC_ALPHA);
        } else if (this.additive) {
            batch.setBlendFunction(GL20.GL_SRC_ALPHA, 1);
        } else {
            batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        }
        Particle[] particleArr = this.particles;
        boolean[] zArr = this.active;
        int i2 = this.activeCount;
        int length = zArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (zArr[i3]) {
                Particle particle = particleArr[i3];
                if (updateParticle(particle, f2, i)) {
                    particle.draw(batch);
                } else {
                    zArr[i3] = false;
                    i2--;
                }
            }
        }
        this.activeCount = i2;
        if (this.cleansUpBlendFunction && (this.additive || this.premultipliedAlpha)) {
            batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        }
        float f5 = this.delayTimer;
        if (f5 < this.delay) {
            this.delayTimer = f5 + f4;
            return;
        }
        if (this.firstUpdate) {
            this.firstUpdate = false;
            addParticle();
        }
        float f6 = this.durationTimer;
        if (f6 < this.duration) {
            this.durationTimer = f6 + f4;
        } else {
            if (this.continuous && !this.allowCompletion) {
                restart();
            }
        }
        this.emissionDelta += i;
        float scale = (this.emissionValue.getScale(this.durationTimer / this.duration) * ((float) this.emissionDiff)) + ((float) this.emission);
        if (scale > 0.0f) {
            float f7 = 1000.0f / scale;
            int i4 = this.emissionDelta;
            if (((float) i4) >= f7) {
                int min = Math.min((int) (((float) i4) / f7), this.maxParticleCount - i2);
                int i5 = (int) (((float) this.emissionDelta) - (((float) min) * f7));
                this.emissionDelta = i5;
                this.emissionDelta = (int) (((float) i5) % f7);
                addParticles(min);
            }
        }
        int i6 = this.minParticleCount;
        if (i2 < i6) {
            addParticles(i6 - i2);
        }
    }

    public ParticleEmitter(BufferedReader bufferedReader) throws IOException {
        initialize();
        load(bufferedReader);
    }

    public ParticleEmitter(ParticleEmitter particleEmitter) {
        this.sprites = new Array<>(particleEmitter.sprites);
        this.name = particleEmitter.name;
        this.imagePaths = new Array<>(particleEmitter.imagePaths);
        setMaxParticleCount(particleEmitter.maxParticleCount);
        this.minParticleCount = particleEmitter.minParticleCount;
        this.delayValue.load(particleEmitter.delayValue);
        this.durationValue.load(particleEmitter.durationValue);
        this.emissionValue.load(particleEmitter.emissionValue);
        this.lifeValue.load(particleEmitter.lifeValue);
        this.lifeOffsetValue.load(particleEmitter.lifeOffsetValue);
        this.xScaleValue.load(particleEmitter.xScaleValue);
        this.yScaleValue.load(particleEmitter.yScaleValue);
        this.rotationValue.load(particleEmitter.rotationValue);
        this.velocityValue.load(particleEmitter.velocityValue);
        this.angleValue.load(particleEmitter.angleValue);
        this.windValue.load(particleEmitter.windValue);
        this.gravityValue.load(particleEmitter.gravityValue);
        this.transparencyValue.load(particleEmitter.transparencyValue);
        this.tintValue.load(particleEmitter.tintValue);
        this.xOffsetValue.load(particleEmitter.xOffsetValue);
        this.yOffsetValue.load(particleEmitter.yOffsetValue);
        this.spawnWidthValue.load(particleEmitter.spawnWidthValue);
        this.spawnHeightValue.load(particleEmitter.spawnHeightValue);
        this.spawnShapeValue.load(particleEmitter.spawnShapeValue);
        this.attached = particleEmitter.attached;
        this.continuous = particleEmitter.continuous;
        this.aligned = particleEmitter.aligned;
        this.behind = particleEmitter.behind;
        this.additive = particleEmitter.additive;
        this.premultipliedAlpha = particleEmitter.premultipliedAlpha;
        this.cleansUpBlendFunction = particleEmitter.cleansUpBlendFunction;
        this.spriteMode = particleEmitter.spriteMode;
        setPosition(particleEmitter.getX(), particleEmitter.getY());
    }
}
