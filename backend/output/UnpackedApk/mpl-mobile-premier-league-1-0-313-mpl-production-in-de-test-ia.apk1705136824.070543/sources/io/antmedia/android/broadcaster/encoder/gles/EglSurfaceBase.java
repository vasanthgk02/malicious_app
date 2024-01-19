package io.antmedia.android.broadcaster.encoder.gles;

import android.opengl.EGL14;
import android.opengl.EGLSurface;

public class EglSurfaceBase {
    public static final String TAG = "Grafika";
    public EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    public EglCore mEglCore;
    public int mHeight = -1;
    public int mWidth = -1;

    public EglSurfaceBase(EglCore eglCore) {
        this.mEglCore = eglCore;
    }

    public void createOffscreenSurface(int i, int i2) {
        if (this.mEGLSurface == EGL14.EGL_NO_SURFACE) {
            this.mEGLSurface = this.mEglCore.createOffscreenSurface(i, i2);
            this.mWidth = i;
            this.mHeight = i2;
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void createWindowSurface(Object obj) {
        if (this.mEGLSurface == EGL14.EGL_NO_SURFACE) {
            this.mEGLSurface = this.mEglCore.createWindowSurface(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public int getHeight() {
        int i = this.mHeight;
        return i < 0 ? this.mEglCore.querySurface(this.mEGLSurface, 12374) : i;
    }

    public int getWidth() {
        int i = this.mWidth;
        return i < 0 ? this.mEglCore.querySurface(this.mEGLSurface, 12375) : i;
    }

    public void makeCurrent() {
        this.mEglCore.makeCurrent(this.mEGLSurface);
    }

    public void makeCurrentReadFrom(EglSurfaceBase eglSurfaceBase) {
        this.mEglCore.makeCurrent(this.mEGLSurface, eglSurfaceBase.mEGLSurface);
    }

    public void releaseEglSurface() {
        this.mEglCore.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveFrame(java.io.File r11) throws java.io.IOException {
        /*
            r10 = this;
            io.antmedia.android.broadcaster.encoder.gles.EglCore r0 = r10.mEglCore
            android.opengl.EGLSurface r1 = r10.mEGLSurface
            boolean r0 = r0.isCurrent(r1)
            if (r0 == 0) goto L_0x0063
            java.lang.String r11 = r11.toString()
            int r7 = r10.getWidth()
            int r8 = r10.getHeight()
            int r0 = r7 * r8
            int r0 = r0 * 4
            java.nio.ByteBuffer r9 = java.nio.ByteBuffer.allocateDirect(r0)
            java.nio.ByteOrder r0 = java.nio.ByteOrder.LITTLE_ENDIAN
            r9.order(r0)
            r0 = 0
            r1 = 0
            r4 = 6408(0x1908, float:8.98E-42)
            r5 = 5121(0x1401, float:7.176E-42)
            r2 = r7
            r3 = r8
            r6 = r9
            android.opengl.GLES20.glReadPixels(r0, r1, r2, r3, r4, r5, r6)
            java.lang.String r0 = "glReadPixels"
            io.antmedia.android.broadcaster.encoder.gles.GlUtil.checkGlError(r0)
            r9.rewind()
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x005c }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x005c }
            r2.<init>(r11)     // Catch:{ all -> 0x005c }
            r1.<init>(r2)     // Catch:{ all -> 0x005c }
            android.graphics.Bitmap$Config r11 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0059 }
            android.graphics.Bitmap r11 = android.graphics.Bitmap.createBitmap(r7, r8, r11)     // Catch:{ all -> 0x0059 }
            r11.copyPixelsFromBuffer(r9)     // Catch:{ all -> 0x0059 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x0059 }
            r2 = 90
            r11.compress(r0, r2, r1)     // Catch:{ all -> 0x0059 }
            r11.recycle()     // Catch:{ all -> 0x0059 }
            r1.close()
            return
        L_0x0059:
            r11 = move-exception
            r0 = r1
            goto L_0x005d
        L_0x005c:
            r11 = move-exception
        L_0x005d:
            if (r0 == 0) goto L_0x0062
            r0.close()
        L_0x0062:
            throw r11
        L_0x0063:
            java.lang.RuntimeException r11 = new java.lang.RuntimeException
            java.lang.String r0 = "Expected EGL context/surface is not current"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.antmedia.android.broadcaster.encoder.gles.EglSurfaceBase.saveFrame(java.io.File):void");
    }

    public void setPresentationTime(long j) {
        this.mEglCore.setPresentationTime(this.mEGLSurface, j);
    }

    public boolean swapBuffers() {
        return this.mEglCore.swapBuffers(this.mEGLSurface);
    }
}
