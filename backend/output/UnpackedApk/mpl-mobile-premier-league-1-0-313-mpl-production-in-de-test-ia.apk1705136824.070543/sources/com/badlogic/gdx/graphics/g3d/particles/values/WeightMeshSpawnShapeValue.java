package com.badlogic.gdx.graphics.g3d.particles.values;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.particles.values.MeshSpawnShapeValue.Triangle;
import com.badlogic.gdx.math.CumulativeDistribution;
import com.badlogic.gdx.math.CumulativeDistribution.CumulativeValue;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public final class WeightMeshSpawnShapeValue extends MeshSpawnShapeValue {
    public CumulativeDistribution<Triangle> distribution = new CumulativeDistribution<>();

    public WeightMeshSpawnShapeValue(WeightMeshSpawnShapeValue weightMeshSpawnShapeValue) {
        super(weightMeshSpawnShapeValue);
        load(weightMeshSpawnShapeValue);
    }

    public void calculateWeights() {
        this.distribution.values.clear();
        VertexAttributes vertexAttributes = this.mesh.getVertexAttributes();
        int numIndices = this.mesh.getNumIndices();
        int numVertices = this.mesh.getNumVertices();
        short s = (short) (vertexAttributes.vertexSize / 4);
        short s2 = (short) (vertexAttributes.findByUsage(1).offset / 4);
        float[] fArr = new float[(numVertices * s)];
        this.mesh.getVertices(fArr);
        float f2 = 2.0f;
        if (numIndices > 0) {
            short[] sArr = new short[numIndices];
            this.mesh.getIndices(sArr);
            int i = 0;
            while (i < numIndices) {
                int i2 = (sArr[i] * s) + s2;
                int i3 = (sArr[i + 1] * s) + s2;
                int i4 = (sArr[i + 2] * s) + s2;
                float f3 = fArr[i2];
                float f4 = fArr[i2 + 1];
                float f5 = fArr[i2 + 2];
                float f6 = fArr[i3];
                float f7 = fArr[i3 + 1];
                float f8 = fArr[i3 + 2];
                float f9 = fArr[i4];
                float f10 = fArr[i4 + 1];
                float f11 = fArr[i4 + 2];
                float abs = Math.abs((((f4 - f7) * f9) + GeneratedOutlineSupport.outline3(f10, f4, f6, (f7 - f10) * f3)) / f2);
                CumulativeDistribution<Triangle> cumulativeDistribution = this.distribution;
                Triangle triangle = new Triangle(f3, f4, f5, f6, f7, f8, f9, f10, f11);
                cumulativeDistribution.values.add(new CumulativeValue(cumulativeDistribution, triangle, 0.0f, abs));
                i += 3;
                f2 = 2.0f;
            }
        } else {
            for (int i5 = 0; i5 < numVertices; i5 += s) {
                int i6 = i5 + s2;
                int i7 = i6 + s;
                int i8 = i7 + s;
                float f12 = fArr[i6];
                float f13 = fArr[i6 + 1];
                float f14 = fArr[i6 + 2];
                float f15 = fArr[i7];
                float f16 = fArr[i7 + 1];
                float f17 = fArr[i7 + 2];
                float f18 = fArr[i8];
                float f19 = fArr[i8 + 1];
                float f20 = fArr[i8 + 2];
                float abs2 = Math.abs((((f13 - f16) * f18) + GeneratedOutlineSupport.outline3(f19, f13, f15, (f16 - f19) * f12)) / 2.0f);
                CumulativeDistribution<Triangle> cumulativeDistribution2 = this.distribution;
                Triangle triangle2 = new Triangle(f12, f13, f14, f15, f16, f17, f18, f19, f20);
                cumulativeDistribution2.values.add(new CumulativeValue(cumulativeDistribution2, triangle2, 0.0f, abs2));
            }
        }
        CumulativeDistribution<Triangle> cumulativeDistribution3 = this.distribution;
        int i9 = 0;
        float f21 = 0.0f;
        while (true) {
            Array<CumulativeValue> array = cumulativeDistribution3.values;
            if (i9 >= array.size) {
                break;
            }
            f21 += ((CumulativeValue[]) array.items)[i9].interval;
            i9++;
        }
        float f22 = 0.0f;
        int i10 = 0;
        while (true) {
            Array<CumulativeValue> array2 = cumulativeDistribution3.values;
            if (i10 < array2.size) {
                CumulativeValue[] cumulativeValueArr = (CumulativeValue[]) array2.items;
                f22 += cumulativeValueArr[i10].interval / f21;
                cumulativeValueArr[i10].frequency = f22;
                i10++;
            } else {
                return;
            }
        }
    }

    public SpawnShapeValue copy() {
        return new WeightMeshSpawnShapeValue(this);
    }

    public void init() {
        calculateWeights();
    }

    public void spawnAux(Vector3 vector3, float f2) {
        CumulativeDistribution<Triangle> cumulativeDistribution = this.distribution;
        if (cumulativeDistribution != null) {
            float random = MathUtils.random();
            int i = cumulativeDistribution.values.size - 1;
            int i2 = 0;
            while (i2 <= i) {
                int i3 = ((i - i2) / 2) + i2;
                float f3 = ((CumulativeValue[]) cumulativeDistribution.values.items)[i3].frequency;
                if (random >= f3) {
                    if (random <= f3) {
                        break;
                    }
                    i2 = i3 + 1;
                } else {
                    i = i3 - 1;
                }
            }
            Triangle triangle = (Triangle) ((CumulativeValue[]) cumulativeDistribution.values.items)[i2].value;
            float random2 = MathUtils.random();
            float random3 = MathUtils.random();
            float f4 = triangle.x1;
            float outline3 = GeneratedOutlineSupport.outline3(triangle.x3, f4, random3, GeneratedOutlineSupport.outline3(triangle.x2, f4, random2, f4));
            float f5 = triangle.y1;
            float outline32 = GeneratedOutlineSupport.outline3(triangle.y3, f5, random3, GeneratedOutlineSupport.outline3(triangle.y2, f5, random2, f5));
            float f6 = triangle.z1;
            vector3.set(outline3, outline32, ((triangle.z3 - f6) * random3) + GeneratedOutlineSupport.outline3(triangle.z2, f6, random2, f6));
            return;
        }
        throw null;
    }

    public WeightMeshSpawnShapeValue() {
    }
}
