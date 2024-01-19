package com.badlogic.gdx.graphics;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureData.Factory;
import com.badlogic.gdx.graphics.glutils.FileTextureData;
import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;

public class Texture extends GLTexture {
    public static AssetManager assetManager;
    public static final Map<Application, Array<Texture>> managedTextures = new HashMap();
    public TextureData data;

    public enum TextureFilter {
        Nearest(GL20.GL_NEAREST),
        Linear(GL20.GL_LINEAR),
        MipMap(GL20.GL_LINEAR_MIPMAP_LINEAR),
        MipMapNearestNearest(GL20.GL_NEAREST_MIPMAP_NEAREST),
        MipMapLinearNearest(GL20.GL_LINEAR_MIPMAP_NEAREST),
        MipMapNearestLinear(GL20.GL_NEAREST_MIPMAP_LINEAR),
        MipMapLinearLinear(GL20.GL_LINEAR_MIPMAP_LINEAR);
        
        public final int glEnum;

        /* access modifiers changed from: public */
        TextureFilter(int i) {
            this.glEnum = i;
        }

        public int getGLEnum() {
            return this.glEnum;
        }

        public boolean isMipMap() {
            int i = this.glEnum;
            return (i == 9728 || i == 9729) ? false : true;
        }
    }

    public enum TextureWrap {
        MirroredRepeat(GL20.GL_MIRRORED_REPEAT),
        ClampToEdge(GL20.GL_CLAMP_TO_EDGE),
        Repeat(GL20.GL_REPEAT);
        
        public final int glEnum;

        /* access modifiers changed from: public */
        TextureWrap(int i) {
            this.glEnum = i;
        }

        public int getGLEnum() {
            return this.glEnum;
        }
    }

    public Texture(String str) {
        this(k.files.internal(str));
    }

    public static void addManagedTexture(Application application, Texture texture) {
        Array array = managedTextures.get(application);
        if (array == null) {
            array = new Array();
        }
        array.add(texture);
        managedTextures.put(application, array);
    }

    public static void clearAllTextures(Application application) {
        managedTextures.remove(application);
    }

    public static String getManagedStatus() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Managed textures/app: { ");
        for (Application application : managedTextures.keySet()) {
            outline73.append(managedTextures.get(application).size);
            outline73.append(CMap.SPACE);
        }
        outline73.append("}");
        return outline73.toString();
    }

    public static int getNumManagedTextures() {
        return managedTextures.get(k.app).size;
    }

    public static void invalidateAllTextures(Application application) {
        Array array = managedTextures.get(application);
        if (array != null) {
            for (int i = 0; i < array.size; i++) {
                ((Texture) array.get(i)).reload();
            }
        }
    }

    public static void setAssetManager(AssetManager assetManager2) {
        assetManager = assetManager2;
    }

    public void dispose() {
        if (this.glHandle != 0) {
            delete();
            if (this.data.isManaged() && managedTextures.get(k.app) != null) {
                managedTextures.get(k.app).removeValue(this, true);
            }
        }
    }

    public void draw(Pixmap pixmap, int i, int i2) {
        if (!this.data.isManaged()) {
            bind();
            k.gl.glTexSubImage2D(this.glTarget, 0, i, i2, pixmap.getWidth(), pixmap.getHeight(), pixmap.getGLFormat(), pixmap.getGLType(), pixmap.getPixels());
            return;
        }
        throw new GdxRuntimeException((String) "can't draw to a managed texture");
    }

    public int getDepth() {
        return 0;
    }

    public int getHeight() {
        return this.data.getHeight();
    }

    public TextureData getTextureData() {
        return this.data;
    }

    public int getWidth() {
        return this.data.getWidth();
    }

    public boolean isManaged() {
        return this.data.isManaged();
    }

    public void load(TextureData textureData) {
        if (this.data == null || textureData.isManaged() == this.data.isManaged()) {
            this.data = textureData;
            if (!textureData.isPrepared()) {
                textureData.prepare();
            }
            bind();
            GLTexture.uploadImageData(GL20.GL_TEXTURE_2D, textureData);
            unsafeSetFilter(this.minFilter, this.magFilter, true);
            unsafeSetWrap(this.uWrap, this.vWrap, true);
            unsafeSetAnisotropicFilter(this.anisotropicFilterLevel, true);
            k.gl.glBindTexture(this.glTarget, 0);
            return;
        }
        throw new GdxRuntimeException((String) "New data must have the same managed status as the old data");
    }

    public void reload() {
        if (isManaged()) {
            this.glHandle = k.gl.glGenTexture();
            load(this.data);
            return;
        }
        throw new GdxRuntimeException((String) "Tried to reload unmanaged Texture");
    }

    public String toString() {
        TextureData textureData = this.data;
        if (textureData instanceof FileTextureData) {
            return textureData.toString();
        }
        return super.toString();
    }

    public Texture(FileHandle fileHandle) {
        this(fileHandle, (Format) null, false);
    }

    public Texture(FileHandle fileHandle, boolean z) {
        this(fileHandle, (Format) null, z);
    }

    public Texture(FileHandle fileHandle, Format format, boolean z) {
        this(Factory.loadFromFile(fileHandle, format, z));
    }

    public Texture(Pixmap pixmap) {
        this((TextureData) new PixmapTextureData(pixmap, null, false, false));
    }

    public Texture(Pixmap pixmap, boolean z) {
        this((TextureData) new PixmapTextureData(pixmap, null, z, false));
    }

    public Texture(Pixmap pixmap, Format format, boolean z) {
        this((TextureData) new PixmapTextureData(pixmap, format, z, false));
    }

    public Texture(int i, int i2, Format format) {
        this((TextureData) new PixmapTextureData(new Pixmap(i, i2, format), null, false, true));
    }

    public Texture(TextureData textureData) {
        this((int) GL20.GL_TEXTURE_2D, k.gl.glGenTexture(), textureData);
    }

    public Texture(int i, int i2, TextureData textureData) {
        super(i, i2);
        load(textureData);
        if (textureData.isManaged()) {
            addManagedTexture(k.app, this);
        }
    }
}
