package com.mpl.androidapp.miniprofile.extensions;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a>\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\nH\u0007\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0007\u001a\"\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f¨\u0006\u0013"}, d2 = {"customRequestParam", "", "Landroid/widget/ImageView;", "url", "", "requestOptions", "Lcom/bumptech/glide/request/RequestOptions;", "load", "previousUrl", "round", "", "cornersRadius", "", "crop", "loadDrawable", "drawable", "loadImageUrl", "placeHolderDrawable", "errorDrawable", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageViewExt.kt */
public final class ImageViewExtKt {
    public static final void customRequestParam(ImageView imageView, String str, RequestOptions requestOptions) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(requestOptions, "requestOptions");
        ((RequestBuilder) Glide.with(imageView.getContext()).load(str).apply((BaseRequestOptions<?>) requestOptions).circleCrop()).into(imageView);
    }

    @SuppressLint({"CheckResult"})
    public static final void load(ImageView imageView, String str, String str2, boolean z, int i, boolean z2) {
        RequestOptions requestOptions;
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, "url");
        if (z) {
            requestOptions = RequestOptions.circleCropTransform();
        } else if (i > 0) {
            RequestOptions requestOptions2 = new RequestOptions();
            Transformation[] transformationArr = new Transformation[2];
            transformationArr[0] = z2 ? new CenterCrop() : new FitCenter();
            transformationArr[1] = new RoundedCorners(i);
            requestOptions = (RequestOptions) requestOptions2.transforms(transformationArr);
        } else {
            requestOptions = null;
        }
        RequestBuilder<Drawable> load = Glide.with(imageView.getContext()).load(str);
        if (requestOptions != null) {
            load = load.apply((BaseRequestOptions<?>) requestOptions);
        }
        if (str2 != null) {
            RequestBuilder<Drawable> load2 = Glide.with(imageView.getContext()).load(str2);
            if (requestOptions != null) {
                load2 = load2.apply((BaseRequestOptions<?>) requestOptions);
            }
            load = load.thumbnail(load2);
        }
        load.into(imageView);
    }

    public static /* synthetic */ void load$default(ImageView imageView, String str, String str2, boolean z, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        load(imageView, str, str2, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z2);
    }

    @SuppressLint({"CheckResult"})
    public static final void loadDrawable(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Glide.with(imageView.getContext()).load(Integer.valueOf(i)).into(imageView);
    }

    public static final void loadImageUrl(ImageView imageView, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(str, "url");
        Glide.with(imageView.getContext()).load(str).apply(((RequestOptions) new RequestOptions().placeholder(i)).error(i2)).into(imageView);
    }
}
