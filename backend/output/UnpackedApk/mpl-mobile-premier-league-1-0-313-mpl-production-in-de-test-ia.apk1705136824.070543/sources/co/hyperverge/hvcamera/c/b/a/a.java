package co.hyperverge.hvcamera.c.b.a;

import android.opengl.GLES20;
import com.badlogic.gdx.graphics.GL20;
import java.nio.FloatBuffer;

public class a extends co.hyperverge.hvcamera.c.b.a.b.a {
    public static int[] s;
    public static int[] t;
    public float[] o;
    public int p;
    public int q = -1;
    public int r = -1;

    public a() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n\nvoid main()\n{\n\ttextureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n\tgl_Position = position;\n}", "#extension GL_OES_EGL_image_external : require\nvarying highp vec2 textureCoordinate;\n\nuniform samplerExternalOES inputImageTexture;\n\nvoid main()\n{\n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public int a(int i, boolean z, boolean z2) {
        GLES20.glUseProgram(this.f2897d);
        if (!this.j) {
            return -1;
        }
        this.k.position(0);
        GLES20.glVertexAttribPointer(this.f2898e, 2, GL20.GL_FLOAT, false, 0, this.k);
        GLES20.glEnableVertexAttribArray(this.f2898e);
        this.l.position(0);
        GLES20.glVertexAttribPointer(this.g, 2, GL20.GL_FLOAT, false, 0, this.l);
        GLES20.glEnableVertexAttribArray(this.g);
        GLES20.glUniformMatrix4fv(this.p, 1, false, this.o, 0);
        if (i != -1) {
            GLES20.glActiveTexture(GL20.GL_TEXTURE0);
            GLES20.glBindTexture(36197, i);
            GLES20.glUniform1i(this.f2899f, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f2898e);
        GLES20.glDisableVertexAttribArray(this.g);
        GLES20.glBindTexture(36197, 0);
        return 1;
    }

    public void c(int i, int i2) {
        if (!(s == null || (this.q == i && this.r == i2))) {
            j();
        }
        if (s == null) {
            this.q = i;
            this.r = i2;
            int[] iArr = new int[1];
            s = iArr;
            t = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            GLES20.glGenTextures(1, t, 0);
            GLES20.glBindTexture(GL20.GL_TEXTURE_2D, t[0]);
            GLES20.glTexImage2D(GL20.GL_TEXTURE_2D, 0, GL20.GL_RGBA, i, i2, 0, GL20.GL_RGBA, GL20.GL_UNSIGNED_BYTE, null);
            GLES20.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MAG_FILTER, 9729.0f);
            GLES20.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MIN_FILTER, 9729.0f);
            GLES20.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_S, 33071.0f);
            GLES20.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_T, 33071.0f);
            GLES20.glBindFramebuffer(GL20.GL_FRAMEBUFFER, s[0]);
            GLES20.glFramebufferTexture2D(GL20.GL_FRAMEBUFFER, GL20.GL_COLOR_ATTACHMENT0, GL20.GL_TEXTURE_2D, t[0], 0);
            GLES20.glBindTexture(GL20.GL_TEXTURE_2D, 0);
            GLES20.glBindFramebuffer(GL20.GL_FRAMEBUFFER, 0);
        }
    }

    public void g() {
        super.g();
        this.p = GLES20.glGetUniformLocation(this.f2897d, "textureTransform");
    }

    public void j() {
        int[] iArr = t;
        if (iArr != null) {
            GLES20.glDeleteTextures(1, iArr, 0);
            t = null;
        }
        int[] iArr2 = s;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(1, iArr2, 0);
            s = null;
        }
        this.q = -1;
        this.r = -1;
    }

    public int a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.f2897d);
        if (!this.j) {
            return -1;
        }
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.f2898e, 2, GL20.GL_FLOAT, false, 0, floatBuffer);
        GLES20.glEnableVertexAttribArray(this.f2898e);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.g, 2, GL20.GL_FLOAT, false, 0, floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.g);
        GLES20.glUniformMatrix4fv(this.p, 1, false, this.o, 0);
        if (i != -1) {
            GLES20.glActiveTexture(GL20.GL_TEXTURE0);
            GLES20.glBindTexture(36197, i);
            GLES20.glUniform1i(this.f2899f, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f2898e);
        GLES20.glDisableVertexAttribArray(this.g);
        GLES20.glBindTexture(36197, 0);
        return 1;
    }

    public int a(int i) {
        if (s == null) {
            return -1;
        }
        GLES20.glViewport(0, 0, this.h, this.i);
        GLES20.glBindFramebuffer(GL20.GL_FRAMEBUFFER, s[0]);
        GLES20.glUseProgram(this.f2897d);
        if (!this.j) {
            return -1;
        }
        this.k.position(0);
        GLES20.glVertexAttribPointer(this.f2898e, 2, GL20.GL_FLOAT, false, 0, this.k);
        GLES20.glEnableVertexAttribArray(this.f2898e);
        this.l.position(0);
        GLES20.glVertexAttribPointer(this.g, 2, GL20.GL_FLOAT, false, 0, this.l);
        GLES20.glEnableVertexAttribArray(this.g);
        GLES20.glUniformMatrix4fv(this.p, 1, false, this.o, 0);
        if (i != -1) {
            GLES20.glActiveTexture(GL20.GL_TEXTURE0);
            GLES20.glBindTexture(36197, i);
            GLES20.glUniform1i(this.f2899f, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f2898e);
        GLES20.glDisableVertexAttribArray(this.g);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindFramebuffer(GL20.GL_FRAMEBUFFER, 0);
        GLES20.glViewport(0, 0, this.m, this.n);
        return t[0];
    }
}
