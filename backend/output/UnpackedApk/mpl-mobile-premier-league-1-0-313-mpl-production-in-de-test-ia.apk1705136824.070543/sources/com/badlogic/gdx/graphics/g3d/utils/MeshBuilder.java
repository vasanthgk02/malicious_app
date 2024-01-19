package com.badlogic.gdx.graphics.g3d.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder.VertexInfo;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.ArrowShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BoxShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.CapsuleShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.ConeShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.CylinderShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.EllipseShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.PatchShapeBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.SphereShapeBuilder;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntIntMap;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.ShortArray;
import java.util.Arrays;

public class MeshBuilder implements MeshPartBuilder {
    public static final int MAX_INDEX = 65535;
    public static final int MAX_VERTICES = 65536;
    public static IntIntMap indicesMap = null;
    public static final ShortArray tmpIndices = new ShortArray();
    public static final FloatArray tmpVertices = new FloatArray();
    public static final Vector3 vTmp = new Vector3();
    public VertexAttributes attributes;
    public int biNorOffset;
    public final BoundingBox bounds = new BoundingBox();
    public int colOffset;
    public int colSize;
    public final Color color = new Color(Color.WHITE);
    public int cpOffset;
    public boolean hasColor = false;
    public boolean hasUVTransform = false;
    public ShortArray indices = new ShortArray();
    public int istart;
    public int lastIndex = -1;
    public int norOffset;
    public final Matrix3 normalTransform = new Matrix3();
    public MeshPart part;
    public Array<MeshPart> parts = new Array<>();
    public int posOffset;
    public int posSize;
    public final Matrix4 positionTransform = new Matrix4();
    public int primitiveType;
    public int stride;
    public int tangentOffset;
    public final Color tempC1 = new Color();
    public final Vector3 tmpNormal = new Vector3();
    public float uOffset = 0.0f;
    public float uScale = 1.0f;
    public int uvOffset;
    public float vOffset = 0.0f;
    public float vScale = 1.0f;
    public final VertexInfo vertTmp1 = new VertexInfo();
    public final VertexInfo vertTmp2 = new VertexInfo();
    public final VertexInfo vertTmp3 = new VertexInfo();
    public final VertexInfo vertTmp4 = new VertexInfo();
    public float[] vertex;
    public boolean vertexTransformationEnabled = false;
    public FloatArray vertices = new FloatArray();
    public int vindex;

    private final void addVertex(float[] fArr, int i) {
        FloatArray floatArray = this.vertices;
        int i2 = floatArray.size;
        floatArray.addAll(fArr, i, this.stride);
        int i3 = this.vindex;
        this.vindex = i3 + 1;
        this.lastIndex = i3;
        if (this.vertexTransformationEnabled) {
            transformPosition(this.vertices.items, this.posOffset + i2, this.posSize, this.positionTransform);
            int i4 = this.norOffset;
            if (i4 >= 0) {
                transformNormal(this.vertices.items, i4 + i2, 3, this.normalTransform);
            }
            int i5 = this.biNorOffset;
            if (i5 >= 0) {
                transformNormal(this.vertices.items, i5 + i2, 3, this.normalTransform);
            }
            int i6 = this.tangentOffset;
            if (i6 >= 0) {
                transformNormal(this.vertices.items, i6 + i2, 3, this.normalTransform);
            }
        }
        float[] fArr2 = this.vertices.items;
        int i7 = this.posOffset;
        float f2 = fArr2[i2 + i7];
        float f3 = 0.0f;
        float f4 = this.posSize > 1 ? fArr2[i7 + i2 + 1] : 0.0f;
        if (this.posSize > 2) {
            f3 = this.vertices.items[this.posOffset + i2 + 2];
        }
        this.bounds.ext(f2, f4, f3);
        if (this.hasColor) {
            int i8 = this.colOffset;
            if (i8 >= 0) {
                float[] fArr3 = this.vertices.items;
                int i9 = i2 + i8;
                float f5 = fArr3[i9];
                Color color2 = this.color;
                fArr3[i9] = f5 * color2.r;
                int i10 = i2 + i8 + 1;
                fArr3[i10] = fArr3[i10] * color2.g;
                int i11 = i2 + i8 + 2;
                fArr3[i11] = fArr3[i11] * color2.f3307b;
                if (this.colSize > 3) {
                    int i12 = i8 + i2 + 3;
                    fArr3[i12] = fArr3[i12] * color2.f3306a;
                }
            } else {
                int i13 = this.cpOffset;
                if (i13 >= 0) {
                    Color.abgr8888ToColor(this.tempC1, this.vertices.items[i13 + i2]);
                    this.vertices.items[this.cpOffset + i2] = this.tempC1.mul(this.color).toFloatBits();
                }
            }
        }
        if (this.hasUVTransform) {
            int i14 = this.uvOffset;
            if (i14 >= 0) {
                float[] fArr4 = this.vertices.items;
                fArr4[i2 + i14] = (this.uScale * fArr4[i2 + i14]) + this.uOffset;
                fArr4[i2 + i14 + 1] = (this.vScale * fArr4[i2 + i14 + 1]) + this.vOffset;
            }
        }
    }

    public static VertexAttributes createAttributes(long j) {
        Array array = new Array();
        if ((j & 1) == 1) {
            array.add(new VertexAttribute(1, 3, ShaderProgram.POSITION_ATTRIBUTE));
        }
        if ((j & 2) == 2) {
            array.add(new VertexAttribute(2, 4, ShaderProgram.COLOR_ATTRIBUTE));
        }
        if ((j & 4) == 4) {
            array.add(new VertexAttribute(4, 4, ShaderProgram.COLOR_ATTRIBUTE));
        }
        if ((j & 8) == 8) {
            array.add(new VertexAttribute(8, 3, ShaderProgram.NORMAL_ATTRIBUTE));
        }
        if ((j & 16) == 16) {
            array.add(new VertexAttribute(16, 2, "a_texCoord0"));
        }
        int i = array.size;
        VertexAttribute[] vertexAttributeArr = new VertexAttribute[i];
        for (int i2 = 0; i2 < i; i2++) {
            vertexAttributeArr[i2] = (VertexAttribute) array.get(i2);
        }
        return new VertexAttributes(vertexAttributeArr);
    }

    private void endpart() {
        MeshPart meshPart = this.part;
        if (meshPart != null) {
            meshPart.center.set(this.bounds.cnt);
            BoundingBox boundingBox = this.bounds;
            Vector3 vector3 = this.part.halfExtents;
            vector3.set(boundingBox.dim);
            vector3.scl(0.5f);
            MeshPart meshPart2 = this.part;
            meshPart2.radius = meshPart2.halfExtents.len();
            this.bounds.inf();
            MeshPart meshPart3 = this.part;
            int i = this.istart;
            meshPart3.offset = i;
            int i2 = this.indices.size;
            meshPart3.size = i2 - i;
            this.istart = i2;
            this.part = null;
        }
    }

    public static final void transformNormal(float[] fArr, int i, int i2, Matrix3 matrix3) {
        if (i2 > 2) {
            Vector3 vector3 = vTmp;
            int i3 = i + 1;
            int i4 = i + 2;
            vector3.set(fArr[i], fArr[i3], fArr[i4]);
            vector3.mul(matrix3);
            vector3.nor();
            Vector3 vector32 = vTmp;
            fArr[i] = vector32.x;
            fArr[i3] = vector32.y;
            fArr[i4] = vector32.z;
        } else if (i2 > 1) {
            Vector3 vector33 = vTmp;
            int i5 = i + 1;
            vector33.set(fArr[i], fArr[i5], 0.0f);
            vector33.mul(matrix3);
            vector33.nor();
            Vector3 vector34 = vTmp;
            fArr[i] = vector34.x;
            fArr[i5] = vector34.y;
        } else {
            Vector3 vector35 = vTmp;
            vector35.set(fArr[i], 0.0f, 0.0f);
            vector35.mul(matrix3);
            fArr[i] = vector35.nor().x;
        }
    }

    public static final void transformPosition(float[] fArr, int i, int i2, Matrix4 matrix4) {
        if (i2 > 2) {
            Vector3 vector3 = vTmp;
            int i3 = i + 1;
            int i4 = i + 2;
            vector3.set(fArr[i], fArr[i3], fArr[i4]);
            vector3.mul(matrix4);
            Vector3 vector32 = vTmp;
            fArr[i] = vector32.x;
            fArr[i3] = vector32.y;
            fArr[i4] = vector32.z;
        } else if (i2 > 1) {
            Vector3 vector33 = vTmp;
            int i5 = i + 1;
            vector33.set(fArr[i], fArr[i5], 0.0f);
            vector33.mul(matrix4);
            Vector3 vector34 = vTmp;
            fArr[i] = vector34.x;
            fArr[i5] = vector34.y;
        } else {
            Vector3 vector35 = vTmp;
            vector35.set(fArr[i], 0.0f, 0.0f);
            vector35.mul(matrix4);
            fArr[i] = vector35.x;
        }
    }

    public void addMesh(Mesh mesh) {
        addMesh(mesh, 0, mesh.getNumIndices());
    }

    @Deprecated
    public void arrow(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i) {
        ArrowShapeBuilder.build(this, f2, f3, f4, f5, f6, f7, f8, f9, i);
    }

    public void begin(long j) {
        begin(createAttributes(j), -1);
    }

    @Deprecated
    public void box(VertexInfo vertexInfo, VertexInfo vertexInfo2, VertexInfo vertexInfo3, VertexInfo vertexInfo4, VertexInfo vertexInfo5, VertexInfo vertexInfo6, VertexInfo vertexInfo7, VertexInfo vertexInfo8) {
        BoxShapeBuilder.build((MeshPartBuilder) this, vertexInfo, vertexInfo2, vertexInfo3, vertexInfo4, vertexInfo5, vertexInfo6, vertexInfo7, vertexInfo8);
    }

    @Deprecated
    public void capsule(float f2, float f3, int i) {
        CapsuleShapeBuilder.build(this, f2, f3, i);
    }

    @Deprecated
    public void circle(float f2, int i, float f3, float f4, float f5, float f6, float f7, float f8) {
        EllipseShapeBuilder.build((MeshPartBuilder) this, f2, i, f3, f4, f5, f6, f7, f8);
    }

    public void clear() {
        this.vertices.size = 0;
        this.indices.size = 0;
        this.parts.clear();
        this.vindex = 0;
        this.lastIndex = -1;
        this.istart = 0;
        this.part = null;
    }

    @Deprecated
    public void cone(float f2, float f3, float f4, int i) {
        cone(f2, f3, f4, i, 0.0f, 360.0f);
    }

    @Deprecated
    public void cylinder(float f2, float f3, float f4, int i) {
        CylinderShapeBuilder.build(this, f2, f3, f4, i);
    }

    @Deprecated
    public void ellipse(float f2, float f3, int i, float f4, float f5, float f6, float f7, float f8, float f9) {
        EllipseShapeBuilder.build((MeshPartBuilder) this, f2, f3, i, f4, f5, f6, f7, f8, f9);
    }

    public Mesh end(Mesh mesh) {
        endpart();
        VertexAttributes vertexAttributes = this.attributes;
        if (vertexAttributes == null) {
            throw new GdxRuntimeException((String) "Call begin() first");
        } else if (!vertexAttributes.equals(mesh.getVertexAttributes())) {
            throw new GdxRuntimeException((String) "Mesh attributes don't match");
        } else if (mesh.getMaxVertices() * this.stride < this.vertices.size) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Mesh can't hold enough vertices: ");
            outline73.append(mesh.getMaxVertices());
            outline73.append(" * ");
            outline73.append(this.stride);
            outline73.append(" < ");
            outline73.append(this.vertices.size);
            throw new GdxRuntimeException(outline73.toString());
        } else if (mesh.getMaxIndices() >= this.indices.size) {
            FloatArray floatArray = this.vertices;
            mesh.setVertices(floatArray.items, 0, floatArray.size);
            ShortArray shortArray = this.indices;
            mesh.setIndices(shortArray.items, 0, shortArray.size);
            ArrayIterator it = this.parts.iterator();
            while (it.hasNext()) {
                ((MeshPart) it.next()).mesh = mesh;
            }
            this.parts.clear();
            this.attributes = null;
            this.vertices.size = 0;
            this.indices.size = 0;
            return mesh;
        } else {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Mesh can't hold enough indices: ");
            outline732.append(mesh.getMaxIndices());
            outline732.append(" < ");
            outline732.append(this.indices.size);
            throw new GdxRuntimeException(outline732.toString());
        }
    }

    public void ensureCapacity(int i, int i2) {
        ensureVertices(i);
        ensureIndices(i2);
    }

    public void ensureIndices(int i) {
        this.indices.ensureCapacity(i);
    }

    public void ensureRectangleIndices(int i) {
        int i2 = this.primitiveType;
        if (i2 == 0) {
            ensureIndices(i * 4);
        } else if (i2 == 1) {
            ensureIndices(i * 8);
        } else {
            ensureIndices(i * 6);
        }
    }

    @Deprecated
    public void ensureRectangles(int i, int i2) {
        ensureVertices(i);
        ensureRectangleIndices(i2);
    }

    public void ensureTriangleIndices(int i) {
        int i2 = this.primitiveType;
        if (i2 == 1) {
            ensureIndices(i * 6);
        } else if (i2 == 4 || i2 == 0) {
            ensureIndices(i * 3);
        } else {
            throw new GdxRuntimeException((String) "Incorrect primtive type");
        }
    }

    @Deprecated
    public void ensureTriangles(int i, int i2) {
        ensureVertices(i);
        ensureTriangleIndices(i2);
    }

    public void ensureVertices(int i) {
        this.vertices.ensureCapacity(this.stride * i);
    }

    public VertexAttributes getAttributes() {
        return this.attributes;
    }

    public int getFloatsPerVertex() {
        return this.stride;
    }

    public void getIndices(short[] sArr, int i) {
        if (this.attributes != null) {
            if (i >= 0) {
                int length = sArr.length;
                ShortArray shortArray = this.indices;
                int i2 = shortArray.size;
                if (i <= length - i2) {
                    System.arraycopy(shortArray.items, 0, sArr, i, i2);
                    return;
                }
            }
            throw new GdxRuntimeException((String) "Array too small or offset out of range");
        }
        throw new GdxRuntimeException((String) "Must be called in between #begin and #end");
    }

    public MeshPart getMeshPart() {
        return this.part;
    }

    public int getNumIndices() {
        return this.indices.size;
    }

    public int getNumVertices() {
        return this.vertices.size / this.stride;
    }

    public int getPrimitiveType() {
        return this.primitiveType;
    }

    public Matrix4 getVertexTransform(Matrix4 matrix4) {
        matrix4.set(this.positionTransform);
        return matrix4;
    }

    public void getVertices(float[] fArr, int i) {
        if (this.attributes != null) {
            if (i >= 0) {
                int length = fArr.length;
                FloatArray floatArray = this.vertices;
                int i2 = floatArray.size;
                if (i <= length - i2) {
                    System.arraycopy(floatArray.items, 0, fArr, i, i2);
                    return;
                }
            }
            throw new GdxRuntimeException((String) "Array too small or offset out of range");
        }
        throw new GdxRuntimeException((String) "Must be called in between #begin and #end");
    }

    public void index(short s) {
        this.indices.add(s);
    }

    public boolean isVertexTransformationEnabled() {
        return this.vertexTransformationEnabled;
    }

    public short lastIndex() {
        return (short) this.lastIndex;
    }

    public void line(short s, short s2) {
        if (this.primitiveType == 1) {
            index(s, s2);
            return;
        }
        throw new GdxRuntimeException((String) "Incorrect primitive type");
    }

    public MeshPart part(String str, int i) {
        return part(str, i, new MeshPart());
    }

    @Deprecated
    public void patch(VertexInfo vertexInfo, VertexInfo vertexInfo2, VertexInfo vertexInfo3, VertexInfo vertexInfo4, int i, int i2) {
        PatchShapeBuilder.build(this, vertexInfo, vertexInfo2, vertexInfo3, vertexInfo4, i, i2);
    }

    public void rect(short s, short s2, short s3, short s4) {
        int i = this.primitiveType;
        if (i == 4) {
            index(s, s2, s3, s3, s4, s);
        } else if (i == 1) {
            index(s, s2, s2, s3, s3, s4, s4, s);
        } else if (i == 0) {
            index(s, s2, s3, s4);
        } else {
            throw new GdxRuntimeException((String) "Incorrect primitive type");
        }
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color.set(f2, f3, f4, f5);
        this.hasColor = !this.color.equals(Color.WHITE);
    }

    public void setUVRange(float f2, float f3, float f4, float f5) {
        this.uOffset = f2;
        this.vOffset = f3;
        this.uScale = f4 - f2;
        this.vScale = f5 - f3;
        this.hasUVTransform = !MathUtils.isZero(f2) || !MathUtils.isZero(f3) || !MathUtils.isEqual(f4, 1.0f) || !MathUtils.isEqual(f5, 1.0f);
    }

    public void setVertexTransform(Matrix4 matrix4) {
        boolean z = matrix4 != null;
        this.vertexTransformationEnabled = z;
        if (z) {
            this.positionTransform.set(matrix4);
            Matrix3 matrix3 = this.normalTransform;
            matrix3.set(matrix4);
            matrix3.inv();
            matrix3.transpose();
            return;
        }
        this.positionTransform.idt();
        this.normalTransform.idt();
    }

    public void setVertexTransformationEnabled(boolean z) {
        this.vertexTransformationEnabled = z;
    }

    @Deprecated
    public void sphere(float f2, float f3, float f4, int i, int i2) {
        SphereShapeBuilder.build(this, f2, f3, f4, i, i2);
    }

    public void triangle(short s, short s2, short s3) {
        int i = this.primitiveType;
        if (i == 4 || i == 0) {
            index(s, s2, s3);
        } else if (i == 1) {
            index(s, s2, s2, s3, s3, s);
        } else {
            throw new GdxRuntimeException((String) "Incorrect primitive type");
        }
    }

    public short vertex(Vector3 vector3, Vector3 vector32, Color color2, Vector2 vector2) {
        if (this.vindex <= 65535) {
            float[] fArr = this.vertex;
            int i = this.posOffset;
            fArr[i] = vector3.x;
            if (this.posSize > 1) {
                fArr[i + 1] = vector3.y;
            }
            if (this.posSize > 2) {
                this.vertex[this.posOffset + 2] = vector3.z;
            }
            if (this.norOffset >= 0) {
                if (vector32 == null) {
                    Vector3 vector33 = this.tmpNormal;
                    vector33.set(vector3);
                    vector32 = vector33.nor();
                }
                float[] fArr2 = this.vertex;
                int i2 = this.norOffset;
                fArr2[i2] = vector32.x;
                fArr2[i2 + 1] = vector32.y;
                fArr2[i2 + 2] = vector32.z;
            }
            if (this.colOffset >= 0) {
                if (color2 == null) {
                    color2 = Color.WHITE;
                }
                float[] fArr3 = this.vertex;
                int i3 = this.colOffset;
                fArr3[i3] = color2.r;
                fArr3[i3 + 1] = color2.g;
                fArr3[i3 + 2] = color2.f3307b;
                if (this.colSize > 3) {
                    fArr3[i3 + 3] = color2.f3306a;
                }
            } else if (this.cpOffset > 0) {
                if (color2 == null) {
                    color2 = Color.WHITE;
                }
                this.vertex[this.cpOffset] = color2.toFloatBits();
            }
            if (vector2 != null) {
                int i4 = this.uvOffset;
                if (i4 >= 0) {
                    float[] fArr4 = this.vertex;
                    fArr4[i4] = vector2.x;
                    fArr4[i4 + 1] = vector2.y;
                }
            }
            addVertex(this.vertex, 0);
            return (short) this.lastIndex;
        }
        throw new GdxRuntimeException((String) "Too many vertices used");
    }

    public void addMesh(MeshPart meshPart) {
        if (meshPart.primitiveType == this.primitiveType) {
            addMesh(meshPart.mesh, meshPart.offset, meshPart.size);
            return;
        }
        throw new GdxRuntimeException((String) "Primitive type doesn't match");
    }

    public void begin(VertexAttributes vertexAttributes) {
        begin(vertexAttributes, -1);
    }

    @Deprecated
    public void box(Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, Vector3 vector35, Vector3 vector36, Vector3 vector37, Vector3 vector38) {
        BoxShapeBuilder.build((MeshPartBuilder) this, vector3, vector32, vector33, vector34, vector35, vector36, vector37, vector38);
    }

    @Deprecated
    public void circle(float f2, int i, Vector3 vector3, Vector3 vector32) {
        EllipseShapeBuilder.build(this, f2, i, vector3, vector32);
    }

    @Deprecated
    public void cone(float f2, float f3, float f4, int i, float f5, float f6) {
        ConeShapeBuilder.build(this, f2, f3, f4, i, f5, f6);
    }

    @Deprecated
    public void cylinder(float f2, float f3, float f4, int i, float f5, float f6) {
        CylinderShapeBuilder.build(this, f2, f3, f4, i, f5, f6);
    }

    @Deprecated
    public void ellipse(float f2, float f3, int i, Vector3 vector3, Vector3 vector32) {
        EllipseShapeBuilder.build(this, f2, f3, i, vector3, vector32);
    }

    public void index(short s, short s2) {
        ensureIndices(2);
        this.indices.add(s);
        this.indices.add(s2);
    }

    public MeshPart part(String str, int i, MeshPart meshPart) {
        if (this.attributes != null) {
            endpart();
            this.part = meshPart;
            meshPart.id = str;
            meshPart.primitiveType = i;
            this.primitiveType = i;
            this.parts.add(meshPart);
            setColor(null);
            setVertexTransform(null);
            setUVRange(null);
            return this.part;
        }
        throw new RuntimeException("Call begin() first");
    }

    @Deprecated
    public void patch(Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, Vector3 vector35, int i, int i2) {
        PatchShapeBuilder.build(this, vector3, vector32, vector33, vector34, vector35, i, i2);
    }

    @Deprecated
    public void sphere(Matrix4 matrix4, float f2, float f3, float f4, int i, int i2) {
        SphereShapeBuilder.build(this, matrix4, f2, f3, f4, i, i2);
    }

    public void begin(long j, int i) {
        begin(createAttributes(j), i);
    }

    @Deprecated
    public void box(Matrix4 matrix4) {
        BoxShapeBuilder.build((MeshPartBuilder) this, matrix4);
    }

    @Deprecated
    public void circle(float f2, int i, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        EllipseShapeBuilder.build((MeshPartBuilder) this, f2, i, vector3, vector32, vector33, vector34);
    }

    @Deprecated
    public void cylinder(float f2, float f3, float f4, int i, float f5, float f6, boolean z) {
        CylinderShapeBuilder.build(this, f2, f3, f4, i, f5, f6, z);
    }

    @Deprecated
    public void ellipse(float f2, float f3, int i, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        EllipseShapeBuilder.build((MeshPartBuilder) this, f2, f3, i, vector3, vector32, vector33, vector34);
    }

    @Deprecated
    public void ensureRectangles(int i) {
        ensureVertices(i * 4);
        ensureRectangleIndices(i);
    }

    @Deprecated
    public void ensureTriangles(int i) {
        ensureVertices(i * 3);
        ensureTriangleIndices(i);
    }

    @Deprecated
    public void patch(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, int i, int i2) {
        PatchShapeBuilder.build(this, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, i, i2);
    }

    public void setColor(Color color2) {
        Color color3 = this.color;
        boolean z = color2 != null;
        this.hasColor = z;
        if (!z) {
            color2 = Color.WHITE;
        }
        color3.set(color2);
    }

    @Deprecated
    public void sphere(float f2, float f3, float f4, int i, int i2, float f5, float f6, float f7, float f8) {
        SphereShapeBuilder.build(this, f2, f3, f4, i, i2, f5, f6, f7, f8);
    }

    public void begin(VertexAttributes vertexAttributes, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (this.attributes == null) {
            this.attributes = vertexAttributes;
            int i7 = 0;
            this.vertices.size = 0;
            this.indices.size = 0;
            this.parts.clear();
            this.vindex = 0;
            int i8 = -1;
            this.lastIndex = -1;
            this.istart = 0;
            this.part = null;
            int i9 = vertexAttributes.vertexSize / 4;
            this.stride = i9;
            float[] fArr = this.vertex;
            if (fArr == null || fArr.length < i9) {
                this.vertex = new float[this.stride];
            }
            VertexAttribute findByUsage = vertexAttributes.findByUsage(1);
            if (findByUsage != null) {
                this.posOffset = findByUsage.offset / 4;
                this.posSize = findByUsage.numComponents;
                VertexAttribute findByUsage2 = vertexAttributes.findByUsage(8);
                if (findByUsage2 == null) {
                    i2 = -1;
                } else {
                    i2 = findByUsage2.offset / 4;
                }
                this.norOffset = i2;
                VertexAttribute findByUsage3 = vertexAttributes.findByUsage(256);
                if (findByUsage3 == null) {
                    i3 = -1;
                } else {
                    i3 = findByUsage3.offset / 4;
                }
                this.biNorOffset = i3;
                VertexAttribute findByUsage4 = vertexAttributes.findByUsage(128);
                if (findByUsage4 == null) {
                    i4 = -1;
                } else {
                    i4 = findByUsage4.offset / 4;
                }
                this.tangentOffset = i4;
                VertexAttribute findByUsage5 = vertexAttributes.findByUsage(2);
                if (findByUsage5 == null) {
                    i5 = -1;
                } else {
                    i5 = findByUsage5.offset / 4;
                }
                this.colOffset = i5;
                if (findByUsage5 != null) {
                    i7 = findByUsage5.numComponents;
                }
                this.colSize = i7;
                VertexAttribute findByUsage6 = vertexAttributes.findByUsage(4);
                if (findByUsage6 == null) {
                    i6 = -1;
                } else {
                    i6 = findByUsage6.offset / 4;
                }
                this.cpOffset = i6;
                VertexAttribute findByUsage7 = vertexAttributes.findByUsage(16);
                if (findByUsage7 != null) {
                    i8 = findByUsage7.offset / 4;
                }
                this.uvOffset = i8;
                setColor(null);
                setVertexTransform(null);
                setUVRange(null);
                this.primitiveType = i;
                this.bounds.inf();
                return;
            }
            throw new GdxRuntimeException((String) "Cannot build mesh without position attribute");
        }
        throw new RuntimeException("Call end() first");
    }

    @Deprecated
    public void box(float f2, float f3, float f4) {
        BoxShapeBuilder.build(this, f2, f3, f4);
    }

    @Deprecated
    public void circle(float f2, int i, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        EllipseShapeBuilder.build(this, f2, i, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14);
    }

    @Deprecated
    public void ellipse(float f2, float f3, int i, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        EllipseShapeBuilder.build(this, f2, f3, i, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15);
    }

    public void line(VertexInfo vertexInfo, VertexInfo vertexInfo2) {
        ensureVertices(2);
        line(vertex(vertexInfo), vertex(vertexInfo2));
    }

    @Deprecated
    public void sphere(Matrix4 matrix4, float f2, float f3, float f4, int i, int i2, float f5, float f6, float f7, float f8) {
        SphereShapeBuilder.build(this, matrix4, f2, f3, f4, i, i2, f5, f6, f7, f8);
    }

    public void addMesh(Mesh mesh, int i, int i2) {
        if (!this.attributes.equals(mesh.getVertexAttributes())) {
            throw new GdxRuntimeException((String) "Vertex attributes do not match");
        } else if (i2 > 0) {
            int numVertices = mesh.getNumVertices() * this.stride;
            FloatArray floatArray = tmpVertices;
            floatArray.size = 0;
            floatArray.ensureCapacity(numVertices);
            FloatArray floatArray2 = tmpVertices;
            floatArray2.size = numVertices;
            mesh.getVertices(floatArray2.items);
            ShortArray shortArray = tmpIndices;
            shortArray.size = 0;
            shortArray.ensureCapacity(i2);
            ShortArray shortArray2 = tmpIndices;
            shortArray2.size = i2;
            mesh.getIndices(i, i2, shortArray2.items, 0);
            addMesh(tmpVertices.items, tmpIndices.items, 0, i2);
        }
    }

    @Deprecated
    public void box(float f2, float f3, float f4, float f5, float f6, float f7) {
        BoxShapeBuilder.build(this, f2, f3, f4, f5, f6, f7);
    }

    @Deprecated
    public void circle(float f2, int i, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        EllipseShapeBuilder.build(this, f2, i, f3, f4, f5, f6, f7, f8, f9, f10);
    }

    @Deprecated
    public void ellipse(float f2, float f3, int i, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        EllipseShapeBuilder.build((MeshPartBuilder) this, f2, f3, i, f4, f5, f6, f7, f8, f9, f10, f11);
    }

    public void index(short s, short s2, short s3) {
        ensureIndices(3);
        this.indices.add(s);
        this.indices.add(s2);
        this.indices.add(s3);
    }

    public void triangle(VertexInfo vertexInfo, VertexInfo vertexInfo2, VertexInfo vertexInfo3) {
        ensureVertices(3);
        triangle(vertex(vertexInfo), vertex(vertexInfo2), vertex(vertexInfo3));
    }

    @Deprecated
    public void circle(float f2, int i, Vector3 vector3, Vector3 vector32, float f3, float f4) {
        EllipseShapeBuilder.build((MeshPartBuilder) this, f2, i, vector3, vector32, f3, f4);
    }

    @Deprecated
    public void ellipse(float f2, float f3, int i, Vector3 vector3, Vector3 vector32, float f4, float f5) {
        EllipseShapeBuilder.build((MeshPartBuilder) this, f2, f3, i, vector3, vector32, f4, f5);
    }

    public short[] getIndices() {
        return this.indices.items;
    }

    public float[] getVertices() {
        return this.vertices.items;
    }

    public void line(Vector3 vector3, Vector3 vector32) {
        line(this.vertTmp1.set(vector3, null, null, null), this.vertTmp2.set(vector32, null, null, null));
    }

    public void rect(VertexInfo vertexInfo, VertexInfo vertexInfo2, VertexInfo vertexInfo3, VertexInfo vertexInfo4) {
        ensureVertices(4);
        rect(vertex(vertexInfo), vertex(vertexInfo2), vertex(vertexInfo3), vertex(vertexInfo4));
    }

    public void setUVRange(TextureRegion textureRegion) {
        if (textureRegion == null) {
            this.hasUVTransform = false;
            this.vOffset = 0.0f;
            this.uOffset = 0.0f;
            this.vScale = 1.0f;
            this.uScale = 1.0f;
            return;
        }
        this.hasUVTransform = true;
        setUVRange(textureRegion.getU(), textureRegion.getV(), textureRegion.getU2(), textureRegion.getV2());
    }

    @Deprecated
    public void circle(float f2, int i, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, float f3, float f4) {
        Vector3 vector35 = vector3;
        Vector3 vector36 = vector32;
        Vector3 vector37 = vector33;
        Vector3 vector38 = vector34;
        circle(f2, i, vector35.x, vector35.y, vector35.z, vector36.x, vector36.y, vector36.z, vector37.x, vector37.y, vector37.z, vector38.x, vector38.y, vector38.z, f3, f4);
    }

    @Deprecated
    public void ellipse(float f2, float f3, int i, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, float f4, float f5) {
        EllipseShapeBuilder.build((MeshPartBuilder) this, f2, f3, i, vector3, vector32, vector33, vector34, f4, f5);
    }

    public void line(float f2, float f3, float f4, float f5, float f6, float f7) {
        line(this.vertTmp1.set(null, null, null, null).setPos(f2, f3, f4), this.vertTmp2.set(null, null, null, null).setPos(f5, f6, f7));
    }

    public void triangle(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        triangle(this.vertTmp1.set(vector3, null, null, null), this.vertTmp2.set(vector32, null, null, null), this.vertTmp3.set(vector33, null, null, null));
    }

    @Deprecated
    public void circle(float f2, int i, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        EllipseShapeBuilder.build(this, f2, i, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16);
    }

    @Deprecated
    public void ellipse(float f2, float f3, int i, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        EllipseShapeBuilder.build(this, f2, f3, i, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17);
    }

    public void line(Vector3 vector3, Color color2, Vector3 vector32, Color color3) {
        line(this.vertTmp1.set(vector3, null, color2, null), this.vertTmp2.set(vector32, null, color3, null));
    }

    public void rect(Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, Vector3 vector35) {
        rect(this.vertTmp1.set(vector3, vector35, null, null).setUV(0.0f, 1.0f), this.vertTmp2.set(vector32, vector35, null, null).setUV(1.0f, 1.0f), this.vertTmp3.set(vector33, vector35, null, null).setUV(1.0f, 0.0f), this.vertTmp4.set(vector34, vector35, null, null).setUV(0.0f, 0.0f));
    }

    public void triangle(Vector3 vector3, Color color2, Vector3 vector32, Color color3, Vector3 vector33, Color color4) {
        triangle(this.vertTmp1.set(vector3, null, color2, null), this.vertTmp2.set(vector32, null, color3, null), this.vertTmp3.set(vector33, null, color4, null));
    }

    @Deprecated
    public void ellipse(float f2, float f3, float f4, float f5, int i, Vector3 vector3, Vector3 vector32) {
        EllipseShapeBuilder.build((MeshPartBuilder) this, f2, f3, f4, f5, i, vector3, vector32);
    }

    public void index(short s, short s2, short s3, short s4) {
        ensureIndices(4);
        this.indices.add(s);
        this.indices.add(s2);
        this.indices.add(s3);
        this.indices.add(s4);
    }

    @Deprecated
    public void ellipse(float f2, float f3, float f4, float f5, int i, float f6, float f7, float f8, float f9, float f10, float f11) {
        EllipseShapeBuilder.build((MeshPartBuilder) this, f2, f3, f4, f5, i, f6, f7, f8, f9, f10, f11);
    }

    @Deprecated
    public void ellipse(float f2, float f3, float f4, float f5, int i, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        EllipseShapeBuilder.build(this, f2, f3, f4, f5, i, f6, f7, f8, f9, f10, f11, f12, f13);
    }

    public void rect(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        float f17 = f14;
        float f18 = f15;
        float f19 = f16;
        float f20 = f2;
        float f21 = f3;
        rect(this.vertTmp1.set(null, null, null, null).setPos(f2, f3, f4).setNor(f17, f18, f19).setUV(0.0f, 1.0f), this.vertTmp2.set(null, null, null, null).setPos(f5, f6, f7).setNor(f17, f18, f19).setUV(1.0f, 1.0f), this.vertTmp3.set(null, null, null, null).setPos(f8, f9, f10).setNor(f17, f18, f19).setUV(1.0f, 0.0f), this.vertTmp4.set(null, null, null, null).setPos(f11, f12, f13).setNor(f17, f18, f19).setUV(0.0f, 0.0f));
    }

    @Deprecated
    public void ellipse(float f2, float f3, float f4, float f5, int i, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        EllipseShapeBuilder.build(this, f2, f3, f4, f5, i, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17, f18, f19);
    }

    public void index(short s, short s2, short s3, short s4, short s5, short s6) {
        ensureIndices(6);
        this.indices.add(s);
        this.indices.add(s2);
        this.indices.add(s3);
        this.indices.add(s4);
        this.indices.add(s5);
        this.indices.add(s6);
    }

    public void addMesh(float[] fArr, short[] sArr, int i, int i2) {
        IntIntMap intIntMap = indicesMap;
        if (intIntMap == null) {
            indicesMap = new IntIntMap(i2, 0.8f);
        } else {
            if (intIntMap.size != 0) {
                Arrays.fill(intIntMap.keyTable, 0);
                intIntMap.size = 0;
                intIntMap.hasZeroValue = false;
            }
            IntIntMap intIntMap2 = indicesMap;
            int tableSize = ObjectSet.tableSize(intIntMap2.size + i2, intIntMap2.loadFactor);
            if (intIntMap2.keyTable.length < tableSize) {
                intIntMap2.resize(tableSize);
            }
        }
        ensureIndices(i2);
        int length = fArr.length / this.stride;
        if (length >= i2) {
            length = i2;
        }
        ensureVertices(length);
        for (int i3 = 0; i3 < i2; i3++) {
            short s = sArr[i + i3] & 65535;
            int i4 = indicesMap.get(s, -1);
            if (i4 < 0) {
                addVertex(fArr, this.stride * s);
                IntIntMap intIntMap3 = indicesMap;
                int i5 = this.lastIndex;
                intIntMap3.put(s, i5);
                i4 = i5;
            }
            index((short) i4);
        }
    }

    public Mesh end() {
        return end(new Mesh(true, this.vertices.size / this.stride, this.indices.size, this.attributes));
    }

    public void index(short s, short s2, short s3, short s4, short s5, short s6, short s7, short s8) {
        ensureIndices(8);
        this.indices.add(s);
        this.indices.add(s2);
        this.indices.add(s3);
        this.indices.add(s4);
        this.indices.add(s5);
        this.indices.add(s6);
        this.indices.add(s7);
        this.indices.add(s8);
    }

    public short vertex(float... fArr) {
        int length = fArr.length - this.stride;
        int i = 0;
        while (i <= length) {
            addVertex(fArr, i);
            i += this.stride;
        }
        return (short) this.lastIndex;
    }

    public short vertex(VertexInfo vertexInfo) {
        Vector2 vector2 = null;
        Vector3 vector3 = vertexInfo.hasPosition ? vertexInfo.position : null;
        Vector3 vector32 = vertexInfo.hasNormal ? vertexInfo.normal : null;
        Color color2 = vertexInfo.hasColor ? vertexInfo.color : null;
        if (vertexInfo.hasUV) {
            vector2 = vertexInfo.uv;
        }
        return vertex(vector3, vector32, color2, vector2);
    }

    public void addMesh(float[] fArr, short[] sArr) {
        int i = this.lastIndex + 1;
        ensureVertices(fArr.length / this.stride);
        int i2 = 0;
        while (i2 < fArr.length) {
            addVertex(fArr, i2);
            i2 += this.stride;
        }
        ensureIndices(sArr.length);
        for (short s : sArr) {
            index((short) (s + i));
        }
    }
}
