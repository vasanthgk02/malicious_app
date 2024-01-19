package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderData;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;

public abstract class ParticleSorter {
    public static final Vector3 TMP_V1 = new Vector3();
    public Camera camera;

    public static class Distance extends ParticleSorter {
        public int currentSize = 0;
        public float[] distances;
        public int[] particleIndices;
        public int[] particleOffsets;

        public void ensureCapacity(int i) {
            if (this.currentSize < i) {
                this.distances = new float[i];
                this.particleIndices = new int[i];
                this.particleOffsets = new int[i];
                this.currentSize = i;
            }
        }

        public void qsort(int i, int i2) {
            if (i < i2) {
                if (i2 - i <= 8) {
                    for (int i3 = i; i3 <= i2; i3++) {
                        for (int i4 = i3; i4 > i; i4--) {
                            float[] fArr = this.distances;
                            int i5 = i4 - 1;
                            if (fArr[i5] <= fArr[i4]) {
                                break;
                            }
                            float f2 = fArr[i4];
                            fArr[i4] = fArr[i5];
                            fArr[i5] = f2;
                            int[] iArr = this.particleIndices;
                            int i6 = iArr[i4];
                            iArr[i4] = iArr[i5];
                            iArr[i5] = i6;
                        }
                    }
                    return;
                }
                float f3 = this.distances[i];
                int i7 = i + 1;
                int i8 = this.particleIndices[i];
                int i9 = i7;
                while (i7 <= i2) {
                    float[] fArr2 = this.distances;
                    if (f3 > fArr2[i7]) {
                        if (i7 > i9) {
                            float f4 = fArr2[i7];
                            fArr2[i7] = fArr2[i9];
                            fArr2[i9] = f4;
                            int[] iArr2 = this.particleIndices;
                            int i10 = iArr2[i7];
                            iArr2[i7] = iArr2[i9];
                            iArr2[i9] = i10;
                        }
                        i9++;
                    }
                    i7++;
                }
                float[] fArr3 = this.distances;
                int i11 = i9 - 1;
                fArr3[i] = fArr3[i11];
                fArr3[i11] = f3;
                int[] iArr3 = this.particleIndices;
                iArr3[i] = iArr3[i11];
                iArr3[i11] = i8;
                qsort(i, i9 - 2);
                qsort(i9, i2);
            }
        }

        public <T extends ParticleControllerRenderData> int[] sort(Array<T> array) {
            float[] fArr = this.camera.view.val;
            float f2 = fArr[2];
            float f3 = fArr[6];
            float f4 = fArr[10];
            ArrayIterator it = array.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                ParticleControllerRenderData particleControllerRenderData = (ParticleControllerRenderData) it.next();
                int i3 = particleControllerRenderData.controller.particles.size + i2;
                int i4 = 0;
                while (i2 < i3) {
                    float[] fArr2 = this.distances;
                    FloatChannel floatChannel = particleControllerRenderData.positionChannel;
                    float[] fArr3 = floatChannel.data;
                    fArr2[i2] = (fArr3[i4 + 2] * f4) + (fArr3[i4 + 1] * f3) + (fArr3[i4 + 0] * f2);
                    this.particleIndices[i2] = i2;
                    i2++;
                    i4 += floatChannel.strideSize;
                }
                i += particleControllerRenderData.controller.particles.size;
            }
            qsort(0, i - 1);
            for (int i5 = 0; i5 < i; i5++) {
                this.particleOffsets[this.particleIndices[i5]] = i5;
            }
            return this.particleOffsets;
        }
    }

    public static class None extends ParticleSorter {
        public int currentCapacity = 0;
        public int[] indices;

        public void ensureCapacity(int i) {
            if (this.currentCapacity < i) {
                this.indices = new int[i];
                for (int i2 = 0; i2 < i; i2++) {
                    this.indices[i2] = i2;
                }
                this.currentCapacity = i;
            }
        }

        public <T extends ParticleControllerRenderData> int[] sort(Array<T> array) {
            return this.indices;
        }
    }

    public void ensureCapacity(int i) {
    }

    public void setCamera(Camera camera2) {
        this.camera = camera2;
    }

    public abstract <T extends ParticleControllerRenderData> int[] sort(Array<T> array);
}
