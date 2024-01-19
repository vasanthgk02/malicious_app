package com.mpl.androidapp.updater.downloadmanager.downloadModules;

import android.app.DownloadManager;
import android.content.Context;
import com.mpl.androidapp.database.entity.GameAssetResource;
import com.mpl.androidapp.database.repo.GameAssetResourceRepo;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB+\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001f\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/DownloadFailSafe;", "", "context", "Landroid/content/Context;", "gameAssetResourceRepo", "Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;", "downloadManager", "Landroid/app/DownloadManager;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;Landroid/app/DownloadManager;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getDownloadManager", "()Landroid/app/DownloadManager;", "setDownloadManager", "(Landroid/app/DownloadManager;)V", "getGameAssetResourceRepo", "()Lcom/mpl/androidapp/database/repo/GameAssetResourceRepo;", "clearDownloadIds", "", "gameResourceList", "", "Lcom/mpl/androidapp/database/entity/GameAssetResource;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAssetResources", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetAssetDownloads", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadFailSafe.kt */
public final class DownloadFailSafe {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "DownloadOfAssets";
    public Context context;
    public DownloadManager downloadManager;
    public final GameAssetResourceRepo gameAssetResourceRepo;
    public final CoroutineDispatcher ioDispatcher;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/downloadModules/DownloadFailSafe$Companion;", "", "()V", "TAG", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DownloadFailSafe.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DownloadFailSafe(Context context2, GameAssetResourceRepo gameAssetResourceRepo2, DownloadManager downloadManager2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(gameAssetResourceRepo2, "gameAssetResourceRepo");
        Intrinsics.checkNotNullParameter(downloadManager2, "downloadManager");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        this.context = context2;
        this.gameAssetResourceRepo = gameAssetResourceRepo2;
        this.downloadManager = downloadManager2;
        this.ioDispatcher = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    public final Object clearDownloadIds(List<GameAssetResource> list, Continuation<? super Unit> continuation) {
        Object withContext = TypeUtilsKt.withContext(this.ioDispatcher, new DownloadFailSafe$clearDownloadIds$2(list, this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object getAllAssetResources(Continuation<? super List<GameAssetResource>> continuation) {
        return TypeUtilsKt.withContext(this.ioDispatcher, new DownloadFailSafe$getAllAssetResources$2(this, null), continuation);
    }

    public final Context getContext() {
        return this.context;
    }

    public final DownloadManager getDownloadManager() {
        return this.downloadManager;
    }

    public final GameAssetResourceRepo getGameAssetResourceRepo() {
        return this.gameAssetResourceRepo;
    }

    public final Object resetAssetDownloads(Continuation<? super Unit> continuation) {
        Object withContext = TypeUtilsKt.withContext(this.ioDispatcher, new DownloadFailSafe$resetAssetDownloads$2(this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setDownloadManager(DownloadManager downloadManager2) {
        Intrinsics.checkNotNullParameter(downloadManager2, "<set-?>");
        this.downloadManager = downloadManager2;
    }
}
