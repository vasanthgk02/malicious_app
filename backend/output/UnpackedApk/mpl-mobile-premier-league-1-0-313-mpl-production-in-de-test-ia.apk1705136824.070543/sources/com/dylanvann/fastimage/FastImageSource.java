package com.dylanvann.fastimage;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.facebook.react.views.imagehelper.ImageSource;

public class FastImageSource extends ImageSource {
    public static final String ANDROID_CONTENT_SCHEME = "content";
    public static final String ANDROID_RESOURCE_SCHEME = "android.resource";
    public static final String DATA_SCHEME = "data";
    public static final String LOCAL_FILE_SCHEME = "file";
    public static final String LOCAL_RESOURCE_SCHEME = "res";
    public Headers mHeaders;
    public Uri mUri;

    public FastImageSource(Context context, String str) {
        this(context, str, null);
    }

    public static boolean isBase64Uri(Uri uri) {
        return "data".equals(uri.getScheme());
    }

    public static boolean isContentUri(Uri uri) {
        return "content".equals(uri.getScheme());
    }

    public static boolean isLocalFileUri(Uri uri) {
        return "file".equals(uri.getScheme());
    }

    public static boolean isLocalResourceUri(Uri uri) {
        return LOCAL_RESOURCE_SCHEME.equals(uri.getScheme());
    }

    public static boolean isResourceUri(Uri uri) {
        return ANDROID_RESOURCE_SCHEME.equals(uri.getScheme());
    }

    public GlideUrl getGlideUrl() {
        return new GlideUrl(getUri().toString(), getHeaders());
    }

    public Headers getHeaders() {
        return this.mHeaders;
    }

    public Object getSourceForLoad() {
        if (isContentUri()) {
            return getSource();
        }
        if (isBase64Resource()) {
            return getSource();
        }
        if (isResource()) {
            return getUri();
        }
        if (isLocalFile()) {
            return getUri().toString();
        }
        return getGlideUrl();
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isBase64Resource() {
        Uri uri = this.mUri;
        return uri != null && isBase64Uri(uri);
    }

    public boolean isLocalFile() {
        Uri uri = this.mUri;
        return uri != null && isLocalFileUri(uri);
    }

    public boolean isResource() {
        Uri uri = this.mUri;
        return uri != null && isResourceUri(uri);
    }

    public FastImageSource(Context context, String str, Headers headers) {
        this(context, str, 0.0d, 0.0d, headers);
    }

    public boolean isContentUri() {
        Uri uri = this.mUri;
        return uri != null && isContentUri(uri);
    }

    public FastImageSource(Context context, String str, double d2, double d3, Headers headers) {
        super(context, str, d2, d3);
        this.mHeaders = headers == null ? Headers.DEFAULT : headers;
        this.mUri = super.getUri();
        if (isResource() && TextUtils.isEmpty(this.mUri.toString())) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Local Resource Not Found. Resource: '");
            outline73.append(getSource());
            outline73.append("'.");
            throw new NotFoundException(outline73.toString());
        } else if (isLocalResourceUri(this.mUri)) {
            String uri = this.mUri.toString();
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("android.resource://");
            outline732.append(context.getPackageName());
            outline732.append("/");
            this.mUri = Uri.parse(uri.replace("res:/", outline732.toString()));
        }
    }
}
