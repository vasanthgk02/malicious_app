package com.badlogic.gdx.graphics.profiling;

import com.badlogic.gdx.graphics.GL30;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

public class GL30Interceptor extends GLInterceptor implements GL30 {
    public final GL30 gl30;

    public GL30Interceptor(GLProfiler gLProfiler, GL30 gl302) {
        super(gLProfiler);
        this.gl30 = gl302;
    }

    private void check() {
        int glGetError = this.gl30.glGetError();
        while (glGetError != 0) {
            this.glProfiler.getListener().onError(glGetError);
            glGetError = this.gl30.glGetError();
        }
    }

    public void glActiveTexture(int i) {
        this.calls++;
        this.gl30.glActiveTexture(i);
        check();
    }

    public void glAttachShader(int i, int i2) {
        this.calls++;
        this.gl30.glAttachShader(i, i2);
        check();
    }

    public void glBeginQuery(int i, int i2) {
        this.calls++;
        this.gl30.glBeginQuery(i, i2);
        check();
    }

    public void glBeginTransformFeedback(int i) {
        this.calls++;
        this.gl30.glBeginTransformFeedback(i);
        check();
    }

    public void glBindAttribLocation(int i, int i2, String str) {
        this.calls++;
        this.gl30.glBindAttribLocation(i, i2, str);
        check();
    }

    public void glBindBuffer(int i, int i2) {
        this.calls++;
        this.gl30.glBindBuffer(i, i2);
        check();
    }

    public void glBindBufferBase(int i, int i2, int i3) {
        this.calls++;
        this.gl30.glBindBufferBase(i, i2, i3);
        check();
    }

    public void glBindBufferRange(int i, int i2, int i3, int i4, int i5) {
        this.calls++;
        this.gl30.glBindBufferRange(i, i2, i3, i4, i5);
        check();
    }

    public void glBindFramebuffer(int i, int i2) {
        this.calls++;
        this.gl30.glBindFramebuffer(i, i2);
        check();
    }

    public void glBindRenderbuffer(int i, int i2) {
        this.calls++;
        this.gl30.glBindRenderbuffer(i, i2);
        check();
    }

    public void glBindSampler(int i, int i2) {
        this.calls++;
        this.gl30.glBindSampler(i, i2);
        check();
    }

    public void glBindTexture(int i, int i2) {
        this.textureBindings++;
        this.calls++;
        this.gl30.glBindTexture(i, i2);
        check();
    }

    public void glBindTransformFeedback(int i, int i2) {
        this.calls++;
        this.gl30.glBindTransformFeedback(i, i2);
        check();
    }

    public void glBindVertexArray(int i) {
        this.calls++;
        this.gl30.glBindVertexArray(i);
        check();
    }

    public void glBlendColor(float f2, float f3, float f4, float f5) {
        this.calls++;
        this.gl30.glBlendColor(f2, f3, f4, f5);
        check();
    }

    public void glBlendEquation(int i) {
        this.calls++;
        this.gl30.glBlendEquation(i);
        check();
    }

    public void glBlendEquationSeparate(int i, int i2) {
        this.calls++;
        this.gl30.glBlendEquationSeparate(i, i2);
        check();
    }

    public void glBlendFunc(int i, int i2) {
        this.calls++;
        this.gl30.glBlendFunc(i, i2);
        check();
    }

    public void glBlendFuncSeparate(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl30.glBlendFuncSeparate(i, i2, i3, i4);
        check();
    }

    public void glBlitFramebuffer(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.calls++;
        this.gl30.glBlitFramebuffer(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        check();
    }

    public void glBufferData(int i, int i2, Buffer buffer, int i3) {
        this.calls++;
        this.gl30.glBufferData(i, i2, buffer, i3);
        check();
    }

    public void glBufferSubData(int i, int i2, int i3, Buffer buffer) {
        this.calls++;
        this.gl30.glBufferSubData(i, i2, i3, buffer);
        check();
    }

    public int glCheckFramebufferStatus(int i) {
        this.calls++;
        int glCheckFramebufferStatus = this.gl30.glCheckFramebufferStatus(i);
        check();
        return glCheckFramebufferStatus;
    }

    public void glClear(int i) {
        this.calls++;
        this.gl30.glClear(i);
        check();
    }

    public void glClearBufferfi(int i, int i2, float f2, int i3) {
        this.calls++;
        this.gl30.glClearBufferfi(i, i2, f2, i3);
        check();
    }

    public void glClearBufferfv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glClearBufferfv(i, i2, floatBuffer);
        check();
    }

    public void glClearBufferiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glClearBufferiv(i, i2, intBuffer);
        check();
    }

    public void glClearBufferuiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glClearBufferuiv(i, i2, intBuffer);
        check();
    }

    public void glClearColor(float f2, float f3, float f4, float f5) {
        this.calls++;
        this.gl30.glClearColor(f2, f3, f4, f5);
        check();
    }

    public void glClearDepthf(float f2) {
        this.calls++;
        this.gl30.glClearDepthf(f2);
        check();
    }

    public void glClearStencil(int i) {
        this.calls++;
        this.gl30.glClearStencil(i);
        check();
    }

    public void glColorMask(boolean z, boolean z2, boolean z3, boolean z4) {
        this.calls++;
        this.gl30.glColorMask(z, z2, z3, z4);
        check();
    }

    public void glCompileShader(int i) {
        this.calls++;
        this.gl30.glCompileShader(i);
        check();
    }

    public void glCompressedTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, Buffer buffer) {
        this.calls++;
        this.gl30.glCompressedTexImage2D(i, i2, i3, i4, i5, i6, i7, buffer);
        check();
    }

    public void glCompressedTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        this.calls++;
        this.gl30.glCompressedTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        check();
    }

    public void glCopyBufferSubData(int i, int i2, int i3, int i4, int i5) {
        this.calls++;
        this.gl30.glCopyBufferSubData(i, i2, i3, i4, i5);
        check();
    }

    public void glCopyTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.calls++;
        this.gl30.glCopyTexImage2D(i, i2, i3, i4, i5, i6, i7, i8);
        check();
    }

    public void glCopyTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.calls++;
        this.gl30.glCopyTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8);
        check();
    }

    public void glCopyTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.calls++;
        this.gl30.glCopyTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9);
        check();
    }

    public int glCreateProgram() {
        this.calls++;
        int glCreateProgram = this.gl30.glCreateProgram();
        check();
        return glCreateProgram;
    }

    public int glCreateShader(int i) {
        this.calls++;
        int glCreateShader = this.gl30.glCreateShader(i);
        check();
        return glCreateShader;
    }

    public void glCullFace(int i) {
        this.calls++;
        this.gl30.glCullFace(i);
        check();
    }

    public void glDeleteBuffer(int i) {
        this.calls++;
        this.gl30.glDeleteBuffer(i);
        check();
    }

    public void glDeleteBuffers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glDeleteBuffers(i, intBuffer);
        check();
    }

    public void glDeleteFramebuffer(int i) {
        this.calls++;
        this.gl30.glDeleteFramebuffer(i);
        check();
    }

    public void glDeleteFramebuffers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glDeleteFramebuffers(i, intBuffer);
        check();
    }

    public void glDeleteProgram(int i) {
        this.calls++;
        this.gl30.glDeleteProgram(i);
        check();
    }

    public void glDeleteQueries(int i, int[] iArr, int i2) {
        this.calls++;
        this.gl30.glDeleteQueries(i, iArr, i2);
        check();
    }

    public void glDeleteRenderbuffer(int i) {
        this.calls++;
        this.gl30.glDeleteRenderbuffer(i);
        check();
    }

    public void glDeleteRenderbuffers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glDeleteRenderbuffers(i, intBuffer);
        check();
    }

    public void glDeleteSamplers(int i, int[] iArr, int i2) {
        this.calls++;
        this.gl30.glDeleteSamplers(i, iArr, i2);
        check();
    }

    public void glDeleteShader(int i) {
        this.calls++;
        this.gl30.glDeleteShader(i);
        check();
    }

    public void glDeleteTexture(int i) {
        this.calls++;
        this.gl30.glDeleteTexture(i);
        check();
    }

    public void glDeleteTextures(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glDeleteTextures(i, intBuffer);
        check();
    }

    public void glDeleteTransformFeedbacks(int i, int[] iArr, int i2) {
        this.calls++;
        this.gl30.glDeleteTransformFeedbacks(i, iArr, i2);
        check();
    }

    public void glDeleteVertexArrays(int i, int[] iArr, int i2) {
        this.calls++;
        this.gl30.glDeleteVertexArrays(i, iArr, i2);
        check();
    }

    public void glDepthFunc(int i) {
        this.calls++;
        this.gl30.glDepthFunc(i);
        check();
    }

    public void glDepthMask(boolean z) {
        this.calls++;
        this.gl30.glDepthMask(z);
        check();
    }

    public void glDepthRangef(float f2, float f3) {
        this.calls++;
        this.gl30.glDepthRangef(f2, f3);
        check();
    }

    public void glDetachShader(int i, int i2) {
        this.calls++;
        this.gl30.glDetachShader(i, i2);
        check();
    }

    public void glDisable(int i) {
        this.calls++;
        this.gl30.glDisable(i);
        check();
    }

    public void glDisableVertexAttribArray(int i) {
        this.calls++;
        this.gl30.glDisableVertexAttribArray(i);
        check();
    }

    public void glDrawArrays(int i, int i2, int i3) {
        this.vertexCount.put((float) i3);
        this.drawCalls++;
        this.calls++;
        this.gl30.glDrawArrays(i, i2, i3);
        check();
    }

    public void glDrawArraysInstanced(int i, int i2, int i3, int i4) {
        this.vertexCount.put((float) i3);
        this.drawCalls++;
        this.calls++;
        this.gl30.glDrawArraysInstanced(i, i2, i3, i4);
        check();
    }

    public void glDrawBuffers(int i, IntBuffer intBuffer) {
        this.drawCalls++;
        this.calls++;
        this.gl30.glDrawBuffers(i, intBuffer);
        check();
    }

    public void glDrawElements(int i, int i2, int i3, Buffer buffer) {
        this.vertexCount.put((float) i2);
        this.drawCalls++;
        this.calls++;
        this.gl30.glDrawElements(i, i2, i3, buffer);
        check();
    }

    public void glDrawElementsInstanced(int i, int i2, int i3, int i4, int i5) {
        this.vertexCount.put((float) i2);
        this.drawCalls++;
        this.calls++;
        this.gl30.glDrawElementsInstanced(i, i2, i3, i4, i5);
        check();
    }

    public void glDrawRangeElements(int i, int i2, int i3, int i4, int i5, Buffer buffer) {
        this.vertexCount.put((float) i4);
        this.drawCalls++;
        this.calls++;
        this.gl30.glDrawRangeElements(i, i2, i3, i4, i5, buffer);
        check();
    }

    public void glEnable(int i) {
        this.calls++;
        this.gl30.glEnable(i);
        check();
    }

    public void glEnableVertexAttribArray(int i) {
        this.calls++;
        this.gl30.glEnableVertexAttribArray(i);
        check();
    }

    public void glEndQuery(int i) {
        this.calls++;
        this.gl30.glEndQuery(i);
        check();
    }

    public void glEndTransformFeedback() {
        this.calls++;
        this.gl30.glEndTransformFeedback();
        check();
    }

    public void glFinish() {
        this.calls++;
        this.gl30.glFinish();
        check();
    }

    public void glFlush() {
        this.calls++;
        this.gl30.glFlush();
        check();
    }

    public void glFlushMappedBufferRange(int i, int i2, int i3) {
        this.calls++;
        this.gl30.glFlushMappedBufferRange(i, i2, i3);
        check();
    }

    public void glFramebufferRenderbuffer(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl30.glFramebufferRenderbuffer(i, i2, i3, i4);
        check();
    }

    public void glFramebufferTexture2D(int i, int i2, int i3, int i4, int i5) {
        this.calls++;
        this.gl30.glFramebufferTexture2D(i, i2, i3, i4, i5);
        check();
    }

    public void glFramebufferTextureLayer(int i, int i2, int i3, int i4, int i5) {
        this.calls++;
        this.gl30.glFramebufferTextureLayer(i, i2, i3, i4, i5);
        check();
    }

    public void glFrontFace(int i) {
        this.calls++;
        this.gl30.glFrontFace(i);
        check();
    }

    public int glGenBuffer() {
        this.calls++;
        int glGenBuffer = this.gl30.glGenBuffer();
        check();
        return glGenBuffer;
    }

    public void glGenBuffers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGenBuffers(i, intBuffer);
        check();
    }

    public int glGenFramebuffer() {
        this.calls++;
        int glGenFramebuffer = this.gl30.glGenFramebuffer();
        check();
        return glGenFramebuffer;
    }

    public void glGenFramebuffers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGenFramebuffers(i, intBuffer);
        check();
    }

    public void glGenQueries(int i, int[] iArr, int i2) {
        this.calls++;
        this.gl30.glGenQueries(i, iArr, i2);
        check();
    }

    public int glGenRenderbuffer() {
        this.calls++;
        int glGenRenderbuffer = this.gl30.glGenRenderbuffer();
        check();
        return glGenRenderbuffer;
    }

    public void glGenRenderbuffers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGenRenderbuffers(i, intBuffer);
        check();
    }

    public void glGenSamplers(int i, int[] iArr, int i2) {
        this.calls++;
        this.gl30.glGenSamplers(i, iArr, i2);
        check();
    }

    public int glGenTexture() {
        this.calls++;
        int glGenTexture = this.gl30.glGenTexture();
        check();
        return glGenTexture;
    }

    public void glGenTextures(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGenTextures(i, intBuffer);
        check();
    }

    public void glGenTransformFeedbacks(int i, int[] iArr, int i2) {
        this.calls++;
        this.gl30.glGenTransformFeedbacks(i, iArr, i2);
        check();
    }

    public void glGenVertexArrays(int i, int[] iArr, int i2) {
        this.calls++;
        this.gl30.glGenVertexArrays(i, iArr, i2);
        check();
    }

    public void glGenerateMipmap(int i) {
        this.calls++;
        this.gl30.glGenerateMipmap(i);
        check();
    }

    public String glGetActiveAttrib(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        this.calls++;
        String glGetActiveAttrib = this.gl30.glGetActiveAttrib(i, i2, intBuffer, intBuffer2);
        check();
        return glGetActiveAttrib;
    }

    public String glGetActiveUniform(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        this.calls++;
        String glGetActiveUniform = this.gl30.glGetActiveUniform(i, i2, intBuffer, intBuffer2);
        check();
        return glGetActiveUniform;
    }

    public void glGetActiveUniformBlockName(int i, int i2, Buffer buffer, Buffer buffer2) {
        this.calls++;
        this.gl30.glGetActiveUniformBlockName(i, i2, buffer, buffer2);
        check();
    }

    public void glGetActiveUniformBlockiv(int i, int i2, int i3, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetActiveUniformBlockiv(i, i2, i3, intBuffer);
        check();
    }

    public void glGetActiveUniformsiv(int i, int i2, IntBuffer intBuffer, int i3, IntBuffer intBuffer2) {
        this.calls++;
        this.gl30.glGetActiveUniformsiv(i, i2, intBuffer, i3, intBuffer2);
        check();
    }

    public void glGetAttachedShaders(int i, int i2, Buffer buffer, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetAttachedShaders(i, i2, buffer, intBuffer);
        check();
    }

    public int glGetAttribLocation(int i, String str) {
        this.calls++;
        int glGetAttribLocation = this.gl30.glGetAttribLocation(i, str);
        check();
        return glGetAttribLocation;
    }

    public void glGetBooleanv(int i, Buffer buffer) {
        this.calls++;
        this.gl30.glGetBooleanv(i, buffer);
        check();
    }

    public void glGetBufferParameteri64v(int i, int i2, LongBuffer longBuffer) {
        this.calls++;
        this.gl30.glGetBufferParameteri64v(i, i2, longBuffer);
        check();
    }

    public void glGetBufferParameteriv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetBufferParameteriv(i, i2, intBuffer);
        check();
    }

    public Buffer glGetBufferPointerv(int i, int i2) {
        this.calls++;
        Buffer glGetBufferPointerv = this.gl30.glGetBufferPointerv(i, i2);
        check();
        return glGetBufferPointerv;
    }

    public int glGetError() {
        this.calls++;
        return this.gl30.glGetError();
    }

    public void glGetFloatv(int i, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glGetFloatv(i, floatBuffer);
        check();
    }

    public int glGetFragDataLocation(int i, String str) {
        this.calls++;
        int glGetFragDataLocation = this.gl30.glGetFragDataLocation(i, str);
        check();
        return glGetFragDataLocation;
    }

    public void glGetFramebufferAttachmentParameteriv(int i, int i2, int i3, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetFramebufferAttachmentParameteriv(i, i2, i3, intBuffer);
        check();
    }

    public void glGetInteger64v(int i, LongBuffer longBuffer) {
        this.calls++;
        this.gl30.glGetInteger64v(i, longBuffer);
        check();
    }

    public void glGetIntegerv(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetIntegerv(i, intBuffer);
        check();
    }

    public String glGetProgramInfoLog(int i) {
        this.calls++;
        String glGetProgramInfoLog = this.gl30.glGetProgramInfoLog(i);
        check();
        return glGetProgramInfoLog;
    }

    public void glGetProgramiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetProgramiv(i, i2, intBuffer);
        check();
    }

    public void glGetQueryObjectuiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetQueryObjectuiv(i, i2, intBuffer);
        check();
    }

    public void glGetQueryiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetQueryiv(i, i2, intBuffer);
        check();
    }

    public void glGetRenderbufferParameteriv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetRenderbufferParameteriv(i, i2, intBuffer);
        check();
    }

    public void glGetSamplerParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glGetSamplerParameterfv(i, i2, floatBuffer);
        check();
    }

    public void glGetSamplerParameteriv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetSamplerParameteriv(i, i2, intBuffer);
        check();
    }

    public String glGetShaderInfoLog(int i) {
        this.calls++;
        String glGetShaderInfoLog = this.gl30.glGetShaderInfoLog(i);
        check();
        return glGetShaderInfoLog;
    }

    public void glGetShaderPrecisionFormat(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        this.calls++;
        this.gl30.glGetShaderPrecisionFormat(i, i2, intBuffer, intBuffer2);
        check();
    }

    public void glGetShaderiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetShaderiv(i, i2, intBuffer);
        check();
    }

    public String glGetString(int i) {
        this.calls++;
        String glGetString = this.gl30.glGetString(i);
        check();
        return glGetString;
    }

    public String glGetStringi(int i, int i2) {
        this.calls++;
        String glGetStringi = this.gl30.glGetStringi(i, i2);
        check();
        return glGetStringi;
    }

    public void glGetTexParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glGetTexParameterfv(i, i2, floatBuffer);
        check();
    }

    public void glGetTexParameteriv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetTexParameteriv(i, i2, intBuffer);
        check();
    }

    public int glGetUniformBlockIndex(int i, String str) {
        this.calls++;
        int glGetUniformBlockIndex = this.gl30.glGetUniformBlockIndex(i, str);
        check();
        return glGetUniformBlockIndex;
    }

    public void glGetUniformIndices(int i, String[] strArr, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetUniformIndices(i, strArr, intBuffer);
        check();
    }

    public int glGetUniformLocation(int i, String str) {
        this.calls++;
        int glGetUniformLocation = this.gl30.glGetUniformLocation(i, str);
        check();
        return glGetUniformLocation;
    }

    public void glGetUniformfv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glGetUniformfv(i, i2, floatBuffer);
        check();
    }

    public void glGetUniformiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetUniformiv(i, i2, intBuffer);
        check();
    }

    public void glGetUniformuiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetUniformuiv(i, i2, intBuffer);
        check();
    }

    public void glGetVertexAttribIiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetVertexAttribIiv(i, i2, intBuffer);
        check();
    }

    public void glGetVertexAttribIuiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetVertexAttribIuiv(i, i2, intBuffer);
        check();
    }

    public void glGetVertexAttribPointerv(int i, int i2, Buffer buffer) {
        this.calls++;
        this.gl30.glGetVertexAttribPointerv(i, i2, buffer);
        check();
    }

    public void glGetVertexAttribfv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glGetVertexAttribfv(i, i2, floatBuffer);
        check();
    }

    public void glGetVertexAttribiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGetVertexAttribiv(i, i2, intBuffer);
        check();
    }

    public void glHint(int i, int i2) {
        this.calls++;
        this.gl30.glHint(i, i2);
        check();
    }

    public void glInvalidateFramebuffer(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glInvalidateFramebuffer(i, i2, intBuffer);
        check();
    }

    public void glInvalidateSubFramebuffer(int i, int i2, IntBuffer intBuffer, int i3, int i4, int i5, int i6) {
        this.calls++;
        this.gl30.glInvalidateSubFramebuffer(i, i2, intBuffer, i3, i4, i5, i6);
        check();
    }

    public boolean glIsBuffer(int i) {
        this.calls++;
        boolean glIsBuffer = this.gl30.glIsBuffer(i);
        check();
        return glIsBuffer;
    }

    public boolean glIsEnabled(int i) {
        this.calls++;
        boolean glIsEnabled = this.gl30.glIsEnabled(i);
        check();
        return glIsEnabled;
    }

    public boolean glIsFramebuffer(int i) {
        this.calls++;
        boolean glIsFramebuffer = this.gl30.glIsFramebuffer(i);
        check();
        return glIsFramebuffer;
    }

    public boolean glIsProgram(int i) {
        this.calls++;
        boolean glIsProgram = this.gl30.glIsProgram(i);
        check();
        return glIsProgram;
    }

    public boolean glIsQuery(int i) {
        this.calls++;
        boolean glIsQuery = this.gl30.glIsQuery(i);
        check();
        return glIsQuery;
    }

    public boolean glIsRenderbuffer(int i) {
        this.calls++;
        boolean glIsRenderbuffer = this.gl30.glIsRenderbuffer(i);
        check();
        return glIsRenderbuffer;
    }

    public boolean glIsSampler(int i) {
        this.calls++;
        boolean glIsSampler = this.gl30.glIsSampler(i);
        check();
        return glIsSampler;
    }

    public boolean glIsShader(int i) {
        this.calls++;
        boolean glIsShader = this.gl30.glIsShader(i);
        check();
        return glIsShader;
    }

    public boolean glIsTexture(int i) {
        this.calls++;
        boolean glIsTexture = this.gl30.glIsTexture(i);
        check();
        return glIsTexture;
    }

    public boolean glIsTransformFeedback(int i) {
        this.calls++;
        boolean glIsTransformFeedback = this.gl30.glIsTransformFeedback(i);
        check();
        return glIsTransformFeedback;
    }

    public boolean glIsVertexArray(int i) {
        this.calls++;
        boolean glIsVertexArray = this.gl30.glIsVertexArray(i);
        check();
        return glIsVertexArray;
    }

    public void glLineWidth(float f2) {
        this.calls++;
        this.gl30.glLineWidth(f2);
        check();
    }

    public void glLinkProgram(int i) {
        this.calls++;
        this.gl30.glLinkProgram(i);
        check();
    }

    public Buffer glMapBufferRange(int i, int i2, int i3, int i4) {
        this.calls++;
        Buffer glMapBufferRange = this.gl30.glMapBufferRange(i, i2, i3, i4);
        check();
        return glMapBufferRange;
    }

    public void glPauseTransformFeedback() {
        this.calls++;
        this.gl30.glPauseTransformFeedback();
        check();
    }

    public void glPixelStorei(int i, int i2) {
        this.calls++;
        this.gl30.glPixelStorei(i, i2);
        check();
    }

    public void glPolygonOffset(float f2, float f3) {
        this.calls++;
        this.gl30.glPolygonOffset(f2, f3);
        check();
    }

    public void glProgramParameteri(int i, int i2, int i3) {
        this.calls++;
        this.gl30.glProgramParameteri(i, i2, i3);
        check();
    }

    public void glReadBuffer(int i) {
        this.calls++;
        this.gl30.glReadBuffer(i);
        check();
    }

    public void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, Buffer buffer) {
        this.calls++;
        this.gl30.glReadPixels(i, i2, i3, i4, i5, i6, buffer);
        check();
    }

    public void glReleaseShaderCompiler() {
        this.calls++;
        this.gl30.glReleaseShaderCompiler();
        check();
    }

    public void glRenderbufferStorage(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl30.glRenderbufferStorage(i, i2, i3, i4);
        check();
    }

    public void glRenderbufferStorageMultisample(int i, int i2, int i3, int i4, int i5) {
        this.calls++;
        this.gl30.glRenderbufferStorageMultisample(i, i2, i3, i4, i5);
        check();
    }

    public void glResumeTransformFeedback() {
        this.calls++;
        this.gl30.glResumeTransformFeedback();
        check();
    }

    public void glSampleCoverage(float f2, boolean z) {
        this.calls++;
        this.gl30.glSampleCoverage(f2, z);
        check();
    }

    public void glSamplerParameterf(int i, int i2, float f2) {
        this.calls++;
        this.gl30.glSamplerParameterf(i, i2, f2);
        check();
    }

    public void glSamplerParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glSamplerParameterfv(i, i2, floatBuffer);
        check();
    }

    public void glSamplerParameteri(int i, int i2, int i3) {
        this.calls++;
        this.gl30.glSamplerParameteri(i, i2, i3);
        check();
    }

    public void glSamplerParameteriv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glSamplerParameteriv(i, i2, intBuffer);
        check();
    }

    public void glScissor(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl30.glScissor(i, i2, i3, i4);
        check();
    }

    public void glShaderBinary(int i, IntBuffer intBuffer, int i2, Buffer buffer, int i3) {
        this.calls++;
        this.gl30.glShaderBinary(i, intBuffer, i2, buffer, i3);
        check();
    }

    public void glShaderSource(int i, String str) {
        this.calls++;
        this.gl30.glShaderSource(i, str);
        check();
    }

    public void glStencilFunc(int i, int i2, int i3) {
        this.calls++;
        this.gl30.glStencilFunc(i, i2, i3);
        check();
    }

    public void glStencilFuncSeparate(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl30.glStencilFuncSeparate(i, i2, i3, i4);
        check();
    }

    public void glStencilMask(int i) {
        this.calls++;
        this.gl30.glStencilMask(i);
        check();
    }

    public void glStencilMaskSeparate(int i, int i2) {
        this.calls++;
        this.gl30.glStencilMaskSeparate(i, i2);
        check();
    }

    public void glStencilOp(int i, int i2, int i3) {
        this.calls++;
        this.gl30.glStencilOp(i, i2, i3);
        check();
    }

    public void glStencilOpSeparate(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl30.glStencilOpSeparate(i, i2, i3, i4);
        check();
    }

    public void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        this.calls++;
        this.gl30.glTexImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        check();
    }

    public void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Buffer buffer) {
        this.calls++;
        this.gl30.glTexImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, buffer);
        check();
    }

    public void glTexParameterf(int i, int i2, float f2) {
        this.calls++;
        this.gl30.glTexParameterf(i, i2, f2);
        check();
    }

    public void glTexParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glTexParameterfv(i, i2, floatBuffer);
        check();
    }

    public void glTexParameteri(int i, int i2, int i3) {
        this.calls++;
        this.gl30.glTexParameteri(i, i2, i3);
        check();
    }

    public void glTexParameteriv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glTexParameteriv(i, i2, intBuffer);
        check();
    }

    public void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer) {
        this.calls++;
        this.gl30.glTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer);
        check();
    }

    public void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, Buffer buffer) {
        this.calls++;
        this.gl30.glTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, buffer);
        check();
    }

    public void glTransformFeedbackVaryings(int i, String[] strArr, int i2) {
        this.calls++;
        this.gl30.glTransformFeedbackVaryings(i, strArr, i2);
        check();
    }

    public void glUniform1f(int i, float f2) {
        this.calls++;
        this.gl30.glUniform1f(i, f2);
        check();
    }

    public void glUniform1fv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glUniform1fv(i, i2, floatBuffer);
        check();
    }

    public void glUniform1i(int i, int i2) {
        this.calls++;
        this.gl30.glUniform1i(i, i2);
        check();
    }

    public void glUniform1iv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glUniform1iv(i, i2, intBuffer);
        check();
    }

    public void glUniform1uiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glUniform1uiv(i, i2, intBuffer);
        check();
    }

    public void glUniform2f(int i, float f2, float f3) {
        this.calls++;
        this.gl30.glUniform2f(i, f2, f3);
        check();
    }

    public void glUniform2fv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glUniform2fv(i, i2, floatBuffer);
        check();
    }

    public void glUniform2i(int i, int i2, int i3) {
        this.calls++;
        this.gl30.glUniform2i(i, i2, i3);
        check();
    }

    public void glUniform2iv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glUniform2iv(i, i2, intBuffer);
        check();
    }

    public void glUniform3f(int i, float f2, float f3, float f4) {
        this.calls++;
        this.gl30.glUniform3f(i, f2, f3, f4);
        check();
    }

    public void glUniform3fv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glUniform3fv(i, i2, floatBuffer);
        check();
    }

    public void glUniform3i(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl30.glUniform3i(i, i2, i3, i4);
        check();
    }

    public void glUniform3iv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glUniform3iv(i, i2, intBuffer);
        check();
    }

    public void glUniform3uiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glUniform3uiv(i, i2, intBuffer);
        check();
    }

    public void glUniform4f(int i, float f2, float f3, float f4, float f5) {
        this.calls++;
        this.gl30.glUniform4f(i, f2, f3, f4, f5);
        check();
    }

    public void glUniform4fv(int i, int i2, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glUniform4fv(i, i2, floatBuffer);
        check();
    }

    public void glUniform4i(int i, int i2, int i3, int i4, int i5) {
        this.calls++;
        this.gl30.glUniform4i(i, i2, i3, i4, i5);
        check();
    }

    public void glUniform4iv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glUniform4iv(i, i2, intBuffer);
        check();
    }

    public void glUniform4uiv(int i, int i2, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glUniform4uiv(i, i2, intBuffer);
        check();
    }

    public void glUniformBlockBinding(int i, int i2, int i3) {
        this.calls++;
        this.gl30.glUniformBlockBinding(i, i2, i3);
        check();
    }

    public void glUniformMatrix2fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glUniformMatrix2fv(i, i2, z, floatBuffer);
        check();
    }

    public void glUniformMatrix2x3fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glUniformMatrix2x3fv(i, i2, z, floatBuffer);
        check();
    }

    public void glUniformMatrix2x4fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glUniformMatrix2x4fv(i, i2, z, floatBuffer);
        check();
    }

    public void glUniformMatrix3fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glUniformMatrix3fv(i, i2, z, floatBuffer);
        check();
    }

    public void glUniformMatrix3x2fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glUniformMatrix3x2fv(i, i2, z, floatBuffer);
        check();
    }

    public void glUniformMatrix3x4fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glUniformMatrix3x4fv(i, i2, z, floatBuffer);
        check();
    }

    public void glUniformMatrix4fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glUniformMatrix4fv(i, i2, z, floatBuffer);
        check();
    }

    public void glUniformMatrix4x2fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glUniformMatrix4x2fv(i, i2, z, floatBuffer);
        check();
    }

    public void glUniformMatrix4x3fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glUniformMatrix4x3fv(i, i2, z, floatBuffer);
        check();
    }

    public boolean glUnmapBuffer(int i) {
        this.calls++;
        boolean glUnmapBuffer = this.gl30.glUnmapBuffer(i);
        check();
        return glUnmapBuffer;
    }

    public void glUseProgram(int i) {
        this.shaderSwitches++;
        this.calls++;
        this.gl30.glUseProgram(i);
        check();
    }

    public void glValidateProgram(int i) {
        this.calls++;
        this.gl30.glValidateProgram(i);
        check();
    }

    public void glVertexAttrib1f(int i, float f2) {
        this.calls++;
        this.gl30.glVertexAttrib1f(i, f2);
        check();
    }

    public void glVertexAttrib1fv(int i, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glVertexAttrib1fv(i, floatBuffer);
        check();
    }

    public void glVertexAttrib2f(int i, float f2, float f3) {
        this.calls++;
        this.gl30.glVertexAttrib2f(i, f2, f3);
        check();
    }

    public void glVertexAttrib2fv(int i, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glVertexAttrib2fv(i, floatBuffer);
        check();
    }

    public void glVertexAttrib3f(int i, float f2, float f3, float f4) {
        this.calls++;
        this.gl30.glVertexAttrib3f(i, f2, f3, f4);
        check();
    }

    public void glVertexAttrib3fv(int i, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glVertexAttrib3fv(i, floatBuffer);
        check();
    }

    public void glVertexAttrib4f(int i, float f2, float f3, float f4, float f5) {
        this.calls++;
        this.gl30.glVertexAttrib4f(i, f2, f3, f4, f5);
        check();
    }

    public void glVertexAttrib4fv(int i, FloatBuffer floatBuffer) {
        this.calls++;
        this.gl30.glVertexAttrib4fv(i, floatBuffer);
        check();
    }

    public void glVertexAttribDivisor(int i, int i2) {
        this.calls++;
        this.gl30.glVertexAttribDivisor(i, i2);
        check();
    }

    public void glVertexAttribI4i(int i, int i2, int i3, int i4, int i5) {
        this.calls++;
        this.gl30.glVertexAttribI4i(i, i2, i3, i4, i5);
        check();
    }

    public void glVertexAttribI4ui(int i, int i2, int i3, int i4, int i5) {
        this.calls++;
        this.gl30.glVertexAttribI4ui(i, i2, i3, i4, i5);
        check();
    }

    public void glVertexAttribIPointer(int i, int i2, int i3, int i4, int i5) {
        this.calls++;
        this.gl30.glVertexAttribIPointer(i, i2, i3, i4, i5);
        check();
    }

    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, Buffer buffer) {
        this.calls++;
        this.gl30.glVertexAttribPointer(i, i2, i3, z, i4, buffer);
        check();
    }

    public void glViewport(int i, int i2, int i3, int i4) {
        this.calls++;
        this.gl30.glViewport(i, i2, i3, i4);
        check();
    }

    public void glDeleteQueries(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glDeleteQueries(i, intBuffer);
        check();
    }

    public void glDeleteSamplers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glDeleteSamplers(i, intBuffer);
        check();
    }

    public void glDeleteTransformFeedbacks(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glDeleteTransformFeedbacks(i, intBuffer);
        check();
    }

    public void glDeleteVertexArrays(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glDeleteVertexArrays(i, intBuffer);
        check();
    }

    public void glGenQueries(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGenQueries(i, intBuffer);
        check();
    }

    public void glGenSamplers(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGenSamplers(i, intBuffer);
        check();
    }

    public void glGenTransformFeedbacks(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGenTransformFeedbacks(i, intBuffer);
        check();
    }

    public void glGenVertexArrays(int i, IntBuffer intBuffer) {
        this.calls++;
        this.gl30.glGenVertexArrays(i, intBuffer);
        check();
    }

    public String glGetActiveUniformBlockName(int i, int i2) {
        this.calls++;
        String glGetActiveUniformBlockName = this.gl30.glGetActiveUniformBlockName(i, i2);
        check();
        return glGetActiveUniformBlockName;
    }

    public void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.calls++;
        this.gl30.glTexImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
        check();
    }

    public void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.calls++;
        this.gl30.glTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11);
        check();
    }

    public void glUniform1fv(int i, int i2, float[] fArr, int i3) {
        this.calls++;
        this.gl30.glUniform1fv(i, i2, fArr, i3);
        check();
    }

    public void glUniform1iv(int i, int i2, int[] iArr, int i3) {
        this.calls++;
        this.gl30.glUniform1iv(i, i2, iArr, i3);
        check();
    }

    public void glUniform2fv(int i, int i2, float[] fArr, int i3) {
        this.calls++;
        this.gl30.glUniform2fv(i, i2, fArr, i3);
        check();
    }

    public void glUniform2iv(int i, int i2, int[] iArr, int i3) {
        this.calls++;
        this.gl30.glUniform2iv(i, i2, iArr, i3);
        check();
    }

    public void glUniform3fv(int i, int i2, float[] fArr, int i3) {
        this.calls++;
        this.gl30.glUniform3fv(i, i2, fArr, i3);
        check();
    }

    public void glUniform3iv(int i, int i2, int[] iArr, int i3) {
        this.calls++;
        this.gl30.glUniform3iv(i, i2, iArr, i3);
        check();
    }

    public void glUniform4fv(int i, int i2, float[] fArr, int i3) {
        this.calls++;
        this.gl30.glUniform4fv(i, i2, fArr, i3);
        check();
    }

    public void glUniform4iv(int i, int i2, int[] iArr, int i3) {
        this.calls++;
        this.gl30.glUniform4iv(i, i2, iArr, i3);
        check();
    }

    public void glUniformMatrix2fv(int i, int i2, boolean z, float[] fArr, int i3) {
        this.calls++;
        this.gl30.glUniformMatrix2fv(i, i2, z, fArr, i3);
        check();
    }

    public void glUniformMatrix3fv(int i, int i2, boolean z, float[] fArr, int i3) {
        this.calls++;
        this.gl30.glUniformMatrix3fv(i, i2, z, fArr, i3);
        check();
    }

    public void glUniformMatrix4fv(int i, int i2, boolean z, float[] fArr, int i3) {
        this.calls++;
        this.gl30.glUniformMatrix4fv(i, i2, z, fArr, i3);
        check();
    }

    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, int i5) {
        this.calls++;
        this.gl30.glVertexAttribPointer(i, i2, i3, z, i4, i5);
        check();
    }

    public void glDrawElements(int i, int i2, int i3, int i4) {
        this.vertexCount.put((float) i2);
        this.drawCalls++;
        this.calls++;
        this.gl30.glDrawElements(i, i2, i3, i4);
        check();
    }

    public void glDrawRangeElements(int i, int i2, int i3, int i4, int i5, int i6) {
        this.vertexCount.put((float) i4);
        this.drawCalls++;
        this.calls++;
        this.gl30.glDrawRangeElements(i, i2, i3, i4, i5, i6);
        check();
    }
}
