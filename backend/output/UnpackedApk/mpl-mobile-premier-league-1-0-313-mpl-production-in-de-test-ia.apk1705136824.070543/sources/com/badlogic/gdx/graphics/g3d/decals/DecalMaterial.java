package com.badlogic.gdx.graphics.g3d.decals;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DecalMaterial {
    public static final int NO_BLEND = -1;
    public int dstBlendFactor;
    public int srcBlendFactor;
    public TextureRegion textureRegion;

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        DecalMaterial decalMaterial = (DecalMaterial) obj;
        if (this.dstBlendFactor == decalMaterial.dstBlendFactor && this.srcBlendFactor == decalMaterial.srcBlendFactor && this.textureRegion.getTexture() == decalMaterial.textureRegion.getTexture()) {
            z = true;
        }
        return z;
    }

    public int getDstBlendFactor() {
        return this.dstBlendFactor;
    }

    public int getSrcBlendFactor() {
        return this.srcBlendFactor;
    }

    public int hashCode() {
        return ((((this.textureRegion.getTexture() != null ? this.textureRegion.getTexture().hashCode() : 0) * 31) + this.srcBlendFactor) * 31) + this.dstBlendFactor;
    }

    public boolean isOpaque() {
        return this.srcBlendFactor == -1;
    }

    public void set() {
        this.textureRegion.getTexture().bind(0);
        if (!isOpaque()) {
            k.gl.glBlendFunc(this.srcBlendFactor, this.dstBlendFactor);
        }
    }
}
