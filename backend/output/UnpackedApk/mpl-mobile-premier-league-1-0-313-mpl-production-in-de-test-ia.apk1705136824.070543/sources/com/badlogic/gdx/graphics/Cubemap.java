package com.badlogic.gdx.graphics;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.TextureData.Factory;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;

public class Cubemap extends GLTexture {
    public static AssetManager assetManager;
    public static final Map<Application, Array<Cubemap>> managedCubemaps = new HashMap();
    public CubemapData data;

    public enum CubemapSide {
        PositiveX(0, GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_X, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 0.0f),
        NegativeX(1, GL20.GL_TEXTURE_CUBE_MAP_NEGATIVE_X, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 0.0f),
        PositiveY(2, GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_Y, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f),
        NegativeY(3, GL20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y, 0.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f),
        PositiveZ(4, GL20.GL_TEXTURE_CUBE_MAP_POSITIVE_Z, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f),
        NegativeZ(5, GL20.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, -1.0f);
        
        public final Vector3 direction;
        public final int glEnum;
        public final int index;
        public final Vector3 up;

        /* access modifiers changed from: public */
        CubemapSide(int i, int i2, float f2, float f3, float f4, float f5, float f6, float f7) {
            this.index = i;
            this.glEnum = i2;
            this.up = new Vector3(f2, f3, f4);
            this.direction = new Vector3(f5, f6, f7);
        }

        public Vector3 getDirection(Vector3 vector3) {
            vector3.set(this.direction);
            return vector3;
        }

        public int getGLEnum() {
            return this.glEnum;
        }

        public Vector3 getUp(Vector3 vector3) {
            vector3.set(this.up);
            return vector3;
        }
    }

    public Cubemap(CubemapData cubemapData) {
        super(GL20.GL_TEXTURE_CUBE_MAP);
        this.data = cubemapData;
        load(cubemapData);
        if (cubemapData.isManaged()) {
            addManagedCubemap(k.app, this);
        }
    }

    public static void addManagedCubemap(Application application, Cubemap cubemap) {
        Array array = managedCubemaps.get(application);
        if (array == null) {
            array = new Array();
        }
        array.add(cubemap);
        managedCubemaps.put(application, array);
    }

    public static void clearAllCubemaps(Application application) {
        managedCubemaps.remove(application);
    }

    public static String getManagedStatus() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Managed cubemap/app: { ");
        for (Application application : managedCubemaps.keySet()) {
            outline73.append(managedCubemaps.get(application).size);
            outline73.append(CMap.SPACE);
        }
        outline73.append("}");
        return outline73.toString();
    }

    public static int getNumManagedCubemaps() {
        return managedCubemaps.get(k.app).size;
    }

    public static void invalidateAllCubemaps(Application application) {
        Array array = managedCubemaps.get(application);
        if (array != null) {
            for (int i = 0; i < array.size; i++) {
                ((Cubemap) array.get(i)).reload();
            }
        }
    }

    public static void setAssetManager(AssetManager assetManager2) {
        assetManager = assetManager2;
    }

    public void dispose() {
        if (this.glHandle != 0) {
            delete();
            if (this.data.isManaged() && managedCubemaps.get(k.app) != null) {
                managedCubemaps.get(k.app).removeValue(this, true);
            }
        }
    }

    public CubemapData getCubemapData() {
        return this.data;
    }

    public int getDepth() {
        return 0;
    }

    public int getHeight() {
        return this.data.getHeight();
    }

    public int getWidth() {
        return this.data.getWidth();
    }

    public boolean isManaged() {
        return this.data.isManaged();
    }

    public void load(CubemapData cubemapData) {
        if (!cubemapData.isPrepared()) {
            cubemapData.prepare();
        }
        bind();
        unsafeSetFilter(this.minFilter, this.magFilter, true);
        unsafeSetWrap(this.uWrap, this.vWrap, true);
        unsafeSetAnisotropicFilter(this.anisotropicFilterLevel, true);
        cubemapData.consumeCubemapData();
        k.gl.glBindTexture(this.glTarget, 0);
    }

    public void reload() {
        if (isManaged()) {
            this.glHandle = k.gl.glGenTexture();
            load(this.data);
            return;
        }
        throw new GdxRuntimeException((String) "Tried to reload an unmanaged Cubemap");
    }

    public Cubemap(FileHandle fileHandle, FileHandle fileHandle2, FileHandle fileHandle3, FileHandle fileHandle4, FileHandle fileHandle5, FileHandle fileHandle6) {
        this(fileHandle, fileHandle2, fileHandle3, fileHandle4, fileHandle5, fileHandle6, false);
    }

    public Cubemap(FileHandle fileHandle, FileHandle fileHandle2, FileHandle fileHandle3, FileHandle fileHandle4, FileHandle fileHandle5, FileHandle fileHandle6, boolean z) {
        this(Factory.loadFromFile(fileHandle, z), Factory.loadFromFile(fileHandle2, z), Factory.loadFromFile(fileHandle3, z), Factory.loadFromFile(fileHandle4, z), Factory.loadFromFile(fileHandle5, z), Factory.loadFromFile(fileHandle6, z));
    }

    public Cubemap(Pixmap pixmap, Pixmap pixmap2, Pixmap pixmap3, Pixmap pixmap4, Pixmap pixmap5, Pixmap pixmap6) {
        this(pixmap, pixmap2, pixmap3, pixmap4, pixmap5, pixmap6, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Cubemap(com.badlogic.gdx.graphics.Pixmap r8, com.badlogic.gdx.graphics.Pixmap r9, com.badlogic.gdx.graphics.Pixmap r10, com.badlogic.gdx.graphics.Pixmap r11, com.badlogic.gdx.graphics.Pixmap r12, com.badlogic.gdx.graphics.Pixmap r13, boolean r14) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.Cubemap.<init>(com.badlogic.gdx.graphics.Pixmap, com.badlogic.gdx.graphics.Pixmap, com.badlogic.gdx.graphics.Pixmap, com.badlogic.gdx.graphics.Pixmap, com.badlogic.gdx.graphics.Pixmap, com.badlogic.gdx.graphics.Pixmap, boolean):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Cubemap(int r10, int r11, int r12, com.badlogic.gdx.graphics.Pixmap.Format r13) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.Cubemap.<init>(int, int, int, com.badlogic.gdx.graphics.Pixmap$Format):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Cubemap(com.badlogic.gdx.graphics.TextureData r9, com.badlogic.gdx.graphics.TextureData r10, com.badlogic.gdx.graphics.TextureData r11, com.badlogic.gdx.graphics.TextureData r12, com.badlogic.gdx.graphics.TextureData r13, com.badlogic.gdx.graphics.TextureData r14) {
        /*
            r8 = this;
            com.badlogic.gdx.graphics.glutils.FacedCubemapData r7 = new com.badlogic.gdx.graphics.glutils.FacedCubemapData
            r0 = r7
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r8.<init>(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.Cubemap.<init>(com.badlogic.gdx.graphics.TextureData, com.badlogic.gdx.graphics.TextureData, com.badlogic.gdx.graphics.TextureData, com.badlogic.gdx.graphics.TextureData, com.badlogic.gdx.graphics.TextureData, com.badlogic.gdx.graphics.TextureData):void");
    }
}
