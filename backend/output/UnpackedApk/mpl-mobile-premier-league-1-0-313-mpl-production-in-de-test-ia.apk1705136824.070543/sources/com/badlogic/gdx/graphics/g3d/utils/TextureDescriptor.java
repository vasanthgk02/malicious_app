package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class TextureDescriptor<T extends GLTexture> implements Comparable<TextureDescriptor<T>> {
    public TextureFilter magFilter;
    public TextureFilter minFilter;
    public T texture;
    public TextureWrap uWrap;
    public TextureWrap vWrap;

    public TextureDescriptor(T t, TextureFilter textureFilter, TextureFilter textureFilter2, TextureWrap textureWrap, TextureWrap textureWrap2) {
        this.texture = null;
        set(t, textureFilter, textureFilter2, textureWrap, textureWrap2);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextureDescriptor)) {
            return false;
        }
        TextureDescriptor textureDescriptor = (TextureDescriptor) obj;
        if (textureDescriptor.texture == this.texture && textureDescriptor.minFilter == this.minFilter && textureDescriptor.magFilter == this.magFilter && textureDescriptor.uWrap == this.uWrap && textureDescriptor.vWrap == this.vWrap) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        T t = this.texture;
        int i = 0;
        long j = ((long) (t == null ? 0 : t.glTarget)) * 811;
        T t2 = this.texture;
        long textureObjectHandle = (j + ((long) (t2 == null ? 0 : t2.getTextureObjectHandle()))) * 811;
        TextureFilter textureFilter = this.minFilter;
        long gLEnum = (textureObjectHandle + ((long) (textureFilter == null ? 0 : textureFilter.getGLEnum()))) * 811;
        TextureFilter textureFilter2 = this.magFilter;
        long gLEnum2 = (gLEnum + ((long) (textureFilter2 == null ? 0 : textureFilter2.getGLEnum()))) * 811;
        TextureWrap textureWrap = this.uWrap;
        long gLEnum3 = (gLEnum2 + ((long) (textureWrap == null ? 0 : textureWrap.getGLEnum()))) * 811;
        TextureWrap textureWrap2 = this.vWrap;
        if (textureWrap2 != null) {
            i = textureWrap2.getGLEnum();
        }
        long j2 = gLEnum3 + ((long) i);
        return (int) ((j2 >> 32) ^ j2);
    }

    public void set(T t, TextureFilter textureFilter, TextureFilter textureFilter2, TextureWrap textureWrap, TextureWrap textureWrap2) {
        this.texture = t;
        this.minFilter = textureFilter;
        this.magFilter = textureFilter2;
        this.uWrap = textureWrap;
        this.vWrap = textureWrap2;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor<T>, code=com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor, for r4v0, types: [com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor<T>, com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != r3) goto L_0x0004
            return r0
        L_0x0004:
            T r1 = r3.texture
            if (r1 != 0) goto L_0x000a
            r1 = 0
            goto L_0x000c
        L_0x000a:
            int r1 = r1.glTarget
        L_0x000c:
            T r2 = r4.texture
            if (r2 != 0) goto L_0x0012
            r2 = 0
            goto L_0x0014
        L_0x0012:
            int r2 = r2.glTarget
        L_0x0014:
            if (r1 == r2) goto L_0x0018
            int r1 = r1 - r2
            return r1
        L_0x0018:
            T r1 = r3.texture
            if (r1 != 0) goto L_0x001e
            r1 = 0
            goto L_0x0022
        L_0x001e:
            int r1 = r1.getTextureObjectHandle()
        L_0x0022:
            T r2 = r4.texture
            if (r2 != 0) goto L_0x0028
            r2 = 0
            goto L_0x002c
        L_0x0028:
            int r2 = r2.getTextureObjectHandle()
        L_0x002c:
            if (r1 == r2) goto L_0x0030
            int r1 = r1 - r2
            return r1
        L_0x0030:
            com.badlogic.gdx.graphics.Texture$TextureFilter r1 = r3.minFilter
            com.badlogic.gdx.graphics.Texture$TextureFilter r2 = r4.minFilter
            if (r1 == r2) goto L_0x0049
            if (r1 != 0) goto L_0x003a
            r1 = 0
            goto L_0x003e
        L_0x003a:
            int r1 = r1.getGLEnum()
        L_0x003e:
            com.badlogic.gdx.graphics.Texture$TextureFilter r4 = r4.minFilter
            if (r4 != 0) goto L_0x0043
            goto L_0x0047
        L_0x0043:
            int r0 = r4.getGLEnum()
        L_0x0047:
            int r1 = r1 - r0
            return r1
        L_0x0049:
            com.badlogic.gdx.graphics.Texture$TextureFilter r1 = r3.magFilter
            com.badlogic.gdx.graphics.Texture$TextureFilter r2 = r4.magFilter
            if (r1 == r2) goto L_0x0062
            if (r1 != 0) goto L_0x0053
            r1 = 0
            goto L_0x0057
        L_0x0053:
            int r1 = r1.getGLEnum()
        L_0x0057:
            com.badlogic.gdx.graphics.Texture$TextureFilter r4 = r4.magFilter
            if (r4 != 0) goto L_0x005c
            goto L_0x0060
        L_0x005c:
            int r0 = r4.getGLEnum()
        L_0x0060:
            int r1 = r1 - r0
            return r1
        L_0x0062:
            com.badlogic.gdx.graphics.Texture$TextureWrap r1 = r3.uWrap
            com.badlogic.gdx.graphics.Texture$TextureWrap r2 = r4.uWrap
            if (r1 == r2) goto L_0x007b
            if (r1 != 0) goto L_0x006c
            r1 = 0
            goto L_0x0070
        L_0x006c:
            int r1 = r1.getGLEnum()
        L_0x0070:
            com.badlogic.gdx.graphics.Texture$TextureWrap r4 = r4.uWrap
            if (r4 != 0) goto L_0x0075
            goto L_0x0079
        L_0x0075:
            int r0 = r4.getGLEnum()
        L_0x0079:
            int r1 = r1 - r0
            return r1
        L_0x007b:
            com.badlogic.gdx.graphics.Texture$TextureWrap r1 = r3.vWrap
            com.badlogic.gdx.graphics.Texture$TextureWrap r2 = r4.vWrap
            if (r1 == r2) goto L_0x0094
            if (r1 != 0) goto L_0x0085
            r1 = 0
            goto L_0x0089
        L_0x0085:
            int r1 = r1.getGLEnum()
        L_0x0089:
            com.badlogic.gdx.graphics.Texture$TextureWrap r4 = r4.vWrap
            if (r4 != 0) goto L_0x008e
            goto L_0x0092
        L_0x008e:
            int r0 = r4.getGLEnum()
        L_0x0092:
            int r1 = r1 - r0
            return r1
        L_0x0094:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor.compareTo(com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor):int");
    }

    public TextureDescriptor(T t) {
        this(t, null, null, null, null);
    }

    public TextureDescriptor() {
        this.texture = null;
    }

    public <V extends T> void set(TextureDescriptor<V> textureDescriptor) {
        this.texture = textureDescriptor.texture;
        this.minFilter = textureDescriptor.minFilter;
        this.magFilter = textureDescriptor.magFilter;
        this.uWrap = textureDescriptor.uWrap;
        this.vWrap = textureDescriptor.vWrap;
    }
}
