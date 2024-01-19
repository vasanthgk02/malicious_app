package androidx.media;

public abstract class VolumeProviderCompat {

    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat volumeProviderCompat);
    }
}
