package com.mpl.androidapp.react;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.inca.security.Proxy.iIiIiIiIii;
import com.mpl.androidapp.R;
import com.mpl.androidapp.share.ct.CtShareEventConstants.ShareEventShareInitiated;
import com.mpl.androidapp.updater.repo.DownloadProgressReceiver;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.Constant.VideoRecordingConstants;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.NetworkCallParams;
import com.mpl.androidapp.utils.NetworkCallParams.Builder;
import com.mpl.androidapp.utils.NetworkUtils;
import com.mpl.androidapp.utils.VideoRecordingUtils;
import com.mpl.network.modules.engine.MHeader;
import com.mpl.network.modules.listeners.IResponseListener;
import com.mpl.securepreferences.MPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookShareActivity extends Activity {
    public static final String TAG = "FacebookShareActivity___";
    public CallbackManager mCallBackManager;
    public String mEntryPoint = "Rank Results";
    public final Set<String> readPermissions = new HashSet();

    public static Intent createIntent(Context context) {
        return new Intent(context, FacebookShareActivity.class);
    }

    public void getCurrentActivity() {
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) getSystemService("activity");
            if (activityManager == null) {
                str = "";
            } else if (VERSION.SDK_INT >= 23) {
                str = "";
                for (AppTask taskInfo : activityManager.getAppTasks()) {
                    str = taskInfo.getTaskInfo().topActivity.getClassName();
                }
            } else {
                String str2 = "";
                for (RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(1)) {
                    str2 = runningTaskInfo.topActivity.getClassName();
                }
            }
            if (str.contains("PlatformWrapperActivity")) {
                MLogger.i(TAG, "Video shared on facebook", str);
                postDataToServer(MPreferences.getString(VideoRecordingConstants.GAME_RECORDING_DATA, "", false));
                startClosingTimer();
                return;
            }
            MLogger.i(TAG, "Video did not shared on facebook till now", str);
        } catch (Throwable th) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Throwable caught: ");
            outline73.append(th.getMessage());
            MLogger.i(TAG, outline73.toString(), th);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isHavingReadVideoPermission(AccessToken accessToken) {
        return isUserLoggedIn() && accessToken.permissions.contains("user_videos");
    }

    /* access modifiers changed from: 0000 */
    public boolean isUserLoggedIn() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        return currentAccessToken != null && !currentAccessToken.isExpired();
    }

    public /* synthetic */ void lambda$onCreate$0$FacebookShareActivity(View view) {
        VideoRecordingUtils.toggleVideoFTUETutorialShownStatus(true);
        setTheme(R.style.AppThemeUnity);
        setContentView(R.layout.activity_facebook_share_loader);
        startShareLogin();
    }

    public /* synthetic */ boolean lambda$startClosingTimer$1$FacebookShareActivity(Message message) {
        MLogger.d(TAG, "handleMessage: ");
        Intent createIntent = createIntent(this);
        createIntent.putExtra("flag", "killMe");
        createIntent.addFlags(PDChoice.FLAG_COMMIT_ON_SEL_CHANGE);
        createIntent.addFlags(65536);
        startActivity(createIntent);
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void logInWithReadPermissions(final boolean z) {
        if (!isUserLoggedIn()) {
            sendFacebookLoginInitiatedEvent();
        }
        LoginManager.getInstance().registerCallback(this.mCallBackManager, new FacebookCallback<LoginResult>() {
            public void onCancel() {
                MLogger.d(FacebookShareActivity.TAG, "onCancel");
                FacebookShareActivity.this.sendFacebookLoginCompletedEvent(false);
                if (z) {
                    Toast.makeText(FacebookShareActivity.this.getApplicationContext(), "Login required for sharing", 0).show();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("data", false);
                    DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
                    if (downloadProgressReceiver != null) {
                        downloadProgressReceiver.send(6, bundle);
                    }
                }
                FacebookShareActivity.this.finish();
            }

            public void onError(FacebookException facebookException) {
                MLogger.e(FacebookShareActivity.TAG, "onError: ", facebookException);
                FacebookShareActivity.this.sendFacebookLoginCompletedEvent(false);
                if (facebookException.toString().contains("Application request limit reached")) {
                    Bundle outline14 = GeneratedOutlineSupport.outline14("failed_reason", "Login Failed");
                    DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
                    if (downloadProgressReceiver != null) {
                        downloadProgressReceiver.send(7, outline14);
                    }
                    FacebookShareActivity.this.finish();
                } else if (z) {
                    Toast.makeText(FacebookShareActivity.this.getApplicationContext(), facebookException.getMessage(), 1).show();
                    LoginManager.getInstance().logOut();
                    FacebookShareActivity.this.logInWithReadPermissions(z);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("data", false);
                    DownloadProgressReceiver downloadProgressReceiver2 = MPLReactContainerActivity.resultReceiver;
                    if (downloadProgressReceiver2 != null) {
                        downloadProgressReceiver2.send(6, bundle);
                    }
                    FacebookShareActivity.this.finish();
                }
            }

            public void onSuccess(LoginResult loginResult) {
                AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                MLogger.d(FacebookShareActivity.TAG, "onSuccess() called with: loginResult =", Boolean.valueOf(loginResult.accessToken.isExpired()));
                FacebookShareActivity.this.sendFacebookLoginCompletedEvent(true);
                if (FacebookShareActivity.this.isHavingReadVideoPermission(currentAccessToken)) {
                    VideoRecordingUtils.setFacebookAccessToken(currentAccessToken.token);
                    VideoRecordingUtils.setFacebookId(currentAccessToken.userId);
                    if (z) {
                        FacebookShareActivity.this.shareVideo(currentAccessToken);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("data", true);
                    DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
                    if (downloadProgressReceiver != null) {
                        downloadProgressReceiver.send(6, bundle);
                    }
                    FacebookShareActivity.this.finish();
                    return;
                }
                Toast.makeText(FacebookShareActivity.this.getApplicationContext(), "Does not having permissions", 0).show();
            }
        });
        LoginManager.getInstance().logInWithReadPermissions(this, this.readPermissions);
    }

    public void loginFacebook(boolean z) {
        this.readPermissions.clear();
        this.readPermissions.add("user_videos");
        logInWithReadPermissions(z);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.mCallBackManager.onActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, -735008275, bundle);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MLogger.d(TAG, "onDetachedFromWindow() called");
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MLogger.d(TAG, "onNewIntent: ");
        if (getIntent().getStringExtra("flag") != null && getIntent().getStringExtra("flag").equalsIgnoreCase("killMe")) {
            DownloadProgressReceiver downloadProgressReceiver = MPLReactContainerActivity.resultReceiver;
            if (downloadProgressReceiver != null) {
                downloadProgressReceiver.send(4, null);
            }
            MLogger.d(TAG, "onNewIntent: finishing activity");
            finish();
        }
    }

    public void onPause() {
        iIiIiIiIii.IiiiIiiiII(this, -1677004594, new Object[0]);
    }

    public void onStart() {
        iIiIiIiIii.IiiiIiiiII(this, 504659668, new Object[0]);
    }

    public void onStop() {
        iIiIiIiIii.IiiiIiiiII(this, -563898080, new Object[0]);
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        MLogger.d(TAG, "onUserInteraction() called");
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        MLogger.d(TAG, "onWindowFocusChanged() called with: hasFocus = [" + z + CMapParser.MARK_END_OF_ARRAY);
    }

    /* access modifiers changed from: 0000 */
    public void postDataToServer(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put(VideoRecordingConstants.FACEBOOK_ID, VideoRecordingUtils.getFacebookId());
            jSONObject.put("accessToken", VideoRecordingUtils.getFacebookAccessToken());
            str = jSONObject.toString();
        } catch (JSONException e2) {
            MLogger.i(TAG, "postDataToServer", e2);
        }
        MLogger.i(TAG, "postDataToServer", str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MHeader("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE));
        arrayList.add(new MHeader("X-INJECTED-APP-TYPE", MBuildConfigUtils.isCashApp() ? "CASH" : "PLAY_STORE"));
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Bearer ");
        outline73.append(MSharedPreferencesUtils.getAccessUserToken());
        arrayList.add(new MHeader("Authorization", outline73.toString()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MLogger.i(TAG, "postDataToServer", ((MHeader) it.next()).toString());
        }
        NetworkCallParams build = new Builder().setUrl(VideoRecordingUtils.getPostUrlForVideoSharing()).setConnectionTimeOut(10000).setWriteTimeOut(10000).setReadTimeOut(10000).setMHeaders(arrayList).setRetryOption(true).setMRequestBody(str).build();
        AnonymousClass3 r0 = new IResponseListener<String>() {
            public void onResponseFail(Exception exc) {
                MLogger.d(IResponseListener.TAG, "onResponseFail() called with: ex = [" + exc + CMapParser.MARK_END_OF_ARRAY);
            }

            public void progressResponse(long j, long j2, boolean z) {
                StringBuilder outline76 = GeneratedOutlineSupport.outline76("progressResponse() called with: bytesRead = [", j, "], contentLength = [");
                outline76.append(j2);
                outline76.append("], done = [");
                outline76.append(z);
                outline76.append(CMapParser.MARK_END_OF_ARRAY);
                MLogger.d(IResponseListener.TAG, outline76.toString());
            }

            public void onResponseSuccess(String str) {
                MLogger.d(IResponseListener.TAG, GeneratedOutlineSupport.outline52("onResponseSuccess() called with: o = [", str, CMapParser.MARK_END_OF_ARRAY));
            }
        };
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("upload_video");
        outline732.append(System.currentTimeMillis());
        NetworkUtils.doPostRequest(build, r0, outline732.toString());
    }

    /* access modifiers changed from: 0000 */
    public void sendFacebookLoginCompletedEvent(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("Entry Point", this.mEntryPoint);
        hashMap.put("Is Success", Boolean.valueOf(z));
        CleverTapAnalyticsUtils.sendEvent((String) "Facebook Login Completed", hashMap);
    }

    /* access modifiers changed from: 0000 */
    public void sendFacebookLoginInitiatedEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put("Entry Point", this.mEntryPoint);
        CleverTapAnalyticsUtils.sendEvent((String) "Facebook Login Initiated", hashMap);
    }

    /* access modifiers changed from: 0000 */
    public void sendVideoUploadInitiatedEvent() {
        HashMap hashMap = new HashMap(MSharedPreferencesUtils.getUserProfileEventParams());
        hashMap.putAll(VideoRecordingUtils.getRecordedVideoEventProp());
        hashMap.put(ShareEventShareInitiated.PROPERTY_SHARE_CHANNEL, "Facebook");
        hashMap.put("Entry Point", this.mEntryPoint);
        hashMap.put("Cash Bonus Offered", VideoRecordingUtils.getVideoSharingBonusCashFBFromConfig());
        hashMap.put("Token Bonus Offered", VideoRecordingUtils.getVideoSharingBonusTokenFBFromConfig());
        hashMap.put("Is Facebook Logged In", Boolean.valueOf(!TextUtils.isEmpty(VideoRecordingUtils.getFacebookAccessToken())));
        CleverTapAnalyticsUtils.sendEvent((String) "Video Upload Initiated", hashMap);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:8|9|10|(2:13|11)|44|14|15|(2:17|18)(6:19|20|21|22|(3:24|25|26)(1:27)|28)|29|30|33|(1:35)|36|(1:38)|39|(1:41)(1:42)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0114 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void shareVideo(com.facebook.AccessToken r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.String r2 = "recorded_video_path"
            java.lang.String r3 = ""
            r4 = 0
            java.lang.String r2 = com.mpl.securepreferences.MPreferences.getString(r2, r3, r4)
            java.lang.String r5 = "recordedVideoHash"
            r6 = 1
            java.lang.String r5 = com.mpl.securepreferences.MPreferences.getString(r5, r3, r6)
            java.lang.String r7 = "video_length"
            r8 = 0
            long r7 = com.mpl.securepreferences.MPreferences.getLong(r7, r8, r6)
            r9 = 4
            java.lang.Object[] r10 = new java.lang.Object[r9]
            java.lang.String r11 = "publishVideo() path"
            r10[r4] = r11
            r10[r6] = r2
            java.lang.Long r12 = java.lang.Long.valueOf(r7)
            r13 = 2
            r10[r13] = r12
            r12 = 3
            r10[r12] = r5
            java.lang.String r14 = "FacebookShareActivity___"
            com.mpl.androidapp.utils.MLogger.d(r14, r10)
            boolean r10 = android.text.TextUtils.isEmpty(r2)
            if (r10 == 0) goto L_0x003b
            return
        L_0x003b:
            java.io.File r10 = new java.io.File
            r10.<init>(r2)
            java.lang.String r15 = com.mpl.androidapp.updater.gameengine.GEInteractor.getMd5OfFile(r2)
            boolean r5 = r15.equals(r5)
            if (r5 != 0) goto L_0x0065
            long r15 = r10.length()
            int r5 = (r15 > r7 ? 1 : (r15 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x0053
            goto L_0x0065
        L_0x0053:
            android.content.Context r0 = r17.getApplicationContext()
            java.lang.String r2 = "File is modified"
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r4)
            r0.show()
            r17.finish()
            goto L_0x01a0
        L_0x0065:
            java.lang.String r5 = r0.userId
            r7 = 6
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r4] = r11
            r7[r6] = r2
            java.lang.String r2 = " accessToken: "
            r7[r13] = r2
            r7[r12] = r0
            java.lang.String r0 = " userId: "
            r7[r9] = r0
            r0 = 5
            r7[r0] = r5
            com.mpl.androidapp.utils.MLogger.d(r14, r7)
            com.facebook.share.model.ShareVideo$Builder r0 = new com.facebook.share.model.ShareVideo$Builder
            r0.<init>()
            android.net.Uri r2 = android.net.Uri.fromFile(r10)
            r0.localUrl = r2
            com.facebook.share.model.ShareVideo r2 = r0.build()
            r5 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0131 }
            r0.<init>()     // Catch:{ JSONException -> 0x0131 }
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0131 }
            java.lang.String r8 = com.mpl.androidapp.utils.VideoRecordingUtils.getVideoTagsFromConfig()     // Catch:{ JSONException -> 0x0131 }
            r7.<init>(r8)     // Catch:{ JSONException -> 0x0131 }
            r8 = 0
        L_0x009d:
            int r9 = r7.length()     // Catch:{ JSONException -> 0x0131 }
            if (r8 >= r9) goto L_0x00ad
            java.lang.String r9 = r7.getString(r8)     // Catch:{ JSONException -> 0x0131 }
            r0.append(r9)     // Catch:{ JSONException -> 0x0131 }
            int r8 = r8 + 1
            goto L_0x009d
        L_0x00ad:
            boolean r7 = com.mpl.androidapp.utils.VideoRecordingUtils.shouldTakeExtraTextFromConfig()     // Catch:{ JSONException -> 0x0131 }
            java.lang.String r8 = "  "
            if (r7 == 0) goto L_0x00c0
            r0.append(r8)     // Catch:{ JSONException -> 0x0131 }
            java.lang.String r7 = com.mpl.androidapp.utils.VideoRecordingUtils.getVideoFeatureTagsFromConfig()     // Catch:{ JSONException -> 0x0131 }
            r0.append(r7)     // Catch:{ JSONException -> 0x0131 }
            goto L_0x0114
        L_0x00c0:
            java.lang.String r7 = "game_recording_data"
            java.lang.String r7 = com.mpl.securepreferences.MPreferences.getString(r7, r3, r4)     // Catch:{ Exception -> 0x0114 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0114 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r7 = com.mpl.androidapp.utils.VideoRecordingUtils.getAutoFillExtraTextFromConfig()     // Catch:{ Exception -> 0x0114 }
            boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r11 = "score"
            java.lang.String r12 = "gameName"
            if (r10 == 0) goto L_0x00ee
            java.lang.String r7 = "Watch me play %1$s and score %2$s on MPL!"
            java.lang.Object[] r10 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x0114 }
            java.lang.String r12 = r9.optString(r12)     // Catch:{ Exception -> 0x0114 }
            r10[r4] = r12     // Catch:{ Exception -> 0x0114 }
            java.lang.String r9 = r9.optString(r11)     // Catch:{ Exception -> 0x0114 }
            r10[r6] = r9     // Catch:{ Exception -> 0x0114 }
            java.lang.String r7 = java.lang.String.format(r7, r10)     // Catch:{ Exception -> 0x0114 }
            goto L_0x010e
        L_0x00ee:
            java.lang.String r10 = "{Game_Name}"
            java.lang.String r12 = r9.optString(r12)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r7 = r7.replace(r10, r12)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r10 = "{TOURNAMENT_NAME}"
            java.lang.String r12 = "tournamentName"
            java.lang.String r12 = r9.optString(r12)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r7 = r7.replace(r10, r12)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r10 = "{SCORE}"
            java.lang.String r9 = r9.optString(r11)     // Catch:{ Exception -> 0x0114 }
            java.lang.String r7 = r7.replace(r10, r9)     // Catch:{ Exception -> 0x0114 }
        L_0x010e:
            r0.append(r8)     // Catch:{ Exception -> 0x0114 }
            r0.append(r7)     // Catch:{ Exception -> 0x0114 }
        L_0x0114:
            com.facebook.share.model.ShareHashtag$Builder r7 = new com.facebook.share.model.ShareHashtag$Builder     // Catch:{ JSONException -> 0x0131 }
            r7.<init>()     // Catch:{ JSONException -> 0x0131 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0131 }
            r8.<init>()     // Catch:{ JSONException -> 0x0131 }
            java.lang.String r9 = "#"
            r8.append(r9)     // Catch:{ JSONException -> 0x0131 }
            r8.append(r0)     // Catch:{ JSONException -> 0x0131 }
            java.lang.String r0 = r8.toString()     // Catch:{ JSONException -> 0x0131 }
            r7.hashtag = r0     // Catch:{ JSONException -> 0x0131 }
            com.facebook.share.model.ShareHashtag r0 = r7.build()     // Catch:{ JSONException -> 0x0131 }
            goto L_0x013c
        L_0x0131:
            r0 = move-exception
            java.lang.Object[] r7 = new java.lang.Object[r13]
            r7[r4] = r3
            r7[r6] = r0
            com.mpl.androidapp.utils.MLogger.e(r14, r7)
            r0 = r5
        L_0x013c:
            com.facebook.share.model.ShareVideoContent$Builder r3 = new com.facebook.share.model.ShareVideoContent$Builder
            r3.<init>()
            java.lang.String r7 = "Watch my game play"
            r3.contentDescription = r7
            java.lang.String r7 = "MPL"
            r3.contentTitle = r7
            com.facebook.share.model.ShareVideo$Builder r7 = new com.facebook.share.model.ShareVideo$Builder
            r7.<init>()
            android.net.Uri r2 = r2.localUrl
            r7.localUrl = r2
            com.facebook.share.model.ShareVideo r2 = r7.build()
            r3.video = r2
            if (r0 == 0) goto L_0x015c
            r3.hashtag = r0
        L_0x015c:
            com.facebook.share.model.ShareVideoContent r0 = new com.facebook.share.model.ShareVideoContent
            r0.<init>(r3, r5)
            com.facebook.share.widget.ShareDialog r2 = new com.facebook.share.widget.ShareDialog
            r2.<init>(r1)
            com.facebook.CallbackManager r3 = r1.mCallBackManager
            com.mpl.androidapp.react.FacebookShareActivity$2 r5 = new com.mpl.androidapp.react.FacebookShareActivity$2
            r5.<init>()
            r2.registerCallback(r3, r5)
            r2.shouldFailOnDataError = r6
            com.facebook.share.widget.ShareDialog$Mode r3 = com.facebook.share.widget.ShareDialog.Mode.AUTOMATIC
            java.lang.String r5 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
            java.lang.String r5 = "mode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            com.facebook.share.widget.ShareDialog$Mode r5 = com.facebook.share.widget.ShareDialog.Mode.AUTOMATIC
            if (r3 != r5) goto L_0x0184
            java.lang.Object r3 = com.facebook.internal.FacebookDialogBase.BASE_AUTOMATIC_MODE
        L_0x0184:
            boolean r3 = r2.canShowImpl(r0, r3)
            if (r3 == 0) goto L_0x0193
            r17.sendVideoUploadInitiatedEvent()
            com.facebook.share.widget.ShareDialog$Mode r3 = com.facebook.share.widget.ShareDialog.Mode.AUTOMATIC
            r2.show(r0, r3)
            goto L_0x01a0
        L_0x0193:
            android.content.Context r0 = r17.getApplicationContext()
            java.lang.String r2 = "Share can not possible.Please Login with valid user"
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r4)
            r0.show()
        L_0x01a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.react.FacebookShareActivity.shareVideo(com.facebook.AccessToken):void");
    }

    public void startClosingTimer() {
        new Handler(new Callback() {
            public final boolean handleMessage(Message message) {
                return FacebookShareActivity.this.lambda$startClosingTimer$1$FacebookShareActivity(message);
            }
        }).sendEmptyMessageDelayed(0, (long) VideoRecordingUtils.getMaxWaitTimeForSharingFromConfig());
    }

    /* access modifiers changed from: 0000 */
    public void startShareLogin() {
        boolean z = getIntent().getStringExtra("flag") != null && getIntent().getStringExtra("flag").equalsIgnoreCase("share");
        if (!TextUtils.isEmpty(getIntent().getStringExtra("entryPoint"))) {
            this.mEntryPoint = getIntent().getStringExtra("entryPoint");
        }
        loginFacebook(z);
    }
}
