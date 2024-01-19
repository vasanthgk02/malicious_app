package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0007J \u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0015"}, d2 = {"Lcom/facebook/share/internal/LegacyNativeDialogParameters;", "", "()V", "create", "Landroid/os/Bundle;", "linkContent", "Lcom/facebook/share/model/ShareLinkContent;", "dataErrorsFatal", "", "photoContent", "Lcom/facebook/share/model/SharePhotoContent;", "imageUrls", "", "", "callId", "Ljava/util/UUID;", "shareContent", "Lcom/facebook/share/model/ShareContent;", "shouldFailOnDataError", "createBaseParameters", "content", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LegacyNativeDialogParameters.kt */
public final class LegacyNativeDialogParameters {
    public static final Bundle create(UUID uuid, ShareContent<?, ?> shareContent, boolean z) {
        Intrinsics.checkNotNullParameter(uuid, "callId");
        Intrinsics.checkNotNullParameter(shareContent, "shareContent");
        boolean z2 = false;
        Bundle bundle = null;
        if (shareContent instanceof ShareLinkContent) {
            ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
            bundle = new Bundle();
            Utility.putUri(bundle, "com.facebook.platform.extra.LINK", shareLinkContent.contentUrl);
            Utility.putNonEmptyString(bundle, "com.facebook.platform.extra.PLACE", shareLinkContent.placeId);
            Utility.putNonEmptyString(bundle, "com.facebook.platform.extra.REF", shareLinkContent.ref);
            bundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", z);
            List<String> list = shareLinkContent.peopleIds;
            if (list == null || list.isEmpty()) {
                z2 = true;
            }
            if (!z2) {
                bundle.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList(list));
            }
        } else if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            Collection photoUrls = ShareInternalUtility.getPhotoUrls(sharePhotoContent, uuid);
            if (photoUrls == null) {
                photoUrls = EmptyList.INSTANCE;
            }
            bundle = new Bundle();
            Utility.putUri(bundle, "com.facebook.platform.extra.LINK", sharePhotoContent.contentUrl);
            Utility.putNonEmptyString(bundle, "com.facebook.platform.extra.PLACE", sharePhotoContent.placeId);
            Utility.putNonEmptyString(bundle, "com.facebook.platform.extra.REF", sharePhotoContent.ref);
            bundle.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", z);
            List<String> list2 = sharePhotoContent.peopleIds;
            if (list2 == null || list2.isEmpty()) {
                z2 = true;
            }
            if (!z2) {
                bundle.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList(list2));
            }
            bundle.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList(photoUrls));
        } else {
            boolean z3 = shareContent instanceof ShareVideoContent;
        }
        return bundle;
    }
}
