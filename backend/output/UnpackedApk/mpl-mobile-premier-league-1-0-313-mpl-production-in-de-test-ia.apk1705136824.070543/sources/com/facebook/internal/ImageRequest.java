package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.FacebookSdk;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u00192\u00020\u0001:\u0003\u0017\u0018\u0019B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0002\u0010\u000bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/facebook/internal/ImageRequest;", "", "context", "Landroid/content/Context;", "imageUri", "Landroid/net/Uri;", "callback", "Lcom/facebook/internal/ImageRequest$Callback;", "allowCachedRedirects", "", "callerTag", "(Landroid/content/Context;Landroid/net/Uri;Lcom/facebook/internal/ImageRequest$Callback;ZLjava/lang/Object;)V", "getAllowCachedRedirects", "()Z", "getCallback", "()Lcom/facebook/internal/ImageRequest$Callback;", "getCallerTag", "()Ljava/lang/Object;", "getContext", "()Landroid/content/Context;", "getImageUri", "()Landroid/net/Uri;", "isCachedRedirectAllowed", "Builder", "Callback", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ImageRequest.kt */
public final class ImageRequest {
    public final boolean allowCachedRedirects;
    public final Callback callback;
    public final Object callerTag;
    public final Context context;
    public final Uri imageUri;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/ImageRequest$Callback;", "", "onCompleted", "", "response", "Lcom/facebook/internal/ImageResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ImageRequest.kt */
    public interface Callback {
        void onCompleted(ImageResponse imageResponse);
    }

    public ImageRequest(Context context2, Uri uri, Callback callback2, boolean z, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this.context = context2;
        this.imageUri = uri;
        this.callback = callback2;
        this.allowCachedRedirects = z;
        this.callerTag = obj;
    }

    public static final Uri getProfilePictureUri(String str, int i, int i2, String str2) {
        Validate.notNullOrEmpty(str, "userId");
        int max = Math.max(i, 0);
        int max2 = Math.max(i2, 0);
        if ((max == 0 && max2 == 0) ? false : true) {
            Builder buildUpon = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon();
            Locale locale = Locale.US;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String format = String.format(locale, "%s/%s/picture", Arrays.copyOf(new Object[]{FacebookSdk.getGraphApiVersion(), str}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            Builder path = buildUpon.path(format);
            if (max2 != 0) {
                path.appendQueryParameter("height", String.valueOf(max2));
            }
            if (max != 0) {
                path.appendQueryParameter("width", String.valueOf(max));
            }
            path.appendQueryParameter("migration_overrides", "{october_2012:true}");
            if (!Utility.isNullOrEmpty(str2)) {
                path.appendQueryParameter("access_token", str2);
            } else {
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                if (!Utility.isNullOrEmpty(FacebookSdk.getClientToken())) {
                    FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                    if (!Utility.isNullOrEmpty(FacebookSdk.getApplicationId())) {
                        StringBuilder sb = new StringBuilder();
                        FacebookSdk facebookSdk4 = FacebookSdk.INSTANCE;
                        sb.append(FacebookSdk.getApplicationId());
                        sb.append('|');
                        FacebookSdk facebookSdk5 = FacebookSdk.INSTANCE;
                        sb.append(FacebookSdk.getClientToken());
                        path.appendQueryParameter("access_token", sb.toString());
                    }
                }
            }
            Uri build = path.build();
            Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
            return build;
        }
        throw new IllegalArgumentException("Either width or height must be greater than 0".toString());
    }
}
