package com.badlogic.gdx.graphics.g3d.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodePart;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ModelBuilder {
    public Array<MeshBuilder> builders = new Array<>();
    public Model model;
    public Node node;
    public Matrix4 tmpTransform = new Matrix4();

    private void endnode() {
        if (this.node != null) {
            this.node = null;
        }
    }

    private MeshBuilder getBuilder(VertexAttributes vertexAttributes) {
        ArrayIterator it = this.builders.iterator();
        while (it.hasNext()) {
            MeshBuilder meshBuilder = (MeshBuilder) it.next();
            if (meshBuilder.getAttributes().equals(vertexAttributes) && meshBuilder.lastIndex() < 16383) {
                return meshBuilder;
            }
        }
        MeshBuilder meshBuilder2 = new MeshBuilder();
        meshBuilder2.begin(vertexAttributes);
        this.builders.add(meshBuilder2);
        return meshBuilder2;
    }

    public static void rebuildReferences(Model model2) {
        model2.materials.clear();
        model2.meshes.clear();
        model2.meshParts.clear();
        ArrayIterator it = model2.nodes.iterator();
        while (it.hasNext()) {
            rebuildReferences(model2, (Node) it.next());
        }
    }

    public void begin() {
        if (this.model == null) {
            this.node = null;
            this.model = new Model();
            this.builders.clear();
            return;
        }
        throw new GdxRuntimeException((String) "Call end() first");
    }

    public Model createArrow(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i, int i2, Material material, long j) {
        begin();
        part((String) "arrow", i2, j, material).arrow(f2, f3, f4, f5, f6, f7, f8, f9, i);
        return end();
    }

    public Model createBox(float f2, float f3, float f4, Material material, long j) {
        return createBox(f2, f3, f4, 4, material, j);
    }

    public Model createCapsule(float f2, float f3, int i, Material material, long j) {
        return createCapsule(f2, f3, i, 4, material, j);
    }

    public Model createCone(float f2, float f3, float f4, int i, Material material, long j) {
        return createCone(f2, f3, f4, i, 4, material, j);
    }

    public Model createCylinder(float f2, float f3, float f4, int i, Material material, long j) {
        return createCylinder(f2, f3, f4, i, 4, material, j);
    }

    public Model createLineGrid(int i, int i2, float f2, float f3, Material material, long j) {
        int i3 = i;
        int i4 = i2;
        begin();
        MeshPartBuilder part = part((String) "lines", 1, j, material);
        float f4 = (((float) i3) * f2) / 2.0f;
        float f5 = (((float) i4) * f3) / 2.0f;
        float f6 = -f4;
        float f7 = -f5;
        float f8 = f6;
        float f9 = f8;
        for (int i5 = 0; i5 <= i3; i5++) {
            part.line(f8, 0.0f, f5, f9, 0.0f, f7);
            f8 += f2;
            f9 += f2;
        }
        float f10 = f7;
        for (int i6 = 0; i6 <= i4; i6++) {
            part.line(f6, 0.0f, f7, f4, 0.0f, f10);
            f7 += f3;
            f10 += f3;
        }
        return end();
    }

    public Model createRect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, Material material, long j) {
        return createRect(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, 4, material, j);
    }

    public Model createSphere(float f2, float f3, float f4, int i, int i2, Material material, long j) {
        return createSphere(f2, f3, f4, i, i2, 4, material, j);
    }

    public Model createXYZCoordinates(float f2, float f3, float f4, int i, int i2, Material material, long j) {
        begin();
        node();
        MeshPartBuilder part = part((String) "xyz", i2, j, material);
        part.setColor(Color.RED);
        MeshPartBuilder meshPartBuilder = part;
        float f5 = f3;
        float f6 = f4;
        int i3 = i;
        meshPartBuilder.arrow(0.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, f5, f6, i3);
        part.setColor(Color.GREEN);
        meshPartBuilder.arrow(0.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, f5, f6, i3);
        part.setColor(Color.BLUE);
        meshPartBuilder.arrow(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f2, f5, f6, i3);
        return end();
    }

    public Model end() {
        Model model2 = this.model;
        if (model2 != null) {
            endnode();
            this.model = null;
            ArrayIterator it = this.builders.iterator();
            while (it.hasNext()) {
                ((MeshBuilder) it.next()).end();
            }
            this.builders.clear();
            rebuildReferences(model2);
            return model2;
        }
        throw new GdxRuntimeException((String) "Call begin() first");
    }

    public void manage(Disposable disposable) {
        Model model2 = this.model;
        if (model2 != null) {
            model2.manageDisposable(disposable);
            return;
        }
        throw new GdxRuntimeException((String) "Call begin() first");
    }

    public Node node(Node node2) {
        if (this.model != null) {
            endnode();
            this.model.nodes.add(node2);
            this.node = node2;
            return node2;
        }
        throw new GdxRuntimeException((String) "Call begin() first");
    }

    public void part(MeshPart meshPart, Material material) {
        if (this.node == null) {
            node();
        }
        this.node.parts.add(new NodePart(meshPart, material));
    }

    public Model createBox(float f2, float f3, float f4, int i, Material material, long j) {
        begin();
        part((String) "box", i, j, material).box(f2, f3, f4);
        return end();
    }

    public Model createCapsule(float f2, float f3, int i, int i2, Material material, long j) {
        begin();
        part((String) "capsule", i2, j, material).capsule(f2, f3, i);
        return end();
    }

    public Model createCone(float f2, float f3, float f4, int i, int i2, Material material, long j) {
        return createCone(f2, f3, f4, i, i2, material, j, 0.0f, 360.0f);
    }

    public Model createCylinder(float f2, float f3, float f4, int i, int i2, Material material, long j) {
        return createCylinder(f2, f3, f4, i, i2, material, j, 0.0f, 360.0f);
    }

    public Model createRect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, int i, Material material, long j) {
        begin();
        part((String) "rect", i, j, material).rect(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16);
        return end();
    }

    public Model createSphere(float f2, float f3, float f4, int i, int i2, int i3, Material material, long j) {
        return createSphere(f2, f3, f4, i, i2, i3, material, j, 0.0f, 360.0f, 0.0f, 180.0f);
    }

    public Model createCone(float f2, float f3, float f4, int i, Material material, long j, float f5, float f6) {
        return createCone(f2, f3, f4, i, 4, material, j, f5, f6);
    }

    public Model createCylinder(float f2, float f3, float f4, int i, Material material, long j, float f5, float f6) {
        return createCylinder(f2, f3, f4, i, 4, material, j, f5, f6);
    }

    public Model createSphere(float f2, float f3, float f4, int i, int i2, Material material, long j, float f5, float f6, float f7, float f8) {
        return createSphere(f2, f3, f4, i, i2, 4, material, j, f5, f6, f7, f8);
    }

    public MeshPart part(String str, Mesh mesh, int i, int i2, int i3, Material material) {
        MeshPart meshPart = new MeshPart();
        meshPart.id = str;
        meshPart.primitiveType = i;
        meshPart.mesh = mesh;
        meshPart.offset = i2;
        meshPart.size = i3;
        part(meshPart, material);
        return meshPart;
    }

    public Model createArrow(Vector3 vector3, Vector3 vector32, Material material, long j) {
        Vector3 vector33 = vector3;
        Vector3 vector34 = vector32;
        return createArrow(vector33.x, vector33.y, vector33.z, vector34.x, vector34.y, vector34.z, 0.1f, 0.1f, 5, 4, material, j);
    }

    public Model createCone(float f2, float f3, float f4, int i, int i2, Material material, long j, float f5, float f6) {
        begin();
        part((String) "cone", i2, j, material).cone(f2, f3, f4, i, f5, f6);
        return end();
    }

    public Model createCylinder(float f2, float f3, float f4, int i, int i2, Material material, long j, float f5, float f6) {
        begin();
        part((String) "cylinder", i2, j, material).cylinder(f2, f3, f4, i, f5, f6);
        return end();
    }

    public Model createSphere(float f2, float f3, float f4, int i, int i2, int i3, Material material, long j, float f5, float f6, float f7, float f8) {
        begin();
        part((String) "sphere", i3, j, material).sphere(f2, f3, f4, i, i2, f5, f6, f7, f8);
        return end();
    }

    public static void rebuildReferences(Model model2, Node node2) {
        ArrayIterator it = node2.parts.iterator();
        while (it.hasNext()) {
            NodePart nodePart = (NodePart) it.next();
            if (!model2.materials.contains(nodePart.material, true)) {
                model2.materials.add(nodePart.material);
            }
            if (!model2.meshParts.contains(nodePart.meshPart, true)) {
                model2.meshParts.add(nodePart.meshPart);
                if (!model2.meshes.contains(nodePart.meshPart.mesh, true)) {
                    model2.meshes.add(nodePart.meshPart.mesh);
                }
                model2.manageDisposable(nodePart.meshPart.mesh);
            }
        }
        for (Node rebuildReferences : node2.getChildren()) {
            rebuildReferences(model2, rebuildReferences);
        }
    }

    public Node node() {
        Node node2 = new Node();
        node(node2);
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("node");
        outline73.append(this.model.nodes.size);
        node2.id = outline73.toString();
        return node2;
    }

    public Node node(String str, Model model2) {
        Node node2 = new Node();
        node2.id = str;
        node2.addChildren(model2.nodes);
        node(node2);
        for (Disposable manage : model2.getManagedDisposables()) {
            manage(manage);
        }
        return node2;
    }

    public MeshPart part(String str, Mesh mesh, int i, Material material) {
        return part(str, mesh, i, 0, mesh.getNumIndices(), material);
    }

    public Model createXYZCoordinates(float f2, Material material, long j) {
        return createXYZCoordinates(f2, 0.1f, 0.1f, 5, 4, material, j);
    }

    public MeshPartBuilder part(String str, int i, VertexAttributes vertexAttributes, Material material) {
        MeshBuilder builder = getBuilder(vertexAttributes);
        part(builder.part(str, i), material);
        return builder;
    }

    public MeshPartBuilder part(String str, int i, long j, Material material) {
        return part(str, i, MeshBuilder.createAttributes(j), material);
    }
}
