package com.badlogic.gdx.graphics.profiling;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.FloatCounter;

public abstract class GLInterceptor implements GL20 {
    public int calls;
    public int drawCalls;
    public GLProfiler glProfiler;
    public int shaderSwitches;
    public int textureBindings;
    public final FloatCounter vertexCount = new FloatCounter(0);

    public GLInterceptor(GLProfiler gLProfiler) {
        this.glProfiler = gLProfiler;
    }

    public static String resolveErrorNumber(int i) {
        switch (i) {
            case GL20.GL_INVALID_ENUM /*1280*/:
                return "GL_INVALID_ENUM";
            case GL20.GL_INVALID_VALUE /*1281*/:
                return "GL_INVALID_VALUE";
            case GL20.GL_INVALID_OPERATION /*1282*/:
                return "GL_INVALID_OPERATION";
            case GL20.GL_OUT_OF_MEMORY /*1285*/:
                return "GL_OUT_OF_MEMORY";
            case GL20.GL_INVALID_FRAMEBUFFER_OPERATION /*1286*/:
                return "GL_INVALID_FRAMEBUFFER_OPERATION";
            default:
                return GeneratedOutlineSupport.outline41("number ", i);
        }
    }

    public int getCalls() {
        return this.calls;
    }

    public int getDrawCalls() {
        return this.drawCalls;
    }

    public int getShaderSwitches() {
        return this.shaderSwitches;
    }

    public int getTextureBindings() {
        return this.textureBindings;
    }

    public FloatCounter getVertexCount() {
        return this.vertexCount;
    }

    public void reset() {
        this.calls = 0;
        this.textureBindings = 0;
        this.drawCalls = 0;
        this.shaderSwitches = 0;
        this.vertexCount.reset();
    }
}
