package com.badlogic.gdx.graphics.profiling;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.math.FloatCounter;

public class GLProfiler {
    public boolean enabled = false;
    public GLInterceptor glInterceptor;
    public Graphics graphics;
    public GLErrorListener listener;

    public GLProfiler(Graphics graphics2) {
        this.graphics = graphics2;
        AndroidGraphics androidGraphics = (AndroidGraphics) graphics2;
        GL30 gl30 = androidGraphics.gl30;
        if (gl30 != null) {
            this.glInterceptor = new GL30Interceptor(this, gl30);
        } else {
            this.glInterceptor = new GL20Interceptor(this, androidGraphics.gl20);
        }
        this.listener = GLErrorListener.LOGGING_LISTENER;
    }

    public void disable() {
        if (this.enabled) {
            AndroidGraphics androidGraphics = (AndroidGraphics) this.graphics;
            GL30 gl30 = androidGraphics.gl30;
            if (gl30 != null) {
                GL30 gl302 = ((GL30Interceptor) gl30).gl30;
                androidGraphics.gl30 = gl302;
                if (gl302 != null) {
                    androidGraphics.gl20 = gl302;
                    k.gl = gl302;
                    k.gl20 = gl302;
                    k.gl30 = gl302;
                }
            } else {
                GL20 gl20 = ((GL20Interceptor) androidGraphics.gl20).gl20;
                androidGraphics.gl20 = gl20;
                if (gl30 == null) {
                    k.gl = gl20;
                    k.gl20 = gl20;
                }
            }
            this.enabled = false;
        }
    }

    public void enable() {
        if (!this.enabled) {
            AndroidGraphics androidGraphics = (AndroidGraphics) this.graphics;
            GL30 gl30 = androidGraphics.gl30;
            if (gl30 != null) {
                GL30 gl302 = (GL30) this.glInterceptor;
                androidGraphics.gl30 = gl302;
                if (gl302 != null) {
                    androidGraphics.gl20 = gl302;
                    k.gl = gl302;
                    k.gl20 = gl302;
                    k.gl30 = gl302;
                }
            } else {
                GLInterceptor gLInterceptor = this.glInterceptor;
                androidGraphics.gl20 = gLInterceptor;
                if (gl30 == null) {
                    k.gl = gLInterceptor;
                    k.gl20 = gLInterceptor;
                }
            }
            this.enabled = true;
        }
    }

    public int getCalls() {
        return this.glInterceptor.getCalls();
    }

    public int getDrawCalls() {
        return this.glInterceptor.getDrawCalls();
    }

    public GLErrorListener getListener() {
        return this.listener;
    }

    public int getShaderSwitches() {
        return this.glInterceptor.getShaderSwitches();
    }

    public int getTextureBindings() {
        return this.glInterceptor.getTextureBindings();
    }

    public FloatCounter getVertexCount() {
        return this.glInterceptor.getVertexCount();
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void reset() {
        this.glInterceptor.reset();
    }

    public void setListener(GLErrorListener gLErrorListener) {
        this.listener = gLErrorListener;
    }
}
