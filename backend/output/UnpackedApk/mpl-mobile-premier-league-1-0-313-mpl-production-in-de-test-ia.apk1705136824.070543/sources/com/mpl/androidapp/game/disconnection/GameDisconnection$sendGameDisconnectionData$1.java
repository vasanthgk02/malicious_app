package com.mpl.androidapp.game.disconnection;

import android.content.BroadcastReceiver.PendingResult;
import com.mpl.androidapp.react.MPLReactContainerActivity.GameEventCallback;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.encryptedPrefs.MEncryptedPrefUtils;
import com.razorpay.AnalyticsConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/mpl/androidapp/game/disconnection/GameDisconnection$sendGameDisconnectionData$1", "Lcom/mpl/androidapp/react/MPLReactContainerActivity$GameEventCallback;", "onFailure", "", "failure", "", "onSuccess", "success", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameDisconnection.kt */
public final class GameDisconnection$sendGameDisconnectionData$1 implements GameEventCallback {
    public final /* synthetic */ GameDisconnection this$0;

    public GameDisconnection$sendGameDisconnectionData$1(GameDisconnection gameDisconnection) {
        this.this$0 = gameDisconnection;
    }

    public void onFailure(String str) {
        Intrinsics.checkNotNullParameter(str, AnalyticsConstants.FAILURE);
        MLogger.e("GameDisconnectionHandling", Intrinsics.stringPlus("Failed to send Game Battle data from React activity, reason - ", str));
        PendingResult access$getPendingResult$p = this.this$0.pendingResult;
        if (access$getPendingResult$p != null) {
            access$getPendingResult$p.finish();
        }
    }

    public void onSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "success");
        MLogger.v("GameDisconnectionHandling", Intrinsics.stringPlus("Sending disconnection data to server success in React activity", str));
        MLogger.v("GameDisconnectionHandling", "clear game data called from onSuccess() method in React activity");
        MEncryptedPrefUtils.INSTANCE.clearGameData();
        PendingResult access$getPendingResult$p = this.this$0.pendingResult;
        if (access$getPendingResult$p != null) {
            access$getPendingResult$p.finish();
        }
        File file = new File(this.this$0.mCrashFilePath);
        if (file.exists()) {
            file.delete();
        }
    }
}
