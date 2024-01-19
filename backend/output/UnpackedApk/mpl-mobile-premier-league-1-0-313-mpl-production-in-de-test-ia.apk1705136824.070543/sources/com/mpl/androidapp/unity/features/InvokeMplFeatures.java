package com.mpl.androidapp.unity.features;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.cfg.mendikot.app.CFGMendikot;
import com.cfg.mendikot.app.SDKConfig;
import com.google.gson.Gson;
import com.mpl.androidapp.R;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.data.implementation.modules.UnityCrashModule;
import com.mpl.androidapp.cleanarch.features.unitycrashanalytics.di.entrypoints.UnityCrashModuleEntryPoint;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.filehandling.downloadservice.features.GenericFileDownloadFeature.GenericFileDownloadFeatureCallback;
import com.mpl.androidapp.filehandling.downloadservice.models.FeatureFileDownloadInput;
import com.mpl.androidapp.game.androidgames.cardGame.CardGameFeature;
import com.mpl.androidapp.model.UnityMiniProfileData;
import com.mpl.androidapp.notification.features.NotificationFeatureInputs;
import com.mpl.androidapp.react.MPLReactContainerActivity.GameEventCallback;
import com.mpl.androidapp.share.MplShareFeature;
import com.mpl.androidapp.share.deeplink.DeepLinkObjects;
import com.mpl.androidapp.share.models.ShareData;
import com.mpl.androidapp.unity.di.entrypoints.MplUnityFeaturesEntryPoint;
import com.mpl.androidapp.unity.di.entrypoints.UnityShareImageEntryPoint;
import com.mpl.androidapp.unity.models.CrashParams;
import com.mpl.androidapp.unity.models.UnityScreenShotParams;
import com.mpl.androidapp.unity.models.UnitySendEventGameParams;
import com.mpl.androidapp.unity.views.UnityMiniProfileActivity;
import com.mpl.androidapp.utils.GameConstant;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004JG\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J.\u0010\u001c\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004J\u001e\u0010 \u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010*\u001a\u00020+H\u0002J\u000e\u0010,\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010-\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0004J\u001e\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0004J.\u00104\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u0002022\u0006\u00105\u001a\u0002022\u0006\u00106\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J@\u00107\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u00108\u001a\u0004\u0018\u00010\u00042\b\u00109\u001a\u0004\u0018\u00010\u00042\b\u0010:\u001a\u0004\u0018\u00010\u00042\b\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010<\u001a\u00020=J6\u0010>\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u0002022\u0006\u0010?\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004J6\u0010B\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u0002022\u0006\u0010?\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0004J6\u0010D\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u0002022\u0006\u0010?\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004J\u0010\u0010E\u001a\u00020F2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001e\u0010G\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010H\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u001e\u0010I\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/mpl/androidapp/unity/features/InvokeMplFeatures;", "", "()V", "tag", "", "crashInterceptedExceptionHandler", "", "context", "Landroid/content/Context;", "data", "battleId", "message", "createScreenShotFileFeature", "screenName", "gameName", "activity", "Landroid/app/Activity;", "decorView", "Landroid/view/ViewGroup;", "isScreenshotUiDisabled", "", "isScreenShotOptions", "(Ljava/lang/String;Ljava/lang/String;Landroid/app/Activity;Landroid/view/ViewGroup;Ljava/lang/Boolean;Ljava/lang/String;)V", "createUnityFeatureInstance", "Lcom/mpl/androidapp/unity/features/MplUnityFeatures;", "mContext", "hiltEntryPoint", "Lcom/mpl/androidapp/unity/di/entrypoints/MplUnityFeaturesEntryPoint;", "firebaseCrashLogFeature", "msg", "stacktrace", "gameId", "genericFileDownloadFeature", "featureFileDownloadInput", "Lcom/mpl/androidapp/filehandling/downloadservice/models/FeatureFileDownloadInput;", "view", "Lcom/mpl/androidapp/filehandling/downloadservice/features/GenericFileDownloadFeature$GenericFileDownloadFeatureCallback;", "getRamAvailabilityForUnity", "availableRAMInMB", "", "availableRAMInPercentage", "invokeShare", "shareData", "Lcom/mpl/androidapp/share/models/ShareData;", "isUnityCrashFeatureEnabled", "launchMiniProfile", "gameData", "launchNativeGames", "applicationContext", "gameid", "", "gamedata", "notificationForUgcShare", "tournamentId", "title", "sendEventForGamesFeature", "event", "eventProp", "gameConfigJson", "url", "callback", "Lcom/mpl/androidapp/react/MPLReactContainerActivity$GameEventCallback;", "shareEventForGames", "launchFrom", "platform", "shareMessage", "shareImageToSocial", "imageLocation", "shareTextToSocial", "unityCrashFeatureInstance", "Lcom/mpl/androidapp/cleanarch/features/unitycrashanalytics/data/implementation/modules/UnityCrashModule;", "unityGameClosed", "unityGameInstantiated", "unityGameUpdated", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InvokeMplFeatures.kt */
public final class InvokeMplFeatures {
    public static final InvokeMplFeatures INSTANCE = new InvokeMplFeatures();
    public static final String tag = "InvokeMplFeatures";

    private final MplUnityFeatures createUnityFeatureInstance(Context context, MplUnityFeaturesEntryPoint mplUnityFeaturesEntryPoint) {
        Context context2 = context;
        MplUnityFeatures mplUnityFeatures = new MplUnityFeatures(context2, mplUnityFeaturesEntryPoint.GenericFileDownloadFeature(), mplUnityFeaturesEntryPoint.LogCrashAnalyticsUseCase(), mplUnityFeaturesEntryPoint.CreateUnityScreenShotUseCase(), mplUnityFeaturesEntryPoint.SendEventForGamesUseCase(), mplUnityFeaturesEntryPoint.NotificationUgcFeature(), mplUnityFeaturesEntryPoint.ioDispatcher());
        return mplUnityFeatures;
    }

    private final void invokeShare(Context context, ShareData shareData) {
        Object obj = TweetUtils.get(TweetUtils.getApplication(context.getApplicationContext()), UnityShareImageEntryPoint.class);
        Intrinsics.checkNotNullExpressionValue(obj, "fromApplication(\n       …int::class.java\n        )");
        UnityShareImageEntryPoint unityShareImageEntryPoint = (UnityShareImageEntryPoint) obj;
        MplShareFeature mplShareFeature = new MplShareFeature(context, unityShareImageEntryPoint.MplShareRepository(), unityShareImageEntryPoint.CheckSharePlatformIsPresent(), unityShareImageEntryPoint.PrepareShareIntent(), unityShareImageEntryPoint.ioDispatcher());
        mplShareFeature.setShareConditions(shareData);
        mplShareFeature.runFeature();
    }

    private final UnityCrashModule unityCrashFeatureInstance(Context context) {
        Object obj = TweetUtils.get(TweetUtils.getApplication(context.getApplicationContext()), UnityCrashModuleEntryPoint.class);
        Intrinsics.checkNotNullExpressionValue(obj, "fromApplication(context,…leEntryPoint::class.java)");
        UnityCrashModuleEntryPoint unityCrashModuleEntryPoint = (UnityCrashModuleEntryPoint) obj;
        return new UnityCrashModule(unityCrashModuleEntryPoint.unityCrashImplService(), unityCrashModuleEntryPoint.loggerFeatureService(), unityCrashModuleEntryPoint.configService(), unityCrashModuleEntryPoint.ioDispatcher());
    }

    public final void crashInterceptedExceptionHandler(Context context, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "data");
        Intrinsics.checkNotNullParameter(str2, WebViewGameVm.KEY_BATTLE_ID);
        Intrinsics.checkNotNullParameter(str3, "message");
        unityCrashFeatureInstance(context).crashInterceptedExceptionHandler(str, str2, str3);
    }

    public final void createScreenShotFileFeature(String str, String str2, Activity activity, ViewGroup viewGroup, Boolean bool, String str3) {
        if (str != null && str2 != null && activity != null && viewGroup != null && bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (str3 != null) {
                UnityScreenShotParams unityScreenShotParams = new UnityScreenShotParams(str, str2, activity, viewGroup, booleanValue, str3);
                Object obj = TweetUtils.get(TweetUtils.getApplication(activity.getApplicationContext()), MplUnityFeaturesEntryPoint.class);
                Intrinsics.checkNotNullExpressionValue(obj, "fromApplication(\n       …int::class.java\n        )");
                createUnityFeatureInstance(activity, (MplUnityFeaturesEntryPoint) obj).createScreenShotFileFeature(unityScreenShotParams);
            }
        }
    }

    public final void firebaseCrashLogFeature(Context context, String str, String str2, String str3) {
        if (context != null && str != null && str2 != null && str3 != null) {
            StringBuilder outline82 = GeneratedOutlineSupport.outline82("logCrashlytics:called ", str, "stacktrace", str2, "gameid");
            outline82.append(str3);
            MLogger.e(tag, outline82.toString());
            CrashParams crashParams = new CrashParams(str, str2, str3);
            Object obj = TweetUtils.get(TweetUtils.getApplication(context.getApplicationContext()), MplUnityFeaturesEntryPoint.class);
            Intrinsics.checkNotNullExpressionValue(obj, "fromApplication(\n       …int::class.java\n        )");
            createUnityFeatureInstance(context, (MplUnityFeaturesEntryPoint) obj).logCrashIntoCrashlyticsFeature(crashParams);
        }
    }

    public final void genericFileDownloadFeature(Context context, FeatureFileDownloadInput featureFileDownloadInput, GenericFileDownloadFeatureCallback genericFileDownloadFeatureCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(featureFileDownloadInput, "featureFileDownloadInput");
        Intrinsics.checkNotNullParameter(genericFileDownloadFeatureCallback, "view");
        Object obj = TweetUtils.get(TweetUtils.getApplication(context.getApplicationContext()), MplUnityFeaturesEntryPoint.class);
        Intrinsics.checkNotNullExpressionValue(obj, "fromApplication(mContext…esEntryPoint::class.java)");
        createUnityFeatureInstance(context, (MplUnityFeaturesEntryPoint) obj).genericFileDownloadFeature(featureFileDownloadInput, genericFileDownloadFeatureCallback);
    }

    public final String getRamAvailabilityForUnity(double d2, double d3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(GameConstant.AVAILABLE_RAM_IN_MB, d2);
            jSONObject.put(GameConstant.AVAILABLE_RAM_IN_PERCENTAGE, d3);
            MLogger.d(tag, "RAM_Availability: before Return  ", jSONObject.toString());
        } catch (JSONException e2) {
            MLogger.e(tag, "RAM_Availability: _Exception: ", e2.getLocalizedMessage());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   …   }\n        }.toString()");
        return jSONObject2;
    }

    public final boolean isUnityCrashFeatureEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return unityCrashFeatureInstance(context).isUnityCrashFeatureEnabled();
    }

    public final void launchMiniProfile(Context context, String str) {
        UnityMiniProfileData unityMiniProfileData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "gameData");
        try {
            unityMiniProfileData = (UnityMiniProfileData) new Gson().fromJson(str, UnityMiniProfileData.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            unityMiniProfileData = null;
        }
        if (unityMiniProfileData != null) {
            Intent intent = new Intent(context, UnityMiniProfileActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable(UnityMiniProfileActivity.UNITY_PROFILE_DATA, unityMiniProfileData);
            intent.putExtra(UnityMiniProfileActivity.UNITY_PROFILE_DATA_BUNDLE, bundle);
            context.startActivity(intent);
        }
    }

    public final void launchNativeGames(Context context, int i, String str) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        Intrinsics.checkNotNullParameter(str, "gamedata");
        if (i == 1002030) {
            CFGMendikot cFGMendikot = CFGMendikot.get();
            Intrinsics.checkNotNullExpressionValue(cFGMendikot, "get()");
            CardGameFeature cardGameFeature = new CardGameFeature(context, cFGMendikot, str, new SDKConfig(), new Gson());
            cardGameFeature.launchMindikotGame();
        }
    }

    public final void notificationForUgcShare(Context context, int i, int i2, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Object obj = TweetUtils.get(TweetUtils.getApplication(context.getApplicationContext()), MplUnityFeaturesEntryPoint.class);
        Intrinsics.checkNotNullExpressionValue(obj, "fromApplication(mContext…esEntryPoint::class.java)");
        createUnityFeatureInstance(context, (MplUnityFeaturesEntryPoint) obj).sendNotificationForUgcFeature(NotificationFeatureInputs.INSTANCE.ugcNotificationFeatureInput(i, i2, str, str2));
    }

    public final void sendEventForGamesFeature(Context context, String str, String str2, String str3, String str4, GameEventCallback gameEventCallback) {
        Intrinsics.checkNotNullParameter(gameEventCallback, "callback");
        if (context != null && str != null && str2 != null && str3 != null && str4 != null) {
            UnitySendEventGameParams unitySendEventGameParams = new UnitySendEventGameParams(str, str2, str3, str4, gameEventCallback);
            Object obj = TweetUtils.get(TweetUtils.getApplication(context.getApplicationContext()), MplUnityFeaturesEntryPoint.class);
            Intrinsics.checkNotNullExpressionValue(obj, "fromApplication(mContext…esEntryPoint::class.java)");
            createUnityFeatureInstance(context, (MplUnityFeaturesEntryPoint) obj).sendEventForGamesFeature(unitySendEventGameParams);
        }
    }

    public final void shareEventForGames(Context context, int i, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "launchFrom");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, "platform");
        Intrinsics.checkNotNullParameter(str4, "shareMessage");
        invokeShare(context, DeepLinkObjects.INSTANCE.prepWebFlowGameTxtShare(i, str4, str, str2, str3));
    }

    public final void shareImageToSocial(Context context, int i, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "launchFrom");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, "platform");
        Intrinsics.checkNotNullParameter(str4, "imageLocation");
        String optString = ConfigManager.getNormalConfig().optString("unity.inApp.share.message", context.getString(R.string.share_default_message));
        DeepLinkObjects deepLinkObjects = DeepLinkObjects.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(optString, "shareMessage");
        invokeShare(context, deepLinkObjects.prepCodeMergeImgShare(i, optString, str, str2, str3, str4));
    }

    public final void shareTextToSocial(Context context, int i, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "launchFrom");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, "platform");
        Intrinsics.checkNotNullParameter(str4, "shareMessage");
        invokeShare(context, DeepLinkObjects.INSTANCE.prepWebFlowGameTxtShare(i, str4, str, str2, str3));
    }

    public final void unityGameClosed(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "data");
        Intrinsics.checkNotNullParameter(str2, WebViewGameVm.KEY_BATTLE_ID);
        unityCrashFeatureInstance(context).unityGameClosedNormally(str, str2);
    }

    public final void unityGameInstantiated(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "data");
        unityCrashFeatureInstance(context).unityGameInstantiated(str);
    }

    public final void unityGameUpdated(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "data");
        Intrinsics.checkNotNullParameter(str2, WebViewGameVm.KEY_BATTLE_ID);
        unityCrashFeatureInstance(context).unityGameUpdated(str, str2);
    }
}
