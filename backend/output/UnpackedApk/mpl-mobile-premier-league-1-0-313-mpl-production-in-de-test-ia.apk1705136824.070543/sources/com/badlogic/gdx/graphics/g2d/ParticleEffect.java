package com.badlogic.gdx.graphics.g2d;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Writer;

public class ParticleEffect implements Disposable {
    public BoundingBox bounds;
    public final Array<ParticleEmitter> emitters;
    public float motionScale;
    public boolean ownsTexture;
    public float xSizeScale;
    public float ySizeScale;

    public ParticleEffect() {
        this.xSizeScale = 1.0f;
        this.ySizeScale = 1.0f;
        this.motionScale = 1.0f;
        this.emitters = new Array<>(true, 8);
    }

    public void allowCompletion() {
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleEmitter) this.emitters.get(i2)).allowCompletion();
        }
    }

    public void dispose() {
        if (this.ownsTexture) {
            int i = this.emitters.size;
            for (int i2 = 0; i2 < i; i2++) {
                ArrayIterator it = ((ParticleEmitter) this.emitters.get(i2)).getSprites().iterator();
                while (it.hasNext()) {
                    ((Sprite) it.next()).getTexture().dispose();
                }
            }
        }
    }

    public void draw(Batch batch) {
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleEmitter) this.emitters.get(i2)).draw(batch);
        }
    }

    public ParticleEmitter findEmitter(String str) {
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            ParticleEmitter particleEmitter = (ParticleEmitter) this.emitters.get(i2);
            if (particleEmitter.getName().equals(str)) {
                return particleEmitter;
            }
        }
        return null;
    }

    public void flipY() {
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleEmitter) this.emitters.get(i2)).flipY();
        }
    }

    public BoundingBox getBoundingBox() {
        if (this.bounds == null) {
            this.bounds = new BoundingBox();
        }
        BoundingBox boundingBox = this.bounds;
        boundingBox.inf();
        ArrayIterator it = this.emitters.iterator();
        while (it.hasNext()) {
            boundingBox.ext(((ParticleEmitter) it.next()).getBoundingBox());
        }
        return boundingBox;
    }

    public Array<ParticleEmitter> getEmitters() {
        return this.emitters;
    }

    public boolean isComplete() {
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (!((ParticleEmitter) this.emitters.get(i2)).isComplete()) {
                return false;
            }
        }
        return true;
    }

    public void load(FileHandle fileHandle, FileHandle fileHandle2) {
        loadEmitters(fileHandle);
        loadEmitterImages(fileHandle2);
    }

    public void loadEmitterImages(TextureAtlas textureAtlas) {
        loadEmitterImages(textureAtlas, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b A[SYNTHETIC, Splitter:B:19:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadEmitters(com.badlogic.gdx.files.FileHandle r6) {
        /*
            r5 = this;
            java.io.InputStream r0 = r6.read()
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.ParticleEmitter> r1 = r5.emitters
            r1.clear()
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0031 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0031 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0031 }
            r0 = 512(0x200, float:7.17E-43)
            r2.<init>(r3, r0)     // Catch:{ IOException -> 0x0031 }
        L_0x0016:
            com.badlogic.gdx.graphics.g2d.ParticleEmitter r0 = r5.newEmitter(r2)     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.ParticleEmitter> r1 = r5.emitters     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            r1.add(r0)     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            java.lang.String r0 = r2.readLine()     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            if (r0 != 0) goto L_0x0016
            r2.close()     // Catch:{ all -> 0x0028 }
        L_0x0028:
            return
        L_0x0029:
            r6 = move-exception
            r1 = r2
            goto L_0x0049
        L_0x002c:
            r0 = move-exception
            r1 = r2
            goto L_0x0032
        L_0x002f:
            r6 = move-exception
            goto L_0x0049
        L_0x0031:
            r0 = move-exception
        L_0x0032:
            com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x002f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002f }
            r3.<init>()     // Catch:{ all -> 0x002f }
            java.lang.String r4 = "Error loading effect: "
            r3.append(r4)     // Catch:{ all -> 0x002f }
            r3.append(r6)     // Catch:{ all -> 0x002f }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x002f }
            r2.<init>(r6, r0)     // Catch:{ all -> 0x002f }
            throw r2     // Catch:{ all -> 0x002f }
        L_0x0049:
            if (r1 == 0) goto L_0x004e
            r1.close()     // Catch:{ all -> 0x004e }
        L_0x004e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.ParticleEffect.loadEmitters(com.badlogic.gdx.files.FileHandle):void");
    }

    public Texture loadTexture(FileHandle fileHandle) {
        return new Texture(fileHandle, false);
    }

    public ParticleEmitter newEmitter(BufferedReader bufferedReader) throws IOException {
        return new ParticleEmitter(bufferedReader);
    }

    public void preAllocateParticles() {
        ArrayIterator it = this.emitters.iterator();
        while (it.hasNext()) {
            ((ParticleEmitter) it.next()).preAllocateParticles();
        }
    }

    public void reset() {
        reset(true);
    }

    public void save(Writer writer) throws IOException {
        int i = this.emitters.size;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            ParticleEmitter particleEmitter = (ParticleEmitter) this.emitters.get(i2);
            int i4 = i3 + 1;
            if (i3 > 0) {
                writer.write("\n");
            }
            particleEmitter.save(writer);
            i2++;
            i3 = i4;
        }
    }

    public void scaleEffect(float f2) {
        scaleEffect(f2, f2, f2);
    }

    public void setDuration(int i) {
        int i2 = this.emitters.size;
        for (int i3 = 0; i3 < i2; i3++) {
            ParticleEmitter particleEmitter = (ParticleEmitter) this.emitters.get(i3);
            particleEmitter.setContinuous(false);
            particleEmitter.duration = (float) i;
            particleEmitter.durationTimer = 0.0f;
        }
    }

    public void setEmittersCleanUpBlendFunction(boolean z) {
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleEmitter) this.emitters.get(i2)).setCleansUpBlendFunction(z);
        }
    }

    public void setFlip(boolean z, boolean z2) {
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleEmitter) this.emitters.get(i2)).setFlip(z, z2);
        }
    }

    public void setPosition(float f2, float f3) {
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleEmitter) this.emitters.get(i2)).setPosition(f2, f3);
        }
    }

    public void start() {
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleEmitter) this.emitters.get(i2)).start();
        }
    }

    public void update(float f2) {
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleEmitter) this.emitters.get(i2)).update(f2);
        }
    }

    public void loadEmitterImages(TextureAtlas textureAtlas, String str) {
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            ParticleEmitter particleEmitter = (ParticleEmitter) this.emitters.get(i2);
            if (particleEmitter.getImagePaths().size != 0) {
                Array array = new Array();
                ArrayIterator it = particleEmitter.getImagePaths().iterator();
                while (it.hasNext()) {
                    String name = new File(((String) it.next()).replace('\\', '/')).getName();
                    int lastIndexOf = name.lastIndexOf(46);
                    if (lastIndexOf != -1) {
                        name = name.substring(0, lastIndexOf);
                    }
                    if (str != null) {
                        name = GeneratedOutlineSupport.outline50(str, name);
                    }
                    Sprite createSprite = textureAtlas.createSprite(name);
                    if (createSprite != null) {
                        array.add(createSprite);
                    } else {
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("SpriteSheet missing image: ", name));
                    }
                }
                particleEmitter.setSprites(array);
            }
        }
    }

    public ParticleEmitter newEmitter(ParticleEmitter particleEmitter) {
        return new ParticleEmitter(particleEmitter);
    }

    public void reset(boolean z) {
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleEmitter) this.emitters.get(i2)).reset();
        }
        if (!z) {
            return;
        }
        if (this.xSizeScale != 1.0f || this.ySizeScale != 1.0f || this.motionScale != 1.0f) {
            scaleEffect(1.0f / this.xSizeScale, 1.0f / this.ySizeScale, 1.0f / this.motionScale);
            this.motionScale = 1.0f;
            this.ySizeScale = 1.0f;
            this.xSizeScale = 1.0f;
        }
    }

    public void scaleEffect(float f2, float f3) {
        scaleEffect(f2, f2, f3);
    }

    public void draw(Batch batch, float f2) {
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            ((ParticleEmitter) this.emitters.get(i2)).draw(batch, f2);
        }
    }

    public void load(FileHandle fileHandle, TextureAtlas textureAtlas) {
        load(fileHandle, textureAtlas, null);
    }

    public void scaleEffect(float f2, float f3, float f4) {
        this.xSizeScale *= f2;
        this.ySizeScale *= f3;
        this.motionScale *= f4;
        ArrayIterator it = this.emitters.iterator();
        while (it.hasNext()) {
            ParticleEmitter particleEmitter = (ParticleEmitter) it.next();
            particleEmitter.scaleSize(f2, f3);
            particleEmitter.scaleMotion(f4);
        }
    }

    public void load(FileHandle fileHandle, TextureAtlas textureAtlas, String str) {
        loadEmitters(fileHandle);
        loadEmitterImages(textureAtlas, str);
    }

    public ParticleEffect(ParticleEffect particleEffect) {
        this.xSizeScale = 1.0f;
        this.ySizeScale = 1.0f;
        this.motionScale = 1.0f;
        this.emitters = new Array<>(true, particleEffect.emitters.size);
        int i = particleEffect.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.emitters.add(newEmitter((ParticleEmitter) particleEffect.emitters.get(i2)));
        }
    }

    public void loadEmitterImages(FileHandle fileHandle) {
        this.ownsTexture = true;
        ObjectMap objectMap = new ObjectMap(this.emitters.size, 0.8f);
        int i = this.emitters.size;
        for (int i2 = 0; i2 < i; i2++) {
            ParticleEmitter particleEmitter = (ParticleEmitter) this.emitters.get(i2);
            if (particleEmitter.getImagePaths().size != 0) {
                Array array = new Array();
                ArrayIterator it = particleEmitter.getImagePaths().iterator();
                while (it.hasNext()) {
                    String name = new File(((String) it.next()).replace('\\', '/')).getName();
                    Sprite sprite = (Sprite) objectMap.get(name);
                    if (sprite == null) {
                        sprite = new Sprite(loadTexture(fileHandle.child(name)));
                        objectMap.put(name, sprite);
                    }
                    array.add(sprite);
                }
                particleEmitter.setSprites(array);
            }
        }
    }
}
