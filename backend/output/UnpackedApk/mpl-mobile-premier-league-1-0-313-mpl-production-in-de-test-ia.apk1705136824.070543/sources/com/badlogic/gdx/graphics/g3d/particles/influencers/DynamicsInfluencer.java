package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import java.util.Arrays;

public class DynamicsInfluencer extends Influencer {
    public FloatChannel accellerationChannel;
    public FloatChannel angularVelocityChannel;
    public boolean has2dAngularVelocity;
    public boolean has3dAngularVelocity;
    public boolean hasAcceleration;
    public FloatChannel positionChannel;
    public FloatChannel previousPositionChannel;
    public FloatChannel rotationChannel;
    public Array<DynamicsModifier> velocities;

    public DynamicsInfluencer() {
        this.velocities = new Array<>(true, 3, DynamicsModifier.class);
    }

    public void activateParticles(int i, int i2) {
        if (this.hasAcceleration) {
            int i3 = this.positionChannel.strideSize;
            int i4 = i * i3;
            int i5 = (i3 * i2) + i4;
            while (i4 < i5) {
                float[] fArr = this.previousPositionChannel.data;
                int i6 = i4 + 0;
                FloatChannel floatChannel = this.positionChannel;
                float[] fArr2 = floatChannel.data;
                fArr[i6] = fArr2[i6];
                int i7 = i4 + 1;
                fArr[i7] = fArr2[i7];
                int i8 = i4 + 2;
                fArr[i8] = fArr2[i8];
                i4 += floatChannel.strideSize;
            }
        }
        if (this.has2dAngularVelocity) {
            int i9 = this.rotationChannel.strideSize;
            int i10 = i * i9;
            int i11 = (i9 * i2) + i10;
            while (i10 < i11) {
                FloatChannel floatChannel2 = this.rotationChannel;
                float[] fArr3 = floatChannel2.data;
                fArr3[i10 + 0] = 1.0f;
                fArr3[i10 + 1] = 0.0f;
                i10 += floatChannel2.strideSize;
            }
        } else if (this.has3dAngularVelocity) {
            int i12 = this.rotationChannel.strideSize;
            int i13 = i * i12;
            int i14 = (i12 * i2) + i13;
            while (i13 < i14) {
                FloatChannel floatChannel3 = this.rotationChannel;
                float[] fArr4 = floatChannel3.data;
                fArr4[i13 + 0] = 0.0f;
                fArr4[i13 + 1] = 0.0f;
                fArr4[i13 + 2] = 0.0f;
                fArr4[i13 + 3] = 1.0f;
                i13 += floatChannel3.strideSize;
            }
        }
        int i15 = 0;
        while (true) {
            Array<DynamicsModifier> array = this.velocities;
            if (i15 < array.size) {
                ((DynamicsModifier[]) array.items)[i15].activateParticles(i, i2);
                i15++;
            } else {
                return;
            }
        }
    }

    public void allocateChannels() {
        boolean z = false;
        int i = 0;
        while (true) {
            Array<DynamicsModifier> array = this.velocities;
            if (i >= array.size) {
                break;
            }
            ((DynamicsModifier[]) array.items)[i].allocateChannels();
            i++;
        }
        FloatChannel floatChannel = (FloatChannel) this.controller.particles.getChannel(ParticleChannels.Acceleration);
        this.accellerationChannel = floatChannel;
        boolean z2 = floatChannel != null;
        this.hasAcceleration = z2;
        if (z2) {
            this.positionChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Position);
            this.previousPositionChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.PreviousPosition);
        }
        FloatChannel floatChannel2 = (FloatChannel) this.controller.particles.getChannel(ParticleChannels.AngularVelocity2D);
        this.angularVelocityChannel = floatChannel2;
        boolean z3 = floatChannel2 != null;
        this.has2dAngularVelocity = z3;
        if (z3) {
            this.rotationChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Rotation2D);
            this.has3dAngularVelocity = false;
            return;
        }
        FloatChannel floatChannel3 = (FloatChannel) this.controller.particles.getChannel(ParticleChannels.AngularVelocity3D);
        this.angularVelocityChannel = floatChannel3;
        if (floatChannel3 != null) {
            z = true;
        }
        this.has3dAngularVelocity = z;
        if (z) {
            this.rotationChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Rotation3D);
        }
    }

    public void init() {
        int i = 0;
        while (true) {
            Array<DynamicsModifier> array = this.velocities;
            if (i < array.size) {
                ((DynamicsModifier[]) array.items)[i].init();
                i++;
            } else {
                return;
            }
        }
    }

    public void read(Json json, JsonValue jsonValue) {
        this.velocities.addAll((Array) json.readValue("velocities", Array.class, DynamicsModifier.class, jsonValue));
    }

    public void set(ParticleController particleController) {
        super.set(particleController);
        int i = 0;
        while (true) {
            Array<DynamicsModifier> array = this.velocities;
            if (i < array.size) {
                ((DynamicsModifier[]) array.items)[i].set(particleController);
                i++;
            } else {
                return;
            }
        }
    }

    public void update() {
        if (this.hasAcceleration) {
            FloatChannel floatChannel = this.accellerationChannel;
            Arrays.fill(floatChannel.data, 0, this.controller.particles.size * floatChannel.strideSize, 0.0f);
        }
        if (this.has2dAngularVelocity || this.has3dAngularVelocity) {
            FloatChannel floatChannel2 = this.angularVelocityChannel;
            Arrays.fill(floatChannel2.data, 0, this.controller.particles.size * floatChannel2.strideSize, 0.0f);
        }
        int i = 0;
        while (true) {
            Array<DynamicsModifier> array = this.velocities;
            if (i >= array.size) {
                break;
            }
            ((DynamicsModifier[]) array.items)[i].update();
            i++;
        }
        if (this.hasAcceleration) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                ParticleController particleController = this.controller;
                if (i2 >= particleController.particles.size) {
                    break;
                }
                FloatChannel floatChannel3 = this.positionChannel;
                float[] fArr = floatChannel3.data;
                int i4 = i3 + 0;
                float f2 = fArr[i4];
                int i5 = i3 + 1;
                float f3 = fArr[i5];
                int i6 = i3 + 2;
                float f4 = fArr[i6];
                float[] fArr2 = this.previousPositionChannel.data;
                float[] fArr3 = this.accellerationChannel.data;
                float f5 = fArr3[i4];
                float f6 = particleController.deltaTimeSqr;
                fArr[i4] = (f5 * f6) + ((f2 * 2.0f) - fArr2[i4]);
                fArr[i5] = (fArr3[i5] * f6) + ((f3 * 2.0f) - fArr2[i5]);
                fArr[i6] = (fArr3[i6] * f6) + ((2.0f * f4) - fArr2[i6]);
                fArr2[i4] = f2;
                fArr2[i5] = f3;
                fArr2[i6] = f4;
                i2++;
                i3 += floatChannel3.strideSize;
            }
        }
        if (this.has2dAngularVelocity) {
            int i7 = 0;
            int i8 = 0;
            while (true) {
                ParticleController particleController2 = this.controller;
                if (i7 < particleController2.particles.size) {
                    float f7 = this.angularVelocityChannel.data[i7] * particleController2.deltaTime;
                    if (f7 != 0.0f) {
                        float cosDeg = MathUtils.cosDeg(f7);
                        float sinDeg = MathUtils.sinDeg(f7);
                        float[] fArr4 = this.rotationChannel.data;
                        int i9 = i8 + 0;
                        float f8 = fArr4[i9];
                        int i10 = i8 + 1;
                        float f9 = fArr4[i10];
                        fArr4[i9] = (f8 * cosDeg) - (f9 * sinDeg);
                        fArr4[i10] = (f8 * sinDeg) + (f9 * cosDeg);
                    }
                    i7++;
                    i8 += this.rotationChannel.strideSize;
                } else {
                    return;
                }
            }
        } else if (this.has3dAngularVelocity) {
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i12 < this.controller.particles.size) {
                float[] fArr5 = this.angularVelocityChannel.data;
                float f10 = fArr5[i13 + 0];
                float f11 = fArr5[i13 + 1];
                float f12 = fArr5[i13 + 2];
                float[] fArr6 = this.rotationChannel.data;
                int i14 = i11 + 0;
                float f13 = fArr6[i14];
                int i15 = i11 + 1;
                float f14 = fArr6[i15];
                int i16 = i11 + 2;
                float f15 = fArr6[i16];
                int i17 = i11 + 3;
                float f16 = fArr6[i17];
                Quaternion quaternion = ParticleControllerComponent.TMP_Q;
                quaternion.set(f10, f11, f12, 0.0f);
                float f17 = quaternion.w;
                float f18 = quaternion.x;
                float f19 = quaternion.y;
                float f20 = quaternion.z;
                int i18 = i11;
                float f21 = ((f19 * f15) + ((f18 * f16) + (f17 * f13))) - (f20 * f14);
                int i19 = i12;
                float f22 = ((f20 * f13) + ((f19 * f16) + (f17 * f14))) - (f18 * f15);
                int i20 = i17;
                float f23 = ((f18 * f14) + ((f20 * f16) + (f17 * f15))) - (f19 * f13);
                float f24 = (((f17 * f16) - (f18 * f13)) - (f19 * f14)) - (f20 * f15);
                quaternion.x = f21;
                quaternion.y = f22;
                quaternion.z = f23;
                quaternion.w = f24;
                float f25 = this.controller.deltaTime * 0.5f;
                float f26 = f21 * f25;
                quaternion.x = f26;
                float f27 = f22 * f25;
                quaternion.y = f27;
                float f28 = f23 * f25;
                quaternion.z = f28;
                float f29 = f24 * f25;
                quaternion.w = f29;
                quaternion.x = f26 + f13;
                quaternion.y = f27 + f14;
                quaternion.z = f28 + f15;
                quaternion.w = f29 + f16;
                quaternion.nor();
                FloatChannel floatChannel4 = this.rotationChannel;
                float[] fArr7 = floatChannel4.data;
                Quaternion quaternion2 = ParticleControllerComponent.TMP_Q;
                fArr7[i14] = quaternion2.x;
                fArr7[i15] = quaternion2.y;
                fArr7[i16] = quaternion2.z;
                fArr7[i20] = quaternion2.w;
                i12 = i19 + 1;
                i11 = i18 + floatChannel4.strideSize;
                i13 += this.angularVelocityChannel.strideSize;
            }
        }
    }

    public void write(Json json) {
        json.writeValue("velocities", this.velocities, Array.class, DynamicsModifier.class);
    }

    public DynamicsInfluencer copy() {
        return new DynamicsInfluencer(this);
    }

    public DynamicsInfluencer(DynamicsModifier... dynamicsModifierArr) {
        this.velocities = new Array<>(true, dynamicsModifierArr.length, DynamicsModifier.class);
        for (DynamicsModifier copy : dynamicsModifierArr) {
            this.velocities.add((DynamicsModifier) copy.copy());
        }
    }

    public DynamicsInfluencer(DynamicsInfluencer dynamicsInfluencer) {
        this((DynamicsModifier[]) dynamicsInfluencer.velocities.toArray(DynamicsModifier.class));
    }
}
