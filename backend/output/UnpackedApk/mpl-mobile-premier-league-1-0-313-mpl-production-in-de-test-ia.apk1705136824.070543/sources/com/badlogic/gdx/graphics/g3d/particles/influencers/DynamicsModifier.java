package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class DynamicsModifier extends Influencer {
    public static final Quaternion TMP_Q = new Quaternion();
    public static final Vector3 TMP_V1 = new Vector3();
    public static final Vector3 TMP_V2 = new Vector3();
    public static final Vector3 TMP_V3 = new Vector3();
    public boolean isGlobal = false;
    public FloatChannel lifeChannel;

    public static abstract class Angular extends Strength {
        public FloatChannel angularChannel;
        public ScaledNumericValue phiValue = new ScaledNumericValue();
        public ScaledNumericValue thetaValue = new ScaledNumericValue();

        public Angular() {
        }

        public void activateParticles(int i, int i2) {
            super.activateParticles(i, i2);
            int i3 = this.angularChannel.strideSize;
            int i4 = i * i3;
            int i5 = (i2 * i3) + i4;
            while (i4 < i5) {
                float newLowValue = this.thetaValue.newLowValue();
                float newHighValue = this.thetaValue.newHighValue();
                if (!this.thetaValue.isRelative()) {
                    newHighValue -= newLowValue;
                }
                float[] fArr = this.angularChannel.data;
                fArr[i4 + 0] = newLowValue;
                fArr[i4 + 1] = newHighValue;
                float newLowValue2 = this.phiValue.newLowValue();
                float newHighValue2 = this.phiValue.newHighValue();
                if (!this.phiValue.isRelative()) {
                    newHighValue2 -= newLowValue2;
                }
                FloatChannel floatChannel = this.angularChannel;
                float[] fArr2 = floatChannel.data;
                fArr2[i4 + 2] = newLowValue2;
                fArr2[i4 + 3] = newHighValue2;
                i4 += floatChannel.strideSize;
            }
        }

        public void allocateChannels() {
            super.allocateChannels();
            ParticleChannels.Interpolation4.id = this.controller.particleChannels.newId();
            this.angularChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Interpolation4);
        }

        public void read(Json json, JsonValue jsonValue) {
            Class cls = ScaledNumericValue.class;
            super.read(json, jsonValue);
            this.thetaValue = (ScaledNumericValue) json.readValue((String) "thetaValue", cls, jsonValue);
            this.phiValue = (ScaledNumericValue) json.readValue((String) "phiValue", cls, jsonValue);
        }

        public void write(Json json) {
            super.write(json);
            json.writeValue("thetaValue", this.thetaValue);
            json.writeValue("phiValue", this.phiValue);
        }

        public Angular(Angular angular) {
            super(angular);
            this.thetaValue.load(angular.thetaValue);
            this.phiValue.load(angular.phiValue);
        }
    }

    public static class BrownianAcceleration extends Strength {
        public FloatChannel accelerationChannel;

        public BrownianAcceleration() {
        }

        public void allocateChannels() {
            super.allocateChannels();
            this.accelerationChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Acceleration);
        }

        public void update() {
            int i = this.controller.particles.size;
            int i2 = 2;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                float[] fArr = this.strengthChannel.data;
                float f2 = fArr[i4 + 0];
                float outline5 = GeneratedOutlineSupport.outline5(this.strengthValue, this.lifeChannel.data[i2], fArr[i4 + 1], f2);
                Vector3 vector3 = DynamicsModifier.TMP_V3;
                vector3.set(MathUtils.random(-1.0f, 1.0f), MathUtils.random(-1.0f, 1.0f), MathUtils.random(-1.0f, 1.0f));
                vector3.nor().scl(outline5);
                FloatChannel floatChannel = this.accelerationChannel;
                float[] fArr2 = floatChannel.data;
                int i6 = i5 + 0;
                float f3 = fArr2[i6];
                Vector3 vector32 = DynamicsModifier.TMP_V3;
                fArr2[i6] = f3 + vector32.x;
                int i7 = i5 + 1;
                fArr2[i7] = fArr2[i7] + vector32.y;
                int i8 = i5 + 2;
                fArr2[i8] = fArr2[i8] + vector32.z;
                i3++;
                i4 += this.strengthChannel.strideSize;
                i5 += floatChannel.strideSize;
                i2 += this.lifeChannel.strideSize;
            }
        }

        public BrownianAcceleration(BrownianAcceleration brownianAcceleration) {
            super(brownianAcceleration);
        }

        public BrownianAcceleration copy() {
            return new BrownianAcceleration(this);
        }
    }

    public static class CentripetalAcceleration extends Strength {
        public FloatChannel accelerationChannel;
        public FloatChannel positionChannel;

        public CentripetalAcceleration() {
        }

        public void allocateChannels() {
            super.allocateChannels();
            this.accelerationChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Acceleration);
            this.positionChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Position);
        }

        public void update() {
            float f2;
            float f3;
            float f4 = 0.0f;
            if (!this.isGlobal) {
                float[] fArr = this.controller.transform.val;
                f4 = fArr[12];
                f2 = fArr[13];
                f3 = fArr[14];
            } else {
                f3 = 0.0f;
                f2 = 0.0f;
            }
            int i = this.controller.particles.size;
            int i2 = 2;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i3 < i) {
                float[] fArr2 = this.strengthChannel.data;
                float f5 = fArr2[i4 + 0];
                float outline5 = GeneratedOutlineSupport.outline5(this.strengthValue, this.lifeChannel.data[i2], fArr2[i4 + 1], f5);
                Vector3 vector3 = DynamicsModifier.TMP_V3;
                float[] fArr3 = this.positionChannel.data;
                vector3.set(fArr3[i5 + 0] - f4, fArr3[i5 + 1] - f2, fArr3[i5 + 2] - f3);
                vector3.nor().scl(outline5);
                FloatChannel floatChannel = this.accelerationChannel;
                float[] fArr4 = floatChannel.data;
                int i7 = i6 + 0;
                float f6 = fArr4[i7];
                Vector3 vector32 = DynamicsModifier.TMP_V3;
                fArr4[i7] = f6 + vector32.x;
                int i8 = i6 + 1;
                fArr4[i8] = fArr4[i8] + vector32.y;
                int i9 = i6 + 2;
                fArr4[i9] = fArr4[i9] + vector32.z;
                i3++;
                i5 += this.positionChannel.strideSize;
                i4 += this.strengthChannel.strideSize;
                i6 += floatChannel.strideSize;
                i2 += this.lifeChannel.strideSize;
            }
        }

        public CentripetalAcceleration(CentripetalAcceleration centripetalAcceleration) {
            super(centripetalAcceleration);
        }

        public CentripetalAcceleration copy() {
            return new CentripetalAcceleration(this);
        }
    }

    public static class FaceDirection extends DynamicsModifier {
        public FloatChannel accellerationChannel;
        public FloatChannel rotationChannel;

        public FaceDirection() {
        }

        public void allocateChannels() {
            this.rotationChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Rotation3D);
            this.accellerationChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Acceleration);
        }

        public ParticleControllerComponent copy() {
            return new FaceDirection(this);
        }

        public void update() {
            int i = 0;
            int i2 = (this.controller.particles.size * this.rotationChannel.strideSize) + 0;
            int i3 = 0;
            while (i < i2) {
                Vector3 vector3 = DynamicsModifier.TMP_V1;
                float[] fArr = this.accellerationChannel.data;
                vector3.set(fArr[i3 + 0], fArr[i3 + 1], fArr[i3 + 2]);
                Vector3 nor = vector3.nor();
                Vector3 vector32 = DynamicsModifier.TMP_V2;
                vector32.set(DynamicsModifier.TMP_V1);
                vector32.crs(Vector3.Y);
                Vector3 nor2 = vector32.nor();
                nor2.crs(DynamicsModifier.TMP_V1);
                Vector3 nor3 = nor2.nor();
                Vector3 vector33 = DynamicsModifier.TMP_V3;
                vector33.set(nor3);
                vector33.crs(nor);
                Vector3 nor4 = vector33.nor();
                DynamicsModifier.TMP_Q.setFromAxes(false, nor4.x, nor3.x, nor.x, nor4.y, nor3.y, nor.y, nor4.z, nor3.z, nor.z);
                FloatChannel floatChannel = this.rotationChannel;
                float[] fArr2 = floatChannel.data;
                Quaternion quaternion = DynamicsModifier.TMP_Q;
                fArr2[i + 0] = quaternion.x;
                fArr2[i + 1] = quaternion.y;
                fArr2[i + 2] = quaternion.z;
                fArr2[i + 3] = quaternion.w;
                i += floatChannel.strideSize;
                i3 += this.accellerationChannel.strideSize;
            }
        }

        public FaceDirection(FaceDirection faceDirection) {
            super(faceDirection);
        }
    }

    public static class PolarAcceleration extends Angular {
        public FloatChannel directionalVelocityChannel;

        public PolarAcceleration() {
        }

        public void allocateChannels() {
            super.allocateChannels();
            this.directionalVelocityChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Acceleration);
        }

        public void update() {
            int i = 0;
            int i2 = (this.controller.particles.size * this.directionalVelocityChannel.strideSize) + 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 2;
            while (i < i2) {
                float f2 = this.lifeChannel.data[i5];
                float[] fArr = this.strengthChannel.data;
                float f3 = fArr[i3 + 0];
                float outline5 = GeneratedOutlineSupport.outline5(this.strengthValue, f2, fArr[i3 + 1], f3);
                float[] fArr2 = this.angularChannel.data;
                float f4 = fArr2[i4 + 2];
                float outline52 = GeneratedOutlineSupport.outline5(this.phiValue, f2, fArr2[i4 + 3], f4);
                float[] fArr3 = this.angularChannel.data;
                float f5 = fArr3[i4 + 0];
                float outline53 = GeneratedOutlineSupport.outline5(this.thetaValue, f2, fArr3[i4 + 1], f5);
                float cosDeg = MathUtils.cosDeg(outline53);
                float sinDeg = MathUtils.sinDeg(outline53);
                float cosDeg2 = MathUtils.cosDeg(outline52);
                float sinDeg2 = MathUtils.sinDeg(outline52);
                Vector3 vector3 = DynamicsModifier.TMP_V3;
                vector3.set(cosDeg * sinDeg2, cosDeg2, sinDeg * sinDeg2);
                vector3.nor().scl(outline5);
                if (!this.isGlobal) {
                    this.controller.transform.getRotation(DynamicsModifier.TMP_Q, true);
                    Vector3 vector32 = DynamicsModifier.TMP_V3;
                    Quaternion quaternion = DynamicsModifier.TMP_Q;
                    if (vector32 != null) {
                        quaternion.transform(vector32);
                    } else {
                        throw null;
                    }
                }
                FloatChannel floatChannel = this.directionalVelocityChannel;
                float[] fArr4 = floatChannel.data;
                int i6 = i + 0;
                float f6 = fArr4[i6];
                Vector3 vector33 = DynamicsModifier.TMP_V3;
                fArr4[i6] = f6 + vector33.x;
                int i7 = i + 1;
                fArr4[i7] = fArr4[i7] + vector33.y;
                int i8 = i + 2;
                fArr4[i8] = fArr4[i8] + vector33.z;
                i3 += this.strengthChannel.strideSize;
                i += floatChannel.strideSize;
                i4 += this.angularChannel.strideSize;
                i5 += this.lifeChannel.strideSize;
            }
        }

        public PolarAcceleration(PolarAcceleration polarAcceleration) {
            super(polarAcceleration);
        }

        public PolarAcceleration copy() {
            return new PolarAcceleration(this);
        }
    }

    public static class Rotational2D extends Strength {
        public FloatChannel rotationalVelocity2dChannel;

        public Rotational2D() {
        }

        public void allocateChannels() {
            super.allocateChannels();
            this.rotationalVelocity2dChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.AngularVelocity2D);
        }

        public void update() {
            int i = 0;
            int i2 = (this.controller.particles.size * this.rotationalVelocity2dChannel.strideSize) + 0;
            int i3 = 0;
            int i4 = 2;
            while (i < i2) {
                float[] fArr = this.rotationalVelocity2dChannel.data;
                float f2 = fArr[i];
                float[] fArr2 = this.strengthChannel.data;
                fArr[i] = (this.strengthValue.getScale(this.lifeChannel.data[i4]) * fArr2[i3 + 1]) + fArr2[i3 + 0] + f2;
                i3 += this.strengthChannel.strideSize;
                i += this.rotationalVelocity2dChannel.strideSize;
                i4 += this.lifeChannel.strideSize;
            }
        }

        public Rotational2D(Rotational2D rotational2D) {
            super(rotational2D);
        }

        public Rotational2D copy() {
            return new Rotational2D(this);
        }
    }

    public static class Rotational3D extends Angular {
        public FloatChannel rotationChannel;
        public FloatChannel rotationalForceChannel;

        public Rotational3D() {
        }

        public void allocateChannels() {
            super.allocateChannels();
            this.rotationChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Rotation3D);
            this.rotationalForceChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.AngularVelocity3D);
        }

        public void update() {
            int i = this.controller.particles.size * this.rotationalForceChannel.strideSize;
            int i2 = 2;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                float f2 = this.lifeChannel.data[i2];
                float[] fArr = this.strengthChannel.data;
                float f3 = fArr[i4 + 0];
                float outline5 = GeneratedOutlineSupport.outline5(this.strengthValue, f2, fArr[i4 + 1], f3);
                float[] fArr2 = this.angularChannel.data;
                float f4 = fArr2[i5 + 2];
                float outline52 = GeneratedOutlineSupport.outline5(this.phiValue, f2, fArr2[i5 + 3], f4);
                float[] fArr3 = this.angularChannel.data;
                float f5 = fArr3[i5 + 0];
                float outline53 = GeneratedOutlineSupport.outline5(this.thetaValue, f2, fArr3[i5 + 1], f5);
                float cosDeg = MathUtils.cosDeg(outline53);
                float sinDeg = MathUtils.sinDeg(outline53);
                float cosDeg2 = MathUtils.cosDeg(outline52);
                float sinDeg2 = MathUtils.sinDeg(outline52);
                DynamicsModifier.TMP_V3.set(cosDeg * sinDeg2, cosDeg2, sinDeg * sinDeg2);
                DynamicsModifier.TMP_V3.scl(outline5 * 0.017453292f);
                FloatChannel floatChannel = this.rotationalForceChannel;
                float[] fArr4 = floatChannel.data;
                int i6 = i3 + 0;
                float f6 = fArr4[i6];
                Vector3 vector3 = DynamicsModifier.TMP_V3;
                fArr4[i6] = f6 + vector3.x;
                int i7 = i3 + 1;
                fArr4[i7] = fArr4[i7] + vector3.y;
                int i8 = i3 + 2;
                fArr4[i8] = fArr4[i8] + vector3.z;
                i4 += this.strengthChannel.strideSize;
                i3 += floatChannel.strideSize;
                i5 += this.angularChannel.strideSize;
                i2 += this.lifeChannel.strideSize;
            }
        }

        public Rotational3D(Rotational3D rotational3D) {
            super(rotational3D);
        }

        public Rotational3D copy() {
            return new Rotational3D(this);
        }
    }

    public static abstract class Strength extends DynamicsModifier {
        public FloatChannel strengthChannel;
        public ScaledNumericValue strengthValue;

        public Strength() {
            this.strengthValue = new ScaledNumericValue();
        }

        public void activateParticles(int i, int i2) {
            int i3 = this.strengthChannel.strideSize;
            int i4 = i * i3;
            int i5 = (i2 * i3) + i4;
            while (i4 < i5) {
                float newLowValue = this.strengthValue.newLowValue();
                float newHighValue = this.strengthValue.newHighValue();
                if (!this.strengthValue.isRelative()) {
                    newHighValue -= newLowValue;
                }
                FloatChannel floatChannel = this.strengthChannel;
                float[] fArr = floatChannel.data;
                fArr[i4 + 0] = newLowValue;
                fArr[i4 + 1] = newHighValue;
                i4 += floatChannel.strideSize;
            }
        }

        public void allocateChannels() {
            DynamicsModifier.super.allocateChannels();
            ParticleChannels.Interpolation.id = this.controller.particleChannels.newId();
            this.strengthChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Interpolation);
        }

        public void read(Json json, JsonValue jsonValue) {
            DynamicsModifier.super.read(json, jsonValue);
            this.strengthValue = (ScaledNumericValue) json.readValue((String) "strengthValue", ScaledNumericValue.class, jsonValue);
        }

        public void write(Json json) {
            DynamicsModifier.super.write(json);
            json.writeValue("strengthValue", this.strengthValue);
        }

        public Strength(Strength strength) {
            super(strength);
            ScaledNumericValue scaledNumericValue = new ScaledNumericValue();
            this.strengthValue = scaledNumericValue;
            scaledNumericValue.load(strength.strengthValue);
        }
    }

    public static class TangentialAcceleration extends Angular {
        public FloatChannel directionalVelocityChannel;
        public FloatChannel positionChannel;

        public TangentialAcceleration() {
        }

        public void allocateChannels() {
            super.allocateChannels();
            this.directionalVelocityChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Acceleration);
            this.positionChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Position);
        }

        public void update() {
            int i = 0;
            int i2 = (this.controller.particles.size * this.directionalVelocityChannel.strideSize) + 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 2;
            while (i < i2) {
                float f2 = this.lifeChannel.data[i6];
                float[] fArr = this.strengthChannel.data;
                float f3 = fArr[i3 + 0];
                float outline5 = GeneratedOutlineSupport.outline5(this.strengthValue, f2, fArr[i3 + 1], f3);
                float[] fArr2 = this.angularChannel.data;
                float f4 = fArr2[i4 + 2];
                float outline52 = GeneratedOutlineSupport.outline5(this.phiValue, f2, fArr2[i4 + 3], f4);
                float[] fArr3 = this.angularChannel.data;
                float f5 = fArr3[i4 + 0];
                float outline53 = GeneratedOutlineSupport.outline5(this.thetaValue, f2, fArr3[i4 + 1], f5);
                float cosDeg = MathUtils.cosDeg(outline53);
                float sinDeg = MathUtils.sinDeg(outline53);
                float cosDeg2 = MathUtils.cosDeg(outline52);
                float sinDeg2 = MathUtils.sinDeg(outline52);
                DynamicsModifier.TMP_V3.set(cosDeg * sinDeg2, cosDeg2, sinDeg * sinDeg2);
                Vector3 vector3 = DynamicsModifier.TMP_V1;
                float[] fArr4 = this.positionChannel.data;
                vector3.set(fArr4[i5 + 0], fArr4[i5 + 1], fArr4[i5 + 2]);
                if (!this.isGlobal) {
                    this.controller.transform.getTranslation(DynamicsModifier.TMP_V2);
                    DynamicsModifier.TMP_V1.sub(DynamicsModifier.TMP_V2);
                    this.controller.transform.getRotation(DynamicsModifier.TMP_Q, true);
                    Vector3 vector32 = DynamicsModifier.TMP_V3;
                    Quaternion quaternion = DynamicsModifier.TMP_Q;
                    if (vector32 != null) {
                        quaternion.transform(vector32);
                    } else {
                        throw null;
                    }
                }
                Vector3 vector33 = DynamicsModifier.TMP_V3;
                vector33.crs(DynamicsModifier.TMP_V1);
                vector33.nor().scl(outline5);
                FloatChannel floatChannel = this.directionalVelocityChannel;
                float[] fArr5 = floatChannel.data;
                int i7 = i + 0;
                float f6 = fArr5[i7];
                Vector3 vector34 = DynamicsModifier.TMP_V3;
                fArr5[i7] = f6 + vector34.x;
                int i8 = i + 1;
                fArr5[i8] = fArr5[i8] + vector34.y;
                int i9 = i + 2;
                fArr5[i9] = fArr5[i9] + vector34.z;
                i3 += this.strengthChannel.strideSize;
                i += floatChannel.strideSize;
                i4 += this.angularChannel.strideSize;
                i6 += this.lifeChannel.strideSize;
                i5 += this.positionChannel.strideSize;
            }
        }

        public TangentialAcceleration(TangentialAcceleration tangentialAcceleration) {
            super(tangentialAcceleration);
        }

        public TangentialAcceleration copy() {
            return new TangentialAcceleration(this);
        }
    }

    public DynamicsModifier() {
    }

    public void allocateChannels() {
        this.lifeChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Life);
    }

    public void read(Json json, JsonValue jsonValue) {
        super.read(json, jsonValue);
        this.isGlobal = ((Boolean) json.readValue((String) "isGlobal", Boolean.TYPE, jsonValue)).booleanValue();
    }

    public void write(Json json) {
        super.write(json);
        json.writeValue("isGlobal", Boolean.valueOf(this.isGlobal));
    }

    public DynamicsModifier(DynamicsModifier dynamicsModifier) {
        this.isGlobal = dynamicsModifier.isGlobal;
    }
}
