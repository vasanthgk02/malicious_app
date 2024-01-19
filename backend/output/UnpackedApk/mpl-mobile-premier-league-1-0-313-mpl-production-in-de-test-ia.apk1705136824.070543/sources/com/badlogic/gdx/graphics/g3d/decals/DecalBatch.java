package com.badlogic.gdx.graphics.g3d.decals;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Mesh.VertexDataType;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.SortedIntList;
import com.badlogic.gdx.utils.SortedIntList.Node;
import java.util.Iterator;

public class DecalBatch implements Disposable {
    public static final int DEFAULT_SIZE = 1000;
    public final SortedIntList<Array<Decal>> groupList;
    public final Pool<Array<Decal>> groupPool;
    public GroupStrategy groupStrategy;
    public Mesh mesh;
    public final Array<Array<Decal>> usedGroups;
    public float[] vertices;

    public DecalBatch(GroupStrategy groupStrategy2) {
        this(1000, groupStrategy2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void add(com.badlogic.gdx.graphics.g3d.decals.Decal r8) {
        /*
            r7 = this;
            com.badlogic.gdx.graphics.g3d.decals.GroupStrategy r0 = r7.groupStrategy
            int r0 = r0.decideGroup(r8)
            com.badlogic.gdx.utils.SortedIntList<com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g3d.decals.Decal>> r1 = r7.groupList
            com.badlogic.gdx.utils.SortedIntList$Node<E> r1 = r1.first
            r2 = 0
            if (r1 == 0) goto L_0x001e
        L_0x000d:
            com.badlogic.gdx.utils.SortedIntList$Node<E> r3 = r1.n
            if (r3 == 0) goto L_0x0017
            int r4 = r1.index
            if (r4 >= r0) goto L_0x0017
            r1 = r3
            goto L_0x000d
        L_0x0017:
            int r3 = r1.index
            if (r3 != r0) goto L_0x001e
            E r1 = r1.value
            goto L_0x001f
        L_0x001e:
            r1 = r2
        L_0x001f:
            com.badlogic.gdx.utils.Array r1 = (com.badlogic.gdx.utils.Array) r1
            if (r1 != 0) goto L_0x0086
            com.badlogic.gdx.utils.Pool<com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g3d.decals.Decal>> r1 = r7.groupPool
            java.lang.Object r1 = r1.obtain()
            com.badlogic.gdx.utils.Array r1 = (com.badlogic.gdx.utils.Array) r1
            r1.clear()
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g3d.decals.Decal>> r3 = r7.usedGroups
            r3.add(r1)
            com.badlogic.gdx.utils.SortedIntList<com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g3d.decals.Decal>> r3 = r7.groupList
            com.badlogic.gdx.utils.SortedIntList$Node<E> r4 = r3.first
            if (r4 == 0) goto L_0x0078
        L_0x0039:
            com.badlogic.gdx.utils.SortedIntList$Node<E> r5 = r4.n
            if (r5 == 0) goto L_0x0043
            int r6 = r5.index
            if (r6 > r0) goto L_0x0043
            r4 = r5
            goto L_0x0039
        L_0x0043:
            int r5 = r4.index
            if (r0 <= r5) goto L_0x005e
            com.badlogic.gdx.utils.SortedIntList$NodePool<E> r2 = r3.nodePool
            com.badlogic.gdx.utils.SortedIntList$Node<E> r5 = r4.n
            com.badlogic.gdx.utils.SortedIntList$Node r0 = r2.obtain(r4, r5, r1, r0)
            r4.n = r0
            com.badlogic.gdx.utils.SortedIntList$Node<E> r2 = r0.n
            if (r2 == 0) goto L_0x0057
            r2.p = r0
        L_0x0057:
            int r0 = r3.size
            int r0 = r0 + 1
            r3.size = r0
            goto L_0x0086
        L_0x005e:
            if (r0 >= r5) goto L_0x0075
            com.badlogic.gdx.utils.SortedIntList$NodePool<E> r4 = r3.nodePool
            com.badlogic.gdx.utils.SortedIntList$Node<E> r5 = r3.first
            com.badlogic.gdx.utils.SortedIntList$Node r0 = r4.obtain(r2, r5, r1, r0)
            com.badlogic.gdx.utils.SortedIntList$Node<E> r2 = r3.first
            r2.p = r0
            r3.first = r0
            int r0 = r3.size
            int r0 = r0 + 1
            r3.size = r0
            goto L_0x0086
        L_0x0075:
            r4.value = r1
            goto L_0x0086
        L_0x0078:
            com.badlogic.gdx.utils.SortedIntList$NodePool<E> r4 = r3.nodePool
            com.badlogic.gdx.utils.SortedIntList$Node r0 = r4.obtain(r2, r2, r1, r0)
            r3.first = r0
            int r0 = r3.size
            int r0 = r0 + 1
            r3.size = r0
        L_0x0086:
            r1.add(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g3d.decals.DecalBatch.add(com.badlogic.gdx.graphics.g3d.decals.Decal):void");
    }

    public void clear() {
        SortedIntList<Array<Decal>> sortedIntList = this.groupList;
        while (true) {
            Node<E> node = sortedIntList.first;
            if (node != null) {
                sortedIntList.nodePool.free(node);
                sortedIntList.first = sortedIntList.first.n;
            } else {
                sortedIntList.size = 0;
                this.groupPool.freeAll(this.usedGroups);
                this.usedGroups.clear();
                return;
            }
        }
    }

    public void dispose() {
        clear();
        this.vertices = null;
        this.mesh.dispose();
    }

    public void flush() {
        render();
        clear();
    }

    public int getSize() {
        return this.vertices.length / 24;
    }

    public void initialize(int i) {
        this.vertices = new float[(i * 24)];
        VertexDataType vertexDataType = VertexDataType.VertexArray;
        if (k.gl30 != null) {
            vertexDataType = VertexDataType.VertexBufferObjectWithVAO;
        }
        int i2 = i * 4;
        int i3 = i * 6;
        int i4 = 0;
        Mesh mesh2 = new Mesh(vertexDataType, false, i2, i3, new VertexAttribute(1, 3, ShaderProgram.POSITION_ATTRIBUTE), new VertexAttribute(4, 4, ShaderProgram.COLOR_ATTRIBUTE), new VertexAttribute(16, 2, "a_texCoord0"));
        this.mesh = mesh2;
        short[] sArr = new short[i3];
        int i5 = 0;
        while (i4 < i3) {
            sArr[i4] = (short) i5;
            short s = (short) (i5 + 2);
            sArr[i4 + 1] = s;
            short s2 = (short) (i5 + 1);
            sArr[i4 + 2] = s2;
            sArr[i4 + 3] = s2;
            sArr[i4 + 4] = s;
            sArr[i4 + 5] = (short) (i5 + 3);
            i4 += 6;
            i5 += 4;
        }
        this.mesh.setIndices(sArr);
    }

    public void render() {
        this.groupStrategy.beforeGroups();
        Iterator it = this.groupList.iterator();
        while (true) {
            SortedIntList.Iterator iterator = (SortedIntList.Iterator) it;
            if (iterator.hasNext()) {
                Node node = (Node) iterator.next();
                this.groupStrategy.beforeGroup(node.index, (Array) node.value);
                render(this.groupStrategy.getGroupShader(node.index), (Array) node.value);
                this.groupStrategy.afterGroup(node.index);
            } else {
                this.groupStrategy.afterGroups();
                return;
            }
        }
    }

    public void setGroupStrategy(GroupStrategy groupStrategy2) {
        this.groupStrategy = groupStrategy2;
    }

    public DecalBatch(int i, GroupStrategy groupStrategy2) {
        this.groupList = new SortedIntList<>();
        this.groupPool = new Pool<Array<Decal>>(16) {
            public Array<Decal> newObject() {
                return new Array<>(false, 100);
            }
        };
        this.usedGroups = new Array<>(true, 16);
        initialize(i);
        setGroupStrategy(groupStrategy2);
    }

    public void flush(ShaderProgram shaderProgram, int i) {
        this.mesh.setVertices(this.vertices, 0, i);
        this.mesh.render(shaderProgram, 4, 0, i / 4);
    }

    private void render(ShaderProgram shaderProgram, Array<Decal> array) {
        int i;
        ArrayIterator it = array.iterator();
        DecalMaterial decalMaterial = null;
        loop0:
        while (true) {
            i = 0;
            while (it.hasNext()) {
                Decal decal = (Decal) it.next();
                if (decalMaterial == null || !decalMaterial.equals(decal.getMaterial())) {
                    if (i > 0) {
                        flush(shaderProgram, i);
                        i = 0;
                    }
                    decal.material.set();
                    decalMaterial = decal.material;
                }
                decal.update();
                float[] fArr = decal.vertices;
                System.arraycopy(fArr, 0, this.vertices, i, fArr.length);
                i += decal.vertices.length;
                if (i == this.vertices.length) {
                    flush(shaderProgram, i);
                }
            }
            break loop0;
        }
        if (i > 0) {
            flush(shaderProgram, i);
        }
    }
}
