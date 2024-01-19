package com.mpl.androidapp.updater.downloadmanager.usecases;

import android.text.TextUtils;
import com.mpl.androidapp.updater.model.GameAssets;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.webview.PokerWebViewVm;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002JF\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/usecases/PrepareGameAssetUseCase;", "", "()V", "gameAssets", "Lcom/mpl/androidapp/updater/model/GameAssets;", "getGameAssets", "()Lcom/mpl/androidapp/updater/model/GameAssets;", "setGameAssets", "(Lcom/mpl/androidapp/updater/model/GameAssets;)V", "prepareGameName", "", "nameOfGame", "setGameAsset", "mGameId", "", "downloadUrl", "oldVersion", "newVersion", "downloadingHash", "sizeOfAsset", "", "shouldRetry", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepareGameAssetUseCase.kt */
public final class PrepareGameAssetUseCase {
    public GameAssets gameAssets;

    private final String prepareGameName(String str) {
        return TextUtils.isEmpty(str) ? PokerWebViewVm.GAME_NAME_POKER : str;
    }

    public final GameAssets getGameAssets() {
        GameAssets gameAssets2 = this.gameAssets;
        if (gameAssets2 != null) {
            return gameAssets2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gameAssets");
        throw null;
    }

    public final GameAssets setGameAsset(int i, String str, String str2, int i2, int i3, String str3, long j, boolean z) {
        Intrinsics.checkNotNullParameter(str, Response.DOWNLOAD_URL);
        Intrinsics.checkNotNullParameter(str2, "nameOfGame");
        Intrinsics.checkNotNullParameter(str3, "downloadingHash");
        GameAssets gameAssets2 = new GameAssets();
        gameAssets2.setAssetVersion(i3);
        gameAssets2.setGameId(i);
        gameAssets2.setUrl(str);
        gameAssets2.setGameName(prepareGameName(str2));
        gameAssets2.setGameVersion(i2);
        gameAssets2.setHash(str3);
        gameAssets2.setSize(j);
        gameAssets2.setRetry(z);
        setGameAssets(gameAssets2);
        return getGameAssets();
    }

    public final void setGameAssets(GameAssets gameAssets2) {
        Intrinsics.checkNotNullParameter(gameAssets2, "<set-?>");
        this.gameAssets = gameAssets2;
    }
}
