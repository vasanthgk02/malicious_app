package com.badlogic.gdx.graphics.g2d;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class Gdx2DPixmap implements Disposable {
    public static final int GDX2D_BLEND_NONE = 0;
    public static final int GDX2D_BLEND_SRC_OVER = 1;
    public static final int GDX2D_FORMAT_ALPHA = 1;
    public static final int GDX2D_FORMAT_LUMINANCE_ALPHA = 2;
    public static final int GDX2D_FORMAT_RGB565 = 5;
    public static final int GDX2D_FORMAT_RGB888 = 3;
    public static final int GDX2D_FORMAT_RGBA4444 = 6;
    public static final int GDX2D_FORMAT_RGBA8888 = 4;
    public static final int GDX2D_SCALE_LINEAR = 1;
    public static final int GDX2D_SCALE_NEAREST = 0;
    public long basePtr;
    public int format;
    public int height;
    public long[] nativeData;
    public ByteBuffer pixelPtr;
    public int width;

    public Gdx2DPixmap(byte[] bArr, int i, int i2, int i3) throws IOException {
        long[] jArr = new long[4];
        this.nativeData = jArr;
        ByteBuffer load = load(jArr, bArr, i, i2);
        this.pixelPtr = load;
        if (load != null) {
            long[] jArr2 = this.nativeData;
            this.basePtr = jArr2[0];
            this.width = (int) jArr2[1];
            this.height = (int) jArr2[2];
            int i4 = (int) jArr2[3];
            this.format = i4;
            if (i3 != 0 && i3 != i4) {
                convert(i3);
                return;
            }
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error loading pixmap: ");
        outline73.append(getFailureReason());
        throw new IOException(outline73.toString());
    }

    public static native void clear(long j, int i);

    private void convert(int i) {
        Gdx2DPixmap gdx2DPixmap = new Gdx2DPixmap(this.width, this.height, i);
        gdx2DPixmap.setBlend(0);
        gdx2DPixmap.drawPixmap(this, 0, 0, 0, 0, this.width, this.height);
        dispose();
        this.basePtr = gdx2DPixmap.basePtr;
        this.format = gdx2DPixmap.format;
        this.height = gdx2DPixmap.height;
        this.nativeData = gdx2DPixmap.nativeData;
        this.pixelPtr = gdx2DPixmap.pixelPtr;
        this.width = gdx2DPixmap.width;
    }

    public static native void drawCircle(long j, int i, int i2, int i3, int i4);

    public static native void drawLine(long j, int i, int i2, int i3, int i4, int i5);

    public static native void drawPixmap(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static native void drawRect(long j, int i, int i2, int i3, int i4, int i5);

    public static native void fillCircle(long j, int i, int i2, int i3, int i4);

    public static native void fillRect(long j, int i, int i2, int i3, int i4, int i5);

    public static native void fillTriangle(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static native void free(long j);

    public static native String getFailureReason();

    public static String getFormatString(int i) {
        switch (i) {
            case 1:
                return "alpha";
            case 2:
                return "luminance alpha";
            case 3:
                return "rgb888";
            case 4:
                return "rgba8888";
            case 5:
                return "rgb565";
            case 6:
                return "rgba4444";
            default:
                return "unknown";
        }
    }

    public static native int getPixel(long j, int i, int i2);

    public static native ByteBuffer load(long[] jArr, byte[] bArr, int i, int i2);

    public static Gdx2DPixmap newPixmap(InputStream inputStream, int i) {
        try {
            return new Gdx2DPixmap(inputStream, i);
        } catch (IOException unused) {
            return null;
        }
    }

    public static native ByteBuffer newPixmap(long[] jArr, int i, int i2, int i3);

    public static native void setBlend(long j, int i);

    public static native void setPixel(long j, int i, int i2, int i3);

    public static native void setScale(long j, int i);

    public static int toGlFormat(int i) {
        switch (i) {
            case 1:
                return GL20.GL_ALPHA;
            case 2:
                return GL20.GL_LUMINANCE_ALPHA;
            case 3:
            case 5:
                return GL20.GL_RGB;
            case 4:
            case 6:
                return GL20.GL_RGBA;
            default:
                throw new GdxRuntimeException(GeneratedOutlineSupport.outline41("unknown format: ", i));
        }
    }

    public static int toGlType(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                return GL20.GL_UNSIGNED_BYTE;
            case 5:
                return GL20.GL_UNSIGNED_SHORT_5_6_5;
            case 6:
                return GL20.GL_UNSIGNED_SHORT_4_4_4_4;
            default:
                throw new GdxRuntimeException(GeneratedOutlineSupport.outline41("unknown format: ", i));
        }
    }

    public void clear(int i) {
        clear(this.basePtr, i);
    }

    public void dispose() {
        free(this.basePtr);
    }

    public void drawCircle(int i, int i2, int i3, int i4) {
        drawCircle(this.basePtr, i, i2, i3, i4);
    }

    public void drawLine(int i, int i2, int i3, int i4, int i5) {
        drawLine(this.basePtr, i, i2, i3, i4, i5);
    }

    public void drawPixmap(Gdx2DPixmap gdx2DPixmap, int i, int i2, int i3, int i4, int i5, int i6) {
        drawPixmap(gdx2DPixmap.basePtr, this.basePtr, i, i2, i5, i6, i3, i4, i5, i6);
    }

    public void drawRect(int i, int i2, int i3, int i4, int i5) {
        drawRect(this.basePtr, i, i2, i3, i4, i5);
    }

    public void fillCircle(int i, int i2, int i3, int i4) {
        fillCircle(this.basePtr, i, i2, i3, i4);
    }

    public void fillRect(int i, int i2, int i3, int i4, int i5) {
        fillRect(this.basePtr, i, i2, i3, i4, i5);
    }

    public void fillTriangle(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        fillTriangle(this.basePtr, i, i2, i3, i4, i5, i6, i7);
    }

    public int getFormat() {
        return this.format;
    }

    public String getFormatString() {
        return getFormatString(this.format);
    }

    public int getGLFormat() {
        return getGLInternalFormat();
    }

    public int getGLInternalFormat() {
        return toGlFormat(this.format);
    }

    public int getGLType() {
        return toGlType(this.format);
    }

    public int getHeight() {
        return this.height;
    }

    public int getPixel(int i, int i2) {
        return getPixel(this.basePtr, i, i2);
    }

    public ByteBuffer getPixels() {
        return this.pixelPtr;
    }

    public int getWidth() {
        return this.width;
    }

    public void setBlend(int i) {
        setBlend(this.basePtr, i);
    }

    public void setPixel(int i, int i2, int i3) {
        setPixel(this.basePtr, i, i2, i3);
    }

    public void setScale(int i) {
        setScale(this.basePtr, i);
    }

    public static Gdx2DPixmap newPixmap(int i, int i2, int i3) {
        try {
            return new Gdx2DPixmap(i, i2, i3);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public void drawPixmap(Gdx2DPixmap gdx2DPixmap, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        drawPixmap(gdx2DPixmap.basePtr, this.basePtr, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public Gdx2DPixmap(InputStream inputStream, int i) throws IOException {
        this.nativeData = new long[4];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ByteBuffer load = load(this.nativeData, byteArray, 0, byteArray.length);
        this.pixelPtr = load;
        if (load != null) {
            long[] jArr = this.nativeData;
            this.basePtr = jArr[0];
            this.width = (int) jArr[1];
            this.height = (int) jArr[2];
            int i2 = (int) jArr[3];
            this.format = i2;
            if (i != 0 && i != i2) {
                convert(i);
                return;
            }
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error loading pixmap: ");
        outline73.append(getFailureReason());
        throw new IOException(outline73.toString());
    }

    public Gdx2DPixmap(int i, int i2, int i3) throws GdxRuntimeException {
        long[] jArr = new long[4];
        this.nativeData = jArr;
        ByteBuffer newPixmap = newPixmap(jArr, i, i2, i3);
        this.pixelPtr = newPixmap;
        if (newPixmap != null) {
            long[] jArr2 = this.nativeData;
            this.basePtr = jArr2[0];
            this.width = (int) jArr2[1];
            this.height = (int) jArr2[2];
            this.format = (int) jArr2[3];
            return;
        }
        StringBuilder outline75 = GeneratedOutlineSupport.outline75("Unable to allocate memory for pixmap: ", i, "x", i2, ", ");
        outline75.append(getFormatString(i3));
        throw new GdxRuntimeException(outline75.toString());
    }

    public Gdx2DPixmap(ByteBuffer byteBuffer, long[] jArr) {
        this.nativeData = new long[4];
        this.pixelPtr = byteBuffer;
        this.basePtr = jArr[0];
        this.width = (int) jArr[1];
        this.height = (int) jArr[2];
        this.format = (int) jArr[3];
    }
}
