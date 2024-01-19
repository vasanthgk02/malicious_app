package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser.MediaItem;
import android.service.media.MediaBrowserService.Result;

public class MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor {
    public MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor(Context context, MediaBrowserServiceCompatApi23$ServiceCompatProxy mediaBrowserServiceCompatApi23$ServiceCompatProxy) {
        super(context, mediaBrowserServiceCompatApi23$ServiceCompatProxy);
    }

    public void onLoadItem(String str, Result<MediaItem> result) {
        ((MediaBrowserServiceCompatApi23$ServiceCompatProxy) this.mServiceProxy).onLoadItem(str, new MediaBrowserServiceCompatApi21$ResultWrapper(result));
    }
}
