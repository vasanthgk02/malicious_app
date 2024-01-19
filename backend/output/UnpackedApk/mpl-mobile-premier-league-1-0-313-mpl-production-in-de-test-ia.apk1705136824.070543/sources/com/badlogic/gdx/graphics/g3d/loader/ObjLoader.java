package com.badlogic.gdx.graphics.g3d.loader;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.assets.loaders.ModelLoader.ModelParameters;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMesh;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNode;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodePart;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.FloatArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ObjLoader extends ModelLoader<ObjLoaderParameters> {
    public static boolean logWarning;
    public final Array<Group> groups;
    public final FloatArray norms;
    public final FloatArray uvs;
    public final FloatArray verts;

    public class Group {
        public Array<Integer> faces = new Array<>(true, 200);
        public boolean hasNorms;
        public boolean hasUVs;
        public Material mat = new Material((String) "");
        public String materialName = "default";
        public final String name;
        public int numFaces = 0;

        public Group(String str) {
            this.name = str;
        }
    }

    public static class ObjLoaderParameters extends ModelParameters {
        public boolean flipV;

        public ObjLoaderParameters() {
        }

        public ObjLoaderParameters(boolean z) {
            this.flipV = z;
        }
    }

    public ObjLoader() {
        this(null);
    }

    private int getIndex(String str, int i) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int parseInt = Integer.parseInt(str);
        return parseInt < 0 ? i + parseInt : parseInt - 1;
    }

    private Group setActiveGroup(String str) {
        ArrayIterator it = this.groups.iterator();
        while (it.hasNext()) {
            Group group = (Group) it.next();
            if (group.name.equals(str)) {
                return group;
            }
        }
        Group group2 = new Group(str);
        this.groups.add(group2);
        return group2;
    }

    public Model loadModel(FileHandle fileHandle, boolean z) {
        return loadModel(fileHandle, new ObjLoaderParameters(z));
    }

    public ObjLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
        this.verts = new FloatArray(300);
        this.norms = new FloatArray(300);
        this.uvs = new FloatArray(200);
        this.groups = new Array<>(true, 10);
    }

    public ModelData loadModelData(FileHandle fileHandle, ObjLoaderParameters objLoaderParameters) {
        return loadModelData(fileHandle, objLoaderParameters != null && objLoaderParameters.flipV);
    }

    public ModelData loadModelData(FileHandle fileHandle, boolean z) {
        int i;
        int i2;
        Array<Integer> array;
        if (logWarning) {
            k.app.error("ObjLoader", "Wavefront (OBJ) is not fully supported, consult the documentation for more information");
        }
        MtlLoader mtlLoader = new MtlLoader();
        Group group = new Group("default");
        this.groups.add(group);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileHandle.read()), 4096);
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.split("\\s+");
                if (split.length < 1) {
                    break;
                } else if (split[0].length() != 0) {
                    char charAt = split[0].toLowerCase().charAt(0);
                    if (charAt != '#') {
                        if (charAt == 'v') {
                            if (split[0].length() == 1) {
                                this.verts.add(Float.parseFloat(split[1]));
                                this.verts.add(Float.parseFloat(split[2]));
                                this.verts.add(Float.parseFloat(split[3]));
                            } else if (split[0].charAt(1) == 'n') {
                                this.norms.add(Float.parseFloat(split[1]));
                                this.norms.add(Float.parseFloat(split[2]));
                                this.norms.add(Float.parseFloat(split[3]));
                            } else if (split[0].charAt(1) == 't') {
                                this.uvs.add(Float.parseFloat(split[1]));
                                this.uvs.add(z ? 1.0f - Float.parseFloat(split[2]) : Float.parseFloat(split[2]));
                            }
                        } else if (charAt == 'f') {
                            Array<Integer> array2 = group.faces;
                            int i3 = 1;
                            while (i3 < split.length - 2) {
                                String[] split2 = split[1].split("/");
                                array2.add(Integer.valueOf(getIndex(split2[0], this.verts.size)));
                                if (split2.length > 2) {
                                    if (i3 == 1) {
                                        group.hasNorms = true;
                                    }
                                    array2.add(Integer.valueOf(getIndex(split2[2], this.norms.size)));
                                }
                                if (split2.length > 1 && split2[1].length() > 0) {
                                    if (i3 == 1) {
                                        group.hasUVs = true;
                                    }
                                    array2.add(Integer.valueOf(getIndex(split2[1], this.uvs.size)));
                                }
                                int i4 = i3 + 1;
                                String[] split3 = split[i4].split("/");
                                array2.add(Integer.valueOf(getIndex(split3[0], this.verts.size)));
                                if (split3.length > 2) {
                                    array2.add(Integer.valueOf(getIndex(split3[2], this.norms.size)));
                                }
                                if (split3.length > 1 && split3[1].length() > 0) {
                                    array2.add(Integer.valueOf(getIndex(split3[1], this.uvs.size)));
                                }
                                int i5 = i4 + 1;
                                String[] split4 = split[i5].split("/");
                                array2.add(Integer.valueOf(getIndex(split4[0], this.verts.size)));
                                if (split4.length > 2) {
                                    array2.add(Integer.valueOf(getIndex(split4[2], this.norms.size)));
                                }
                                if (split4.length > 1 && split4[1].length() > 0) {
                                    array2.add(Integer.valueOf(getIndex(split4[1], this.uvs.size)));
                                }
                                group.numFaces++;
                                i3 = i5 - 1;
                            }
                        } else {
                            if (charAt != 'o') {
                                if (charAt != 'g') {
                                    if (split[0].equals("mtllib")) {
                                        mtlLoader.load(fileHandle.parent().child(split[1]));
                                    } else if (split[0].equals("usemtl")) {
                                        if (split.length == 1) {
                                            group.materialName = "default";
                                        } else {
                                            group.materialName = split[1].replace('.', '_');
                                        }
                                    }
                                }
                            }
                            if (split.length > 1) {
                                group = setActiveGroup(split[1]);
                            } else {
                                group = setActiveGroup("default");
                            }
                        }
                    }
                }
            } catch (IOException unused) {
                return null;
            }
        }
        bufferedReader.close();
        int i6 = 0;
        while (true) {
            Array<Group> array3 = this.groups;
            i = array3.size;
            if (i6 >= i) {
                break;
            }
            if (((Group) array3.get(i6)).numFaces < 1) {
                this.groups.removeIndex(i6);
                i6--;
            }
            i6++;
        }
        if (i < 1) {
            return null;
        }
        ModelData modelData = new ModelData();
        int i7 = 0;
        int i8 = 0;
        while (i7 < i) {
            Group group2 = (Group) this.groups.get(i7);
            Array<Integer> array4 = group2.faces;
            int i9 = array4.size;
            int i10 = group2.numFaces;
            boolean z2 = group2.hasNorms;
            boolean z3 = group2.hasUVs;
            int i11 = i10 * 3;
            float[] fArr = new float[(((z2 ? 3 : 0) + 3 + (z3 ? 2 : 0)) * i11)];
            int i12 = 0;
            int i13 = 0;
            while (i12 < i9) {
                int i14 = i;
                int i15 = i12 + 1;
                int intValue = ((Integer) array4.get(i12)).intValue() * 3;
                int i16 = i13 + 1;
                int i17 = i9;
                int i18 = i7;
                int i19 = intValue + 1;
                fArr[i13] = this.verts.get(intValue);
                int i20 = i16 + 1;
                int i21 = i19 + 1;
                fArr[i16] = this.verts.get(i19);
                int i22 = i20 + 1;
                fArr[i20] = this.verts.get(i21);
                if (z2) {
                    int i23 = i15 + 1;
                    int intValue2 = ((Integer) array4.get(i15)).intValue() * 3;
                    int i24 = i22 + 1;
                    int i25 = i23;
                    int i26 = intValue2 + 1;
                    fArr[i22] = this.norms.get(intValue2);
                    int i27 = i24 + 1;
                    fArr[i24] = this.norms.get(i26);
                    fArr[i27] = this.norms.get(i26 + 1);
                    i22 = i27 + 1;
                    i15 = i25;
                }
                if (z3) {
                    int i28 = i15 + 1;
                    int intValue3 = ((Integer) array4.get(i15)).intValue() * 2;
                    int i29 = i22 + 1;
                    array = array4;
                    fArr[i22] = this.uvs.get(intValue3);
                    fArr[i29] = this.uvs.get(intValue3 + 1);
                    i13 = i29 + 1;
                    i12 = i28;
                } else {
                    array = array4;
                    i13 = i22;
                    i12 = i15;
                }
                i = i14;
                i9 = i17;
                array4 = array;
                i7 = i18;
            }
            int i30 = i7;
            int i31 = i;
            if (i11 >= 32767) {
                i11 = 0;
            }
            short[] sArr = new short[i11];
            if (i11 > 0) {
                for (int i32 = 0; i32 < i11; i32++) {
                    sArr[i32] = (short) i32;
                }
            }
            Array array5 = new Array();
            array5.add(new VertexAttribute(1, 3, ShaderProgram.POSITION_ATTRIBUTE));
            if (z2) {
                array5.add(new VertexAttribute(8, 3, ShaderProgram.NORMAL_ATTRIBUTE));
            }
            if (z3) {
                array5.add(new VertexAttribute(16, 2, "a_texCoord0"));
            }
            i8++;
            String num = Integer.toString(i8);
            String outline50 = "default".equals(group2.name) ? GeneratedOutlineSupport.outline50("node", num) : group2.name;
            String outline502 = "default".equals(group2.name) ? GeneratedOutlineSupport.outline50("mesh", num) : group2.name;
            String outline503 = "default".equals(group2.name) ? GeneratedOutlineSupport.outline50("part", num) : group2.name;
            ModelNode modelNode = new ModelNode();
            modelNode.id = outline50;
            modelNode.meshId = outline502;
            modelNode.scale = new Vector3(1.0f, 1.0f, 1.0f);
            modelNode.translation = new Vector3();
            modelNode.rotation = new Quaternion();
            ModelNodePart modelNodePart = new ModelNodePart();
            modelNodePart.meshPartId = outline503;
            modelNodePart.materialId = group2.materialName;
            modelNode.parts = new ModelNodePart[]{modelNodePart};
            ModelMeshPart modelMeshPart = new ModelMeshPart();
            modelMeshPart.id = outline503;
            modelMeshPart.indices = sArr;
            modelMeshPart.primitiveType = 4;
            ModelMesh modelMesh = new ModelMesh();
            modelMesh.id = outline502;
            modelMesh.attributes = (VertexAttribute[]) array5.toArray(VertexAttribute.class);
            modelMesh.vertices = fArr;
            modelMesh.parts = new ModelMeshPart[]{modelMeshPart};
            modelData.nodes.add(modelNode);
            modelData.meshes.add(modelMesh);
            modelData.materials.add(mtlLoader.getMaterial(group2.materialName));
            i7 = i30 + 1;
            i = i31;
        }
        FloatArray floatArray = this.verts;
        if (floatArray.size > 0) {
            i2 = 0;
            floatArray.size = 0;
        } else {
            i2 = 0;
        }
        FloatArray floatArray2 = this.norms;
        if (floatArray2.size > 0) {
            floatArray2.size = i2;
        }
        FloatArray floatArray3 = this.uvs;
        if (floatArray3.size > 0) {
            floatArray3.size = i2;
        }
        Array<Group> array6 = this.groups;
        if (array6.size > 0) {
            array6.clear();
        }
        return modelData;
    }
}
