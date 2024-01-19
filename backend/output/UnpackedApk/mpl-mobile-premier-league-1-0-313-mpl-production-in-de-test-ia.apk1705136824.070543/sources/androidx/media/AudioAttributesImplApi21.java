package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import com.android.tools.r8.GeneratedOutlineSupport;

@TargetApi(21)
public class AudioAttributesImplApi21 implements AudioAttributesImpl {
    public AudioAttributes mAudioAttributes;
    public int mLegacyStreamType = -1;

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.mAudioAttributes.equals(((AudioAttributesImplApi21) obj).mAudioAttributes);
    }

    public int hashCode() {
        return this.mAudioAttributes.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AudioAttributesCompat: audioattributes=");
        outline73.append(this.mAudioAttributes);
        return outline73.toString();
    }
}
