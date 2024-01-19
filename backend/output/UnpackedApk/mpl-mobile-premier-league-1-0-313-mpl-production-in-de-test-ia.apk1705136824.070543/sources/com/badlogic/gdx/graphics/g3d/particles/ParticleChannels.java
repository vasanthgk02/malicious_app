package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ChannelDescriptor;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.ChannelInitializer;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import java.util.Arrays;

public class ParticleChannels {
    public static final ChannelDescriptor Acceleration = new ChannelDescriptor(newGlobalId(), Float.TYPE, 3);
    public static final int AlphaOffset = 3;
    public static final ChannelDescriptor AngularVelocity2D = new ChannelDescriptor(newGlobalId(), Float.TYPE, 1);
    public static final ChannelDescriptor AngularVelocity3D = new ChannelDescriptor(newGlobalId(), Float.TYPE, 3);
    public static final int BlueOffset = 2;
    public static final ChannelDescriptor Color = new ChannelDescriptor(newGlobalId(), Float.TYPE, 4);
    public static final int CosineOffset = 0;
    public static final int CurrentLifeOffset = 0;
    public static final int GreenOffset = 1;
    public static final int HalfHeightOffset = 5;
    public static final int HalfWidthOffset = 4;
    public static final ChannelDescriptor Interpolation = new ChannelDescriptor(-1, Float.TYPE, 2);
    public static final ChannelDescriptor Interpolation4 = new ChannelDescriptor(-1, Float.TYPE, 4);
    public static final ChannelDescriptor Interpolation6 = new ChannelDescriptor(-1, Float.TYPE, 6);
    public static final int InterpolationDiffOffset = 1;
    public static final int InterpolationStartOffset = 0;
    public static final ChannelDescriptor Life = new ChannelDescriptor(newGlobalId(), Float.TYPE, 3);
    public static final int LifePercentOffset = 2;
    public static final ChannelDescriptor ModelInstance = new ChannelDescriptor(newGlobalId(), ModelInstance.class, 1);
    public static final ChannelDescriptor ParticleController = new ChannelDescriptor(newGlobalId(), ParticleController.class, 1);
    public static final ChannelDescriptor Position = new ChannelDescriptor(newGlobalId(), Float.TYPE, 3);
    public static final ChannelDescriptor PreviousPosition = new ChannelDescriptor(newGlobalId(), Float.TYPE, 3);
    public static final int RedOffset = 0;
    public static final ChannelDescriptor Rotation2D = new ChannelDescriptor(newGlobalId(), Float.TYPE, 2);
    public static final ChannelDescriptor Rotation3D = new ChannelDescriptor(newGlobalId(), Float.TYPE, 4);
    public static final ChannelDescriptor Scale = new ChannelDescriptor(newGlobalId(), Float.TYPE, 1);
    public static final int SineOffset = 1;
    public static final ChannelDescriptor TextureRegion = new ChannelDescriptor(newGlobalId(), Float.TYPE, 6);
    public static final int TotalLifeOffset = 1;
    public static final int U2Offset = 2;
    public static final int UOffset = 0;
    public static final int V2Offset = 3;
    public static final int VOffset = 1;
    public static final int VelocityPhiDiffOffset = 3;
    public static final int VelocityPhiStartOffset = 2;
    public static final int VelocityStrengthDiffOffset = 1;
    public static final int VelocityStrengthStartOffset = 0;
    public static final int VelocityThetaDiffOffset = 1;
    public static final int VelocityThetaStartOffset = 0;
    public static final int WOffset = 3;
    public static final int XOffset = 0;
    public static final int YOffset = 1;
    public static final int ZOffset = 2;
    public static int currentGlobalId;
    public int currentId;

    public static class ColorInitializer implements ChannelInitializer<FloatChannel> {
        public static ColorInitializer instance;

        public static ColorInitializer get() {
            if (instance == null) {
                instance = new ColorInitializer();
            }
            return instance;
        }

        public void init(FloatChannel floatChannel) {
            float[] fArr = floatChannel.data;
            Arrays.fill(fArr, 0, fArr.length, 1.0f);
        }
    }

    public static class Rotation2dInitializer implements ChannelInitializer<FloatChannel> {
        public static Rotation2dInitializer instance;

        public static Rotation2dInitializer get() {
            if (instance == null) {
                instance = new Rotation2dInitializer();
            }
            return instance;
        }

        public void init(FloatChannel floatChannel) {
            int length = floatChannel.data.length;
            int i = 0;
            while (i < length) {
                float[] fArr = floatChannel.data;
                fArr[i + 0] = 1.0f;
                fArr[i + 1] = 0.0f;
                i += floatChannel.strideSize;
            }
        }
    }

    public static class Rotation3dInitializer implements ChannelInitializer<FloatChannel> {
        public static Rotation3dInitializer instance;

        public static Rotation3dInitializer get() {
            if (instance == null) {
                instance = new Rotation3dInitializer();
            }
            return instance;
        }

        public void init(FloatChannel floatChannel) {
            int length = floatChannel.data.length;
            int i = 0;
            while (i < length) {
                float[] fArr = floatChannel.data;
                fArr[i + 2] = 0.0f;
                fArr[i + 1] = 0.0f;
                fArr[i + 0] = 0.0f;
                fArr[i + 3] = 1.0f;
                i += floatChannel.strideSize;
            }
        }
    }

    public static class ScaleInitializer implements ChannelInitializer<FloatChannel> {
        public static ScaleInitializer instance;

        public static ScaleInitializer get() {
            if (instance == null) {
                instance = new ScaleInitializer();
            }
            return instance;
        }

        public void init(FloatChannel floatChannel) {
            float[] fArr = floatChannel.data;
            Arrays.fill(fArr, 0, fArr.length, 1.0f);
        }
    }

    public static class TextureRegionInitializer implements ChannelInitializer<FloatChannel> {
        public static TextureRegionInitializer instance;

        public static TextureRegionInitializer get() {
            if (instance == null) {
                instance = new TextureRegionInitializer();
            }
            return instance;
        }

        public void init(FloatChannel floatChannel) {
            int length = floatChannel.data.length;
            int i = 0;
            while (i < length) {
                float[] fArr = floatChannel.data;
                fArr[i + 0] = 0.0f;
                fArr[i + 1] = 0.0f;
                fArr[i + 2] = 1.0f;
                fArr[i + 3] = 1.0f;
                fArr[i + 4] = 0.5f;
                fArr[i + 5] = 0.5f;
                i += floatChannel.strideSize;
            }
        }
    }

    public ParticleChannels() {
        resetIds();
    }

    public static int newGlobalId() {
        int i = currentGlobalId;
        currentGlobalId = i + 1;
        return i;
    }

    public int newId() {
        int i = this.currentId;
        this.currentId = i + 1;
        return i;
    }

    public void resetIds() {
        this.currentId = currentGlobalId;
    }
}
