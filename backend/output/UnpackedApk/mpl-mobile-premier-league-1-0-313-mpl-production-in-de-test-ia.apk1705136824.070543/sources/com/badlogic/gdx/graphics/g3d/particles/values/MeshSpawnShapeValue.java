package com.badlogic.gdx.graphics.g3d.particles.values;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;

public abstract class MeshSpawnShapeValue extends SpawnShapeValue {
    public Mesh mesh;
    public Model model;

    public static class Triangle {
        public float x1;
        public float x2;
        public float x3;
        public float y1;
        public float y2;
        public float y3;
        public float z1;
        public float z2;
        public float z3;

        public Triangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
            this.x1 = f2;
            this.y1 = f3;
            this.z1 = f4;
            this.x2 = f5;
            this.y2 = f6;
            this.z2 = f7;
            this.x3 = f8;
            this.y3 = f9;
            this.z3 = f10;
        }

        public static Vector3 pick(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Vector3 vector3) {
            float random = MathUtils.random();
            float random2 = MathUtils.random();
            vector3.set(GeneratedOutlineSupport.outline3(f8, f2, random2, GeneratedOutlineSupport.outline3(f5, f2, random, f2)), GeneratedOutlineSupport.outline3(f9, f3, random2, GeneratedOutlineSupport.outline3(f6, f3, random, f3)), ((f10 - f4) * random2) + GeneratedOutlineSupport.outline3(f7, f4, random, f4));
            return vector3;
        }

        public Vector3 pick(Vector3 vector3) {
            float random = MathUtils.random();
            float random2 = MathUtils.random();
            float f2 = this.x1;
            float outline3 = GeneratedOutlineSupport.outline3(this.x3, f2, random2, GeneratedOutlineSupport.outline3(this.x2, f2, random, f2));
            float f3 = this.y1;
            float outline32 = GeneratedOutlineSupport.outline3(this.y3, f3, random2, GeneratedOutlineSupport.outline3(this.y2, f3, random, f3));
            float f4 = this.z1;
            vector3.set(outline3, outline32, ((this.z3 - f4) * random2) + GeneratedOutlineSupport.outline3(this.z2, f4, random, f4));
            return vector3;
        }
    }

    public MeshSpawnShapeValue(MeshSpawnShapeValue meshSpawnShapeValue) {
        super(meshSpawnShapeValue);
    }

    public void load(ParticleValue particleValue) {
        super.load(particleValue);
        MeshSpawnShapeValue meshSpawnShapeValue = (MeshSpawnShapeValue) particleValue;
        setMesh(meshSpawnShapeValue.mesh, meshSpawnShapeValue.model);
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
        if (this.model != null) {
            resourceData.createSaveData();
            throw null;
        }
    }

    public void setMesh(Mesh mesh2, Model model2) {
        if (mesh2.getVertexAttribute(1) != null) {
            this.model = model2;
            this.mesh = mesh2;
            return;
        }
        throw new GdxRuntimeException((String) "Mesh vertices must have Usage.Position");
    }

    public MeshSpawnShapeValue() {
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
        if (resourceData.getSaveData().loadAsset() != null) {
            throw null;
        }
    }

    public void setMesh(Mesh mesh2) {
        setMesh(mesh2, null);
    }
}
