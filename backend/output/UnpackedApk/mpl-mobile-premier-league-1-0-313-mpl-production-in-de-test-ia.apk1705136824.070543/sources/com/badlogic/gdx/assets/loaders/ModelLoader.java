package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.ModelLoader.ModelParameters;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.graphics.g3d.model.data.ModelTexture;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider.AssetTextureProvider;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider.FileTextureProvider;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import java.util.Iterator;

public abstract class ModelLoader<P extends ModelParameters> extends AsynchronousAssetLoader<Model, P> {
    public ModelParameters defaultParameters = new ModelParameters();
    public Array<Entry<String, ModelData>> items = new Array<>();

    public static class ModelParameters extends AssetLoaderParameters<Model> {
        public TextureLoader$TextureParameter textureParameter = new TextureLoader$TextureParameter();

        public ModelParameters() {
            TextureFilter textureFilter = TextureFilter.Linear;
            TextureWrap textureWrap = TextureWrap.Repeat;
        }
    }

    public ModelLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    public void loadAsync(AssetManager assetManager, String str, FileHandle fileHandle, P p) {
    }

    public Model loadModel(FileHandle fileHandle, TextureProvider textureProvider, P p) {
        ModelData loadModelData = loadModelData(fileHandle, p);
        if (loadModelData == null) {
            return null;
        }
        return new Model(loadModelData, textureProvider);
    }

    public ModelData loadModelData(FileHandle fileHandle) {
        return loadModelData(fileHandle, null);
    }

    public abstract ModelData loadModelData(FileHandle fileHandle, P p);

    public Array<AssetDescriptor> getDependencies(String str, FileHandle fileHandle, P p) {
        Array<AssetDescriptor> array = new Array<>();
        V loadModelData = loadModelData(fileHandle, p);
        if (loadModelData == null) {
            return array;
        }
        Entry entry = new Entry();
        entry.key = str;
        entry.value = loadModelData;
        synchronized (this.items) {
            this.items.add(entry);
        }
        TextureLoader$TextureParameter textureLoader$TextureParameter = p != null ? p.textureParameter : this.defaultParameters.textureParameter;
        ArrayIterator it = loadModelData.materials.iterator();
        while (it.hasNext()) {
            Array<ModelTexture> array2 = ((ModelMaterial) it.next()).textures;
            if (array2 != null) {
                ArrayIterator it2 = array2.iterator();
                while (it2.hasNext()) {
                    array.add(new AssetDescriptor(((ModelTexture) it2.next()).fileName, Texture.class, textureLoader$TextureParameter));
                }
            }
        }
        return array;
    }

    public Model loadSync(AssetManager assetManager, String str, FileHandle fileHandle, P p) {
        ModelData modelData;
        synchronized (this.items) {
            modelData = null;
            for (int i = 0; i < this.items.size; i++) {
                if (((String) ((Entry) this.items.get(i)).key).equals(str)) {
                    modelData = (ModelData) ((Entry) this.items.get(i)).value;
                    this.items.removeIndex(i);
                }
            }
        }
        if (modelData == null) {
            return null;
        }
        Model model = new Model(modelData, new AssetTextureProvider(assetManager));
        Iterator<Disposable> it = model.getManagedDisposables().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof Texture) {
                it.remove();
            }
        }
        return model;
    }

    public Model loadModel(FileHandle fileHandle, P p) {
        return loadModel(fileHandle, new FileTextureProvider(), p);
    }

    public Model loadModel(FileHandle fileHandle, TextureProvider textureProvider) {
        return loadModel(fileHandle, textureProvider, null);
    }

    public Model loadModel(FileHandle fileHandle) {
        return loadModel(fileHandle, new FileTextureProvider(), null);
    }
}
