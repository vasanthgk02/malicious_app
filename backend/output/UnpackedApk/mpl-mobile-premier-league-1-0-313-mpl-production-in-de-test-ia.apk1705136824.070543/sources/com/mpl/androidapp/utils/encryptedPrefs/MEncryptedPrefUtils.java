package com.mpl.androidapp.utils.encryptedPrefs;

import android.content.Context;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\r\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\n\u001a\u0004\u0018\u00010\tJ\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ\r\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0006J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000e¨\u0006\u001f"}, d2 = {"Lcom/mpl/androidapp/utils/encryptedPrefs/MEncryptedPrefUtils;", "", "()V", "clearGameData", "", "getForceUploadFlag", "", "()Ljava/lang/Boolean;", "getGameBattleId", "", "getGameConfig", "getGameData", "getGameFocusState", "getGameId", "", "()Ljava/lang/Integer;", "init", "context", "Landroid/content/Context;", "putForceUploadFlag", "forceUpload", "putGameBattleId", "battleId", "putGameConfig", "config", "putGameData", "gameData", "putGameFocusState", "hasFocus", "putGameId", "gameId", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MEncryptedPrefUtils.kt */
public final class MEncryptedPrefUtils {
    public static final MEncryptedPrefUtils INSTANCE = new MEncryptedPrefUtils();

    public final void clearGameData() {
        putGameBattleId("");
        putGameConfig("");
        putGameData("");
        putForceUploadFlag(false);
        putGameFocusState(false);
        putGameId(0);
    }

    public final Boolean getForceUploadFlag() {
        return MEncryptedPrefs.INSTANCE.getBoolean(Constant.GAME_FORCE_UPLOAD, false);
    }

    public final String getGameBattleId() {
        return MEncryptedPrefs.INSTANCE.getString(Constant.GAME_BATTLE_ID, "");
    }

    public final String getGameConfig() {
        return MEncryptedPrefs.INSTANCE.getString(Constant.GAME_CONFIG, "");
    }

    public final String getGameData() {
        return MEncryptedPrefs.INSTANCE.getString(Constant.GAME_DATA, "");
    }

    public final Boolean getGameFocusState() {
        return MEncryptedPrefs.INSTANCE.getBoolean(Constant.GAME_STATE, false);
    }

    public final Integer getGameId() {
        return MEncryptedPrefs.INSTANCE.getInt(Constant.GAME_ID_UNITY, 0);
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MEncryptedPrefs.INSTANCE.init(context);
    }

    public final void putForceUploadFlag(boolean z) {
        MEncryptedPrefs.INSTANCE.putBoolean(Constant.GAME_FORCE_UPLOAD, z);
    }

    public final void putGameBattleId(String str) {
        Intrinsics.checkNotNullParameter(str, WebViewGameVm.KEY_BATTLE_ID);
        MEncryptedPrefs.INSTANCE.putString(Constant.GAME_BATTLE_ID, str);
    }

    public final void putGameConfig(String str) {
        Intrinsics.checkNotNullParameter(str, "config");
        MEncryptedPrefs.INSTANCE.putString(Constant.GAME_CONFIG, str);
    }

    public final void putGameData(String str) {
        Intrinsics.checkNotNullParameter(str, "gameData");
        MEncryptedPrefs.INSTANCE.putString(Constant.GAME_DATA, str);
    }

    public final void putGameFocusState(boolean z) {
        MEncryptedPrefs.INSTANCE.putBoolean(Constant.GAME_STATE, z);
    }

    public final void putGameId(int i) {
        MEncryptedPrefs.INSTANCE.putInt(Constant.GAME_ID_UNITY, i);
    }
}
