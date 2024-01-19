package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ColorAttribute extends Attribute {
    public static final long Ambient = Attribute.register(AmbientAlias);
    public static final String AmbientAlias = "ambientColor";
    public static final long AmbientLight = Attribute.register(AmbientLightAlias);
    public static final String AmbientLightAlias = "ambientLightColor";
    public static final long Diffuse = Attribute.register(DiffuseAlias);
    public static final String DiffuseAlias = "diffuseColor";
    public static final long Emissive = Attribute.register(EmissiveAlias);
    public static final String EmissiveAlias = "emissiveColor";
    public static final long Fog;
    public static final String FogAlias = "fogColor";
    public static long Mask = 0;
    public static final long Reflection = Attribute.register(ReflectionAlias);
    public static final String ReflectionAlias = "reflectionColor";
    public static final long Specular = Attribute.register(SpecularAlias);
    public static final String SpecularAlias = "specularColor";
    public final Color color;

    static {
        long register = Attribute.register(FogAlias);
        Fog = register;
        Mask = register | Ambient | Diffuse | Specular | Emissive | Reflection | AmbientLight;
    }

    public ColorAttribute(long j) {
        super(j);
        this.color = new Color();
        if (!is(j)) {
            throw new GdxRuntimeException((String) "Invalid type specified");
        }
    }

    public static final ColorAttribute createAmbient(Color color2) {
        return new ColorAttribute(Ambient, color2);
    }

    public static final ColorAttribute createAmbientLight(Color color2) {
        return new ColorAttribute(AmbientLight, color2);
    }

    public static final ColorAttribute createDiffuse(Color color2) {
        return new ColorAttribute(Diffuse, color2);
    }

    public static final ColorAttribute createEmissive(Color color2) {
        return new ColorAttribute(Emissive, color2);
    }

    public static final ColorAttribute createFog(Color color2) {
        return new ColorAttribute(Fog, color2);
    }

    public static final ColorAttribute createReflection(Color color2) {
        return new ColorAttribute(Reflection, color2);
    }

    public static final ColorAttribute createSpecular(Color color2) {
        return new ColorAttribute(Specular, color2);
    }

    public static final boolean is(long j) {
        return (j & Mask) != 0;
    }

    public Attribute copy() {
        return new ColorAttribute(this);
    }

    public int hashCode() {
        return this.color.toIntBits() + (super.hashCode() * 953);
    }

    public static final ColorAttribute createAmbient(float f2, float f3, float f4, float f5) {
        ColorAttribute colorAttribute = new ColorAttribute(Ambient, f2, f3, f4, f5);
        return colorAttribute;
    }

    public static final ColorAttribute createAmbientLight(float f2, float f3, float f4, float f5) {
        ColorAttribute colorAttribute = new ColorAttribute(AmbientLight, f2, f3, f4, f5);
        return colorAttribute;
    }

    public static final ColorAttribute createDiffuse(float f2, float f3, float f4, float f5) {
        ColorAttribute colorAttribute = new ColorAttribute(Diffuse, f2, f3, f4, f5);
        return colorAttribute;
    }

    public static final ColorAttribute createEmissive(float f2, float f3, float f4, float f5) {
        ColorAttribute colorAttribute = new ColorAttribute(Emissive, f2, f3, f4, f5);
        return colorAttribute;
    }

    public static final ColorAttribute createFog(float f2, float f3, float f4, float f5) {
        ColorAttribute colorAttribute = new ColorAttribute(Fog, f2, f3, f4, f5);
        return colorAttribute;
    }

    public static final ColorAttribute createReflection(float f2, float f3, float f4, float f5) {
        ColorAttribute colorAttribute = new ColorAttribute(Reflection, f2, f3, f4, f5);
        return colorAttribute;
    }

    public static final ColorAttribute createSpecular(float f2, float f3, float f4, float f5) {
        ColorAttribute colorAttribute = new ColorAttribute(Specular, f2, f3, f4, f5);
        return colorAttribute;
    }

    public int compareTo(Attribute attribute) {
        long j = this.type;
        long j2 = attribute.type;
        if (j != j2) {
            return (int) (j - j2);
        }
        return ((ColorAttribute) attribute).color.toIntBits() - this.color.toIntBits();
    }

    public ColorAttribute(long j, Color color2) {
        this(j);
        if (color2 != null) {
            this.color.set(color2);
        }
    }

    public ColorAttribute(long j, float f2, float f3, float f4, float f5) {
        this(j);
        this.color.set(f2, f3, f4, f5);
    }

    public ColorAttribute(ColorAttribute colorAttribute) {
        this(colorAttribute.type, colorAttribute.color);
    }
}
