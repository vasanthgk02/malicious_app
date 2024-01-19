package com.facebook.share.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\tH\u0002J*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0007J \u0010 \u001a\u00020\u00042\u000e\u0010!\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e2\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\""}, d2 = {"Lcom/facebook/share/internal/NativeDialogParameters;", "", "()V", "create", "Landroid/os/Bundle;", "cameraEffectContent", "Lcom/facebook/share/model/ShareCameraEffectContent;", "attachmentUrlsBundle", "dataErrorsFatal", "", "linkContent", "Lcom/facebook/share/model/ShareLinkContent;", "mediaContent", "Lcom/facebook/share/model/ShareMediaContent;", "mediaInfos", "", "photoContent", "Lcom/facebook/share/model/SharePhotoContent;", "imageUrls", "", "storyContent", "Lcom/facebook/share/model/ShareStoryContent;", "mediaInfo", "stickerInfo", "videoContent", "Lcom/facebook/share/model/ShareVideoContent;", "videoUrl", "callId", "Ljava/util/UUID;", "shareContent", "Lcom/facebook/share/model/ShareContent;", "shouldFailOnDataError", "createBaseParameters", "content", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: NativeDialogParameters.kt */
public final class NativeDialogParameters {
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25, types: [java.util.Collection] */
    /* JADX WARNING: type inference failed for: r0v27, types: [kotlin.collections.EmptyList] */
    /* JADX WARNING: type inference failed for: r0v29 */
    /* JADX WARNING: type inference failed for: r0v32 */
    /* JADX WARNING: type inference failed for: r0v44 */
    /* JADX WARNING: type inference failed for: r0v45 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03df  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03eb  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03f7  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03f9  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0402  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0412  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0414  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x041a  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0426  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.os.Bundle create(java.util.UUID r19, com.facebook.share.model.ShareContent<?, ?> r20, boolean r21) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.String r3 = "callId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r4 = "shareContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            boolean r4 = r1 instanceof com.facebook.share.model.ShareLinkContent
            java.lang.String r5 = "HASHTAG"
            java.lang.String r6 = "FRIENDS"
            java.lang.String r7 = "DATA_FAILURES_FATAL"
            java.lang.String r8 = "REF"
            java.lang.String r9 = "PAGE"
            java.lang.String r10 = "PLACE"
            java.lang.String r11 = "LINK"
            r12 = 0
            if (r4 == 0) goto L_0x0080
            r0 = r1
            com.facebook.share.model.ShareLinkContent r0 = (com.facebook.share.model.ShareLinkContent) r0
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            android.net.Uri r3 = r0.contentUrl
            com.facebook.internal.Utility.putUri(r1, r11, r3)
            java.lang.String r3 = r0.placeId
            com.facebook.internal.Utility.putNonEmptyString(r1, r10, r3)
            java.lang.String r3 = r0.pageId
            com.facebook.internal.Utility.putNonEmptyString(r1, r9, r3)
            java.lang.String r3 = r0.ref
            com.facebook.internal.Utility.putNonEmptyString(r1, r8, r3)
            java.lang.String r3 = r0.ref
            com.facebook.internal.Utility.putNonEmptyString(r1, r8, r3)
            r1.putBoolean(r7, r2)
            java.util.List<java.lang.String> r2 = r0.peopleIds
            if (r2 == 0) goto L_0x0054
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r3 = 0
            goto L_0x0055
        L_0x0054:
            r3 = 1
        L_0x0055:
            if (r3 != 0) goto L_0x005f
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r2)
            r1.putStringArrayList(r6, r3)
        L_0x005f:
            com.facebook.share.model.ShareHashtag r2 = r0.shareHashtag
            if (r2 != 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            java.lang.String r12 = r2.hashtag
        L_0x0066:
            com.facebook.internal.Utility.putNonEmptyString(r1, r5, r12)
            java.lang.String r2 = r0.quote
            java.lang.String r3 = "QUOTE"
            com.facebook.internal.Utility.putNonEmptyString(r1, r3, r2)
            android.net.Uri r2 = r0.contentUrl
            java.lang.String r3 = "MESSENGER_LINK"
            com.facebook.internal.Utility.putUri(r1, r3, r2)
            android.net.Uri r0 = r0.contentUrl
            java.lang.String r2 = "TARGET_DISPLAY"
            com.facebook.internal.Utility.putUri(r1, r2, r0)
            goto L_0x0439
        L_0x0080:
            boolean r4 = r1 instanceof com.facebook.share.model.SharePhotoContent
            if (r4 == 0) goto L_0x00dd
            com.facebook.share.model.SharePhotoContent r1 = (com.facebook.share.model.SharePhotoContent) r1
            java.util.List r0 = com.facebook.share.internal.ShareInternalUtility.getPhotoUrls(r1, r0)
            if (r0 != 0) goto L_0x008e
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
        L_0x008e:
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            android.net.Uri r4 = r1.contentUrl
            com.facebook.internal.Utility.putUri(r3, r11, r4)
            java.lang.String r4 = r1.placeId
            com.facebook.internal.Utility.putNonEmptyString(r3, r10, r4)
            java.lang.String r4 = r1.pageId
            com.facebook.internal.Utility.putNonEmptyString(r3, r9, r4)
            java.lang.String r4 = r1.ref
            com.facebook.internal.Utility.putNonEmptyString(r3, r8, r4)
            java.lang.String r4 = r1.ref
            com.facebook.internal.Utility.putNonEmptyString(r3, r8, r4)
            r3.putBoolean(r7, r2)
            java.util.List<java.lang.String> r2 = r1.peopleIds
            if (r2 == 0) goto L_0x00bc
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L_0x00ba
            goto L_0x00bc
        L_0x00ba:
            r4 = 0
            goto L_0x00bd
        L_0x00bc:
            r4 = 1
        L_0x00bd:
            if (r4 != 0) goto L_0x00c7
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r2)
            r3.putStringArrayList(r6, r4)
        L_0x00c7:
            com.facebook.share.model.ShareHashtag r1 = r1.shareHashtag
            if (r1 != 0) goto L_0x00cc
            goto L_0x00ce
        L_0x00cc:
            java.lang.String r12 = r1.hashtag
        L_0x00ce:
            com.facebook.internal.Utility.putNonEmptyString(r3, r5, r12)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            java.lang.String r0 = "PHOTOS"
            r3.putStringArrayList(r0, r1)
            goto L_0x043c
        L_0x00dd:
            boolean r4 = r1 instanceof com.facebook.share.model.ShareVideoContent
            java.lang.String r13 = "attachmentUri"
            java.lang.String r14 = "appCallId"
            if (r4 == 0) goto L_0x0162
            com.facebook.share.model.ShareVideoContent r1 = (com.facebook.share.model.ShareVideoContent) r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r14)
            com.facebook.share.model.ShareVideo r4 = r1.video
            if (r4 != 0) goto L_0x00f0
            r4 = r12
            goto L_0x00f2
        L_0x00f0:
            android.net.Uri r4 = r4.localUrl
        L_0x00f2:
            if (r4 != 0) goto L_0x00f6
            r0 = r12
            goto L_0x010a
        L_0x00f6:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r13)
            com.facebook.internal.NativeAppCallAttachmentStore$Attachment r3 = new com.facebook.internal.NativeAppCallAttachmentStore$Attachment
            r3.<init>(r0, r12, r4)
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r3)
            com.facebook.internal.NativeAppCallAttachmentStore.addAttachments(r0)
            java.lang.String r0 = r3.attachmentUrl
        L_0x010a:
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            android.net.Uri r4 = r1.contentUrl
            com.facebook.internal.Utility.putUri(r3, r11, r4)
            java.lang.String r4 = r1.placeId
            com.facebook.internal.Utility.putNonEmptyString(r3, r10, r4)
            java.lang.String r4 = r1.pageId
            com.facebook.internal.Utility.putNonEmptyString(r3, r9, r4)
            java.lang.String r4 = r1.ref
            com.facebook.internal.Utility.putNonEmptyString(r3, r8, r4)
            java.lang.String r4 = r1.ref
            com.facebook.internal.Utility.putNonEmptyString(r3, r8, r4)
            r3.putBoolean(r7, r2)
            java.util.List<java.lang.String> r2 = r1.peopleIds
            if (r2 == 0) goto L_0x0138
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L_0x0136
            goto L_0x0138
        L_0x0136:
            r4 = 0
            goto L_0x0139
        L_0x0138:
            r4 = 1
        L_0x0139:
            if (r4 != 0) goto L_0x0143
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r2)
            r3.putStringArrayList(r6, r4)
        L_0x0143:
            com.facebook.share.model.ShareHashtag r2 = r1.shareHashtag
            if (r2 != 0) goto L_0x0148
            goto L_0x014a
        L_0x0148:
            java.lang.String r12 = r2.hashtag
        L_0x014a:
            com.facebook.internal.Utility.putNonEmptyString(r3, r5, r12)
            java.lang.String r2 = r1.contentTitle
            java.lang.String r4 = "TITLE"
            com.facebook.internal.Utility.putNonEmptyString(r3, r4, r2)
            java.lang.String r1 = r1.contentDescription
            java.lang.String r2 = "DESCRIPTION"
            com.facebook.internal.Utility.putNonEmptyString(r3, r2, r1)
            java.lang.String r1 = "VIDEO"
            com.facebook.internal.Utility.putNonEmptyString(r3, r1, r0)
            goto L_0x043c
        L_0x0162:
            boolean r4 = r1 instanceof com.facebook.share.model.ShareMediaContent
            java.lang.String r12 = "type"
            java.lang.String r15 = "uri"
            if (r4 == 0) goto L_0x0214
            com.facebook.share.model.ShareMediaContent r1 = (com.facebook.share.model.ShareMediaContent) r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r14)
            java.util.List<com.facebook.share.model.ShareMedia<?, ?>> r3 = r1.media
            if (r3 != 0) goto L_0x0175
            r0 = 0
            goto L_0x01c0
        L_0x0175:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x0183:
            boolean r14 = r3.hasNext()
            if (r14 == 0) goto L_0x01bc
            java.lang.Object r14 = r3.next()
            com.facebook.share.model.ShareMedia r14 = (com.facebook.share.model.ShareMedia) r14
            r20 = r3
            com.facebook.internal.NativeAppCallAttachmentStore$Attachment r3 = com.facebook.share.internal.ShareInternalUtility.getAttachment(r0, r14)
            if (r3 != 0) goto L_0x0199
            r3 = 0
            goto L_0x01b2
        L_0x0199:
            r4.add(r3)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            com.facebook.share.model.ShareMedia$Type r14 = r14.getMediaType()
            java.lang.String r14 = r14.name()
            r0.putString(r12, r14)
            java.lang.String r3 = r3.attachmentUrl
            r0.putString(r15, r3)
            r3 = r0
        L_0x01b2:
            if (r3 == 0) goto L_0x01b7
            r13.add(r3)
        L_0x01b7:
            r0 = r19
            r3 = r20
            goto L_0x0183
        L_0x01bc:
            com.facebook.internal.NativeAppCallAttachmentStore.addAttachments(r4)
            r0 = r13
        L_0x01c0:
            if (r0 != 0) goto L_0x01c4
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
        L_0x01c4:
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            android.net.Uri r4 = r1.contentUrl
            com.facebook.internal.Utility.putUri(r3, r11, r4)
            java.lang.String r4 = r1.placeId
            com.facebook.internal.Utility.putNonEmptyString(r3, r10, r4)
            java.lang.String r4 = r1.pageId
            com.facebook.internal.Utility.putNonEmptyString(r3, r9, r4)
            java.lang.String r4 = r1.ref
            com.facebook.internal.Utility.putNonEmptyString(r3, r8, r4)
            java.lang.String r4 = r1.ref
            com.facebook.internal.Utility.putNonEmptyString(r3, r8, r4)
            r3.putBoolean(r7, r2)
            java.util.List<java.lang.String> r2 = r1.peopleIds
            if (r2 == 0) goto L_0x01f2
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L_0x01f0
            goto L_0x01f2
        L_0x01f0:
            r4 = 0
            goto L_0x01f3
        L_0x01f2:
            r4 = 1
        L_0x01f3:
            if (r4 != 0) goto L_0x01fd
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r2)
            r3.putStringArrayList(r6, r4)
        L_0x01fd:
            com.facebook.share.model.ShareHashtag r1 = r1.shareHashtag
            if (r1 != 0) goto L_0x0203
            r1 = 0
            goto L_0x0205
        L_0x0203:
            java.lang.String r1 = r1.hashtag
        L_0x0205:
            com.facebook.internal.Utility.putNonEmptyString(r3, r5, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            java.lang.String r0 = "MEDIA"
            r3.putParcelableArrayList(r0, r1)
            goto L_0x043c
        L_0x0214:
            boolean r0 = r1 instanceof com.facebook.share.model.ShareCameraEffectContent
            if (r0 == 0) goto L_0x033a
            r0 = r1
            com.facebook.share.model.ShareCameraEffectContent r0 = (com.facebook.share.model.ShareCameraEffectContent) r0
            r4 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r14)
            com.facebook.share.model.CameraEffectTextures r1 = r0.textures
            if (r1 != 0) goto L_0x022c
            r1 = 0
            r3 = 0
            r16 = r5
            r17 = r6
            goto L_0x02be
        L_0x022c:
            android.os.Bundle r12 = new android.os.Bundle
            r12.<init>()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            android.os.Bundle r15 = r1.textures
            if (r15 != 0) goto L_0x023c
            r15 = 0
            goto L_0x0240
        L_0x023c:
            java.util.Set r15 = r15.keySet()
        L_0x0240:
            if (r15 != 0) goto L_0x0244
            kotlin.collections.EmptySet r15 = kotlin.collections.EmptySet.INSTANCE
        L_0x0244:
            java.util.Iterator r15 = r15.iterator()
        L_0x0248:
            boolean r16 = r15.hasNext()
            if (r16 == 0) goto L_0x02b5
            java.lang.Object r16 = r15.next()
            r20 = r15
            r15 = r16
            java.lang.String r15 = (java.lang.String) r15
            r16 = r5
            android.os.Bundle r5 = r1.textures
            if (r5 != 0) goto L_0x0260
            r5 = 0
            goto L_0x0264
        L_0x0260:
            java.lang.Object r5 = r5.get(r15)
        L_0x0264:
            r17 = r6
            boolean r6 = r5 instanceof android.net.Uri
            if (r6 == 0) goto L_0x026d
            android.net.Uri r5 = (android.net.Uri) r5
            goto L_0x026e
        L_0x026d:
            r5 = 0
        L_0x026e:
            android.os.Bundle r6 = r1.textures
            if (r6 != 0) goto L_0x0274
            r6 = 0
            goto L_0x0278
        L_0x0274:
            java.lang.Object r6 = r6.get(r15)
        L_0x0278:
            r18 = r1
            boolean r1 = r6 instanceof android.graphics.Bitmap
            if (r1 == 0) goto L_0x0281
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            goto L_0x0282
        L_0x0281:
            r6 = 0
        L_0x0282:
            if (r6 == 0) goto L_0x0293
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            java.lang.String r1 = "attachmentBitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            com.facebook.internal.NativeAppCallAttachmentStore$Attachment r1 = new com.facebook.internal.NativeAppCallAttachmentStore$Attachment
            r5 = 0
            r1.<init>(r4, r6, r5)
            goto L_0x02a2
        L_0x0293:
            r1 = 0
            if (r5 == 0) goto L_0x02a2
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r13)
            com.facebook.internal.NativeAppCallAttachmentStore$Attachment r6 = new com.facebook.internal.NativeAppCallAttachmentStore$Attachment
            r6.<init>(r4, r1, r5)
            r1 = r6
        L_0x02a2:
            if (r1 == 0) goto L_0x02ac
            r14.add(r1)
            java.lang.String r1 = r1.attachmentUrl
            r12.putString(r15, r1)
        L_0x02ac:
            r15 = r20
            r5 = r16
            r6 = r17
            r1 = r18
            goto L_0x0248
        L_0x02b5:
            r16 = r5
            r17 = r6
            r1 = 0
            com.facebook.internal.NativeAppCallAttachmentStore.addAttachments(r14)
            r3 = r12
        L_0x02be:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            android.net.Uri r5 = r0.contentUrl
            com.facebook.internal.Utility.putUri(r4, r11, r5)
            java.lang.String r5 = r0.placeId
            com.facebook.internal.Utility.putNonEmptyString(r4, r10, r5)
            java.lang.String r5 = r0.pageId
            com.facebook.internal.Utility.putNonEmptyString(r4, r9, r5)
            java.lang.String r5 = r0.ref
            com.facebook.internal.Utility.putNonEmptyString(r4, r8, r5)
            java.lang.String r5 = r0.ref
            com.facebook.internal.Utility.putNonEmptyString(r4, r8, r5)
            r4.putBoolean(r7, r2)
            java.util.List<java.lang.String> r2 = r0.peopleIds
            if (r2 == 0) goto L_0x02ec
            boolean r5 = r2.isEmpty()
            if (r5 == 0) goto L_0x02ea
            goto L_0x02ec
        L_0x02ea:
            r5 = 0
            goto L_0x02ed
        L_0x02ec:
            r5 = 1
        L_0x02ed:
            if (r5 != 0) goto L_0x02f9
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r2)
            r6 = r17
            r4.putStringArrayList(r6, r5)
        L_0x02f9:
            com.facebook.share.model.ShareHashtag r2 = r0.shareHashtag
            if (r2 != 0) goto L_0x02fe
            goto L_0x0300
        L_0x02fe:
            java.lang.String r1 = r2.hashtag
        L_0x0300:
            r5 = r16
            com.facebook.internal.Utility.putNonEmptyString(r4, r5, r1)
            java.lang.String r1 = r0.effectId
            java.lang.String r2 = "effect_id"
            com.facebook.internal.Utility.putNonEmptyString(r4, r2, r1)
            if (r3 == 0) goto L_0x0313
            java.lang.String r1 = "effect_textures"
            r4.putBundle(r1, r3)
        L_0x0313:
            com.facebook.share.internal.CameraEffectJSONUtility r1 = com.facebook.share.internal.CameraEffectJSONUtility.INSTANCE     // Catch:{ JSONException -> 0x0329 }
            com.facebook.share.model.CameraEffectArguments r0 = r0.arguments     // Catch:{ JSONException -> 0x0329 }
            org.json.JSONObject r0 = com.facebook.share.internal.CameraEffectJSONUtility.convertToJSON(r0)     // Catch:{ JSONException -> 0x0329 }
            if (r0 == 0) goto L_0x0326
            java.lang.String r1 = "effect_arguments"
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0329 }
            com.facebook.internal.Utility.putNonEmptyString(r4, r1, r0)     // Catch:{ JSONException -> 0x0329 }
        L_0x0326:
            r1 = r4
            goto L_0x0439
        L_0x0329:
            r0 = move-exception
            com.facebook.FacebookException r1 = new com.facebook.FacebookException
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = "Unable to create a JSON Object from the provided CameraEffectArguments: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)
            r1.<init>(r0)
            throw r1
        L_0x033a:
            r4 = r19
            r0 = 0
            boolean r3 = r1 instanceof com.facebook.share.model.ShareStoryContent
            if (r3 == 0) goto L_0x043b
            com.facebook.share.model.ShareStoryContent r1 = (com.facebook.share.model.ShareStoryContent) r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r14)
            com.facebook.share.model.ShareMedia<?, ?> r3 = r1.backgroundAsset
            java.lang.String r13 = "extension"
            if (r3 != 0) goto L_0x034f
        L_0x034c:
            r16 = r5
            goto L_0x0381
        L_0x034f:
            com.facebook.internal.NativeAppCallAttachmentStore$Attachment r0 = com.facebook.share.internal.ShareInternalUtility.getAttachment(r4, r3)
            if (r0 != 0) goto L_0x0357
            r0 = 0
            goto L_0x034c
        L_0x0357:
            r16 = r5
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            com.facebook.share.model.ShareMedia$Type r3 = r3.getMediaType()
            java.lang.String r3 = r3.name()
            r5.putString(r12, r3)
            java.lang.String r3 = r0.attachmentUrl
            r5.putString(r15, r3)
            android.net.Uri r3 = r0.originalUri
            java.lang.String r3 = com.facebook.share.internal.ShareInternalUtility.getUriExtension(r3)
            if (r3 == 0) goto L_0x0379
            com.facebook.internal.Utility.putNonEmptyString(r5, r13, r3)
        L_0x0379:
            java.util.List r0 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r0)
            com.facebook.internal.NativeAppCallAttachmentStore.addAttachments(r0)
            r0 = r5
        L_0x0381:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r14)
            com.facebook.share.model.SharePhoto r3 = r1.stickerAsset
            if (r3 != 0) goto L_0x0389
            goto L_0x039b
        L_0x0389:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.facebook.share.model.SharePhoto r5 = r1.stickerAsset
            r3.add(r5)
            com.facebook.share.model.SharePhoto r3 = r1.stickerAsset
            com.facebook.internal.NativeAppCallAttachmentStore$Attachment r3 = com.facebook.share.internal.ShareInternalUtility.getAttachment(r4, r3)
            if (r3 != 0) goto L_0x039d
        L_0x039b:
            r3 = 0
            goto L_0x03ba
        L_0x039d:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r5 = r3.attachmentUrl
            r4.putString(r15, r5)
            android.net.Uri r5 = r3.originalUri
            java.lang.String r5 = com.facebook.share.internal.ShareInternalUtility.getUriExtension(r5)
            if (r5 == 0) goto L_0x03b2
            com.facebook.internal.Utility.putNonEmptyString(r4, r13, r5)
        L_0x03b2:
            java.util.List r3 = com.twitter.sdk.android.tweetui.TweetUtils.listOf(r3)
            com.facebook.internal.NativeAppCallAttachmentStore.addAttachments(r3)
            r3 = r4
        L_0x03ba:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            android.net.Uri r5 = r1.contentUrl
            com.facebook.internal.Utility.putUri(r4, r11, r5)
            java.lang.String r5 = r1.placeId
            com.facebook.internal.Utility.putNonEmptyString(r4, r10, r5)
            java.lang.String r5 = r1.pageId
            com.facebook.internal.Utility.putNonEmptyString(r4, r9, r5)
            java.lang.String r5 = r1.ref
            com.facebook.internal.Utility.putNonEmptyString(r4, r8, r5)
            java.lang.String r5 = r1.ref
            com.facebook.internal.Utility.putNonEmptyString(r4, r8, r5)
            r4.putBoolean(r7, r2)
            java.util.List<java.lang.String> r2 = r1.peopleIds
            if (r2 == 0) goto L_0x03e8
            boolean r5 = r2.isEmpty()
            if (r5 == 0) goto L_0x03e6
            goto L_0x03e8
        L_0x03e6:
            r5 = 0
            goto L_0x03e9
        L_0x03e8:
            r5 = 1
        L_0x03e9:
            if (r5 != 0) goto L_0x03f3
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r2)
            r4.putStringArrayList(r6, r5)
        L_0x03f3:
            com.facebook.share.model.ShareHashtag r2 = r1.shareHashtag
            if (r2 != 0) goto L_0x03f9
            r2 = 0
            goto L_0x03fb
        L_0x03f9:
            java.lang.String r2 = r2.hashtag
        L_0x03fb:
            r5 = r16
            com.facebook.internal.Utility.putNonEmptyString(r4, r5, r2)
            if (r0 == 0) goto L_0x0407
            java.lang.String r2 = "bg_asset"
            r4.putParcelable(r2, r0)
        L_0x0407:
            if (r3 == 0) goto L_0x040e
            java.lang.String r0 = "interactive_asset_uri"
            r4.putParcelable(r0, r3)
        L_0x040e:
            java.util.List<java.lang.String> r0 = r1.backgroundColorList
            if (r0 != 0) goto L_0x0414
            r0 = 0
            goto L_0x0418
        L_0x0414:
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r0)
        L_0x0418:
            if (r0 == 0) goto L_0x0423
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x0421
            goto L_0x0423
        L_0x0421:
            r2 = 0
            goto L_0x0424
        L_0x0423:
            r2 = 1
        L_0x0424:
            if (r2 != 0) goto L_0x0430
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r0)
            java.lang.String r0 = "top_background_color_list"
            r4.putStringArrayList(r0, r2)
        L_0x0430:
            java.lang.String r0 = r1.attributionLink
            java.lang.String r1 = "content_url"
            com.facebook.internal.Utility.putNonEmptyString(r4, r1, r0)
            goto L_0x0326
        L_0x0439:
            r3 = r1
            goto L_0x043c
        L_0x043b:
            r3 = 0
        L_0x043c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.NativeDialogParameters.create(java.util.UUID, com.facebook.share.model.ShareContent, boolean):android.os.Bundle");
    }
}
