package com.badlogic.gdx.backends.android;

import android.annotation.TargetApi;
import android.opengl.GLES30;
import com.badlogic.gdx.graphics.GL30;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

@TargetApi(18)
public class AndroidGL30 extends AndroidGL20 implements GL30 {
    public void glBeginQuery(int i, int i2) {
        GLES30.glBeginQuery(i, i2);
    }

    public void glBeginTransformFeedback(int i) {
        GLES30.glBeginTransformFeedback(i);
    }

    public void glBindBufferBase(int i, int i2, int i3) {
        GLES30.glBindBufferBase(i, i2, i3);
    }

    public void glBindBufferRange(int i, int i2, int i3, int i4, int i5) {
        GLES30.glBindBufferRange(i, i2, i3, i4, i5);
    }

    public void glBindSampler(int i, int i2) {
        GLES30.glBindSampler(i, i2);
    }

    public void glBindTransformFeedback(int i, int i2) {
        GLES30.glBindTransformFeedback(i, i2);
    }

    public void glBindVertexArray(int i) {
        GLES30.glBindVertexArray(i);
    }

    public void glBlitFramebuffer(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        GLES30.glBlitFramebuffer(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public void glClearBufferfi(int i, int i2, float f2, int i3) {
        GLES30.glClearBufferfi(i, i2, f2, i3);
    }

    public void glClearBufferfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES30.glClearBufferfv(i, i2, floatBuffer);
    }

    public void glClearBufferiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glClearBufferiv(i, i2, intBuffer);
    }

    public void glClearBufferuiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glClearBufferuiv(i, i2, intBuffer);
    }

    public void glCopyBufferSubData(int i, int i2, int i3, int i4, int i5) {
        GLES30.glCopyBufferSubData(i, i2, i3, i4, i5);
    }

    public void glCopyTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        GLES30.glCopyTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public void glDeleteQueries(int i, int[] iArr, int i2) {
        GLES30.glDeleteQueries(i, iArr, i2);
    }

    public void glDeleteSamplers(int i, int[] iArr, int i2) {
        GLES30.glDeleteSamplers(i, iArr, i2);
    }

    public void glDeleteTransformFeedbacks(int i, int[] iArr, int i2) {
        GLES30.glDeleteTransformFeedbacks(i, iArr, i2);
    }

    public void glDeleteVertexArrays(int i, int[] iArr, int i2) {
        GLES30.glDeleteVertexArrays(i, iArr, i2);
    }

    public void glDrawArraysInstanced(int i, int i2, int i3, int i4) {
        GLES30.glDrawArraysInstanced(i, i2, i3, i4);
    }

    public void glDrawBuffers(int i, IntBuffer intBuffer) {
        GLES30.glDrawBuffers(i, intBuffer);
    }

    public void glDrawElementsInstanced(int i, int i2, int i3, int i4, int i5) {
        GLES30.glDrawElementsInstanced(i, i2, i3, i4, i5);
    }

    public void glDrawRangeElements(int i, int i2, int i3, int i4, int i5, Buffer buffer) {
        GLES30.glDrawRangeElements(i, i2, i3, i4, i5, buffer);
    }

    public void glEndQuery(int i) {
        GLES30.glEndQuery(i);
    }

    public void glEndTransformFeedback() {
        GLES30.glEndTransformFeedback();
    }

    public void glFlushMappedBufferRange(int i, int i2, int i3) {
        GLES30.glFlushMappedBufferRange(i, i2, i3);
    }

    public void glFramebufferTextureLayer(int i, int i2, int i3, int i4, int i5) {
        GLES30.glFramebufferTextureLayer(i, i2, i3, i4, i5);
    }

    public void glGenQueries(int i, int[] iArr, int i2) {
        GLES30.glGenQueries(i, iArr, i2);
    }

    public void glGenSamplers(int i, int[] iArr, int i2) {
        GLES30.glGenSamplers(i, iArr, i2);
    }

    public void glGenTransformFeedbacks(int i, int[] iArr, int i2) {
        GLES30.glGenTransformFeedbacks(i, iArr, i2);
    }

    public void glGenVertexArrays(int i, int[] iArr, int i2) {
        GLES30.glGenVertexArrays(i, iArr, i2);
    }

    public void glGetActiveUniformBlockName(int i, int i2, Buffer buffer, Buffer buffer2) {
        GLES30.glGetActiveUniformBlockName(i, i2, buffer, buffer2);
    }

    public void glGetActiveUniformBlockiv(int i, int i2, int i3, IntBuffer intBuffer) {
        GLES30.glGetActiveUniformBlockiv(i, i2, i3, intBuffer);
    }

    public void glGetActiveUniformsiv(int i, int i2, IntBuffer intBuffer, int i3, IntBuffer intBuffer2) {
        GLES30.glGetActiveUniformsiv(i, i2, intBuffer, i3, intBuffer2);
    }

    public void glGetBufferParameteri64v(int i, int i2, LongBuffer longBuffer) {
        GLES30.glGetBufferParameteri64v(i, i2, longBuffer);
    }

    public Buffer glGetBufferPointerv(int i, int i2) {
        return GLES30.glGetBufferPointerv(i, i2);
    }

    public int glGetFragDataLocation(int i, String str) {
        return GLES30.glGetFragDataLocation(i, str);
    }

    public void glGetInteger64v(int i, LongBuffer longBuffer) {
        GLES30.glGetInteger64v(i, longBuffer);
    }

    public void glGetQueryObjectuiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glGetQueryObjectuiv(i, i2, intBuffer);
    }

    public void glGetQueryiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glGetQueryiv(i, i2, intBuffer);
    }

    public void glGetSamplerParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES30.glGetSamplerParameterfv(i, i2, floatBuffer);
    }

    public void glGetSamplerParameteriv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glGetSamplerParameteriv(i, i2, intBuffer);
    }

    public String glGetStringi(int i, int i2) {
        return GLES30.glGetStringi(i, i2);
    }

    public int glGetUniformBlockIndex(int i, String str) {
        return GLES30.glGetUniformBlockIndex(i, str);
    }

    public void glGetUniformIndices(int i, String[] strArr, IntBuffer intBuffer) {
        GLES30.glGetUniformIndices(i, strArr, intBuffer);
    }

    public void glGetUniformuiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glGetUniformuiv(i, i2, intBuffer);
    }

    public void glGetVertexAttribIiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glGetVertexAttribIiv(i, i2, intBuffer);
    }

    public void glGetVertexAttribIuiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glGetVertexAttribIuiv(i, i2, intBuffer);
    }

    public void glInvalidateFramebuffer(int i, int i2, IntBuffer intBuffer) {
        GLES30.glInvalidateFramebuffer(i, i2, intBuffer);
    }

    public void glInvalidateSubFramebuffer(int i, int i2, IntBuffer intBuffer, int i3, int i4, int i5, int i6) {
        GLES30.glInvalidateSubFramebuffer(i, i2, intBuffer, i3, i4, i5, i6);
    }

    public boolean glIsQuery(int i) {
        return GLES30.glIsQuery(i);
    }

    public boolean glIsSampler(int i) {
        return GLES30.glIsSampler(i);
    }

    public boolean glIsTransformFeedback(int i) {
        return GLES30.glIsTransformFeedback(i);
    }

    public boolean glIsVertexArray(int i) {
        return GLES30.glIsVertexArray(i);
    }

    public Buffer glMapBufferRange(int i, int i2, int i3, int i4) {
        return GLES30.glMapBufferRange(i, i2, i3, i4);
    }

    public void glPauseTransformFeedback() {
        GLES30.glPauseTransformFeedback();
    }

    public void glProgramParameteri(int i, int i2, int i3) {
        GLES30.glProgramParameteri(i, i2, i3);
    }

    public void glReadBuffer(int i) {
        GLES30.glReadBuffer(i);
    }

    public void glRenderbufferStorageMultisample(int i, int i2, int i3, int i4, int i5) {
        GLES30.glRenderbufferStorageMultisample(i, i2, i3, i4, i5);
    }

    public void glResumeTransformFeedback() {
        GLES30.glResumeTransformFeedback();
    }

    public void glSamplerParameterf(int i, int i2, float f2) {
        GLES30.glSamplerParameterf(i, i2, f2);
    }

    public void glSamplerParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES30.glSamplerParameterfv(i, i2, floatBuffer);
    }

    public void glSamplerParameteri(int i, int i2, int i3) {
        GLES30.glSamplerParameteri(i, i2, i3);
    }

    public void glSamplerParameteriv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glSamplerParameteriv(i, i2, intBuffer);
    }

    public void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Buffer buffer) {
        if (buffer == null) {
            GLES30.glTexImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, 0);
        } else {
            GLES30.glTexImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, buffer);
        }
    }

    public void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, Buffer buffer) {
        GLES30.glTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, buffer);
    }

    public void glTransformFeedbackVaryings(int i, String[] strArr, int i2) {
        GLES30.glTransformFeedbackVaryings(i, strArr, i2);
    }

    public void glUniform1uiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glUniform1uiv(i, i2, intBuffer);
    }

    public void glUniform3uiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glUniform3uiv(i, i2, intBuffer);
    }

    public void glUniform4uiv(int i, int i2, IntBuffer intBuffer) {
        GLES30.glUniform4uiv(i, i2, intBuffer);
    }

    public void glUniformBlockBinding(int i, int i2, int i3) {
        GLES30.glUniformBlockBinding(i, i2, i3);
    }

    public void glUniformMatrix2x3fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES30.glUniformMatrix2x3fv(i, i2, z, floatBuffer);
    }

    public void glUniformMatrix2x4fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES30.glUniformMatrix2x4fv(i, i2, z, floatBuffer);
    }

    public void glUniformMatrix3x2fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES30.glUniformMatrix3x2fv(i, i2, z, floatBuffer);
    }

    public void glUniformMatrix3x4fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES30.glUniformMatrix3x4fv(i, i2, z, floatBuffer);
    }

    public void glUniformMatrix4x2fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES30.glUniformMatrix4x2fv(i, i2, z, floatBuffer);
    }

    public void glUniformMatrix4x3fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES30.glUniformMatrix4x3fv(i, i2, z, floatBuffer);
    }

    public boolean glUnmapBuffer(int i) {
        return GLES30.glUnmapBuffer(i);
    }

    public void glVertexAttribDivisor(int i, int i2) {
        GLES30.glVertexAttribDivisor(i, i2);
    }

    public void glVertexAttribI4i(int i, int i2, int i3, int i4, int i5) {
        GLES30.glVertexAttribI4i(i, i2, i3, i4, i5);
    }

    public void glVertexAttribI4ui(int i, int i2, int i3, int i4, int i5) {
        GLES30.glVertexAttribI4ui(i, i2, i3, i4, i5);
    }

    public void glVertexAttribIPointer(int i, int i2, int i3, int i4, int i5) {
        GLES30.glVertexAttribIPointer(i, i2, i3, i4, i5);
    }

    public void glDeleteQueries(int i, IntBuffer intBuffer) {
        GLES30.glDeleteQueries(i, intBuffer);
    }

    public void glDeleteSamplers(int i, IntBuffer intBuffer) {
        GLES30.glDeleteSamplers(i, intBuffer);
    }

    public void glDeleteTransformFeedbacks(int i, IntBuffer intBuffer) {
        GLES30.glDeleteTransformFeedbacks(i, intBuffer);
    }

    public void glDeleteVertexArrays(int i, IntBuffer intBuffer) {
        GLES30.glDeleteVertexArrays(i, intBuffer);
    }

    public void glDrawRangeElements(int i, int i2, int i3, int i4, int i5, int i6) {
        GLES30.glDrawRangeElements(i, i2, i3, i4, i5, i6);
    }

    public void glGenQueries(int i, IntBuffer intBuffer) {
        GLES30.glGenQueries(i, intBuffer);
    }

    public void glGenSamplers(int i, IntBuffer intBuffer) {
        GLES30.glGenSamplers(i, intBuffer);
    }

    public void glGenTransformFeedbacks(int i, IntBuffer intBuffer) {
        GLES30.glGenTransformFeedbacks(i, intBuffer);
    }

    public void glGenVertexArrays(int i, IntBuffer intBuffer) {
        GLES30.glGenVertexArrays(i, intBuffer);
    }

    public String glGetActiveUniformBlockName(int i, int i2) {
        return GLES30.glGetActiveUniformBlockName(i, i2);
    }

    public void glTexSubImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        GLES30.glTexSubImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11);
    }

    public void glTexImage3D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        GLES30.glTexImage3D(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }
}
