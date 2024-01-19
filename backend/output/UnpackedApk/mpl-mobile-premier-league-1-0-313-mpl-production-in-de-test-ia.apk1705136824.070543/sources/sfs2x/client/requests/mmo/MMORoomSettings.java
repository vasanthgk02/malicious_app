package sfs2x.client.requests.mmo;

import sfs2x.client.entities.data.Vec3D;
import sfs2x.client.requests.RoomSettings;

public class MMORoomSettings extends RoomSettings {
    public Vec3D defaultAOI;
    public MapLimits mapLimits;
    public int proximityListUpdateMillis = 250;
    public boolean sendAOIEntryPoint = true;
    public int userMaxLimboSeconds = 50;

    public MMORoomSettings(String str) {
        super(str);
    }

    public Vec3D getDefaultAOI() {
        return this.defaultAOI;
    }

    public MapLimits getMapLimits() {
        return this.mapLimits;
    }

    public int getProximityListUpdateMillis() {
        return this.proximityListUpdateMillis;
    }

    public int getUserMaxLimboSeconds() {
        return this.userMaxLimboSeconds;
    }

    public boolean isSendAOIEntryPoint() {
        return this.sendAOIEntryPoint;
    }

    public void setDefaultAOI(Vec3D vec3D) {
        this.defaultAOI = vec3D;
    }

    public void setMapLimits(MapLimits mapLimits2) {
        this.mapLimits = mapLimits2;
    }

    public void setProximityListUpdateMillis(int i) {
        this.proximityListUpdateMillis = i;
    }

    public void setSendAOIEntryPoint(boolean z) {
        this.sendAOIEntryPoint = z;
    }

    public void setUserMaxLimboSeconds(int i) {
        this.userMaxLimboSeconds = i;
    }
}
