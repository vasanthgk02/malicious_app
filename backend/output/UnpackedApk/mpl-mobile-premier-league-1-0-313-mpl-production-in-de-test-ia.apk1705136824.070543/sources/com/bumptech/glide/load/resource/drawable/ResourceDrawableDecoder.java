package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.dylanvann.fastimage.FastImageSource;
import java.io.IOException;
import java.util.List;

public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {
    public final Context context;

    public ResourceDrawableDecoder(Context context2) {
        this.context = context2.getApplicationContext();
    }

    public /* bridge */ /* synthetic */ Resource decode(Object obj, int i, int i2, Options options) throws IOException {
        return decode((Uri) obj);
    }

    public boolean handles(Object obj, Options options) throws IOException {
        return ((Uri) obj).getScheme().equals(FastImageSource.ANDROID_RESOURCE_SCHEME);
    }

    public Resource decode(Uri uri) {
        Context context2;
        int i;
        String authority = uri.getAuthority();
        if (authority.equals(this.context.getPackageName())) {
            context2 = this.context;
        } else {
            try {
                context2 = this.context.createPackageContext(authority, 0);
            } catch (NameNotFoundException e2) {
                if (authority.contains(this.context.getPackageName())) {
                    context2 = this.context;
                } else {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline46("Failed to obtain context or unrecognized Uri format for: ", uri), e2);
                }
            }
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            List<String> pathSegments2 = uri.getPathSegments();
            String authority2 = uri.getAuthority();
            String str = pathSegments2.get(0);
            String str2 = pathSegments2.get(1);
            i = context2.getResources().getIdentifier(str2, str, authority2);
            if (i == 0) {
                i = Resources.getSystem().getIdentifier(str2, str, "android");
            }
            if (i == 0) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline46("Failed to find resource id for: ", uri));
            }
        } else if (pathSegments.size() == 1) {
            try {
                i = Integer.parseInt(uri.getPathSegments().get(0));
            } catch (NumberFormatException e3) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline46("Unrecognized Uri format: ", uri), e3);
            }
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline46("Unrecognized Uri format: ", uri));
        }
        Drawable drawable = DrawableDecoderCompat.getDrawable(this.context, context2, i, null);
        if (drawable != null) {
            return new NonOwnedDrawableResource(drawable);
        }
        return null;
    }
}
