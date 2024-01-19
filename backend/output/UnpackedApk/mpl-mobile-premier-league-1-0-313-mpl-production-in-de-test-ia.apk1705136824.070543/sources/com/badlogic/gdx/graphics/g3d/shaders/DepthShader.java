package com.badlogic.gdx.graphics.g3d.shaders;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class DepthShader extends DefaultShader {
    public static String defaultFragmentShader;
    public static String defaultVertexShader;
    public static final Attributes tmpAttributes = new Attributes();
    public final FloatAttribute alphaTestAttribute;
    public final int numBones;
    public final int weights;

    public static class Config extends com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Config {
        public float defaultAlphaTest = 0.5f;
        public boolean depthBufferOnly = false;

        public Config() {
            this.defaultCullFace = GL20.GL_FRONT;
        }

        public Config(String str, String str2) {
            super(str, str2);
        }
    }

    public DepthShader(Renderable renderable) {
        this(renderable, new Config());
    }

    public static final Attributes combineAttributes(Renderable renderable) {
        tmpAttributes.clear();
        Environment environment = renderable.environment;
        if (environment != null) {
            tmpAttributes.set((Iterable<Attribute>) environment);
        }
        Material material = renderable.material;
        if (material != null) {
            tmpAttributes.set((Iterable<Attribute>) material);
        }
        return tmpAttributes;
    }

    public static String createPrefix(Renderable renderable, Config config) {
        String createPrefix = DefaultShader.createPrefix(renderable, config);
        return !config.depthBufferOnly ? GeneratedOutlineSupport.outline50(createPrefix, "#define PackedDepthFlag\n") : createPrefix;
    }

    public static final String getDefaultFragmentShader() {
        if (defaultFragmentShader == null) {
            defaultFragmentShader = k.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/depth.fragment.glsl").readString();
        }
        return defaultFragmentShader;
    }

    public static final String getDefaultVertexShader() {
        if (defaultVertexShader == null) {
            defaultVertexShader = k.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/depth.vertex.glsl").readString();
        }
        return defaultVertexShader;
    }

    public void begin(Camera camera, RenderContext renderContext) {
        super.begin(camera, renderContext);
    }

    public boolean canRender(Renderable renderable) {
        Attributes combineAttributes = combineAttributes(renderable);
        boolean z = true;
        if (combineAttributes.has(BlendingAttribute.Type)) {
            long j = this.attributesMask;
            long j2 = BlendingAttribute.Type;
            if ((j & j2) != j2) {
                return false;
            }
            boolean has = combineAttributes.has(TextureAttribute.Diffuse);
            long j3 = this.attributesMask;
            long j4 = TextureAttribute.Diffuse;
            if (has != ((j3 & j4) == j4)) {
                return false;
            }
        }
        if (((renderable.meshPart.mesh.getVertexAttributes().getMask() & 64) == 64) != (this.weights > 0)) {
            z = false;
        }
        return z;
    }

    public void end() {
        super.end();
    }

    public void render(Renderable renderable, Attributes attributes) {
        if (attributes.has(BlendingAttribute.Type)) {
            BlendingAttribute blendingAttribute = (BlendingAttribute) attributes.get(BlendingAttribute.Type);
            attributes.remove(BlendingAttribute.Type);
            boolean has = attributes.has(FloatAttribute.AlphaTest);
            if (!has) {
                attributes.set((Attribute) this.alphaTestAttribute);
            }
            if (blendingAttribute.opacity >= ((FloatAttribute) attributes.get(FloatAttribute.AlphaTest)).value) {
                super.render(renderable, attributes);
            }
            if (!has) {
                attributes.remove(FloatAttribute.AlphaTest);
            }
            attributes.set((Attribute) blendingAttribute);
            return;
        }
        super.render(renderable, attributes);
    }

    public DepthShader(Renderable renderable, Config config) {
        this(renderable, config, createPrefix(renderable, config));
    }

    public DepthShader(Renderable renderable, Config config, String str) {
        this(renderable, config, str, config.vertexShader == null ? getDefaultVertexShader() : config.vertexShader, config.fragmentShader == null ? getDefaultFragmentShader() : config.fragmentShader);
    }

    public DepthShader(Renderable renderable, Config config, String str, String str2, String str3) {
        this(renderable, config, new ShaderProgram(GeneratedOutlineSupport.outline50(str, str2), GeneratedOutlineSupport.outline50(str, str3)));
    }

    public DepthShader(Renderable renderable, Config config, ShaderProgram shaderProgram) {
        super(renderable, (com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Config) config, shaderProgram);
        combineAttributes(renderable);
        this.numBones = renderable.bones == null ? 0 : config.numBones;
        int size = renderable.meshPart.mesh.getVertexAttributes().size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            VertexAttribute vertexAttribute = renderable.meshPart.mesh.getVertexAttributes().get(i2);
            if (vertexAttribute.usage == 64) {
                i |= 1 << vertexAttribute.unit;
            }
        }
        this.weights = i;
        this.alphaTestAttribute = new FloatAttribute(FloatAttribute.AlphaTest, config.defaultAlphaTest);
    }
}
