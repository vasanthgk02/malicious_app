package com.badlogic.gdx.graphics.g3d.particles.influencers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.ParallelArray.FloatChannel;
import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData.SaveData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public abstract class RegionInfluencer extends Influencer {
    public static final String ASSET_DATA = "atlasAssetData";
    public String atlasName;
    public FloatChannel regionChannel;
    public Array<AspectTextureRegion> regions;

    public static class Animated extends RegionInfluencer {
        public FloatChannel lifeChannel;

        public Animated() {
        }

        public void allocateChannels() {
            RegionInfluencer.super.allocateChannels();
            this.lifeChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.Life);
        }

        public void update() {
            int i = this.controller.particles.size * this.regionChannel.strideSize;
            int i2 = 2;
            int i3 = 0;
            while (i3 < i) {
                Array<AspectTextureRegion> array = this.regions;
                AspectTextureRegion aspectTextureRegion = (AspectTextureRegion) array.get((int) (this.lifeChannel.data[i2] * ((float) (array.size - 1))));
                FloatChannel floatChannel = this.regionChannel;
                float[] fArr = floatChannel.data;
                fArr[i3 + 0] = aspectTextureRegion.u;
                fArr[i3 + 1] = aspectTextureRegion.v;
                fArr[i3 + 2] = aspectTextureRegion.u2;
                fArr[i3 + 3] = aspectTextureRegion.v2;
                fArr[i3 + 4] = 0.5f;
                fArr[i3 + 5] = aspectTextureRegion.halfInvAspectRatio;
                i3 += floatChannel.strideSize;
                i2 += this.lifeChannel.strideSize;
            }
        }

        public Animated(Animated animated) {
            super((RegionInfluencer) animated);
        }

        public Animated copy() {
            return new Animated(this);
        }

        public Animated(TextureRegion textureRegion) {
            super(textureRegion);
        }

        public Animated(Texture texture) {
            super(texture);
        }
    }

    public static class AspectTextureRegion {
        public float halfInvAspectRatio;
        public String imageName;
        public float u;
        public float u2;
        public float v;
        public float v2;

        public AspectTextureRegion() {
        }

        public void set(TextureRegion textureRegion) {
            this.u = textureRegion.getU();
            this.v = textureRegion.getV();
            this.u2 = textureRegion.getU2();
            this.v2 = textureRegion.getV2();
            this.halfInvAspectRatio = (((float) textureRegion.getRegionHeight()) / ((float) textureRegion.getRegionWidth())) * 0.5f;
            if (textureRegion instanceof AtlasRegion) {
                this.imageName = ((AtlasRegion) textureRegion).name;
            }
        }

        public void updateUV(TextureAtlas textureAtlas) {
            String str = this.imageName;
            if (str != null) {
                AtlasRegion findRegion = textureAtlas.findRegion(str);
                this.u = findRegion.getU();
                this.v = findRegion.getV();
                this.u2 = findRegion.getU2();
                this.v2 = findRegion.getV2();
                this.halfInvAspectRatio = (((float) findRegion.getRegionHeight()) / ((float) findRegion.getRegionWidth())) * 0.5f;
            }
        }

        public AspectTextureRegion(AspectTextureRegion aspectTextureRegion) {
            set(aspectTextureRegion);
        }

        public AspectTextureRegion(TextureRegion textureRegion) {
            set(textureRegion);
        }

        public void set(AspectTextureRegion aspectTextureRegion) {
            this.u = aspectTextureRegion.u;
            this.v = aspectTextureRegion.v;
            this.u2 = aspectTextureRegion.u2;
            this.v2 = aspectTextureRegion.v2;
            this.halfInvAspectRatio = aspectTextureRegion.halfInvAspectRatio;
            this.imageName = aspectTextureRegion.imageName;
        }
    }

    public static class Random extends RegionInfluencer {
        public Random() {
        }

        public void activateParticles(int i, int i2) {
            int i3 = this.regionChannel.strideSize;
            int i4 = i * i3;
            int i5 = (i2 * i3) + i4;
            while (i4 < i5) {
                AspectTextureRegion aspectTextureRegion = (AspectTextureRegion) this.regions.random();
                FloatChannel floatChannel = this.regionChannel;
                float[] fArr = floatChannel.data;
                fArr[i4 + 0] = aspectTextureRegion.u;
                fArr[i4 + 1] = aspectTextureRegion.v;
                fArr[i4 + 2] = aspectTextureRegion.u2;
                fArr[i4 + 3] = aspectTextureRegion.v2;
                fArr[i4 + 4] = 0.5f;
                fArr[i4 + 5] = aspectTextureRegion.halfInvAspectRatio;
                i4 += floatChannel.strideSize;
            }
        }

        public Random(Random random) {
            super((RegionInfluencer) random);
        }

        public Random copy() {
            return new Random(this);
        }

        public Random(TextureRegion textureRegion) {
            super(textureRegion);
        }

        public Random(Texture texture) {
            super(texture);
        }
    }

    public static class Single extends RegionInfluencer {
        public Single() {
        }

        public void init() {
            int i = 0;
            AspectTextureRegion aspectTextureRegion = ((AspectTextureRegion[]) this.regions.items)[0];
            int i2 = this.controller.emitter.maxParticleCount * this.regionChannel.strideSize;
            while (i < i2) {
                FloatChannel floatChannel = this.regionChannel;
                float[] fArr = floatChannel.data;
                fArr[i + 0] = aspectTextureRegion.u;
                fArr[i + 1] = aspectTextureRegion.v;
                fArr[i + 2] = aspectTextureRegion.u2;
                fArr[i + 3] = aspectTextureRegion.v2;
                fArr[i + 4] = 0.5f;
                fArr[i + 5] = aspectTextureRegion.halfInvAspectRatio;
                i += floatChannel.strideSize;
            }
        }

        public Single(Single single) {
            super((RegionInfluencer) single);
        }

        public Single copy() {
            return new Single(this);
        }

        public Single(TextureRegion textureRegion) {
            super(textureRegion);
        }

        public Single(Texture texture) {
            super(texture);
        }
    }

    public RegionInfluencer(int i) {
        this.regions = new Array<>(false, i, AspectTextureRegion.class);
    }

    public void add(TextureRegion... textureRegionArr) {
        this.regions.ensureCapacity(textureRegionArr.length);
        for (TextureRegion aspectTextureRegion : textureRegionArr) {
            this.regions.add(new AspectTextureRegion(aspectTextureRegion));
        }
    }

    public void allocateChannels() {
        this.regionChannel = (FloatChannel) this.controller.particles.addChannel(ParticleChannels.TextureRegion);
    }

    public void clear() {
        this.atlasName = null;
        this.regions.clear();
    }

    public void load(AssetManager assetManager, ResourceData resourceData) {
        super.load(assetManager, resourceData);
        SaveData saveData = resourceData.getSaveData(ASSET_DATA);
        if (saveData != null) {
            saveData.loadAsset();
            throw null;
        }
    }

    public void read(Json json, JsonValue jsonValue) {
        this.regions.clear();
        this.regions.addAll((Array) json.readValue("regions", Array.class, AspectTextureRegion.class, jsonValue));
    }

    public void save(AssetManager assetManager, ResourceData resourceData) {
        super.save(assetManager, resourceData);
        if (this.atlasName != null) {
            SaveData saveData = resourceData.getSaveData(ASSET_DATA);
            if (saveData == null) {
                saveData = resourceData.createSaveData(ASSET_DATA);
            }
            saveData.saveAsset(this.atlasName, TextureAtlas.class);
        }
    }

    public void setAtlasName(String str) {
        this.atlasName = str;
    }

    public void write(Json json) {
        json.writeValue("regions", this.regions, Array.class, AspectTextureRegion.class);
    }

    public RegionInfluencer() {
        this(1);
        AspectTextureRegion aspectTextureRegion = new AspectTextureRegion();
        aspectTextureRegion.v = 0.0f;
        aspectTextureRegion.u = 0.0f;
        aspectTextureRegion.v2 = 1.0f;
        aspectTextureRegion.u2 = 1.0f;
        aspectTextureRegion.halfInvAspectRatio = 0.5f;
        this.regions.add(aspectTextureRegion);
    }

    public RegionInfluencer(TextureRegion... textureRegionArr) {
        setAtlasName(null);
        this.regions = new Array<>(false, textureRegionArr.length, AspectTextureRegion.class);
        add(textureRegionArr);
    }

    public RegionInfluencer(Texture texture) {
        this(new TextureRegion(texture));
    }

    public RegionInfluencer(RegionInfluencer regionInfluencer) {
        this(regionInfluencer.regions.size);
        this.regions.ensureCapacity(regionInfluencer.regions.size);
        int i = 0;
        while (true) {
            Array<AspectTextureRegion> array = regionInfluencer.regions;
            if (i < array.size) {
                this.regions.add(new AspectTextureRegion((AspectTextureRegion) array.get(i)));
                i++;
            } else {
                return;
            }
        }
    }
}
