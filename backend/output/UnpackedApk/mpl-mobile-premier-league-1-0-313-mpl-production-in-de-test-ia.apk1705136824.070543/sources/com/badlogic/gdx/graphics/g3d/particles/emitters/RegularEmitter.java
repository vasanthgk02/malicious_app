package com.badlogic.gdx.graphics.g3d.particles.emitters;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.values.RangedNumericValue;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;

public class RegularEmitter extends Emitter implements Serializable {
    public boolean continuous;
    public float delay;
    public float delayTimer;
    public RangedNumericValue delayValue;
    public float duration;
    public float durationTimer;
    public RangedNumericValue durationValue;
    public int emission;
    public int emissionDelta;
    public int emissionDiff;
    public EmissionMode emissionMode;
    public ScaledNumericValue emissionValue;
    public int life;
    public FloatChannel lifeChannel;
    public int lifeDiff;
    public int lifeOffset;
    public int lifeOffsetDiff;
    public ScaledNumericValue lifeOffsetValue;
    public ScaledNumericValue lifeValue;

    public enum EmissionMode {
        Enabled,
        EnabledUntilCycleEnd,
        Disabled
    }

    public RegularEmitter() {
        this.delayValue = new RangedNumericValue();
        this.durationValue = new RangedNumericValue();
        this.lifeOffsetValue = new ScaledNumericValue();
        this.lifeValue = new ScaledNumericValue();
        this.emissionValue = new ScaledNumericValue();
        this.durationValue.setActive(true);
        this.emissionValue.setActive(true);
        this.lifeValue.setActive(true);
        this.continuous = true;
        this.emissionMode = EmissionMode.Enabled;
    }

    private void addParticles(int i) {
        int min = Math.min(i, this.maxParticleCount - this.controller.particles.size);
        if (min > 0) {
            ParticleController particleController = this.controller;
            particleController.activateParticles(particleController.particles.size, min);
            this.controller.particles.size += min;
        }
    }

    public void activateParticles(int i, int i2) {
        int i3;
        int scale = this.life + ((int) (this.lifeValue.getScale(this.percent) * ((float) this.lifeDiff)));
        int outline5 = (int) GeneratedOutlineSupport.outline5(this.lifeOffsetValue, this.percent, (float) this.lifeOffsetDiff, (float) this.lifeOffset);
        if (outline5 > 0) {
            if (outline5 >= scale) {
                outline5 = scale - 1;
            }
            i3 = scale - outline5;
        } else {
            i3 = scale;
        }
        float f2 = (float) i3;
        float f3 = (float) scale;
        float f4 = 1.0f - (f2 / f3);
        int i4 = this.lifeChannel.strideSize;
        int i5 = i * i4;
        int i6 = (i2 * i4) + i5;
        while (i5 < i6) {
            FloatChannel floatChannel = this.lifeChannel;
            float[] fArr = floatChannel.data;
            fArr[i5 + 0] = f2;
            fArr[i5 + 1] = f3;
            fArr[i5 + 2] = f4;
            i5 += floatChannel.strideSize;
        }
    }

    public void allocateChannels() {
        this.lifeChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Life);
    }

    public ParticleControllerComponent copy() {
        return new RegularEmitter(this);
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

    public EmissionMode getEmissionMode() {
        return this.emissionMode;
    }

    public ScaledNumericValue getLife() {
        return this.lifeValue;
    }

    public ScaledNumericValue getLifeOffset() {
        return this.lifeOffsetValue;
    }

    public float getPercentComplete() {
        if (this.delayTimer < this.delay) {
            return 0.0f;
        }
        return Math.min(1.0f, this.durationTimer / this.duration);
    }

    public void init() {
        super.init();
        this.emissionDelta = 0;
        this.durationTimer = this.duration;
    }

    public boolean isComplete() {
        boolean z = false;
        if (this.delayTimer < this.delay) {
            return false;
        }
        if (this.durationTimer >= this.duration && this.controller.particles.size == 0) {
            z = true;
        }
        return z;
    }

    public boolean isContinuous() {
        return this.continuous;
    }

    public void read(Json json, JsonValue jsonValue) {
        Class cls = RangedNumericValue.class;
        Class cls2 = ScaledNumericValue.class;
        super.read(json, jsonValue);
        this.continuous = ((Boolean) json.readValue((String) "continous", Boolean.TYPE, jsonValue)).booleanValue();
        this.emissionValue = (ScaledNumericValue) json.readValue((String) "emission", cls2, jsonValue);
        this.delayValue = (RangedNumericValue) json.readValue((String) InlineAnimation.DELAY, cls, jsonValue);
        this.durationValue = (RangedNumericValue) json.readValue((String) InlineAnimation.DURATION, cls, jsonValue);
        this.lifeValue = (ScaledNumericValue) json.readValue((String) "life", cls2, jsonValue);
        this.lifeOffsetValue = (ScaledNumericValue) json.readValue((String) "lifeOffset", cls2, jsonValue);
    }

    public void set(RegularEmitter regularEmitter) {
        super.set(regularEmitter);
        this.delayValue.load(regularEmitter.delayValue);
        this.durationValue.load(regularEmitter.durationValue);
        this.lifeOffsetValue.load(regularEmitter.lifeOffsetValue);
        this.lifeValue.load(regularEmitter.lifeValue);
        this.emissionValue.load(regularEmitter.emissionValue);
        this.emission = regularEmitter.emission;
        this.emissionDiff = regularEmitter.emissionDiff;
        this.emissionDelta = regularEmitter.emissionDelta;
        this.lifeOffset = regularEmitter.lifeOffset;
        this.lifeOffsetDiff = regularEmitter.lifeOffsetDiff;
        this.life = regularEmitter.life;
        this.lifeDiff = regularEmitter.lifeDiff;
        this.duration = regularEmitter.duration;
        this.delay = regularEmitter.delay;
        this.durationTimer = regularEmitter.durationTimer;
        this.delayTimer = regularEmitter.delayTimer;
        this.continuous = regularEmitter.continuous;
    }

    public void setContinuous(boolean z) {
        this.continuous = z;
    }

    public void setEmissionMode(EmissionMode emissionMode2) {
        this.emissionMode = emissionMode2;
    }

    public void start() {
        RangedNumericValue rangedNumericValue = this.delayValue;
        this.delay = rangedNumericValue.active ? rangedNumericValue.newLowValue() : 0.0f;
        this.delayTimer = 0.0f;
        this.durationTimer = 0.0f;
        float newLowValue = this.durationValue.newLowValue();
        this.duration = newLowValue;
        this.percent = this.durationTimer / newLowValue;
        this.emission = (int) this.emissionValue.newLowValue();
        this.emissionDiff = (int) this.emissionValue.newHighValue();
        if (!this.emissionValue.isRelative()) {
            this.emissionDiff -= this.emission;
        }
        this.life = (int) this.lifeValue.newLowValue();
        this.lifeDiff = (int) this.lifeValue.newHighValue();
        if (!this.lifeValue.isRelative()) {
            this.lifeDiff -= this.life;
        }
        ScaledNumericValue scaledNumericValue = this.lifeOffsetValue;
        this.lifeOffset = scaledNumericValue.active ? (int) scaledNumericValue.newLowValue() : 0;
        this.lifeOffsetDiff = (int) this.lifeOffsetValue.newHighValue();
        if (!this.lifeOffsetValue.isRelative()) {
            this.lifeOffsetDiff -= this.lifeOffset;
        }
    }

    public void update() {
        ParticleController particleController;
        int i;
        float f2 = this.controller.deltaTime * 1000.0f;
        float f3 = this.delayTimer;
        int i2 = 0;
        if (f3 < this.delay) {
            this.delayTimer = f3 + f2;
        } else {
            boolean z = this.emissionMode != EmissionMode.Disabled;
            float f4 = this.durationTimer;
            float f5 = this.duration;
            if (f4 < f5) {
                float f6 = f4 + f2;
                this.durationTimer = f6;
                this.percent = f6 / f5;
            } else if (!this.continuous || !z || this.emissionMode != EmissionMode.Enabled) {
                z = false;
            } else {
                this.controller.start();
            }
            if (z) {
                this.emissionDelta = (int) (((float) this.emissionDelta) + f2);
                float outline5 = GeneratedOutlineSupport.outline5(this.emissionValue, this.percent, (float) this.emissionDiff, (float) this.emission);
                if (outline5 > 0.0f) {
                    float f7 = 1000.0f / outline5;
                    int i3 = this.emissionDelta;
                    if (((float) i3) >= f7) {
                        int min = Math.min((int) (((float) i3) / f7), this.maxParticleCount - this.controller.particles.size);
                        int i4 = (int) (((float) this.emissionDelta) - (((float) min) * f7));
                        this.emissionDelta = i4;
                        this.emissionDelta = (int) (((float) i4) % f7);
                        addParticles(min);
                    }
                }
                int i5 = this.controller.particles.size;
                int i6 = this.minParticleCount;
                if (i5 < i6) {
                    addParticles(i6 - i5);
                }
            }
        }
        int i7 = this.controller.particles.size;
        int i8 = 0;
        while (true) {
            particleController = this.controller;
            ParallelArray parallelArray = particleController.particles;
            i = parallelArray.size;
            if (i2 >= i) {
                break;
            }
            FloatChannel floatChannel = this.lifeChannel;
            float[] fArr = floatChannel.data;
            int i9 = i8 + 0;
            float f8 = fArr[i9] - f2;
            fArr[i9] = f8;
            if (f8 <= 0.0f) {
                parallelArray.removeElement(i2);
            } else {
                fArr[i8 + 2] = 1.0f - (fArr[i9] / fArr[i8 + 1]);
                i2++;
                i8 += floatChannel.strideSize;
            }
        }
        if (i < i7) {
            particleController.killParticles(i, i7 - i);
        }
    }

    public void write(Json json) {
        super.write(json);
        json.writeValue("continous", Boolean.valueOf(this.continuous));
        json.writeValue("emission", this.emissionValue);
        json.writeValue(InlineAnimation.DELAY, this.delayValue);
        json.writeValue(InlineAnimation.DURATION, this.durationValue);
        json.writeValue("life", this.lifeValue);
        json.writeValue("lifeOffset", this.lifeOffsetValue);
    }

    public RegularEmitter(RegularEmitter regularEmitter) {
        this();
        set(regularEmitter);
    }
}
