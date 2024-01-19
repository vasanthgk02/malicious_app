package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class TextureAttribute extends Attribute {
    public static final long Ambient = Attribute.register(AmbientAlias);
    public static final String AmbientAlias = "ambientTexture";
    public static final long Bump = Attribute.register(BumpAlias);
    public static final String BumpAlias = "bumpTexture";
    public static final long Diffuse = Attribute.register(DiffuseAlias);
    public static final String DiffuseAlias = "diffuseTexture";
    public static final long Emissive = Attribute.register(EmissiveAlias);
    public static final String EmissiveAlias = "emissiveTexture";
    public static long Mask = 0;
    public static final long Normal = Attribute.register(NormalAlias);
    public static final String NormalAlias = "normalTexture";
    public static final long Reflection;
    public static final String ReflectionAlias = "reflectionTexture";
    public static final long Specular = Attribute.register(SpecularAlias);
    public static final String SpecularAlias = "specularTexture";
    public float offsetU;
    public float offsetV;
    public float scaleU;
    public float scaleV;
    public final TextureDescriptor<Texture> textureDescription;
    public int uvIndex;

    static {
        long register = Attribute.register(ReflectionAlias);
        Reflection = register;
        Mask = register | Diffuse | Specular | Bump | Normal | Ambient | Emissive;
    }

    public TextureAttribute(long j) {
        super(j);
        this.offsetU = 0.0f;
        this.offsetV = 0.0f;
        this.scaleU = 1.0f;
        this.scaleV = 1.0f;
        this.uvIndex = 0;
        if (is(j)) {
            this.textureDescription = new TextureDescriptor<>();
            return;
        }
        throw new GdxRuntimeException((String) "Invalid type specified");
    }

    public static TextureAttribute createAmbient(Texture texture) {
        return new TextureAttribute(Ambient, texture);
    }

    public static TextureAttribute createBump(Texture texture) {
        return new TextureAttribute(Bump, texture);
    }

    public static TextureAttribute createDiffuse(Texture texture) {
        return new TextureAttribute(Diffuse, texture);
    }

    public static TextureAttribute createEmissive(Texture texture) {
        return new TextureAttribute(Emissive, texture);
    }

    public static TextureAttribute createNormal(Texture texture) {
        return new TextureAttribute(Normal, texture);
    }

    public static TextureAttribute createReflection(Texture texture) {
        return new TextureAttribute(Reflection, texture);
    }

    public static TextureAttribute createSpecular(Texture texture) {
        return new TextureAttribute(Specular, texture);
    }

    public static final boolean is(long j) {
        return (j & Mask) != 0;
    }

    public Attribute copy() {
        return new TextureAttribute(this);
    }

    public int hashCode() {
        return ((((((((((this.textureDescription.hashCode() + (super.hashCode() * 991)) * 991) + Float.floatToRawIntBits(this.offsetU)) * 991) + Float.floatToRawIntBits(this.offsetV)) * 991) + Float.floatToRawIntBits(this.scaleU)) * 991) + Float.floatToRawIntBits(this.scaleV)) * 991) + this.uvIndex;
    }

    public void set(TextureRegion textureRegion) {
        this.textureDescription.texture = textureRegion.getTexture();
        this.offsetU = textureRegion.getU();
        this.offsetV = textureRegion.getV();
        this.scaleU = textureRegion.getU2() - this.offsetU;
        this.scaleV = textureRegion.getV2() - this.offsetV;
    }

    public static TextureAttribute createAmbient(TextureRegion textureRegion) {
        return new TextureAttribute(Ambient, textureRegion);
    }

    public static TextureAttribute createBump(TextureRegion textureRegion) {
        return new TextureAttribute(Bump, textureRegion);
    }

    public static TextureAttribute createDiffuse(TextureRegion textureRegion) {
        return new TextureAttribute(Diffuse, textureRegion);
    }

    public static TextureAttribute createEmissive(TextureRegion textureRegion) {
        return new TextureAttribute(Emissive, textureRegion);
    }

    public static TextureAttribute createNormal(TextureRegion textureRegion) {
        return new TextureAttribute(Normal, textureRegion);
    }

    public static TextureAttribute createReflection(TextureRegion textureRegion) {
        return new TextureAttribute(Reflection, textureRegion);
    }

    public static TextureAttribute createSpecular(TextureRegion textureRegion) {
        return new TextureAttribute(Specular, textureRegion);
    }

    public int compareTo(Attribute attribute) {
        long j = this.type;
        long j2 = attribute.type;
        int i = -1;
        if (j != j2) {
            if (j >= j2) {
                i = 1;
            }
            return i;
        }
        TextureAttribute textureAttribute = (TextureAttribute) attribute;
        int compareTo = this.textureDescription.compareTo(textureAttribute.textureDescription);
        if (compareTo != 0) {
            return compareTo;
        }
        int i2 = this.uvIndex;
        int i3 = textureAttribute.uvIndex;
        if (i2 != i3) {
            return i2 - i3;
        }
        if (!MathUtils.isEqual(this.scaleU, textureAttribute.scaleU)) {
            if (this.scaleU > textureAttribute.scaleU) {
                i = 1;
            }
            return i;
        } else if (!MathUtils.isEqual(this.scaleV, textureAttribute.scaleV)) {
            if (this.scaleV > textureAttribute.scaleV) {
                i = 1;
            }
            return i;
        } else if (!MathUtils.isEqual(this.offsetU, textureAttribute.offsetU)) {
            if (this.offsetU > textureAttribute.offsetU) {
                i = 1;
            }
            return i;
        } else if (MathUtils.isEqual(this.offsetV, textureAttribute.offsetV)) {
            return 0;
        } else {
            if (this.offsetV > textureAttribute.offsetV) {
                i = 1;
            }
            return i;
        }
    }

    public <T extends Texture> TextureAttribute(long j, TextureDescriptor<T> textureDescriptor) {
        this(j);
        this.textureDescription.set(textureDescriptor);
    }

    public <T extends Texture> TextureAttribute(long j, TextureDescriptor<T> textureDescriptor, float f2, float f3, float f4, float f5, int i) {
        this(j, textureDescriptor);
        this.offsetU = f2;
        this.offsetV = f3;
        this.scaleU = f4;
        this.scaleV = f5;
        this.uvIndex = i;
    }

    public <T extends Texture> TextureAttribute(long j, TextureDescriptor<T> textureDescriptor, float f2, float f3, float f4, float f5) {
        this(j, textureDescriptor, f2, f3, f4, f5, 0);
    }

    public TextureAttribute(long j, Texture texture) {
        this(j);
        this.textureDescription.texture = texture;
    }

    public TextureAttribute(long j, TextureRegion textureRegion) {
        this(j);
        set(textureRegion);
    }

    public TextureAttribute(TextureAttribute textureAttribute) {
        this(textureAttribute.type, textureAttribute.textureDescription, textureAttribute.offsetU, textureAttribute.offsetV, textureAttribute.scaleU, textureAttribute.scaleV, textureAttribute.uvIndex);
    }
}
