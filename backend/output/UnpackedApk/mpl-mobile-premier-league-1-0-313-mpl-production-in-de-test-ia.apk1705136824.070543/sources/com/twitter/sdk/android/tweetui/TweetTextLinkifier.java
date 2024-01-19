package com.twitter.sdk.android.tweetui;

import java.util.regex.Pattern;

public final class TweetTextLinkifier {
    public static final Pattern QUOTED_STATUS_URL = Pattern.compile("^https?://twitter\\.com(/#!)?/\\w+/status/\\d+$");
    public static final Pattern VINE_URL = Pattern.compile("^https?://vine\\.co(/#!)?/v/\\w+$");

    public static /* synthetic */ int lambda$mergeAndSortEntities$0(FormattedUrlEntity formattedUrlEntity, FormattedUrlEntity formattedUrlEntity2) {
        if (formattedUrlEntity == null && formattedUrlEntity2 != null) {
            return -1;
        }
        if (formattedUrlEntity != null && formattedUrlEntity2 == null) {
            return 1;
        }
        if (formattedUrlEntity == null && formattedUrlEntity2 == null) {
            return 0;
        }
        int i = formattedUrlEntity.start;
        int i2 = formattedUrlEntity2.start;
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [java.lang.CharSequence] */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009e, code lost:
        if (QUOTED_STATUS_URL.matcher(r2.expandedUrl).find() == false) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ae, code lost:
        if (VINE_URL.matcher(r2.expandedUrl).find() == false) goto L_0x00b1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.CharSequence linkifyUrls(com.twitter.sdk.android.tweetui.FormattedTweetText r14, com.twitter.sdk.android.tweetui.LinkClickListener r15, int r16, int r17, boolean r18, boolean r19) {
        /*
            r0 = r14
            java.lang.String r1 = r0.text
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x000c
            java.lang.String r0 = r0.text
            return r0
        L_0x000c:
            android.text.SpannableStringBuilder r1 = new android.text.SpannableStringBuilder
            java.lang.String r2 = r0.text
            r1.<init>(r2)
            java.util.List<com.twitter.sdk.android.tweetui.FormattedUrlEntity> r2 = r0.urlEntities
            java.util.List r2 = com.google.android.material.resources.TextAppearanceConfig.getSafeList(r2)
            java.util.List<com.twitter.sdk.android.tweetui.FormattedMediaEntity> r3 = r0.mediaEntities
            java.util.List r3 = com.google.android.material.resources.TextAppearanceConfig.getSafeList(r3)
            java.util.List<com.twitter.sdk.android.tweetui.FormattedUrlEntity> r4 = r0.hashtagEntities
            java.util.List r4 = com.google.android.material.resources.TextAppearanceConfig.getSafeList(r4)
            java.util.List<com.twitter.sdk.android.tweetui.FormattedUrlEntity> r5 = r0.mentionEntities
            java.util.List r5 = com.google.android.material.resources.TextAppearanceConfig.getSafeList(r5)
            java.util.List<com.twitter.sdk.android.tweetui.FormattedUrlEntity> r6 = r0.symbolEntities
            java.util.List r6 = com.google.android.material.resources.TextAppearanceConfig.getSafeList(r6)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>(r2)
            r7.addAll(r3)
            r7.addAll(r4)
            r7.addAll(r5)
            r7.addAll(r6)
            com.twitter.sdk.android.tweetui.-$$Lambda$TweetTextLinkifier$lprK0wbRLYp22YtUkb5dhr9jYeU r2 = com.twitter.sdk.android.tweetui.$$Lambda$TweetTextLinkifier$lprK0wbRLYp22YtUkb5dhr9jYeU.INSTANCE
            java.util.Collections.sort(r7, r2)
            java.lang.String r0 = r0.text
            boolean r2 = r7.isEmpty()
            r3 = 0
            if (r2 == 0) goto L_0x0051
            goto L_0x00b1
        L_0x0051:
            int r2 = r7.size()
            r4 = 1
            int r2 = r2 - r4
            java.lang.Object r2 = r7.get(r2)
            com.twitter.sdk.android.tweetui.FormattedUrlEntity r2 = (com.twitter.sdk.android.tweetui.FormattedUrlEntity) r2
            r5 = 8206(0x200e, float:1.1499E-41)
            java.lang.String r5 = java.lang.Character.toString(r5)
            boolean r5 = r0.endsWith(r5)
            if (r5 == 0) goto L_0x0073
            int r5 = r0.length()
            int r5 = r5 + -1
            java.lang.String r0 = r0.substring(r3, r5)
        L_0x0073:
            java.lang.String r5 = r2.url
            boolean r0 = r0.endsWith(r5)
            if (r0 == 0) goto L_0x00b1
            boolean r0 = r2 instanceof com.twitter.sdk.android.tweetui.FormattedMediaEntity
            if (r0 == 0) goto L_0x008d
            r0 = r2
            com.twitter.sdk.android.tweetui.FormattedMediaEntity r0 = (com.twitter.sdk.android.tweetui.FormattedMediaEntity) r0
            java.lang.String r0 = r0.type
            java.lang.String r5 = "photo"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            r4 = 0
        L_0x008e:
            if (r4 != 0) goto L_0x00b2
            if (r18 == 0) goto L_0x00a0
            java.util.regex.Pattern r0 = QUOTED_STATUS_URL
            java.lang.String r4 = r2.expandedUrl
            java.util.regex.Matcher r0 = r0.matcher(r4)
            boolean r0 = r0.find()
            if (r0 != 0) goto L_0x00b2
        L_0x00a0:
            if (r19 == 0) goto L_0x00b1
            java.util.regex.Pattern r0 = VINE_URL
            java.lang.String r4 = r2.expandedUrl
            java.util.regex.Matcher r0 = r0.matcher(r4)
            boolean r0 = r0.find()
            if (r0 == 0) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r2 = 0
        L_0x00b2:
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto L_0x00b9
            goto L_0x0114
        L_0x00b9:
            java.util.Iterator r0 = r7.iterator()
            r4 = 0
        L_0x00be:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0114
            java.lang.Object r5 = r0.next()
            r11 = r5
            com.twitter.sdk.android.tweetui.FormattedUrlEntity r11 = (com.twitter.sdk.android.tweetui.FormattedUrlEntity) r11
            int r5 = r11.start
            int r5 = r5 - r4
            int r6 = r11.end
            int r6 = r6 - r4
            if (r5 < 0) goto L_0x00be
            int r7 = r1.length()
            if (r6 > r7) goto L_0x00be
            if (r2 == 0) goto L_0x00e9
            int r7 = r2.start
            int r8 = r11.start
            if (r7 != r8) goto L_0x00e9
            java.lang.String r7 = ""
            r1.replace(r5, r6, r7)
            int r6 = r6 - r5
            int r4 = r4 + r6
            goto L_0x00be
        L_0x00e9:
            java.lang.String r7 = r11.displayUrl
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00be
            java.lang.String r7 = r11.displayUrl
            r1.replace(r5, r6, r7)
            java.lang.String r7 = r11.displayUrl
            int r7 = r7.length()
            int r7 = r7 + r5
            int r7 = r6 - r7
            int r12 = r6 - r7
            int r4 = r4 + r7
            com.twitter.sdk.android.tweetui.TweetTextLinkifier$1 r13 = new com.twitter.sdk.android.tweetui.TweetTextLinkifier$1
            r9 = 0
            r6 = r13
            r7 = r17
            r8 = r16
            r10 = r15
            r6.<init>(r7, r8, r9, r10, r11)
            r6 = 33
            r1.setSpan(r13, r5, r12, r6)
            goto L_0x00be
        L_0x0114:
            int r0 = r1.length()
        L_0x0118:
            if (r0 <= 0) goto L_0x0126
            int r2 = r0 + -1
            char r4 = r1.charAt(r2)
            r5 = 32
            if (r4 > r5) goto L_0x0126
            r0 = r2
            goto L_0x0118
        L_0x0126:
            int r2 = r1.length()
            if (r0 >= r2) goto L_0x0130
            java.lang.CharSequence r1 = r1.subSequence(r3, r0)
        L_0x0130:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.TweetTextLinkifier.linkifyUrls(com.twitter.sdk.android.tweetui.FormattedTweetText, com.twitter.sdk.android.tweetui.LinkClickListener, int, int, boolean, boolean):java.lang.CharSequence");
    }
}
