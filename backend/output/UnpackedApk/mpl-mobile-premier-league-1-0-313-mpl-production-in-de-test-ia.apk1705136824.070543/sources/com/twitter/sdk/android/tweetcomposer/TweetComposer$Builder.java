package com.twitter.sdk.android.tweetcomposer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.material.resources.TextAppearanceConfig;
import java.util.Iterator;

public class TweetComposer$Builder {
    public final Context context;
    public Uri imageUri;
    public String text;

    public TweetComposer$Builder(Context context2) {
        if (context2 != null) {
            this.context = context2;
            return;
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    public void show() {
        Intent intent = new Intent("android.intent.action.SEND");
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.text)) {
            sb.append(this.text);
        }
        intent.putExtra("android.intent.extra.TEXT", sb.toString());
        intent.setType("text/plain");
        Uri uri = this.imageUri;
        if (uri != null) {
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.setType("image/jpeg");
        }
        Iterator<ResolveInfo> it = this.context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (true) {
            if (!it.hasNext()) {
                intent = null;
                break;
            }
            ResolveInfo next = it.next();
            if (next.activityInfo.packageName.startsWith("com.twitter.android")) {
                ActivityInfo activityInfo = next.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
                break;
            }
        }
        if (intent == null) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("https://twitter.com/intent/tweet?text=%s&url=%s", new Object[]{TextAppearanceConfig.urlEncode(this.text), TextAppearanceConfig.urlEncode("")})));
        }
        this.context.startActivity(intent);
    }
}
