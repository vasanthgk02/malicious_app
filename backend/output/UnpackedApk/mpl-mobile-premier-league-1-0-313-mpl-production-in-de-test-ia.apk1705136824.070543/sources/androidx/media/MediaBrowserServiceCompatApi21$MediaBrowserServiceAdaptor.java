package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.service.media.MediaBrowserService.BrowserRoot;
import android.service.media.MediaBrowserService.Result;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

public class MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor extends MediaBrowserService {
    public final MediaBrowserServiceCompatApi21$ServiceCompatProxy mServiceProxy;

    public MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor(Context context, MediaBrowserServiceCompatApi21$ServiceCompatProxy mediaBrowserServiceCompatApi21$ServiceCompatProxy) {
        attachBaseContext(context);
        this.mServiceProxy = mediaBrowserServiceCompatApi21$ServiceCompatProxy;
    }

    public BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader(bundle);
        MediaBrowserServiceCompatApi21$BrowserRoot onGetRoot = this.mServiceProxy.onGetRoot(str, i, bundle == null ? null : new Bundle(bundle));
        if (onGetRoot == null) {
            return null;
        }
        return new BrowserRoot(onGetRoot.mRootId, onGetRoot.mExtras);
    }

    public void onLoadChildren(String str, Result<List<MediaItem>> result) {
        this.mServiceProxy.onLoadChildren(str, new MediaBrowserServiceCompatApi21$ResultWrapper(result));
    }
}
