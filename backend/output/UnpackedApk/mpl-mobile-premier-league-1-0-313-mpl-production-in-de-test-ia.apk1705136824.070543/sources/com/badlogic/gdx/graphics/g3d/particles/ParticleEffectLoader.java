package com.badlogic.gdx.graphics.g3d.particles;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.AssetData;
import com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import com.badlogic.gdx.utils.SerializationException;

public class ParticleEffectLoader extends AsynchronousAssetLoader<ParticleEffect, ParticleEffectLoadParameter> {
    public Array<Entry<String, ResourceData<ParticleEffect>>> items = new Array<>();

    public static class ParticleEffectLoadParameter extends AssetLoaderParameters<ParticleEffect> {
        public Array<ParticleBatch<?>> batches;

        public ParticleEffectLoadParameter(Array<ParticleBatch<?>> array) {
            this.batches = array;
        }
    }

    public static class ParticleEffectSaveParameter extends AssetLoaderParameters<ParticleEffect> {
        public Array<ParticleBatch<?>> batches;
        public FileHandle file;
        public AssetManager manager;

        public ParticleEffectSaveParameter(FileHandle fileHandle, AssetManager assetManager, Array<ParticleBatch<?>> array) {
            this.batches = array;
            this.file = fileHandle;
            this.manager = assetManager;
        }
    }

    public ParticleEffectLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    private <T> T find(Array<?> array, Class<T> cls) {
        ArrayIterator it = array.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (cls.isAssignableFrom(next.getClass())) {
                return next;
            }
        }
        return null;
    }

    public void loadAsync(AssetManager assetManager, String str, FileHandle fileHandle, ParticleEffectLoadParameter particleEffectLoadParameter) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d A[SYNTHETIC, Splitter:B:33:0x007d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void save(com.badlogic.gdx.graphics.g3d.particles.ParticleEffect r8, com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader.ParticleEffectSaveParameter r9) throws java.io.IOException {
        /*
            r7 = this;
            com.badlogic.gdx.graphics.g3d.particles.ResourceData r0 = new com.badlogic.gdx.graphics.g3d.particles.ResourceData
            r0.<init>(r8)
            r1 = 0
            r8.save(r1, r0)
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch<?>> r2 = r9.batches
            r3 = 0
            if (r2 == 0) goto L_0x0043
            com.badlogic.gdx.utils.Array$ArrayIterator r2 = r2.iterator()
        L_0x0012:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0043
            java.lang.Object r4 = r2.next()
            com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch r4 = (com.badlogic.gdx.graphics.g3d.particles.batches.ParticleBatch) r4
            com.badlogic.gdx.utils.Array r5 = r8.getControllers()
            com.badlogic.gdx.utils.Array$ArrayIterator r5 = r5.iterator()
        L_0x0026:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x003c
            java.lang.Object r6 = r5.next()
            com.badlogic.gdx.graphics.g3d.particles.ParticleController r6 = (com.badlogic.gdx.graphics.g3d.particles.ParticleController) r6
            com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderer<?, ?> r6 = r6.renderer
            boolean r6 = r6.isCompatible(r4)
            if (r6 == 0) goto L_0x0026
            r5 = 1
            goto L_0x003d
        L_0x003c:
            r5 = 0
        L_0x003d:
            if (r5 == 0) goto L_0x0012
            r4.save(r1, r0)
            goto L_0x0012
        L_0x0043:
            com.badlogic.gdx.utils.Json r8 = new com.badlogic.gdx.utils.Json
            r8.<init>()
            com.badlogic.gdx.files.FileHandle r9 = r9.file
            java.lang.Class<com.badlogic.gdx.graphics.g3d.particles.ResourceData> r2 = com.badlogic.gdx.graphics.g3d.particles.ResourceData.class
            java.lang.String r4 = "UTF-8"
            java.io.Writer r3 = r9.writer(r3, r4)     // Catch:{ Exception -> 0x0062 }
            r8.toJson(r0, r2, r1, r3)     // Catch:{ Exception -> 0x005d, all -> 0x005b }
            java.io.OutputStreamWriter r3 = (java.io.OutputStreamWriter) r3
            r3.close()     // Catch:{ all -> 0x005a }
        L_0x005a:
            return
        L_0x005b:
            r8 = move-exception
            goto L_0x007b
        L_0x005d:
            r8 = move-exception
            r1 = r3
            goto L_0x0063
        L_0x0060:
            r8 = move-exception
            goto L_0x007a
        L_0x0062:
            r8 = move-exception
        L_0x0063:
            com.badlogic.gdx.utils.SerializationException r0 = new com.badlogic.gdx.utils.SerializationException     // Catch:{ all -> 0x0060 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r2.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r3 = "Error writing file: "
            r2.append(r3)     // Catch:{ all -> 0x0060 }
            r2.append(r9)     // Catch:{ all -> 0x0060 }
            java.lang.String r9 = r2.toString()     // Catch:{ all -> 0x0060 }
            r0.<init>(r9, r8)     // Catch:{ all -> 0x0060 }
            throw r0     // Catch:{ all -> 0x0060 }
        L_0x007a:
            r3 = r1
        L_0x007b:
            if (r3 == 0) goto L_0x0080
            r3.close()     // Catch:{ all -> 0x0080 }
        L_0x0080:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader.save(com.badlogic.gdx.graphics.g3d.particles.ParticleEffect, com.badlogic.gdx.graphics.g3d.particles.ParticleEffectLoader$ParticleEffectSaveParameter):void");
    }

    public Array<AssetDescriptor> getDependencies(String str, FileHandle fileHandle, ParticleEffectLoadParameter particleEffectLoadParameter) {
        Array<AssetData> assets;
        try {
            V v = (ResourceData) new Json().readValue(ResourceData.class, (Class) null, new JsonReader().parse(fileHandle));
            synchronized (this.items) {
                Entry entry = new Entry();
                entry.key = str;
                entry.value = v;
                this.items.add(entry);
                assets = v.getAssets();
            }
            Array<AssetDescriptor> array = new Array<>();
            ArrayIterator it = assets.iterator();
            while (it.hasNext()) {
                AssetData assetData = (AssetData) it.next();
                if (!resolve(assetData.filename).exists()) {
                    assetData.filename = fileHandle.parent().child(k.files.internal(assetData.filename).name()).path();
                }
                Class<T> cls = assetData.type;
                if (cls == ParticleEffect.class) {
                    array.add(new AssetDescriptor(assetData.filename, cls, particleEffectLoadParameter));
                } else {
                    array.add(new AssetDescriptor(assetData.filename, cls));
                }
            }
            return array;
        } catch (Exception e2) {
            throw new SerializationException("Error reading file: " + fileHandle, e2);
        }
    }

    public ParticleEffect loadSync(AssetManager assetManager, String str, FileHandle fileHandle, ParticleEffectLoadParameter particleEffectLoadParameter) {
        ResourceData resourceData;
        synchronized (this.items) {
            int i = 0;
            while (true) {
                if (i >= this.items.size) {
                    resourceData = null;
                    break;
                }
                Entry entry = (Entry) this.items.get(i);
                if (((String) entry.key).equals(str)) {
                    resourceData = (ResourceData) entry.value;
                    this.items.removeIndex(i);
                    break;
                }
                i++;
            }
        }
        ((ParticleEffect) resourceData.resource).load(assetManager, resourceData);
        if (particleEffectLoadParameter != null) {
            Array<ParticleBatch<?>> array = particleEffectLoadParameter.batches;
            if (array != null) {
                ArrayIterator it = array.iterator();
                while (it.hasNext()) {
                    ((ParticleBatch) it.next()).load(assetManager, resourceData);
                }
            }
            ((ParticleEffect) resourceData.resource).setBatch(particleEffectLoadParameter.batches);
        }
        return (ParticleEffect) resourceData.resource;
    }
}
