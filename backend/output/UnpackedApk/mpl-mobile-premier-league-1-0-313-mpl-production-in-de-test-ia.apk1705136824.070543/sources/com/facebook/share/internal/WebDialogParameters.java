package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u0013"}, d2 = {"Lcom/facebook/share/internal/WebDialogParameters;", "", "()V", "create", "Landroid/os/Bundle;", "appGroupCreationContent", "Lcom/facebook/share/model/AppGroupCreationContent;", "gameRequestContent", "Lcom/facebook/share/model/GameRequestContent;", "shareLinkContent", "Lcom/facebook/share/model/ShareLinkContent;", "sharePhotoContent", "Lcom/facebook/share/model/SharePhotoContent;", "createBaseParameters", "shareContent", "Lcom/facebook/share/model/ShareContent;", "createForFeed", "shareFeedContent", "Lcom/facebook/share/internal/ShareFeedContent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: WebDialogParameters.kt */
public final class WebDialogParameters {
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.os.Bundle create(com.facebook.share.model.GameRequestContent r8) {
        /*
            java.lang.String r0 = "gameRequestContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = r8.message
            java.lang.String r2 = "message"
            com.facebook.internal.Utility.putNonEmptyString(r0, r2, r1)
            java.util.List<java.lang.String> r1 = r8.recipients
            java.lang.String r2 = "b"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r3 = ","
            if (r1 == 0) goto L_0x0025
            java.lang.String r1 = android.text.TextUtils.join(r3, r1)
            java.lang.String r4 = "to"
            r0.putString(r4, r1)
        L_0x0025:
            java.lang.String r1 = r8.title
            java.lang.String r4 = "title"
            com.facebook.internal.Utility.putNonEmptyString(r0, r4, r1)
            java.lang.String r1 = r8.data
            java.lang.String r4 = "data"
            com.facebook.internal.Utility.putNonEmptyString(r0, r4, r1)
            com.facebook.share.model.GameRequestContent$ActionType r1 = r8.actionType
            java.lang.String r4 = "(this as java.lang.String).toLowerCase(locale)"
            java.lang.String r5 = "ENGLISH"
            r6 = 0
            if (r1 != 0) goto L_0x003d
            goto L_0x0043
        L_0x003d:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x0045
        L_0x0043:
            r1 = r6
            goto L_0x0051
        L_0x0045:
            java.util.Locale r7 = java.util.Locale.ENGLISH
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            java.lang.String r1 = r1.toLowerCase(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
        L_0x0051:
            java.lang.String r7 = "action_type"
            com.facebook.internal.Utility.putNonEmptyString(r0, r7, r1)
            java.lang.String r1 = r8.objectId
            java.lang.String r7 = "object_id"
            com.facebook.internal.Utility.putNonEmptyString(r0, r7, r1)
            com.facebook.share.model.GameRequestContent$Filters r1 = r8.filters
            if (r1 != 0) goto L_0x0062
            goto L_0x0075
        L_0x0062:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x0069
            goto L_0x0075
        L_0x0069:
            java.util.Locale r6 = java.util.Locale.ENGLISH
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            java.lang.String r6 = r1.toLowerCase(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
        L_0x0075:
            java.lang.String r1 = "filters"
            com.facebook.internal.Utility.putNonEmptyString(r0, r1, r6)
            java.util.List<java.lang.String> r8 = r8.suggestions
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            if (r8 == 0) goto L_0x008a
            java.lang.String r8 = android.text.TextUtils.join(r3, r8)
            java.lang.String r1 = "suggestions"
            r0.putString(r1, r8)
        L_0x008a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.WebDialogParameters.create(com.facebook.share.model.GameRequestContent):android.os.Bundle");
    }

    public static final Bundle createBaseParameters(ShareContent<?, ?> shareContent) {
        String str;
        Intrinsics.checkNotNullParameter(shareContent, "shareContent");
        Bundle bundle = new Bundle();
        ShareHashtag shareHashtag = shareContent.shareHashtag;
        if (shareHashtag == null) {
            str = null;
        } else {
            str = shareHashtag.hashtag;
        }
        Utility.putNonEmptyString(bundle, "hashtag", str);
        return bundle;
    }
}
