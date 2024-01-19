package com.facebook.imagepipeline.common;

import co.hyperverge.hypersnapsdk.c.k;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class RotationOptions {
    public static final int DISABLE_ROTATION = -2;
    public static final int NO_ROTATION = 0;
    public static final int ROTATE_180 = 180;
    public static final int ROTATE_270 = 270;
    public static final int ROTATE_90 = 90;
    public static final RotationOptions ROTATION_OPTIONS_AUTO_ROTATE = new RotationOptions(-1, false);
    public static final RotationOptions ROTATION_OPTIONS_DISABLE_ROTATION = new RotationOptions(-2, false);
    public static final RotationOptions ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME = new RotationOptions(-1, true);
    public static final int USE_EXIF_ROTATION_ANGLE = -1;
    public final boolean mDeferUntilRendered;
    public final int mRotation;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RotationAngle {
    }

    public RotationOptions(int i, boolean z) {
        this.mRotation = i;
        this.mDeferUntilRendered = z;
    }

    public static RotationOptions autoRotate() {
        return ROTATION_OPTIONS_AUTO_ROTATE;
    }

    public static RotationOptions autoRotateAtRenderTime() {
        return ROTATION_OPTIONS_ROTATE_AT_RENDER_TIME;
    }

    public static RotationOptions disableRotation() {
        return ROTATION_OPTIONS_DISABLE_ROTATION;
    }

    public static RotationOptions forceRotation(int i) {
        return new RotationOptions(i, false);
    }

    public boolean canDeferUntilRendered() {
        return this.mDeferUntilRendered;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RotationOptions)) {
            return false;
        }
        RotationOptions rotationOptions = (RotationOptions) obj;
        if (!(this.mRotation == rotationOptions.mRotation && this.mDeferUntilRendered == rotationOptions.mDeferUntilRendered)) {
            z = false;
        }
        return z;
    }

    public int getForcedAngle() {
        if (!useImageMetadata()) {
            return this.mRotation;
        }
        throw new IllegalStateException("Rotation is set to use EXIF");
    }

    public int hashCode() {
        int i;
        Integer valueOf = Integer.valueOf(this.mRotation);
        Boolean valueOf2 = Boolean.valueOf(this.mDeferUntilRendered);
        int i2 = 0;
        if (valueOf == null) {
            i = 0;
        } else {
            i = valueOf.hashCode();
        }
        if (valueOf2 != null) {
            i2 = valueOf2.hashCode();
        }
        return k.hashCode(i, i2);
    }

    public boolean rotationEnabled() {
        return this.mRotation != -2;
    }

    public String toString() {
        return String.format(null, "%d defer:%b", new Object[]{Integer.valueOf(this.mRotation), Boolean.valueOf(this.mDeferUntilRendered)});
    }

    public boolean useImageMetadata() {
        return this.mRotation == -1;
    }
}
