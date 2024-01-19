package com.mpl.androidapp.updater.downloadmanager.usecases;

import android.content.Context;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.updater.model.GameAssets;
import com.mpl.androidapp.updater.util.GEUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bJ\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/usecases/DownloadAssetTaskUseCase;", "", "()V", "SIZE_MB", "", "getSIZE_MB", "()J", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "downloadTaskParams", "Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "getDownloadTaskParams", "()Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "setDownloadTaskParams", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;)V", "gameAssets", "Lcom/mpl/androidapp/updater/model/GameAssets;", "getGameAssets", "()Lcom/mpl/androidapp/updater/model/GameAssets;", "setGameAssets", "(Lcom/mpl/androidapp/updater/model/GameAssets;)V", "tournamentId", "", "getTournamentId", "()Ljava/lang/String;", "setTournamentId", "(Ljava/lang/String;)V", "prepareDownloadTask", "gameAsset", "prepareWebViewBundleFilePath", "Ljava/io/File;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadAssetTaskUseCase.kt */
public final class DownloadAssetTaskUseCase {
    public final long SIZE_MB;
    public Context context;
    public DownloadTaskParams downloadTaskParams;
    public GameAssets gameAssets;
    public String tournamentId;

    private final File prepareWebViewBundleFilePath(Context context2) {
        if (this.gameAssets == null) {
            return null;
        }
        File gameAssetsDownloadDirPath = GEUtil.getGameAssetsDownloadDirPath(context2);
        if (!gameAssetsDownloadDirPath.exists()) {
            gameAssetsDownloadDirPath.createNewFile();
        }
        return gameAssetsDownloadDirPath;
    }

    public final Context getContext() {
        Context context2 = this.context;
        if (context2 != null) {
            return context2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        throw null;
    }

    public final DownloadTaskParams getDownloadTaskParams() {
        return this.downloadTaskParams;
    }

    public final GameAssets getGameAssets() {
        GameAssets gameAssets2 = this.gameAssets;
        if (gameAssets2 != null) {
            return gameAssets2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gameAssets");
        throw null;
    }

    public final long getSIZE_MB() {
        return this.SIZE_MB;
    }

    public final String getTournamentId() {
        return this.tournamentId;
    }

    public final DownloadTaskParams prepareDownloadTask(GameAssets gameAssets2, Context context2) {
        Intrinsics.checkNotNullParameter(gameAssets2, "gameAsset");
        Intrinsics.checkNotNullParameter(context2, "context");
        setContext(context2);
        setGameAssets(gameAssets2);
        if (this.gameAssets != null) {
            File prepareWebViewBundleFilePath = prepareWebViewBundleFilePath(context2);
            String str = null;
            if (prepareWebViewBundleFilePath != null) {
                String absolutePath = prepareWebViewBundleFilePath.getAbsolutePath();
                if (absolutePath != null) {
                    str = absolutePath;
                }
            }
            if (str != null) {
                String str2 = this.tournamentId;
                if (str2 == null) {
                    str2 = "111";
                }
                String url = getGameAssets().getUrl();
                Intrinsics.checkNotNullExpressionValue(url, "gameAssets.url");
                DownloadTaskParams downloadTaskParams2 = new DownloadTaskParams(url, getGameAssets().getGameId(), "webApp.zip", str + '/' + getGameAssets().getGameId(), getGameAssets(), Integer.parseInt(str2), getSIZE_MB(), 0, false);
                this.downloadTaskParams = downloadTaskParams2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        return this.downloadTaskParams;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setDownloadTaskParams(DownloadTaskParams downloadTaskParams2) {
        this.downloadTaskParams = downloadTaskParams2;
    }

    public final void setGameAssets(GameAssets gameAssets2) {
        Intrinsics.checkNotNullParameter(gameAssets2, "<set-?>");
        this.gameAssets = gameAssets2;
    }

    public final void setTournamentId(String str) {
        this.tournamentId = str;
    }
}
