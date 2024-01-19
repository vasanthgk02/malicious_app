package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ChannelDescriptor;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import io.hansel.core.criteria.HSLCriteriaBuilder;

public abstract class SimpleInfluencer extends Influencer {
    public FloatChannel interpolationChannel;
    public FloatChannel lifeChannel;
    public ScaledNumericValue value;
    public FloatChannel valueChannel;
    public ChannelDescriptor valueChannelDescriptor;

    public SimpleInfluencer() {
        ScaledNumericValue scaledNumericValue = new ScaledNumericValue();
        this.value = scaledNumericValue;
        scaledNumericValue.setHigh(1.0f);
    }

    private void set(SimpleInfluencer simpleInfluencer) {
        this.value.load(simpleInfluencer.value);
        this.valueChannelDescriptor = simpleInfluencer.valueChannelDescriptor;
    }

    public void activateParticles(int i, int i2) {
        if (!this.value.isRelative()) {
            int i3 = this.valueChannel.strideSize;
            int i4 = i * i3;
            int i5 = i * this.interpolationChannel.strideSize;
            int i6 = (i2 * i3) + i4;
            while (i4 < i6) {
                float newLowValue = this.value.newLowValue();
                float newHighValue = this.value.newHighValue() - newLowValue;
                float[] fArr = this.interpolationChannel.data;
                fArr[i5 + 0] = newLowValue;
                fArr[i5 + 1] = newHighValue;
                this.valueChannel.data[i4] = GeneratedOutlineSupport.outline5(this.value, 0.0f, newHighValue, newLowValue);
                i4 += this.valueChannel.strideSize;
                i5 += this.interpolationChannel.strideSize;
            }
            return;
        }
        int i7 = this.valueChannel.strideSize;
        int i8 = i * i7;
        int i9 = i * this.interpolationChannel.strideSize;
        int i10 = (i2 * i7) + i8;
        while (i8 < i10) {
            float newLowValue2 = this.value.newLowValue();
            float newHighValue2 = this.value.newHighValue();
            float[] fArr2 = this.interpolationChannel.data;
            fArr2[i9 + 0] = newLowValue2;
            fArr2[i9 + 1] = newHighValue2;
            this.valueChannel.data[i8] = GeneratedOutlineSupport.outline5(this.value, 0.0f, newHighValue2, newLowValue2);
            i8 += this.valueChannel.strideSize;
            i9 += this.interpolationChannel.strideSize;
        }
    }

    public void allocateChannels() {
        this.valueChannel = (FloatChannel) this.controller.particles.addChannel(this.valueChannelDescriptor);
        ParticleChannels.Interpolation.id = this.controller.particleChannels.newId();
        this.interpolationChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Interpolation);
        this.lifeChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Life);
    }

    public void read(Json json, JsonValue jsonValue) {
        this.value = (ScaledNumericValue) json.readValue((String) HSLCriteriaBuilder.VALUE, ScaledNumericValue.class, jsonValue);
    }

    public void update() {
        int i = 0;
        int i2 = (this.controller.particles.size * this.valueChannel.strideSize) + 0;
        int i3 = 0;
        int i4 = 2;
        while (i < i2) {
            float[] fArr = this.valueChannel.data;
            float[] fArr2 = this.interpolationChannel.data;
            float f2 = fArr2[i3 + 0];
            fArr[i] = GeneratedOutlineSupport.outline5(this.value, this.lifeChannel.data[i4], fArr2[i3 + 1], f2);
            i += this.valueChannel.strideSize;
            i3 += this.interpolationChannel.strideSize;
            i4 += this.lifeChannel.strideSize;
        }
    }

    public void write(Json json) {
        json.writeValue(HSLCriteriaBuilder.VALUE, this.value);
    }

    public SimpleInfluencer(SimpleInfluencer simpleInfluencer) {
        this();
        set(simpleInfluencer);
    }
}
