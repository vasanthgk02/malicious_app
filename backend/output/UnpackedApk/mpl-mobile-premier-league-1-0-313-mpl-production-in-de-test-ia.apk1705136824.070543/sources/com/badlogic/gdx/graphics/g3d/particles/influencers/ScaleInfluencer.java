package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;

public class ScaleInfluencer extends SimpleInfluencer {
    public ScaleInfluencer() {
        this.valueChannelDescriptor = ParticleChannels.Scale;
    }

    public void activateParticles(int i, int i2) {
        if (this.value.isRelative()) {
            int i3 = this.valueChannel.strideSize;
            int i4 = i * i3;
            int i5 = i * this.interpolationChannel.strideSize;
            int i6 = (i2 * i3) + i4;
            while (i4 < i6) {
                float newLowValue = this.value.newLowValue() * this.controller.scale.x;
                float newHighValue = this.value.newHighValue() * this.controller.scale.x;
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
            float newLowValue2 = this.value.newLowValue() * this.controller.scale.x;
            float newHighValue2 = (this.value.newHighValue() * this.controller.scale.x) - newLowValue2;
            float[] fArr2 = this.interpolationChannel.data;
            fArr2[i9 + 0] = newLowValue2;
            fArr2[i9 + 1] = newHighValue2;
            this.valueChannel.data[i8] = GeneratedOutlineSupport.outline5(this.value, 0.0f, newHighValue2, newLowValue2);
            i8 += this.valueChannel.strideSize;
            i9 += this.interpolationChannel.strideSize;
        }
    }

    public ParticleControllerComponent copy() {
        return new ScaleInfluencer(this);
    }

    public ScaleInfluencer(ScaleInfluencer scaleInfluencer) {
        super(scaleInfluencer);
    }
}
