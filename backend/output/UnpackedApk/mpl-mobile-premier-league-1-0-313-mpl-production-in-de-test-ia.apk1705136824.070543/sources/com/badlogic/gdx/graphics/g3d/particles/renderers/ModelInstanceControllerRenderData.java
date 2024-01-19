package com.badlogic.gdx.graphics.g3d.particles.renderers;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ObjectChannel;

public class ModelInstanceControllerRenderData extends ParticleControllerRenderData {
    public FloatChannel colorChannel;
    public ObjectChannel<ModelInstance> modelInstanceChannel;
    public FloatChannel rotationChannel;
    public FloatChannel scaleChannel;
}
