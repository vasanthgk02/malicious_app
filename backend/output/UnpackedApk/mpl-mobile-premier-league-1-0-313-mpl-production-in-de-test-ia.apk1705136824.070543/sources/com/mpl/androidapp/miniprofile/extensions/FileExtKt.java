package com.mpl.androidapp.miniprofile.extensions;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0006\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\n\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"uri", "Landroid/net/Uri;", "Ljava/io/File;", "getUri", "(Ljava/io/File;)Landroid/net/Uri;", "asUri", "", "getMediaDuration", "", "context", "Landroid/content/Context;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileExt.kt */
public final class FileExtKt {
    public static final Uri asUri(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final long getMediaDuration(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        long j = 0;
        if (!file.exists()) {
            return 0;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(context, Uri.parse(file.getAbsolutePath()));
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        mediaMetadataRetriever.release();
        Intrinsics.checkNotNullExpressionValue(extractMetadata, InlineAnimation.DURATION);
        Long longOrNull = CharsKt__CharKt.toLongOrNull(extractMetadata);
        if (longOrNull != null) {
            j = longOrNull.longValue();
        }
        return j;
    }

    public static final Uri getUri(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return asUri(file.getAbsolutePath());
    }
}
