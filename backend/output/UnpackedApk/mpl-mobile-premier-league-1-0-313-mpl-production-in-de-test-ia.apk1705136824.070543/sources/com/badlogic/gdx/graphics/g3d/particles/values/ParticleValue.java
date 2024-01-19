package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.facebook.react.modules.appstate.AppStateModule;

public class ParticleValue implements Serializable {
    public boolean active;

    public ParticleValue() {
    }

    public boolean isActive() {
        return this.active;
    }

    public void load(ParticleValue particleValue) {
        this.active = particleValue.active;
    }

    public void read(Json json, JsonValue jsonValue) {
        this.active = ((Boolean) json.readValue((String) AppStateModule.APP_STATE_ACTIVE, Boolean.class, jsonValue)).booleanValue();
    }

    public void setActive(boolean z) {
        this.active = z;
    }

    public void write(Json json) {
        json.writeValue(AppStateModule.APP_STATE_ACTIVE, Boolean.valueOf(this.active));
    }

    public ParticleValue(ParticleValue particleValue) {
        this.active = particleValue.active;
    }
}
