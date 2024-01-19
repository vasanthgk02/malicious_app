package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class CubemapAttribute extends Attribute {
    public static final long EnvironmentMap;
    public static final String EnvironmentMapAlias = "environmentCubemap";
    public static long Mask;
    public final TextureDescriptor<Cubemap> textureDescription;

    static {
        long register = Attribute.register(EnvironmentMapAlias);
        EnvironmentMap = register;
        Mask = register;
    }

    public CubemapAttribute(long j) {
        super(j);
        if (is(j)) {
            this.textureDescription = new TextureDescriptor<>();
            return;
        }
        throw new GdxRuntimeException((String) "Invalid type specified");
    }

    public static final boolean is(long j) {
        return (j & Mask) != 0;
    }

    public Attribute copy() {
        return new CubemapAttribute(this);
    }

    public int hashCode() {
        return this.textureDescription.hashCode() + (super.hashCode() * 967);
    }

    public int compareTo(Attribute attribute) {
        long j = this.type;
        long j2 = attribute.type;
        if (j != j2) {
            return (int) (j - j2);
        }
        return this.textureDescription.compareTo(((CubemapAttribute) attribute).textureDescription);
    }

    public <T extends Cubemap> CubemapAttribute(long j, TextureDescriptor<T> textureDescriptor) {
        this(j);
        this.textureDescription.set(textureDescriptor);
    }

    public CubemapAttribute(long j, Cubemap cubemap) {
        this(j);
        this.textureDescription.texture = cubemap;
    }

    public CubemapAttribute(CubemapAttribute cubemapAttribute) {
        this(cubemapAttribute.type, cubemapAttribute.textureDescription);
    }
}
