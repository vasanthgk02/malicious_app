package com.badlogic.gdx.graphics.g3d.particles.renderers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ObjectChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
import com.badlogic.gdx.graphics.g3d.particles.batches.ModelInstanceParticleBatch;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.math.Matrix4;

public class ModelInstanceRenderer extends ParticleControllerRenderer<ModelInstanceControllerRenderData, ModelInstanceParticleBatch> {
    public boolean hasColor;
    public boolean hasRotation;
    public boolean hasScale;

    public ModelInstanceRenderer() {
        super(new ModelInstanceControllerRenderData());
    }

    public void allocateChannels() {
        ((ModelInstanceControllerRenderData) this.renderData).positionChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Position);
    }

    public ParticleControllerComponent copy() {
        return new ModelInstanceRenderer((ModelInstanceParticleBatch) this.batch);
    }

    public void init() {
        ((ModelInstanceControllerRenderData) this.renderData).modelInstanceChannel = (ObjectChannel) this.controller.particles.getChannel(ParticleChannels.ModelInstance);
        ((ModelInstanceControllerRenderData) this.renderData).colorChannel = (FloatChannel) this.controller.particles.getChannel(ParticleChannels.Color);
        ((ModelInstanceControllerRenderData) this.renderData).scaleChannel = (FloatChannel) this.controller.particles.getChannel(ParticleChannels.Scale);
        ((ModelInstanceControllerRenderData) this.renderData).rotationChannel = (FloatChannel) this.controller.particles.getChannel(ParticleChannels.Rotation3D);
        boolean z = true;
        this.hasColor = ((ModelInstanceControllerRenderData) this.renderData).colorChannel != null;
        this.hasScale = ((ModelInstanceControllerRenderData) this.renderData).scaleChannel != null;
        if (((ModelInstanceControllerRenderData) this.renderData).rotationChannel == null) {
            z = false;
        }
        this.hasRotation = z;
    }

    public boolean isCompatible(ParticleBatch<?> particleBatch) {
        return particleBatch instanceof ModelInstanceParticleBatch;
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
            D d2 = this.renderData;
            ModelInstance modelInstance = ((ModelInstance[]) ((ModelInstanceControllerRenderData) d2).modelInstanceChannel.data)[i2];
            float f6 = this.hasScale ? ((ModelInstanceControllerRenderData) d2).scaleChannel.data[i2] : 1.0f;
            if (this.hasRotation) {
                D d3 = this.renderData;
                int i4 = ((ModelInstanceControllerRenderData) d3).rotationChannel.strideSize * i2;
                float f7 = ((ModelInstanceControllerRenderData) d3).rotationChannel.data[i4 + 0];
                float f8 = ((ModelInstanceControllerRenderData) d3).rotationChannel.data[i4 + 1];
                float f9 = ((ModelInstanceControllerRenderData) d3).rotationChannel.data[i4 + 2];
                f2 = ((ModelInstanceControllerRenderData) d3).rotationChannel.data[i4 + 3];
                f5 = f7;
                f4 = f8;
                f3 = f9;
            } else {
                f5 = 0.0f;
                f4 = 0.0f;
                f3 = 0.0f;
                f2 = 1.0f;
            }
            Matrix4 matrix4 = modelInstance.transform;
            D d4 = this.renderData;
            matrix4.set(((ModelInstanceControllerRenderData) d4).positionChannel.data[i3 + 0], ((ModelInstanceControllerRenderData) d4).positionChannel.data[i3 + 1], ((ModelInstanceControllerRenderData) d4).positionChannel.data[i3 + 2], f5, f4, f3, f2, f6, f6, f6);
            if (this.hasColor) {
                int i5 = ((ModelInstanceControllerRenderData) this.renderData).colorChannel.strideSize * i2;
                BlendingAttribute blendingAttribute = (BlendingAttribute) ((Material) modelInstance.materials.get(0)).get(BlendingAttribute.Type);
                Color color = ((ColorAttribute) ((Material) modelInstance.materials.get(0)).get(ColorAttribute.Diffuse)).color;
                D d5 = this.renderData;
                color.r = ((ModelInstanceControllerRenderData) d5).colorChannel.data[i5 + 0];
                color.g = ((ModelInstanceControllerRenderData) d5).colorChannel.data[i5 + 1];
                color.f3307b = ((ModelInstanceControllerRenderData) d5).colorChannel.data[i5 + 2];
                if (blendingAttribute != null) {
                    blendingAttribute.opacity = ((ModelInstanceControllerRenderData) d5).colorChannel.data[i5 + 3];
                }
            }
            i2++;
            i3 += ((ModelInstanceControllerRenderData) this.renderData).positionChannel.strideSize;
        }
        super.update();
    }

    public ModelInstanceRenderer(ModelInstanceParticleBatch modelInstanceParticleBatch) {
        this();
        setBatch(modelInstanceParticleBatch);
    }
}
