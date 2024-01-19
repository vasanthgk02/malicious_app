package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.values.GradientColorValue;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class ColorInfluencer extends Influencer {
    public FloatChannel colorChannel;

    public static class Random extends ColorInfluencer {
        public FloatChannel colorChannel;

        public void activateParticles(int i, int i2) {
            int i3 = this.colorChannel.strideSize;
            int i4 = i * i3;
            int i5 = (i2 * i3) + i4;
            while (i4 < i5) {
                this.colorChannel.data[i4 + 0] = MathUtils.random();
                this.colorChannel.data[i4 + 1] = MathUtils.random();
                this.colorChannel.data[i4 + 2] = MathUtils.random();
                this.colorChannel.data[i4 + 3] = MathUtils.random();
                i4 += this.colorChannel.strideSize;
            }
        }

        public void allocateChannels() {
            this.colorChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Color);
        }

        public Random copy() {
            return new Random();
        }
    }

    public static class Single extends ColorInfluencer {
        public FloatChannel alphaInterpolationChannel;
        public ScaledNumericValue alphaValue;
        public GradientColorValue colorValue;
        public FloatChannel lifeChannel;

        public Single() {
            this.colorValue = new GradientColorValue();
            ScaledNumericValue scaledNumericValue = new ScaledNumericValue();
            this.alphaValue = scaledNumericValue;
            scaledNumericValue.setHigh(1.0f);
        }

        public void activateParticles(int i, int i2) {
            int i3 = this.colorChannel.strideSize;
            int i4 = i * i3;
            int i5 = this.alphaInterpolationChannel.strideSize * i;
            int i6 = (i * this.lifeChannel.strideSize) + 2;
            int i7 = (i2 * i3) + i4;
            while (i4 < i7) {
                float newLowValue = this.alphaValue.newLowValue();
                float newHighValue = this.alphaValue.newHighValue() - newLowValue;
                this.colorValue.getColor(0.0f, this.colorChannel.data, i4);
                this.colorChannel.data[i4 + 3] = GeneratedOutlineSupport.outline5(this.alphaValue, this.lifeChannel.data[i6], newHighValue, newLowValue);
                FloatChannel floatChannel = this.alphaInterpolationChannel;
                float[] fArr = floatChannel.data;
                fArr[i5 + 0] = newLowValue;
                fArr[i5 + 1] = newHighValue;
                i4 += this.colorChannel.strideSize;
                i5 += floatChannel.strideSize;
                i6 += this.lifeChannel.strideSize;
            }
        }

        public void allocateChannels() {
            ColorInfluencer.super.allocateChannels();
            ParticleChannels.Interpolation.id = this.controller.particleChannels.newId();
            this.alphaInterpolationChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Interpolation);
            this.lifeChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Life);
        }

        public void read(Json json, JsonValue jsonValue) {
            this.alphaValue = (ScaledNumericValue) json.readValue((String) "alpha", ScaledNumericValue.class, jsonValue);
            this.colorValue = (GradientColorValue) json.readValue((String) "color", GradientColorValue.class, jsonValue);
        }

        public void set(Single single) {
            this.colorValue.load(single.colorValue);
            this.alphaValue.load(single.alphaValue);
        }

        public void update() {
            int i = 0;
            int i2 = (this.controller.particles.size * this.colorChannel.strideSize) + 0;
            int i3 = 0;
            int i4 = 2;
            while (i < i2) {
                float f2 = this.lifeChannel.data[i4];
                this.colorValue.getColor(f2, this.colorChannel.data, i);
                float[] fArr = this.alphaInterpolationChannel.data;
                float f3 = fArr[i3 + 0];
                this.colorChannel.data[i + 3] = GeneratedOutlineSupport.outline5(this.alphaValue, f2, fArr[i3 + 1], f3);
                i += this.colorChannel.strideSize;
                i3 += this.alphaInterpolationChannel.strideSize;
                i4 += this.lifeChannel.strideSize;
            }
        }

        public void write(Json json) {
            json.writeValue("alpha", this.alphaValue);
            json.writeValue("color", this.colorValue);
        }

        public Single copy() {
            return new Single(this);
        }

        public Single(Single single) {
            this();
            set(single);
        }
    }

    public void allocateChannels() {
        this.colorChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Color);
    }
}
