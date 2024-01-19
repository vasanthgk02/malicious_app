package com.badlogic.gdx.graphics.g3d.utils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.IntBuffer;

public final class DefaultTextureBinder implements TextureBinder {
    public static final int LRU = 1;
    public static final int MAX_GLES_UNITS = 32;
    public static final int ROUNDROBIN = 0;
    public int bindCount;
    public final int count;
    public int currentTexture;
    public final int method;
    public final int offset;
    public int reuseCount;
    public boolean reused;
    public final TextureDescriptor tempDesc;
    public final GLTexture[] textures;
    public int[] unitsLRU;

    public DefaultTextureBinder(int i) {
        this(i, 0);
    }

    private final int bindTexture(TextureDescriptor textureDescriptor, boolean z) {
        int i;
        int i2;
        T t = textureDescriptor.texture;
        this.reused = false;
        int i3 = this.method;
        if (i3 == 0) {
            i2 = this.offset;
            i = bindTextureRoundRobin(t);
        } else if (i3 != 1) {
            return -1;
        } else {
            i2 = this.offset;
            i = bindTextureLRU(t);
        }
        int i4 = i2 + i;
        if (this.reused) {
            this.reuseCount++;
            if (z) {
                t.bind(i4);
            } else {
                k.gl.glActiveTexture(GL20.GL_TEXTURE0 + i4);
            }
        } else {
            this.bindCount++;
        }
        t.unsafeSetWrap(textureDescriptor.uWrap, textureDescriptor.vWrap);
        t.unsafeSetFilter(textureDescriptor.minFilter, textureDescriptor.magFilter);
        return i4;
    }

    private final int bindTextureLRU(GLTexture gLTexture) {
        int i = 0;
        while (true) {
            if (i >= this.count) {
                break;
            }
            int i2 = this.unitsLRU[i];
            GLTexture[] gLTextureArr = this.textures;
            if (gLTextureArr[i2] == gLTexture) {
                this.reused = true;
                break;
            } else if (gLTextureArr[i2] == null) {
                break;
            } else {
                i++;
            }
        }
        int i3 = this.count;
        if (i >= i3) {
            i = i3 - 1;
        }
        int i4 = this.unitsLRU[i];
        while (i > 0) {
            int[] iArr = this.unitsLRU;
            iArr[i] = iArr[i - 1];
            i--;
        }
        this.unitsLRU[0] = i4;
        if (!this.reused) {
            this.textures[i4] = gLTexture;
            gLTexture.bind(this.offset + i4);
        }
        return i4;
    }

    private final int bindTextureRoundRobin(GLTexture gLTexture) {
        int i = 0;
        while (true) {
            int i2 = this.count;
            if (i < i2) {
                int i3 = (this.currentTexture + i) % i2;
                if (this.textures[i3] == gLTexture) {
                    this.reused = true;
                    return i3;
                }
                i++;
            } else {
                int i4 = (this.currentTexture + 1) % i2;
                this.currentTexture = i4;
                this.textures[i4] = gLTexture;
                gLTexture.bind(this.offset + i4);
                return this.currentTexture;
            }
        }
    }

    public static int getMaxTextureUnits() {
        IntBuffer newIntBuffer = BufferUtils.newIntBuffer(16);
        k.gl.glGetIntegerv(GL20.GL_MAX_TEXTURE_IMAGE_UNITS, newIntBuffer);
        return newIntBuffer.get(0);
    }

    public void begin() {
        for (int i = 0; i < this.count; i++) {
            this.textures[i] = null;
            int[] iArr = this.unitsLRU;
            if (iArr != null) {
                iArr[i] = i;
            }
        }
    }

    public final int bind(TextureDescriptor textureDescriptor) {
        return bindTexture(textureDescriptor, false);
    }

    public void end() {
        k.gl.glActiveTexture(GL20.GL_TEXTURE0);
    }

    public final int getBindCount() {
        return this.bindCount;
    }

    public final int getReuseCount() {
        return this.reuseCount;
    }

    public final void resetCounts() {
        this.reuseCount = 0;
        this.bindCount = 0;
    }

    public DefaultTextureBinder(int i, int i2) {
        this(i, i2, -1);
    }

    public final int bind(GLTexture gLTexture) {
        this.tempDesc.set(gLTexture, null, null, null, null);
        return bindTexture(this.tempDesc, false);
    }

    public DefaultTextureBinder(int i, int i2, int i3) {
        this.reuseCount = 0;
        this.bindCount = 0;
        this.tempDesc = new TextureDescriptor();
        this.currentTexture = 0;
        int min = Math.min(getMaxTextureUnits(), 32);
        i3 = i3 < 0 ? min - i2 : i3;
        if (i2 < 0 || i3 < 0 || i2 + i3 > min) {
            throw new GdxRuntimeException((String) "Illegal arguments");
        }
        this.method = i;
        this.offset = i2;
        this.count = i3;
        this.textures = new GLTexture[i3];
        this.unitsLRU = i == 1 ? new int[i3] : null;
    }
}
