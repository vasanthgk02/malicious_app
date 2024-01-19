package com.badlogic.gdx.backends.android;

import android.opengl.GLES20;
import com.badlogic.gdx.graphics.GL20;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class AndroidGL20 implements GL20 {
    public byte[] buffer = new byte[512];
    public int[] ints = new int[1];
    public int[] ints2 = new int[1];
    public int[] ints3 = new int[1];

    public void glActiveTexture(int i) {
        GLES20.glActiveTexture(i);
    }

    public void glAttachShader(int i, int i2) {
        GLES20.glAttachShader(i, i2);
    }

    public void glBindAttribLocation(int i, int i2, String str) {
        GLES20.glBindAttribLocation(i, i2, str);
    }

    public void glBindBuffer(int i, int i2) {
        GLES20.glBindBuffer(i, i2);
    }

    public void glBindFramebuffer(int i, int i2) {
        GLES20.glBindFramebuffer(i, i2);
    }

    public void glBindRenderbuffer(int i, int i2) {
        GLES20.glBindRenderbuffer(i, i2);
    }

    public void glBindTexture(int i, int i2) {
        GLES20.glBindTexture(i, i2);
    }

    public void glBlendColor(float f2, float f3, float f4, float f5) {
        GLES20.glBlendColor(f2, f3, f4, f5);
    }

    public void glBlendEquation(int i) {
        GLES20.glBlendEquation(i);
    }

    public void glBlendEquationSeparate(int i, int i2) {
        GLES20.glBlendEquationSeparate(i, i2);
    }

    public void glBlendFunc(int i, int i2) {
        GLES20.glBlendFunc(i, i2);
    }

    public void glBlendFuncSeparate(int i, int i2, int i3, int i4) {
        GLES20.glBlendFuncSeparate(i, i2, i3, i4);
    }

    public void glBufferData(int i, int i2, Buffer buffer2, int i3) {
        GLES20.glBufferData(i, i2, buffer2, i3);
    }

    public void glBufferSubData(int i, int i2, int i3, Buffer buffer2) {
        GLES20.glBufferSubData(i, i2, i3, buffer2);
    }

    public int glCheckFramebufferStatus(int i) {
        return GLES20.glCheckFramebufferStatus(i);
    }

    public void glClear(int i) {
        GLES20.glClear(i);
    }

    public void glClearColor(float f2, float f3, float f4, float f5) {
        GLES20.glClearColor(f2, f3, f4, f5);
    }

    public void glClearDepthf(float f2) {
        GLES20.glClearDepthf(f2);
    }

    public void glClearStencil(int i) {
        GLES20.glClearStencil(i);
    }

    public void glColorMask(boolean z, boolean z2, boolean z3, boolean z4) {
        GLES20.glColorMask(z, z2, z3, z4);
    }

    public void glCompileShader(int i) {
        GLES20.glCompileShader(i);
    }

    public void glCompressedTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, Buffer buffer2) {
        GLES20.glCompressedTexImage2D(i, i2, i3, i4, i5, i6, i7, buffer2);
    }

    public void glCompressedTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer2) {
        GLES20.glCompressedTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer2);
    }

    public void glCopyTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GLES20.glCopyTexImage2D(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void glCopyTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GLES20.glCopyTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public int glCreateProgram() {
        return GLES20.glCreateProgram();
    }

    public int glCreateShader(int i) {
        return GLES20.glCreateShader(i);
    }

    public void glCullFace(int i) {
        GLES20.glCullFace(i);
    }

    public void glDeleteBuffer(int i) {
        int[] iArr = this.ints;
        iArr[0] = i;
        GLES20.glDeleteBuffers(1, iArr, 0);
    }

    public void glDeleteBuffers(int i, IntBuffer intBuffer) {
        GLES20.glDeleteBuffers(i, intBuffer);
    }

    public void glDeleteFramebuffer(int i) {
        int[] iArr = this.ints;
        iArr[0] = i;
        GLES20.glDeleteFramebuffers(1, iArr, 0);
    }

    public void glDeleteFramebuffers(int i, IntBuffer intBuffer) {
        GLES20.glDeleteFramebuffers(i, intBuffer);
    }

    public void glDeleteProgram(int i) {
        GLES20.glDeleteProgram(i);
    }

    public void glDeleteRenderbuffer(int i) {
        int[] iArr = this.ints;
        iArr[0] = i;
        GLES20.glDeleteRenderbuffers(1, iArr, 0);
    }

    public void glDeleteRenderbuffers(int i, IntBuffer intBuffer) {
        GLES20.glDeleteRenderbuffers(i, intBuffer);
    }

    public void glDeleteShader(int i) {
        GLES20.glDeleteShader(i);
    }

    public void glDeleteTexture(int i) {
        int[] iArr = this.ints;
        iArr[0] = i;
        GLES20.glDeleteTextures(1, iArr, 0);
    }

    public void glDeleteTextures(int i, IntBuffer intBuffer) {
        GLES20.glDeleteTextures(i, intBuffer);
    }

    public void glDepthFunc(int i) {
        GLES20.glDepthFunc(i);
    }

    public void glDepthMask(boolean z) {
        GLES20.glDepthMask(z);
    }

    public void glDepthRangef(float f2, float f3) {
        GLES20.glDepthRangef(f2, f3);
    }

    public void glDetachShader(int i, int i2) {
        GLES20.glDetachShader(i, i2);
    }

    public void glDisable(int i) {
        GLES20.glDisable(i);
    }

    public void glDisableVertexAttribArray(int i) {
        GLES20.glDisableVertexAttribArray(i);
    }

    public void glDrawArrays(int i, int i2, int i3) {
        GLES20.glDrawArrays(i, i2, i3);
    }

    public void glDrawElements(int i, int i2, int i3, Buffer buffer2) {
        GLES20.glDrawElements(i, i2, i3, buffer2);
    }

    public void glEnable(int i) {
        GLES20.glEnable(i);
    }

    public void glEnableVertexAttribArray(int i) {
        GLES20.glEnableVertexAttribArray(i);
    }

    public void glFinish() {
        GLES20.glFinish();
    }

    public void glFlush() {
        GLES20.glFlush();
    }

    public void glFramebufferRenderbuffer(int i, int i2, int i3, int i4) {
        GLES20.glFramebufferRenderbuffer(i, i2, i3, i4);
    }

    public void glFramebufferTexture2D(int i, int i2, int i3, int i4, int i5) {
        GLES20.glFramebufferTexture2D(i, i2, i3, i4, i5);
    }

    public void glFrontFace(int i) {
        GLES20.glFrontFace(i);
    }

    public int glGenBuffer() {
        GLES20.glGenBuffers(1, this.ints, 0);
        return this.ints[0];
    }

    public void glGenBuffers(int i, IntBuffer intBuffer) {
        GLES20.glGenBuffers(i, intBuffer);
    }

    public int glGenFramebuffer() {
        GLES20.glGenFramebuffers(1, this.ints, 0);
        return this.ints[0];
    }

    public void glGenFramebuffers(int i, IntBuffer intBuffer) {
        GLES20.glGenFramebuffers(i, intBuffer);
    }

    public int glGenRenderbuffer() {
        GLES20.glGenRenderbuffers(1, this.ints, 0);
        return this.ints[0];
    }

    public void glGenRenderbuffers(int i, IntBuffer intBuffer) {
        GLES20.glGenRenderbuffers(i, intBuffer);
    }

    public int glGenTexture() {
        GLES20.glGenTextures(1, this.ints, 0);
        return this.ints[0];
    }

    public void glGenTextures(int i, IntBuffer intBuffer) {
        GLES20.glGenTextures(i, intBuffer);
    }

    public void glGenerateMipmap(int i) {
        GLES20.glGenerateMipmap(i);
    }

    public String glGetActiveAttrib(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        byte[] bArr = this.buffer;
        GLES20.glGetActiveAttrib(i, i2, bArr.length, this.ints, 0, this.ints2, 0, this.ints3, 0, bArr, 0);
        intBuffer.put(this.ints2[0]);
        intBuffer2.put(this.ints3[0]);
        return new String(this.buffer, 0, this.ints[0]);
    }

    public String glGetActiveUniform(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        byte[] bArr = this.buffer;
        GLES20.glGetActiveUniform(i, i2, bArr.length, this.ints, 0, this.ints2, 0, this.ints3, 0, bArr, 0);
        intBuffer.put(this.ints2[0]);
        intBuffer2.put(this.ints3[0]);
        return new String(this.buffer, 0, this.ints[0]);
    }

    public void glGetAttachedShaders(int i, int i2, Buffer buffer2, IntBuffer intBuffer) {
        GLES20.glGetAttachedShaders(i, i2, (IntBuffer) buffer2, intBuffer);
    }

    public int glGetAttribLocation(int i, String str) {
        return GLES20.glGetAttribLocation(i, str);
    }

    public void glGetBooleanv(int i, Buffer buffer2) {
        GLES20.glGetBooleanv(i, (IntBuffer) buffer2);
    }

    public void glGetBufferParameteriv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetBufferParameteriv(i, i2, intBuffer);
    }

    public int glGetError() {
        return GLES20.glGetError();
    }

    public void glGetFloatv(int i, FloatBuffer floatBuffer) {
        GLES20.glGetFloatv(i, floatBuffer);
    }

    public void glGetFramebufferAttachmentParameteriv(int i, int i2, int i3, IntBuffer intBuffer) {
        GLES20.glGetFramebufferAttachmentParameteriv(i, i2, i3, intBuffer);
    }

    public void glGetIntegerv(int i, IntBuffer intBuffer) {
        GLES20.glGetIntegerv(i, intBuffer);
    }

    public String glGetProgramInfoLog(int i) {
        return GLES20.glGetProgramInfoLog(i);
    }

    public void glGetProgramiv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetProgramiv(i, i2, intBuffer);
    }

    public void glGetRenderbufferParameteriv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetRenderbufferParameteriv(i, i2, intBuffer);
    }

    public String glGetShaderInfoLog(int i) {
        return GLES20.glGetShaderInfoLog(i);
    }

    public void glGetShaderPrecisionFormat(int i, int i2, IntBuffer intBuffer, IntBuffer intBuffer2) {
        GLES20.glGetShaderPrecisionFormat(i, i2, intBuffer, intBuffer2);
    }

    public void glGetShaderiv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetShaderiv(i, i2, intBuffer);
    }

    public String glGetString(int i) {
        return GLES20.glGetString(i);
    }

    public void glGetTexParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glGetTexParameterfv(i, i2, floatBuffer);
    }

    public void glGetTexParameteriv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetTexParameteriv(i, i2, intBuffer);
    }

    public int glGetUniformLocation(int i, String str) {
        return GLES20.glGetUniformLocation(i, str);
    }

    public void glGetUniformfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glGetUniformfv(i, i2, floatBuffer);
    }

    public void glGetUniformiv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetUniformiv(i, i2, intBuffer);
    }

    public void glGetVertexAttribPointerv(int i, int i2, Buffer buffer2) {
    }

    public void glGetVertexAttribfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glGetVertexAttribfv(i, i2, floatBuffer);
    }

    public void glGetVertexAttribiv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glGetVertexAttribiv(i, i2, intBuffer);
    }

    public void glHint(int i, int i2) {
        GLES20.glHint(i, i2);
    }

    public boolean glIsBuffer(int i) {
        return GLES20.glIsBuffer(i);
    }

    public boolean glIsEnabled(int i) {
        return GLES20.glIsEnabled(i);
    }

    public boolean glIsFramebuffer(int i) {
        return GLES20.glIsFramebuffer(i);
    }

    public boolean glIsProgram(int i) {
        return GLES20.glIsProgram(i);
    }

    public boolean glIsRenderbuffer(int i) {
        return GLES20.glIsRenderbuffer(i);
    }

    public boolean glIsShader(int i) {
        return GLES20.glIsShader(i);
    }

    public boolean glIsTexture(int i) {
        return GLES20.glIsTexture(i);
    }

    public void glLineWidth(float f2) {
        GLES20.glLineWidth(f2);
    }

    public void glLinkProgram(int i) {
        GLES20.glLinkProgram(i);
    }

    public void glPixelStorei(int i, int i2) {
        GLES20.glPixelStorei(i, i2);
    }

    public void glPolygonOffset(float f2, float f3) {
        GLES20.glPolygonOffset(f2, f3);
    }

    public void glReadPixels(int i, int i2, int i3, int i4, int i5, int i6, Buffer buffer2) {
        GLES20.glReadPixels(i, i2, i3, i4, i5, i6, buffer2);
    }

    public void glReleaseShaderCompiler() {
        GLES20.glReleaseShaderCompiler();
    }

    public void glRenderbufferStorage(int i, int i2, int i3, int i4) {
        GLES20.glRenderbufferStorage(i, i2, i3, i4);
    }

    public void glSampleCoverage(float f2, boolean z) {
        GLES20.glSampleCoverage(f2, z);
    }

    public void glScissor(int i, int i2, int i3, int i4) {
        GLES20.glScissor(i, i2, i3, i4);
    }

    public void glShaderBinary(int i, IntBuffer intBuffer, int i2, Buffer buffer2, int i3) {
        GLES20.glShaderBinary(i, intBuffer, i2, buffer2, i3);
    }

    public void glShaderSource(int i, String str) {
        GLES20.glShaderSource(i, str);
    }

    public void glStencilFunc(int i, int i2, int i3) {
        GLES20.glStencilFunc(i, i2, i3);
    }

    public void glStencilFuncSeparate(int i, int i2, int i3, int i4) {
        GLES20.glStencilFuncSeparate(i, i2, i3, i4);
    }

    public void glStencilMask(int i) {
        GLES20.glStencilMask(i);
    }

    public void glStencilMaskSeparate(int i, int i2) {
        GLES20.glStencilMaskSeparate(i, i2);
    }

    public void glStencilOp(int i, int i2, int i3) {
        GLES20.glStencilOp(i, i2, i3);
    }

    public void glStencilOpSeparate(int i, int i2, int i3, int i4) {
        GLES20.glStencilOpSeparate(i, i2, i3, i4);
    }

    public void glTexImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer2) {
        GLES20.glTexImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer2);
    }

    public void glTexParameterf(int i, int i2, float f2) {
        GLES20.glTexParameterf(i, i2, f2);
    }

    public void glTexParameterfv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glTexParameterfv(i, i2, floatBuffer);
    }

    public void glTexParameteri(int i, int i2, int i3) {
        GLES20.glTexParameteri(i, i2, i3);
    }

    public void glTexParameteriv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glTexParameteriv(i, i2, intBuffer);
    }

    public void glTexSubImage2D(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Buffer buffer2) {
        GLES20.glTexSubImage2D(i, i2, i3, i4, i5, i6, i7, i8, buffer2);
    }

    public void glUniform1f(int i, float f2) {
        GLES20.glUniform1f(i, f2);
    }

    public void glUniform1fv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glUniform1fv(i, i2, floatBuffer);
    }

    public void glUniform1i(int i, int i2) {
        GLES20.glUniform1i(i, i2);
    }

    public void glUniform1iv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glUniform1iv(i, i2, intBuffer);
    }

    public void glUniform2f(int i, float f2, float f3) {
        GLES20.glUniform2f(i, f2, f3);
    }

    public void glUniform2fv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glUniform2fv(i, i2, floatBuffer);
    }

    public void glUniform2i(int i, int i2, int i3) {
        GLES20.glUniform2i(i, i2, i3);
    }

    public void glUniform2iv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glUniform2iv(i, i2, intBuffer);
    }

    public void glUniform3f(int i, float f2, float f3, float f4) {
        GLES20.glUniform3f(i, f2, f3, f4);
    }

    public void glUniform3fv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glUniform3fv(i, i2, floatBuffer);
    }

    public void glUniform3i(int i, int i2, int i3, int i4) {
        GLES20.glUniform3i(i, i2, i3, i4);
    }

    public void glUniform3iv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glUniform3iv(i, i2, intBuffer);
    }

    public void glUniform4f(int i, float f2, float f3, float f4, float f5) {
        GLES20.glUniform4f(i, f2, f3, f4, f5);
    }

    public void glUniform4fv(int i, int i2, FloatBuffer floatBuffer) {
        GLES20.glUniform4fv(i, i2, floatBuffer);
    }

    public void glUniform4i(int i, int i2, int i3, int i4, int i5) {
        GLES20.glUniform4i(i, i2, i3, i4, i5);
    }

    public void glUniform4iv(int i, int i2, IntBuffer intBuffer) {
        GLES20.glUniform4iv(i, i2, intBuffer);
    }

    public void glUniformMatrix2fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES20.glUniformMatrix2fv(i, i2, z, floatBuffer);
    }

    public void glUniformMatrix3fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES20.glUniformMatrix3fv(i, i2, z, floatBuffer);
    }

    public void glUniformMatrix4fv(int i, int i2, boolean z, FloatBuffer floatBuffer) {
        GLES20.glUniformMatrix4fv(i, i2, z, floatBuffer);
    }

    public void glUseProgram(int i) {
        GLES20.glUseProgram(i);
    }

    public void glValidateProgram(int i) {
        GLES20.glValidateProgram(i);
    }

    public void glVertexAttrib1f(int i, float f2) {
        GLES20.glVertexAttrib1f(i, f2);
    }

    public void glVertexAttrib1fv(int i, FloatBuffer floatBuffer) {
        GLES20.glVertexAttrib1fv(i, floatBuffer);
    }

    public void glVertexAttrib2f(int i, float f2, float f3) {
        GLES20.glVertexAttrib2f(i, f2, f3);
    }

    public void glVertexAttrib2fv(int i, FloatBuffer floatBuffer) {
        GLES20.glVertexAttrib2fv(i, floatBuffer);
    }

    public void glVertexAttrib3f(int i, float f2, float f3, float f4) {
        GLES20.glVertexAttrib3f(i, f2, f3, f4);
    }

    public void glVertexAttrib3fv(int i, FloatBuffer floatBuffer) {
        GLES20.glVertexAttrib3fv(i, floatBuffer);
    }

    public void glVertexAttrib4f(int i, float f2, float f3, float f4, float f5) {
        GLES20.glVertexAttrib4f(i, f2, f3, f4, f5);
    }

    public void glVertexAttrib4fv(int i, FloatBuffer floatBuffer) {
        GLES20.glVertexAttrib4fv(i, floatBuffer);
    }

    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, Buffer buffer2) {
        GLES20.glVertexAttribPointer(i, i2, i3, z, i4, buffer2);
    }

    public void glViewport(int i, int i2, int i3, int i4) {
        GLES20.glViewport(i, i2, i3, i4);
    }

    public void glDrawElements(int i, int i2, int i3, int i4) {
        GLES20.glDrawElements(i, i2, i3, i4);
    }

    public void glUniform1fv(int i, int i2, float[] fArr, int i3) {
        GLES20.glUniform1fv(i, i2, fArr, i3);
    }

    public void glUniform1iv(int i, int i2, int[] iArr, int i3) {
        GLES20.glUniform1iv(i, i2, iArr, i3);
    }

    public void glUniform2fv(int i, int i2, float[] fArr, int i3) {
        GLES20.glUniform2fv(i, i2, fArr, i3);
    }

    public void glUniform2iv(int i, int i2, int[] iArr, int i3) {
        GLES20.glUniform2iv(i, i2, iArr, i3);
    }

    public void glUniform3fv(int i, int i2, float[] fArr, int i3) {
        GLES20.glUniform3fv(i, i2, fArr, i3);
    }

    public void glUniform3iv(int i, int i2, int[] iArr, int i3) {
        GLES20.glUniform3iv(i, i2, iArr, i3);
    }

    public void glUniform4fv(int i, int i2, float[] fArr, int i3) {
        GLES20.glUniform4fv(i, i2, fArr, i3);
    }

    public void glUniform4iv(int i, int i2, int[] iArr, int i3) {
        GLES20.glUniform4iv(i, i2, iArr, i3);
    }

    public void glUniformMatrix2fv(int i, int i2, boolean z, float[] fArr, int i3) {
        GLES20.glUniformMatrix2fv(i, i2, z, fArr, i3);
    }

    public void glUniformMatrix3fv(int i, int i2, boolean z, float[] fArr, int i3) {
        GLES20.glUniformMatrix3fv(i, i2, z, fArr, i3);
    }

    public void glUniformMatrix4fv(int i, int i2, boolean z, float[] fArr, int i3) {
        GLES20.glUniformMatrix4fv(i, i2, z, fArr, i3);
    }

    public void glVertexAttribPointer(int i, int i2, int i3, boolean z, int i4, int i5) {
        GLES20.glVertexAttribPointer(i, i2, i3, z, i4, i5);
    }
}
