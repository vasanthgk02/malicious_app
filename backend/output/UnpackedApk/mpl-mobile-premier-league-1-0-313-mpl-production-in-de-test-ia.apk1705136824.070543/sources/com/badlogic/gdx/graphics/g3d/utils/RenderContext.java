package com.badlogic.gdx.graphics.g3d.utils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.GL20;

public class RenderContext {
    public int blendDFactor;
    public int blendSFactor;
    public boolean blending;
    public int cullFace;
    public int depthFunc;
    public boolean depthMask;
    public float depthRangeFar;
    public float depthRangeNear;
    public final TextureBinder textureBinder;

    public RenderContext(TextureBinder textureBinder2) {
        this.textureBinder = textureBinder2;
    }

    public void begin() {
        k.gl.glDisable(GL20.GL_DEPTH_TEST);
        this.depthFunc = 0;
        k.gl.glDepthMask(true);
        this.depthMask = true;
        k.gl.glDisable(GL20.GL_BLEND);
        this.blending = false;
        k.gl.glDisable(GL20.GL_CULL_FACE);
        this.blendDFactor = 0;
        this.blendSFactor = 0;
        this.cullFace = 0;
        this.textureBinder.begin();
    }

    public void end() {
        if (this.depthFunc != 0) {
            k.gl.glDisable(GL20.GL_DEPTH_TEST);
        }
        if (!this.depthMask) {
            k.gl.glDepthMask(true);
        }
        if (this.blending) {
            k.gl.glDisable(GL20.GL_BLEND);
        }
        if (this.cullFace > 0) {
            k.gl.glDisable(GL20.GL_CULL_FACE);
        }
        this.textureBinder.end();
    }

    public void setBlending(boolean z, int i, int i2) {
        if (z != this.blending) {
            this.blending = z;
            if (z) {
                k.gl.glEnable(GL20.GL_BLEND);
            } else {
                k.gl.glDisable(GL20.GL_BLEND);
            }
        }
        if (!z) {
            return;
        }
        if (this.blendSFactor != i || this.blendDFactor != i2) {
            k.gl.glBlendFunc(i, i2);
            this.blendSFactor = i;
            this.blendDFactor = i2;
        }
    }

    public void setCullFace(int i) {
        if (i != this.cullFace) {
            this.cullFace = i;
            if (i == 1028 || i == 1029 || i == 1032) {
                k.gl.glEnable(GL20.GL_CULL_FACE);
                k.gl.glCullFace(i);
                return;
            }
            k.gl.glDisable(GL20.GL_CULL_FACE);
        }
    }

    public void setDepthMask(boolean z) {
        if (this.depthMask != z) {
            GL20 gl20 = k.gl;
            this.depthMask = z;
            gl20.glDepthMask(z);
        }
    }

    public void setDepthTest(int i) {
        setDepthTest(i, 0.0f, 1.0f);
    }

    public void setDepthTest(int i, float f2, float f3) {
        boolean z = true;
        boolean z2 = this.depthFunc != 0;
        if (i == 0) {
            z = false;
        }
        if (this.depthFunc != i) {
            this.depthFunc = i;
            if (z) {
                k.gl.glEnable(GL20.GL_DEPTH_TEST);
                k.gl.glDepthFunc(i);
            } else {
                k.gl.glDisable(GL20.GL_DEPTH_TEST);
            }
        }
        if (z) {
            if (!z2 || this.depthFunc != i) {
                GL20 gl20 = k.gl;
                this.depthFunc = i;
                gl20.glDepthFunc(i);
            }
            if (!z2 || this.depthRangeNear != f2 || this.depthRangeFar != f3) {
                GL20 gl202 = k.gl;
                this.depthRangeNear = f2;
                this.depthRangeFar = f3;
                gl202.glDepthRangef(f2, f3);
            }
        }
    }
}
