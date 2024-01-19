package com.freshchat.consumer.sdk;

import android.net.Uri;
import com.freshchat.consumer.sdk.j.as;

public class FreshchatImageLoaderRequest {
    public int errorResId;
    public boolean maintainAspectRatio;
    public int placeholderResId;
    public int targetHeight;
    public int targetWidth;
    public TransformType transformToApply;
    public final Uri uri;

    public enum TransformType {
        CIRCULAR
    }

    public static class a {
        public int errorResId;
        public boolean maintainAspectRatio;
        public int placeholderResId;
        public int targetHeight;
        public int targetWidth;
        public TransformType transformToApply;
        public final Uri uri;

        public a(String str) {
            String aH = as.aH(str);
            if (!as.isEmpty(aH)) {
                this.uri = Uri.parse(aH);
                return;
            }
            throw new IllegalArgumentException("Path must not be empty.");
        }

        public a G(int i) {
            this.placeholderResId = i;
            return this;
        }

        public a H(int i) {
            this.errorResId = i;
            return this;
        }

        public a a(int i, int i2) {
            return a(i, i2, true);
        }

        public a a(int i, int i2, boolean z) {
            this.targetWidth = i;
            this.targetHeight = i2;
            this.maintainAspectRatio = z;
            return this;
        }

        public a a(TransformType transformType) {
            this.transformToApply = transformType;
            return this;
        }

        public FreshchatImageLoaderRequest dM() {
            FreshchatImageLoaderRequest freshchatImageLoaderRequest = new FreshchatImageLoaderRequest(this.uri);
            freshchatImageLoaderRequest.placeholderResId = this.placeholderResId;
            freshchatImageLoaderRequest.errorResId = this.errorResId;
            freshchatImageLoaderRequest.transformToApply = this.transformToApply;
            freshchatImageLoaderRequest.maintainAspectRatio = this.maintainAspectRatio;
            freshchatImageLoaderRequest.targetWidth = this.targetWidth;
            freshchatImageLoaderRequest.targetHeight = this.targetHeight;
            return freshchatImageLoaderRequest;
        }
    }

    public FreshchatImageLoaderRequest(Uri uri2) {
        this.uri = uri2;
    }

    public int getErrorResId() {
        return this.errorResId;
    }

    public int getPlaceholderResId() {
        return this.placeholderResId;
    }

    public int getTargetHeight() {
        return this.targetHeight;
    }

    public int getTargetWidth() {
        return this.targetWidth;
    }

    public TransformType getTransformToApply() {
        return this.transformToApply;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void setMaintainAspectRatio(boolean z) {
        this.maintainAspectRatio = z;
    }

    public void setTargetHeight(int i) {
        this.targetHeight = i;
    }

    public void setTargetWidth(int i) {
        this.targetWidth = i;
    }

    public void setTransformToApply(TransformType transformType) {
        this.transformToApply = transformType;
    }

    public boolean shouldMaintainAspectRatio() {
        return this.maintainAspectRatio;
    }
}
