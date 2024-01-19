package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

public class MediaSessionCompatApi23 {

    public interface Callback extends android.support.v4.media.session.MediaSessionCompatApi21.Callback {
        void onPlayFromUri(Uri uri, Bundle bundle);
    }

    public static class CallbackProxy<T extends Callback> extends android.support.v4.media.session.MediaSessionCompatApi21.CallbackProxy<T> {
        public CallbackProxy(T t) {
            super(t);
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((Callback) this.mCallback).onPlayFromUri(uri, bundle);
        }
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }
}
