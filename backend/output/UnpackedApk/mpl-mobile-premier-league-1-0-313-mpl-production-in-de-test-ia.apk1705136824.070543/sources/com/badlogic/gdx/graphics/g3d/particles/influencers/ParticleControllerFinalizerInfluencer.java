package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ObjectChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ParticleControllerFinalizerInfluencer extends Influencer {
    public ObjectChannel<ParticleController> controllerChannel;
    public boolean hasRotation;
    public boolean hasScale;
    public FloatChannel positionChannel;
    public FloatChannel rotationChannel;
    public FloatChannel scaleChannel;

    public void allocateChannels() {
        this.positionChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Position);
    }

    public void init() {
        ObjectChannel<ParticleController> objectChannel = (ObjectChannel) this.controller.particles.getChannel(ParticleChannels.ParticleController);
        this.controllerChannel = objectChannel;
        if (objectChannel != null) {
            this.scaleChannel = (FloatChannel) this.controller.particles.getChannel(ParticleChannels.Scale);
            this.rotationChannel = (FloatChannel) this.controller.particles.getChannel(ParticleChannels.Rotation3D);
            boolean z = true;
            this.hasScale = this.scaleChannel != null;
            if (this.rotationChannel == null) {
                z = false;
            }
            this.hasRotation = z;
            return;
        }
        throw new GdxRuntimeException((String) "ParticleController channel not found, specify an influencer which will allocate it please.");
    }

    public void update() {
        float f2;
        float f3;
        float f4;
        float f5;
        int i = this.controller.particles.size;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            ParticleController particleController = ((ParticleController[]) this.controllerChannel.data)[i2];
            float f6 = this.hasScale ? this.scaleChannel.data[i2] : 1.0f;
            if (this.hasRotation) {
                FloatChannel floatChannel = this.rotationChannel;
                int i4 = floatChannel.strideSize * i2;
                float[] fArr = floatChannel.data;
                float f7 = fArr[i4 + 0];
                float f8 = fArr[i4 + 1];
                float f9 = fArr[i4 + 2];
                f2 = fArr[i4 + 3];
                f4 = f8;
                f3 = f9;
                f5 = f7;
            } else {
                f5 = 0.0f;
                f4 = 0.0f;
                f3 = 0.0f;
                f2 = 1.0f;
            }
            float[] fArr2 = this.positionChannel.data;
            particleController.setTransform(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], f5, f4, f3, f2, f6);
            particleController.update();
            i2++;
            i3 += this.positionChannel.strideSize;
        }
    }

    public ParticleControllerFinalizerInfluencer copy() {
        return new ParticleControllerFinalizerInfluencer();
    }
}
