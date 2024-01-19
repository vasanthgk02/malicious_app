package com.badlogic.gdx.graphics.g3d.shaders;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.IntIntMap;

public abstract class BaseShader implements Shader {
    public final IntIntMap attributes = new IntIntMap(51, 0.8f);
    public Camera camera;
    public Attributes combinedAttributes = new Attributes();
    public RenderContext context;
    public Mesh currentMesh;
    public final IntArray globalUniforms = new IntArray();
    public final IntArray localUniforms = new IntArray();
    public int[] locations;
    public ShaderProgram program;
    public final Array<Setter> setters = new Array<>();
    public final IntArray tempArray = new IntArray();
    public final Array<String> uniforms = new Array<>();
    public final Array<Validator> validators = new Array<>();

    public static abstract class GlobalSetter implements Setter {
        public boolean isGlobal(BaseShader baseShader, int i) {
            return true;
        }
    }

    public static abstract class LocalSetter implements Setter {
        public boolean isGlobal(BaseShader baseShader, int i) {
            return false;
        }
    }

    public interface Setter {
        boolean isGlobal(BaseShader baseShader, int i);

        void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes);
    }

    public static class Uniform implements Validator {
        public final String alias;
        public final long environmentMask;
        public final long materialMask;
        public final long overallMask;

        public Uniform(String str, long j, long j2, long j3) {
            this.alias = str;
            this.materialMask = j;
            this.environmentMask = j2;
            this.overallMask = j3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0020  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0010  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean validate(com.badlogic.gdx.graphics.g3d.shaders.BaseShader r7, int r8, com.badlogic.gdx.graphics.g3d.Renderable r9) {
            /*
                r6 = this;
                r7 = 0
                if (r9 == 0) goto L_0x000d
                com.badlogic.gdx.graphics.g3d.Material r0 = r9.material
                if (r0 == 0) goto L_0x000d
                long r0 = r0.getMask()
                goto L_0x000e
            L_0x000d:
                r0 = r7
            L_0x000e:
                if (r9 == 0) goto L_0x0018
                com.badlogic.gdx.graphics.g3d.Environment r9 = r9.environment
                if (r9 == 0) goto L_0x0018
                long r7 = r9.getMask()
            L_0x0018:
                long r2 = r6.materialMask
                long r4 = r0 & r2
                int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r9 != 0) goto L_0x0032
                long r2 = r6.environmentMask
                long r4 = r7 & r2
                int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r9 != 0) goto L_0x0032
                long r7 = r7 | r0
                long r0 = r6.overallMask
                long r7 = r7 & r0
                int r9 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r9 != 0) goto L_0x0032
                r7 = 1
                goto L_0x0033
            L_0x0032:
                r7 = 0
            L_0x0033:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Uniform.validate(com.badlogic.gdx.graphics.g3d.shaders.BaseShader, int, com.badlogic.gdx.graphics.g3d.Renderable):boolean");
        }

        public Uniform(String str, long j, long j2) {
            this(str, j, j2, 0);
        }

        public Uniform(String str, long j) {
            this(str, 0, 0, j);
        }

        public Uniform(String str) {
            this(str, 0, 0);
        }
    }

    public interface Validator {
        boolean validate(BaseShader baseShader, int i, Renderable renderable);
    }

    private final int[] getAttributeLocations(VertexAttributes vertexAttributes) {
        this.tempArray.size = 0;
        int size = vertexAttributes.size();
        for (int i = 0; i < size; i++) {
            this.tempArray.add(this.attributes.get(vertexAttributes.get(i).getKey(), -1));
        }
        IntArray intArray = this.tempArray;
        int length = intArray.items.length;
        int i2 = intArray.size;
        if (length != i2) {
            intArray.resize(i2);
        }
        return this.tempArray.items;
    }

    public void begin(Camera camera2, RenderContext renderContext) {
        this.camera = camera2;
        this.context = renderContext;
        this.program.bind();
        this.currentMesh = null;
        int i = 0;
        while (true) {
            IntArray intArray = this.globalUniforms;
            if (i < intArray.size) {
                Array<Setter> array = this.setters;
                int i2 = intArray.get(i);
                if (array.get(i2) != null) {
                    ((Setter) this.setters.get(i2)).set(this, i2, null, null);
                }
                i++;
            } else {
                return;
            }
        }
    }

    public void dispose() {
        this.program = null;
        this.uniforms.clear();
        this.validators.clear();
        this.setters.clear();
        this.localUniforms.size = 0;
        this.globalUniforms.size = 0;
        this.locations = null;
    }

    public void end() {
        Mesh mesh = this.currentMesh;
        if (mesh != null) {
            mesh.unbind(this.program, this.tempArray.items);
            this.currentMesh = null;
        }
    }

    public String getUniformAlias(int i) {
        return (String) this.uniforms.get(i);
    }

    public int getUniformID(String str) {
        int i = this.uniforms.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (((String) this.uniforms.get(i2)).equals(str)) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean has(int i) {
        if (i >= 0) {
            int[] iArr = this.locations;
            if (i < iArr.length && iArr[i] >= 0) {
                return true;
            }
        }
        return false;
    }

    public void init(ShaderProgram shaderProgram, Renderable renderable) {
        if (this.locations != null) {
            throw new GdxRuntimeException((String) "Already initialized");
        } else if (shaderProgram.isCompiled()) {
            this.program = shaderProgram;
            int i = this.uniforms.size;
            this.locations = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                String str = (String) this.uniforms.get(i2);
                Validator validator = (Validator) this.validators.get(i2);
                Setter setter = (Setter) this.setters.get(i2);
                if (validator == null || validator.validate(this, i2, renderable)) {
                    this.locations[i2] = shaderProgram.fetchUniformLocation(str, false);
                    if (this.locations[i2] >= 0 && setter != null) {
                        if (setter.isGlobal(this, i2)) {
                            this.globalUniforms.add(i2);
                        } else {
                            this.localUniforms.add(i2);
                        }
                    }
                } else {
                    this.locations[i2] = -1;
                }
                if (this.locations[i2] < 0) {
                    this.validators.set(i2, null);
                    this.setters.set(i2, null);
                }
            }
            if (renderable != null) {
                VertexAttributes vertexAttributes = renderable.meshPart.mesh.getVertexAttributes();
                int size = vertexAttributes.size();
                for (int i3 = 0; i3 < size; i3++) {
                    VertexAttribute vertexAttribute = vertexAttributes.get(i3);
                    int attributeLocation = shaderProgram.getAttributeLocation(vertexAttribute.alias);
                    if (attributeLocation >= 0) {
                        this.attributes.put(vertexAttribute.getKey(), attributeLocation);
                    }
                }
            }
        } else {
            throw new GdxRuntimeException(shaderProgram.getLog());
        }
    }

    public final int loc(int i) {
        if (i >= 0) {
            int[] iArr = this.locations;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        return -1;
    }

    public int register(String str, Validator validator, Setter setter) {
        if (this.locations == null) {
            int uniformID = getUniformID(str);
            if (uniformID >= 0) {
                this.validators.set(uniformID, validator);
                this.setters.set(uniformID, setter);
                return uniformID;
            }
            this.uniforms.add(str);
            this.validators.add(validator);
            this.setters.add(setter);
            return this.uniforms.size - 1;
        }
        throw new GdxRuntimeException((String) "Cannot register an uniform after initialization");
    }

    public void render(Renderable renderable) {
        float[] fArr = renderable.worldTransform.val;
        float f2 = fArr[4] * fArr[9] * fArr[2];
        if ((((((fArr[8] * fArr[1]) * fArr[6]) + (f2 + ((fArr[0] * fArr[5]) * fArr[10]))) - ((fArr[0] * fArr[9]) * fArr[6])) - ((fArr[4] * fArr[1]) * fArr[10])) - ((fArr[8] * fArr[5]) * fArr[2]) != 0.0f) {
            this.combinedAttributes.clear();
            Environment environment = renderable.environment;
            if (environment != null) {
                this.combinedAttributes.set((Iterable<Attribute>) environment);
            }
            Material material = renderable.material;
            if (material != null) {
                this.combinedAttributes.set((Iterable<Attribute>) material);
            }
            render(renderable, this.combinedAttributes);
        }
    }

    public final boolean set(int i, Matrix4 matrix4) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformMatrix(iArr[i], matrix4);
        return true;
    }

    public final boolean set(int i, Matrix3 matrix3) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformMatrix(iArr[i], matrix3);
        return true;
    }

    public final boolean set(int i, Vector3 vector3) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformf(iArr[i], vector3);
        return true;
    }

    public void render(Renderable renderable, Attributes attributes2) {
        int i = 0;
        while (true) {
            IntArray intArray = this.localUniforms;
            if (i >= intArray.size) {
                break;
            }
            Array<Setter> array = this.setters;
            int i2 = intArray.get(i);
            if (array.get(i2) != null) {
                ((Setter) this.setters.get(i2)).set(this, i2, renderable, attributes2);
            }
            i++;
        }
        Mesh mesh = this.currentMesh;
        if (mesh != renderable.meshPart.mesh) {
            if (mesh != null) {
                mesh.unbind(this.program, this.tempArray.items);
            }
            Mesh mesh2 = renderable.meshPart.mesh;
            this.currentMesh = mesh2;
            mesh2.bind(this.program, getAttributeLocations(mesh2.getVertexAttributes()));
        }
        renderable.meshPart.render(this.program, false);
    }

    public final boolean set(int i, Vector2 vector2) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformf(iArr[i], vector2);
        return true;
    }

    public final boolean set(int i, Color color) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformf(iArr[i], color);
        return true;
    }

    public int register(String str, Validator validator) {
        return register(str, validator, null);
    }

    public int register(String str, Setter setter) {
        return register(str, null, setter);
    }

    public final boolean set(int i, float f2) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformf(iArr[i], f2);
        return true;
    }

    public int register(String str) {
        return register(str, null, null);
    }

    public int register(Uniform uniform, Setter setter) {
        return register(uniform.alias, uniform, setter);
    }

    public final boolean set(int i, float f2, float f3) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformf(iArr[i], f2, f3);
        return true;
    }

    public int register(Uniform uniform) {
        return register(uniform, (Setter) null);
    }

    public final boolean set(int i, float f2, float f3, float f4) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformf(iArr[i], f2, f3, f4);
        return true;
    }

    public final boolean set(int i, float f2, float f3, float f4, float f5) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformf(iArr[i], f2, f3, f4, f5);
        return true;
    }

    public final boolean set(int i, int i2) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformi(iArr[i], i2);
        return true;
    }

    public final boolean set(int i, int i2, int i3) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformi(iArr[i], i2, i3);
        return true;
    }

    public final boolean set(int i, int i2, int i3, int i4) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformi(iArr[i], i2, i3, i4);
        return true;
    }

    public final boolean set(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformi(iArr[i], i2, i3, i4, i5);
        return true;
    }

    public final boolean set(int i, TextureDescriptor textureDescriptor) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformi(iArr[i], this.context.textureBinder.bind(textureDescriptor));
        return true;
    }

    public final boolean set(int i, GLTexture gLTexture) {
        int[] iArr = this.locations;
        if (iArr[i] < 0) {
            return false;
        }
        this.program.setUniformi(iArr[i], this.context.textureBinder.bind(gLTexture));
        return true;
    }
}
