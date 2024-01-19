package com.badlogic.gdx.backends.android.surfaceview;

import android.opengl.GLSurfaceView.EGLConfigChooser;

public class GdxEglConfigChooser implements EGLConfigChooser {
    public int mAlphaSize;
    public int mBlueSize;
    public final int[] mConfigAttribs;
    public int mDepthSize;
    public int mGreenSize;
    public int mNumSamples;
    public int mRedSize;
    public int mStencilSize;
    public int[] mValue = new int[1];

    public GdxEglConfigChooser(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.mRedSize = i;
        this.mGreenSize = i2;
        this.mBlueSize = i3;
        this.mAlphaSize = i4;
        this.mDepthSize = i5;
        this.mStencilSize = i6;
        this.mNumSamples = i7;
        this.mConfigAttribs = new int[]{12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:95:0x013f, code lost:
        if (r9 == r0.mAlphaSize) goto L_0x0141;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public javax.microedition.khronos.egl.EGLConfig chooseConfig(javax.microedition.khronos.egl.EGL10 r19, javax.microedition.khronos.egl.EGLDisplay r20) {
        /*
            r18 = this;
            r0 = r18
            r7 = r19
            r8 = r20
            r9 = 1
            int[] r10 = new int[r9]
            int[] r3 = r0.mConfigAttribs
            r4 = 0
            r5 = 0
            r1 = r19
            r2 = r20
            r6 = r10
            r1.eglChooseConfig(r2, r3, r4, r5, r6)
            r11 = 0
            r12 = r10[r11]
            if (r12 <= 0) goto L_0x0157
            javax.microedition.khronos.egl.EGLConfig[] r13 = new javax.microedition.khronos.egl.EGLConfig[r12]
            int[] r3 = r0.mConfigAttribs
            r1 = r19
            r2 = r20
            r4 = r13
            r5 = r12
            r6 = r10
            r1.eglChooseConfig(r2, r3, r4, r5, r6)
            r1 = 0
            r2 = r1
            r3 = r2
            r4 = 0
        L_0x002c:
            if (r4 >= r12) goto L_0x014e
            r5 = r13[r4]
            r6 = 12325(0x3025, float:1.7271E-41)
            int[] r10 = r0.mValue
            boolean r6 = r7.eglGetConfigAttrib(r8, r5, r6, r10)
            if (r6 == 0) goto L_0x003f
            int[] r6 = r0.mValue
            r6 = r6[r11]
            goto L_0x0040
        L_0x003f:
            r6 = 0
        L_0x0040:
            r10 = 12326(0x3026, float:1.7272E-41)
            int[] r14 = r0.mValue
            boolean r10 = r7.eglGetConfigAttrib(r8, r5, r10, r14)
            if (r10 == 0) goto L_0x004f
            int[] r10 = r0.mValue
            r10 = r10[r11]
            goto L_0x0050
        L_0x004f:
            r10 = 0
        L_0x0050:
            int r14 = r0.mDepthSize
            if (r6 < r14) goto L_0x0145
            int r6 = r0.mStencilSize
            if (r10 >= r6) goto L_0x005a
            goto L_0x0145
        L_0x005a:
            r6 = 12324(0x3024, float:1.727E-41)
            int[] r10 = r0.mValue
            boolean r6 = r7.eglGetConfigAttrib(r8, r5, r6, r10)
            if (r6 == 0) goto L_0x0069
            int[] r6 = r0.mValue
            r6 = r6[r11]
            goto L_0x006a
        L_0x0069:
            r6 = 0
        L_0x006a:
            r10 = 12323(0x3023, float:1.7268E-41)
            int[] r14 = r0.mValue
            boolean r10 = r7.eglGetConfigAttrib(r8, r5, r10, r14)
            if (r10 == 0) goto L_0x0079
            int[] r10 = r0.mValue
            r10 = r10[r11]
            goto L_0x007a
        L_0x0079:
            r10 = 0
        L_0x007a:
            r14 = 12322(0x3022, float:1.7267E-41)
            int[] r15 = r0.mValue
            boolean r14 = r7.eglGetConfigAttrib(r8, r5, r14, r15)
            if (r14 == 0) goto L_0x0089
            int[] r14 = r0.mValue
            r14 = r14[r11]
            goto L_0x008a
        L_0x0089:
            r14 = 0
        L_0x008a:
            r15 = 12321(0x3021, float:1.7265E-41)
            int[] r9 = r0.mValue
            boolean r9 = r7.eglGetConfigAttrib(r8, r5, r15, r9)
            if (r9 == 0) goto L_0x0099
            int[] r9 = r0.mValue
            r9 = r9[r11]
            goto L_0x009a
        L_0x0099:
            r9 = 0
        L_0x009a:
            if (r1 != 0) goto L_0x00a7
            r15 = 5
            if (r6 != r15) goto L_0x00a7
            r11 = 6
            if (r10 != r11) goto L_0x00a7
            if (r14 != r15) goto L_0x00a7
            if (r9 != 0) goto L_0x00a7
            r1 = r5
        L_0x00a7:
            if (r2 != 0) goto L_0x00c1
            int r11 = r0.mRedSize
            if (r6 != r11) goto L_0x00c1
            int r11 = r0.mGreenSize
            if (r10 != r11) goto L_0x00c1
            int r11 = r0.mBlueSize
            if (r14 != r11) goto L_0x00c1
            int r11 = r0.mAlphaSize
            if (r9 != r11) goto L_0x00c1
            int r2 = r0.mNumSamples
            if (r2 != 0) goto L_0x00c0
            r2 = r5
            goto L_0x014e
        L_0x00c0:
            r2 = r5
        L_0x00c1:
            r11 = 12338(0x3032, float:1.7289E-41)
            int[] r15 = r0.mValue
            boolean r11 = r7.eglGetConfigAttrib(r8, r5, r11, r15)
            if (r11 == 0) goto L_0x00d2
            int[] r11 = r0.mValue
            r16 = 0
            r11 = r11[r16]
            goto L_0x00d5
        L_0x00d2:
            r16 = 0
            r11 = 0
        L_0x00d5:
            r15 = 12337(0x3031, float:1.7288E-41)
            r17 = r1
            int[] r1 = r0.mValue
            boolean r1 = r7.eglGetConfigAttrib(r8, r5, r15, r1)
            if (r1 == 0) goto L_0x00e6
            int[] r1 = r0.mValue
            r1 = r1[r16]
            goto L_0x00e7
        L_0x00e6:
            r1 = 0
        L_0x00e7:
            if (r3 != 0) goto L_0x0104
            r15 = 1
            if (r11 != r15) goto L_0x0104
            int r11 = r0.mNumSamples
            if (r1 < r11) goto L_0x0104
            int r1 = r0.mRedSize
            if (r6 != r1) goto L_0x0104
            int r1 = r0.mGreenSize
            if (r10 != r1) goto L_0x0104
            int r1 = r0.mBlueSize
            if (r14 != r1) goto L_0x0104
            int r1 = r0.mAlphaSize
            if (r9 != r1) goto L_0x0104
            r15 = 1
            r16 = 0
            goto L_0x0141
        L_0x0104:
            r1 = 12512(0x30e0, float:1.7533E-41)
            int[] r11 = r0.mValue
            boolean r1 = r7.eglGetConfigAttrib(r8, r5, r1, r11)
            if (r1 == 0) goto L_0x0115
            int[] r1 = r0.mValue
            r16 = 0
            r1 = r1[r16]
            goto L_0x0118
        L_0x0115:
            r16 = 0
            r1 = 0
        L_0x0118:
            r11 = 12513(0x30e1, float:1.7534E-41)
            int[] r15 = r0.mValue
            boolean r11 = r7.eglGetConfigAttrib(r8, r5, r11, r15)
            if (r11 == 0) goto L_0x0127
            int[] r11 = r0.mValue
            r11 = r11[r16]
            goto L_0x0128
        L_0x0127:
            r11 = 0
        L_0x0128:
            r15 = 1
            if (r3 != 0) goto L_0x0142
            if (r1 != r15) goto L_0x0142
            int r1 = r0.mNumSamples
            if (r11 < r1) goto L_0x0142
            int r1 = r0.mRedSize
            if (r6 != r1) goto L_0x0142
            int r1 = r0.mGreenSize
            if (r10 != r1) goto L_0x0142
            int r1 = r0.mBlueSize
            if (r14 != r1) goto L_0x0142
            int r1 = r0.mAlphaSize
            if (r9 != r1) goto L_0x0142
        L_0x0141:
            r3 = r5
        L_0x0142:
            r1 = r17
            goto L_0x0148
        L_0x0145:
            r15 = 1
            r16 = 0
        L_0x0148:
            int r4 = r4 + 1
            r9 = 1
            r11 = 0
            goto L_0x002c
        L_0x014e:
            if (r3 == 0) goto L_0x0151
            goto L_0x0156
        L_0x0151:
            if (r2 == 0) goto L_0x0155
            r3 = r2
            goto L_0x0156
        L_0x0155:
            r3 = r1
        L_0x0156:
            return r3
        L_0x0157:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "No configs match configSpec"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.backends.android.surfaceview.GdxEglConfigChooser.chooseConfig(javax.microedition.khronos.egl.EGL10, javax.microedition.khronos.egl.EGLDisplay):javax.microedition.khronos.egl.EGLConfig");
    }
}
