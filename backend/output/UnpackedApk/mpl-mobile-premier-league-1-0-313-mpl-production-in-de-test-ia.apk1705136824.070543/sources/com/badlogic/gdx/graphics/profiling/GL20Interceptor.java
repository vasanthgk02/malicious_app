package com.badlogic.gdx.graphics.profiling;

import com.badlogic.gdx.graphics.GL20;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class GL20Interceptor extends GLInterceptor implements GL20 {
    public final GL20 gl20;

    public GL20Interceptor(GLProfiler gLProfiler, GL20 gl202) {
        super(gLProfiler);
        this.gl20 = gl202;
    }

    private void check() {
        int glGetError = this.gl20.glGetError();
        while (glGetError != 0) {
            this.glProfiler.getListener().onError(glGetError);
            glGetError = this.gl20.glGetError();
        }
    }

    public void glActiveTexture(int i) {
        this.calls++;
        this.gl20.glActiveTexture(i);
        check();
    }

    public void glAttachShader(int i, int i2) {
        this.calls++;
        this.gl20.glAttachShader(i, i2);
        check();
    }

    public void glBindAttribLocation(int i, int i2, String str) {
        this.calls++;
        this.gl20.glBindAttribLocation(i, i2, str);
        check();
    }

    public void glBindBuffer(int i, int i2) {
        this.calls++;
        this.gl20.glBindBuffer(i, i2);
        check();
    }

    public void glBindFramebuffer(int i, int i2) {
        this.calls++;
        this.gl20.glBindFramebuffer(i, i2);
        check();
    }

    public void glBindRenderbuffer(int i, int i2) {
        this.calls++;
        this.gl20.glBindRenderbuffer(i, i2);
        check();
    }

    public void glBindTexture(int i, int i2) {
        this.textureBindings++;
        this.calls++;
        this.gl20.glBindTexture(i, i2);
        check();
    }

    public void glBlendColor(float f2, float f3, float f4, float f5) {
        this.calls++;
        this.gl20.glBlendColor(f2, f3, f4, f5);
        check();
    }

    public void glBlendEquation(int i) {
        this.calls++;
        this.gl20.glBlendEquation(i);
        check();
    }

    public void glBlendEquationSeparate(int i, int i2) {
        this.calls++;
        this.gl20.glBlendEquationSeparate(i, i2);
        check();
    }

    public void glBlendFunc(int i, int i2) {
        this.calls++;
        this.gl20.glBlendFunc(i, i2);
        check();
    }

    public void glBlendFuncSeparate(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl20.glBlendFuncSeparate(i, i2, i3, i4);
        check();
    }

    public void glBufferData(int i, int i2, Buffer buffer, int i3) {
        this.calls++;
        this.gl20.glBufferData(i, i2, buffer, i3);
        check();
    }

    public void glBufferSubData(int i, int i2, int i3, Buffer buffer) {
        this.calls++;
        this.gl20.glBufferSubData(i, i2, i3, buffer);
        check();
    }

    public int glCheckFramebufferStatus(int i) {
        this.calls++;
        int glCheckFramebufferStatus = this.gl20.glCheckFramebufferStatus(i);
        check();
        return glCheckFramebufferStatus;
    }

    public void glClear(int i) {
        this.calls++;
        this.gl20.glClear(i);
        check();
    }

    public void glClearColor(float f2, float f3, float f4, float f5) {
        this.calls++;
        this.gl20.glClearColor(f2, f3, f4, f5);
        check();
    }

    public void glClearDepthf(float f2) {
        this.calls++;
        this.gl20.glClearDepthf(f2);
        check();
    }

    public void glClearStencil(int i) {
        this.calls++;
        this.gl20.glClearStencil(i);
        check();
    }

    public void glColorMask(boolean z, boolean z2, boolean z3, boolean z4) {
        this.calls++;
        this.gl20.glColorMask(z, z2, z3, z4);
        check();
    }

    public void glCompileShader(int i) {
        this.calls++;
        this.gl20.glCompileShader(i);
        check();
    }

    public void glCompressedTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, Buffer buffer) {
        this.calls++;
        this.gl20.glCompressedTexImage2D(i, i2, i3, i4, i5, i6, i7, buffer);
        check();
    }

    public void glCompressedTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        this.calls++;
        this.gl20.glCompressedTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        check();
    }

    public void glCopyTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.calls++;
        this.gl20.glCopyTexImage2D(i, i2, i3, i4, i5, i6, i7, i8);
        check();
    }

    public void glCopyTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.calls++;
        this.gl20.glCopyTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8);
        check();
    }

    public int glCreateProgram() {
        this.calls++;
        int glCreateProgram = this.gl20.glCreateProgram();
        check();
        return glCreateProgram;
    }

    public int glCreateShader(int i) {
        this.calls++;
        int glCreateShader = this.gl20.glCreateShader(i);
        check();
        return glCreateShader;
    }

    public void glCullFace(int i) {
        this.calls++;
        this.gl20.glCullFace(i);
        check();
    }

    public void glDeleteBuffer(int i) {
        this.calls++;
        this.gl20.glDeleteBuffer(i);
        check();
    }

    public void glDeleteBuffers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glDeleteBuffers(i, intBuffer);
        check();
    }

    public void glDeleteFramebuffer(int i) {
        this.calls++;
        this.gl20.glDeleteFramebuffer(i);
        check();
    }

    public void glDeleteFramebuffers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glDeleteFramebuffers(i, intBuffer);
        check();
    }

    public void glDeleteProgram(int i) {
        this.calls++;
        this.gl20.glDeleteProgram(i);
        check();
    }

    public void glDeleteRenderbuffer(int i) {
        this.calls++;
        this.gl20.glDeleteRenderbuffer(i);
        check();
    }

    public void glDeleteRenderbuffers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glDeleteRenderbuffers(i, intBuffer);
        check();
    }

    public void glDeleteShader(int i) {
        this.calls++;
        this.gl20.glDeleteShader(i);
        check();
    }

    public void glDeleteTexture(int i) {
        this.calls++;
        this.gl20.glDeleteTexture(i);
        check();
    }

    public void glDeleteTextures(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glDeleteTextures(i, intBuffer);
        check();
    }

    public void glDepthFunc(int i) {
        this.calls++;
        this.gl20.glDepthFunc(i);
        check();
    }

    public void glDepthMask(boolean z) {
        this.calls++;
        this.gl20.glDepthMask(z);
        check();
    }

    public void glDepthRangef(float f2, float f3) {
        this.calls++;
        this.gl20.glDepthRangef(f2, f3);
        check();
    }

    public void glDetachShader(int i, int i2) {
        this.calls++;
        this.gl20.glDetachShader(i, i2);
        check();
    }

    public void glDisable(int i) {
        this.calls++;
        this.gl20.glDisable(i);
        check();
    }

    public void glDisableVertexAttribArray(int i) {
        this.calls++;
        this.gl20.glDisableVertexAttribArray(i);
        check();
    }

    public void glDrawArrays(int i, int i2, int i3) {
        this.vertexCount.put((float) i3);
        this.drawCalls++;
        this.calls++;
        this.gl20.glDrawArrays(i, i2, i3);
        check();
    }

    public void glDrawElements(int i, int i2, int i3, Buffer buffer) {
        this.vertexCount.put((float) i2);
        this.drawCalls++;
        this.calls++;
        this.gl20.glDrawElements(i, i2, i3, buffer);
        check();
    }

    public void glEnable(int i) {
        this.calls++;
        this.gl20.glEnable(i);
        check();
    }

    public void glEnableVertexAttribArray(int i) {
        this.calls++;
        this.gl20.glEnableVertexAttribArray(i);
        check();
    }

    public void glFinish() {
        this.calls++;
        this.gl20.glFinish();
        check();
    }

    public void glFlush() {
        this.calls++;
        this.gl20.glFlush();
        check();
    }

    public void glFramebufferRenderbuffer(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl20.glFramebufferRenderbuffer(i, i2, i3, i4);
        check();
    }

    public void glFramebufferTexture2D(int i, int i2, int i3, int i4, int i5) {
        this.calls++;
        this.gl20.glFramebufferTexture2D(i, i2, i3, i4, i5);
        check();
    }

    public void glFrontFace(int i) {
        this.calls++;
        this.gl20.glFrontFace(i);
        check();
    }

    public int glGenBuffer() {
        this.calls++;
        int glGenBuffer = this.gl20.glGenBuffer();
        check();
        return glGenBuffer;
    }

    public void glGenBuffers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGenBuffers(i, intBuffer);
        check();
    }

    public int glGenFramebuffer() {
        this.calls++;
        int glGenFramebuffer = this.gl20.glGenFramebuffer();
        check();
        return glGenFramebuffer;
    }

    public void glGenFramebuffers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGenFramebuffers(i, intBuffer);
        check();
    }

    public int glGenRenderbuffer() {
        this.calls++;
        int glGenRenderbuffer = this.gl20.glGenRenderbuffer();
        check();
        return glGenRenderbuffer;
    }

    public void glGenRenderbuffers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGenRenderbuffers(i, intBuffer);
        check();
    }

    public int glGenTexture() {
        this.calls++;
        int glGenTexture = this.gl20.glGenTexture();
        check();
        return glGenTexture;
    }

    public void glGenTextures(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGenTextures(i, intBuffer);
        check();
    }

    public void glGenerateMipmap(int i) {
        this.calls++;
        this.gl20.glGenerateMipmap(i);
        check();
    }

    public String glGetActiveAttrib(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        this.calls++;
        String glGetActiveAttrib = this.gl20.glGetActiveAttrib(i, i2, intBuffer, intBuffer2);
        check();
        return glGetActiveAttrib;
    }

    public String glGetActiveUniform(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        this.calls++;
        String glGetActiveUniform = this.gl20.glGetActiveUniform(i, i2, intBuffer, intBuffer2);
        check();
        return glGetActiveUniform;
    }

    public void glGetAttachedShaders(int i, int i2, Buffer buffer, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGetAttachedShaders(i, i2, buffer, intBuffer);
        check();
    }

    public int glGetAttribLocation(int i, String str) {
        this.calls++;
        int glGetAttribLocation = this.gl20.glGetAttribLocation(i, str);
        check();
        return glGetAttribLocation;
    }

    public void glGetBooleanv(int i, Buffer buffer) {
        this.calls++;
        this.gl20.glGetBooleanv(i, buffer);
        check();
    }

    public void glGetBufferParameteriv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGetBufferParameteriv(i, i2, intBuffer);
        check();
    }

    public int glGetError() {
        this.calls++;
        return this.gl20.glGetError();
    }

    public void glGetFloatv(int i, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glGetFloatv(i, floatBuffer);
        check();
    }

    public void glGetFramebufferAttachmentParameteriv(int i, int i2, int i3, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGetFramebufferAttachmentParameteriv(i, i2, i3, intBuffer);
        check();
    }

    public void glGetIntegerv(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGetIntegerv(i, intBuffer);
        check();
    }

    public String glGetProgramInfoLog(int i) {
        this.calls++;
        String glGetProgramInfoLog = this.gl20.glGetProgramInfoLog(i);
        check();
        return glGetProgramInfoLog;
    }

    public void glGetProgramiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGetProgramiv(i, i2, intBuffer);
        check();
    }

    public void glGetRenderbufferParameteriv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGetRenderbufferParameteriv(i, i2, intBuffer);
        check();
    }

    public String glGetShaderInfoLog(int i) {
        this.calls++;
        String glGetShaderInfoLog = this.gl20.glGetShaderInfoLog(i);
        check();
        return glGetShaderInfoLog;
    }

    public void glGetShaderPrecisionFormat(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        this.calls++;
        this.gl20.glGetShaderPrecisionFormat(i, i2, intBuffer, intBuffer2);
        check();
    }

    public void glGetShaderiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGetShaderiv(i, i2, intBuffer);
        check();
    }

    public String glGetString(int i) {
        this.calls++;
        String glGetString = this.gl20.glGetString(i);
        check();
        return glGetString;
    }

    public void glGetTexParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glGetTexParameterfv(i, i2, floatBuffer);
        check();
    }

    public void glGetTexParameteriv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGetTexParameteriv(i, i2, intBuffer);
        check();
    }

    public int glGetUniformLocation(int i, String str) {
        this.calls++;
        int glGetUniformLocation = this.gl20.glGetUniformLocation(i, str);
        check();
        return glGetUniformLocation;
    }

    public void glGetUniformfv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glGetUniformfv(i, i2, floatBuffer);
        check();
    }

    public void glGetUniformiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGetUniformiv(i, i2, intBuffer);
        check();
    }

    public void glGetVertexAttribPointerv(int i, int i2, Buffer buffer) {
        this.calls++;
        this.gl20.glGetVertexAttribPointerv(i, i2, buffer);
        check();
    }

    public void glGetVertexAttribfv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glGetVertexAttribfv(i, i2, floatBuffer);
        check();
    }

    public void glGetVertexAttribiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glGetVertexAttribiv(i, i2, intBuffer);
        check();
    }

    public void glHint(int i, int i2) {
        this.calls++;
        this.gl20.glHint(i, i2);
        check();
    }

    public boolean glIsBuffer(int i) {
        this.calls++;
        boolean glIsBuffer = this.gl20.glIsBuffer(i);
        check();
        return glIsBuffer;
    }

    public boolean glIsEnabled(int i) {
        this.calls++;
        boolean glIsEnabled = this.gl20.glIsEnabled(i);
        check();
        return glIsEnabled;
    }

    public boolean glIsFramebuffer(int i) {
        this.calls++;
        boolean glIsFramebuffer = this.gl20.glIsFramebuffer(i);
        check();
        return glIsFramebuffer;
    }

    public boolean glIsProgram(int i) {
        this.calls++;
        boolean glIsProgram = this.gl20.glIsProgram(i);
        check();
        return glIsProgram;
    }

    public boolean glIsRenderbuffer(int i) {
        this.calls++;
        boolean glIsRenderbuffer = this.gl20.glIsRenderbuffer(i);
        check();
        return glIsRenderbuffer;
    }

    public boolean glIsShader(int i) {
        this.calls++;
        boolean glIsShader = this.gl20.glIsShader(i);
        check();
        return glIsShader;
    }

    public boolean glIsTexture(int i) {
        this.calls++;
        boolean glIsTexture = this.gl20.glIsTexture(i);
        check();
        return glIsTexture;
    }

    public void glLineWidth(float f2) {
        this.calls++;
        this.gl20.glLineWidth(f2);
        check();
    }

    public void glLinkProgram(int i) {
        this.calls++;
        this.gl20.glLinkProgram(i);
        check();
    }

    public void glPixelStorei(int i, int i2) {
        this.calls++;
        this.gl20.glPixelStorei(i, i2);
        check();
    }

    public void glPolygonOffset(float f2, float f3) {
        this.calls++;
        this.gl20.glPolygonOffset(f2, f3);
        check();
    }

    public void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, Buffer buffer) {
        this.calls++;
        this.gl20.glReadPixels(i, i2, i3, i4, i5, i6, buffer);
        check();
    }

    public void glReleaseShaderCompiler() {
        this.calls++;
        this.gl20.glReleaseShaderCompiler();
        check();
    }

    public void glRenderbufferStorage(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl20.glRenderbufferStorage(i, i2, i3, i4);
        check();
    }

    public void glSampleCoverage(float f2, boolean z) {
        this.calls++;
        this.gl20.glSampleCoverage(f2, z);
        check();
    }

    public void glScissor(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl20.glScissor(i, i2, i3, i4);
        check();
    }

    public void glShaderBinary(int i, IntBuffer intBuffer, int i2, Buffer buffer, int i3) {
        this.calls++;
        this.gl20.glShaderBinary(i, intBuffer, i2, buffer, i3);
        check();
    }

    public void glShaderSource(int i, String str) {
        this.calls++;
        this.gl20.glShaderSource(i, str);
        check();
    }

    public void glStencilFunc(int i, int i2, int i3) {
        this.calls++;
        this.gl20.glStencilFunc(i, i2, i3);
        check();
    }

    public void glStencilFuncSeparate(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl20.glStencilFuncSeparate(i, i2, i3, i4);
        check();
    }

    public void glStencilMask(int i) {
        this.calls++;
        this.gl20.glStencilMask(i);
        check();
    }

    public void glStencilMaskSeparate(int i, int i2) {
        this.calls++;
        this.gl20.glStencilMaskSeparate(i, i2);
        check();
    }

    public void glStencilOp(int i, int i2, int i3) {
        this.calls++;
        this.gl20.glStencilOp(i, i2, i3);
        check();
    }

    public void glStencilOpSeparate(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl20.glStencilOpSeparate(i, i2, i3, i4);
        check();
    }

    public void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        this.calls++;
        this.gl20.glTexImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        check();
    }

    public void glTexParameterf(int i, int i2, float f2) {
        this.calls++;
        this.gl20.glTexParameterf(i, i2, f2);
        check();
    }

    public void glTexParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glTexParameterfv(i, i2, floatBuffer);
        check();
    }

    public void glTexParameteri(int i, int i2, int i3) {
        this.calls++;
        this.gl20.glTexParameteri(i, i2, i3);
        check();
    }

    public void glTexParameteriv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glTexParameteriv(i, i2, intBuffer);
        check();
    }

    public void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        this.calls++;
        this.gl20.glTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        check();
    }

    public void glUniform1f(int i, float f2) {
        this.calls++;
        this.gl20.glUniform1f(i, f2);
        check();
    }

    public void glUniform1fv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glUniform1fv(i, i2, floatBuffer);
        check();
    }

    public void glUniform1i(int i, int i2) {
        this.calls++;
        this.gl20.glUniform1i(i, i2);
        check();
    }

    public void glUniform1iv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glUniform1iv(i, i2, intBuffer);
        check();
    }

    public void glUniform2f(int i, float f2, float f3) {
        this.calls++;
        this.gl20.glUniform2f(i, f2, f3);
        check();
    }

    public void glUniform2fv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glUniform2fv(i, i2, floatBuffer);
        check();
    }

    public void glUniform2i(int i, int i2, int i3) {
        this.calls++;
        this.gl20.glUniform2i(i, i2, i3);
        check();
    }

    public void glUniform2iv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glUniform2iv(i, i2, intBuffer);
        check();
    }

    public void glUniform3f(int i, float f2, float f3, float f4) {
        this.calls++;
        this.gl20.glUniform3f(i, f2, f3, f4);
        check();
    }

    public void glUniform3fv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glUniform3fv(i, i2, floatBuffer);
        check();
    }

    public void glUniform3i(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl20.glUniform3i(i, i2, i3, i4);
        check();
    }

    public void glUniform3iv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glUniform3iv(i, i2, intBuffer);
        check();
    }

    public void glUniform4f(int i, float f2, float f3, float f4, float f5) {
        this.calls++;
        this.gl20.glUniform4f(i, f2, f3, f4, f5);
        check();
    }

    public void glUniform4fv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glUniform4fv(i, i2, floatBuffer);
        check();
    }

    public void glUniform4i(int i, int i2, int i3, int i4, int i5) {
        this.calls++;
        this.gl20.glUniform4i(i, i2, i3, i4, i5);
        check();
    }

    public void glUniform4iv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl20.glUniform4iv(i, i2, intBuffer);
        check();
    }

    public void glUniformMatrix2fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glUniformMatrix2fv(i, i2, z, floatBuffer);
        check();
    }

    public void glUniformMatrix3fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glUniformMatrix3fv(i, i2, z, floatBuffer);
        check();
    }

    public void glUniformMatrix4fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glUniformMatrix4fv(i, i2, z, floatBuffer);
        check();
    }

    public void glUseProgram(int i) {
        this.shaderSwitches++;
        this.calls++;
        this.gl20.glUseProgram(i);
        check();
    }

    public void glValidateProgram(int i) {
        this.calls++;
        this.gl20.glValidateProgram(i);
        check();
    }

    public void glVertexAttrib1f(int i, float f2) {
        this.calls++;
        this.gl20.glVertexAttrib1f(i, f2);
        check();
    }

    public void glVertexAttrib1fv(int i, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glVertexAttrib1fv(i, floatBuffer);
        check();
    }

    public void glVertexAttrib2f(int i, float f2, float f3) {
        this.calls++;
        this.gl20.glVertexAttrib2f(i, f2, f3);
        check();
    }

    public void glVertexAttrib2fv(int i, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glVertexAttrib2fv(i, floatBuffer);
        check();
    }

    public void glVertexAttrib3f(int i, float f2, float f3, float f4) {
        this.calls++;
        this.gl20.glVertexAttrib3f(i, f2, f3, f4);
        check();
    }

    public void glVertexAttrib3fv(int i, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glVertexAttrib3fv(i, floatBuffer);
        check();
    }

    public void glVertexAttrib4f(int i, float f2, float f3, float f4, float f5) {
        this.calls++;
        this.gl20.glVertexAttrib4f(i, f2, f3, f4, f5);
        check();
    }

    public void glVertexAttrib4fv(int i, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl20.glVertexAttrib4fv(i, floatBuffer);
        check();
    }

    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, Buffer buffer) {
        this.calls++;
        this.gl20.glVertexAttribPointer(i, i2, i3, z, i4, buffer);
        check();
    }

    public void glViewport(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl20.glViewport(i, i2, i3, i4);
        check();
    }

    public void glUniform1fv(int i, int i2, float[] fArr, int i3) {
        this.calls++;
        this.gl20.glUniform1fv(i, i2, fArr, i3);
        check();
    }

    public void glUniform1iv(int i, int i2, int[] iArr, int i3) {
        this.calls++;
        this.gl20.glUniform1iv(i, i2, iArr, i3);
        check();
    }

    public void glUniform2fv(int i, int i2, float[] fArr, int i3) {
        this.calls++;
        this.gl20.glUniform2fv(i, i2, fArr, i3);
        check();
    }

    public void glUniform2iv(int i, int i2, int[] iArr, int i3) {
        this.calls++;
        this.gl20.glUniform2iv(i, i2, iArr, i3);
        check();
    }

    public void glUniform3fv(int i, int i2, float[] fArr, int i3) {
        this.calls++;
        this.gl20.glUniform3fv(i, i2, fArr, i3);
        check();
    }

    public void glUniform3iv(int i, int i2, int[] iArr, int i3) {
        this.calls++;
        this.gl20.glUniform3iv(i, i2, iArr, i3);
        check();
    }

    public void glUniform4fv(int i, int i2, float[] fArr, int i3) {
        this.calls++;
        this.gl20.glUniform4fv(i, i2, fArr, i3);
        check();
    }

    public void glUniform4iv(int i, int i2, int[] iArr, int i3) {
        this.calls++;
        this.gl20.glUniform4iv(i, i2, iArr, i3);
        check();
    }

    public void glUniformMatrix2fv(int i, int i2, boolean z, float[] fArr, int i3) {
        this.calls++;
        this.gl20.glUniformMatrix2fv(i, i2, z, fArr, i3);
        check();
    }

    public void glUniformMatrix3fv(int i, int i2, boolean z, float[] fArr, int i3) {
        this.calls++;
        this.gl20.glUniformMatrix3fv(i, i2, z, fArr, i3);
        check();
    }

    public void glUniformMatrix4fv(int i, int i2, boolean z, float[] fArr, int i3) {
        this.calls++;
        this.gl20.glUniformMatrix4fv(i, i2, z, fArr, i3);
        check();
    }

    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, int i5) {
        this.calls++;
        this.gl20.glVertexAttribPointer(i, i2, i3, z, i4, i5);
        check();
    }

    public void glDrawElements(int i, int i2, int i3, int i4) {
        this.vertexCount.put((float) i2);
        this.drawCalls++;
        this.calls++;
        this.gl20.glDrawElements(i, i2, i3, i4);
        check();
    }
}
