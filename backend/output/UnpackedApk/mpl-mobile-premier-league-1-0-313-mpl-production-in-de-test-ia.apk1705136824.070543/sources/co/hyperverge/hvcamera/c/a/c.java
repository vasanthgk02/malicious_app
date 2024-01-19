package co.hyperverge.hvcamera.c.a;

import android.graphics.Bitmap;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.ShutterCallback;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import co.hyperverge.hvcamera.magicfilter.utils.j;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public abstract class c implements Renderer {
    public static int l = -1;

    /* renamed from: a  reason: collision with root package name */
    public co.hyperverge.hvcamera.c.b.a.b.a f2886a;

    /* renamed from: b  reason: collision with root package name */
    public final GLSurfaceView f2887b;

    /* renamed from: c  reason: collision with root package name */
    public int f2888c = -1;

    /* renamed from: d  reason: collision with root package name */
    public final FloatBuffer f2889d;

    /* renamed from: e  reason: collision with root package name */
    public final FloatBuffer f2890e;
    public int g;
    public int h;
    public int i;
    public int j;
    public IntBuffer k;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f2891a;

        public a(int i) {
            this.f2891a = i;
        }

        public void run() {
            co.hyperverge.hvcamera.c.b.a.b.a aVar = c.this.f2886a;
            if (aVar != null) {
                aVar.j = false;
                GLES20.glDeleteProgram(aVar.f2897d);
            }
            c cVar = c.this;
            cVar.f2886a = null;
            cVar.f2886a = new co.hyperverge.hvcamera.c.b.a.b.a("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
            c.l = this.f2891a;
            co.hyperverge.hvcamera.c.b.a.b.a aVar2 = c.this.f2886a;
            if (aVar2 != null) {
                aVar2.b();
            }
            c.this.c();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            co.hyperverge.hvcamera.c.b.a.b.a aVar = c.this.f2886a;
            aVar.j = false;
            GLES20.glDeleteProgram(aVar.f2897d);
        }
    }

    public c(GLSurfaceView gLSurfaceView) {
        this.f2887b = gLSurfaceView;
        this.f2886a = new co.hyperverge.hvcamera.c.b.a.b.a("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(j.f2944e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2889d = asFloatBuffer;
        asFloatBuffer.put(j.f2944e).position(0);
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(j.f2940a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2890e = asFloatBuffer2;
        asFloatBuffer2.put(j.f2940a).position(0);
        this.f2887b.setEGLContextClientVersion(2);
        this.f2887b.setRenderer(this);
        this.f2887b.setRenderMode(0);
    }

    public abstract void a();

    public abstract void a(float f2, float f3, AutoFocusCallback autoFocusCallback);

    public void a(int i2) {
        this.f2887b.queueEvent(new a(i2));
        this.f2887b.requestRender();
    }

    public abstract void a(Bitmap bitmap, File file, boolean z, boolean z2, int i2);

    public abstract void a(File file, co.hyperverge.hvcamera.magicfilter.utils.g.a aVar, ShutterCallback shutterCallback);

    public void b() {
        this.f2887b.queueEvent(new b());
    }

    public void c() {
        co.hyperverge.hvcamera.c.b.a.b.a aVar = this.f2886a;
        if (aVar != null) {
            int i2 = this.g;
            int i3 = this.h;
            aVar.m = i2;
            aVar.n = i3;
            int i4 = this.i;
            int i5 = this.j;
            aVar.h = i4;
            aVar.i = i5;
        }
    }

    public abstract void d();

    public abstract void e();
}
