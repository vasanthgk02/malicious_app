package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Cubemap.CubemapSide;
import com.badlogic.gdx.graphics.CubemapData;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.Factory;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class FacedCubemapData implements CubemapData {
    public final TextureData[] data;

    public FacedCubemapData() {
        this((TextureData) null, (TextureData) null, (TextureData) null, (TextureData) null, (TextureData) null, (TextureData) null);
    }

    public void consumeCubemapData() {
        int i = 0;
        while (true) {
            TextureData[] textureDataArr = this.data;
            if (i < textureDataArr.length) {
                if (textureDataArr[i].getType() == TextureDataType.Custom) {
                    this.data[i].consumeCustomData(GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_X + i);
                } else {
                    Pixmap consumePixmap = this.data[i].consumePixmap();
                    boolean disposePixmap = this.data[i].disposePixmap();
                    if (this.data[i].getFormat() != consumePixmap.getFormat()) {
                        Pixmap pixmap = new Pixmap(consumePixmap.getWidth(), consumePixmap.getHeight(), this.data[i].getFormat());
                        pixmap.setBlending(Blending.None);
                        pixmap.drawPixmap(consumePixmap, 0, 0, 0, 0, consumePixmap.getWidth(), consumePixmap.getHeight());
                        if (this.data[i].disposePixmap()) {
                            consumePixmap.dispose();
                        }
                        consumePixmap = pixmap;
                        disposePixmap = true;
                    }
                    k.gl.glPixelStorei(GL20.GL_UNPACK_ALIGNMENT, 1);
                    k.gl.glTexImage2D(i + GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_X, 0, consumePixmap.getGLInternalFormat(), consumePixmap.getWidth(), consumePixmap.getHeight(), 0, consumePixmap.getGLFormat(), consumePixmap.getGLType(), consumePixmap.getPixels());
                    if (disposePixmap) {
                        consumePixmap.dispose();
                    }
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r0 > 0) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getHeight() {
        /*
            r4 = this;
            com.badlogic.gdx.graphics.TextureData[] r0 = r4.data
            com.badlogic.gdx.graphics.Cubemap$CubemapSide r1 = com.badlogic.gdx.graphics.Cubemap.CubemapSide.PositiveZ
            int r1 = r1.index
            r2 = r0[r1]
            if (r2 == 0) goto L_0x0013
            r0 = r0[r1]
            int r0 = r0.getHeight()
            if (r0 <= 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            com.badlogic.gdx.graphics.TextureData[] r1 = r4.data
            com.badlogic.gdx.graphics.Cubemap$CubemapSide r2 = com.badlogic.gdx.graphics.Cubemap.CubemapSide.NegativeZ
            int r2 = r2.index
            r3 = r1[r2]
            if (r3 == 0) goto L_0x0027
            r1 = r1[r2]
            int r1 = r1.getHeight()
            if (r1 <= r0) goto L_0x0027
            r0 = r1
        L_0x0027:
            com.badlogic.gdx.graphics.TextureData[] r1 = r4.data
            com.badlogic.gdx.graphics.Cubemap$CubemapSide r2 = com.badlogic.gdx.graphics.Cubemap.CubemapSide.PositiveX
            int r2 = r2.index
            r3 = r1[r2]
            if (r3 == 0) goto L_0x003a
            r1 = r1[r2]
            int r1 = r1.getHeight()
            if (r1 <= r0) goto L_0x003a
            r0 = r1
        L_0x003a:
            com.badlogic.gdx.graphics.TextureData[] r1 = r4.data
            com.badlogic.gdx.graphics.Cubemap$CubemapSide r2 = com.badlogic.gdx.graphics.Cubemap.CubemapSide.NegativeX
            int r2 = r2.index
            r3 = r1[r2]
            if (r3 == 0) goto L_0x004d
            r1 = r1[r2]
            int r1 = r1.getHeight()
            if (r1 <= r0) goto L_0x004d
            r0 = r1
        L_0x004d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.glutils.FacedCubemapData.getHeight():int");
    }

    public TextureData getTextureData(CubemapSide cubemapSide) {
        return this.data[cubemapSide.index];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r0 > 0) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getWidth() {
        /*
            r4 = this;
            com.badlogic.gdx.graphics.TextureData[] r0 = r4.data
            com.badlogic.gdx.graphics.Cubemap$CubemapSide r1 = com.badlogic.gdx.graphics.Cubemap.CubemapSide.PositiveZ
            int r1 = r1.index
            r2 = r0[r1]
            if (r2 == 0) goto L_0x0013
            r0 = r0[r1]
            int r0 = r0.getWidth()
            if (r0 <= 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            com.badlogic.gdx.graphics.TextureData[] r1 = r4.data
            com.badlogic.gdx.graphics.Cubemap$CubemapSide r2 = com.badlogic.gdx.graphics.Cubemap.CubemapSide.NegativeZ
            int r2 = r2.index
            r3 = r1[r2]
            if (r3 == 0) goto L_0x0027
            r1 = r1[r2]
            int r1 = r1.getWidth()
            if (r1 <= r0) goto L_0x0027
            r0 = r1
        L_0x0027:
            com.badlogic.gdx.graphics.TextureData[] r1 = r4.data
            com.badlogic.gdx.graphics.Cubemap$CubemapSide r2 = com.badlogic.gdx.graphics.Cubemap.CubemapSide.PositiveY
            int r2 = r2.index
            r3 = r1[r2]
            if (r3 == 0) goto L_0x003a
            r1 = r1[r2]
            int r1 = r1.getWidth()
            if (r1 <= r0) goto L_0x003a
            r0 = r1
        L_0x003a:
            com.badlogic.gdx.graphics.TextureData[] r1 = r4.data
            com.badlogic.gdx.graphics.Cubemap$CubemapSide r2 = com.badlogic.gdx.graphics.Cubemap.CubemapSide.NegativeY
            int r2 = r2.index
            r3 = r1[r2]
            if (r3 == 0) goto L_0x004d
            r1 = r1[r2]
            int r1 = r1.getWidth()
            if (r1 <= r0) goto L_0x004d
            r0 = r1
        L_0x004d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.glutils.FacedCubemapData.getWidth():int");
    }

    public boolean isComplete() {
        int i = 0;
        while (true) {
            TextureData[] textureDataArr = this.data;
            if (i >= textureDataArr.length) {
                return true;
            }
            if (textureDataArr[i] == null) {
                return false;
            }
            i++;
        }
    }

    public boolean isManaged() {
        for (TextureData isManaged : this.data) {
            if (!isManaged.isManaged()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrepared() {
        return false;
    }

    public void load(CubemapSide cubemapSide, FileHandle fileHandle) {
        this.data[cubemapSide.index] = Factory.loadFromFile(fileHandle, false);
    }

    public void prepare() {
        if (isComplete()) {
            int i = 0;
            while (true) {
                TextureData[] textureDataArr = this.data;
                if (i < textureDataArr.length) {
                    if (!textureDataArr[i].isPrepared()) {
                        this.data[i].prepare();
                    }
                    i++;
                } else {
                    return;
                }
            }
        } else {
            throw new GdxRuntimeException((String) "You need to complete your cubemap data before using it");
        }
    }

    public FacedCubemapData(FileHandle fileHandle, FileHandle fileHandle2, FileHandle fileHandle3, FileHandle fileHandle4, FileHandle fileHandle5, FileHandle fileHandle6) {
        this(Factory.loadFromFile(fileHandle, false), Factory.loadFromFile(fileHandle2, false), Factory.loadFromFile(fileHandle3, false), Factory.loadFromFile(fileHandle4, false), Factory.loadFromFile(fileHandle5, false), Factory.loadFromFile(fileHandle6, false));
    }

    public void load(CubemapSide cubemapSide, Pixmap pixmap) {
        TextureData[] textureDataArr = this.data;
        int i = cubemapSide.index;
        TextureData textureData = null;
        if (pixmap != null) {
            textureData = new PixmapTextureData(pixmap, null, false, false);
        }
        textureDataArr[i] = textureData;
    }

    public FacedCubemapData(FileHandle fileHandle, FileHandle fileHandle2, FileHandle fileHandle3, FileHandle fileHandle4, FileHandle fileHandle5, FileHandle fileHandle6, boolean z) {
        this(Factory.loadFromFile(fileHandle, z), Factory.loadFromFile(fileHandle2, z), Factory.loadFromFile(fileHandle3, z), Factory.loadFromFile(fileHandle4, z), Factory.loadFromFile(fileHandle5, z), Factory.loadFromFile(fileHandle6, z));
    }

    public FacedCubemapData(Pixmap pixmap, Pixmap pixmap2, Pixmap pixmap3, Pixmap pixmap4, Pixmap pixmap5, Pixmap pixmap6) {
        this(pixmap, pixmap2, pixmap3, pixmap4, pixmap5, pixmap6, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FacedCubemapData(com.badlogic.gdx.graphics.Pixmap r8, com.badlogic.gdx.graphics.Pixmap r9, com.badlogic.gdx.graphics.Pixmap r10, com.badlogic.gdx.graphics.Pixmap r11, com.badlogic.gdx.graphics.Pixmap r12, com.badlogic.gdx.graphics.Pixmap r13, boolean r14) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            if (r8 != 0) goto L_0x0006
            r2 = r1
            goto L_0x000b
        L_0x0006:
            com.badlogic.gdx.graphics.glutils.PixmapTextureData r2 = new com.badlogic.gdx.graphics.glutils.PixmapTextureData
            r2.<init>(r8, r1, r14, r0)
        L_0x000b:
            if (r9 != 0) goto L_0x000f
            r3 = r1
            goto L_0x0015
        L_0x000f:
            com.badlogic.gdx.graphics.glutils.PixmapTextureData r8 = new com.badlogic.gdx.graphics.glutils.PixmapTextureData
            r8.<init>(r9, r1, r14, r0)
            r3 = r8
        L_0x0015:
            if (r10 != 0) goto L_0x0019
            r4 = r1
            goto L_0x001f
        L_0x0019:
            com.badlogic.gdx.graphics.glutils.PixmapTextureData r8 = new com.badlogic.gdx.graphics.glutils.PixmapTextureData
            r8.<init>(r10, r1, r14, r0)
            r4 = r8
        L_0x001f:
            if (r11 != 0) goto L_0x0023
            r5 = r1
            goto L_0x0029
        L_0x0023:
            com.badlogic.gdx.graphics.glutils.PixmapTextureData r8 = new com.badlogic.gdx.graphics.glutils.PixmapTextureData
            r8.<init>(r11, r1, r14, r0)
            r5 = r8
        L_0x0029:
            if (r12 != 0) goto L_0x002d
            r6 = r1
            goto L_0x0033
        L_0x002d:
            com.badlogic.gdx.graphics.glutils.PixmapTextureData r8 = new com.badlogic.gdx.graphics.glutils.PixmapTextureData
            r8.<init>(r12, r1, r14, r0)
            r6 = r8
        L_0x0033:
            if (r13 != 0) goto L_0x0037
            r14 = r1
            goto L_0x003d
        L_0x0037:
            com.badlogic.gdx.graphics.glutils.PixmapTextureData r8 = new com.badlogic.gdx.graphics.glutils.PixmapTextureData
            r8.<init>(r13, r1, r14, r0)
            r14 = r8
        L_0x003d:
            r8 = r7
            r9 = r2
            r10 = r3
            r11 = r4
            r12 = r5
            r13 = r6
            r8.<init>(r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.glutils.FacedCubemapData.<init>(com.badlogic.gdx.graphics.Pixmap, com.badlogic.gdx.graphics.Pixmap, com.badlogic.gdx.graphics.Pixmap, com.badlogic.gdx.graphics.Pixmap, com.badlogic.gdx.graphics.Pixmap, com.badlogic.gdx.graphics.Pixmap, boolean):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FacedCubemapData(int r10, int r11, int r12, com.badlogic.gdx.graphics.Pixmap.Format r13) {
        /*
            r9 = this;
            com.badlogic.gdx.graphics.glutils.PixmapTextureData r1 = new com.badlogic.gdx.graphics.glutils.PixmapTextureData
            com.badlogic.gdx.graphics.Pixmap r0 = new com.badlogic.gdx.graphics.Pixmap
            r0.<init>(r12, r11, r13)
            r2 = 0
            r3 = 0
            r4 = 1
            r1.<init>(r0, r2, r3, r4)
            com.badlogic.gdx.graphics.glutils.PixmapTextureData r5 = new com.badlogic.gdx.graphics.glutils.PixmapTextureData
            com.badlogic.gdx.graphics.Pixmap r0 = new com.badlogic.gdx.graphics.Pixmap
            r0.<init>(r12, r11, r13)
            r5.<init>(r0, r2, r3, r4)
            com.badlogic.gdx.graphics.glutils.PixmapTextureData r6 = new com.badlogic.gdx.graphics.glutils.PixmapTextureData
            com.badlogic.gdx.graphics.Pixmap r0 = new com.badlogic.gdx.graphics.Pixmap
            r0.<init>(r10, r12, r13)
            r6.<init>(r0, r2, r3, r4)
            com.badlogic.gdx.graphics.glutils.PixmapTextureData r7 = new com.badlogic.gdx.graphics.glutils.PixmapTextureData
            com.badlogic.gdx.graphics.Pixmap r0 = new com.badlogic.gdx.graphics.Pixmap
            r0.<init>(r10, r12, r13)
            r7.<init>(r0, r2, r3, r4)
            com.badlogic.gdx.graphics.glutils.PixmapTextureData r12 = new com.badlogic.gdx.graphics.glutils.PixmapTextureData
            com.badlogic.gdx.graphics.Pixmap r0 = new com.badlogic.gdx.graphics.Pixmap
            r0.<init>(r10, r11, r13)
            r12.<init>(r0, r2, r3, r4)
            com.badlogic.gdx.graphics.glutils.PixmapTextureData r8 = new com.badlogic.gdx.graphics.glutils.PixmapTextureData
            com.badlogic.gdx.graphics.Pixmap r0 = new com.badlogic.gdx.graphics.Pixmap
            r0.<init>(r10, r11, r13)
            r8.<init>(r0, r2, r3, r4)
            r0 = r9
            r2 = r5
            r3 = r6
            r4 = r7
            r5 = r12
            r6 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.glutils.FacedCubemapData.<init>(int, int, int, com.badlogic.gdx.graphics.Pixmap$Format):void");
    }

    public FacedCubemapData(TextureData textureData, TextureData textureData2, TextureData textureData3, TextureData textureData4, TextureData textureData5, TextureData textureData6) {
        TextureData[] textureDataArr = new TextureData[6];
        this.data = textureDataArr;
        textureDataArr[0] = textureData;
        textureDataArr[1] = textureData2;
        textureDataArr[2] = textureData3;
        textureDataArr[3] = textureData4;
        textureDataArr[4] = textureData5;
        textureDataArr[5] = textureData6;
    }
}
