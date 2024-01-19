package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.Key;
import java.net.URL;
import java.security.MessageDigest;

public class GlideUrl implements Key {
    public volatile byte[] cacheKeyBytes;
    public int hashCode;
    public final Headers headers;
    public String safeStringUrl;
    public URL safeUrl;
    public final String stringUrl;
    public final URL url;

    public GlideUrl(URL url2) {
        Headers headers2 = Headers.DEFAULT;
        k.checkNotNull(url2, (String) "Argument must not be null");
        this.url = url2;
        this.stringUrl = null;
        k.checkNotNull(headers2, (String) "Argument must not be null");
        this.headers = headers2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GlideUrl)) {
            return false;
        }
        GlideUrl glideUrl = (GlideUrl) obj;
        if (!getCacheKey().equals(glideUrl.getCacheKey()) || !this.headers.equals(glideUrl.headers)) {
            return false;
        }
        return true;
    }

    public String getCacheKey() {
        String str = this.stringUrl;
        if (str != null) {
            return str;
        }
        URL url2 = this.url;
        k.checkNotNull(url2, (String) "Argument must not be null");
        return url2.toString();
    }

    public final String getSafeStringUrl() {
        if (TextUtils.isEmpty(this.safeStringUrl)) {
            String str = this.stringUrl;
            if (TextUtils.isEmpty(str)) {
                URL url2 = this.url;
                k.checkNotNull(url2, (String) "Argument must not be null");
                str = url2.toString();
            }
            this.safeStringUrl = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.safeStringUrl;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode2 = getCacheKey().hashCode();
            this.hashCode = hashCode2;
            this.hashCode = this.headers.hashCode() + (hashCode2 * 31);
        }
        return this.hashCode;
    }

    public String toString() {
        return getCacheKey();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        if (this.cacheKeyBytes == null) {
            this.cacheKeyBytes = getCacheKey().getBytes(Key.CHARSET);
        }
        messageDigest.update(this.cacheKeyBytes);
    }

    public GlideUrl(String str, Headers headers2) {
        this.url = null;
        if (!TextUtils.isEmpty(str)) {
            this.stringUrl = str;
            k.checkNotNull(headers2, (String) "Argument must not be null");
            this.headers = headers2;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
