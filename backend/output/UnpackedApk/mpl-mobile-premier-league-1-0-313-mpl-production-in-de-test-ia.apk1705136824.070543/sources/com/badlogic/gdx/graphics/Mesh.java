package com.badlogic.gdx.graphics;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.graphics.glutils.IndexArray;
import com.badlogic.gdx.graphics.glutils.IndexBufferObject;
import com.badlogic.gdx.graphics.glutils.IndexBufferObjectSubData;
import com.badlogic.gdx.graphics.glutils.IndexData;
import com.badlogic.gdx.graphics.glutils.InstanceBufferObject;
import com.badlogic.gdx.graphics.glutils.InstanceData;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.VertexArray;
import com.badlogic.gdx.graphics.glutils.VertexBufferObject;
import com.badlogic.gdx.graphics.glutils.VertexBufferObjectSubData;
import com.badlogic.gdx.graphics.glutils.VertexBufferObjectWithVAO;
import com.badlogic.gdx.graphics.glutils.VertexData;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;

public class Mesh implements Disposable {
    public static final Map<Application, Array<Mesh>> meshes = new HashMap();
    public boolean autoBind;
    public final IndexData indices;
    public InstanceData instances;
    public boolean isInstanced;
    public final boolean isVertexArray;
    public final Vector3 tmpV;
    public final VertexData vertices;

    /* renamed from: com.badlogic.gdx.graphics.Mesh$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$badlogic$gdx$graphics$Mesh$VertexDataType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0015 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001c */
        static {
            /*
                com.badlogic.gdx.graphics.Mesh$VertexDataType[] r0 = com.badlogic.gdx.graphics.Mesh.VertexDataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$badlogic$gdx$graphics$Mesh$VertexDataType = r0
                com.badlogic.gdx.graphics.Mesh$VertexDataType r1 = com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexBufferObject     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = $SwitchMap$com$badlogic$gdx$graphics$Mesh$VertexDataType     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.badlogic.gdx.graphics.Mesh$VertexDataType r1 = com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexBufferObjectSubData     // Catch:{ NoSuchFieldError -> 0x0015 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r0 = $SwitchMap$com$badlogic$gdx$graphics$Mesh$VertexDataType     // Catch:{ NoSuchFieldError -> 0x001c }
                com.badlogic.gdx.graphics.Mesh$VertexDataType r1 = com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexBufferObjectWithVAO     // Catch:{ NoSuchFieldError -> 0x001c }
                r1 = 3
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                int[] r0 = $SwitchMap$com$badlogic$gdx$graphics$Mesh$VertexDataType     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.badlogic.gdx.graphics.Mesh$VertexDataType r1 = com.badlogic.gdx.graphics.Mesh.VertexDataType.VertexArray     // Catch:{ NoSuchFieldError -> 0x0024 }
                r1 = 0
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.Mesh.AnonymousClass1.<clinit>():void");
        }
    }

    public enum VertexDataType {
        VertexArray,
        VertexBufferObject,
        VertexBufferObjectSubData,
        VertexBufferObjectWithVAO
    }

    public Mesh(VertexData vertexData, IndexData indexData, boolean z) {
        this.autoBind = true;
        this.isInstanced = false;
        this.tmpV = new Vector3();
        this.vertices = vertexData;
        this.indices = indexData;
        this.isVertexArray = z;
        addManagedMesh(k.app, this);
    }

    public static void addManagedMesh(Application application, Mesh mesh) {
        Array array = meshes.get(application);
        if (array == null) {
            array = new Array();
        }
        array.add(mesh);
        meshes.put(application, array);
    }

    public static void clearAllMeshes(Application application) {
        meshes.remove(application);
    }

    public static String getManagedStatus() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Managed meshes/app: { ");
        for (Application application : meshes.keySet()) {
            outline73.append(meshes.get(application).size);
            outline73.append(CMap.SPACE);
        }
        outline73.append("}");
        return outline73.toString();
    }

    public static void invalidateAllMeshes(Application application) {
        Array array = meshes.get(application);
        if (array != null) {
            for (int i = 0; i < array.size; i++) {
                ((Mesh) array.get(i)).vertices.invalidate();
                ((Mesh) array.get(i)).indices.invalidate();
            }
        }
    }

    private VertexData makeVertexBuffer(boolean z, int i, VertexAttributes vertexAttributes) {
        if (k.gl30 != null) {
            return new VertexBufferObjectWithVAO(z, i, vertexAttributes);
        }
        return new VertexBufferObject(z, i, vertexAttributes);
    }

    public void bind(ShaderProgram shaderProgram) {
        bind(shaderProgram, null);
    }

    public BoundingBox calculateBoundingBox() {
        BoundingBox boundingBox = new BoundingBox();
        calculateBoundingBox(boundingBox);
        return boundingBox;
    }

    public float calculateRadius(float f2, float f3, float f4, int i, int i2, Matrix4 matrix4) {
        return (float) Math.sqrt((double) calculateRadiusSquared(f2, f3, f4, i, i2, matrix4));
    }

    public float calculateRadiusSquared(float f2, float f3, float f4, int i, int i2, Matrix4 matrix4) {
        float f5 = f2;
        float f6 = f3;
        float f7 = f4;
        int i3 = i2;
        Matrix4 matrix42 = matrix4;
        int numIndices = getNumIndices();
        if (i >= 0 && i3 >= 1) {
            int i4 = i + i3;
            if (i4 <= numIndices) {
                FloatBuffer buffer = this.vertices.getBuffer();
                ShortBuffer buffer2 = this.indices.getBuffer();
                VertexAttribute vertexAttribute = getVertexAttribute(1);
                int i5 = vertexAttribute.offset / 4;
                int i6 = this.vertices.getAttributes().vertexSize / 4;
                int i7 = vertexAttribute.numComponents;
                short s = 65535;
                float f8 = 0.0f;
                if (i7 == 1) {
                    int i8 = i5;
                    float f9 = 0.0f;
                    for (int i9 = i; i9 < i4; i9++) {
                        this.tmpV.set(buffer.get(((buffer2.get(i9) & 65535) * i6) + i8), 0.0f, 0.0f);
                        if (matrix42 != null) {
                            this.tmpV.mul(matrix42);
                        }
                        Vector3 vector3 = this.tmpV;
                        vector3.sub(f5, f6, f7);
                        float len2 = vector3.len2();
                        if (len2 > f9) {
                            f9 = len2;
                        }
                    }
                    return f9;
                } else if (i7 == 2) {
                    int i10 = i5;
                    float f10 = 0.0f;
                    for (int i11 = i; i11 < i4; i11++) {
                        int i12 = ((buffer2.get(i11) & 65535) * i6) + i10;
                        this.tmpV.set(buffer.get(i12), buffer.get(i12 + 1), 0.0f);
                        if (matrix42 != null) {
                            this.tmpV.mul(matrix42);
                        }
                        Vector3 vector32 = this.tmpV;
                        vector32.sub(f5, f6, f7);
                        float len22 = vector32.len2();
                        if (len22 > f10) {
                            f10 = len22;
                        }
                    }
                    return f10;
                } else if (i7 != 3) {
                    return 0.0f;
                } else {
                    int i13 = i;
                    while (i13 < i4) {
                        int i14 = ((buffer2.get(i13) & s) * i6) + i5;
                        int i15 = i5;
                        this.tmpV.set(buffer.get(i14), buffer.get(i14 + 1), buffer.get(i14 + 2));
                        if (matrix42 != null) {
                            this.tmpV.mul(matrix42);
                        }
                        Vector3 vector33 = this.tmpV;
                        vector33.sub(f5, f6, f7);
                        float len23 = vector33.len2();
                        if (len23 > f8) {
                            f8 = len23;
                        }
                        i13++;
                        i5 = i15;
                        s = 65535;
                    }
                    return f8;
                }
            }
        }
        throw new GdxRuntimeException((String) "Not enough indices");
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [short[]] */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r9v2, types: [short[]] */
    /* JADX WARNING: type inference failed for: r8v0, types: [short, int] */
    /* JADX WARNING: type inference failed for: r14v0, types: [short] */
    /* JADX WARNING: type inference failed for: r14v4 */
    /* JADX WARNING: type inference failed for: r14v5 */
    /* JADX WARNING: type inference failed for: r14v6 */
    /* JADX WARNING: type inference failed for: r14v7 */
    /* JADX WARNING: type inference failed for: r14v8 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r14v14 */
    /* JADX WARNING: type inference failed for: r14v15 */
    /* JADX WARNING: type inference failed for: r14v16 */
    /* JADX WARNING: type inference failed for: r14v17 */
    /* JADX WARNING: type inference failed for: r14v18 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r14v7
      assigns: []
      uses: []
      mth insns count: 149
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0117  */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.badlogic.gdx.graphics.Mesh copy(boolean r19, boolean r20, int[] r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r21
            int r3 = r18.getVertexSize()
            int r3 = r3 / 4
            int r4 = r18.getNumVertices()
            int r5 = r4 * r3
            float[] r6 = new float[r5]
            r7 = 0
            r0.getVertices(r7, r5, r6)
            if (r2 == 0) goto L_0x006b
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x001d:
            int r13 = r2.length
            if (r10 >= r13) goto L_0x0036
            r13 = r2[r10]
            com.badlogic.gdx.graphics.VertexAttribute r13 = r0.getVertexAttribute(r13)
            if (r13 == 0) goto L_0x0033
            r13 = r2[r10]
            com.badlogic.gdx.graphics.VertexAttribute r13 = r0.getVertexAttribute(r13)
            int r13 = r13.numComponents
            int r11 = r11 + r13
            int r12 = r12 + 1
        L_0x0033:
            int r10 = r10 + 1
            goto L_0x001d
        L_0x0036:
            if (r11 <= 0) goto L_0x006b
            com.badlogic.gdx.graphics.VertexAttribute[] r10 = new com.badlogic.gdx.graphics.VertexAttribute[r12]
            short[] r11 = new short[r11]
            r12 = 0
            r13 = 0
            r14 = -1
            r15 = -1
        L_0x0040:
            int r8 = r2.length
            if (r12 >= r8) goto L_0x006e
            r8 = r2[r12]
            com.badlogic.gdx.graphics.VertexAttribute r8 = r0.getVertexAttribute(r8)
            if (r8 != 0) goto L_0x004c
            goto L_0x0067
        L_0x004c:
            r9 = 0
        L_0x004d:
            int r7 = r8.numComponents
            if (r9 >= r7) goto L_0x005c
            int r14 = r14 + 1
            int r7 = r8.offset
            int r7 = r7 + r9
            short r7 = (short) r7
            r11[r14] = r7
            int r9 = r9 + 1
            goto L_0x004d
        L_0x005c:
            int r15 = r15 + 1
            com.badlogic.gdx.graphics.VertexAttribute r7 = r8.copy()
            r10[r15] = r7
            int r7 = r8.numComponents
            int r13 = r13 + r7
        L_0x0067:
            int r12 = r12 + 1
            r7 = 0
            goto L_0x0040
        L_0x006b:
            r10 = 0
            r11 = 0
            r13 = 0
        L_0x006e:
            if (r11 != 0) goto L_0x007c
            short[] r11 = new short[r3]
            r2 = 0
        L_0x0073:
            if (r2 >= r3) goto L_0x007b
            r11[r2] = r2
            int r2 = r2 + 1
            short r2 = (short) r2
            goto L_0x0073
        L_0x007b:
            r13 = r3
        L_0x007c:
            int r2 = r18.getNumIndices()
            if (r2 <= 0) goto L_0x00f3
            short[] r9 = new short[r2]
            r0.getIndices(r9)
            if (r20 != 0) goto L_0x008b
            if (r13 == r3) goto L_0x00f4
        L_0x008b:
            float[] r4 = new float[r5]
            r5 = 0
            r7 = 0
        L_0x008f:
            if (r7 >= r2) goto L_0x00f0
            short r8 = r9[r7]
            int r8 = r8 * r3
            if (r20 == 0) goto L_0x00ca
            r12 = 0
            r14 = -1
        L_0x0099:
            if (r12 >= r5) goto L_0x00c7
            if (r14 >= 0) goto L_0x00c7
            int r15 = r12 * r13
            r16 = 1
            r21 = r2
            r0 = 0
        L_0x00a4:
            int r2 = r11.length
            if (r0 >= r2) goto L_0x00bc
            if (r16 == 0) goto L_0x00bc
            int r2 = r15 + r0
            r2 = r4[r2]
            short r17 = r11[r0]
            int r17 = r8 + r17
            r17 = r6[r17]
            int r2 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r2 == 0) goto L_0x00b9
            r16 = 0
        L_0x00b9:
            int r0 = r0 + 1
            goto L_0x00a4
        L_0x00bc:
            if (r16 == 0) goto L_0x00bf
            r14 = r12
        L_0x00bf:
            int r12 = r12 + 1
            short r12 = (short) r12
            r0 = r18
            r2 = r21
            goto L_0x0099
        L_0x00c7:
            r21 = r2
            goto L_0x00cd
        L_0x00ca:
            r21 = r2
            r14 = -1
        L_0x00cd:
            if (r14 <= 0) goto L_0x00d2
            r9[r7] = r14
            goto L_0x00e9
        L_0x00d2:
            int r0 = r5 * r13
            r2 = 0
        L_0x00d5:
            int r12 = r11.length
            if (r2 >= r12) goto L_0x00e4
            int r12 = r0 + r2
            short r14 = r11[r2]
            int r14 = r14 + r8
            r14 = r6[r14]
            r4[r12] = r14
            int r2 = r2 + 1
            goto L_0x00d5
        L_0x00e4:
            short r0 = (short) r5
            r9[r7] = r0
            int r5 = r5 + 1
        L_0x00e9:
            int r7 = r7 + 1
            r0 = r18
            r2 = r21
            goto L_0x008f
        L_0x00f0:
            r6 = r4
            r4 = r5
            goto L_0x00f4
        L_0x00f3:
            r9 = 0
        L_0x00f4:
            if (r10 != 0) goto L_0x0105
            com.badlogic.gdx.graphics.Mesh r0 = new com.badlogic.gdx.graphics.Mesh
            if (r9 != 0) goto L_0x00fc
            r2 = 0
            goto L_0x00fd
        L_0x00fc:
            int r2 = r9.length
        L_0x00fd:
            com.badlogic.gdx.graphics.VertexAttributes r3 = r18.getVertexAttributes()
            r0.<init>(r1, r4, r2, r3)
            goto L_0x010f
        L_0x0105:
            com.badlogic.gdx.graphics.Mesh r0 = new com.badlogic.gdx.graphics.Mesh
            if (r9 != 0) goto L_0x010b
            r2 = 0
            goto L_0x010c
        L_0x010b:
            int r2 = r9.length
        L_0x010c:
            r0.<init>(r1, r4, r2, r10)
        L_0x010f:
            int r4 = r4 * r13
            r1 = 0
            r0.setVertices(r6, r1, r4)
            if (r9 == 0) goto L_0x011a
            r0.setIndices(r9)
        L_0x011a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.Mesh.copy(boolean, boolean, int[]):com.badlogic.gdx.graphics.Mesh");
    }

    public Mesh disableInstancedRendering() {
        if (this.isInstanced) {
            this.isInstanced = false;
            this.instances.dispose();
            this.instances = null;
        }
        return this;
    }

    public void dispose() {
        if (meshes.get(k.app) != null) {
            meshes.get(k.app).removeValue(this, true);
        }
        this.vertices.dispose();
        InstanceData instanceData = this.instances;
        if (instanceData != null) {
            instanceData.dispose();
        }
        this.indices.dispose();
    }

    public Mesh enableInstancedRendering(boolean z, int i, VertexAttribute... vertexAttributeArr) {
        if (!this.isInstanced) {
            this.isInstanced = true;
            this.instances = new InstanceBufferObject(z, i, vertexAttributeArr);
            return this;
        }
        throw new GdxRuntimeException((String) "Trying to enable InstancedRendering on same Mesh instance twice. Use disableInstancedRendering to clean up old InstanceData first");
    }

    public BoundingBox extendBoundingBox(BoundingBox boundingBox, int i, int i2) {
        return extendBoundingBox(boundingBox, i, i2, null);
    }

    public void getIndices(short[] sArr) {
        getIndices(sArr, 0);
    }

    public ShortBuffer getIndicesBuffer() {
        return this.indices.getBuffer();
    }

    public int getMaxIndices() {
        return this.indices.getNumMaxIndices();
    }

    public int getMaxVertices() {
        return this.vertices.getNumMaxVertices();
    }

    public int getNumIndices() {
        return this.indices.getNumIndices();
    }

    public int getNumVertices() {
        return this.vertices.getNumVertices();
    }

    public VertexAttribute getVertexAttribute(int i) {
        VertexAttributes attributes = this.vertices.getAttributes();
        int size = attributes.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (attributes.get(i2).usage == i) {
                return attributes.get(i2);
            }
        }
        return null;
    }

    public VertexAttributes getVertexAttributes() {
        return this.vertices.getAttributes();
    }

    public int getVertexSize() {
        return this.vertices.getAttributes().vertexSize;
    }

    public float[] getVertices(float[] fArr) {
        return getVertices(0, -1, fArr);
    }

    public FloatBuffer getVerticesBuffer() {
        return this.vertices.getBuffer();
    }

    public boolean isInstanced() {
        return this.isInstanced;
    }

    public void render(ShaderProgram shaderProgram, int i) {
        render(shaderProgram, i, 0, this.indices.getNumMaxIndices() > 0 ? getNumIndices() : getNumVertices(), this.autoBind);
    }

    public void scale(float f2, float f3, float f4) {
        VertexAttribute vertexAttribute = getVertexAttribute(1);
        int i = vertexAttribute.offset / 4;
        int i2 = vertexAttribute.numComponents;
        int numVertices = getNumVertices();
        int vertexSize = getVertexSize() / 4;
        float[] fArr = new float[(numVertices * vertexSize)];
        getVertices(fArr);
        int i3 = 0;
        if (i2 == 1) {
            while (i3 < numVertices) {
                fArr[i] = fArr[i] * f2;
                i += vertexSize;
                i3++;
            }
        } else if (i2 == 2) {
            while (i3 < numVertices) {
                fArr[i] = fArr[i] * f2;
                int i4 = i + 1;
                fArr[i4] = fArr[i4] * f3;
                i += vertexSize;
                i3++;
            }
        } else if (i2 == 3) {
            while (i3 < numVertices) {
                fArr[i] = fArr[i] * f2;
                int i5 = i + 1;
                fArr[i5] = fArr[i5] * f3;
                int i6 = i + 2;
                fArr[i6] = fArr[i6] * f4;
                i += vertexSize;
                i3++;
            }
        }
        setVertices(fArr);
    }

    public void setAutoBind(boolean z) {
        this.autoBind = z;
    }

    public Mesh setIndices(short[] sArr) {
        this.indices.setIndices(sArr, 0, sArr.length);
        return this;
    }

    public Mesh setInstanceData(float[] fArr, int i, int i2) {
        InstanceData instanceData = this.instances;
        if (instanceData != null) {
            instanceData.setInstanceData(fArr, i, i2);
            return this;
        }
        throw new GdxRuntimeException((String) "An InstanceBufferObject must be set before setting instance data!");
    }

    public Mesh setVertices(float[] fArr) {
        this.vertices.setVertices(fArr, 0, fArr.length);
        return this;
    }

    public void transform(Matrix4 matrix4) {
        transform(matrix4, 0, getNumVertices());
    }

    public void transformUV(Matrix3 matrix3) {
        transformUV(matrix3, 0, getNumVertices());
    }

    public void unbind(ShaderProgram shaderProgram) {
        unbind(shaderProgram, null);
    }

    public Mesh updateInstanceData(int i, float[] fArr) {
        return updateInstanceData(i, fArr, 0, fArr.length);
    }

    public Mesh updateVertices(int i, float[] fArr) {
        return updateVertices(i, fArr, 0, fArr.length);
    }

    public void bind(ShaderProgram shaderProgram, int[] iArr) {
        this.vertices.bind(shaderProgram, iArr);
        InstanceData instanceData = this.instances;
        if (instanceData != null && instanceData.getNumInstances() > 0) {
            this.instances.bind(shaderProgram, iArr);
        }
        if (this.indices.getNumIndices() > 0) {
            this.indices.bind();
        }
    }

    public float calculateRadius(Vector3 vector3, int i, int i2, Matrix4 matrix4) {
        return calculateRadius(vector3.x, vector3.y, vector3.z, i, i2, matrix4);
    }

    public BoundingBox extendBoundingBox(BoundingBox boundingBox, int i, int i2, Matrix4 matrix4) {
        int numIndices = getNumIndices();
        int numVertices = getNumVertices();
        if (numIndices != 0) {
            numVertices = numIndices;
        }
        if (i >= 0 && i2 >= 1) {
            int i3 = i + i2;
            if (i3 <= numVertices) {
                FloatBuffer buffer = this.vertices.getBuffer();
                ShortBuffer buffer2 = this.indices.getBuffer();
                VertexAttribute vertexAttribute = getVertexAttribute(1);
                int i4 = vertexAttribute.offset / 4;
                int i5 = this.vertices.getAttributes().vertexSize / 4;
                int i6 = vertexAttribute.numComponents;
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (numIndices > 0) {
                                while (i < i3) {
                                    int i7 = ((buffer2.get(i) & 65535) * i5) + i4;
                                    this.tmpV.set(buffer.get(i7), buffer.get(i7 + 1), buffer.get(i7 + 2));
                                    if (matrix4 != null) {
                                        this.tmpV.mul(matrix4);
                                    }
                                    boundingBox.ext(this.tmpV);
                                    i++;
                                }
                            } else {
                                while (i < i3) {
                                    int i8 = (i * i5) + i4;
                                    this.tmpV.set(buffer.get(i8), buffer.get(i8 + 1), buffer.get(i8 + 2));
                                    if (matrix4 != null) {
                                        this.tmpV.mul(matrix4);
                                    }
                                    boundingBox.ext(this.tmpV);
                                    i++;
                                }
                            }
                        }
                    } else if (numIndices > 0) {
                        while (i < i3) {
                            int i9 = ((buffer2.get(i) & 65535) * i5) + i4;
                            this.tmpV.set(buffer.get(i9), buffer.get(i9 + 1), 0.0f);
                            if (matrix4 != null) {
                                this.tmpV.mul(matrix4);
                            }
                            boundingBox.ext(this.tmpV);
                            i++;
                        }
                    } else {
                        while (i < i3) {
                            int i10 = (i * i5) + i4;
                            this.tmpV.set(buffer.get(i10), buffer.get(i10 + 1), 0.0f);
                            if (matrix4 != null) {
                                this.tmpV.mul(matrix4);
                            }
                            boundingBox.ext(this.tmpV);
                            i++;
                        }
                    }
                } else if (numIndices > 0) {
                    while (i < i3) {
                        this.tmpV.set(buffer.get(((buffer2.get(i) & 65535) * i5) + i4), 0.0f, 0.0f);
                        if (matrix4 != null) {
                            this.tmpV.mul(matrix4);
                        }
                        boundingBox.ext(this.tmpV);
                        i++;
                    }
                } else {
                    while (i < i3) {
                        this.tmpV.set(buffer.get((i * i5) + i4), 0.0f, 0.0f);
                        if (matrix4 != null) {
                            this.tmpV.mul(matrix4);
                        }
                        boundingBox.ext(this.tmpV);
                        i++;
                    }
                }
                return boundingBox;
            }
        }
        throw new GdxRuntimeException(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline75("Invalid part specified ( offset=", i, ", count=", i2, ", max="), numVertices, " )"));
    }

    public void getIndices(short[] sArr, int i) {
        getIndices(0, sArr, i);
    }

    public float[] getVertices(int i, float[] fArr) {
        return getVertices(i, -1, fArr);
    }

    public void render(ShaderProgram shaderProgram, int i, int i2, int i3) {
        render(shaderProgram, i, i2, i3, this.autoBind);
    }

    public Mesh setIndices(short[] sArr, int i, int i2) {
        this.indices.setIndices(sArr, i, i2);
        return this;
    }

    public Mesh setVertices(float[] fArr, int i, int i2) {
        this.vertices.setVertices(fArr, i, i2);
        return this;
    }

    public void transform(Matrix4 matrix4, int i, int i2) {
        VertexAttribute vertexAttribute = getVertexAttribute(1);
        int i3 = vertexAttribute.offset / 4;
        int vertexSize = getVertexSize() / 4;
        int i4 = vertexAttribute.numComponents;
        getNumVertices();
        int i5 = i2 * vertexSize;
        float[] fArr = new float[i5];
        int i6 = i * vertexSize;
        getVertices(i6, i5, fArr);
        transform(matrix4, fArr, vertexSize, i3, i4, 0, i2);
        updateVertices(i6, fArr);
    }

    public void transformUV(Matrix3 matrix3, int i, int i2) {
        int i3 = getVertexAttribute(16).offset / 4;
        int vertexSize = getVertexSize() / 4;
        int numVertices = getNumVertices() * vertexSize;
        float[] fArr = new float[numVertices];
        getVertices(0, numVertices, fArr);
        transformUV(matrix3, fArr, vertexSize, i3, i, i2);
        setVertices(fArr, 0, numVertices);
    }

    public void unbind(ShaderProgram shaderProgram, int[] iArr) {
        this.vertices.unbind(shaderProgram, iArr);
        InstanceData instanceData = this.instances;
        if (instanceData != null && instanceData.getNumInstances() > 0) {
            this.instances.unbind(shaderProgram, iArr);
        }
        if (this.indices.getNumIndices() > 0) {
            this.indices.unbind();
        }
    }

    public Mesh updateInstanceData(int i, float[] fArr, int i2, int i3) {
        this.instances.updateInstanceData(i, fArr, i2, i3);
        return this;
    }

    public Mesh updateVertices(int i, float[] fArr, int i2, int i3) {
        this.vertices.updateVertices(i, fArr, i2, i3);
        return this;
    }

    public void calculateBoundingBox(BoundingBox boundingBox) {
        int numVertices = getNumVertices();
        if (numVertices != 0) {
            FloatBuffer buffer = this.vertices.getBuffer();
            boundingBox.inf();
            VertexAttribute vertexAttribute = getVertexAttribute(1);
            int i = vertexAttribute.offset / 4;
            int i2 = this.vertices.getAttributes().vertexSize / 4;
            int i3 = vertexAttribute.numComponents;
            int i4 = 0;
            if (i3 == 1) {
                while (i4 < numVertices) {
                    boundingBox.ext(buffer.get(i), 0.0f, 0.0f);
                    i += i2;
                    i4++;
                }
            } else if (i3 == 2) {
                while (i4 < numVertices) {
                    boundingBox.ext(buffer.get(i), buffer.get(i + 1), 0.0f);
                    i += i2;
                    i4++;
                }
            } else if (i3 == 3) {
                while (i4 < numVertices) {
                    boundingBox.ext(buffer.get(i), buffer.get(i + 1), buffer.get(i + 2));
                    i += i2;
                    i4++;
                }
            }
        } else {
            throw new GdxRuntimeException((String) "No vertices defined");
        }
    }

    public float calculateRadius(float f2, float f3, float f4, int i, int i2) {
        return calculateRadius(f2, f3, f4, i, i2, null);
    }

    public void getIndices(int i, short[] sArr, int i2) {
        getIndices(i, -1, sArr, i2);
    }

    public float[] getVertices(int i, int i2, float[] fArr) {
        return getVertices(i, i2, fArr, 0);
    }

    public void render(ShaderProgram shaderProgram, int i, int i2, int i3, boolean z) {
        if (i3 != 0) {
            if (z) {
                bind(shaderProgram);
            }
            if (!this.isVertexArray) {
                int numInstances = this.isInstanced ? this.instances.getNumInstances() : 0;
                if (this.indices.getNumIndices() > 0) {
                    if (i3 + i2 > this.indices.getNumMaxIndices()) {
                        StringBuilder outline75 = GeneratedOutlineSupport.outline75("Mesh attempting to access memory outside of the index buffer (count: ", i3, ", offset: ", i2, ", max: ");
                        outline75.append(this.indices.getNumMaxIndices());
                        outline75.append(")");
                        throw new GdxRuntimeException(outline75.toString());
                    } else if (!this.isInstanced || numInstances <= 0) {
                        k.gl20.glDrawElements(i, i3, (int) GL20.GL_UNSIGNED_SHORT, i2 * 2);
                    } else {
                        k.gl30.glDrawElementsInstanced(i, i3, GL20.GL_UNSIGNED_SHORT, i2 * 2, numInstances);
                    }
                } else if (!this.isInstanced || numInstances <= 0) {
                    k.gl20.glDrawArrays(i, i2, i3);
                } else {
                    k.gl30.glDrawArraysInstanced(i, i2, i3, numInstances);
                }
            } else if (this.indices.getNumIndices() > 0) {
                ShortBuffer buffer = this.indices.getBuffer();
                int position = buffer.position();
                int limit = buffer.limit();
                buffer.position(i2);
                buffer.limit(i2 + i3);
                k.gl20.glDrawElements(i, i3, (int) GL20.GL_UNSIGNED_SHORT, (Buffer) buffer);
                buffer.position(position);
                buffer.limit(limit);
            } else {
                k.gl20.glDrawArrays(i, i2, i3);
            }
            if (z) {
                unbind(shaderProgram);
            }
        }
    }

    public Mesh updateInstanceData(int i, FloatBuffer floatBuffer) {
        return updateInstanceData(i, floatBuffer, 0, floatBuffer.limit());
    }

    public float calculateRadius(Vector3 vector3, int i, int i2) {
        return calculateRadius(vector3.x, vector3.y, vector3.z, i, i2, null);
    }

    public void getIndices(int i, int i2, short[] sArr, int i3) {
        int numIndices = getNumIndices();
        if (i2 < 0) {
            i2 = numIndices - i;
        }
        if (i < 0 || i >= numIndices || i + i2 > numIndices) {
            StringBuilder outline75 = GeneratedOutlineSupport.outline75("Invalid range specified, offset: ", i, ", count: ", i2, ", max: ");
            outline75.append(numIndices);
            throw new IllegalArgumentException(outline75.toString());
        } else if (sArr.length - i3 >= i2) {
            int position = getIndicesBuffer().position();
            getVerticesBuffer().position(i);
            getIndicesBuffer().get(sArr, i3, i2);
            getVerticesBuffer().position(position);
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("not enough room in indices array, has ");
            outline73.append(sArr.length);
            outline73.append(" shorts, needs ");
            outline73.append(i2);
            throw new IllegalArgumentException(outline73.toString());
        }
    }

    public float[] getVertices(int i, int i2, float[] fArr, int i3) {
        int vertexSize = (getVertexSize() * getNumVertices()) / 4;
        if (i2 == -1) {
            i2 = vertexSize - i;
            if (i2 > fArr.length - i3) {
                i2 = fArr.length - i3;
            }
        }
        if (i < 0 || i2 <= 0 || i + i2 > vertexSize || i3 < 0 || i3 >= fArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (fArr.length - i3 >= i2) {
            int position = getVerticesBuffer().position();
            getVerticesBuffer().position(i);
            getVerticesBuffer().get(fArr, i3, i2);
            getVerticesBuffer().position(position);
            return fArr;
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("not enough room in vertices array, has ");
            outline73.append(fArr.length);
            outline73.append(" floats, needs ");
            outline73.append(i2);
            throw new IllegalArgumentException(outline73.toString());
        }
    }

    public Mesh setInstanceData(float[] fArr) {
        InstanceData instanceData = this.instances;
        if (instanceData != null) {
            instanceData.setInstanceData(fArr, 0, fArr.length);
            return this;
        }
        throw new GdxRuntimeException((String) "An InstanceBufferObject must be set before setting instance data!");
    }

    public Mesh updateInstanceData(int i, FloatBuffer floatBuffer, int i2, int i3) {
        this.instances.updateInstanceData(i, floatBuffer, i2, i3);
        return this;
    }

    public float calculateRadius(float f2, float f3, float f4) {
        return calculateRadius(f2, f3, f4, 0, getNumIndices(), null);
    }

    public float calculateRadius(Vector3 vector3) {
        return calculateRadius(vector3.x, vector3.y, vector3.z, 0, getNumIndices(), null);
    }

    public Mesh setInstanceData(FloatBuffer floatBuffer, int i) {
        InstanceData instanceData = this.instances;
        if (instanceData != null) {
            instanceData.setInstanceData(floatBuffer, i);
            return this;
        }
        throw new GdxRuntimeException((String) "An InstanceBufferObject must be set before setting instance data!");
    }

    public Mesh(boolean z, int i, int i2, VertexAttribute... vertexAttributeArr) {
        this.autoBind = true;
        this.isInstanced = false;
        this.tmpV = new Vector3();
        this.vertices = makeVertexBuffer(z, i, new VertexAttributes(vertexAttributeArr));
        this.indices = new IndexBufferObject(z, i2);
        this.isVertexArray = false;
        addManagedMesh(k.app, this);
    }

    public static void transformUV(Matrix3 matrix3, float[] fArr, int i, int i2, int i3, int i4) {
        if (i3 < 0 || i4 < 1 || (i3 + i4) * i > fArr.length) {
            StringBuilder outline75 = GeneratedOutlineSupport.outline75("start = ", i3, ", count = ", i4, ", vertexSize = ");
            outline75.append(i);
            outline75.append(", length = ");
            outline75.append(fArr.length);
            throw new IndexOutOfBoundsException(outline75.toString());
        }
        int i5 = (i3 * i) + i2;
        for (int i6 = 0; i6 < i4; i6++) {
            float f2 = fArr[i5];
            int i7 = i5 + 1;
            float f3 = fArr[i7];
            float[] fArr2 = matrix3.val;
            float f4 = (fArr2[3] * f3) + (fArr2[0] * f2) + fArr2[6];
            float f5 = f2 * fArr2[1];
            fArr[i5] = f4;
            fArr[i7] = (f3 * fArr2[4]) + f5 + fArr2[7];
            i5 += i;
        }
    }

    public Mesh setInstanceData(FloatBuffer floatBuffer) {
        InstanceData instanceData = this.instances;
        if (instanceData != null) {
            instanceData.setInstanceData(floatBuffer, floatBuffer.limit());
            return this;
        }
        throw new GdxRuntimeException((String) "An InstanceBufferObject must be set before setting instance data!");
    }

    public static void transform(Matrix4 matrix4, float[] fArr, int i, int i2, int i3, int i4, int i5) {
        if (i2 < 0 || i3 < 1 || i2 + i3 > i) {
            throw new IndexOutOfBoundsException();
        } else if (i4 < 0 || i5 < 1 || (i4 + i5) * i > fArr.length) {
            StringBuilder outline75 = GeneratedOutlineSupport.outline75("start = ", i4, ", count = ", i5, ", vertexSize = ");
            outline75.append(i);
            outline75.append(", length = ");
            outline75.append(fArr.length);
            throw new IndexOutOfBoundsException(outline75.toString());
        } else {
            Vector3 vector3 = new Vector3();
            int i6 = (i4 * i) + i2;
            int i7 = 0;
            if (i3 == 1) {
                while (i7 < i5) {
                    vector3.set(fArr[i6], 0.0f, 0.0f);
                    vector3.mul(matrix4);
                    fArr[i6] = vector3.x;
                    i6 += i;
                    i7++;
                }
            } else if (i3 == 2) {
                while (i7 < i5) {
                    int i8 = i6 + 1;
                    vector3.set(fArr[i6], fArr[i8], 0.0f);
                    vector3.mul(matrix4);
                    fArr[i6] = vector3.x;
                    fArr[i8] = vector3.y;
                    i6 += i;
                    i7++;
                }
            } else if (i3 == 3) {
                while (i7 < i5) {
                    int i9 = i6 + 1;
                    int i10 = i6 + 2;
                    vector3.set(fArr[i6], fArr[i9], fArr[i10]);
                    vector3.mul(matrix4);
                    fArr[i6] = vector3.x;
                    fArr[i9] = vector3.y;
                    fArr[i10] = vector3.z;
                    i6 += i;
                    i7++;
                }
            }
        }
    }

    public BoundingBox calculateBoundingBox(BoundingBox boundingBox, int i, int i2) {
        boundingBox.inf();
        return extendBoundingBox(boundingBox, i, i2);
    }

    public BoundingBox calculateBoundingBox(BoundingBox boundingBox, int i, int i2, Matrix4 matrix4) {
        boundingBox.inf();
        return extendBoundingBox(boundingBox, i, i2, matrix4);
    }

    public Mesh(boolean z, int i, int i2, VertexAttributes vertexAttributes) {
        this.autoBind = true;
        this.isInstanced = false;
        this.tmpV = new Vector3();
        this.vertices = makeVertexBuffer(z, i, vertexAttributes);
        this.indices = new IndexBufferObject(z, i2);
        this.isVertexArray = false;
        addManagedMesh(k.app, this);
    }

    public Mesh(boolean z, boolean z2, int i, int i2, VertexAttributes vertexAttributes) {
        this.autoBind = true;
        this.isInstanced = false;
        this.tmpV = new Vector3();
        this.vertices = makeVertexBuffer(z, i, vertexAttributes);
        this.indices = new IndexBufferObject(z2, i2);
        this.isVertexArray = false;
        addManagedMesh(k.app, this);
    }

    public Mesh(VertexDataType vertexDataType, boolean z, int i, int i2, VertexAttribute... vertexAttributeArr) {
        this(vertexDataType, z, i, i2, new VertexAttributes(vertexAttributeArr));
    }

    public Mesh copy(boolean z) {
        return copy(z, false, null);
    }

    public Mesh(VertexDataType vertexDataType, boolean z, int i, int i2, VertexAttributes vertexAttributes) {
        this.autoBind = true;
        this.isInstanced = false;
        this.tmpV = new Vector3();
        int ordinal = vertexDataType.ordinal();
        if (ordinal == 1) {
            this.vertices = new VertexBufferObject(z, i, vertexAttributes);
            this.indices = new IndexBufferObject(z, i2);
            this.isVertexArray = false;
        } else if (ordinal == 2) {
            this.vertices = new VertexBufferObjectSubData(z, i, vertexAttributes);
            this.indices = new IndexBufferObjectSubData(z, i2);
            this.isVertexArray = false;
        } else if (ordinal != 3) {
            this.vertices = new VertexArray(i, vertexAttributes);
            this.indices = new IndexArray(i2);
            this.isVertexArray = true;
        } else {
            this.vertices = new VertexBufferObjectWithVAO(z, i, vertexAttributes);
            this.indices = new IndexBufferObjectSubData(z, i2);
            this.isVertexArray = false;
        }
        addManagedMesh(k.app, this);
    }
}
