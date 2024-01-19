package co.hyperverge.hvcamera.c.b.a.b;

import android.opengl.GLES20;
import co.hyperverge.hvcamera.magicfilter.utils.e;
import co.hyperverge.hvcamera.magicfilter.utils.f;
import co.hyperverge.hvcamera.magicfilter.utils.j;
import com.badlogic.gdx.graphics.GL20;
import io.sentry.SentryClient;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<Runnable> f2894a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public String f2895b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f2896c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f2897d;

    /* renamed from: e  reason: collision with root package name */
    public int f2898e;

    /* renamed from: f  reason: collision with root package name */
    public int f2899f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public FloatBuffer k;
    public FloatBuffer l;
    public int m;
    public int n;

    public a(String str, String str2) {
        try {
            a("1");
            this.f2894a = new LinkedList<>();
            this.f2895b = str;
            this.f2896c = str2;
            a("2");
            this.k = ByteBuffer.allocateDirect(j.f2944e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            a("3");
            this.k.put(j.f2944e).position(0);
            a("4");
            this.l = ByteBuffer.allocateDirect(j.f2940a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            a("5");
            this.l.put(j.a(f.NORMAL, false, true)).position(0);
            a("6");
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public int a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.f2897d);
        i();
        if (!this.j) {
            return -1;
        }
        floatBuffer.position(0);
        GLES20.glVertexAttribPointer(this.f2898e, 2, GL20.GL_FLOAT, false, 0, floatBuffer);
        GLES20.glEnableVertexAttribArray(this.f2898e);
        floatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.g, 2, GL20.GL_FLOAT, false, 0, floatBuffer2);
        GLES20.glEnableVertexAttribArray(this.g);
        if (i2 != -1) {
            GLES20.glActiveTexture(GL20.GL_TEXTURE0);
            GLES20.glBindTexture(GL20.GL_TEXTURE_2D, i2);
            GLES20.glUniform1i(this.f2899f, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f2898e);
        GLES20.glDisableVertexAttribArray(this.g);
        GLES20.glBindTexture(GL20.GL_TEXTURE_2D, 0);
        return 1;
    }

    public void b() {
        g();
        this.j = true;
    }

    public void g() {
        a(SentryClient.SENTRY_PROTOCOL_VERSION);
        try {
            String str = this.f2895b;
            String str2 = this.f2896c;
            int[] iArr = new int[1];
            int a2 = e.a(str, GL20.GL_VERTEX_SHADER);
            int i2 = 0;
            if (a2 != 0) {
                int a3 = e.a(str2, GL20.GL_FRAGMENT_SHADER);
                if (a3 != 0) {
                    int glCreateProgram = GLES20.glCreateProgram();
                    GLES20.glAttachShader(glCreateProgram, a2);
                    GLES20.glAttachShader(glCreateProgram, a3);
                    GLES20.glLinkProgram(glCreateProgram);
                    GLES20.glGetProgramiv(glCreateProgram, GL20.GL_LINK_STATUS, iArr, 0);
                    if (iArr[0] <= 0) {
                        GLES20.glGetProgramInfoLog(glCreateProgram);
                    } else {
                        GLES20.glDeleteShader(a2);
                        GLES20.glDeleteShader(a3);
                        i2 = glCreateProgram;
                    }
                }
            }
            this.f2897d = i2;
            this.f2898e = GLES20.glGetAttribLocation(i2, "position");
            this.f2899f = GLES20.glGetUniformLocation(this.f2897d, "inputImageTexture");
            this.g = GLES20.glGetAttribLocation(this.f2897d, "inputTextureCoordinate");
            this.j = true;
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public void i() {
        while (!this.f2894a.isEmpty()) {
            this.f2894a.removeFirst().run();
        }
    }

    public int a(int i2, boolean z, boolean z2) {
        GLES20.glUseProgram(this.f2897d);
        i();
        if (!this.j) {
            return -1;
        }
        this.k.position(0);
        GLES20.glVertexAttribPointer(this.f2898e, 2, GL20.GL_FLOAT, false, 0, this.k);
        GLES20.glEnableVertexAttribArray(this.f2898e);
        if (z || z2) {
            float[] fArr = new float[8];
            if (z) {
                fArr = j.a(f.ROTATION_180, false, false);
            } else if (z2) {
                fArr = j.a(f.NORMAL, false, false);
            }
            this.l.clear();
            this.l.put(fArr).position(0);
        }
        this.l.position(0);
        GLES20.glVertexAttribPointer(this.g, 2, GL20.GL_FLOAT, false, 0, this.l);
        GLES20.glEnableVertexAttribArray(this.g);
        if (i2 != -1) {
            GLES20.glActiveTexture(GL20.GL_TEXTURE0);
            GLES20.glBindTexture(GL20.GL_TEXTURE_2D, i2);
            GLES20.glUniform1i(this.f2899f, 0);
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f2898e);
        GLES20.glDisableVertexAttribArray(this.g);
        GLES20.glBindTexture(GL20.GL_TEXTURE_2D, 0);
        return 1;
    }

    public final void a(String str) {
        do {
        } while (GLES20.glGetError() != 0);
    }
}
