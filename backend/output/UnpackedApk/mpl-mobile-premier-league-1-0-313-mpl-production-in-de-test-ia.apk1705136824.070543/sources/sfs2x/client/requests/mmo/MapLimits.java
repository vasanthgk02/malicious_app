package sfs2x.client.requests.mmo;

import sfs2x.client.entities.data.Vec3D;

public final class MapLimits {
    public Vec3D higherLimit;
    public Vec3D lowerLimit;

    public MapLimits(Vec3D vec3D, Vec3D vec3D2) {
        if (vec3D == null || vec3D2 == null) {
            throw new IllegalArgumentException("Map Limits arguments must be both non null!");
        }
        this.lowerLimit = vec3D;
        this.higherLimit = vec3D2;
    }

    public Vec3D getHigherLimit() {
        return this.higherLimit;
    }

    public Vec3D getLowerLimit() {
        return this.lowerLimit;
    }
}
