package com.badlogic.gdx.graphics.g2d;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.SynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ShortArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PolygonRegionLoader extends SynchronousAssetLoader<PolygonRegion, PolygonRegionParameters> {
    public PolygonRegionParameters defaultParameters;
    public EarClippingTriangulator triangulator;

    public static class PolygonRegionParameters extends AssetLoaderParameters<PolygonRegion> {
        public int readerBuffer = 1024;
        public String[] textureExtensions = {"png", "PNG", "jpeg", "JPEG", "jpg", "JPG", "cim", "CIM", "etc1", "ETC1", "ktx", "KTX", "zktx", "ZKTX"};
        public String texturePrefix = "i ";
    }

    public PolygonRegionLoader() {
        this(new InternalFileHandleResolver());
    }

    public PolygonRegion load(AssetManager assetManager, String str, FileHandle fileHandle, PolygonRegionParameters polygonRegionParameters) {
        throw null;
    }

    public PolygonRegionLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
        this.defaultParameters = new PolygonRegionParameters();
        this.triangulator = new EarClippingTriangulator();
    }

    public Array<AssetDescriptor> getDependencies(String str, FileHandle fileHandle, PolygonRegionParameters polygonRegionParameters) {
        String str2;
        if (polygonRegionParameters == null) {
            polygonRegionParameters = this.defaultParameters;
        }
        try {
            int i = polygonRegionParameters.readerBuffer;
            if (fileHandle != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileHandle.read()), i);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (readLine.startsWith(polygonRegionParameters.texturePrefix)) {
                            str2 = readLine.substring(polygonRegionParameters.texturePrefix.length());
                            break;
                        }
                    } else {
                        str2 = null;
                        break;
                    }
                }
                bufferedReader.close();
                if (str2 == null) {
                    String[] strArr = polygonRegionParameters.textureExtensions;
                    if (strArr != null) {
                        for (String str3 : strArr) {
                            FileHandle sibling = fileHandle.sibling(fileHandle.nameWithoutExtension().concat("." + str3));
                            if (sibling.exists()) {
                                str2 = sibling.name();
                            }
                        }
                    }
                }
                if (str2 == null) {
                    return null;
                }
                Array<AssetDescriptor> array = new Array<>(true, 1);
                array.add(new AssetDescriptor(fileHandle.sibling(str2), Texture.class));
                return array;
            }
            throw null;
        } catch (IOException e2) {
            throw new GdxRuntimeException(GeneratedOutlineSupport.outline50("Error reading ", str), e2);
        }
    }

    public PolygonRegion load(TextureRegion textureRegion, FileHandle fileHandle) {
        String readLine;
        if (fileHandle != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileHandle.read()), 256);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused) {
                        }
                        throw new GdxRuntimeException("Polygon shape not found: " + fileHandle);
                    }
                } catch (IOException e2) {
                    throw new GdxRuntimeException("Error reading polygon shape file: " + fileHandle, e2);
                } catch (Throwable unused2) {
                }
            } while (!readLine.startsWith("s"));
            String[] split = readLine.substring(1).trim().split(",");
            int length = split.length;
            float[] fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = Float.parseFloat(split[i]);
            }
            ShortArray computeTriangles = this.triangulator.computeTriangles(fArr);
            int i2 = computeTriangles.size;
            short[] sArr = new short[i2];
            System.arraycopy(computeTriangles.items, 0, sArr, 0, i2);
            PolygonRegion polygonRegion = new PolygonRegion(textureRegion, fArr, sArr);
            try {
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
            return polygonRegion;
        }
        throw null;
        throw th;
    }
}
