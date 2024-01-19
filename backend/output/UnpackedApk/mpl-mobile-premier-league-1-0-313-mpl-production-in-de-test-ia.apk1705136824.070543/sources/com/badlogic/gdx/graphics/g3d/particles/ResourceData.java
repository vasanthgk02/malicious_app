package com.badlogic.gdx.graphics.g3d.particles;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entries;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.badlogic.gdx.utils.reflect.ReflectionException;

public class ResourceData<T> implements Serializable {
    public int currentLoadIndex;
    public Array<SaveData> data;
    public T resource;
    public Array<AssetData> sharedAssets;
    public ObjectMap<String, SaveData> uniqueData;

    public static class AssetData<T> implements Serializable {
        public String filename;
        public Class<T> type;

        public AssetData() {
        }

        public void read(Json json, JsonValue jsonValue) {
            Class cls = String.class;
            this.filename = (String) json.readValue((String) "filename", cls, jsonValue);
            String str = (String) json.readValue((String) "type", cls, jsonValue);
            try {
                this.type = k.forName(str);
            } catch (ReflectionException e2) {
                throw new GdxRuntimeException(GeneratedOutlineSupport.outline50("Class not found: ", str), e2);
            }
        }

        public void write(Json json) {
            json.writeValue("filename", this.filename);
            json.writeValue("type", this.type.getName());
        }

        public AssetData(String str, Class<T> cls) {
            this.filename = str;
            this.type = cls;
        }
    }

    public interface Configurable<T> {
        void load(AssetManager assetManager, ResourceData<T> resourceData);

        void save(AssetManager assetManager, ResourceData<T> resourceData);
    }

    public static class SaveData implements Serializable {
        public IntArray assets = new IntArray();
        public ObjectMap<String, Object> data = new ObjectMap<>();
        public int loadIndex = 0;
        public ResourceData resources;

        public SaveData() {
        }

        public <K> K load(String str) {
            return this.data.get(str);
        }

        public AssetDescriptor loadAsset() {
            int i = this.loadIndex;
            IntArray intArray = this.assets;
            if (i == intArray.size) {
                return null;
            }
            Array<AssetData> array = this.resources.sharedAssets;
            this.loadIndex = i + 1;
            AssetData assetData = (AssetData) array.get(intArray.get(i));
            return new AssetDescriptor(assetData.filename, assetData.type);
        }

        public void read(Json json, JsonValue jsonValue) {
            this.data = (ObjectMap) json.readValue((String) "data", ObjectMap.class, jsonValue);
            IntArray intArray = this.assets;
            int[] iArr = (int[]) json.readValue((String) "indices", int[].class, jsonValue);
            if (intArray != null) {
                int length = iArr.length;
                int[] iArr2 = intArray.items;
                int i = intArray.size + length;
                if (i > iArr2.length) {
                    iArr2 = intArray.resize(Math.max(Math.max(8, i), (int) (((float) intArray.size) * 1.75f)));
                }
                System.arraycopy(iArr, 0, iArr2, intArray.size, length);
                intArray.size += length;
                return;
            }
            throw null;
        }

        public void save(String str, Object obj) {
            this.data.put(str, obj);
        }

        public <K> void saveAsset(String str, Class<K> cls) {
            int assetData = this.resources.getAssetData(str, cls);
            if (assetData == -1) {
                this.resources.sharedAssets.add(new AssetData(str, cls));
                assetData = this.resources.sharedAssets.size - 1;
            }
            this.assets.add(assetData);
        }

        public void write(Json json) {
            json.writeValue((String) "data", (Object) this.data, ObjectMap.class);
            IntArray intArray = this.assets;
            int i = intArray.size;
            int[] iArr = new int[i];
            System.arraycopy(intArray.items, 0, iArr, 0, i);
            json.writeValue((String) "indices", (Object) iArr, int[].class);
        }

        public SaveData(ResourceData resourceData) {
            this.resources = resourceData;
        }
    }

    public ResourceData() {
        this.uniqueData = new ObjectMap<>();
        this.data = new Array<>(true, 3, SaveData.class);
        this.sharedAssets = new Array<>();
        this.currentLoadIndex = 0;
    }

    public SaveData createSaveData() {
        SaveData saveData = new SaveData(this);
        this.data.add(saveData);
        return saveData;
    }

    public <K> int getAssetData(String str, Class<K> cls) {
        ArrayIterator it = this.sharedAssets.iterator();
        int i = 0;
        while (it.hasNext()) {
            AssetData assetData = (AssetData) it.next();
            if (assetData.filename.equals(str) && assetData.type.equals(cls)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public Array<AssetDescriptor> getAssetDescriptors() {
        Array<AssetDescriptor> array = new Array<>();
        ArrayIterator it = this.sharedAssets.iterator();
        while (it.hasNext()) {
            AssetData assetData = (AssetData) it.next();
            array.add(new AssetDescriptor(assetData.filename, assetData.type));
        }
        return array;
    }

    public Array<AssetData> getAssets() {
        return this.sharedAssets;
    }

    public SaveData getSaveData() {
        Array<SaveData> array = this.data;
        int i = this.currentLoadIndex;
        this.currentLoadIndex = i + 1;
        return (SaveData) array.get(i);
    }

    public void read(Json json, JsonValue jsonValue) {
        ObjectMap<String, SaveData> objectMap = (ObjectMap) json.readValue((String) "unique", ObjectMap.class, jsonValue);
        this.uniqueData = objectMap;
        Entries entries = objectMap.entries();
        if (entries != null) {
            while (entries.hasNext()) {
                ((SaveData) ((Entry) entries.next()).value).resources = this;
            }
            Array<SaveData> array = (Array) json.readValue("data", Array.class, SaveData.class, jsonValue);
            this.data = array;
            ArrayIterator it = array.iterator();
            while (it.hasNext()) {
                ((SaveData) it.next()).resources = this;
            }
            this.sharedAssets.addAll((Array) json.readValue("assets", Array.class, AssetData.class, jsonValue));
            this.resource = json.readValue((String) "resource", (Class<T>) null, jsonValue);
            return;
        }
        throw null;
    }

    public void write(Json json) {
        json.writeValue((String) "unique", (Object) this.uniqueData, ObjectMap.class);
        json.writeValue("data", this.data, Array.class, SaveData.class);
        json.writeValue((String) "assets", (Object) this.sharedAssets.toArray(AssetData.class), AssetData[].class);
        json.writeValue((String) "resource", (Object) this.resource, (Class) null);
    }

    public SaveData getSaveData(String str) {
        return (SaveData) this.uniqueData.get(str);
    }

    public SaveData createSaveData(String str) {
        SaveData saveData = new SaveData(this);
        if (!(this.uniqueData.locateKey(str) >= 0)) {
            this.uniqueData.put(str, saveData);
            return saveData;
        }
        throw new RuntimeException("Key already used, data must be unique, use a different key");
    }

    public ResourceData(T t) {
        this();
        this.resource = t;
    }
}
