package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.utils.MeshBuilder;
import com.badlogic.gdx.graphics.g3d.utils.RenderableSorter;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.FlushablePool;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Pool;
import java.util.Comparator;

public class ModelCache implements Disposable, RenderableProvider {
    public boolean building;
    public Camera camera;
    public Array<Renderable> items;
    public MeshBuilder meshBuilder;
    public FlushablePool<MeshPart> meshPartPool;
    public MeshPool meshPool;
    public Array<Renderable> renderables;
    public FlushablePool<Renderable> renderablesPool;
    public RenderableSorter sorter;
    public Array<Renderable> tmp;

    public interface MeshPool extends Disposable {
        /* synthetic */ void dispose();

        void flush();

        Mesh obtain(VertexAttributes vertexAttributes, int i, int i2);
    }

    public static class SimpleMeshPool implements MeshPool {
        public Array<Mesh> freeMeshes = new Array<>();
        public Array<Mesh> usedMeshes = new Array<>();

        public void dispose() {
            ArrayIterator it = this.usedMeshes.iterator();
            while (it.hasNext()) {
                ((Mesh) it.next()).dispose();
            }
            this.usedMeshes.clear();
            ArrayIterator it2 = this.freeMeshes.iterator();
            while (it2.hasNext()) {
                ((Mesh) it2.next()).dispose();
            }
            this.freeMeshes.clear();
        }

        public void flush() {
            this.freeMeshes.addAll(this.usedMeshes);
            this.usedMeshes.clear();
        }

        public Mesh obtain(VertexAttributes vertexAttributes, int i, int i2) {
            int i3 = this.freeMeshes.size;
            int i4 = 0;
            while (i4 < i3) {
                Mesh mesh = (Mesh) this.freeMeshes.get(i4);
                if (!mesh.getVertexAttributes().equals(vertexAttributes) || mesh.getMaxVertices() < i || mesh.getMaxIndices() < i2) {
                    i4++;
                } else {
                    this.freeMeshes.removeIndex(i4);
                    this.usedMeshes.add(mesh);
                    return mesh;
                }
            }
            Mesh mesh2 = new Mesh(false, 65536, Math.max(65536, 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1))), vertexAttributes);
            this.usedMeshes.add(mesh2);
            return mesh2;
        }
    }

    public static class Sorter implements RenderableSorter, Comparator<Renderable> {
        public void sort(Camera camera, Array<Renderable> array) {
            array.sort(this);
        }

        public int compare(Renderable renderable, Renderable renderable2) {
            int compareTo = renderable.meshPart.mesh.getVertexAttributes().compareTo(renderable2.meshPart.mesh.getVertexAttributes());
            if (compareTo == 0) {
                compareTo = renderable.material.compareTo((Attributes) renderable2.material);
                if (compareTo == 0) {
                    return renderable.meshPart.primitiveType - renderable2.meshPart.primitiveType;
                }
            }
            return compareTo;
        }
    }

    public static class TightMeshPool implements MeshPool {
        public Array<Mesh> freeMeshes = new Array<>();
        public Array<Mesh> usedMeshes = new Array<>();

        public void dispose() {
            ArrayIterator it = this.usedMeshes.iterator();
            while (it.hasNext()) {
                ((Mesh) it.next()).dispose();
            }
            this.usedMeshes.clear();
            ArrayIterator it2 = this.freeMeshes.iterator();
            while (it2.hasNext()) {
                ((Mesh) it2.next()).dispose();
            }
            this.freeMeshes.clear();
        }

        public void flush() {
            this.freeMeshes.addAll(this.usedMeshes);
            this.usedMeshes.clear();
        }

        public Mesh obtain(VertexAttributes vertexAttributes, int i, int i2) {
            int i3 = this.freeMeshes.size;
            for (int i4 = 0; i4 < i3; i4++) {
                Mesh mesh = (Mesh) this.freeMeshes.get(i4);
                if (mesh.getVertexAttributes().equals(vertexAttributes) && mesh.getMaxVertices() == i && mesh.getMaxIndices() == i2) {
                    this.freeMeshes.removeIndex(i4);
                    this.usedMeshes.add(mesh);
                    return mesh;
                }
            }
            Mesh mesh2 = new Mesh(true, i, i2, vertexAttributes);
            this.usedMeshes.add(mesh2);
            return mesh2;
        }
    }

    public ModelCache() {
        this(new Sorter(), new SimpleMeshPool());
    }

    private Renderable obtainRenderable(Material material, int i) {
        Renderable renderable = (Renderable) this.renderablesPool.obtain();
        renderable.bones = null;
        renderable.environment = null;
        renderable.material = material;
        MeshPart meshPart = renderable.meshPart;
        meshPart.mesh = null;
        meshPart.offset = 0;
        meshPart.size = 0;
        meshPart.primitiveType = i;
        meshPart.center.set(0.0f, 0.0f, 0.0f);
        renderable.meshPart.halfExtents.set(0.0f, 0.0f, 0.0f);
        renderable.meshPart.radius = -1.0f;
        renderable.shader = null;
        renderable.userData = null;
        renderable.worldTransform.idt();
        return renderable;
    }

    public void add(Renderable renderable) {
        if (!this.building) {
            throw new GdxRuntimeException((String) "Can only add items to the ModelCache in between .begin() and .end()");
        } else if (renderable.bones == null) {
            this.items.add(renderable);
        } else {
            this.renderables.add(renderable);
        }
    }

    public void begin() {
        begin(null);
    }

    public void dispose() {
        if (!this.building) {
            this.meshPool.dispose();
            return;
        }
        throw new GdxRuntimeException((String) "Cannot dispose a ModelCache in between .begin() and .end()");
    }

    public void end() {
        if (this.building) {
            this.building = false;
            Array<Renderable> array = this.items;
            if (array.size != 0) {
                this.sorter.sort(this.camera, array);
                Array<Renderable> array2 = this.items;
                int i = array2.size;
                int i2 = this.renderables.size;
                Renderable renderable = (Renderable) array2.get(0);
                VertexAttributes vertexAttributes = renderable.meshPart.mesh.getVertexAttributes();
                Material material = renderable.material;
                int i3 = renderable.meshPart.primitiveType;
                int i4 = this.renderables.size;
                this.meshBuilder.begin(vertexAttributes);
                MeshPart part = this.meshBuilder.part("", i3, (MeshPart) this.meshPartPool.obtain());
                this.renderables.add(obtainRenderable(material, i3));
                int i5 = this.items.size;
                for (int i6 = 0; i6 < i5; i6++) {
                    Renderable renderable2 = (Renderable) this.items.get(i6);
                    VertexAttributes vertexAttributes2 = renderable2.meshPart.mesh.getVertexAttributes();
                    Material material2 = renderable2.material;
                    int i7 = renderable2.meshPart.primitiveType;
                    boolean z = vertexAttributes2.equals(vertexAttributes) && (this.meshBuilder.getNumVertices() + (renderable2.meshPart.mesh.getNumIndices() > 0 ? renderable2.meshPart.mesh.getNumVertices() : renderable2.meshPart.size) <= 65536);
                    if (!(z && i7 == i3 && material2.same(material, true))) {
                        if (!z) {
                            MeshBuilder meshBuilder2 = this.meshBuilder;
                            Mesh end = meshBuilder2.end(this.meshPool.obtain(vertexAttributes, meshBuilder2.getNumVertices(), this.meshBuilder.getNumIndices()));
                            while (true) {
                                Array<Renderable> array3 = this.renderables;
                                if (i4 >= array3.size) {
                                    break;
                                }
                                ((Renderable) array3.get(i4)).meshPart.mesh = end;
                                i4++;
                            }
                            this.meshBuilder.begin(vertexAttributes2);
                            vertexAttributes = vertexAttributes2;
                        }
                        MeshPart part2 = this.meshBuilder.part("", i7, (MeshPart) this.meshPartPool.obtain());
                        Array<Renderable> array4 = this.renderables;
                        MeshPart meshPart = ((Renderable) array4.get(array4.size - 1)).meshPart;
                        meshPart.offset = part.offset;
                        meshPart.size = part.size;
                        this.renderables.add(obtainRenderable(material2, i7));
                        part = part2;
                        material = material2;
                        i3 = i7;
                    }
                    this.meshBuilder.setVertexTransform(renderable2.worldTransform);
                    MeshBuilder meshBuilder3 = this.meshBuilder;
                    MeshPart meshPart2 = renderable2.meshPart;
                    meshBuilder3.addMesh(meshPart2.mesh, meshPart2.offset, meshPart2.size);
                }
                MeshBuilder meshBuilder4 = this.meshBuilder;
                Mesh end2 = meshBuilder4.end(this.meshPool.obtain(vertexAttributes, meshBuilder4.getNumVertices(), this.meshBuilder.getNumIndices()));
                while (true) {
                    Array<Renderable> array5 = this.renderables;
                    int i8 = array5.size;
                    if (i4 < i8) {
                        ((Renderable) array5.get(i4)).meshPart.mesh = end2;
                        i4++;
                    } else {
                        MeshPart meshPart3 = ((Renderable) array5.get(i8 - 1)).meshPart;
                        meshPart3.offset = part.offset;
                        meshPart3.size = part.size;
                        return;
                    }
                }
            }
        } else {
            throw new GdxRuntimeException((String) "Call begin() prior to calling end()");
        }
    }

    public void getRenderables(Array<Renderable> array, Pool<Renderable> pool) {
        if (!this.building) {
            ArrayIterator it = this.renderables.iterator();
            while (it.hasNext()) {
                Renderable renderable = (Renderable) it.next();
                renderable.shader = null;
                renderable.environment = null;
            }
            array.addAll(this.renderables);
            return;
        }
        throw new GdxRuntimeException((String) "Cannot render a ModelCache in between .begin() and .end()");
    }

    public ModelCache(RenderableSorter renderableSorter, MeshPool meshPool2) {
        this.renderables = new Array<>();
        this.renderablesPool = new FlushablePool<Renderable>() {
            public Renderable newObject() {
                return new Renderable();
            }
        };
        this.meshPartPool = new FlushablePool<MeshPart>() {
            public MeshPart newObject() {
                return new MeshPart();
            }
        };
        this.items = new Array<>();
        this.tmp = new Array<>();
        this.sorter = renderableSorter;
        this.meshPool = meshPool2;
        this.meshBuilder = new MeshBuilder();
    }

    public void begin(Camera camera2) {
        if (!this.building) {
            this.building = true;
            this.camera = camera2;
            this.renderablesPool.flush();
            this.renderables.clear();
            this.items.clear();
            this.meshPartPool.flush();
            this.meshPool.flush();
            return;
        }
        throw new GdxRuntimeException((String) "Call end() after calling begin()");
    }

    public void add(RenderableProvider renderableProvider) {
        renderableProvider.getRenderables(this.tmp, this.renderablesPool);
        int i = this.tmp.size;
        for (int i2 = 0; i2 < i; i2++) {
            add((Renderable) this.tmp.get(i2));
        }
        this.tmp.clear();
    }

    public <T extends RenderableProvider> void add(Iterable<T> iterable) {
        for (T add : iterable) {
            add((RenderableProvider) add);
        }
    }
}
