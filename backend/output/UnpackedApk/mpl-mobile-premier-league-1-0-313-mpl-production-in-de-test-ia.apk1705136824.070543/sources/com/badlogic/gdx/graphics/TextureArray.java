package com.badlogic.gdx.graphics;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureArrayData.Factory;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;

public class TextureArray extends GLTexture {
    public static final Map<Application, Array<TextureArray>> managedTextureArrays = new HashMap();
    public TextureArrayData data;

    public TextureArray(String... strArr) {
        this(getInternalHandles(strArr));
    }

    public static void addManagedTexture(Application application, TextureArray textureArray) {
        Array array = managedTextureArrays.get(application);
        if (array == null) {
            array = new Array();
        }
        array.add(textureArray);
        managedTextureArrays.put(application, array);
    }

    public static void clearAllTextureArrays(Application application) {
        managedTextureArrays.remove(application);
    }

    public static FileHandle[] getInternalHandles(String... strArr) {
        FileHandle[] fileHandleArr = new FileHandle[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            fileHandleArr[i] = k.files.internal(strArr[i]);
        }
        return fileHandleArr;
    }

    public static String getManagedStatus() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Managed TextureArrays/app: { ");
        for (Application application : managedTextureArrays.keySet()) {
            outline73.append(managedTextureArrays.get(application).size);
            outline73.append(CMap.SPACE);
        }
        outline73.append("}");
        return outline73.toString();
    }

    public static int getNumManagedTextureArrays() {
        return managedTextureArrays.get(k.app).size;
    }

    public static void invalidateAllTextureArrays(Application application) {
        Array array = managedTextureArrays.get(application);
        if (array != null) {
            for (int i = 0; i < array.size; i++) {
                ((TextureArray) array.get(i)).reload();
            }
        }
    }

    private void load(TextureArrayData textureArrayData) {
        if (this.data == null || textureArrayData.isManaged() == this.data.isManaged()) {
            this.data = textureArrayData;
            bind();
            k.gl30.glTexImage3D((int) GL30.GL_TEXTURE_2D_ARRAY, 0, textureArrayData.getInternalFormat(), textureArrayData.getWidth(), textureArrayData.getHeight(), textureArrayData.getDepth(), 0, textureArrayData.getInternalFormat(), textureArrayData.getGLType(), (Buffer) null);
            if (!textureArrayData.isPrepared()) {
                textureArrayData.prepare();
            }
            textureArrayData.consumeTextureArrayData();
            setFilter(this.minFilter, this.magFilter);
            setWrap(this.uWrap, this.vWrap);
            k.gl.glBindTexture(this.glTarget, 0);
            return;
        }
        throw new GdxRuntimeException((String) "New data must have the same managed status as the old data");
    }

    public int getDepth() {
        return this.data.getDepth();
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

    public void reload() {
        if (isManaged()) {
            this.glHandle = k.gl.glGenTexture();
            load(this.data);
            return;
        }
        throw new GdxRuntimeException((String) "Tried to reload an unmanaged TextureArray");
    }

    public TextureArray(FileHandle... fileHandleArr) {
        this(false, fileHandleArr);
    }

    public TextureArray(boolean z, FileHandle... fileHandleArr) {
        this(z, Format.RGBA8888, fileHandleArr);
    }

    public TextureArray(boolean z, Format format, FileHandle... fileHandleArr) {
        this(Factory.loadFromFiles(format, z, fileHandleArr));
    }

    public TextureArray(TextureArrayData textureArrayData) {
        super(GL30.GL_TEXTURE_2D_ARRAY, k.gl.glGenTexture());
        if (k.gl30 != null) {
            load(textureArrayData);
            if (textureArrayData.isManaged()) {
                addManagedTexture(k.app, this);
                return;
            }
            return;
        }
        throw new GdxRuntimeException((String) "TextureArray requires a device running with GLES 3.0 compatibilty");
    }
}
