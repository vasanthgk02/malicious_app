package com.badlogic.gdx.graphics.g3d.shaders;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.Attributes;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.CubemapAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.DirectionalLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.IntAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.PointLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.SpotLightsAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.environment.AmbientCubemap;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.environment.ShadowMap;
import com.badlogic.gdx.graphics.g3d.environment.SpotLight;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.GlobalSetter;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.LocalSetter;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Setter;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader.Uniform;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.Iterator;

public class DefaultShader extends BaseShader {
    @Deprecated
    public static int defaultCullFace = GL20.GL_BACK;
    @Deprecated
    public static int defaultDepthFunc = GL20.GL_LEQUAL;
    public static String defaultFragmentShader;
    public static String defaultVertexShader;
    public static long implementedFlags = ((((BlendingAttribute.Type | TextureAttribute.Diffuse) | ColorAttribute.Diffuse) | ColorAttribute.Specular) | FloatAttribute.Shininess);
    public static final long optionalAttributes = (IntAttribute.CullFace | DepthTestAttribute.Type);
    public static final Attributes tmpAttributes = new Attributes();
    public final AmbientCubemap ambientCubemap;
    public final long attributesMask;
    public final Config config;
    public int dirLightsColorOffset;
    public int dirLightsDirectionOffset;
    public int dirLightsLoc;
    public int dirLightsSize;
    public final DirectionalLight[] directionalLights;
    public final boolean environmentCubemap;
    public final boolean lighting;
    public boolean lightsSet;
    public final Matrix3 normalMatrix;
    public final PointLight[] pointLights;
    public int pointLightsColorOffset;
    public int pointLightsIntensityOffset;
    public int pointLightsLoc;
    public int pointLightsPositionOffset;
    public int pointLightsSize;
    public Renderable renderable;
    public final boolean shadowMap;
    public final SpotLight[] spotLights;
    public int spotLightsColorOffset;
    public int spotLightsCutoffAngleOffset;
    public int spotLightsDirectionOffset;
    public int spotLightsExponentOffset;
    public int spotLightsIntensityOffset;
    public int spotLightsLoc;
    public int spotLightsPositionOffset;
    public int spotLightsSize;
    public float time;
    public final Vector3 tmpV1;
    public final int u_alphaTest;
    public final int u_ambientCubemap;
    public final int u_ambientTexture;
    public final int u_ambientUVTransform;
    public final int u_bones;
    public final int u_cameraDirection;
    public final int u_cameraNearFar;
    public final int u_cameraPosition;
    public final int u_cameraUp;
    public final int u_diffuseColor;
    public final int u_diffuseTexture;
    public final int u_diffuseUVTransform;
    public final int u_dirLights0color;
    public final int u_dirLights0direction;
    public final int u_dirLights1color;
    public final int u_emissiveColor;
    public final int u_emissiveTexture;
    public final int u_emissiveUVTransform;
    public final int u_environmentCubemap;
    public final int u_fogColor;
    public final int u_normalMatrix;
    public final int u_normalTexture;
    public final int u_normalUVTransform;
    public final int u_opacity;
    public final int u_pointLights0color;
    public final int u_pointLights0intensity;
    public final int u_pointLights0position;
    public final int u_pointLights1color;
    public final int u_projTrans;
    public final int u_projViewTrans;
    public final int u_projViewWorldTrans;
    public final int u_reflectionColor;
    public final int u_reflectionTexture;
    public final int u_reflectionUVTransform;
    public final int u_shadowMapProjViewTrans;
    public final int u_shadowPCFOffset;
    public final int u_shadowTexture;
    public final int u_shininess;
    public final int u_specularColor;
    public final int u_specularTexture;
    public final int u_specularUVTransform;
    public final int u_spotLights0color;
    public final int u_spotLights0cutoffAngle;
    public final int u_spotLights0direction;
    public final int u_spotLights0exponent;
    public final int u_spotLights0intensity;
    public final int u_spotLights0position;
    public final int u_spotLights1color;
    public final int u_time;
    public final int u_viewTrans;
    public final int u_viewWorldTrans;
    public final int u_worldTrans;
    public final long vertexMask;

    public static class Config {
        public int defaultCullFace = -1;
        public int defaultDepthFunc = -1;
        public String fragmentShader = null;
        public boolean ignoreUnimplemented = true;
        public int numBones = 12;
        public int numDirectionalLights = 2;
        public int numPointLights = 5;
        public int numSpotLights = 0;
        public String vertexShader = null;

        public Config() {
        }

        public Config(String str, String str2) {
            this.vertexShader = str;
            this.fragmentShader = str2;
        }
    }

    public static class Inputs {
        public static final Uniform alphaTest = new Uniform("u_alphaTest");
        public static final Uniform ambientCube = new Uniform("u_ambientCubemap");
        public static final Uniform ambientTexture = new Uniform("u_ambientTexture", TextureAttribute.Ambient);
        public static final Uniform ambientUVTransform = new Uniform("u_ambientUVTransform", TextureAttribute.Ambient);
        public static final Uniform bones = new Uniform("u_bones");
        public static final Uniform cameraDirection = new Uniform("u_cameraDirection");
        public static final Uniform cameraNearFar = new Uniform("u_cameraNearFar");
        public static final Uniform cameraPosition = new Uniform("u_cameraPosition");
        public static final Uniform cameraUp = new Uniform("u_cameraUp");
        public static final Uniform diffuseColor = new Uniform("u_diffuseColor", ColorAttribute.Diffuse);
        public static final Uniform diffuseTexture = new Uniform("u_diffuseTexture", TextureAttribute.Diffuse);
        public static final Uniform diffuseUVTransform = new Uniform("u_diffuseUVTransform", TextureAttribute.Diffuse);
        public static final Uniform dirLights = new Uniform("u_dirLights");
        public static final Uniform emissiveColor = new Uniform("u_emissiveColor", ColorAttribute.Emissive);
        public static final Uniform emissiveTexture = new Uniform("u_emissiveTexture", TextureAttribute.Emissive);
        public static final Uniform emissiveUVTransform = new Uniform("u_emissiveUVTransform", TextureAttribute.Emissive);
        public static final Uniform environmentCubemap = new Uniform("u_environmentCubemap");
        public static final Uniform normalMatrix = new Uniform("u_normalMatrix");
        public static final Uniform normalTexture = new Uniform("u_normalTexture", TextureAttribute.Normal);
        public static final Uniform normalUVTransform = new Uniform("u_normalUVTransform", TextureAttribute.Normal);
        public static final Uniform opacity = new Uniform("u_opacity", BlendingAttribute.Type);
        public static final Uniform pointLights = new Uniform("u_pointLights");
        public static final Uniform projTrans = new Uniform("u_projTrans");
        public static final Uniform projViewTrans = new Uniform("u_projViewTrans");
        public static final Uniform projViewWorldTrans = new Uniform("u_projViewWorldTrans");
        public static final Uniform reflectionColor = new Uniform("u_reflectionColor", ColorAttribute.Reflection);
        public static final Uniform reflectionTexture = new Uniform("u_reflectionTexture", TextureAttribute.Reflection);
        public static final Uniform reflectionUVTransform = new Uniform("u_reflectionUVTransform", TextureAttribute.Reflection);
        public static final Uniform shininess = new Uniform("u_shininess", FloatAttribute.Shininess);
        public static final Uniform specularColor = new Uniform("u_specularColor", ColorAttribute.Specular);
        public static final Uniform specularTexture = new Uniform("u_specularTexture", TextureAttribute.Specular);
        public static final Uniform specularUVTransform = new Uniform("u_specularUVTransform", TextureAttribute.Specular);
        public static final Uniform spotLights = new Uniform("u_spotLights");
        public static final Uniform viewTrans = new Uniform("u_viewTrans");
        public static final Uniform viewWorldTrans = new Uniform("u_viewWorldTrans");
        public static final Uniform worldTrans = new Uniform("u_worldTrans");
    }

    public static class Setters {
        public static final Setter ambientTexture = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, baseShader.context.textureBinder.bind((TextureDescriptor) ((TextureAttribute) attributes.get(TextureAttribute.Ambient)).textureDescription));
            }
        };
        public static final Setter ambientUVTransform = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                TextureAttribute textureAttribute = (TextureAttribute) attributes.get(TextureAttribute.Ambient);
                baseShader.set(i, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
            }
        };
        public static final Setter cameraDirection = new GlobalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, baseShader.camera.direction);
            }
        };
        public static final Setter cameraNearFar = new GlobalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                Camera camera = baseShader.camera;
                baseShader.set(i, camera.near, camera.far);
            }
        };
        public static final Setter cameraPosition = new GlobalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                Camera camera = baseShader.camera;
                Vector3 vector3 = camera.position;
                float f2 = vector3.x;
                float f3 = vector3.y;
                float f4 = vector3.z;
                float f5 = camera.far;
                baseShader.set(i, f2, f3, f4, 1.1881f / (f5 * f5));
            }
        };
        public static final Setter cameraUp = new GlobalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, baseShader.camera.up);
            }
        };
        public static final Setter diffuseColor = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, ((ColorAttribute) attributes.get(ColorAttribute.Diffuse)).color);
            }
        };
        public static final Setter diffuseTexture = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, baseShader.context.textureBinder.bind((TextureDescriptor) ((TextureAttribute) attributes.get(TextureAttribute.Diffuse)).textureDescription));
            }
        };
        public static final Setter diffuseUVTransform = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                TextureAttribute textureAttribute = (TextureAttribute) attributes.get(TextureAttribute.Diffuse);
                baseShader.set(i, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
            }
        };
        public static final Setter emissiveColor = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, ((ColorAttribute) attributes.get(ColorAttribute.Emissive)).color);
            }
        };
        public static final Setter emissiveTexture = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, baseShader.context.textureBinder.bind((TextureDescriptor) ((TextureAttribute) attributes.get(TextureAttribute.Emissive)).textureDescription));
            }
        };
        public static final Setter emissiveUVTransform = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                TextureAttribute textureAttribute = (TextureAttribute) attributes.get(TextureAttribute.Emissive);
                baseShader.set(i, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
            }
        };
        public static final Setter environmentCubemap = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                if (attributes.has(CubemapAttribute.EnvironmentMap)) {
                    baseShader.set(i, baseShader.context.textureBinder.bind((TextureDescriptor) ((CubemapAttribute) attributes.get(CubemapAttribute.EnvironmentMap)).textureDescription));
                }
            }
        };
        public static final Setter normalMatrix = new LocalSetter() {
            public final Matrix3 tmpM = new Matrix3();

            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                Matrix3 matrix3 = this.tmpM;
                matrix3.set(renderable.worldTransform);
                matrix3.inv();
                matrix3.transpose();
                baseShader.set(i, matrix3);
            }
        };
        public static final Setter normalTexture = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, baseShader.context.textureBinder.bind((TextureDescriptor) ((TextureAttribute) attributes.get(TextureAttribute.Normal)).textureDescription));
            }
        };
        public static final Setter normalUVTransform = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                TextureAttribute textureAttribute = (TextureAttribute) attributes.get(TextureAttribute.Normal);
                baseShader.set(i, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
            }
        };
        public static final Setter projTrans = new GlobalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, baseShader.camera.projection);
            }
        };
        public static final Setter projViewTrans = new GlobalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, baseShader.camera.combined);
            }
        };
        public static final Setter projViewWorldTrans = new LocalSetter() {
            public final Matrix4 temp = new Matrix4();

            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                Matrix4 matrix4 = this.temp;
                matrix4.set(baseShader.camera.combined);
                matrix4.mul(renderable.worldTransform);
                baseShader.set(i, matrix4);
            }
        };
        public static final Setter reflectionColor = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, ((ColorAttribute) attributes.get(ColorAttribute.Reflection)).color);
            }
        };
        public static final Setter reflectionTexture = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, baseShader.context.textureBinder.bind((TextureDescriptor) ((TextureAttribute) attributes.get(TextureAttribute.Reflection)).textureDescription));
            }
        };
        public static final Setter reflectionUVTransform = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                TextureAttribute textureAttribute = (TextureAttribute) attributes.get(TextureAttribute.Reflection);
                baseShader.set(i, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
            }
        };
        public static final Setter shininess = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, ((FloatAttribute) attributes.get(FloatAttribute.Shininess)).value);
            }
        };
        public static final Setter specularColor = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, ((ColorAttribute) attributes.get(ColorAttribute.Specular)).color);
            }
        };
        public static final Setter specularTexture = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, baseShader.context.textureBinder.bind((TextureDescriptor) ((TextureAttribute) attributes.get(TextureAttribute.Specular)).textureDescription));
            }
        };
        public static final Setter specularUVTransform = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                TextureAttribute textureAttribute = (TextureAttribute) attributes.get(TextureAttribute.Specular);
                baseShader.set(i, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV);
            }
        };
        public static final Setter viewTrans = new GlobalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, baseShader.camera.view);
            }
        };
        public static final Setter viewWorldTrans = new LocalSetter() {
            public final Matrix4 temp = new Matrix4();

            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                Matrix4 matrix4 = this.temp;
                matrix4.set(baseShader.camera.view);
                matrix4.mul(renderable.worldTransform);
                baseShader.set(i, matrix4);
            }
        };
        public static final Setter worldTrans = new LocalSetter() {
            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                baseShader.set(i, renderable.worldTransform);
            }
        };

        public static class ACubemap extends LocalSetter {
            public static final float[] ones = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
            public static final Vector3 tmpV1 = new Vector3();
            public final AmbientCubemap cacheAmbientCubemap = new AmbientCubemap();
            public final int dirLightsOffset;
            public final int pointLightsOffset;

            public ACubemap(int i, int i2) {
                this.dirLightsOffset = i;
                this.pointLightsOffset = i2;
            }

            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                if (renderable.environment == null) {
                    ShaderProgram shaderProgram = baseShader.program;
                    int loc = baseShader.loc(i);
                    float[] fArr = ones;
                    shaderProgram.setUniform3fv(loc, fArr, 0, fArr.length);
                    return;
                }
                renderable.worldTransform.getTranslation(tmpV1);
                if (attributes.has(ColorAttribute.AmbientLight)) {
                    this.cacheAmbientCubemap.set(((ColorAttribute) attributes.get(ColorAttribute.AmbientLight)).color);
                }
                if (attributes.has(DirectionalLightsAttribute.Type)) {
                    Array<DirectionalLight> array = ((DirectionalLightsAttribute) attributes.get(DirectionalLightsAttribute.Type)).lights;
                    for (int i2 = this.dirLightsOffset; i2 < array.size; i2++) {
                        this.cacheAmbientCubemap.add(((DirectionalLight) array.get(i2)).color, ((DirectionalLight) array.get(i2)).direction);
                    }
                }
                if (attributes.has(PointLightsAttribute.Type)) {
                    Array<PointLight> array2 = ((PointLightsAttribute) attributes.get(PointLightsAttribute.Type)).lights;
                    for (int i3 = this.pointLightsOffset; i3 < array2.size; i3++) {
                        this.cacheAmbientCubemap.add(((PointLight) array2.get(i3)).color, ((PointLight) array2.get(i3)).position, tmpV1, ((PointLight) array2.get(i3)).intensity);
                    }
                }
                this.cacheAmbientCubemap.clamp();
                ShaderProgram shaderProgram2 = baseShader.program;
                int loc2 = baseShader.loc(i);
                float[] fArr2 = this.cacheAmbientCubemap.data;
                shaderProgram2.setUniform3fv(loc2, fArr2, 0, fArr2.length);
            }
        }

        public static class Bones extends LocalSetter {
            public static final Matrix4 idtMatrix = new Matrix4();
            public final float[] bones;

            public Bones(int i) {
                this.bones = new float[(i * 16)];
            }

            public void set(BaseShader baseShader, int i, Renderable renderable, Attributes attributes) {
                int i2 = 0;
                while (true) {
                    float[] fArr = this.bones;
                    if (i2 < fArr.length) {
                        int i3 = i2 / 16;
                        Matrix4[] matrix4Arr = renderable.bones;
                        if (matrix4Arr == null || i3 >= matrix4Arr.length || matrix4Arr[i3] == null) {
                            System.arraycopy(idtMatrix.val, 0, this.bones, i2, 16);
                        } else {
                            System.arraycopy(matrix4Arr[i3].val, 0, fArr, i2, 16);
                        }
                        i2 += 16;
                    } else {
                        ShaderProgram shaderProgram = baseShader.program;
                        int loc = baseShader.loc(i);
                        float[] fArr2 = this.bones;
                        shaderProgram.setUniformMatrix4fv(loc, fArr2, 0, fArr2.length);
                        return;
                    }
                }
            }
        }
    }

    public DefaultShader(Renderable renderable2) {
        this(renderable2, new Config());
    }

    public static final boolean and(long j, long j2) {
        return (j & j2) == j2;
    }

    public static final long combineAttributeMasks(Renderable renderable2) {
        Environment environment = renderable2.environment;
        long j = 0;
        if (environment != null) {
            j = 0 | environment.getMask();
        }
        Material material = renderable2.material;
        return material != null ? j | material.getMask() : j;
    }

    public static final Attributes combineAttributes(Renderable renderable2) {
        tmpAttributes.clear();
        Environment environment = renderable2.environment;
        if (environment != null) {
            tmpAttributes.set((Iterable<Attribute>) environment);
        }
        Material material = renderable2.material;
        if (material != null) {
            tmpAttributes.set((Iterable<Attribute>) material);
        }
        return tmpAttributes;
    }

    public static String createPrefix(Renderable renderable2, Config config2) {
        String str;
        Attributes combineAttributes = combineAttributes(renderable2);
        long mask = combineAttributes.getMask();
        long mask2 = renderable2.meshPart.mesh.getVertexAttributes().getMask();
        String str2 = and(mask2, 1) ? "#define positionFlag\n" : "";
        if (or(mask2, 6)) {
            str2 = GeneratedOutlineSupport.outline50(str2, "#define colorFlag\n");
        }
        if (and(mask2, 256)) {
            str2 = GeneratedOutlineSupport.outline50(str2, "#define binormalFlag\n");
        }
        if (and(mask2, 128)) {
            str2 = GeneratedOutlineSupport.outline50(str2, "#define tangentFlag\n");
        }
        if (and(mask2, 8)) {
            str2 = GeneratedOutlineSupport.outline50(str2, "#define normalFlag\n");
        }
        if ((and(mask2, 8) || and(mask2, 384)) && renderable2.environment != null) {
            String outline57 = GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline78(GeneratedOutlineSupport.outline50(GeneratedOutlineSupport.outline50(str2, "#define lightingFlag\n"), "#define ambientCubemapFlag\n"), "#define numDirectionalLights "), config2.numDirectionalLights, "\n"), "#define numPointLights "), config2.numPointLights, "\n"), "#define numSpotLights "), config2.numSpotLights, "\n");
            if (combineAttributes.has(ColorAttribute.Fog)) {
                outline57 = GeneratedOutlineSupport.outline50(outline57, "#define fogFlag\n");
            }
            if (renderable2.environment.shadowMap != null) {
                outline57 = GeneratedOutlineSupport.outline50(outline57, "#define shadowMapFlag\n");
            }
            str2 = outline57;
            if (combineAttributes.has(CubemapAttribute.EnvironmentMap)) {
                str2 = GeneratedOutlineSupport.outline50(str2, "#define environmentCubemapFlag\n");
            }
        }
        int size = renderable2.meshPart.mesh.getVertexAttributes().size();
        for (int i = 0; i < size; i++) {
            VertexAttribute vertexAttribute = renderable2.meshPart.mesh.getVertexAttributes().get(i);
            int i2 = vertexAttribute.usage;
            if (i2 == 64) {
                str = GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline78(str2, "#define boneWeight"), vertexAttribute.unit, "Flag\n");
            } else if (i2 == 16) {
                str = GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline78(str2, "#define texCoord"), vertexAttribute.unit, "Flag\n");
            }
            str2 = str;
        }
        long j = BlendingAttribute.Type;
        if ((mask & j) == j) {
            str2 = GeneratedOutlineSupport.outline50(str2, "#define blendedFlag\n");
        }
        long j2 = TextureAttribute.Diffuse;
        if ((mask & j2) == j2) {
            str2 = GeneratedOutlineSupport.outline50(GeneratedOutlineSupport.outline50(str2, "#define diffuseTextureFlag\n"), "#define diffuseTextureCoord texCoord0\n");
        }
        long j3 = TextureAttribute.Specular;
        if ((mask & j3) == j3) {
            str2 = GeneratedOutlineSupport.outline50(GeneratedOutlineSupport.outline50(str2, "#define specularTextureFlag\n"), "#define specularTextureCoord texCoord0\n");
        }
        long j4 = TextureAttribute.Normal;
        if ((mask & j4) == j4) {
            str2 = GeneratedOutlineSupport.outline50(GeneratedOutlineSupport.outline50(str2, "#define normalTextureFlag\n"), "#define normalTextureCoord texCoord0\n");
        }
        long j5 = TextureAttribute.Emissive;
        if ((mask & j5) == j5) {
            str2 = GeneratedOutlineSupport.outline50(GeneratedOutlineSupport.outline50(str2, "#define emissiveTextureFlag\n"), "#define emissiveTextureCoord texCoord0\n");
        }
        long j6 = TextureAttribute.Reflection;
        if ((mask & j6) == j6) {
            str2 = GeneratedOutlineSupport.outline50(GeneratedOutlineSupport.outline50(str2, "#define reflectionTextureFlag\n"), "#define reflectionTextureCoord texCoord0\n");
        }
        long j7 = TextureAttribute.Ambient;
        if ((mask & j7) == j7) {
            str2 = GeneratedOutlineSupport.outline50(GeneratedOutlineSupport.outline50(str2, "#define ambientTextureFlag\n"), "#define ambientTextureCoord texCoord0\n");
        }
        long j8 = ColorAttribute.Diffuse;
        if ((mask & j8) == j8) {
            str2 = GeneratedOutlineSupport.outline50(str2, "#define diffuseColorFlag\n");
        }
        long j9 = ColorAttribute.Specular;
        if ((mask & j9) == j9) {
            str2 = GeneratedOutlineSupport.outline50(str2, "#define specularColorFlag\n");
        }
        long j10 = ColorAttribute.Emissive;
        if ((mask & j10) == j10) {
            str2 = GeneratedOutlineSupport.outline50(str2, "#define emissiveColorFlag\n");
        }
        long j11 = ColorAttribute.Reflection;
        if ((mask & j11) == j11) {
            str2 = GeneratedOutlineSupport.outline50(str2, "#define reflectionColorFlag\n");
        }
        long j12 = FloatAttribute.Shininess;
        if ((mask & j12) == j12) {
            str2 = GeneratedOutlineSupport.outline50(str2, "#define shininessFlag\n");
        }
        long j13 = FloatAttribute.AlphaTest;
        if ((mask & j13) == j13) {
            str2 = GeneratedOutlineSupport.outline50(str2, "#define alphaTestFlag\n");
        }
        return (renderable2.bones == null || config2.numBones <= 0) ? str2 : GeneratedOutlineSupport.outline57(GeneratedOutlineSupport.outline78(str2, "#define numBones "), config2.numBones, "\n");
    }

    public static String getDefaultFragmentShader() {
        if (defaultFragmentShader == null) {
            defaultFragmentShader = k.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/default.fragment.glsl").readString();
        }
        return defaultFragmentShader;
    }

    public static String getDefaultVertexShader() {
        if (defaultVertexShader == null) {
            defaultVertexShader = k.files.classpath("com/badlogic/gdx/graphics/g3d/shaders/default.vertex.glsl").readString();
        }
        return defaultVertexShader;
    }

    public static final boolean or(long j, long j2) {
        return (j & j2) != 0;
    }

    public void begin(Camera camera, RenderContext renderContext) {
        super.begin(camera, renderContext);
        for (DirectionalLight directionalLight : this.directionalLights) {
            directionalLight.set(0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f);
        }
        for (PointLight pointLight : this.pointLights) {
            pointLight.set(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        }
        for (SpotLight spotLight : this.spotLights) {
            spotLight.set(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        }
        this.lightsSet = false;
        if (has(this.u_time)) {
            int i = this.u_time;
            float f2 = this.time + ((AndroidGraphics) k.graphics).deltaTime;
            this.time = f2;
            set(i, f2);
        }
    }

    public void bindLights(Renderable renderable2, Attributes attributes) {
        Array array;
        Array array2;
        Environment environment = renderable2.environment;
        DirectionalLightsAttribute directionalLightsAttribute = (DirectionalLightsAttribute) attributes.get(DirectionalLightsAttribute.class, DirectionalLightsAttribute.Type);
        Array<SpotLight> array3 = null;
        if (directionalLightsAttribute == null) {
            array = null;
        } else {
            array = directionalLightsAttribute.lights;
        }
        PointLightsAttribute pointLightsAttribute = (PointLightsAttribute) attributes.get(PointLightsAttribute.class, PointLightsAttribute.Type);
        if (pointLightsAttribute == null) {
            array2 = null;
        } else {
            array2 = pointLightsAttribute.lights;
        }
        SpotLightsAttribute spotLightsAttribute = (SpotLightsAttribute) attributes.get(SpotLightsAttribute.class, SpotLightsAttribute.Type);
        if (spotLightsAttribute != null) {
            array3 = spotLightsAttribute.lights;
        }
        int i = 0;
        if (this.dirLightsLoc >= 0) {
            int i2 = 0;
            while (true) {
                DirectionalLight[] directionalLightArr = this.directionalLights;
                if (i2 >= directionalLightArr.length) {
                    break;
                }
                if (array == null || i2 >= array.size) {
                    if (this.lightsSet) {
                        DirectionalLight[] directionalLightArr2 = this.directionalLights;
                        if (directionalLightArr2[i2].color.r == 0.0f && directionalLightArr2[i2].color.g == 0.0f && directionalLightArr2[i2].color.f3307b == 0.0f) {
                            i2++;
                        }
                    }
                    this.directionalLights[i2].color.set(0.0f, 0.0f, 0.0f, 1.0f);
                } else if (!this.lightsSet || !directionalLightArr[i2].equals((DirectionalLight) array.get(i2))) {
                    this.directionalLights[i2].set((DirectionalLight) array.get(i2));
                } else {
                    i2++;
                }
                int i3 = (this.dirLightsSize * i2) + this.dirLightsLoc;
                DirectionalLight[] directionalLightArr3 = this.directionalLights;
                this.program.setUniformf(this.dirLightsColorOffset + i3, directionalLightArr3[i2].color.r, directionalLightArr3[i2].color.g, directionalLightArr3[i2].color.f3307b);
                ShaderProgram shaderProgram = this.program;
                int i4 = i3 + this.dirLightsDirectionOffset;
                DirectionalLight[] directionalLightArr4 = this.directionalLights;
                shaderProgram.setUniformf(i4, directionalLightArr4[i2].direction.x, directionalLightArr4[i2].direction.y, directionalLightArr4[i2].direction.z);
                if (this.dirLightsSize <= 0) {
                    break;
                }
                i2++;
            }
        }
        if (this.pointLightsLoc >= 0) {
            int i5 = 0;
            while (true) {
                PointLight[] pointLightArr = this.pointLights;
                if (i5 >= pointLightArr.length) {
                    break;
                }
                if (array2 == null || i5 >= array2.size) {
                    if (!this.lightsSet || this.pointLights[i5].intensity != 0.0f) {
                        this.pointLights[i5].intensity = 0.0f;
                    } else {
                        i5++;
                    }
                } else if (!this.lightsSet || !pointLightArr[i5].equals((PointLight) array2.get(i5))) {
                    this.pointLights[i5].set((PointLight) array2.get(i5));
                } else {
                    i5++;
                }
                int i6 = (this.pointLightsSize * i5) + this.pointLightsLoc;
                PointLight[] pointLightArr2 = this.pointLights;
                this.program.setUniformf(this.pointLightsColorOffset + i6, pointLightArr2[i5].color.r * pointLightArr2[i5].intensity, pointLightArr2[i5].color.g * pointLightArr2[i5].intensity, pointLightArr2[i5].color.f3307b * pointLightArr2[i5].intensity);
                PointLight[] pointLightArr3 = this.pointLights;
                this.program.setUniformf(this.pointLightsPositionOffset + i6, pointLightArr3[i5].position.x, pointLightArr3[i5].position.y, pointLightArr3[i5].position.z);
                int i7 = this.pointLightsIntensityOffset;
                if (i7 >= 0) {
                    this.program.setUniformf(i6 + i7, this.pointLights[i5].intensity);
                }
                if (this.pointLightsSize <= 0) {
                    break;
                }
                i5++;
            }
        }
        if (this.spotLightsLoc >= 0) {
            while (true) {
                SpotLight[] spotLightArr = this.spotLights;
                if (i >= spotLightArr.length) {
                    break;
                }
                if (array3 == null || i >= array3.size) {
                    if (!this.lightsSet || this.spotLights[i].intensity != 0.0f) {
                        this.spotLights[i].intensity = 0.0f;
                    } else {
                        i++;
                    }
                } else if (!this.lightsSet || !spotLightArr[i].equals((SpotLight) array3.get(i))) {
                    this.spotLights[i].set((SpotLight) array3.get(i));
                } else {
                    i++;
                }
                int i8 = (this.spotLightsSize * i) + this.spotLightsLoc;
                SpotLight[] spotLightArr2 = this.spotLights;
                this.program.setUniformf(this.spotLightsColorOffset + i8, spotLightArr2[i].color.r * spotLightArr2[i].intensity, spotLightArr2[i].color.g * spotLightArr2[i].intensity, spotLightArr2[i].color.f3307b * spotLightArr2[i].intensity);
                this.program.setUniformf(this.spotLightsPositionOffset + i8, this.spotLights[i].position);
                this.program.setUniformf(this.spotLightsDirectionOffset + i8, this.spotLights[i].direction);
                this.program.setUniformf(this.spotLightsCutoffAngleOffset + i8, this.spotLights[i].cutoffAngle);
                this.program.setUniformf(this.spotLightsExponentOffset + i8, this.spotLights[i].exponent);
                int i9 = this.spotLightsIntensityOffset;
                if (i9 >= 0) {
                    this.program.setUniformf(i8 + i9, this.spotLights[i].intensity);
                }
                if (this.spotLightsSize <= 0) {
                    break;
                }
                i++;
            }
        }
        if (attributes.has(ColorAttribute.Fog)) {
            set(this.u_fogColor, ((ColorAttribute) attributes.get(ColorAttribute.Fog)).color);
        }
        if (environment != null) {
            ShadowMap shadowMap2 = environment.shadowMap;
            if (shadowMap2 != null) {
                set(this.u_shadowMapProjViewTrans, shadowMap2.getProjViewTrans());
                set(this.u_shadowTexture, environment.shadowMap.getDepthMap());
                set(this.u_shadowPCFOffset, 1.0f / (((float) environment.shadowMap.getDepthMap().texture.getWidth()) * 2.0f));
            }
        }
        this.lightsSet = true;
    }

    public void bindMaterial(Attributes attributes) {
        int i = this.config.defaultCullFace;
        if (i == -1) {
            i = defaultCullFace;
        }
        int i2 = this.config.defaultDepthFunc;
        if (i2 == -1) {
            i2 = defaultDepthFunc;
        }
        float f2 = 0.0f;
        float f3 = 1.0f;
        Iterator<Attribute> it = attributes.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Attribute next = it.next();
            long j = next.type;
            if (BlendingAttribute.is(j)) {
                BlendingAttribute blendingAttribute = (BlendingAttribute) next;
                this.context.setBlending(true, blendingAttribute.sourceFunction, blendingAttribute.destFunction);
                set(this.u_opacity, blendingAttribute.opacity);
            } else {
                long j2 = IntAttribute.CullFace;
                if ((j & j2) == j2) {
                    i = ((IntAttribute) next).value;
                } else {
                    long j3 = FloatAttribute.AlphaTest;
                    if ((j & j3) == j3) {
                        set(this.u_alphaTest, ((FloatAttribute) next).value);
                    } else {
                        long j4 = DepthTestAttribute.Type;
                        if ((j & j4) == j4) {
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
            }
        }
        this.context.setCullFace(i);
        this.context.setDepthTest(i2, f2, f3);
        this.context.setDepthMask(z);
    }

    public boolean canRender(Renderable renderable2) {
        if (this.attributesMask == (combineAttributeMasks(renderable2) | optionalAttributes) && this.vertexMask == renderable2.meshPart.mesh.getVertexAttributes().getMaskWithSizePacked()) {
            if ((renderable2.environment != null) == this.lighting) {
                return true;
            }
        }
        return false;
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
        super.end();
    }

    public boolean equals(DefaultShader defaultShader) {
        return defaultShader == this;
    }

    public boolean equals(Object obj) {
        return (obj instanceof DefaultShader) && equals((DefaultShader) obj);
    }

    public int getDefaultCullFace() {
        int i = this.config.defaultCullFace;
        return i == -1 ? defaultCullFace : i;
    }

    public int getDefaultDepthFunc() {
        int i = this.config.defaultDepthFunc;
        return i == -1 ? defaultDepthFunc : i;
    }

    public void init() {
        ShaderProgram shaderProgram = this.program;
        this.program = null;
        init(shaderProgram, this.renderable);
        this.renderable = null;
        this.dirLightsLoc = loc(this.u_dirLights0color);
        this.dirLightsColorOffset = loc(this.u_dirLights0color) - this.dirLightsLoc;
        this.dirLightsDirectionOffset = loc(this.u_dirLights0direction) - this.dirLightsLoc;
        int loc = loc(this.u_dirLights1color) - this.dirLightsLoc;
        this.dirLightsSize = loc;
        if (loc < 0) {
            this.dirLightsSize = 0;
        }
        this.pointLightsLoc = loc(this.u_pointLights0color);
        this.pointLightsColorOffset = loc(this.u_pointLights0color) - this.pointLightsLoc;
        this.pointLightsPositionOffset = loc(this.u_pointLights0position) - this.pointLightsLoc;
        int i = -1;
        this.pointLightsIntensityOffset = has(this.u_pointLights0intensity) ? loc(this.u_pointLights0intensity) - this.pointLightsLoc : -1;
        int loc2 = loc(this.u_pointLights1color) - this.pointLightsLoc;
        this.pointLightsSize = loc2;
        if (loc2 < 0) {
            this.pointLightsSize = 0;
        }
        this.spotLightsLoc = loc(this.u_spotLights0color);
        this.spotLightsColorOffset = loc(this.u_spotLights0color) - this.spotLightsLoc;
        this.spotLightsPositionOffset = loc(this.u_spotLights0position) - this.spotLightsLoc;
        this.spotLightsDirectionOffset = loc(this.u_spotLights0direction) - this.spotLightsLoc;
        if (has(this.u_spotLights0intensity)) {
            i = loc(this.u_spotLights0intensity) - this.spotLightsLoc;
        }
        this.spotLightsIntensityOffset = i;
        this.spotLightsCutoffAngleOffset = loc(this.u_spotLights0cutoffAngle) - this.spotLightsLoc;
        this.spotLightsExponentOffset = loc(this.u_spotLights0exponent) - this.spotLightsLoc;
        int loc3 = loc(this.u_spotLights1color) - this.spotLightsLoc;
        this.spotLightsSize = loc3;
        if (loc3 < 0) {
            this.spotLightsSize = 0;
        }
    }

    public void render(Renderable renderable2, Attributes attributes) {
        if (!attributes.has(BlendingAttribute.Type)) {
            this.context.setBlending(false, GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        }
        bindMaterial(attributes);
        if (this.lighting) {
            bindLights(renderable2, attributes);
        }
        super.render(renderable2, attributes);
    }

    public void setDefaultCullFace(int i) {
        this.config.defaultCullFace = i;
    }

    public void setDefaultDepthFunc(int i) {
        this.config.defaultDepthFunc = i;
    }

    public DefaultShader(Renderable renderable2, Config config2) {
        this(renderable2, config2, createPrefix(renderable2, config2));
    }

    public DefaultShader(Renderable renderable2, Config config2, String str) {
        this(renderable2, config2, str, config2.vertexShader == null ? getDefaultVertexShader() : config2.vertexShader, config2.fragmentShader == null ? getDefaultFragmentShader() : config2.fragmentShader);
    }

    public DefaultShader(Renderable renderable2, Config config2, String str, String str2, String str3) {
        this(renderable2, config2, new ShaderProgram(GeneratedOutlineSupport.outline50(str, str2), GeneratedOutlineSupport.outline50(str, str3)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x015a, code lost:
        r8 = r7.numDirectionalLights;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x015c, code lost:
        if (r8 > 0) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0178, code lost:
        r8 = r7.numPointLights;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x017a, code lost:
        if (r8 > 0) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0196, code lost:
        r8 = r7.numSpotLights;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0198, code lost:
        if (r8 > 0) goto L_0x019c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultShader(com.badlogic.gdx.graphics.g3d.Renderable r6, com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Config r7, com.badlogic.gdx.graphics.glutils.ShaderProgram r8) {
        /*
            r5 = this;
            r5.<init>()
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_dirLights[0].color"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_dirLights0color = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_dirLights[0].direction"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_dirLights0direction = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_dirLights[1].color"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_dirLights1color = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_pointLights[0].color"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_pointLights0color = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_pointLights[0].position"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_pointLights0position = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_pointLights[0].intensity"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_pointLights0intensity = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_pointLights[1].color"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_pointLights1color = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_spotLights[0].color"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_spotLights0color = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_spotLights[0].position"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_spotLights0position = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_spotLights[0].intensity"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_spotLights0intensity = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_spotLights[0].direction"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_spotLights0direction = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_spotLights[0].cutoffAngle"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_spotLights0cutoffAngle = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_spotLights[0].exponent"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_spotLights0exponent = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_spotLights[1].color"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_spotLights1color = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_fogColor"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_fogColor = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_shadowMapProjViewTrans"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_shadowMapProjViewTrans = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_shadowTexture"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_shadowTexture = r0
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r0 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r1 = "u_shadowPCFOffset"
            r0.<init>(r1)
            int r0 = r5.register(r0)
            r5.u_shadowPCFOffset = r0
            com.badlogic.gdx.graphics.g3d.environment.AmbientCubemap r0 = new com.badlogic.gdx.graphics.g3d.environment.AmbientCubemap
            r0.<init>()
            r5.ambientCubemap = r0
            com.badlogic.gdx.math.Matrix3 r0 = new com.badlogic.gdx.math.Matrix3
            r0.<init>()
            r5.normalMatrix = r0
            com.badlogic.gdx.math.Vector3 r0 = new com.badlogic.gdx.math.Vector3
            r0.<init>()
            r5.tmpV1 = r0
            com.badlogic.gdx.graphics.g3d.Attributes r0 = combineAttributes(r6)
            r5.config = r7
            r5.program = r8
            com.badlogic.gdx.graphics.g3d.Environment r8 = r6.environment
            r1 = 1
            r2 = 0
            if (r8 == 0) goto L_0x0112
            r8 = 1
            goto L_0x0113
        L_0x0112:
            r8 = 0
        L_0x0113:
            r5.lighting = r8
            long r3 = com.badlogic.gdx.graphics.g3d.attributes.CubemapAttribute.EnvironmentMap
            boolean r8 = r0.has(r3)
            if (r8 != 0) goto L_0x012c
            boolean r8 = r5.lighting
            if (r8 == 0) goto L_0x012a
            long r3 = com.badlogic.gdx.graphics.g3d.attributes.CubemapAttribute.EnvironmentMap
            boolean r8 = r0.has(r3)
            if (r8 == 0) goto L_0x012a
            goto L_0x012c
        L_0x012a:
            r8 = 0
            goto L_0x012d
        L_0x012c:
            r8 = 1
        L_0x012d:
            r5.environmentCubemap = r8
            boolean r8 = r5.lighting
            if (r8 == 0) goto L_0x013a
            com.badlogic.gdx.graphics.g3d.Environment r8 = r6.environment
            com.badlogic.gdx.graphics.g3d.environment.ShadowMap r8 = r8.shadowMap
            if (r8 == 0) goto L_0x013a
            goto L_0x013b
        L_0x013a:
            r1 = 0
        L_0x013b:
            r5.shadowMap = r1
            r5.renderable = r6
            long r0 = r0.getMask()
            long r3 = optionalAttributes
            long r0 = r0 | r3
            r5.attributesMask = r0
            com.badlogic.gdx.graphics.g3d.model.MeshPart r8 = r6.meshPart
            com.badlogic.gdx.graphics.Mesh r8 = r8.mesh
            com.badlogic.gdx.graphics.VertexAttributes r8 = r8.getVertexAttributes()
            long r0 = r8.getMaskWithSizePacked()
            r5.vertexMask = r0
            boolean r8 = r5.lighting
            if (r8 == 0) goto L_0x015f
            int r8 = r7.numDirectionalLights
            if (r8 <= 0) goto L_0x015f
            goto L_0x0160
        L_0x015f:
            r8 = 0
        L_0x0160:
            com.badlogic.gdx.graphics.g3d.environment.DirectionalLight[] r8 = new com.badlogic.gdx.graphics.g3d.environment.DirectionalLight[r8]
            r5.directionalLights = r8
            r8 = 0
        L_0x0165:
            com.badlogic.gdx.graphics.g3d.environment.DirectionalLight[] r0 = r5.directionalLights
            int r1 = r0.length
            if (r8 >= r1) goto L_0x0174
            com.badlogic.gdx.graphics.g3d.environment.DirectionalLight r1 = new com.badlogic.gdx.graphics.g3d.environment.DirectionalLight
            r1.<init>()
            r0[r8] = r1
            int r8 = r8 + 1
            goto L_0x0165
        L_0x0174:
            boolean r8 = r5.lighting
            if (r8 == 0) goto L_0x017d
            int r8 = r7.numPointLights
            if (r8 <= 0) goto L_0x017d
            goto L_0x017e
        L_0x017d:
            r8 = 0
        L_0x017e:
            com.badlogic.gdx.graphics.g3d.environment.PointLight[] r8 = new com.badlogic.gdx.graphics.g3d.environment.PointLight[r8]
            r5.pointLights = r8
            r8 = 0
        L_0x0183:
            com.badlogic.gdx.graphics.g3d.environment.PointLight[] r0 = r5.pointLights
            int r1 = r0.length
            if (r8 >= r1) goto L_0x0192
            com.badlogic.gdx.graphics.g3d.environment.PointLight r1 = new com.badlogic.gdx.graphics.g3d.environment.PointLight
            r1.<init>()
            r0[r8] = r1
            int r8 = r8 + 1
            goto L_0x0183
        L_0x0192:
            boolean r8 = r5.lighting
            if (r8 == 0) goto L_0x019b
            int r8 = r7.numSpotLights
            if (r8 <= 0) goto L_0x019b
            goto L_0x019c
        L_0x019b:
            r8 = 0
        L_0x019c:
            com.badlogic.gdx.graphics.g3d.environment.SpotLight[] r8 = new com.badlogic.gdx.graphics.g3d.environment.SpotLight[r8]
            r5.spotLights = r8
        L_0x01a0:
            com.badlogic.gdx.graphics.g3d.environment.SpotLight[] r8 = r5.spotLights
            int r0 = r8.length
            if (r2 >= r0) goto L_0x01af
            com.badlogic.gdx.graphics.g3d.environment.SpotLight r0 = new com.badlogic.gdx.graphics.g3d.environment.SpotLight
            r0.<init>()
            r8[r2] = r0
            int r2 = r2 + 1
            goto L_0x01a0
        L_0x01af:
            boolean r8 = r7.ignoreUnimplemented
            if (r8 != 0) goto L_0x01d1
            long r0 = implementedFlags
            long r2 = r5.attributesMask
            long r0 = r0 & r2
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x01bd
            goto L_0x01d1
        L_0x01bd:
            com.badlogic.gdx.utils.GdxRuntimeException r6 = new com.badlogic.gdx.utils.GdxRuntimeException
            java.lang.String r7 = "Some attributes not implemented yet ("
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r7)
            long r0 = r5.attributesMask
            java.lang.String r8 = ")"
            java.lang.String r7 = com.android.tools.r8.GeneratedOutlineSupport.outline58(r7, r0, r8)
            r6.<init>(r7)
            throw r6
        L_0x01d1:
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r8 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.projTrans
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.projTrans
            int r8 = r5.register(r8, r0)
            r5.u_projTrans = r8
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r8 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.viewTrans
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.viewTrans
            int r8 = r5.register(r8, r0)
            r5.u_viewTrans = r8
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r8 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.projViewTrans
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.projViewTrans
            int r8 = r5.register(r8, r0)
            r5.u_projViewTrans = r8
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r8 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.cameraPosition
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.cameraPosition
            int r8 = r5.register(r8, r0)
            r5.u_cameraPosition = r8
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r8 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.cameraDirection
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.cameraDirection
            int r8 = r5.register(r8, r0)
            r5.u_cameraDirection = r8
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r8 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.cameraUp
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.cameraUp
            int r8 = r5.register(r8, r0)
            r5.u_cameraUp = r8
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r8 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.cameraNearFar
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.cameraNearFar
            int r8 = r5.register(r8, r0)
            r5.u_cameraNearFar = r8
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r8 = new com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform
            java.lang.String r0 = "u_time"
            r8.<init>(r0)
            int r8 = r5.register(r8)
            r5.u_time = r8
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r8 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.worldTrans
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.worldTrans
            int r8 = r5.register(r8, r0)
            r5.u_worldTrans = r8
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r8 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.viewWorldTrans
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.viewWorldTrans
            int r8 = r5.register(r8, r0)
            r5.u_viewWorldTrans = r8
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r8 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.projViewWorldTrans
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.projViewWorldTrans
            int r8 = r5.register(r8, r0)
            r5.u_projViewWorldTrans = r8
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r8 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.normalMatrix
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.normalMatrix
            int r8 = r5.register(r8, r0)
            r5.u_normalMatrix = r8
            com.badlogic.gdx.math.Matrix4[] r6 = r6.bones
            r8 = -1
            if (r6 == 0) goto L_0x0263
            int r6 = r7.numBones
            if (r6 <= 0) goto L_0x0263
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.bones
            com.badlogic.gdx.graphics.g3d.shaders.DefaultShader$Setters$Bones r0 = new com.badlogic.gdx.graphics.g3d.shaders.DefaultShader$Setters$Bones
            int r1 = r7.numBones
            r0.<init>(r1)
            int r6 = r5.register(r6, r0)
            goto L_0x0264
        L_0x0263:
            r6 = -1
        L_0x0264:
            r5.u_bones = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.shininess
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.shininess
            int r6 = r5.register(r6, r0)
            r5.u_shininess = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.opacity
            int r6 = r5.register(r6)
            r5.u_opacity = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.diffuseColor
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.diffuseColor
            int r6 = r5.register(r6, r0)
            r5.u_diffuseColor = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.diffuseTexture
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.diffuseTexture
            int r6 = r5.register(r6, r0)
            r5.u_diffuseTexture = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.diffuseUVTransform
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.diffuseUVTransform
            int r6 = r5.register(r6, r0)
            r5.u_diffuseUVTransform = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.specularColor
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.specularColor
            int r6 = r5.register(r6, r0)
            r5.u_specularColor = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.specularTexture
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.specularTexture
            int r6 = r5.register(r6, r0)
            r5.u_specularTexture = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.specularUVTransform
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.specularUVTransform
            int r6 = r5.register(r6, r0)
            r5.u_specularUVTransform = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.emissiveColor
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.emissiveColor
            int r6 = r5.register(r6, r0)
            r5.u_emissiveColor = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.emissiveTexture
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.emissiveTexture
            int r6 = r5.register(r6, r0)
            r5.u_emissiveTexture = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.emissiveUVTransform
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.emissiveUVTransform
            int r6 = r5.register(r6, r0)
            r5.u_emissiveUVTransform = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.reflectionColor
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.reflectionColor
            int r6 = r5.register(r6, r0)
            r5.u_reflectionColor = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.reflectionTexture
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.reflectionTexture
            int r6 = r5.register(r6, r0)
            r5.u_reflectionTexture = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.reflectionUVTransform
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.reflectionUVTransform
            int r6 = r5.register(r6, r0)
            r5.u_reflectionUVTransform = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.normalTexture
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.normalTexture
            int r6 = r5.register(r6, r0)
            r5.u_normalTexture = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.normalUVTransform
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.normalUVTransform
            int r6 = r5.register(r6, r0)
            r5.u_normalUVTransform = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.ambientTexture
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.ambientTexture
            int r6 = r5.register(r6, r0)
            r5.u_ambientTexture = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.ambientUVTransform
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r0 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.ambientUVTransform
            int r6 = r5.register(r6, r0)
            r5.u_ambientUVTransform = r6
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.alphaTest
            int r6 = r5.register(r6)
            r5.u_alphaTest = r6
            boolean r6 = r5.lighting
            if (r6 == 0) goto L_0x0334
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.ambientCube
            com.badlogic.gdx.graphics.g3d.shaders.DefaultShader$Setters$ACubemap r0 = new com.badlogic.gdx.graphics.g3d.shaders.DefaultShader$Setters$ACubemap
            int r1 = r7.numDirectionalLights
            int r7 = r7.numPointLights
            r0.<init>(r1, r7)
            int r6 = r5.register(r6, r0)
            goto L_0x0335
        L_0x0334:
            r6 = -1
        L_0x0335:
            r5.u_ambientCubemap = r6
            boolean r6 = r5.environmentCubemap
            if (r6 == 0) goto L_0x0343
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Uniform r6 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Inputs.environmentCubemap
            com.badlogic.gdx.graphics.g3d.shaders.BaseShader$Setter r7 = com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.Setters.environmentCubemap
            int r8 = r5.register(r6, r7)
        L_0x0343:
            r5.u_environmentCubemap = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g3d.shaders.DefaultShader.<init>(com.badlogic.gdx.graphics.g3d.Renderable, com.badlogic.gdx.graphics.g3d.shaders.DefaultShader$Config, com.badlogic.gdx.graphics.glutils.ShaderProgram):void");
    }
}
