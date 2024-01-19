package com.google.android.gms.common.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import com.dylanvann.fastimage.FastImageSource;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class ResourceUtils {
    public static final Uri zza = new Builder().scheme(FastImageSource.ANDROID_RESOURCE_SCHEME).authority("com.google.android.gms").appendPath("drawable").build();
}
