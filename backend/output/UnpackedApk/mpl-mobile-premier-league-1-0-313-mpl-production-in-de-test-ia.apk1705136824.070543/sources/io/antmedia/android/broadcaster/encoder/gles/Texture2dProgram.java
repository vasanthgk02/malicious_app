package io.antmedia.android.broadcaster.encoder.gles;

import android.opengl.GLES20;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import java.nio.FloatBuffer;

public class Texture2dProgram {
    public static final String FRAGMENT_SHADER_2D = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    public static final String FRAGMENT_SHADER_EXT = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    public static final String FRAGMENT_SHADER_EXT_BW = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n";
    public static final String FRAGMENT_SHADER_EXT_FILT = "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n";
    public static final int KERNEL_SIZE = 9;
    public static final String TAG = "Grafika";
    public static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    public float mColorAdjust;
    public float[] mKernel = new float[9];
    public int mProgramHandle;
    public ProgramType mProgramType;
    public float[] mTexOffset;
    public int mTextureTarget;
    public int maPositionLoc;
    public int maTextureCoordLoc;
    public int muColorAdjustLoc;
    public int muKernelLoc;
    public int muMVPMatrixLoc;
    public int muTexMatrixLoc;
    public int muTexOffsetLoc;

    /* renamed from: io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001d */
        static {
            /*
                io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram$ProgramType[] r0 = io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram.ProgramType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType = r0
                r1 = 1
                io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram$ProgramType r2 = io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram.ProgramType.TEXTURE_2D     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram$ProgramType r3 = io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram.ProgramType.TEXTURE_EXT     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram$ProgramType r3 = io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram.ProgramType.TEXTURE_EXT_BW     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Texture2dProgram$ProgramType     // Catch:{ NoSuchFieldError -> 0x0024 }
                io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram$ProgramType r2 = io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram.ProgramType.TEXTURE_EXT_FILT     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.antmedia.android.broadcaster.encoder.gles.Texture2dProgram.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ProgramType {
        TEXTURE_2D,
        TEXTURE_EXT,
        TEXTURE_EXT_BW,
        TEXTURE_EXT_FILT
    }

    public Texture2dProgram(ProgramType programType) {
        this.mProgramType = programType;
        int ordinal = programType.ordinal();
        if (ordinal == 0) {
            this.mTextureTarget = GL20.GL_TEXTURE_2D;
            this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_2D);
        } else if (ordinal == 1) {
            this.mTextureTarget = 36197;
            this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT);
        } else if (ordinal == 2) {
            this.mTextureTarget = 36197;
            this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT_BW);
        } else if (ordinal == 3) {
            this.mTextureTarget = 36197;
            this.mProgramHandle = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER_EXT_FILT);
        } else {
            throw new RuntimeException("Unhandled type " + programType);
        }
        if (this.mProgramHandle != 0) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Created program ");
            outline73.append(this.mProgramHandle);
            outline73.append(" (");
            outline73.append(programType);
            outline73.append(")");
            outline73.toString();
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.maPositionLoc = glGetAttribLocation;
            GlUtil.checkLocation(glGetAttribLocation, "aPosition");
            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
            this.maTextureCoordLoc = glGetAttribLocation2;
            GlUtil.checkLocation(glGetAttribLocation2, "aTextureCoord");
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
            this.muMVPMatrixLoc = glGetUniformLocation;
            GlUtil.checkLocation(glGetUniformLocation, "uMVPMatrix");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
            this.muTexMatrixLoc = glGetUniformLocation2;
            GlUtil.checkLocation(glGetUniformLocation2, "uTexMatrix");
            int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.mProgramHandle, "uKernel");
            this.muKernelLoc = glGetUniformLocation3;
            if (glGetUniformLocation3 < 0) {
                this.muKernelLoc = -1;
                this.muTexOffsetLoc = -1;
                this.muColorAdjustLoc = -1;
                return;
            }
            int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexOffset");
            this.muTexOffsetLoc = glGetUniformLocation4;
            GlUtil.checkLocation(glGetUniformLocation4, "uTexOffset");
            int glGetUniformLocation5 = GLES20.glGetUniformLocation(this.mProgramHandle, "uColorAdjust");
            this.muColorAdjustLoc = glGetUniformLocation5;
            GlUtil.checkLocation(glGetUniformLocation5, "uColorAdjust");
            setKernel(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
            setTexSize(256, 256);
            return;
        }
        throw new RuntimeException("Unable to create program");
    }

    public int createTextureObject() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.checkGlError("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(this.mTextureTarget, i);
        GlUtil.checkGlError("glBindTexture " + i);
        GLES20.glTexParameterf(36197, GL20.GL_TEXTURE_MIN_FILTER, 9728.0f);
        GLES20.glTexParameterf(36197, GL20.GL_TEXTURE_MAG_FILTER, 9729.0f);
        GLES20.glTexParameteri(36197, GL20.GL_TEXTURE_WRAP_S, GL20.GL_CLAMP_TO_EDGE);
        GLES20.glTexParameteri(36197, GL20.GL_TEXTURE_WRAP_T, GL20.GL_CLAMP_TO_EDGE);
        GlUtil.checkGlError("glTexParameter");
        return i;
    }

    public void draw(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6) {
        GlUtil.checkGlError("draw start");
        GLES20.glUseProgram(this.mProgramHandle);
        GlUtil.checkGlError("glUseProgram");
        GLES20.glActiveTexture(GL20.GL_TEXTURE0);
        GLES20.glBindTexture(this.mTextureTarget, i5);
        float[] fArr3 = fArr;
        GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, fArr, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.muTexMatrixLoc, 1, false, fArr2, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.maPositionLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maPositionLoc, i3, GL20.GL_FLOAT, false, i4, floatBuffer);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.maTextureCoordLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.maTextureCoordLoc, 2, GL20.GL_FLOAT, false, i6, floatBuffer2);
        GlUtil.checkGlError("glVertexAttribPointer");
        int i7 = this.muKernelLoc;
        if (i7 >= 0) {
            GLES20.glUniform1fv(i7, 9, this.mKernel, 0);
            GLES20.glUniform2fv(this.muTexOffsetLoc, 9, this.mTexOffset, 0);
            GLES20.glUniform1f(this.muColorAdjustLoc, this.mColorAdjust);
        }
        int i8 = i;
        int i9 = i2;
        GLES20.glDrawArrays(5, i, i2);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.maPositionLoc);
        GLES20.glDisableVertexAttribArray(this.maTextureCoordLoc);
        GLES20.glBindTexture(this.mTextureTarget, 0);
        GLES20.glUseProgram(0);
    }

    public ProgramType getProgramType() {
        return this.mProgramType;
    }

    public void release() {
        GLES20.glDeleteProgram(this.mProgramHandle);
        this.mProgramHandle = -1;
    }

    public void setKernel(float[] fArr, float f2) {
        if (fArr.length == 9) {
            System.arraycopy(fArr, 0, this.mKernel, 0, 9);
            this.mColorAdjust = f2;
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Kernel size is ");
        outline73.append(fArr.length);
        outline73.append(" vs. ");
        outline73.append(9);
        throw new IllegalArgumentException(outline73.toString());
    }

    public void setTexSize(int i, int i2) {
        float f2 = 1.0f / ((float) i);
        float f3 = 1.0f / ((float) i2);
        float f4 = -f2;
        float f5 = -f3;
        this.mTexOffset = new float[]{f4, f5, 0.0f, f5, f2, f5, f4, 0.0f, 0.0f, 0.0f, f2, 0.0f, f4, f3, 0.0f, f3, f2, f3};
    }
}
