package com.badlogic.gdx.graphics.g3d;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.model.Animation;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.NodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.NodeKeyframe;
import com.badlogic.gdx.graphics.g3d.model.NodePart;
import com.badlogic.gdx.graphics.g3d.model.data.ModelAnimation;
import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMesh;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMeshPart;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNode;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodeAnimation;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodeKeyframe;
import com.badlogic.gdx.graphics.g3d.model.data.ModelNodePart;
import com.badlogic.gdx.graphics.g3d.model.data.ModelTexture;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider.FileTextureProvider;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entries;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import java.nio.Buffer;
import java.util.Arrays;

public class Model implements Disposable {
    public final Array<Animation> animations;
    public final Array<Disposable> disposables;
    public final Array<Material> materials;
    public final Array<MeshPart> meshParts;
    public final Array<Mesh> meshes;
    public ObjectMap<NodePart, ArrayMap<String, Matrix4>> nodePartBones;
    public final Array<Node> nodes;

    public Model() {
        this.materials = new Array<>();
        this.nodes = new Array<>();
        this.animations = new Array<>();
        this.meshes = new Array<>();
        this.meshParts = new Array<>();
        this.disposables = new Array<>();
        this.nodePartBones = new ObjectMap<>();
    }

    public BoundingBox calculateBoundingBox(BoundingBox boundingBox) {
        boundingBox.inf();
        return extendBoundingBox(boundingBox);
    }

    public void calculateTransforms() {
        int i = this.nodes.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((Node) this.nodes.get(i2)).calculateTransforms(true);
        }
        for (int i3 = 0; i3 < i; i3++) {
            ((Node) this.nodes.get(i3)).calculateBoneTransforms(true);
        }
    }

    public Material convertMaterial(ModelMaterial modelMaterial, TextureProvider textureProvider) {
        Texture texture;
        ModelMaterial modelMaterial2 = modelMaterial;
        Material material = new Material();
        material.id = modelMaterial2.id;
        if (modelMaterial2.ambient != null) {
            material.set((Attribute) new ColorAttribute(ColorAttribute.Ambient, modelMaterial2.ambient));
        }
        if (modelMaterial2.diffuse != null) {
            material.set((Attribute) new ColorAttribute(ColorAttribute.Diffuse, modelMaterial2.diffuse));
        }
        if (modelMaterial2.specular != null) {
            material.set((Attribute) new ColorAttribute(ColorAttribute.Specular, modelMaterial2.specular));
        }
        if (modelMaterial2.emissive != null) {
            material.set((Attribute) new ColorAttribute(ColorAttribute.Emissive, modelMaterial2.emissive));
        }
        if (modelMaterial2.reflection != null) {
            material.set((Attribute) new ColorAttribute(ColorAttribute.Reflection, modelMaterial2.reflection));
        }
        if (modelMaterial2.shininess > 0.0f) {
            material.set((Attribute) new FloatAttribute(FloatAttribute.Shininess, modelMaterial2.shininess));
        }
        if (modelMaterial2.opacity != 1.0f) {
            material.set((Attribute) new BlendingAttribute(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA, modelMaterial2.opacity));
        }
        ObjectMap objectMap = new ObjectMap();
        Array<ModelTexture> array = modelMaterial2.textures;
        if (array != null) {
            ArrayIterator it = array.iterator();
            while (it.hasNext()) {
                ModelTexture modelTexture = (ModelTexture) it.next();
                if (objectMap.containsKey(modelTexture.fileName)) {
                    texture = (Texture) objectMap.get(modelTexture.fileName);
                    TextureProvider textureProvider2 = textureProvider;
                } else {
                    texture = textureProvider.load(modelTexture.fileName);
                    objectMap.put(modelTexture.fileName, texture);
                    this.disposables.add(texture);
                }
                TextureDescriptor textureDescriptor = new TextureDescriptor(texture);
                textureDescriptor.minFilter = texture.getMinFilter();
                textureDescriptor.magFilter = texture.getMagFilter();
                textureDescriptor.uWrap = texture.getUWrap();
                textureDescriptor.vWrap = texture.getVWrap();
                Vector2 vector2 = modelTexture.uvTranslation;
                float f2 = vector2 == null ? 0.0f : vector2.x;
                Vector2 vector22 = modelTexture.uvTranslation;
                float f3 = vector22 == null ? 0.0f : vector22.y;
                Vector2 vector23 = modelTexture.uvScaling;
                float f4 = vector23 == null ? 1.0f : vector23.x;
                Vector2 vector24 = modelTexture.uvScaling;
                float f5 = vector24 == null ? 1.0f : vector24.y;
                int i = modelTexture.usage;
                if (i == 2) {
                    TextureAttribute textureAttribute = new TextureAttribute(TextureAttribute.Diffuse, textureDescriptor, f2, f3, f4, f5);
                    material.set((Attribute) textureAttribute);
                } else if (i == 3) {
                    TextureAttribute textureAttribute2 = new TextureAttribute(TextureAttribute.Emissive, textureDescriptor, f2, f3, f4, f5);
                    material.set((Attribute) textureAttribute2);
                } else if (i == 4) {
                    TextureAttribute textureAttribute3 = new TextureAttribute(TextureAttribute.Ambient, textureDescriptor, f2, f3, f4, f5);
                    material.set((Attribute) textureAttribute3);
                } else if (i == 5) {
                    TextureAttribute textureAttribute4 = new TextureAttribute(TextureAttribute.Specular, textureDescriptor, f2, f3, f4, f5);
                    material.set((Attribute) textureAttribute4);
                } else if (i == 7) {
                    TextureAttribute textureAttribute5 = new TextureAttribute(TextureAttribute.Normal, textureDescriptor, f2, f3, f4, f5);
                    material.set((Attribute) textureAttribute5);
                } else if (i == 8) {
                    TextureAttribute textureAttribute6 = new TextureAttribute(TextureAttribute.Bump, textureDescriptor, f2, f3, f4, f5);
                    material.set((Attribute) textureAttribute6);
                } else if (i == 10) {
                    TextureAttribute textureAttribute7 = new TextureAttribute(TextureAttribute.Reflection, textureDescriptor, f2, f3, f4, f5);
                    material.set((Attribute) textureAttribute7);
                }
            }
        }
        return material;
    }

    public void convertMesh(ModelMesh modelMesh) {
        int i = 0;
        for (ModelMeshPart modelMeshPart : modelMesh.parts) {
            i += modelMeshPart.indices.length;
        }
        boolean z = i > 0;
        VertexAttributes vertexAttributes = new VertexAttributes(modelMesh.attributes);
        int length = modelMesh.vertices.length / (vertexAttributes.vertexSize / 4);
        Mesh mesh = new Mesh(true, length, i, vertexAttributes);
        this.meshes.add(mesh);
        this.disposables.add(mesh);
        BufferUtils.copy(modelMesh.vertices, (Buffer) mesh.getVerticesBuffer(), modelMesh.vertices.length, 0);
        mesh.getIndicesBuffer().clear();
        int i2 = 0;
        for (ModelMeshPart modelMeshPart2 : modelMesh.parts) {
            MeshPart meshPart = new MeshPart();
            meshPart.id = modelMeshPart2.id;
            meshPart.primitiveType = modelMeshPart2.primitiveType;
            meshPart.offset = i2;
            meshPart.size = z ? modelMeshPart2.indices.length : length;
            meshPart.mesh = mesh;
            if (z) {
                mesh.getIndicesBuffer().put(modelMeshPart2.indices);
            }
            i2 += meshPart.size;
            this.meshParts.add(meshPart);
        }
        mesh.getIndicesBuffer().position(0);
        ArrayIterator it = this.meshParts.iterator();
        while (it.hasNext()) {
            ((MeshPart) it.next()).update();
        }
    }

    public void dispose() {
        ArrayIterator it = this.disposables.iterator();
        while (it.hasNext()) {
            ((Disposable) it.next()).dispose();
        }
    }

    public BoundingBox extendBoundingBox(BoundingBox boundingBox) {
        int i = this.nodes.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((Node) this.nodes.get(i2)).extendBoundingBox(boundingBox);
        }
        return boundingBox;
    }

    public Animation getAnimation(String str) {
        return getAnimation(str, true);
    }

    public Iterable<Disposable> getManagedDisposables() {
        return this.disposables;
    }

    public Material getMaterial(String str) {
        return getMaterial(str, true);
    }

    public Node getNode(String str) {
        return getNode(str, true);
    }

    public void load(ModelData modelData, TextureProvider textureProvider) {
        loadMeshes(modelData.meshes);
        loadMaterials(modelData.materials, textureProvider);
        loadNodes(modelData.nodes);
        loadAnimations(modelData.animations);
        calculateTransforms();
    }

    public void loadAnimations(Iterable<ModelAnimation> iterable) {
        for (ModelAnimation next : iterable) {
            Animation animation = new Animation();
            animation.id = next.id;
            ArrayIterator it = next.nodeAnimations.iterator();
            while (it.hasNext()) {
                ModelNodeAnimation modelNodeAnimation = (ModelNodeAnimation) it.next();
                Node node = getNode(modelNodeAnimation.nodeId);
                if (node != null) {
                    NodeAnimation nodeAnimation = new NodeAnimation();
                    nodeAnimation.node = node;
                    if (modelNodeAnimation.translation != null) {
                        Array<NodeKeyframe<Vector3>> array = new Array<>();
                        nodeAnimation.translation = array;
                        array.ensureCapacity(modelNodeAnimation.translation.size);
                        ArrayIterator it2 = modelNodeAnimation.translation.iterator();
                        while (it2.hasNext()) {
                            ModelNodeKeyframe modelNodeKeyframe = (ModelNodeKeyframe) it2.next();
                            float f2 = modelNodeKeyframe.keytime;
                            if (f2 > animation.duration) {
                                animation.duration = f2;
                            }
                            Array<NodeKeyframe<Vector3>> array2 = nodeAnimation.translation;
                            float f3 = modelNodeKeyframe.keytime;
                            T t = modelNodeKeyframe.value;
                            array2.add(new NodeKeyframe(f3, new Vector3(t == null ? node.translation : (Vector3) t)));
                        }
                    }
                    if (modelNodeAnimation.rotation != null) {
                        Array<NodeKeyframe<Quaternion>> array3 = new Array<>();
                        nodeAnimation.rotation = array3;
                        array3.ensureCapacity(modelNodeAnimation.rotation.size);
                        ArrayIterator it3 = modelNodeAnimation.rotation.iterator();
                        while (it3.hasNext()) {
                            ModelNodeKeyframe modelNodeKeyframe2 = (ModelNodeKeyframe) it3.next();
                            float f4 = modelNodeKeyframe2.keytime;
                            if (f4 > animation.duration) {
                                animation.duration = f4;
                            }
                            Array<NodeKeyframe<Quaternion>> array4 = nodeAnimation.rotation;
                            float f5 = modelNodeKeyframe2.keytime;
                            T t2 = modelNodeKeyframe2.value;
                            array4.add(new NodeKeyframe(f5, new Quaternion(t2 == null ? node.rotation : (Quaternion) t2)));
                        }
                    }
                    if (modelNodeAnimation.scaling != null) {
                        Array<NodeKeyframe<Vector3>> array5 = new Array<>();
                        nodeAnimation.scaling = array5;
                        array5.ensureCapacity(modelNodeAnimation.scaling.size);
                        ArrayIterator it4 = modelNodeAnimation.scaling.iterator();
                        while (it4.hasNext()) {
                            ModelNodeKeyframe modelNodeKeyframe3 = (ModelNodeKeyframe) it4.next();
                            float f6 = modelNodeKeyframe3.keytime;
                            if (f6 > animation.duration) {
                                animation.duration = f6;
                            }
                            Array<NodeKeyframe<Vector3>> array6 = nodeAnimation.scaling;
                            float f7 = modelNodeKeyframe3.keytime;
                            T t3 = modelNodeKeyframe3.value;
                            array6.add(new NodeKeyframe(f7, new Vector3(t3 == null ? node.scale : (Vector3) t3)));
                        }
                    }
                    Array<NodeKeyframe<Vector3>> array7 = nodeAnimation.translation;
                    if (array7 == null || array7.size <= 0) {
                        Array<NodeKeyframe<Quaternion>> array8 = nodeAnimation.rotation;
                        if (array8 == null || array8.size <= 0) {
                            Array<NodeKeyframe<Vector3>> array9 = nodeAnimation.scaling;
                            if (array9 != null) {
                                if (array9.size <= 0) {
                                }
                            }
                        }
                    }
                    animation.nodeAnimations.add(nodeAnimation);
                }
            }
            if (animation.nodeAnimations.size > 0) {
                this.animations.add(animation);
            }
        }
    }

    public void loadMaterials(Iterable<ModelMaterial> iterable, TextureProvider textureProvider) {
        for (ModelMaterial convertMaterial : iterable) {
            this.materials.add(convertMaterial(convertMaterial, textureProvider));
        }
    }

    public void loadMeshes(Iterable<ModelMesh> iterable) {
        for (ModelMesh convertMesh : iterable) {
            convertMesh(convertMesh);
        }
    }

    public Node loadNode(ModelNode modelNode) {
        MeshPart meshPart;
        Node node = new Node();
        node.id = modelNode.id;
        Vector3 vector3 = modelNode.translation;
        if (vector3 != null) {
            node.translation.set(vector3);
        }
        Quaternion quaternion = modelNode.rotation;
        if (quaternion != null) {
            node.rotation.set(quaternion);
        }
        Vector3 vector32 = modelNode.scale;
        if (vector32 != null) {
            node.scale.set(vector32);
        }
        ModelNodePart[] modelNodePartArr = modelNode.parts;
        if (modelNodePartArr != null) {
            for (ModelNodePart modelNodePart : modelNodePartArr) {
                Material material = null;
                if (modelNodePart.meshPartId != null) {
                    ArrayIterator it = this.meshParts.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        meshPart = (MeshPart) it.next();
                        if (modelNodePart.meshPartId.equals(meshPart.id)) {
                            break;
                        }
                    }
                }
                meshPart = null;
                if (modelNodePart.materialId != null) {
                    ArrayIterator it2 = this.materials.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Material material2 = (Material) it2.next();
                        if (modelNodePart.materialId.equals(material2.id)) {
                            material = material2;
                            break;
                        }
                    }
                }
                if (meshPart == null || material == null) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid node: ");
                    outline73.append(node.id);
                    throw new GdxRuntimeException(outline73.toString());
                }
                NodePart nodePart = new NodePart();
                nodePart.meshPart = meshPart;
                nodePart.material = material;
                node.parts.add(nodePart);
                ArrayMap<String, Matrix4> arrayMap = modelNodePart.bones;
                if (arrayMap != null) {
                    this.nodePartBones.put(nodePart, arrayMap);
                }
            }
        }
        ModelNode[] modelNodeArr = modelNode.children;
        if (modelNodeArr != null) {
            for (ModelNode loadNode : modelNodeArr) {
                node.addChild(loadNode(loadNode));
            }
        }
        return node;
    }

    public void loadNodes(Iterable<ModelNode> iterable) {
        this.nodePartBones.clear();
        for (ModelNode loadNode : iterable) {
            this.nodes.add(loadNode(loadNode));
        }
        Entries entries = this.nodePartBones.entries();
        if (entries == null) {
            throw null;
        }
        while (entries.hasNext()) {
            Entry entry = (Entry) entries.next();
            NodePart nodePart = (NodePart) entry.key;
            if (nodePart.invBoneBindTransforms == null) {
                nodePart.invBoneBindTransforms = new ArrayMap<>(false, 16, Node.class, Matrix4.class);
            }
            ArrayMap<Node, Matrix4> arrayMap = ((NodePart) entry.key).invBoneBindTransforms;
            Arrays.fill(arrayMap.keys, 0, arrayMap.size, null);
            Arrays.fill(arrayMap.values, 0, arrayMap.size, null);
            arrayMap.size = 0;
            ArrayMap.Entries entries2 = ((ArrayMap) entry.value).entries();
            if (entries2 != null) {
                while (true) {
                    if (entries2.hasNext()) {
                        Entry entry2 = (Entry) entries2.next();
                        ArrayMap<Node, Matrix4> arrayMap2 = ((NodePart) entry.key).invBoneBindTransforms;
                        Node node = getNode((String) entry2.key);
                        Matrix4 matrix4 = new Matrix4((Matrix4) entry2.value);
                        float[] fArr = matrix4.val;
                        float f2 = (fArr[0] * fArr[5] * fArr[10] * fArr[15]) + ((((((fArr[2] * fArr[4]) * fArr[9]) * fArr[15]) + ((((fArr[1] * fArr[6]) * fArr[8]) * fArr[15]) + ((((((fArr[1] * fArr[4]) * fArr[11]) * fArr[14]) + ((((fArr[0] * fArr[7]) * fArr[9]) * fArr[14]) + ((((((fArr[3] * fArr[5]) * fArr[8]) * fArr[14]) + ((((fArr[0] * fArr[6]) * fArr[11]) * fArr[13]) + ((((((fArr[3] * fArr[4]) * fArr[10]) * fArr[13]) + ((((fArr[2] * fArr[7]) * fArr[8]) * fArr[13]) + ((((((fArr[2] * fArr[5]) * fArr[11]) * fArr[12]) + ((((fArr[1] * fArr[7]) * fArr[10]) * fArr[12]) + (((((fArr[3] * fArr[6]) * fArr[9]) * fArr[12]) - (((fArr[2] * fArr[7]) * fArr[9]) * fArr[12])) - (((fArr[3] * fArr[5]) * fArr[10]) * fArr[12])))) - (((fArr[1] * fArr[6]) * fArr[11]) * fArr[12])) - (((fArr[3] * fArr[6]) * fArr[8]) * fArr[13])))) - (((fArr[0] * fArr[7]) * fArr[10]) * fArr[13])) - (((fArr[2] * fArr[4]) * fArr[11]) * fArr[13])))) - (((fArr[1] * fArr[7]) * fArr[8]) * fArr[14])) - (((fArr[3] * fArr[4]) * fArr[9]) * fArr[14])))) - (((fArr[0] * fArr[5]) * fArr[11]) * fArr[14])) - (((fArr[2] * fArr[5]) * fArr[8]) * fArr[15])))) - (((fArr[0] * fArr[6]) * fArr[9]) * fArr[15])) - (((fArr[1] * fArr[4]) * fArr[10]) * fArr[15]));
                        if (f2 != 0.0f) {
                            float f3 = (fArr[5] * fArr[10] * fArr[15]) + (((((fArr[13] * fArr[6]) * fArr[11]) + (((fArr[9] * fArr[14]) * fArr[7]) - ((fArr[13] * fArr[10]) * fArr[7]))) - ((fArr[5] * fArr[14]) * fArr[11])) - ((fArr[9] * fArr[6]) * fArr[15]));
                            float f4 = (((fArr[8] * fArr[6]) * fArr[15]) + (((fArr[4] * fArr[14]) * fArr[11]) + ((((fArr[12] * fArr[10]) * fArr[7]) - ((fArr[8] * fArr[14]) * fArr[7])) - ((fArr[12] * fArr[6]) * fArr[11])))) - ((fArr[4] * fArr[10]) * fArr[15]);
                            float f5 = (fArr[4] * fArr[9] * fArr[15]) + (((((fArr[12] * fArr[5]) * fArr[11]) + (((fArr[8] * fArr[13]) * fArr[7]) - ((fArr[12] * fArr[9]) * fArr[7]))) - ((fArr[4] * fArr[13]) * fArr[11])) - ((fArr[8] * fArr[5]) * fArr[15]));
                            float f6 = (((fArr[8] * fArr[5]) * fArr[14]) + (((fArr[4] * fArr[13]) * fArr[10]) + ((((fArr[12] * fArr[9]) * fArr[6]) - ((fArr[8] * fArr[13]) * fArr[6])) - ((fArr[12] * fArr[5]) * fArr[10])))) - ((fArr[4] * fArr[9]) * fArr[14]);
                            float f7 = (((fArr[9] * fArr[2]) * fArr[15]) + (((fArr[1] * fArr[14]) * fArr[11]) + ((((fArr[13] * fArr[10]) * fArr[3]) - ((fArr[9] * fArr[14]) * fArr[3])) - ((fArr[13] * fArr[2]) * fArr[11])))) - ((fArr[1] * fArr[10]) * fArr[15]);
                            float f8 = (fArr[0] * fArr[10] * fArr[15]) + (((((fArr[12] * fArr[2]) * fArr[11]) + (((fArr[8] * fArr[14]) * fArr[3]) - ((fArr[12] * fArr[10]) * fArr[3]))) - ((fArr[0] * fArr[14]) * fArr[11])) - ((fArr[8] * fArr[2]) * fArr[15]));
                            float f9 = (((fArr[8] * fArr[1]) * fArr[15]) + (((fArr[0] * fArr[13]) * fArr[11]) + ((((fArr[12] * fArr[9]) * fArr[3]) - ((fArr[8] * fArr[13]) * fArr[3])) - ((fArr[12] * fArr[1]) * fArr[11])))) - ((fArr[0] * fArr[9]) * fArr[15]);
                            float f10 = (fArr[0] * fArr[9] * fArr[14]) + (((((fArr[12] * fArr[1]) * fArr[10]) + (((fArr[8] * fArr[13]) * fArr[2]) - ((fArr[12] * fArr[9]) * fArr[2]))) - ((fArr[0] * fArr[13]) * fArr[10])) - ((fArr[8] * fArr[1]) * fArr[14]));
                            float f11 = (fArr[1] * fArr[6] * fArr[15]) + (((((fArr[13] * fArr[2]) * fArr[7]) + (((fArr[5] * fArr[14]) * fArr[3]) - ((fArr[13] * fArr[6]) * fArr[3]))) - ((fArr[1] * fArr[14]) * fArr[7])) - ((fArr[5] * fArr[2]) * fArr[15]));
                            float f12 = (((fArr[4] * fArr[2]) * fArr[15]) + (((fArr[0] * fArr[14]) * fArr[7]) + ((((fArr[12] * fArr[6]) * fArr[3]) - ((fArr[4] * fArr[14]) * fArr[3])) - ((fArr[12] * fArr[2]) * fArr[7])))) - ((fArr[0] * fArr[6]) * fArr[15]);
                            float f13 = (fArr[0] * fArr[5] * fArr[15]) + (((((fArr[12] * fArr[1]) * fArr[7]) + (((fArr[4] * fArr[13]) * fArr[3]) - ((fArr[12] * fArr[5]) * fArr[3]))) - ((fArr[0] * fArr[13]) * fArr[7])) - ((fArr[4] * fArr[1]) * fArr[15]));
                            float f14 = (((fArr[4] * fArr[1]) * fArr[14]) + (((fArr[0] * fArr[13]) * fArr[6]) + ((((fArr[12] * fArr[5]) * fArr[2]) - ((fArr[4] * fArr[13]) * fArr[2])) - ((fArr[12] * fArr[1]) * fArr[6])))) - ((fArr[0] * fArr[5]) * fArr[14]);
                            float f15 = (((fArr[5] * fArr[2]) * fArr[11]) + (((fArr[1] * fArr[10]) * fArr[7]) + ((((fArr[9] * fArr[6]) * fArr[3]) - ((fArr[5] * fArr[10]) * fArr[3])) - ((fArr[9] * fArr[2]) * fArr[7])))) - ((fArr[1] * fArr[6]) * fArr[11]);
                            float f16 = (fArr[0] * fArr[6] * fArr[11]) + (((((fArr[8] * fArr[2]) * fArr[7]) + (((fArr[4] * fArr[10]) * fArr[3]) - ((fArr[8] * fArr[6]) * fArr[3]))) - ((fArr[0] * fArr[10]) * fArr[7])) - ((fArr[4] * fArr[2]) * fArr[11]));
                            float f17 = (((fArr[4] * fArr[1]) * fArr[11]) + (((fArr[0] * fArr[9]) * fArr[7]) + ((((fArr[8] * fArr[5]) * fArr[3]) - ((fArr[4] * fArr[9]) * fArr[3])) - ((fArr[8] * fArr[1]) * fArr[7])))) - ((fArr[0] * fArr[5]) * fArr[11]);
                            float f18 = (fArr[0] * fArr[5] * fArr[10]) + (((((fArr[8] * fArr[1]) * fArr[6]) + (((fArr[4] * fArr[9]) * fArr[2]) - ((fArr[8] * fArr[5]) * fArr[2]))) - ((fArr[0] * fArr[9]) * fArr[6])) - ((fArr[4] * fArr[1]) * fArr[10]));
                            float f19 = 1.0f / f2;
                            fArr[0] = f3 * f19;
                            fArr[1] = f7 * f19;
                            fArr[2] = f11 * f19;
                            fArr[3] = f15 * f19;
                            fArr[4] = f4 * f19;
                            fArr[5] = f8 * f19;
                            fArr[6] = f12 * f19;
                            fArr[7] = f16 * f19;
                            fArr[8] = f5 * f19;
                            fArr[9] = f9 * f19;
                            fArr[10] = f13 * f19;
                            fArr[11] = f17 * f19;
                            fArr[12] = f6 * f19;
                            fArr[13] = f10 * f19;
                            fArr[14] = f14 * f19;
                            fArr[15] = f18 * f19;
                            arrayMap2.put(node, matrix4);
                        } else {
                            throw new RuntimeException("non-invertible matrix");
                        }
                    }
                }
            } else {
                throw null;
            }
        }
    }

    public void manageDisposable(Disposable disposable) {
        if (!this.disposables.contains(disposable, true)) {
            this.disposables.add(disposable);
        }
    }

    public Animation getAnimation(String str, boolean z) {
        int i = this.animations.size;
        int i2 = 0;
        if (z) {
            while (i2 < i) {
                Animation animation = (Animation) this.animations.get(i2);
                if (animation.id.equalsIgnoreCase(str)) {
                    return animation;
                }
                i2++;
            }
        } else {
            while (i2 < i) {
                Animation animation2 = (Animation) this.animations.get(i2);
                if (animation2.id.equals(str)) {
                    return animation2;
                }
                i2++;
            }
        }
        return null;
    }

    public Material getMaterial(String str, boolean z) {
        int i = this.materials.size;
        int i2 = 0;
        if (z) {
            while (i2 < i) {
                Material material = (Material) this.materials.get(i2);
                if (material.id.equalsIgnoreCase(str)) {
                    return material;
                }
                i2++;
            }
        } else {
            while (i2 < i) {
                Material material2 = (Material) this.materials.get(i2);
                if (material2.id.equals(str)) {
                    return material2;
                }
                i2++;
            }
        }
        return null;
    }

    public Node getNode(String str, boolean z) {
        return getNode(str, z, false);
    }

    public Node getNode(String str, boolean z, boolean z2) {
        return Node.getNode(this.nodes, str, z, z2);
    }

    public Model(ModelData modelData) {
        this(modelData, new FileTextureProvider());
    }

    public Model(ModelData modelData, TextureProvider textureProvider) {
        this.materials = new Array<>();
        this.nodes = new Array<>();
        this.animations = new Array<>();
        this.meshes = new Array<>();
        this.meshParts = new Array<>();
        this.disposables = new Array<>();
        this.nodePartBones = new ObjectMap<>();
        load(modelData, textureProvider);
    }
}
