package com.badlogic.gdx.graphics.g3d.particles;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.Configurable;
import com.badlogic.gdx.graphics.g3d.particles.emitters.Emitter;
import com.badlogic.gdx.graphics.g3d.particles.influencers.Influencer;
import com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;

public class ParticleController implements Serializable, Configurable {
    public static final float DEFAULT_TIME_STEP = 0.016666668f;
    public BoundingBox boundingBox;
    public float deltaTime;
    public float deltaTimeSqr;
    public Emitter emitter;
    public Array<Influencer> influencers;
    public String name;
    public ParticleChannels particleChannels;
    public ParallelArray particles;
    public ParticleControllerRenderer<?, ?> renderer;
    public Vector3 scale;
    public Matrix4 transform;

    public ParticleController() {
        this.transform = new Matrix4();
        this.scale = new Vector3(1.0f, 1.0f, 1.0f);
        this.influencers = new Array<>(true, 3, Influencer.class);
        setTimeStep(0.016666668f);
    }

    private <K extends Influencer> int findIndex(Class<K> cls) {
        int i = 0;
        while (true) {
            Array<Influencer> array = this.influencers;
            if (i >= array.size) {
                return -1;
            }
            if (cls.isAssignableFrom(((Influencer) array.get(i)).getClass())) {
                return i;
            }
            i++;
        }
    }

    private void setTimeStep(float f2) {
        this.deltaTime = f2;
        this.deltaTimeSqr = f2 * f2;
    }

    public void activateParticles(int i, int i2) {
        this.emitter.activateParticles(i, i2);
        ArrayIterator it = this.influencers.iterator();
        while (it.hasNext()) {
            ((Influencer) it.next()).activateParticles(i, i2);
        }
    }

    public void allocateChannels(int i) {
        this.particles = new ParallelArray(i);
        this.emitter.allocateChannels();
        ArrayIterator it = this.influencers.iterator();
        while (it.hasNext()) {
            ((Influencer) it.next()).allocateChannels();
        }
        this.renderer.allocateChannels();
    }

    public void bind() {
        this.emitter.set(this);
        ArrayIterator it = this.influencers.iterator();
        while (it.hasNext()) {
            ((Influencer) it.next()).set(this);
        }
        this.renderer.set(this);
    }

    public void calculateBoundingBox() {
        BoundingBox boundingBox2 = this.boundingBox;
        Vector3 vector3 = boundingBox2.min;
        vector3.set(0.0f, 0.0f, 0.0f);
        Vector3 vector32 = boundingBox2.max;
        vector32.set(0.0f, 0.0f, 0.0f);
        boundingBox2.set(vector3, vector32);
        FloatChannel floatChannel = (FloatChannel) this.particles.getChannel(ParticleChannels.Position);
        int i = floatChannel.strideSize * this.particles.size;
        for (int i2 = 0; i2 < i; i2 += floatChannel.strideSize) {
            BoundingBox boundingBox3 = this.boundingBox;
            float[] fArr = floatChannel.data;
            boundingBox3.ext(fArr[i2 + 0], fArr[i2 + 1], fArr[i2 + 2]);
        }
    }

    public ParticleController copy() {
        Emitter emitter2 = (Emitter) this.emitter.copy();
        Array<Influencer> array = this.influencers;
        Influencer[] influencerArr = new Influencer[array.size];
        ArrayIterator it = array.iterator();
        int i = 0;
        while (it.hasNext()) {
            influencerArr[i] = (Influencer) ((Influencer) it.next()).copy();
            i++;
        }
        return new ParticleController(new String(this.name), emitter2, (ParticleControllerRenderer) this.renderer.copy(), influencerArr);
    }

    public void dispose() {
        this.emitter.dispose();
        ArrayIterator it = this.influencers.iterator();
        while (it.hasNext()) {
            ((Influencer) it.next()).dispose();
        }
    }

    public void draw() {
        if (this.particles.size > 0) {
            this.renderer.update();
        }
    }

    public void end() {
        ArrayIterator it = this.influencers.iterator();
        while (it.hasNext()) {
            ((Influencer) it.next()).end();
        }
        this.emitter.end();
    }

    public <K extends Influencer> K findInfluencer(Class<K> cls) {
        int findIndex = findIndex(cls);
        if (findIndex > -1) {
            return (Influencer) this.influencers.get(findIndex);
        }
        return null;
    }

    public BoundingBox getBoundingBox() {
        if (this.boundingBox == null) {
            this.boundingBox = new BoundingBox();
        }
        calculateBoundingBox();
        return this.boundingBox;
    }

    public void getTransform(Matrix4 matrix4) {
        matrix4.set(this.transform);
    }

    public void init() {
        bind();
        if (this.particles != null) {
            end();
            this.particleChannels.resetIds();
        }
        allocateChannels(this.emitter.maxParticleCount);
        this.emitter.init();
        ArrayIterator it = this.influencers.iterator();
        while (it.hasNext()) {
            ((Influencer) it.next()).init();
        }
        this.renderer.init();
    }

    public boolean isComplete() {
        return this.emitter.isComplete();
    }

    public void killParticles(int i, int i2) {
        this.emitter.killParticles(i, i2);
        ArrayIterator it = this.influencers.iterator();
        while (it.hasNext()) {
            ((Influencer) it.next()).killParticles(i, i2);
        }
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
        this.emitter.load(assetManager, resourceData);
        ArrayIterator it = this.influencers.iterator();
        while (it.hasNext()) {
            ((Influencer) it.next()).load(assetManager, resourceData);
        }
        this.renderer.load(assetManager, resourceData);
    }

    public void mul(Matrix4 matrix4) {
        Matrix4.mul(this.transform.val, matrix4.val);
        this.transform.getScale(this.scale);
    }

    public void read(Json json, JsonValue jsonValue) {
        this.name = (String) json.readValue((String) "name", String.class, jsonValue);
        this.emitter = (Emitter) json.readValue((String) "emitter", Emitter.class, jsonValue);
        this.influencers.addAll((Array) json.readValue("influencers", Array.class, Influencer.class, jsonValue));
        this.renderer = (ParticleControllerRenderer) json.readValue((String) "renderer", ParticleControllerRenderer.class, jsonValue);
    }

    public <K extends Influencer> void removeInfluencer(Class<K> cls) {
        int findIndex = findIndex(cls);
        if (findIndex > -1) {
            this.influencers.removeIndex(findIndex);
        }
    }

    public <K extends Influencer> boolean replaceInfluencer(Class<K> cls, K k) {
        int findIndex = findIndex(cls);
        if (findIndex <= -1) {
            return false;
        }
        this.influencers.insert(findIndex, k);
        this.influencers.removeIndex(findIndex + 1);
        return true;
    }

    public void reset() {
        end();
        start();
    }

    public void rotate(Quaternion quaternion) {
        this.transform.rotate(quaternion);
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
        this.emitter.save(assetManager, resourceData);
        ArrayIterator it = this.influencers.iterator();
        while (it.hasNext()) {
            ((Influencer) it.next()).save(assetManager, resourceData);
        }
        this.renderer.save(assetManager, resourceData);
    }

    public void scale(float f2, float f3, float f4) {
        this.transform.scale(f2, f3, f4);
        this.transform.getScale(this.scale);
    }

    public void setTransform(Matrix4 matrix4) {
        this.transform.set(matrix4);
        matrix4.getScale(this.scale);
    }

    public void setTranslation(Vector3 vector3) {
        this.transform.setTranslation(vector3);
    }

    public void start() {
        this.emitter.start();
        ArrayIterator it = this.influencers.iterator();
        while (it.hasNext()) {
            ((Influencer) it.next()).start();
        }
    }

    public void translate(Vector3 vector3) {
        Matrix4 matrix4 = this.transform;
        if (matrix4 != null) {
            matrix4.translate(vector3.x, vector3.y, vector3.z);
            return;
        }
        throw null;
    }

    public void update() {
        update(((AndroidGraphics) k.graphics).deltaTime);
    }

    public void write(Json json) {
        json.writeValue("name", this.name);
        json.writeValue((String) "emitter", (Object) this.emitter, Emitter.class);
        json.writeValue("influencers", this.influencers, Array.class, Influencer.class);
        json.writeValue((String) "renderer", (Object) this.renderer, ParticleControllerRenderer.class);
    }

    public void rotate(Vector3 vector3, float f2) {
        Matrix4 matrix4 = this.transform;
        if (matrix4 == null) {
            throw null;
        } else if (f2 != 0.0f) {
            Quaternion quaternion = Matrix4.quat;
            if (quaternion != null) {
                quaternion.setFromAxis(vector3.x, vector3.y, vector3.z, f2);
                matrix4.rotate(Matrix4.quat);
                return;
            }
            throw null;
        }
    }

    public void scale(Vector3 vector3) {
        scale(vector3.x, vector3.y, vector3.z);
    }

    public void setTransform(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f9;
        this.transform.set(f2, f3, f4, f5, f6, f7, f8, f9, f9, f9);
        Vector3 vector3 = this.scale;
        vector3.x = f10;
        vector3.y = f10;
        vector3.z = f10;
    }

    public void update(float f2) {
        setTimeStep(f2);
        this.emitter.update();
        ArrayIterator it = this.influencers.iterator();
        while (it.hasNext()) {
            ((Influencer) it.next()).update();
        }
    }

    public ParticleController(String str, Emitter emitter2, ParticleControllerRenderer<?, ?> particleControllerRenderer, Influencer... influencerArr) {
        this();
        this.name = str;
        this.emitter = emitter2;
        this.renderer = particleControllerRenderer;
        this.particleChannels = new ParticleChannels();
        this.influencers = new Array<>((T[]) influencerArr);
    }
}
