package com.twitter.sdk.android.tweetui;

import android.app.Activity;
import android.os.Bundle;
import com.inca.security.Proxy.iIiIiIiIii;
import com.twitter.sdk.android.core.models.MediaEntity;
import java.io.Serializable;
import java.util.List;

public class GalleryActivity extends Activity {
    public GalleryItem galleryItem;

    public static class GalleryItem implements Serializable {
        public final List<MediaEntity> mediaEntities;
        public final int mediaEntityIndex;

        public GalleryItem(int i, List<MediaEntity> list) {
            this.mediaEntityIndex = i;
            this.mediaEntities = list;
        }

        public GalleryItem(long j, int i, List<MediaEntity> list) {
            this.mediaEntityIndex = i;
            this.mediaEntities = list;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R$anim.tw__slide_out);
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -1069844359, bundle);
    }
}
