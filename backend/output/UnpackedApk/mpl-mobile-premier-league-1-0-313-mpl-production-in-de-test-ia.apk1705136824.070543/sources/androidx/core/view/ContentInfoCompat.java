package androidx.core.view;

import a.a.a.a.d.b;
import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.util.Locale;

public final class ContentInfoCompat {
    public final ClipData mClip;
    public final Bundle mExtras;
    public final int mFlags;
    public final Uri mLinkUri;
    public final int mSource;

    public static final class Builder {
        public ClipData mClip;
        public Bundle mExtras;
        public int mFlags;
        public Uri mLinkUri;
        public int mSource;

        public Builder(ClipData clipData, int i) {
            this.mClip = clipData;
            this.mSource = i;
        }
    }

    public ContentInfoCompat(Builder builder) {
        ClipData clipData = builder.mClip;
        b.checkNotNull(clipData);
        this.mClip = clipData;
        int i = builder.mSource;
        Integer valueOf = Integer.valueOf(3);
        Integer valueOf2 = Integer.valueOf(0);
        if (i < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{DefaultSettingsSpiCall.SOURCE_PARAM, valueOf2, valueOf}));
        } else if (i <= 3) {
            this.mSource = i;
            int i2 = builder.mFlags;
            if ((i2 & 1) == i2) {
                this.mFlags = i2;
                this.mLinkUri = builder.mLinkUri;
                this.mExtras = builder.mExtras;
                return;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Requested flags 0x");
            outline73.append(Integer.toHexString(i2));
            outline73.append(", but only 0x");
            outline73.append(Integer.toHexString(1));
            outline73.append(" are allowed");
            throw new IllegalArgumentException(outline73.toString());
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{DefaultSettingsSpiCall.SOURCE_PARAM, valueOf2, valueOf}));
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ContentInfoCompat{clip=");
        outline73.append(this.mClip.getDescription());
        outline73.append(", source=");
        int i = this.mSource;
        outline73.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? String.valueOf(i) : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
        outline73.append(", flags=");
        int i2 = this.mFlags;
        if ((i2 & 1) != 0) {
            str = "FLAG_CONVERT_TO_PLAIN_TEXT";
        } else {
            str = String.valueOf(i2);
        }
        outline73.append(str);
        String str3 = "";
        if (this.mLinkUri == null) {
            str2 = str3;
        } else {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73(", hasLinkUri(");
            outline732.append(this.mLinkUri.toString().length());
            outline732.append(")");
            str2 = outline732.toString();
        }
        outline73.append(str2);
        if (this.mExtras != null) {
            str3 = ", hasExtras";
        }
        return GeneratedOutlineSupport.outline62(outline73, str3, "}");
    }
}
