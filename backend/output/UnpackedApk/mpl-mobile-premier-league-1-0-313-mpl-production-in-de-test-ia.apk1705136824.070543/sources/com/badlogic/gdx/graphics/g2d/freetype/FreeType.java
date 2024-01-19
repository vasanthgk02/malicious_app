package com.badlogic.gdx.graphics.g2d.freetype;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.LongMap;
import com.badlogic.gdx.utils.LongMap.Values;
import com.badlogic.gdx.utils.SharedLibraryLoader;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel.MapMode;
import org.apache.pdfbox.filter.ASCII85InputStream;
import sfs2x.client.entities.invitation.InvitationReply;

public class FreeType {
    public static int FT_ENCODING_ADOBE_CUSTOM = encode('A', 'D', 'B', 'C');
    public static int FT_ENCODING_ADOBE_EXPERT = encode('A', 'D', 'B', 'E');
    public static int FT_ENCODING_ADOBE_LATIN_1 = encode('l', 'a', 't', '1');
    public static int FT_ENCODING_ADOBE_STANDARD = encode('A', 'D', 'O', 'B');
    public static int FT_ENCODING_APPLE_ROMAN = encode('a', 'r', 'm', 'n');
    public static int FT_ENCODING_BIG5 = encode('b', 'i', 'g', '5');
    public static int FT_ENCODING_GB2312 = encode('g', 'b', ' ', ' ');
    public static int FT_ENCODING_JOHAB = encode('j', 'o', 'h', 'a');
    public static int FT_ENCODING_MS_SYMBOL = encode('s', 'y', 'm', 'b');
    public static int FT_ENCODING_NONE = 0;
    public static int FT_ENCODING_OLD_LATIN_2 = encode('l', 'a', 't', '2');
    public static int FT_ENCODING_SJIS = encode('s', 'j', 'i', 's');
    public static int FT_ENCODING_UNICODE = encode(ASCII85InputStream.PADDING_U, 'n', 'i', 'c');
    public static int FT_ENCODING_WANSUNG = encode('w', 'a', 'n', 's');
    public static int FT_FACE_FLAG_CID_KEYED = 4096;
    public static int FT_FACE_FLAG_EXTERNAL_STREAM = 1024;
    public static int FT_FACE_FLAG_FAST_GLYPHS = 128;
    public static int FT_FACE_FLAG_FIXED_SIZES = 2;
    public static int FT_FACE_FLAG_FIXED_WIDTH = 4;
    public static int FT_FACE_FLAG_GLYPH_NAMES = 512;
    public static int FT_FACE_FLAG_HINTER = 2048;
    public static int FT_FACE_FLAG_HORIZONTAL = 16;
    public static int FT_FACE_FLAG_KERNING = 64;
    public static int FT_FACE_FLAG_MULTIPLE_MASTERS = 256;
    public static int FT_FACE_FLAG_SCALABLE = 1;
    public static int FT_FACE_FLAG_SFNT = 8;
    public static int FT_FACE_FLAG_TRICKY = 8192;
    public static int FT_FACE_FLAG_VERTICAL = 32;
    public static int FT_KERNING_DEFAULT = 0;
    public static int FT_KERNING_UNFITTED = 1;
    public static int FT_KERNING_UNSCALED = 2;
    public static int FT_LOAD_CROP_BITMAP = 64;
    public static int FT_LOAD_DEFAULT = 0;
    public static int FT_LOAD_FORCE_AUTOHINT = 32;
    public static int FT_LOAD_IGNORE_GLOBAL_ADVANCE_WIDTH = 512;
    public static int FT_LOAD_IGNORE_TRANSFORM = 2048;
    public static int FT_LOAD_LINEAR_DESIGN = 8192;
    public static int FT_LOAD_MONOCHROME = 4096;
    public static int FT_LOAD_NO_AUTOHINT = 32768;
    public static int FT_LOAD_NO_BITMAP = 8;
    public static int FT_LOAD_NO_HINTING = 2;
    public static int FT_LOAD_NO_RECURSE = 1024;
    public static int FT_LOAD_NO_SCALE = 1;
    public static int FT_LOAD_PEDANTIC = 128;
    public static int FT_LOAD_RENDER = 4;
    public static int FT_LOAD_TARGET_LCD = 196608;
    public static int FT_LOAD_TARGET_LCD_V = 262144;
    public static int FT_LOAD_TARGET_LIGHT = 65536;
    public static int FT_LOAD_TARGET_MONO = 131072;
    public static int FT_LOAD_TARGET_NORMAL = 0;
    public static int FT_LOAD_VERTICAL_LAYOUT = 16;
    public static int FT_PIXEL_MODE_GRAY = 2;
    public static int FT_PIXEL_MODE_GRAY2 = 3;
    public static int FT_PIXEL_MODE_GRAY4 = 4;
    public static int FT_PIXEL_MODE_LCD = 5;
    public static int FT_PIXEL_MODE_LCD_V = 6;
    public static int FT_PIXEL_MODE_MONO = 1;
    public static int FT_PIXEL_MODE_NONE;
    public static int FT_RENDER_MODE_LCD = 3;
    public static int FT_RENDER_MODE_LCD_V = 4;
    public static int FT_RENDER_MODE_LIGHT = 1;
    public static int FT_RENDER_MODE_MAX = 5;
    public static int FT_RENDER_MODE_MONO = 2;
    public static int FT_RENDER_MODE_NORMAL = 0;
    public static int FT_STROKER_LINECAP_BUTT = 0;
    public static int FT_STROKER_LINECAP_ROUND = 1;
    public static int FT_STROKER_LINECAP_SQUARE = 2;
    public static int FT_STROKER_LINEJOIN_BEVEL = 1;
    public static int FT_STROKER_LINEJOIN_MITER = 2;
    public static int FT_STROKER_LINEJOIN_MITER_FIXED = 3;
    public static int FT_STROKER_LINEJOIN_MITER_VARIABLE = 2;
    public static int FT_STROKER_LINEJOIN_ROUND = 0;
    public static int FT_STYLE_FLAG_BOLD = 2;
    public static int FT_STYLE_FLAG_ITALIC = 1;

    public static class Bitmap extends Pointer {
        public Bitmap(long j) {
            super(j);
        }

        public static native ByteBuffer getBuffer(long j);

        public static native int getNumGray(long j);

        public static native int getPitch(long j);

        public static native int getPixelMode(long j);

        public static native int getRows(long j);

        public static native int getWidth(long j);

        public ByteBuffer getBuffer() {
            if (getRows() == 0) {
                return BufferUtils.newByteBuffer(1);
            }
            return getBuffer(this.address);
        }

        public int getNumGray() {
            return getNumGray(this.address);
        }

        public int getPitch() {
            return getPitch(this.address);
        }

        public int getPixelMode() {
            return getPixelMode(this.address);
        }

        public Pixmap getPixmap(Format format, Color color, float f2) {
            Pixmap pixmap;
            int i;
            int i2;
            int i3;
            Format format2 = format;
            float f3 = f2;
            int width = getWidth();
            int rows = getRows();
            ByteBuffer buffer = getBuffer();
            int pixelMode = getPixelMode();
            int abs = Math.abs(getPitch());
            if (color == Color.WHITE && pixelMode == FreeType.FT_PIXEL_MODE_GRAY && abs == width && f3 == 1.0f) {
                pixmap = new Pixmap(width, rows, Format.Alpha);
                BufferUtils.copy(buffer, pixmap.getPixels(), pixmap.getPixels().capacity());
            } else {
                Pixmap pixmap2 = new Pixmap(width, rows, Format.RGBA8888);
                int rgba8888 = Color.rgba8888(color);
                byte[] bArr = new byte[abs];
                int[] iArr = new int[width];
                IntBuffer asIntBuffer = pixmap2.getPixels().asIntBuffer();
                if (pixelMode == FreeType.FT_PIXEL_MODE_MONO) {
                    for (int i4 = 0; i4 < rows; i4++) {
                        buffer.get(bArr);
                        int i5 = 0;
                        for (int i6 = 0; i6 < width; i6 += 8) {
                            byte b2 = bArr[i5];
                            int min = Math.min(8, width - i6);
                            for (int i7 = 0; i7 < min; i7++) {
                                if ((b2 & (1 << (7 - i7))) != 0) {
                                    iArr[i6 + i7] = rgba8888;
                                } else {
                                    iArr[i6 + i7] = 0;
                                }
                            }
                            i5++;
                        }
                        asIntBuffer.put(iArr);
                    }
                } else {
                    int i8 = rgba8888 & -256;
                    byte b3 = 255;
                    int i9 = rgba8888 & InvitationReply.EXPIRED;
                    int i10 = 0;
                    while (i10 < rows) {
                        buffer.get(bArr);
                        int i11 = 0;
                        while (i11 < width) {
                            byte b4 = bArr[i11] & b3;
                            if (b4 == 0) {
                                iArr[i11] = i8;
                            } else if (b4 == b3) {
                                iArr[i11] = i8 | i9;
                            } else {
                                i2 = i9;
                                double d2 = (double) (((float) b4) / 255.0f);
                                i3 = width;
                                i = rows;
                                iArr[i11] = ((int) (((float) i9) * ((float) Math.pow(d2, (double) f3)))) | i8;
                                i11++;
                                width = i3;
                                i9 = i2;
                                rows = i;
                                b3 = 255;
                            }
                            i3 = width;
                            i = rows;
                            i2 = i9;
                            i11++;
                            width = i3;
                            i9 = i2;
                            rows = i;
                            b3 = 255;
                        }
                        int i12 = width;
                        int i13 = rows;
                        int i14 = i9;
                        asIntBuffer.put(iArr);
                        i10++;
                        b3 = 255;
                    }
                }
                pixmap = pixmap2;
            }
            if (format2 == pixmap.getFormat()) {
                return pixmap;
            }
            Pixmap pixmap3 = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), format2);
            pixmap3.setBlending(Blending.None);
            pixmap3.drawPixmap(pixmap, 0, 0);
            pixmap3.setBlending(Blending.SourceOver);
            pixmap.dispose();
            return pixmap3;
        }

        public int getRows() {
            return getRows(this.address);
        }

        public int getWidth() {
            return getWidth(this.address);
        }
    }

    public static class Face extends Pointer implements Disposable {
        public Library library;

        public Face(long j, Library library2) {
            super(j);
            this.library = library2;
        }

        public static native void doneFace(long j);

        public static native int getAscender(long j);

        public static native int getCharIndex(long j, int i);

        public static native int getDescender(long j);

        public static native int getFaceFlags(long j);

        public static native long getGlyph(long j);

        public static native int getHeight(long j);

        public static native int getKerning(long j, int i, int i2, int i3);

        public static native int getMaxAdvanceHeight(long j);

        public static native int getMaxAdvanceWidth(long j);

        public static native int getNumGlyphs(long j);

        public static native long getSize(long j);

        public static native int getStyleFlags(long j);

        public static native int getUnderlinePosition(long j);

        public static native int getUnderlineThickness(long j);

        public static native boolean hasKerning(long j);

        public static native boolean loadChar(long j, int i, int i2);

        public static native boolean loadGlyph(long j, int i, int i2);

        public static native boolean selectSize(long j, int i);

        public static native boolean setCharSize(long j, int i, int i2, int i3, int i4);

        public static native boolean setPixelSizes(long j, int i, int i2);

        public void dispose() {
            doneFace(this.address);
            ByteBuffer byteBuffer = (ByteBuffer) this.library.fontData.get(this.address);
            if (byteBuffer != null) {
                LongMap<ByteBuffer> longMap = this.library.fontData;
                long j = this.address;
                if (j != 0) {
                    int locateKey = longMap.locateKey(j);
                    if (locateKey >= 0) {
                        long[] jArr = longMap.keyTable;
                        V[] vArr = longMap.valueTable;
                        V v = vArr[locateKey];
                        int i = longMap.mask;
                        int i2 = locateKey + 1;
                        while (true) {
                            int i3 = i2 & i;
                            long j2 = jArr[i3];
                            if (j2 == 0) {
                                break;
                            }
                            int place = longMap.place(j2);
                            if (((i3 - place) & i) > ((locateKey - place) & i)) {
                                jArr[locateKey] = j2;
                                vArr[locateKey] = vArr[i3];
                                locateKey = i3;
                            }
                            i2 = i3 + 1;
                        }
                        jArr[locateKey] = 0;
                        vArr[locateKey] = null;
                        longMap.size--;
                    }
                } else if (longMap.hasZeroValue) {
                    longMap.hasZeroValue = false;
                    longMap.zeroValue = null;
                    longMap.size--;
                }
                if (BufferUtils.isUnsafeByteBuffer(byteBuffer)) {
                    BufferUtils.disposeUnsafeByteBuffer(byteBuffer);
                }
            }
        }

        public int getAscender() {
            return getAscender(this.address);
        }

        public int getCharIndex(int i) {
            return getCharIndex(this.address, i);
        }

        public int getDescender() {
            return getDescender(this.address);
        }

        public int getFaceFlags() {
            return getFaceFlags(this.address);
        }

        public GlyphSlot getGlyph() {
            return new GlyphSlot(getGlyph(this.address));
        }

        public int getHeight() {
            return getHeight(this.address);
        }

        public int getKerning(int i, int i2, int i3) {
            return getKerning(this.address, i, i2, i3);
        }

        public int getMaxAdvanceHeight() {
            return getMaxAdvanceHeight(this.address);
        }

        public int getMaxAdvanceWidth() {
            return getMaxAdvanceWidth(this.address);
        }

        public int getNumGlyphs() {
            return getNumGlyphs(this.address);
        }

        public Size getSize() {
            return new Size(getSize(this.address));
        }

        public int getStyleFlags() {
            return getStyleFlags(this.address);
        }

        public int getUnderlinePosition() {
            return getUnderlinePosition(this.address);
        }

        public int getUnderlineThickness() {
            return getUnderlineThickness(this.address);
        }

        public boolean hasKerning() {
            return hasKerning(this.address);
        }

        public boolean loadChar(int i, int i2) {
            return loadChar(this.address, i, i2);
        }

        public boolean loadGlyph(int i, int i2) {
            return loadGlyph(this.address, i, i2);
        }

        public boolean selectSize(int i) {
            return selectSize(this.address, i);
        }

        public boolean setCharSize(int i, int i2, int i3, int i4) {
            return setCharSize(this.address, i, i2, i3, i4);
        }

        public boolean setPixelSizes(int i, int i2) {
            return setPixelSizes(this.address, i, i2);
        }
    }

    public static class Glyph extends Pointer implements Disposable {
        public boolean rendered;

        public Glyph(long j) {
            super(j);
        }

        public static native void done(long j);

        public static native long getBitmap(long j);

        public static native int getLeft(long j);

        public static native int getTop(long j);

        public static native long strokeBorder(long j, long j2, boolean z);

        public static native long toBitmap(long j, int i);

        public void dispose() {
            done(this.address);
        }

        public Bitmap getBitmap() {
            if (this.rendered) {
                return new Bitmap(getBitmap(this.address));
            }
            throw new GdxRuntimeException((String) "Glyph is not yet rendered");
        }

        public int getLeft() {
            if (this.rendered) {
                return getLeft(this.address);
            }
            throw new GdxRuntimeException((String) "Glyph is not yet rendered");
        }

        public int getTop() {
            if (this.rendered) {
                return getTop(this.address);
            }
            throw new GdxRuntimeException((String) "Glyph is not yet rendered");
        }

        public void strokeBorder(Stroker stroker, boolean z) {
            this.address = strokeBorder(this.address, stroker.address, z);
        }

        public void toBitmap(int i) {
            long bitmap = toBitmap(this.address, i);
            if (bitmap != 0) {
                this.address = bitmap;
                this.rendered = true;
                return;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Couldn't render glyph, FreeType error code: ");
            outline73.append(FreeType.getLastErrorCode());
            throw new GdxRuntimeException(outline73.toString());
        }
    }

    public static class GlyphMetrics extends Pointer {
        public GlyphMetrics(long j) {
            super(j);
        }

        public static native int getHeight(long j);

        public static native int getHoriAdvance(long j);

        public static native int getHoriBearingX(long j);

        public static native int getHoriBearingY(long j);

        public static native int getVertAdvance(long j);

        public static native int getVertBearingX(long j);

        public static native int getVertBearingY(long j);

        public static native int getWidth(long j);

        public int getHeight() {
            return getHeight(this.address);
        }

        public int getHoriAdvance() {
            return getHoriAdvance(this.address);
        }

        public int getHoriBearingX() {
            return getHoriBearingX(this.address);
        }

        public int getHoriBearingY() {
            return getHoriBearingY(this.address);
        }

        public int getVertAdvance() {
            return getVertAdvance(this.address);
        }

        public int getVertBearingX() {
            return getVertBearingX(this.address);
        }

        public int getVertBearingY() {
            return getVertBearingY(this.address);
        }

        public int getWidth() {
            return getWidth(this.address);
        }
    }

    public static class GlyphSlot extends Pointer {
        public GlyphSlot(long j) {
            super(j);
        }

        public static native int getAdvanceX(long j);

        public static native int getAdvanceY(long j);

        public static native long getBitmap(long j);

        public static native int getBitmapLeft(long j);

        public static native int getBitmapTop(long j);

        public static native int getFormat(long j);

        public static native long getGlyph(long j);

        public static native int getLinearHoriAdvance(long j);

        public static native int getLinearVertAdvance(long j);

        public static native long getMetrics(long j);

        public static native boolean renderGlyph(long j, int i);

        public int getAdvanceX() {
            return getAdvanceX(this.address);
        }

        public int getAdvanceY() {
            return getAdvanceY(this.address);
        }

        public Bitmap getBitmap() {
            return new Bitmap(getBitmap(this.address));
        }

        public int getBitmapLeft() {
            return getBitmapLeft(this.address);
        }

        public int getBitmapTop() {
            return getBitmapTop(this.address);
        }

        public int getFormat() {
            return getFormat(this.address);
        }

        public Glyph getGlyph() {
            long glyph = getGlyph(this.address);
            if (glyph != 0) {
                return new Glyph(glyph);
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Couldn't get glyph, FreeType error code: ");
            outline73.append(FreeType.getLastErrorCode());
            throw new GdxRuntimeException(outline73.toString());
        }

        public int getLinearHoriAdvance() {
            return getLinearHoriAdvance(this.address);
        }

        public int getLinearVertAdvance() {
            return getLinearVertAdvance(this.address);
        }

        public GlyphMetrics getMetrics() {
            return new GlyphMetrics(getMetrics(this.address));
        }

        public boolean renderGlyph(int i) {
            return renderGlyph(this.address, i);
        }
    }

    public static class Library extends Pointer implements Disposable {
        public LongMap<ByteBuffer> fontData = new LongMap<>();

        public Library(long j) {
            super(j);
        }

        public static native void doneFreeType(long j);

        public static native long newMemoryFace(long j, ByteBuffer byteBuffer, int i, int i2);

        public static native long strokerNew(long j);

        public Stroker createStroker() {
            long strokerNew = strokerNew(this.address);
            if (strokerNew != 0) {
                return new Stroker(strokerNew);
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Couldn't create FreeType stroker, FreeType error code: ");
            outline73.append(FreeType.getLastErrorCode());
            throw new GdxRuntimeException(outline73.toString());
        }

        public void dispose() {
            Values values;
            doneFreeType(this.address);
            LongMap<ByteBuffer> longMap = this.fontData;
            if (longMap.values1 == null) {
                longMap.values1 = new Values(longMap);
                longMap.values2 = new Values(longMap);
            }
            Values values2 = longMap.values1;
            if (!values2.valid) {
                values2.reset();
                values = longMap.values1;
                values.valid = true;
                longMap.values2.valid = false;
            } else {
                longMap.values2.reset();
                values = longMap.values2;
                values.valid = true;
                longMap.values1.valid = false;
            }
            while (values.hasNext()) {
                ByteBuffer byteBuffer = (ByteBuffer) values.next();
                if (BufferUtils.isUnsafeByteBuffer(byteBuffer)) {
                    BufferUtils.disposeUnsafeByteBuffer(byteBuffer);
                }
            }
        }

        public Face newFace(FileHandle fileHandle, int i) {
            ByteBuffer byteBuffer;
            ByteBuffer byteBuffer2 = null;
            if (fileHandle != null) {
                try {
                    byteBuffer2 = fileHandle.map(MapMode.READ_ONLY);
                } catch (GdxRuntimeException unused) {
                }
                if (byteBuffer2 == null) {
                    InputStream read = fileHandle.read();
                    try {
                        int length = (int) fileHandle.length();
                        if (length == 0) {
                            byte[] copyStreamToByteArray = StreamUtils.copyStreamToByteArray(read, 16384);
                            ByteBuffer newUnsafeByteBuffer = BufferUtils.newUnsafeByteBuffer(copyStreamToByteArray.length);
                            BufferUtils.copy(copyStreamToByteArray, 0, (Buffer) newUnsafeByteBuffer, copyStreamToByteArray.length);
                            byteBuffer = newUnsafeByteBuffer;
                        } else {
                            byteBuffer = BufferUtils.newUnsafeByteBuffer(length);
                            byte[] bArr = new byte[4096];
                            int position = byteBuffer.position();
                            int i2 = 0;
                            while (true) {
                                int read2 = read.read(bArr);
                                if (read2 == -1) {
                                    break;
                                }
                                BufferUtils.copy(bArr, 0, (Buffer) byteBuffer, read2);
                                i2 += read2;
                                byteBuffer.position(position + i2);
                            }
                            byteBuffer.position(position);
                        }
                        if (read != null) {
                            try {
                                read.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        byteBuffer2 = byteBuffer;
                    } catch (IOException e2) {
                        throw new GdxRuntimeException((Throwable) e2);
                    } catch (Throwable unused3) {
                    }
                }
                return newMemoryFace(byteBuffer2, i);
            }
            throw null;
            throw th;
        }

        public Face newMemoryFace(byte[] bArr, int i, int i2) {
            ByteBuffer newUnsafeByteBuffer = BufferUtils.newUnsafeByteBuffer(bArr.length);
            BufferUtils.copy(bArr, 0, (Buffer) newUnsafeByteBuffer, bArr.length);
            return newMemoryFace(newUnsafeByteBuffer, i2);
        }

        public Face newMemoryFace(ByteBuffer byteBuffer, int i) {
            long newMemoryFace = newMemoryFace(this.address, byteBuffer, byteBuffer.remaining(), i);
            if (newMemoryFace == 0) {
                if (BufferUtils.isUnsafeByteBuffer(byteBuffer)) {
                    BufferUtils.disposeUnsafeByteBuffer(byteBuffer);
                }
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Couldn't load font, FreeType error code: ");
                outline73.append(FreeType.getLastErrorCode());
                throw new GdxRuntimeException(outline73.toString());
            }
            this.fontData.put(newMemoryFace, byteBuffer);
            return new Face(newMemoryFace, this);
        }
    }

    public static class Pointer {
        public long address;

        public Pointer(long j) {
            this.address = j;
        }
    }

    public static class Size extends Pointer {
        public Size(long j) {
            super(j);
        }

        public static native long getMetrics(long j);

        public SizeMetrics getMetrics() {
            return new SizeMetrics(getMetrics(this.address));
        }
    }

    public static class SizeMetrics extends Pointer {
        public SizeMetrics(long j) {
            super(j);
        }

        public static native int getAscender(long j);

        public static native int getDescender(long j);

        public static native int getHeight(long j);

        public static native int getMaxAdvance(long j);

        public static native int getXppem(long j);

        public static native int getXscale(long j);

        public static native int getYppem(long j);

        public static native int getYscale(long j);

        public int getAscender() {
            return getAscender(this.address);
        }

        public int getDescender() {
            return getDescender(this.address);
        }

        public int getHeight() {
            return getHeight(this.address);
        }

        public int getMaxAdvance() {
            return getMaxAdvance(this.address);
        }

        public int getXScale() {
            return getXscale(this.address);
        }

        public int getXppem() {
            return getXppem(this.address);
        }

        public int getYppem() {
            return getYppem(this.address);
        }

        public int getYscale() {
            return getYscale(this.address);
        }
    }

    public static class Stroker extends Pointer implements Disposable {
        public Stroker(long j) {
            super(j);
        }

        public static native void done(long j);

        public static native void set(long j, int i, int i2, int i3, int i4);

        public void dispose() {
            done(this.address);
        }

        public void set(int i, int i2, int i3, int i4) {
            set(this.address, i, i2, i3, i4);
        }
    }

    public static int encode(char c2, char c3, char c4, char c5) {
        return (c2 << 24) | (c3 << 16) | (c4 << 8) | c5;
    }

    public static native int getLastErrorCode();

    public static Library initFreeType() {
        new SharedLibraryLoader().load("gdx-freetype");
        long initFreeTypeJni = initFreeTypeJni();
        if (initFreeTypeJni != 0) {
            return new Library(initFreeTypeJni);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Couldn't initialize FreeType library, FreeType error code: ");
        outline73.append(getLastErrorCode());
        throw new GdxRuntimeException(outline73.toString());
    }

    public static native long initFreeTypeJni();

    public static int toInt(int i) {
        return ((i + 63) & -64) >> 6;
    }
}
