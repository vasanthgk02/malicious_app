package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        Object obj = audioAttributesCompat.mImpl;
        if (versionedParcel.readField(1)) {
            obj = versionedParcel.readVersionedParcelable();
        }
        audioAttributesCompat.mImpl = (AudioAttributesImpl) obj;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        if (versionedParcel != null) {
            AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.mImpl;
            versionedParcel.setOutputField(1);
            versionedParcel.writeVersionedParcelable(audioAttributesImpl);
            return;
        }
        throw null;
    }
}
