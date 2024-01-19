package com.badlogic.gdx.graphics.g3d.loader;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.assets.loaders.ModelLoader.ModelParameters;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.model.data.ModelAnimation;
import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNode;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodeKeyframe;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodePart;
import com.badlogic.gdx.graphics.g3d.model.data.ModelTexture;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.BaseJsonReader;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import io.hansel.core.criteria.HSLCriteriaBuilder;

public class G3dModelLoader extends ModelLoader<ModelParameters> {
    public static final short VERSION_HI = 0;
    public static final short VERSION_LO = 1;
    public final BaseJsonReader reader;
    public final Quaternion tempQ;

    public G3dModelLoader(BaseJsonReader baseJsonReader) {
        this(baseJsonReader, null);
    }

    public ModelData loadModelData(FileHandle fileHandle, ModelParameters modelParameters) {
        return parseModel(fileHandle);
    }

    public void parseAnimations(ModelData modelData, JsonValue jsonValue) {
        ModelData modelData2 = modelData;
        JsonValue jsonValue2 = jsonValue.get("animations");
        if (jsonValue2 != null) {
            modelData2.animations.ensureCapacity(jsonValue2.size);
            JsonValue jsonValue3 = jsonValue2.child;
            while (jsonValue3 != null) {
                JsonValue jsonValue4 = jsonValue3.get("bones");
                if (jsonValue4 != null) {
                    ModelAnimation modelAnimation = new ModelAnimation();
                    modelData2.animations.add(modelAnimation);
                    modelAnimation.nodeAnimations.ensureCapacity(jsonValue4.size);
                    modelAnimation.id = jsonValue3.getString("id");
                    JsonValue jsonValue5 = jsonValue4.child;
                    while (jsonValue5 != null) {
                        ModelNodeAnimation modelNodeAnimation = new ModelNodeAnimation();
                        modelAnimation.nodeAnimations.add(modelNodeAnimation);
                        modelNodeAnimation.nodeId = jsonValue5.getString("boneId");
                        JsonValue jsonValue6 = jsonValue5.get("keyframes");
                        float f2 = 1000.0f;
                        float f3 = 0.0f;
                        int i = 2;
                        int i2 = 1;
                        int i3 = 0;
                        int i4 = 3;
                        if (jsonValue6 == null || !jsonValue6.isArray()) {
                            JsonValue jsonValue7 = jsonValue5.get("translation");
                            if (jsonValue7 != null && jsonValue7.isArray()) {
                                Array<ModelNodeKeyframe<Vector3>> array = new Array<>();
                                modelNodeAnimation.translation = array;
                                array.ensureCapacity(jsonValue7.size);
                                for (JsonValue jsonValue8 = jsonValue7.child; jsonValue8 != null; jsonValue8 = jsonValue8.next) {
                                    ModelNodeKeyframe modelNodeKeyframe = new ModelNodeKeyframe();
                                    modelNodeAnimation.translation.add(modelNodeKeyframe);
                                    modelNodeKeyframe.keytime = jsonValue8.getFloat("keytime", 0.0f) / 1000.0f;
                                    JsonValue jsonValue9 = jsonValue8.get(HSLCriteriaBuilder.VALUE);
                                    if (jsonValue9 != null && jsonValue9.size >= 3) {
                                        modelNodeKeyframe.value = new Vector3(jsonValue9.getFloat(0), jsonValue9.getFloat(1), jsonValue9.getFloat(2));
                                    }
                                }
                            }
                            JsonValue jsonValue10 = jsonValue5.get("rotation");
                            if (jsonValue10 != null && jsonValue10.isArray()) {
                                Array<ModelNodeKeyframe<Quaternion>> array2 = new Array<>();
                                modelNodeAnimation.rotation = array2;
                                array2.ensureCapacity(jsonValue10.size);
                                for (JsonValue jsonValue11 = jsonValue10.child; jsonValue11 != null; jsonValue11 = jsonValue11.next) {
                                    ModelNodeKeyframe modelNodeKeyframe2 = new ModelNodeKeyframe();
                                    modelNodeAnimation.rotation.add(modelNodeKeyframe2);
                                    modelNodeKeyframe2.keytime = jsonValue11.getFloat("keytime", 0.0f) / 1000.0f;
                                    JsonValue jsonValue12 = jsonValue11.get(HSLCriteriaBuilder.VALUE);
                                    if (jsonValue12 != null) {
                                        if (jsonValue12.size >= 4) {
                                            modelNodeKeyframe2.value = new Quaternion(jsonValue12.getFloat(0), jsonValue12.getFloat(1), jsonValue12.getFloat(2), jsonValue12.getFloat(3));
                                        }
                                    }
                                }
                            }
                            JsonValue jsonValue13 = jsonValue5.get("scaling");
                            if (jsonValue13 != null && jsonValue13.isArray()) {
                                Array<ModelNodeKeyframe<Vector3>> array3 = new Array<>();
                                modelNodeAnimation.scaling = array3;
                                array3.ensureCapacity(jsonValue13.size);
                                for (JsonValue jsonValue14 = jsonValue13.child; jsonValue14 != null; jsonValue14 = jsonValue14.next) {
                                    ModelNodeKeyframe modelNodeKeyframe3 = new ModelNodeKeyframe();
                                    modelNodeAnimation.scaling.add(modelNodeKeyframe3);
                                    modelNodeKeyframe3.keytime = jsonValue14.getFloat("keytime", 0.0f) / 1000.0f;
                                    JsonValue jsonValue15 = jsonValue14.get(HSLCriteriaBuilder.VALUE);
                                    if (jsonValue15 != null) {
                                        if (jsonValue15.size >= 3) {
                                            modelNodeKeyframe3.value = new Vector3(jsonValue15.getFloat(0), jsonValue15.getFloat(1), jsonValue15.getFloat(2));
                                        }
                                    }
                                }
                            }
                        } else {
                            JsonValue jsonValue16 = jsonValue6.child;
                            while (jsonValue16 != null) {
                                float f4 = jsonValue16.getFloat("keytime", f3) / f2;
                                JsonValue jsonValue17 = jsonValue16.get("translation");
                                if (jsonValue17 != null && jsonValue17.size == i4) {
                                    if (modelNodeAnimation.translation == null) {
                                        modelNodeAnimation.translation = new Array<>();
                                    }
                                    ModelNodeKeyframe modelNodeKeyframe4 = new ModelNodeKeyframe();
                                    modelNodeKeyframe4.keytime = f4;
                                    modelNodeKeyframe4.value = new Vector3(jsonValue17.getFloat(i3), jsonValue17.getFloat(i2), jsonValue17.getFloat(i));
                                    modelNodeAnimation.translation.add(modelNodeKeyframe4);
                                }
                                JsonValue jsonValue18 = jsonValue16.get("rotation");
                                if (jsonValue18 != null && jsonValue18.size == 4) {
                                    if (modelNodeAnimation.rotation == null) {
                                        modelNodeAnimation.rotation = new Array<>();
                                    }
                                    ModelNodeKeyframe modelNodeKeyframe5 = new ModelNodeKeyframe();
                                    modelNodeKeyframe5.keytime = f4;
                                    modelNodeKeyframe5.value = new Quaternion(jsonValue18.getFloat(0), jsonValue18.getFloat(i2), jsonValue18.getFloat(i), jsonValue18.getFloat(3));
                                    modelNodeAnimation.rotation.add(modelNodeKeyframe5);
                                }
                                JsonValue jsonValue19 = jsonValue16.get("scale");
                                if (jsonValue19 != null && jsonValue19.size == 3) {
                                    if (modelNodeAnimation.scaling == null) {
                                        modelNodeAnimation.scaling = new Array<>();
                                    }
                                    ModelNodeKeyframe modelNodeKeyframe6 = new ModelNodeKeyframe();
                                    modelNodeKeyframe6.keytime = f4;
                                    modelNodeKeyframe6.value = new Vector3(jsonValue19.getFloat(0), jsonValue19.getFloat(1), jsonValue19.getFloat(2));
                                    modelNodeAnimation.scaling.add(modelNodeKeyframe6);
                                }
                                jsonValue16 = jsonValue16.next;
                                ModelData modelData3 = modelData;
                                f2 = 1000.0f;
                                f3 = 0.0f;
                                i = 2;
                                i2 = 1;
                                i3 = 0;
                                i4 = 3;
                            }
                        }
                        jsonValue5 = jsonValue5.next;
                        ModelData modelData4 = modelData;
                    }
                }
                jsonValue3 = jsonValue3.next;
                modelData2 = modelData;
            }
        }
    }

    public VertexAttribute[] parseAttributes(JsonValue jsonValue) {
        Array array = new Array();
        int i = 0;
        int i2 = 0;
        for (JsonValue jsonValue2 = jsonValue.child; jsonValue2 != null; jsonValue2 = jsonValue2.next) {
            String asString = jsonValue2.asString();
            if (asString.equals("POSITION")) {
                array.add(VertexAttribute.Position());
            } else if (asString.equals("NORMAL")) {
                array.add(VertexAttribute.Normal());
            } else if (asString.equals("COLOR")) {
                array.add(VertexAttribute.ColorUnpacked());
            } else if (asString.equals("COLORPACKED")) {
                array.add(VertexAttribute.ColorPacked());
            } else if (asString.equals("TANGENT")) {
                array.add(VertexAttribute.Tangent());
            } else if (asString.equals("BINORMAL")) {
                array.add(VertexAttribute.Binormal());
            } else if (asString.startsWith("TEXCOORD")) {
                array.add(VertexAttribute.TexCoords(i));
                i++;
            } else if (asString.startsWith("BLENDWEIGHT")) {
                array.add(VertexAttribute.BoneWeight(i2));
                i2++;
            } else {
                throw new GdxRuntimeException(GeneratedOutlineSupport.outline52("Unknown vertex attribute '", asString, "', should be one of position, normal, uv, tangent or binormal"));
            }
        }
        return (VertexAttribute[]) array.toArray(VertexAttribute.class);
    }

    public Color parseColor(JsonValue jsonValue) {
        if (jsonValue.size >= 3) {
            return new Color(jsonValue.getFloat(0), jsonValue.getFloat(1), jsonValue.getFloat(2), 1.0f);
        }
        throw new GdxRuntimeException((String) "Expected Color values <> than three.");
    }

    public void parseMaterials(ModelData modelData, JsonValue jsonValue, String str) {
        JsonValue jsonValue2 = jsonValue.get("materials");
        if (jsonValue2 != null) {
            modelData.materials.ensureCapacity(jsonValue2.size);
            JsonValue jsonValue3 = jsonValue2.child;
            while (jsonValue3 != null) {
                ModelMaterial modelMaterial = new ModelMaterial();
                String string = jsonValue3.getString("id", null);
                if (string != null) {
                    modelMaterial.id = string;
                    JsonValue jsonValue4 = jsonValue3.get("diffuse");
                    if (jsonValue4 != null) {
                        modelMaterial.diffuse = parseColor(jsonValue4);
                    }
                    JsonValue jsonValue5 = jsonValue3.get("ambient");
                    if (jsonValue5 != null) {
                        modelMaterial.ambient = parseColor(jsonValue5);
                    }
                    JsonValue jsonValue6 = jsonValue3.get("emissive");
                    if (jsonValue6 != null) {
                        modelMaterial.emissive = parseColor(jsonValue6);
                    }
                    JsonValue jsonValue7 = jsonValue3.get("specular");
                    if (jsonValue7 != null) {
                        modelMaterial.specular = parseColor(jsonValue7);
                    }
                    JsonValue jsonValue8 = jsonValue3.get("reflection");
                    if (jsonValue8 != null) {
                        modelMaterial.reflection = parseColor(jsonValue8);
                    }
                    modelMaterial.shininess = jsonValue3.getFloat(FloatAttribute.ShininessAlias, 0.0f);
                    modelMaterial.opacity = jsonValue3.getFloat("opacity", 1.0f);
                    JsonValue jsonValue9 = jsonValue3.get("textures");
                    if (jsonValue9 != null) {
                        JsonValue jsonValue10 = jsonValue9.child;
                        while (jsonValue10 != null) {
                            ModelTexture modelTexture = new ModelTexture();
                            String string2 = jsonValue10.getString("id", null);
                            if (string2 != null) {
                                modelTexture.id = string2;
                                String string3 = jsonValue10.getString("filename", null);
                                if (string3 != null) {
                                    StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
                                    String str2 = "/";
                                    if (str.length() == 0 || str.endsWith(str2)) {
                                        str2 = "";
                                    }
                                    modelTexture.fileName = GeneratedOutlineSupport.outline62(outline73, str2, string3);
                                    modelTexture.uvTranslation = readVector2(jsonValue10.get("uvTranslation"), 0.0f, 0.0f);
                                    modelTexture.uvScaling = readVector2(jsonValue10.get("uvScaling"), 1.0f, 1.0f);
                                    String string4 = jsonValue10.getString("type", null);
                                    if (string4 != null) {
                                        modelTexture.usage = parseTextureUsage(string4);
                                        if (modelMaterial.textures == null) {
                                            modelMaterial.textures = new Array<>();
                                        }
                                        modelMaterial.textures.add(modelTexture);
                                        jsonValue10 = jsonValue10.next;
                                    } else {
                                        throw new GdxRuntimeException((String) "Texture needs type.");
                                    }
                                } else {
                                    throw new GdxRuntimeException((String) "Texture needs filename.");
                                }
                            } else {
                                throw new GdxRuntimeException((String) "Texture has no id.");
                            }
                        }
                        continue;
                    }
                    modelData.materials.add(modelMaterial);
                    jsonValue3 = jsonValue3.next;
                } else {
                    throw new GdxRuntimeException((String) "Material needs an id.");
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0094, code lost:
        r3.vertices = r6;
        r5 = r2.require("parts");
        r6 = new com.badlogic.gdx.utils.Array();
        r5 = r5.child;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a3, code lost:
        if (r5 == null) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a5, code lost:
        r7 = new com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart();
        r10 = r5.getString("id", null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00af, code lost:
        if (r10 == null) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b1, code lost:
        r11 = r6.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b9, code lost:
        if (r11.hasNext() == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c7, code lost:
        if (((com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart) r11.next()).id.equals(r10) != false) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d7, code lost:
        throw new com.badlogic.gdx.utils.GdxRuntimeException(com.android.tools.r8.GeneratedOutlineSupport.outline52("Mesh part with id '", r10, "' already in defined"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d8, code lost:
        r7.id = r10;
        r9 = r5.getString("type", null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e0, code lost:
        if (r9 == null) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e2, code lost:
        r7.primitiveType = parseType(r9);
        r9 = r5.require("indices");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f2, code lost:
        if (r9.type != com.badlogic.gdx.utils.JsonValue.ValueType.array) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f4, code lost:
        r10 = new short[r9.size];
        r9 = r9.child;
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fb, code lost:
        if (r9 == null) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fd, code lost:
        r15 = r9.type.ordinal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0103, code lost:
        if (r15 == 2) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0105, code lost:
        if (r15 == r13) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0107, code lost:
        if (r15 == r12) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010a, code lost:
        if (r15 != 5) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0112, code lost:
        if (r9.longValue == 0) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0114, code lost:
        r12 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0116, code lost:
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0118, code lost:
        r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73("Value cannot be converted to short: ");
        r2.append(r9.type);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x012c, code lost:
        throw new java.lang.IllegalStateException(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x012d, code lost:
        r12 = (short) ((int) r9.longValue);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0132, code lost:
        r12 = (short) ((int) r9.doubleValue);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0137, code lost:
        r12 = java.lang.Short.parseShort(r9.stringValue);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013d, code lost:
        r10[r11] = r12;
        r9 = r9.next;
        r11 = r11 + 1;
        r12 = 4;
        r13 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0146, code lost:
        r7.indices = r10;
        r6.add(r7);
        r5 = r5.next;
        r12 = 4;
        r13 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0151, code lost:
        r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73("Value is not an array: ");
        r2.append(r9.type);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0163, code lost:
        throw new java.lang.IllegalStateException(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0171, code lost:
        throw new com.badlogic.gdx.utils.GdxRuntimeException(com.android.tools.r8.GeneratedOutlineSupport.outline52("No primitive type given for mesh part '", r10, "'"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0179, code lost:
        throw new com.badlogic.gdx.utils.GdxRuntimeException((java.lang.String) "Not id given for mesh part");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x017a, code lost:
        r3.parts = (com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart[]) r6.toArray(com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart.class);
        r1.meshes.add(r3);
        r2 = r2.next;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseMeshes(com.badlogic.gdx.graphics.g3d.model.data.ModelData r19, com.badlogic.gdx.utils.JsonValue r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.lang.String r2 = "meshes"
            r3 = r20
            com.badlogic.gdx.utils.JsonValue r2 = r3.get(r2)
            if (r2 == 0) goto L_0x01a0
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g3d.model.data.ModelMesh> r3 = r1.meshes
            int r4 = r2.size
            r3.ensureCapacity(r4)
            com.badlogic.gdx.utils.JsonValue r2 = r2.child
        L_0x0017:
            if (r2 == 0) goto L_0x01a0
            com.badlogic.gdx.graphics.g3d.model.data.ModelMesh r3 = new com.badlogic.gdx.graphics.g3d.model.data.ModelMesh
            r3.<init>()
            java.lang.String r4 = "id"
            java.lang.String r5 = ""
            java.lang.String r5 = r2.getString(r4, r5)
            r3.id = r5
            java.lang.String r5 = "attributes"
            com.badlogic.gdx.utils.JsonValue r5 = r2.require(r5)
            com.badlogic.gdx.graphics.VertexAttribute[] r5 = r0.parseAttributes(r5)
            r3.attributes = r5
            java.lang.String r5 = "vertices"
            com.badlogic.gdx.utils.JsonValue r5 = r2.require(r5)
            com.badlogic.gdx.utils.JsonValue$ValueType r6 = r5.type
            com.badlogic.gdx.utils.JsonValue$ValueType r7 = com.badlogic.gdx.utils.JsonValue.ValueType.array
            java.lang.String r8 = "Value is not an array: "
            if (r6 != r7) goto L_0x018d
            int r6 = r5.size
            float[] r6 = new float[r6]
            com.badlogic.gdx.utils.JsonValue r5 = r5.child
            r7 = 0
        L_0x0049:
            r9 = 0
            r11 = 5
            r12 = 4
            r13 = 3
            r14 = 2
            if (r5 == 0) goto L_0x0094
            com.badlogic.gdx.utils.JsonValue$ValueType r15 = r5.type
            int r15 = r15.ordinal()
            if (r15 == r14) goto L_0x0087
            if (r15 == r13) goto L_0x0083
            if (r15 == r12) goto L_0x007f
            if (r15 != r11) goto L_0x006a
            long r11 = r5.longValue
            int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r13 == 0) goto L_0x0068
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x008d
        L_0x0068:
            r9 = 0
            goto L_0x008d
        L_0x006a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Value cannot be converted to float: "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            com.badlogic.gdx.utils.JsonValue$ValueType r3 = r5.type
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x007f:
            long r9 = r5.longValue
            float r9 = (float) r9
            goto L_0x008d
        L_0x0083:
            double r9 = r5.doubleValue
            float r9 = (float) r9
            goto L_0x008d
        L_0x0087:
            java.lang.String r9 = r5.stringValue
            float r9 = java.lang.Float.parseFloat(r9)
        L_0x008d:
            r6[r7] = r9
            com.badlogic.gdx.utils.JsonValue r5 = r5.next
            int r7 = r7 + 1
            goto L_0x0049
        L_0x0094:
            r3.vertices = r6
            java.lang.String r5 = "parts"
            com.badlogic.gdx.utils.JsonValue r5 = r2.require(r5)
            com.badlogic.gdx.utils.Array r6 = new com.badlogic.gdx.utils.Array
            r6.<init>()
            com.badlogic.gdx.utils.JsonValue r5 = r5.child
        L_0x00a3:
            if (r5 == 0) goto L_0x017a
            com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart r7 = new com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart
            r7.<init>()
            r9 = 0
            java.lang.String r10 = r5.getString(r4, r9)
            if (r10 == 0) goto L_0x0172
            com.badlogic.gdx.utils.Array$ArrayIterator r11 = r6.iterator()
        L_0x00b5:
            boolean r15 = r11.hasNext()
            if (r15 == 0) goto L_0x00d8
            java.lang.Object r15 = r11.next()
            com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart r15 = (com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart) r15
            java.lang.String r15 = r15.id
            boolean r15 = r15.equals(r10)
            if (r15 != 0) goto L_0x00ca
            goto L_0x00b5
        L_0x00ca:
            com.badlogic.gdx.utils.GdxRuntimeException r1 = new com.badlogic.gdx.utils.GdxRuntimeException
            java.lang.String r2 = "Mesh part with id '"
            java.lang.String r3 = "' already in defined"
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r2, r10, r3)
            r1.<init>(r2)
            throw r1
        L_0x00d8:
            r7.id = r10
            java.lang.String r11 = "type"
            java.lang.String r9 = r5.getString(r11, r9)
            if (r9 == 0) goto L_0x0164
            int r9 = r0.parseType(r9)
            r7.primitiveType = r9
            java.lang.String r9 = "indices"
            com.badlogic.gdx.utils.JsonValue r9 = r5.require(r9)
            com.badlogic.gdx.utils.JsonValue$ValueType r10 = r9.type
            com.badlogic.gdx.utils.JsonValue$ValueType r11 = com.badlogic.gdx.utils.JsonValue.ValueType.array
            if (r10 != r11) goto L_0x0151
            int r10 = r9.size
            short[] r10 = new short[r10]
            com.badlogic.gdx.utils.JsonValue r9 = r9.child
            r11 = 0
        L_0x00fb:
            if (r9 == 0) goto L_0x0146
            com.badlogic.gdx.utils.JsonValue$ValueType r15 = r9.type
            int r15 = r15.ordinal()
            if (r15 == r14) goto L_0x0137
            if (r15 == r13) goto L_0x0132
            if (r15 == r12) goto L_0x012d
            r12 = 5
            if (r15 != r12) goto L_0x0118
            long r12 = r9.longValue
            r15 = 0
            int r17 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x0116
            r12 = 1
            goto L_0x013d
        L_0x0116:
            r12 = 0
            goto L_0x013d
        L_0x0118:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Value cannot be converted to short: "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            com.badlogic.gdx.utils.JsonValue$ValueType r3 = r9.type
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x012d:
            long r12 = r9.longValue
            int r13 = (int) r12
            short r12 = (short) r13
            goto L_0x013d
        L_0x0132:
            double r12 = r9.doubleValue
            int r12 = (int) r12
            short r12 = (short) r12
            goto L_0x013d
        L_0x0137:
            java.lang.String r12 = r9.stringValue
            short r12 = java.lang.Short.parseShort(r12)
        L_0x013d:
            r10[r11] = r12
            com.badlogic.gdx.utils.JsonValue r9 = r9.next
            int r11 = r11 + 1
            r12 = 4
            r13 = 3
            goto L_0x00fb
        L_0x0146:
            r7.indices = r10
            r6.add(r7)
            com.badlogic.gdx.utils.JsonValue r5 = r5.next
            r12 = 4
            r13 = 3
            goto L_0x00a3
        L_0x0151:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r8)
            com.badlogic.gdx.utils.JsonValue$ValueType r3 = r9.type
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0164:
            com.badlogic.gdx.utils.GdxRuntimeException r1 = new com.badlogic.gdx.utils.GdxRuntimeException
            java.lang.String r2 = "No primitive type given for mesh part '"
            java.lang.String r3 = "'"
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r2, r10, r3)
            r1.<init>(r2)
            throw r1
        L_0x0172:
            com.badlogic.gdx.utils.GdxRuntimeException r1 = new com.badlogic.gdx.utils.GdxRuntimeException
            java.lang.String r2 = "Not id given for mesh part"
            r1.<init>(r2)
            throw r1
        L_0x017a:
            java.lang.Class<com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart> r4 = com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart.class
            java.lang.Object[] r4 = r6.toArray(r4)
            com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart[] r4 = (com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart[]) r4
            r3.parts = r4
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g3d.model.data.ModelMesh> r4 = r1.meshes
            r4.add(r3)
            com.badlogic.gdx.utils.JsonValue r2 = r2.next
            goto L_0x0017
        L_0x018d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r8)
            com.badlogic.gdx.utils.JsonValue$ValueType r3 = r5.type
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader.parseMeshes(com.badlogic.gdx.graphics.g3d.model.data.ModelData, com.badlogic.gdx.utils.JsonValue):void");
    }

    public ModelData parseModel(FileHandle fileHandle) {
        JsonValue parse = ((JsonReader) this.reader).parse(fileHandle);
        ModelData modelData = new ModelData();
        JsonValue require = parse.require("version");
        modelData.version[0] = require.getShort(0);
        modelData.version[1] = require.getShort(1);
        short[] sArr = modelData.version;
        if (sArr[0] == 0 && sArr[1] == 1) {
            modelData.id = parse.getString("id", "");
            parseMeshes(modelData, parse);
            parseMaterials(modelData, parse, fileHandle.parent().path());
            parseNodes(modelData, parse);
            parseAnimations(modelData, parse);
            return modelData;
        }
        throw new GdxRuntimeException((String) "Model version not supported");
    }

    public Array<ModelNode> parseNodes(ModelData modelData, JsonValue jsonValue) {
        JsonValue jsonValue2 = jsonValue.get("nodes");
        if (jsonValue2 != null) {
            modelData.nodes.ensureCapacity(jsonValue2.size);
            for (JsonValue jsonValue3 = jsonValue2.child; jsonValue3 != null; jsonValue3 = jsonValue3.next) {
                modelData.nodes.add(parseNodesRecursively(jsonValue3));
            }
        }
        return modelData.nodes;
    }

    public ModelNode parseNodesRecursively(JsonValue jsonValue) {
        Vector3 vector3;
        Quaternion quaternion;
        Vector3 vector32;
        String str;
        String str2;
        int i;
        G3dModelLoader g3dModelLoader = this;
        JsonValue jsonValue2 = jsonValue;
        ModelNode modelNode = new ModelNode();
        String str3 = null;
        String string = jsonValue2.getString("id", null);
        if (string != null) {
            modelNode.id = string;
            String str4 = "translation";
            JsonValue jsonValue3 = jsonValue2.get(str4);
            if (jsonValue3 == null || jsonValue3.size == 3) {
                boolean z = true;
                if (jsonValue3 == null) {
                    vector3 = null;
                } else {
                    vector3 = new Vector3(jsonValue3.getFloat(0), jsonValue3.getFloat(1), jsonValue3.getFloat(2));
                }
                modelNode.translation = vector3;
                String str5 = "rotation";
                JsonValue jsonValue4 = jsonValue2.get(str5);
                if (jsonValue4 == null || jsonValue4.size == 4) {
                    if (jsonValue4 == null) {
                        quaternion = null;
                    } else {
                        quaternion = new Quaternion(jsonValue4.getFloat(0), jsonValue4.getFloat(1), jsonValue4.getFloat(2), jsonValue4.getFloat(3));
                    }
                    modelNode.rotation = quaternion;
                    JsonValue jsonValue5 = jsonValue2.get("scale");
                    if (jsonValue5 == null || jsonValue5.size == 3) {
                        if (jsonValue5 == null) {
                            vector32 = null;
                        } else {
                            vector32 = new Vector3(jsonValue5.getFloat(0), jsonValue5.getFloat(1), jsonValue5.getFloat(2));
                        }
                        modelNode.scale = vector32;
                        String string2 = jsonValue2.getString("mesh", null);
                        if (string2 != null) {
                            modelNode.meshId = string2;
                        }
                        JsonValue jsonValue6 = jsonValue2.get("parts");
                        if (jsonValue6 != null) {
                            modelNode.parts = new ModelNodePart[jsonValue6.size];
                            JsonValue jsonValue7 = jsonValue6.child;
                            int i2 = 0;
                            while (jsonValue7 != null) {
                                ModelNodePart modelNodePart = new ModelNodePart();
                                String string3 = jsonValue7.getString("meshpartid", str3);
                                String string4 = jsonValue7.getString("materialid", str3);
                                if (string3 == null || string4 == null) {
                                    throw new GdxRuntimeException(GeneratedOutlineSupport.outline52("Node ", string, " part is missing meshPartId or materialId"));
                                }
                                modelNodePart.materialId = string4;
                                modelNodePart.meshPartId = string3;
                                JsonValue jsonValue8 = jsonValue7.get("bones");
                                if (jsonValue8 != null) {
                                    modelNodePart.bones = new ArrayMap<>(z, jsonValue8.size, String.class, Matrix4.class);
                                    JsonValue jsonValue9 = jsonValue8.child;
                                    while (jsonValue9 != null) {
                                        String string5 = jsonValue9.getString("node", null);
                                        if (string5 != null) {
                                            Matrix4 matrix4 = new Matrix4();
                                            JsonValue jsonValue10 = jsonValue9.get(str4);
                                            if (jsonValue10 == null || jsonValue10.size < 3) {
                                                str = str4;
                                            } else {
                                                str = str4;
                                                matrix4.translate(jsonValue10.getFloat(0), jsonValue10.getFloat(1), jsonValue10.getFloat(2));
                                            }
                                            JsonValue jsonValue11 = jsonValue9.get(str5);
                                            if (jsonValue11 == null || jsonValue11.size < 4) {
                                                str2 = str5;
                                                i = 3;
                                            } else {
                                                Quaternion quaternion2 = g3dModelLoader.tempQ;
                                                str2 = str5;
                                                i = 3;
                                                quaternion2.set(jsonValue11.getFloat(0), jsonValue11.getFloat(1), jsonValue11.getFloat(2), jsonValue11.getFloat(3));
                                                matrix4.rotate(quaternion2);
                                            }
                                            JsonValue jsonValue12 = jsonValue9.get("scale");
                                            if (jsonValue12 != null && jsonValue12.size >= i) {
                                                matrix4.scale(jsonValue12.getFloat(0), jsonValue12.getFloat(1), jsonValue12.getFloat(2));
                                            }
                                            modelNodePart.bones.put(string5, matrix4);
                                            jsonValue9 = jsonValue9.next;
                                            g3dModelLoader = this;
                                            str4 = str;
                                            str5 = str2;
                                        } else {
                                            throw new GdxRuntimeException((String) "Bone node ID missing");
                                        }
                                    }
                                    continue;
                                }
                                modelNode.parts[i2] = modelNodePart;
                                jsonValue7 = jsonValue7.next;
                                i2++;
                                str3 = null;
                                z = true;
                                g3dModelLoader = this;
                                str4 = str4;
                                str5 = str5;
                            }
                        }
                        JsonValue jsonValue13 = jsonValue2.get("children");
                        if (jsonValue13 != null) {
                            modelNode.children = new ModelNode[jsonValue13.size];
                            JsonValue jsonValue14 = jsonValue13.child;
                            int i3 = 0;
                            while (jsonValue14 != null) {
                                modelNode.children[i3] = parseNodesRecursively(jsonValue14);
                                jsonValue14 = jsonValue14.next;
                                i3++;
                            }
                        }
                        return modelNode;
                    }
                    throw new GdxRuntimeException((String) "Node scale incomplete");
                }
                throw new GdxRuntimeException((String) "Node rotation incomplete");
            }
            throw new GdxRuntimeException((String) "Node translation incomplete");
        }
        G3dModelLoader g3dModelLoader2 = g3dModelLoader;
        throw new GdxRuntimeException((String) "Node id missing.");
    }

    public int parseTextureUsage(String str) {
        if (str.equalsIgnoreCase("AMBIENT")) {
            return 4;
        }
        if (str.equalsIgnoreCase("BUMP")) {
            return 8;
        }
        if (str.equalsIgnoreCase("DIFFUSE")) {
            return 2;
        }
        if (str.equalsIgnoreCase("EMISSIVE")) {
            return 3;
        }
        if (str.equalsIgnoreCase("NONE")) {
            return 1;
        }
        if (str.equalsIgnoreCase("NORMAL")) {
            return 7;
        }
        if (str.equalsIgnoreCase("REFLECTION")) {
            return 10;
        }
        if (str.equalsIgnoreCase("SHININESS")) {
            return 6;
        }
        if (str.equalsIgnoreCase("SPECULAR")) {
            return 5;
        }
        return str.equalsIgnoreCase("TRANSPARENCY") ? 9 : 0;
    }

    public int parseType(String str) {
        if (str.equals("TRIANGLES")) {
            return 4;
        }
        if (str.equals("LINES")) {
            return 1;
        }
        if (str.equals("POINTS")) {
            return 0;
        }
        if (str.equals("TRIANGLE_STRIP")) {
            return 5;
        }
        if (str.equals("LINE_STRIP")) {
            return 3;
        }
        throw new GdxRuntimeException(GeneratedOutlineSupport.outline52("Unknown primitive type '", str, "', should be one of triangle, trianglestrip, line, linestrip, lineloop or point"));
    }

    public Vector2 readVector2(JsonValue jsonValue, float f2, float f3) {
        if (jsonValue == null) {
            return new Vector2(f2, f3);
        }
        if (jsonValue.size == 2) {
            return new Vector2(jsonValue.getFloat(0), jsonValue.getFloat(1));
        }
        throw new GdxRuntimeException((String) "Expected Vector2 values <> than two.");
    }

    public G3dModelLoader(BaseJsonReader baseJsonReader, FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
        this.tempQ = new Quaternion();
        this.reader = baseJsonReader;
    }
}
