package com.mpl.androidapp.webview;

import android.app.Application;
import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.miniprofile.base.BaseViewModel;
import com.mpl.androidapp.updater.downloadmanager.DownloadFeature;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.updater.downloadmanager.di.entrypoints.AssetDownloadEntryPoint;
import com.mpl.androidapp.updater.downloadmanager.usecases.DownloadAssetTaskUseCase;
import com.mpl.androidapp.updater.downloadmanager.usecases.PrepareGameAssetUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.Constants;
import com.mpl.androidapp.updater.interactor.FileInteractor;
import com.mpl.androidapp.updater.model.GameAssets;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.webview.ct.utils.UtilWebGameEndToEndEvent;
import com.razorpay.AnalyticsConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020;2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010?\u001a\u00020;J\u0006\u0010@\u001a\u00020;JF\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\"2\u0006\u0010F\u001a\u00020\"2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020'J\u001e\u0010K\u001a\u00020;2\u0006\u0010E\u001a\u00020\"2\u0006\u0010F\u001a\u00020\"2\u0006\u0010B\u001a\u00020\"R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR-\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!j\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"`#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0017\u00102\u001a\b\u0012\u0004\u0012\u0002030\f¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u000fR\u001c\u00105\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006M"}, d2 = {"Lcom/mpl/androidapp/webview/PokerWebViewVm;", "Lcom/mpl/androidapp/miniprofile/base/BaseViewModel;", "context", "Landroid/app/Application;", "prepareGameAsset", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/PrepareGameAssetUseCase;", "downloadPokerAssetTask", "Lcom/mpl/androidapp/updater/downloadmanager/usecases/DownloadAssetTaskUseCase;", "(Landroid/app/Application;Lcom/mpl/androidapp/updater/downloadmanager/usecases/PrepareGameAssetUseCase;Lcom/mpl/androidapp/updater/downloadmanager/usecases/DownloadAssetTaskUseCase;)V", "TAG", "", "booleanViewObserve", "Landroidx/lifecycle/MutableLiveData;", "Lcom/mpl/androidapp/webview/PokerViewData;", "getBooleanViewObserve", "()Landroidx/lifecycle/MutableLiveData;", "getDownloadPokerAssetTask", "()Lcom/mpl/androidapp/updater/downloadmanager/usecases/DownloadAssetTaskUseCase;", "setDownloadPokerAssetTask", "(Lcom/mpl/androidapp/updater/downloadmanager/usecases/DownloadAssetTaskUseCase;)V", "downloadTaskParams", "Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "getDownloadTaskParams", "()Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;", "setDownloadTaskParams", "(Lcom/mpl/androidapp/updater/downloadmanager/data/DownloadTaskParams;)V", "gameAssets", "Lcom/mpl/androidapp/updater/model/GameAssets;", "getGameAssets", "()Lcom/mpl/androidapp/updater/model/GameAssets;", "setGameAssets", "(Lcom/mpl/androidapp/updater/model/GameAssets;)V", "idProgress", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getIdProgress", "()Ljava/util/HashMap;", "isDownloadFileV2", "", "()Z", "setDownloadFileV2", "(Z)V", "pokerAssetDownloadFailObserver", "Lcom/mpl/androidapp/webview/PokerDownloadAssetFailData;", "getPokerAssetDownloadFailObserver", "getPrepareGameAsset", "()Lcom/mpl/androidapp/updater/downloadmanager/usecases/PrepareGameAssetUseCase;", "setPrepareGameAsset", "(Lcom/mpl/androidapp/updater/downloadmanager/usecases/PrepareGameAssetUseCase;)V", "progressLiveData", "Lcom/mpl/androidapp/webview/ProgressPokerData;", "getProgressLiveData", "tournamentId", "getTournamentId", "()Ljava/lang/String;", "setTournamentId", "(Ljava/lang/String;)V", "handleBroadcast", "", "intent", "Landroid/content/Intent;", "initDownloadManager", "initiatePokerDownload", "prepareDownloadTaskParams", "prepareGameAssets", "mGameId", "downloadUrl", "nameOfGame", "oldVersion", "newVersion", "downloadingHash", "sizeOfAsset", "", "shouldRetry", "syncWebViewFolder", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PokerWebViewVm.kt */
public final class PokerWebViewVm extends BaseViewModel {
    public static final Companion Companion = new Companion(null);
    public static final String FILE_NAME_POKER = "webApp.zip";
    public static final String GAME_NAME_POKER = "Poker";
    public static final boolean IS_WEB_VIEW_FLOW = true;
    public static final long SIZE_MB = 0;
    public final String TAG = "PokerWebViewVm";
    public final MutableLiveData<PokerViewData> booleanViewObserve = new MutableLiveData<>();
    public DownloadAssetTaskUseCase downloadPokerAssetTask;
    public DownloadTaskParams downloadTaskParams;
    public GameAssets gameAssets;
    public final HashMap<Integer, Integer> idProgress = new HashMap<>();
    public boolean isDownloadFileV2;
    public final MutableLiveData<PokerDownloadAssetFailData> pokerAssetDownloadFailObserver = new MutableLiveData<>();
    public PrepareGameAssetUseCase prepareGameAsset;
    public final MutableLiveData<ProgressPokerData> progressLiveData = new MutableLiveData<>();
    public String tournamentId;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/mpl/androidapp/webview/PokerWebViewVm$Companion;", "", "()V", "FILE_NAME_POKER", "", "GAME_NAME_POKER", "IS_WEB_VIEW_FLOW", "", "SIZE_MB", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PokerWebViewVm.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public PokerWebViewVm(Application application, PrepareGameAssetUseCase prepareGameAssetUseCase, DownloadAssetTaskUseCase downloadAssetTaskUseCase) {
        // Intrinsics.checkNotNullParameter(application, "context");
        // Intrinsics.checkNotNullParameter(prepareGameAssetUseCase, "prepareGameAsset");
        // Intrinsics.checkNotNullParameter(downloadAssetTaskUseCase, "downloadPokerAssetTask");
        super(application);
        this.prepareGameAsset = prepareGameAssetUseCase;
        this.downloadPokerAssetTask = downloadAssetTaskUseCase;
    }

    private final void initDownloadManager(DownloadTaskParams downloadTaskParams2) {
        try {
            Object fromApplication = TweetUtils.fromApplication(getContext(), AssetDownloadEntryPoint.class);
            Intrinsics.checkNotNullExpressionValue(fromApplication, "fromApplication(context,…adEntryPoint::class.java)");
            AssetDownloadEntryPoint assetDownloadEntryPoint = (AssetDownloadEntryPoint) fromApplication;
            DownloadFeature downloadFeature = new DownloadFeature(downloadTaskParams2, assetDownloadEntryPoint.downloadAssetsService(), assetDownloadEntryPoint.downloadProgressAssetsService(), assetDownloadEntryPoint.gameAssetResourceRepo(), assetDownloadEntryPoint.getGameResourceUseCase(), assetDownloadEntryPoint.updateAssetsAnalyticsUseCase(), assetDownloadEntryPoint.InsertAssetEntryUseCase(), assetDownloadEntryPoint.ioDispatcher(), true);
            downloadFeature.runFeature();
        } catch (Exception e2) {
            MLogger.e(this.TAG, "", e2);
        }
    }

    public final MutableLiveData<PokerViewData> getBooleanViewObserve() {
        return this.booleanViewObserve;
    }

    public final DownloadAssetTaskUseCase getDownloadPokerAssetTask() {
        return this.downloadPokerAssetTask;
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

    public final HashMap<Integer, Integer> getIdProgress() {
        return this.idProgress;
    }

    public final MutableLiveData<PokerDownloadAssetFailData> getPokerAssetDownloadFailObserver() {
        return this.pokerAssetDownloadFailObserver;
    }

    public final PrepareGameAssetUseCase getPrepareGameAsset() {
        return this.prepareGameAsset;
    }

    public final MutableLiveData<ProgressPokerData> getProgressLiveData() {
        return this.progressLiveData;
    }

    public final String getTournamentId() {
        return this.tournamentId;
    }

    public final void handleBroadcast(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, AnalyticsConstants.INTENT);
        if (Intrinsics.areEqual(Constants.WEB_VIEW_ASSET_PROGRESS, intent.getAction())) {
            try {
                int intExtra = intent.getIntExtra(Constants.BYTES_DOWNLOADED, 0);
                int intExtra2 = intent.getIntExtra(Constants.TOTAL_SIZE, 0);
                this.progressLiveData.setValue(new ProgressPokerData(intExtra, intExtra2, (int) ((((long) intExtra) * 100) / ((long) intExtra2))));
            } catch (Exception e2) {
                MLogger.e(this.TAG, "", e2);
            }
        }
        if (Intrinsics.areEqual(Constants.WEB_VIEW_ASSET_PROGRESS_COMPLETE, intent.getAction())) {
            int intExtra3 = intent.getIntExtra(Constants.BYTES_DOWNLOADED, 0);
            int intExtra4 = intent.getIntExtra(Constants.TOTAL_SIZE, 0);
            int intExtra5 = intent.getIntExtra("GameId", 0);
            int intExtra6 = intent.getIntExtra(Constants.NEW_VERSION, 0);
            this.progressLiveData.setValue(new ProgressPokerData(intExtra3, intExtra4, 100));
            this.booleanViewObserve.setValue(new PokerViewData(intExtra5, intExtra6));
            UtilWebGameEndToEndEvent.INSTANCE.assetDownloadSuccessful(intExtra5);
        }
        if (Intrinsics.areEqual(Constants.WEB_VIEW_ASSET_DOWNLOAD_FAIL, intent.getAction())) {
            int intExtra7 = intent.getIntExtra(Constants.BYTES_DOWNLOADED, 0);
            int intExtra8 = intent.getIntExtra(Constants.TOTAL_SIZE, 0);
            int intExtra9 = intent.getIntExtra("GameId", 0);
            int intExtra10 = intent.getIntExtra(Constants.NEW_VERSION, 0);
            this.progressLiveData.setValue(new ProgressPokerData(intExtra7, intExtra8, 100));
            this.booleanViewObserve.setValue(new PokerViewData(intExtra9, intExtra10));
            this.pokerAssetDownloadFailObserver.setValue(new PokerDownloadAssetFailData(intExtra9, intExtra10));
            UtilWebGameEndToEndEvent.INSTANCE.assetDownloadFailure(intExtra9, "Some error occurred in poker game download");
        }
    }

    public final void initiatePokerDownload() {
        DownloadTaskParams downloadTaskParams2 = this.downloadTaskParams;
        if (downloadTaskParams2 != null) {
            initDownloadManager(downloadTaskParams2);
        }
    }

    public final boolean isDownloadFileV2() {
        return this.isDownloadFileV2;
    }

    public final void prepareDownloadTaskParams() {
        this.downloadTaskParams = this.downloadPokerAssetTask.prepareDownloadTask(getGameAssets(), getContext());
    }

    public final void prepareGameAssets(int i, String str, String str2, int i2, int i3, String str3, long j, boolean z) {
        GeneratedOutlineSupport.outline97(str, Response.DOWNLOAD_URL, str2, "nameOfGame", str3, "downloadingHash");
        setGameAssets(this.prepareGameAsset.setGameAsset(i, str, str2, i2, i3, str3, j, z));
    }

    public final void setDownloadFileV2(boolean z) {
        this.isDownloadFileV2 = z;
    }

    public final void setDownloadPokerAssetTask(DownloadAssetTaskUseCase downloadAssetTaskUseCase) {
        Intrinsics.checkNotNullParameter(downloadAssetTaskUseCase, "<set-?>");
        this.downloadPokerAssetTask = downloadAssetTaskUseCase;
    }

    public final void setDownloadTaskParams(DownloadTaskParams downloadTaskParams2) {
        this.downloadTaskParams = downloadTaskParams2;
    }

    public final void setGameAssets(GameAssets gameAssets2) {
        Intrinsics.checkNotNullParameter(gameAssets2, "<set-?>");
        this.gameAssets = gameAssets2;
    }

    public final void setPrepareGameAsset(PrepareGameAssetUseCase prepareGameAssetUseCase) {
        Intrinsics.checkNotNullParameter(prepareGameAssetUseCase, "<set-?>");
        this.prepareGameAsset = prepareGameAssetUseCase;
    }

    public final void setTournamentId(String str) {
        this.tournamentId = str;
    }

    public final void syncWebViewFolder(int i, int i2, int i3) {
        if (i2 > i) {
            FileInteractor.getWebAssetsFolder(getContext(), i3, i2, true);
        }
    }
}
