package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.CubemapData;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.graphics.glutils.ETC1.ETC1Data;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class KTXTextureData implements TextureData, CubemapData {
    public static final int GL_TEXTURE_1D = 4660;
    public static final int GL_TEXTURE_1D_ARRAY_EXT = 4660;
    public static final int GL_TEXTURE_2D_ARRAY_EXT = 4660;
    public static final int GL_TEXTURE_3D = 4660;
    public ByteBuffer compressedData;
    public FileHandle file;
    public int glBaseInternalFormat;
    public int glFormat;
    public int glInternalFormat;
    public int glType;
    public int glTypeSize;
    public int imagePos;
    public int numberOfArrayElements;
    public int numberOfFaces;
    public int numberOfMipmapLevels;
    public int pixelDepth = -1;
    public int pixelHeight = -1;
    public int pixelWidth = -1;
    public boolean useMipMaps;

    public KTXTextureData(FileHandle fileHandle, boolean z) {
        this.file = fileHandle;
        this.useMipMaps = z;
    }

    public void consumeCubemapData() {
        consumeCustomData(GL20.GL_TEXTURE_CUBE_MAP);
    }

    public void consumeCustomData(int i) {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z2;
        int i8 = i;
        if (this.compressedData != null) {
            IntBuffer newIntBuffer = BufferUtils.newIntBuffer(16);
            int i9 = 1;
            if (this.glType != 0 && this.glFormat != 0) {
                z = false;
            } else if (this.glType + this.glFormat == 0) {
                z = true;
            } else {
                throw new GdxRuntimeException((String) "either both or none of glType, glFormat must be zero");
            }
            if (this.pixelHeight > 0) {
                i3 = 2;
                i2 = GL20.GL_TEXTURE_2D;
            } else {
                i3 = 1;
                i2 = 4660;
            }
            if (this.pixelDepth > 0) {
                i3 = 3;
                i2 = 4660;
            }
            int i10 = this.numberOfFaces;
            if (i10 == 6) {
                if (i3 == 2) {
                    i2 = GL20.GL_TEXTURE_CUBE_MAP;
                } else {
                    throw new GdxRuntimeException((String) "cube map needs 2D faces");
                }
            } else if (i10 != 1) {
                throw new GdxRuntimeException((String) "numberOfFaces must be either 1 or 6");
            }
            if (this.numberOfArrayElements > 0) {
                if (i2 == 4660 || i2 == 3553) {
                    i3++;
                    i2 = 4660;
                } else {
                    throw new GdxRuntimeException((String) "No API for 3D and cube arrays yet");
                }
            }
            if (i2 != 4660) {
                int i11 = this.numberOfFaces;
                int i12 = GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_X;
                if (i11 != 6 || i8 == 34067) {
                    if (this.numberOfFaces == 6 && i8 == 34067) {
                        i8 = GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_X;
                    } else if (i8 != i2 && (34069 > i8 || i8 > 34074 || i8 != 3553)) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Invalid target requested : 0x");
                        outline73.append(Integer.toHexString(i));
                        outline73.append(", expecting : 0x");
                        outline73.append(Integer.toHexString(i2));
                        throw new GdxRuntimeException(outline73.toString());
                    }
                    i12 = i8;
                    i4 = -1;
                } else if (34069 > i8 || i8 > 34074) {
                    throw new GdxRuntimeException((String) "You must specify either GL_TEXTURE_CUBE_MAP to bind all 6 faces of the cube or the requested face GL_TEXTURE_CUBE_MAP_POSITIVE_X and followings.");
                } else {
                    i4 = i8 - GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_X;
                }
                k.gl.glGetIntegerv(GL20.GL_UNPACK_ALIGNMENT, newIntBuffer);
                int i13 = newIntBuffer.get(0);
                int i14 = 4;
                if (i13 != 4) {
                    k.gl.glPixelStorei(GL20.GL_UNPACK_ALIGNMENT, 4);
                }
                int i15 = this.glInternalFormat;
                int i16 = this.glFormat;
                int i17 = this.imagePos;
                int i18 = 0;
                while (i18 < this.numberOfMipmapLevels) {
                    int max = Math.max(i9, this.pixelWidth >> i18);
                    int max2 = Math.max(i9, this.pixelHeight >> i18);
                    Math.max(i9, this.pixelDepth >> i18);
                    this.compressedData.position(i17);
                    int i19 = this.compressedData.getInt();
                    int i20 = (i19 + 3) & -4;
                    i17 += i14;
                    int i21 = 0;
                    while (i21 < this.numberOfFaces) {
                        this.compressedData.position(i17);
                        i17 += i20;
                        if (i4 == -1 || i4 == i21) {
                            ByteBuffer slice = this.compressedData.slice();
                            slice.limit(i20);
                            i5 = i4;
                            if (i3 != 1) {
                                if (i3 == 2) {
                                    int i22 = this.numberOfArrayElements;
                                    if (i22 <= 0) {
                                        i22 = max2;
                                    }
                                    if (!z) {
                                        z2 = z;
                                        i7 = i20;
                                        i6 = max;
                                        k.gl.glTexImage2D(i12 + i21, i18, i15, i6, i22, 0, i16, this.glType, slice);
                                    } else if (i15 == ETC1.ETC1_RGB8_OES) {
                                        z2 = z;
                                        if (!((AndroidGraphics) k.graphics).supportsExtension("GL_OES_compressed_ETC1_RGB8_texture")) {
                                            Pixmap decodeImage = ETC1.decodeImage(new ETC1Data(max, i22, slice, 0), Format.RGB888);
                                            i7 = i20;
                                            i6 = max;
                                            k.gl.glTexImage2D(i12 + i21, i18, decodeImage.getGLInternalFormat(), decodeImage.getWidth(), decodeImage.getHeight(), 0, decodeImage.getGLFormat(), decodeImage.getGLType(), decodeImage.getPixels());
                                            decodeImage.dispose();
                                        } else {
                                            i7 = i20;
                                            i6 = max;
                                            k.gl.glCompressedTexImage2D(i12 + i21, i18, i15, i6, i22, 0, i19, slice);
                                        }
                                    } else {
                                        z2 = z;
                                        i7 = i20;
                                        i6 = max;
                                        k.gl.glCompressedTexImage2D(i12 + i21, i18, i15, i6, i22, 0, i19, slice);
                                    }
                                    max2 = i22;
                                } else {
                                    z2 = z;
                                    i7 = i20;
                                    i6 = max;
                                }
                                i21++;
                                i4 = i5;
                                z = z2;
                                i20 = i7;
                                max = i6;
                            }
                        } else {
                            i5 = i4;
                        }
                        z2 = z;
                        i7 = i20;
                        i6 = max;
                        i21++;
                        i4 = i5;
                        z = z2;
                        i20 = i7;
                        max = i6;
                    }
                    int i23 = i4;
                    boolean z3 = z;
                    i18++;
                    i9 = 1;
                    i14 = 4;
                }
                if (i13 != 4) {
                    k.gl.glPixelStorei(GL20.GL_UNPACK_ALIGNMENT, i13);
                }
                if (useMipMaps()) {
                    k.gl.glGenerateMipmap(i12);
                }
                disposePreparedData();
                return;
            }
            throw new GdxRuntimeException((String) "Unsupported texture format (only 2D texture are supported in LibGdx for the time being)");
        }
        throw new GdxRuntimeException((String) "Call prepare() before calling consumeCompressedData()");
    }

    public Pixmap consumePixmap() {
        throw new GdxRuntimeException((String) "This TextureData implementation does not return a Pixmap");
    }

    public boolean disposePixmap() {
        throw new GdxRuntimeException((String) "This TextureData implementation does not return a Pixmap");
    }

    public void disposePreparedData() {
        ByteBuffer byteBuffer = this.compressedData;
        if (byteBuffer != null) {
            BufferUtils.disposeUnsafeByteBuffer(byteBuffer);
        }
        this.compressedData = null;
    }

    public ByteBuffer getData(int i, int i2) {
        int i3 = this.imagePos;
        for (int i4 = 0; i4 < this.numberOfMipmapLevels; i4++) {
            int i5 = (this.compressedData.getInt(i3) + 3) & -4;
            i3 += 4;
            if (i4 == i) {
                for (int i6 = 0; i6 < this.numberOfFaces; i6++) {
                    if (i6 == i2) {
                        this.compressedData.position(i3);
                        ByteBuffer slice = this.compressedData.slice();
                        slice.limit(i5);
                        return slice;
                    }
                    i3 += i5;
                }
                continue;
            } else {
                i3 = (i5 * this.numberOfFaces) + i3;
            }
        }
        return null;
    }

    public Format getFormat() {
        throw new GdxRuntimeException((String) "This TextureData implementation directly handles texture formats.");
    }

    public int getGlInternalFormat() {
        return this.glInternalFormat;
    }

    public int getHeight() {
        return this.pixelHeight;
    }

    public int getNumberOfFaces() {
        return this.numberOfFaces;
    }

    public int getNumberOfMipMapLevels() {
        return this.numberOfMipmapLevels;
    }

    public TextureDataType getType() {
        return TextureDataType.Custom;
    }

    public int getWidth() {
        return this.pixelWidth;
    }

    public boolean isManaged() {
        return true;
    }

    public boolean isPrepared() {
        return this.compressedData != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085 A[SYNTHETIC, Splitter:B:28:0x0085] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void prepare() {
        /*
            r7 = this;
            java.nio.ByteBuffer r0 = r7.compressedData
            if (r0 != 0) goto L_0x0233
            com.badlogic.gdx.files.FileHandle r0 = r7.file
            if (r0 == 0) goto L_0x022b
            java.lang.String r0 = r0.name()
            java.lang.String r1 = ".zktx"
            boolean r0 = r0.endsWith(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0089
            r0 = 10240(0x2800, float:1.4349E-41)
            byte[] r0 = new byte[r0]
            r2 = 0
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0063 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0063 }
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x0063 }
            com.badlogic.gdx.files.FileHandle r6 = r7.file     // Catch:{ Exception -> 0x0063 }
            java.io.InputStream r6 = r6.read()     // Catch:{ Exception -> 0x0063 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0063 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0063 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0063 }
            int r2 = r3.readInt()     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            java.nio.ByteBuffer r2 = com.badlogic.gdx.utils.BufferUtils.newUnsafeByteBuffer(r2)     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            r7.compressedData = r2     // Catch:{ Exception -> 0x005e, all -> 0x005c }
        L_0x0039:
            int r2 = r3.read(r0)     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            r4 = -1
            if (r2 == r4) goto L_0x0046
            java.nio.ByteBuffer r4 = r7.compressedData     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            r4.put(r0, r1, r2)     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            goto L_0x0039
        L_0x0046:
            java.nio.ByteBuffer r0 = r7.compressedData     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            r0.position(r1)     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            java.nio.ByteBuffer r0 = r7.compressedData     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            java.nio.ByteBuffer r2 = r7.compressedData     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            int r2 = r2.capacity()     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            r0.limit(r2)     // Catch:{ Exception -> 0x005e, all -> 0x005c }
            r3.close()     // Catch:{ all -> 0x005a }
            goto L_0x0095
        L_0x005a:
            goto L_0x0095
        L_0x005c:
            r0 = move-exception
            goto L_0x0083
        L_0x005e:
            r0 = move-exception
            r2 = r3
            goto L_0x0064
        L_0x0061:
            r0 = move-exception
            goto L_0x0082
        L_0x0063:
            r0 = move-exception
        L_0x0064:
            com.badlogic.gdx.utils.GdxRuntimeException r1 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r3.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = "Couldn't load zktx file '"
            r3.append(r4)     // Catch:{ all -> 0x0061 }
            com.badlogic.gdx.files.FileHandle r4 = r7.file     // Catch:{ all -> 0x0061 }
            r3.append(r4)     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = "'"
            r3.append(r4)     // Catch:{ all -> 0x0061 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0061 }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x0061 }
            throw r1     // Catch:{ all -> 0x0061 }
        L_0x0082:
            r3 = r2
        L_0x0083:
            if (r3 == 0) goto L_0x0088
            r3.close()     // Catch:{ all -> 0x0088 }
        L_0x0088:
            throw r0
        L_0x0089:
            com.badlogic.gdx.files.FileHandle r0 = r7.file
            byte[] r0 = r0.readBytes()
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0)
            r7.compressedData = r0
        L_0x0095:
            java.nio.ByteBuffer r0 = r7.compressedData
            byte r0 = r0.get()
            r2 = -85
            java.lang.String r3 = "Invalid KTX Header"
            if (r0 != r2) goto L_0x0225
            java.nio.ByteBuffer r0 = r7.compressedData
            byte r0 = r0.get()
            r2 = 75
            if (r0 != r2) goto L_0x021f
            java.nio.ByteBuffer r0 = r7.compressedData
            byte r0 = r0.get()
            r2 = 84
            if (r0 != r2) goto L_0x0219
            java.nio.ByteBuffer r0 = r7.compressedData
            byte r0 = r0.get()
            r2 = 88
            if (r0 != r2) goto L_0x0213
            java.nio.ByteBuffer r0 = r7.compressedData
            byte r0 = r0.get()
            r2 = 32
            if (r0 != r2) goto L_0x020d
            java.nio.ByteBuffer r0 = r7.compressedData
            byte r0 = r0.get()
            r2 = 49
            if (r0 != r2) goto L_0x0207
            java.nio.ByteBuffer r0 = r7.compressedData
            byte r0 = r0.get()
            if (r0 != r2) goto L_0x0201
            java.nio.ByteBuffer r0 = r7.compressedData
            byte r0 = r0.get()
            r2 = -69
            if (r0 != r2) goto L_0x01fb
            java.nio.ByteBuffer r0 = r7.compressedData
            byte r0 = r0.get()
            r2 = 13
            if (r0 != r2) goto L_0x01f5
            java.nio.ByteBuffer r0 = r7.compressedData
            byte r0 = r0.get()
            r2 = 10
            if (r0 != r2) goto L_0x01ef
            java.nio.ByteBuffer r0 = r7.compressedData
            byte r0 = r0.get()
            r4 = 26
            if (r0 != r4) goto L_0x01e9
            java.nio.ByteBuffer r0 = r7.compressedData
            byte r0 = r0.get()
            if (r0 != r2) goto L_0x01e3
            java.nio.ByteBuffer r0 = r7.compressedData
            int r0 = r0.getInt()
            r2 = 67305985(0x4030201, float:1.5399896E-36)
            if (r0 == r2) goto L_0x0122
            r4 = 16909060(0x1020304, float:2.3879393E-38)
            if (r0 != r4) goto L_0x011c
            goto L_0x0122
        L_0x011c:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            r0.<init>(r3)
            throw r0
        L_0x0122:
            if (r0 == r2) goto L_0x0133
            java.nio.ByteBuffer r0 = r7.compressedData
            java.nio.ByteOrder r2 = r0.order()
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN
            if (r2 != r3) goto L_0x0130
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
        L_0x0130:
            r0.order(r3)
        L_0x0133:
            java.nio.ByteBuffer r0 = r7.compressedData
            int r0 = r0.getInt()
            r7.glType = r0
            java.nio.ByteBuffer r0 = r7.compressedData
            int r0 = r0.getInt()
            r7.glTypeSize = r0
            java.nio.ByteBuffer r0 = r7.compressedData
            int r0 = r0.getInt()
            r7.glFormat = r0
            java.nio.ByteBuffer r0 = r7.compressedData
            int r0 = r0.getInt()
            r7.glInternalFormat = r0
            java.nio.ByteBuffer r0 = r7.compressedData
            int r0 = r0.getInt()
            r7.glBaseInternalFormat = r0
            java.nio.ByteBuffer r0 = r7.compressedData
            int r0 = r0.getInt()
            r7.pixelWidth = r0
            java.nio.ByteBuffer r0 = r7.compressedData
            int r0 = r0.getInt()
            r7.pixelHeight = r0
            java.nio.ByteBuffer r0 = r7.compressedData
            int r0 = r0.getInt()
            r7.pixelDepth = r0
            java.nio.ByteBuffer r0 = r7.compressedData
            int r0 = r0.getInt()
            r7.numberOfArrayElements = r0
            java.nio.ByteBuffer r0 = r7.compressedData
            int r0 = r0.getInt()
            r7.numberOfFaces = r0
            java.nio.ByteBuffer r0 = r7.compressedData
            int r0 = r0.getInt()
            r7.numberOfMipmapLevels = r0
            if (r0 != 0) goto L_0x0192
            r0 = 1
            r7.numberOfMipmapLevels = r0
            r7.useMipMaps = r0
        L_0x0192:
            java.nio.ByteBuffer r0 = r7.compressedData
            int r0 = r0.getInt()
            java.nio.ByteBuffer r2 = r7.compressedData
            int r2 = r2.position()
            int r2 = r2 + r0
            r7.imagePos = r2
            java.nio.ByteBuffer r0 = r7.compressedData
            boolean r0 = r0.isDirect()
            if (r0 != 0) goto L_0x01e2
            int r0 = r7.imagePos
            r2 = 0
        L_0x01ac:
            int r3 = r7.numberOfMipmapLevels
            if (r2 >= r3) goto L_0x01c4
            java.nio.ByteBuffer r3 = r7.compressedData
            int r3 = r3.getInt(r0)
            int r3 = r3 + 3
            r3 = r3 & -4
            int r4 = r7.numberOfFaces
            r5 = 4
            int r0 = com.android.tools.r8.GeneratedOutlineSupport.outline7(r3, r4, r5, r0)
            int r2 = r2 + 1
            goto L_0x01ac
        L_0x01c4:
            java.nio.ByteBuffer r2 = r7.compressedData
            r2.limit(r0)
            java.nio.ByteBuffer r2 = r7.compressedData
            r2.position(r1)
            java.nio.ByteBuffer r0 = com.badlogic.gdx.utils.BufferUtils.newUnsafeByteBuffer(r0)
            java.nio.ByteBuffer r1 = r7.compressedData
            java.nio.ByteOrder r1 = r1.order()
            r0.order(r1)
            java.nio.ByteBuffer r1 = r7.compressedData
            r0.put(r1)
            r7.compressedData = r0
        L_0x01e2:
            return
        L_0x01e3:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            r0.<init>(r3)
            throw r0
        L_0x01e9:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            r0.<init>(r3)
            throw r0
        L_0x01ef:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            r0.<init>(r3)
            throw r0
        L_0x01f5:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            r0.<init>(r3)
            throw r0
        L_0x01fb:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            r0.<init>(r3)
            throw r0
        L_0x0201:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            r0.<init>(r3)
            throw r0
        L_0x0207:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            r0.<init>(r3)
            throw r0
        L_0x020d:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            r0.<init>(r3)
            throw r0
        L_0x0213:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            r0.<init>(r3)
            throw r0
        L_0x0219:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            r0.<init>(r3)
            throw r0
        L_0x021f:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            r0.<init>(r3)
            throw r0
        L_0x0225:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            r0.<init>(r3)
            throw r0
        L_0x022b:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            java.lang.String r1 = "Need a file to load from"
            r0.<init>(r1)
            throw r0
        L_0x0233:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException
            java.lang.String r1 = "Already prepared"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.glutils.KTXTextureData.prepare():void");
    }

    public boolean useMipMaps() {
        return this.useMipMaps;
    }
}
