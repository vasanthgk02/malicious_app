package com.twitter.sdk.android.tweetcomposer;

import android.app.IntentService;
import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;

public class TweetUploadService extends IntentService {
    public DependencyProvider dependencyProvider;
    public Intent intent;

    public static class DependencyProvider {
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TweetUploadService() {
        // DependencyProvider dependencyProvider2 = new DependencyProvider();
        super("TweetUploadService");
        this.dependencyProvider = dependencyProvider2;
    }

    public void fail(TwitterException twitterException) {
        Intent intent2 = this.intent;
        Intent intent3 = new Intent("com.twitter.sdk.android.tweetcomposer.UPLOAD_FAILURE");
        intent3.putExtra("EXTRA_RETRY_INTENT", intent2);
        intent3.setPackage(getApplicationContext().getPackageName());
        sendBroadcast(intent3);
        stopSelf();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleIntent(android.content.Intent r9) {
        /*
            r8 = this;
            java.lang.String r0 = "EXTRA_USER_TOKEN"
            android.os.Parcelable r0 = r9.getParcelableExtra(r0)
            com.twitter.sdk.android.core.TwitterAuthToken r0 = (com.twitter.sdk.android.core.TwitterAuthToken) r0
            r8.intent = r9
            com.twitter.sdk.android.core.TwitterSession r1 = new com.twitter.sdk.android.core.TwitterSession
            r2 = -1
            java.lang.String r4 = ""
            r1.<init>(r0, r2, r4)
            java.lang.String r0 = "EXTRA_TWEET_TEXT"
            java.lang.String r0 = r9.getStringExtra(r0)
            java.lang.String r2 = "EXTRA_IMAGE_URI"
            android.os.Parcelable r9 = r9.getParcelableExtra(r2)
            android.net.Uri r9 = (android.net.Uri) r9
            r2 = 0
            if (r9 == 0) goto L_0x00db
            com.twitter.sdk.android.tweetcomposer.TweetUploadService$1 r3 = new com.twitter.sdk.android.tweetcomposer.TweetUploadService$1
            r3.<init>(r1, r0)
            com.twitter.sdk.android.tweetcomposer.TweetUploadService$DependencyProvider r0 = r8.dependencyProvider
            if (r0 == 0) goto L_0x00da
            com.twitter.sdk.android.core.TwitterCore r0 = com.twitter.sdk.android.core.TwitterCore.getInstance()
            com.twitter.sdk.android.core.TwitterApiClient r0 = r0.getApiClient(r1)
            java.lang.String r1 = r9.getAuthority()
            java.lang.String r5 = "com.android.providers.media.documents"
            boolean r1 = r5.equalsIgnoreCase(r1)
            r5 = 1
            if (r1 == 0) goto L_0x0066
            java.lang.String r9 = android.provider.DocumentsContract.getDocumentId(r9)
            java.lang.String r1 = ":"
            java.lang.String[] r9 = r9.split(r1)
            r1 = 0
            r6 = r9[r1]
            java.lang.String r7 = "image"
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x0088
            android.net.Uri r6 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            java.lang.String[] r7 = new java.lang.String[r5]
            r9 = r9[r5]
            r7[r1] = r9
            java.lang.String r9 = "_id=?"
            java.lang.String r9 = com.google.android.material.resources.TextAppearanceConfig.resolveFilePath(r8, r6, r9, r7)
            goto L_0x0089
        L_0x0066:
            java.lang.String r1 = r9.getScheme()
            java.lang.String r6 = "content"
            boolean r1 = r6.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0077
            java.lang.String r9 = com.google.android.material.resources.TextAppearanceConfig.resolveFilePath(r8, r9, r2, r2)
            goto L_0x0089
        L_0x0077:
            java.lang.String r1 = r9.getScheme()
            java.lang.String r6 = "file"
            boolean r1 = r6.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0088
            java.lang.String r9 = r9.getPath()
            goto L_0x0089
        L_0x0088:
            r9 = r2
        L_0x0089:
            if (r9 != 0) goto L_0x0096
            com.twitter.sdk.android.core.TwitterException r9 = new com.twitter.sdk.android.core.TwitterException
            java.lang.String r0 = "Uri file path resolved to null"
            r9.<init>(r0)
            r8.fail(r9)
            goto L_0x00de
        L_0x0096:
            java.io.File r1 = new java.io.File
            r1.<init>(r9)
            java.lang.String r9 = r1.getName()
            if (r9 != 0) goto L_0x00a3
            r4 = r2
            goto L_0x00b1
        L_0x00a3:
            java.lang.String r6 = "."
            int r6 = r9.lastIndexOf(r6)
            if (r6 >= 0) goto L_0x00ac
            goto L_0x00b1
        L_0x00ac:
            int r6 = r6 + r5
            java.lang.String r4 = r9.substring(r6)
        L_0x00b1:
            boolean r9 = android.text.TextUtils.isEmpty(r4)
            if (r9 != 0) goto L_0x00c0
            android.webkit.MimeTypeMap r9 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r9 = r9.getMimeTypeFromExtension(r4)
            goto L_0x00c2
        L_0x00c0:
            java.lang.String r9 = "application/octet-stream"
        L_0x00c2:
            okhttp3.MediaType r9 = okhttp3.MediaType.parse(r9)
            okhttp3.RequestBody r9 = okhttp3.RequestBody.create(r9, r1)
            java.lang.Class<com.twitter.sdk.android.core.services.MediaService> r1 = com.twitter.sdk.android.core.services.MediaService.class
            java.lang.Object r0 = r0.getService(r1)
            com.twitter.sdk.android.core.services.MediaService r0 = (com.twitter.sdk.android.core.services.MediaService) r0
            retrofit2.Call r9 = r0.upload(r9, r2, r2)
            r9.enqueue(r3)
            goto L_0x00de
        L_0x00da:
            throw r2
        L_0x00db:
            r8.uploadTweetWithMedia(r1, r0, r2)
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetcomposer.TweetUploadService.onHandleIntent(android.content.Intent):void");
    }

    public void uploadTweetWithMedia(TwitterSession twitterSession, String str, String str2) {
        if (this.dependencyProvider != null) {
            ((StatusesService) TwitterCore.getInstance().getApiClient(twitterSession).getService(StatusesService.class)).update(str, null, null, null, null, null, null, Boolean.TRUE, str2).enqueue(new Callback<Tweet>() {
                public void failure(TwitterException twitterException) {
                    TweetUploadService.this.fail(twitterException);
                }

                public void success(Result<Tweet> result) {
                    TweetUploadService tweetUploadService = TweetUploadService.this;
                    long j = ((Tweet) result.data).id;
                    if (tweetUploadService != null) {
                        Intent intent = new Intent("com.twitter.sdk.android.tweetcomposer.UPLOAD_SUCCESS");
                        intent.putExtra("EXTRA_TWEET_ID", j);
                        intent.setPackage(tweetUploadService.getApplicationContext().getPackageName());
                        tweetUploadService.sendBroadcast(intent);
                        TweetUploadService.this.stopSelf();
                        return;
                    }
                    throw null;
                }
            });
            return;
        }
        throw null;
    }
}
