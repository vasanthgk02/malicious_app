package com.badlogic.gdx.graphics.g3d.particles;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.IntAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Setter;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Uniform;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.Iterator;

public class ParticleShader extends BaseShader {
    public static final Vector3 TMP_VECTOR3 = new Vector3();
    public static String defaultFragmentShader;
    public static String defaultVertexShader;
    public static long implementedFlags = (BlendingAttribute.Type | TextureAttribute.Diffuse);
    public static final long optionalAttributes = (IntAttribute.CullFace | DepthTestAttribute.Type);
    public final Config config;
    public Material currentMaterial;
    public long materialMask;
    public Renderable renderable;
    public long vertexMask;

    public enum AlignMode {
        Screen,
        ViewPoint
    }

    public static class Config {
        public AlignMode align = AlignMode.Screen;
        public int defaultCullFace = -1;
        public int defaultDepthFunc = -1;
        public String fragmentShader = null;
        public boolean ignoreUnimplemented = true;
        public ParticleType type = ParticleType.Billboard;
        public String vertexShader = null;

        public Config() {
        }

        public Config(AlignMode alignMode, ParticleType particleType) {
            this.align = alignMode;
            this.type = particleType;
        }

        public Config(AlignMode alignMode) {
            this.align = alignMode;
        }

        public Config(ParticleType particleType) {
            this.type = particleType;
        }

        public Config(String str, String str2) {
            this.vertexShader = str;
            this.fragmentShader = str2;
        }
    }

    public static class Inputs {
        public static final Uniform cameraInvDirection = new Uniform("u_cameraInvDirection");
        public static final Uniform cameraRight = new Uniform("u_cameraRight");
        public static final Uniform regionSize = new Uniform("u_regionSize");
        public static final Uniform screenWidth = new Uniform("u_screenWidth");
    }

    public enum ParticleType {
        Billboard,
        Point
    }

    public static class Setters {
        public static final Setter cameraInvDirection = new Setter() {
            public boolean isGlobal(BaseShader baseShader, int i) {
                return true;
            }

            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                Vector3 vector3 = ParticleShader.TMP_VECTOR3;
                Vector3 vector32 = baseShader.camera.direction;
                vector3.set(-vector32.x, -vector32.y, -vector32.z);
                baseShader.set(i, vector3.nor());
            }
        };
        public static final Setter cameraPosition = new Setter() {
            public boolean isGlobal(BaseShader baseShader, int i) {
                return true;
            }

            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, baseShader.camera.position);
            }
        };
        public static final Setter cameraRight = new Setter() {
            public boolean isGlobal(BaseShader baseShader, int i) {
                return true;
            }

            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                Vector3 vector3 = ParticleShader.TMP_VECTOR3;
                vector3.set(baseShader.camera.direction);
                vector3.crs(baseShader.camera.up);
                baseShader.set(i, vector3.nor());
            }
        };
        public static final Setter cameraUp = new Setter() {
            public boolean isGlobal(BaseShader baseShader, int i) {
                return true;
            }

            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                Vector3 vector3 = ParticleShader.TMP_VECTOR3;
                vector3.set(baseShader.camera.up);
                baseShader.set(i, vector3.nor());
            }
        };
        public static final Setter screenWidth = new Setter() {
            public boolean isGlobal(BaseShader baseShader, int i) {
                return true;
            }

            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, (float) ((AndroidGraphics) k.graphics).width);
            }
        };
        public static final Setter worldViewTrans = new Setter() {
            public final Matrix4 temp = new Matrix4();

            public boolean isGlobal(BaseShader baseShader, int i) {
                return false;
            }

            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                Matrix4 matrix4 = this.temp;
                matrix4.set(baseShader.camera.view);
                matrix4.mul(renderable.worldTransform);
                baseShader.set(i, matrix4);
            }
        };
    }

    public ParticleShader(Renderable renderable2) {
        this(renderable2, new Config());
    }

    public static String createPrefix(Renderable renderable2, Config config2) {
        String str = k.app.getType() == ApplicationType.Desktop ? "#version 120\n" : "#version 100\n";
        if (config2.type != ParticleType.Billboard) {
            return str;
        }
        String outline50 = GeneratedOutlineSupport.outline50(str, "#define billboard\n");
        AlignMode alignMode = config2.align;
        if (alignMode == AlignMode.Screen) {
            return GeneratedOutlineSupport.outline50(outline50, "#define screenFacing\n");
        }
        return alignMode == AlignMode.ViewPoint ? GeneratedOutlineSupport.outline50(outline50, "#define viewPointFacing\n") : outline50;
    }

    public static String getDefaultFragmentShader() {
        if (defaultFragmentShader == null) {
            defaultFragmentShader = k.files.classpath("com/badlogic/gdx/graphics/g3d/particles/particles.fragment.glsl").readString();
        }
        return defaultFragmentShader;
    }

    public static String getDefaultVertexShader() {
        if (defaultVertexShader == null) {
            defaultVertexShader = k.files.classpath("com/badlogic/gdx/graphics/g3d/particles/particles.vertex.glsl").readString();
        }
        return defaultVertexShader;
    }

    public void begin(Camera camera, RenderContext renderContext) {
        super.begin(camera, renderContext);
    }

    public void bindMaterial(Renderable renderable2) {
        if (this.currentMaterial != renderable2.material) {
            int i = this.config.defaultCullFace;
            if (i == -1) {
                i = GL20.GL_BACK;
            }
            int i2 = this.config.defaultDepthFunc;
            if (i2 == -1) {
                i2 = GL20.GL_LEQUAL;
            }
            float f2 = 0.0f;
            float f3 = 1.0f;
            Material material = renderable2.material;
            this.currentMaterial = material;
            Iterator<Attribute> it = material.iterator();
            boolean z = true;
            while (it.hasNext()) {
                Attribute next = it.next();
                long j = next.type;
                if (BlendingAttribute.is(j)) {
                    BlendingAttribute blendingAttribute = (BlendingAttribute) next;
                    this.context.setBlending(true, blendingAttribute.sourceFunction, blendingAttribute.destFunction);
                } else {
                    long j2 = DepthTestAttribute.Type;
                    if ((j & j2) == j2) {
                        DepthTestAttribute depthTestAttribute = (DepthTestAttribute) next;
                        i2 = depthTestAttribute.depthFunc;
                        f2 = depthTestAttribute.depthRangeNear;
                        f3 = depthTestAttribute.depthRangeFar;
                        z = depthTestAttribute.depthMask;
                    } else if (!this.config.ignoreUnimplemented) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown material attribute: ");
                        outline73.append(next.toString());
                        throw new GdxRuntimeException(outline73.toString());
                    }
                }
            }
            this.context.setCullFace(i);
            this.context.setDepthTest(i2, f2, f3);
            this.context.setDepthMask(z);
        }
    }

    public boolean canRender(Renderable renderable2) {
        return this.materialMask == (renderable2.material.getMask() | optionalAttributes) && this.vertexMask == renderable2.meshPart.mesh.getVertexAttributes().getMask();
    }

    public int compareTo(Shader shader) {
        if (shader == null) {
            return -1;
        }
        if (shader == this) {
        }
        return 0;
    }

    public void dispose() {
        this.program.dispose();
        super.dispose();
    }

    public void end() {
        this.currentMaterial = null;
        super.end();
    }

    public boolean equals(ParticleShader particleShader) {
        return particleShader == this;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParticleShader) && equals((ParticleShader) obj);
    }

    public int getDefaultCullFace() {
        int i = this.config.defaultCullFace;
        return i == -1 ? GL20.GL_BACK : i;
    }

    public int getDefaultDepthFunc() {
        int i = this.config.defaultDepthFunc;
        return i == -1 ? GL20.GL_LEQUAL : i;
    }

    public void init() {
        ShaderProgram shaderProgram = this.program;
        this.program = null;
        init(shaderProgram, this.renderable);
        this.renderable = null;
    }

    public void render(Renderable renderable2) {
        if (!renderable2.material.has(BlendingAttribute.Type)) {
            this.context.setBlending(false, GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        }
        bindMaterial(renderable2);
        super.render(renderable2);
    }

    public void setDefaultCullFace(int i) {
        this.config.defaultCullFace = i;
    }

    public void setDefaultDepthFunc(int i) {
        this.config.defaultDepthFunc = i;
    }

    public ParticleShader(Renderable renderable2, Config config2) {
        this(renderable2, config2, createPrefix(renderable2, config2));
    }

    public ParticleShader(Renderable renderable2, Config config2, String str) {
        this(renderable2, config2, str, config2.vertexShader == null ? getDefaultVertexShader() : config2.vertexShader, config2.fragmentShader == null ? getDefaultFragmentShader() : config2.fragmentShader);
    }

    public ParticleShader(Renderable renderable2, Config config2, String str, String str2, String str3) {
        this(renderable2, config2, new ShaderProgram(GeneratedOutlineSupport.outline50(str, str2), GeneratedOutlineSupport.outline50(str, str3)));
    }

    public ParticleShader(Renderable renderable2, Config config2, ShaderProgram shaderProgram) {
        this.config = config2;
        this.program = shaderProgram;
        this.renderable = renderable2;
        this.materialMask = renderable2.material.getMask() | optionalAttributes;
        this.vertexMask = renderable2.meshPart.mesh.getVertexAttributes().getMask();
        if (!config2.ignoreUnimplemented) {
            long j = implementedFlags;
            long j2 = this.materialMask;
            if ((j & j2) != j2) {
                throw new GdxRuntimeException(GeneratedOutlineSupport.outline58(GeneratedOutlineSupport.outline73("Some attributes not implemented yet ("), this.materialMask, ")"));
            }
        }
        register(com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.viewTrans, com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.viewTrans);
        register(com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.projViewTrans, com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.projViewTrans);
        register(com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.projTrans, com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.projTrans);
        register(Inputs.screenWidth, Setters.screenWidth);
        register(com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.cameraUp, Setters.cameraUp);
        register(Inputs.cameraRight, Setters.cameraRight);
        register(Inputs.cameraInvDirection, Setters.cameraInvDirection);
        register(com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.cameraPosition, Setters.cameraPosition);
        register(com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.diffuseTexture, com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.diffuseTexture);
    }
}
