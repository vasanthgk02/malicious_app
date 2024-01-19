package com.freshchat.consumer.sdk.j;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest.TransformType;
import com.freshchat.consumer.sdk.b.c;
import com.mpl.androidapp.utils.Constant;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;
import java.io.IOException;

public class t implements FreshchatImageLoader {
    public final Picasso la;

    public t() {
        Picasso picasso;
        c cVar;
        try {
            picasso = Picasso.get();
        } catch (Exception unused) {
            cVar = c.PICASSO_INIT_ERROR;
            ai.e("FRESHCHAT", cVar.toString());
            picasso = null;
            this.la = picasso;
        } catch (NoSuchMethodError unused2) {
            cVar = c.PICASSO_NO_SUCH_METHOD_ERROR;
            ai.e("FRESHCHAT", cVar.toString());
            picasso = null;
            this.la = picasso;
        }
        this.la = picasso;
    }

    private void a(FreshchatImageLoaderRequest freshchatImageLoaderRequest, String str) {
        if (freshchatImageLoaderRequest == null) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("FreshchatImageLoaderRequest instance must not be null in ", str));
        }
    }

    public static t eL() {
        if (!ba.fZ()) {
            return new t();
        }
        ai.e("FRESHCHAT_WARNING", c.DEFAULT_IMAGE_LOADER_MISSING.toString());
        return null;
    }

    public void fetch(FreshchatImageLoaderRequest freshchatImageLoaderRequest) {
        a(freshchatImageLoaderRequest, "fetch");
        Picasso picasso = this.la;
        if (picasso == null) {
            ai.e("FRESHCHAT", c.PICASSO_INSTANCE_MISSING.toString());
        } else {
            picasso.load(freshchatImageLoaderRequest.getUri()).fetch();
        }
    }

    public Bitmap get(FreshchatImageLoaderRequest freshchatImageLoaderRequest) {
        a(freshchatImageLoaderRequest, Constant.GET);
        Picasso picasso = this.la;
        if (picasso == null) {
            ai.e("FRESHCHAT", c.PICASSO_INSTANCE_MISSING.toString());
            return null;
        }
        try {
            return picasso.load(freshchatImageLoaderRequest.getUri()).get();
        } catch (IOException e2) {
            q.a(e2);
            return null;
        }
    }

    public void load(FreshchatImageLoaderRequest freshchatImageLoaderRequest, ImageView imageView) {
        if (imageView != null) {
            a(freshchatImageLoaderRequest, "load");
            Picasso picasso = this.la;
            if (picasso == null) {
                ai.e("FRESHCHAT", c.PICASSO_INSTANCE_MISSING.toString());
                return;
            }
            RequestCreator load = picasso.load(freshchatImageLoaderRequest.getUri());
            if (!(freshchatImageLoaderRequest.getTargetHeight() == 0 && freshchatImageLoaderRequest.getTargetWidth() == 0)) {
                load.resize(freshchatImageLoaderRequest.getTargetWidth(), freshchatImageLoaderRequest.getTargetHeight());
                if (freshchatImageLoaderRequest.shouldMaintainAspectRatio()) {
                    load.centerInside();
                }
            }
            if (freshchatImageLoaderRequest.getTransformToApply() == TransformType.CIRCULAR) {
                load.transform((Transformation) new s());
            }
            int placeholderResId = freshchatImageLoaderRequest.getPlaceholderResId();
            if (placeholderResId > 0) {
                load.placeholder(placeholderResId);
            }
            int errorResId = freshchatImageLoaderRequest.getErrorResId();
            if (errorResId > 0) {
                load.error(errorResId);
            }
            load.into(imageView);
            return;
        }
        throw new IllegalArgumentException("Target must not be null.");
    }
}
