package com.badlogic.gdx.graphics.g3d.particles.values;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.g3d.particles.values.PrimitiveSpawnShapeValue.SpawnSide;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public final class EllipseSpawnShapeValue extends PrimitiveSpawnShapeValue {
    public SpawnSide side = SpawnSide.both;

    public EllipseSpawnShapeValue(EllipseSpawnShapeValue ellipseSpawnShapeValue) {
        super(ellipseSpawnShapeValue);
        load(ellipseSpawnShapeValue);
    }

    public SpawnShapeValue copy() {
        return new EllipseSpawnShapeValue(this);
    }

    public SpawnSide getSide() {
        return this.side;
    }

    public void load(ParticleValue particleValue) {
        super.load(particleValue);
        this.side = ((EllipseSpawnShapeValue) particleValue).side;
    }

    public void read(Json json, JsonValue jsonValue) {
        super.read(json, jsonValue);
        this.side = (SpawnSide) json.readValue((String) "side", SpawnSide.class, jsonValue);
    }

    public void setSide(SpawnSide spawnSide) {
        this.side = spawnSide;
    }

    public void spawnAux(Vector3 vector3, float f2) {
        float f3;
        float f4;
        float f5;
        float f6;
        float outline5 = GeneratedOutlineSupport.outline5(this.spawnWidthValue, f2, this.spawnWidthDiff, this.spawnWidth);
        float outline52 = GeneratedOutlineSupport.outline5(this.spawnHeightValue, f2, this.spawnHeightDiff, this.spawnHeight);
        float outline53 = GeneratedOutlineSupport.outline5(this.spawnDepthValue, f2, this.spawnDepthDiff, this.spawnDepth);
        SpawnSide spawnSide = this.side;
        if (spawnSide == SpawnSide.top) {
            f3 = 3.1415927f;
        } else {
            f3 = spawnSide == SpawnSide.bottom ? -3.1415927f : 6.2831855f;
        }
        float random = MathUtils.random(0.0f, f3);
        if (!this.edges) {
            f6 = MathUtils.random(outline5 / 2.0f);
            f5 = MathUtils.random(outline52 / 2.0f);
            f4 = MathUtils.random(outline53 / 2.0f);
        } else if (outline5 == 0.0f) {
            vector3.set(0.0f, MathUtils.sin(random) * (outline52 / 2.0f), MathUtils.cos(random) * (outline53 / 2.0f));
            return;
        } else if (outline52 == 0.0f) {
            vector3.set(MathUtils.cos(random) * (outline5 / 2.0f), 0.0f, MathUtils.sin(random) * (outline53 / 2.0f));
            return;
        } else if (outline53 == 0.0f) {
            vector3.set(MathUtils.cos(random) * (outline5 / 2.0f), MathUtils.sin(random) * (outline52 / 2.0f), 0.0f);
            return;
        } else {
            f6 = outline5 / 2.0f;
            f5 = outline52 / 2.0f;
            f4 = outline53 / 2.0f;
        }
        float random2 = MathUtils.random(-1.0f, 1.0f);
        float sqrt = (float) Math.sqrt((double) (1.0f - (random2 * random2)));
        vector3.set(MathUtils.cos(random) * f6 * sqrt, MathUtils.sin(random) * f5 * sqrt, f4 * random2);
    }

    public void write(Json json) {
        super.write(json);
        json.writeValue("side", this.side);
    }

    public EllipseSpawnShapeValue() {
    }
}
