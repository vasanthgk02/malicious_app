package com.google.android.gms.common.images;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class Size {
    public final int zaa;
    public final int zab;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return size.zaa == 0 && size.zab == 0;
        }
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "0x0";
    }
}
