package com.badlogic.gdx.graphics.g3d.model;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class MeshPart {
    public static final BoundingBox bounds = new BoundingBox();
    public final Vector3 center = new Vector3();
    public final Vector3 halfExtents = new Vector3();
    public String id;
    public Mesh mesh;
    public int offset;
    public int primitiveType;
    public float radius = -1.0f;
    public int size;

    public MeshPart() {
    }

    public boolean equals(MeshPart meshPart) {
        return meshPart == this || (meshPart != null && meshPart.mesh == this.mesh && meshPart.primitiveType == this.primitiveType && meshPart.offset == this.offset && meshPart.size == this.size);
    }

    public void render(ShaderProgram shaderProgram, boolean z) {
        this.mesh.render(shaderProgram, this.primitiveType, this.offset, this.size, z);
    }

    public MeshPart set(MeshPart meshPart) {
        this.id = meshPart.id;
        this.mesh = meshPart.mesh;
        this.offset = meshPart.offset;
        this.size = meshPart.size;
        this.primitiveType = meshPart.primitiveType;
        this.center.set(meshPart.center);
        this.halfExtents.set(meshPart.halfExtents);
        this.radius = meshPart.radius;
        return this;
    }

    public void update() {
        this.mesh.calculateBoundingBox(bounds, this.offset, this.size);
        this.center.set(bounds.cnt);
        BoundingBox boundingBox = bounds;
        Vector3 vector3 = this.halfExtents;
        vector3.set(boundingBox.dim);
        vector3.scl(0.5f);
        this.radius = this.halfExtents.len();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MeshPart)) {
            return false;
        }
        return equals((MeshPart) obj);
    }

    public void render(ShaderProgram shaderProgram) {
        this.mesh.render(shaderProgram, this.primitiveType, this.offset, this.size);
    }

    public MeshPart(String str, Mesh mesh2, int i, int i2, int i3) {
        set(str, mesh2, i, i2, i3);
    }

    public MeshPart set(String str, Mesh mesh2, int i, int i2, int i3) {
        this.id = str;
        this.mesh = mesh2;
        this.offset = i;
        this.size = i2;
        this.primitiveType = i3;
        this.center.set(0.0f, 0.0f, 0.0f);
        this.halfExtents.set(0.0f, 0.0f, 0.0f);
        this.radius = -1.0f;
        return this;
    }

    public MeshPart(MeshPart meshPart) {
        set(meshPart);
    }
}
