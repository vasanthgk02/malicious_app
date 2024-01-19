package com.mpl.androidapp.game.disconnection;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.text.TextUtils;
import com.crimzoncode.tqcontests.util.TQConstants;
import com.mpl.androidapp.unity.features.InvokeMplFeatures;
import com.mpl.androidapp.utils.Constant.ApiEndPoints;
import com.mpl.androidapp.utils.GameConstant;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.encryptedPrefs.MEncryptedPrefUtils;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/mpl/androidapp/game/disconnection/GameDisconnection;", "", "context", "Landroid/content/Context;", "pResult", "Landroid/content/BroadcastReceiver$PendingResult;", "(Landroid/content/Context;Landroid/content/BroadcastReceiver$PendingResult;)V", "mContext", "mCrashFilePath", "", "pendingResult", "buildDisconnectionData", "", "contentArr", "", "gameDisconnectionHandling", "processFile", "file", "Ljava/io/File;", "sendGameDisconnectionData", "gameData", "gameConfig", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameDisconnection.kt */
public final class GameDisconnection {
    public final Context mContext;
    public final String mCrashFilePath;
    public final PendingResult pendingResult;

    public GameDisconnection(Context context, PendingResult pendingResult2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        this.pendingResult = pendingResult2;
        String str = null;
        File externalFilesDir = context.getExternalFilesDir(null);
        this.mCrashFilePath = Intrinsics.stringPlus(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : str, "/UTemp/Log.txt");
    }

    private final void buildDisconnectionData(List<String> list) {
        if (Intrinsics.areEqual(CharsKt__CharKt.trim(list.get(2)).toString(), "foreground")) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("GameId", list.get(0));
            jSONObject.put(TQConstants.SESSION_ID, list.get(1));
            jSONObject.put("BattleDisconnectionReason", "App Crash");
            MLogger.v("GameDisconnectionHandling", Intrinsics.stringPlus("Final game data json - ", jSONObject));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(GameConstant.AUTH_TOKEN, MSharedPreferencesUtils.getAccessUserToken());
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "gameDataJson.toString()");
            sendGameDisconnectionData(jSONObject3, jSONObject2.toString());
            MLogger.v("GameDisconnectionHandling", "gameDisconnectionHandling() called: scenario - App Crash");
        }
    }

    private final void processFile(File file) {
        StringBuilder sb;
        List split$default;
        Throwable th;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    String readLine = bufferedReader.readLine();
                    Intrinsics.checkNotNullExpressionValue(readLine, "reader.readLine()");
                    while (true) {
                        sb.append(readLine);
                        sb.append(10);
                        readLine = bufferedReader.readLine();
                        Intrinsics.checkNotNullExpressionValue(readLine, "reader.readLine()");
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    TweetUtils.closeFinally(bufferedReader, th);
                    throw th3;
                }
            } catch (IOException e2) {
                MLogger.e("GameDisconnectionHandling", Intrinsics.stringPlus("gameDisconnectionHandling() Exception: ", e2.getMessage()));
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
                MLogger.v("GameDisconnectionHandling", Intrinsics.stringPlus("file content ", sb2));
                if (sb2.length() > 0) {
                    String decrypt = Jumble.decrypt(sb2);
                    Intrinsics.checkNotNullExpressionValue(decrypt, "data");
                    if (decrypt.length() > 0) {
                        split$default = CharsKt__CharKt.split$default((CharSequence) decrypt, new String[]{"☮"}, false, 0, 6);
                        MLogger.v("GameDisconnectionHandling", "values saved in file " + ((String) split$default.get(0)) + " - " + ((String) split$default.get(1)) + " - " + ((String) split$default.get(2)));
                        buildDisconnectionData(split$default);
                    }
                }
            } catch (Exception e3) {
                MLogger.e("GameDisconnectionHandling", Intrinsics.stringPlus("gameDisconnectionHandling() Exception: ", e3.getMessage()));
                String sb3 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb3, "stringBuilder.toString()");
                MLogger.v("GameDisconnectionHandling", Intrinsics.stringPlus("file content ", sb3));
                if (sb3.length() > 0) {
                    String decrypt2 = Jumble.decrypt(sb3);
                    Intrinsics.checkNotNullExpressionValue(decrypt2, "data");
                    if (decrypt2.length() > 0) {
                        split$default = CharsKt__CharKt.split$default((CharSequence) decrypt2, new String[]{"☮"}, false, 0, 6);
                        MLogger.v("GameDisconnectionHandling", "values saved in file " + ((String) split$default.get(0)) + " - " + ((String) split$default.get(1)) + " - " + ((String) split$default.get(2)));
                        buildDisconnectionData(split$default);
                    }
                }
            }
        } catch (Exception e4) {
            MLogger.e("GameDisconnectionHandling", Intrinsics.stringPlus("gameDisconnectionHandling() Exception: ", e4.getMessage()));
        } catch (Throwable th4) {
            String sb4 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "stringBuilder.toString()");
            MLogger.v("GameDisconnectionHandling", Intrinsics.stringPlus("file content ", sb4));
            if (sb4.length() > 0) {
                String decrypt3 = Jumble.decrypt(sb4);
                Intrinsics.checkNotNullExpressionValue(decrypt3, "data");
                if (decrypt3.length() > 0) {
                    List split$default2 = CharsKt__CharKt.split$default((CharSequence) decrypt3, new String[]{"☮"}, false, 0, 6);
                    MLogger.v("GameDisconnectionHandling", "values saved in file " + ((String) split$default2.get(0)) + " - " + ((String) split$default2.get(1)) + " - " + ((String) split$default2.get(2)));
                    buildDisconnectionData(split$default2);
                }
            }
            throw th4;
        }
    }

    public final void gameDisconnectionHandling() throws JSONException {
        JSONObject jSONObject;
        MEncryptedPrefUtils mEncryptedPrefUtils = MEncryptedPrefUtils.INSTANCE;
        Context applicationContext = this.mContext.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "mContext.applicationContext");
        mEncryptedPrefUtils.init(applicationContext);
        MLogger.v("GameDisconnectionHandling", "gameDisconnectionHandling() called ");
        if (!TextUtils.isEmpty(MEncryptedPrefUtils.INSTANCE.getGameBattleId())) {
            MLogger.v("GameDisconnectionHandling", Intrinsics.stringPlus("gameDisconnectionHandling() called with battle id ", MEncryptedPrefUtils.INSTANCE.getGameBattleId()));
            Boolean gameFocusState = MEncryptedPrefUtils.INSTANCE.getGameFocusState();
            Intrinsics.checkNotNull(gameFocusState);
            boolean booleanValue = gameFocusState.booleanValue();
            String gameData = MEncryptedPrefUtils.INSTANCE.getGameData();
            if (TextUtils.isEmpty(gameData)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(gameData);
            }
            Boolean forceUploadFlag = MEncryptedPrefUtils.INSTANCE.getForceUploadFlag();
            Intrinsics.checkNotNull(forceUploadFlag);
            if (forceUploadFlag.booleanValue()) {
                MLogger.v("GameDisconnectionHandling", "gameDisconnectionHandling() called: scenario - Force upload");
            } else if (!TextUtils.isEmpty(gameData) && !booleanValue) {
                jSONObject.put("BattleDisconnectionReason", "User Led App Kill");
                MLogger.v("GameDisconnectionHandling", "gameDisconnectionHandling() called: scenario - User Led App Kill");
            } else if (!booleanValue) {
                jSONObject.put("BattleDisconnectionReason", "User Led App Kill");
                MLogger.v("GameDisconnectionHandling", "gameDisconnectionHandling() called: scenario - User Led App Kill");
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "gameDataJson.toString()");
            sendGameDisconnectionData(jSONObject2, MEncryptedPrefUtils.INSTANCE.getGameConfig());
            return;
        }
        File file = new File(this.mCrashFilePath);
        if (file.exists()) {
            processFile(file);
        }
    }

    public final void sendGameDisconnectionData(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "gameData");
        MLogger.v("GameDisconnectionHandling", "sendGameDisconnectionData() called ");
        InvokeMplFeatures.INSTANCE.sendEventForGamesFeature(this.mContext.getApplicationContext(), "Connection Lost", str, str2, ApiEndPoints.ALL_GAMES_DISCONNECTION_EVENT, new GameDisconnection$sendGameDisconnectionData$1(this));
    }
}
