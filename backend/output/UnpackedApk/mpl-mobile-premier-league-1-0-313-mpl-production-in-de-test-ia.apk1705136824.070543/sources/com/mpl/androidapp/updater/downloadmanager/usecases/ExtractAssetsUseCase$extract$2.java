package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.cleverTap.AssetsAnalytics;
import com.mpl.androidapp.cleverTap.AssetsAnalyticsProps;
import com.mpl.androidapp.config.UpdaterAnalytics;
import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.updater.gameengine.GEInteractor;
import com.mpl.androidapp.updater.interactor.FileInteractor;
import com.mpl.androidapp.updater.model.GameAssets;
import com.mpl.androidapp.utils.AssetsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.usecases.ExtractAssetsUseCase$extract$2", f = "ExtractAssetsUseCase.kt", l = {47}, m = "invokeSuspend")
/* compiled from: ExtractAssetsUseCase.kt */
public final class ExtractAssetsUseCase$extract$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ DownloadTaskParams $downloadTaskParams;
    public int label;
    public final /* synthetic */ ExtractAssetsUseCase this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.usecases.ExtractAssetsUseCase$extract$2$1", f = "ExtractAssetsUseCase.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.mpl.androidapp.updater.downloadmanager.usecases.ExtractAssetsUseCase$extract$2$1  reason: invalid class name */
    /* compiled from: ExtractAssetsUseCase.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(downloadTaskParams, extractAssetsUseCase, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                TweetUtils.throwOnFailure(obj);
                boolean isPokerFlow = downloadTaskParams.isPokerFlow();
                File file = new File(downloadTaskParams.getDownloadPath(), downloadTaskParams.getFileName());
                File file2 = new File(downloadTaskParams.getDownloadPath());
                GameAssets gameAssets = downloadTaskParams.getGameAssets();
                int gameId = gameAssets.getGameId();
                String gameName = gameAssets.getGameName();
                int assetVersion = gameAssets.getAssetVersion();
                int gameVersion = gameAssets.getGameVersion();
                if (!isPokerFlow) {
                    MLogger.d("DownloadOfAssets", "Starting extracting the file");
                    boolean extractZipFile = CommonUtils.extractZipFile(file, file2);
                    MLogger.d("DownloadOfAssets", "Extracting the file is completed");
                    UpdaterAnalytics.gameAssetsInstalledEvent(gameName, gameId, gameAssets, true, false);
                    if (gameAssets.getAssetVersion() != 0) {
                        MSharedPreferencesUtils.setDownloadedAssetVersion(extractAssetsUseCase.getContext(), gameId, assetVersion);
                    } else {
                        MSharedPreferencesUtils.setDownloadedAssetVersion(extractAssetsUseCase.getContext(), gameId, AssetsUtils.getGameVersion(gameId));
                    }
                    AssetsAnalyticsProps assetsAnalyticsProps = new AssetsAnalyticsProps();
                    assetsAnalyticsProps.setGameName(gameAssets.getGameName());
                    assetsAnalyticsProps.setGameId(gameAssets.getGameId());
                    assetsAnalyticsProps.setAssetsType("Assets");
                    assetsAnalyticsProps.setAssetsInstallSuccess(extractZipFile);
                    AssetsAnalytics.sendGameFileInstallStatusEvent(assetsAnalyticsProps);
                    AssetsUtils.addGameIdForMergedAssetsDownload(gameAssets.getGameId());
                    MSharedPreferencesUtils.putAssetsDownloadTime(gameId);
                    String dirMD5 = GEInteractor.dirMD5(new File(file2.getAbsolutePath(), String.valueOf(gameAssets.getGameId())).getAbsolutePath());
                    MSharedPreferencesUtils.saveGameHashForGameId(gameId, dirMD5);
                    MLogger.d("DownloadOfAssets", "HashCompare: ", "\nGame ID: ", new Integer(gameAssets.getGameId()), "\nPath: ", new File(file2.getAbsolutePath(), String.valueOf(gameAssets.getGameId())).getAbsolutePath(), "\nHash: ", dirMD5);
                } else if (FileInteractor.performWebAssetsFileOperationAfterDownload(extractAssetsUseCase.getContext(), String.valueOf(gameId), assetVersion, gameVersion)) {
                    MSharedPreferencesUtils.saveIntInNormalPref(extractAssetsUseCase.getContext(), Constant.POKER_ZIP_VERSION, assetVersion);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ExtractAssetsUseCase$extract$2(ExtractAssetsUseCase extractAssetsUseCase, DownloadTaskParams downloadTaskParams, Continuation<? super ExtractAssetsUseCase$extract$2> continuation) {
        // this.this$0 = extractAssetsUseCase;
        // this.$downloadTaskParams = downloadTaskParams;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExtractAssetsUseCase$extract$2(this.this$0, this.$downloadTaskParams, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExtractAssetsUseCase$extract$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            MLogger.d("DownloadOfAssets", "Extract process initiated");
            CoroutineDispatcher dispatcher = this.this$0.getDispatcher();
            final DownloadTaskParams downloadTaskParams = this.$downloadTaskParams;
            final ExtractAssetsUseCase extractAssetsUseCase = this.this$0;
            AnonymousClass1 r1 = new AnonymousClass1(null);
            this.label = 1;
            if (TypeUtilsKt.withContext(dispatcher, r1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            TweetUtils.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
