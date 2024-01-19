package com.mpl.androidapp.updater.downloadmanager.usecases;

import com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams;
import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
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
@DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.usecases.CopyPokerAssetFileUseCase$copyAsset$2", f = "CopyPokerAssetFileUseCase.kt", l = {43}, m = "invokeSuspend")
/* compiled from: CopyPokerAssetFileUseCase.kt */
public final class CopyPokerAssetFileUseCase$copyAsset$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ DownloadTaskParams $downloadTaskParams;
    public int label;
    public final /* synthetic */ CopyPokerAssetFileUseCase this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.mpl.androidapp.updater.downloadmanager.usecases.CopyPokerAssetFileUseCase$copyAsset$2$1", f = "CopyPokerAssetFileUseCase.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.mpl.androidapp.updater.downloadmanager.usecases.CopyPokerAssetFileUseCase$copyAsset$2$1  reason: invalid class name */
    /* compiled from: CopyPokerAssetFileUseCase.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(copyPokerAssetFileUseCase, downloadTaskParams, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f0, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r7, r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f4, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f7, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f8, code lost:
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r5, r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fb, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r0 = r8.label
                if (r0 != 0) goto L_0x0105
                com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
                com.mpl.androidapp.updater.downloadmanager.usecases.CopyPokerAssetFileUseCase r9 = r3
                android.content.Context r9 = r9.getContext()
                com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r0 = r4
                int r0 = r0.getGameId()
                java.lang.String r0 = java.lang.String.valueOf(r0)
                com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r1 = r4
                com.mpl.androidapp.updater.model.GameAssets r1 = r1.getGameAssets()
                int r1 = r1.getAssetVersion()
                java.io.File r9 = com.mpl.androidapp.utils.FileUtils.getWebViewBundleOutputFile(r9, r0, r1)
                r0 = 1
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.String r1 = r9.getAbsolutePath()
                java.lang.String r2 = "Destination file path "
                java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r1)
                r2 = 0
                r0[r2] = r1
                java.lang.String r1 = "DownloadOfAssets"
                com.mpl.androidapp.utils.MLogger.d(r1, r0)
                java.io.File r0 = new java.io.File
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r3 = r4
                java.lang.String r3 = r3.getDownloadPath()
                r1.append(r3)
                r3 = 47
                r1.append(r3)
                com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r3 = r4
                java.lang.String r3 = r3.getFileName()
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                java.lang.String r0 = r0.getAbsolutePath()
                java.io.File r1 = new java.io.File
                r1.<init>(r0)
                java.io.File r0 = new java.io.File
                java.lang.String r3 = r9.getAbsolutePath()
                r0.<init>(r3)
                r3 = 8192(0x2000, float:1.148E-41)
                java.lang.String r4 = "<this>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
                java.lang.String r5 = "target"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
                boolean r5 = r1.exists()
                r6 = 0
                if (r5 == 0) goto L_0x00fc
                boolean r5 = r0.exists()
                if (r5 == 0) goto L_0x0094
                kotlin.io.FileAlreadyExistsException r9 = new kotlin.io.FileAlreadyExistsException
                java.lang.String r2 = "The destination file already exists."
                r9.<init>(r1, r0, r2)
                throw r9
            L_0x0094:
                boolean r5 = r1.isDirectory()
                if (r5 == 0) goto L_0x00a9
                boolean r2 = r0.mkdirs()
                if (r2 == 0) goto L_0x00a1
                goto L_0x00da
            L_0x00a1:
                kotlin.io.FileSystemException r9 = new kotlin.io.FileSystemException
                java.lang.String r2 = "Failed to create target directory."
                r9.<init>(r1, r0, r2)
                throw r9
            L_0x00a9:
                java.io.File r5 = r0.getParentFile()
                if (r5 == 0) goto L_0x00b2
                r5.mkdirs()
            L_0x00b2:
                java.io.FileInputStream r5 = new java.io.FileInputStream
                r5.<init>(r1)
                java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x00f5 }
                r7.<init>(r0)     // Catch:{ all -> 0x00f5 }
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)     // Catch:{ all -> 0x00ee }
                java.lang.String r0 = "out"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)     // Catch:{ all -> 0x00ee }
                byte[] r0 = new byte[r3]     // Catch:{ all -> 0x00ee }
                int r3 = r5.read(r0)     // Catch:{ all -> 0x00ee }
            L_0x00ca:
                if (r3 < 0) goto L_0x00d4
                r7.write(r0, r2, r3)     // Catch:{ all -> 0x00ee }
                int r3 = r5.read(r0)     // Catch:{ all -> 0x00ee }
                goto L_0x00ca
            L_0x00d4:
                com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r7, r6)     // Catch:{ all -> 0x00f5 }
                com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r5, r6)
            L_0x00da:
                r1.delete()
                com.mpl.androidapp.updater.downloadmanager.data.DownloadTaskParams r0 = r4
                java.lang.String r9 = r9.getAbsolutePath()
                java.lang.String r1 = "outFile.absolutePath"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)
                r0.setDownloadPath(r9)
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            L_0x00ee:
                r9 = move-exception
                throw r9     // Catch:{ all -> 0x00f0 }
            L_0x00f0:
                r0 = move-exception
                com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r7, r9)     // Catch:{ all -> 0x00f5 }
                throw r0     // Catch:{ all -> 0x00f5 }
            L_0x00f5:
                r9 = move-exception
                throw r9     // Catch:{ all -> 0x00f7 }
            L_0x00f7:
                r0 = move-exception
                com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r5, r9)
                throw r0
            L_0x00fc:
                kotlin.io.NoSuchFileException r9 = new kotlin.io.NoSuchFileException
                r0 = 2
                java.lang.String r2 = "The source file doesn't exist."
                r9.<init>(r1, r6, r2, r0)
                throw r9
            L_0x0105:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.updater.downloadmanager.usecases.CopyPokerAssetFileUseCase$copyAsset$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CopyPokerAssetFileUseCase$copyAsset$2(CopyPokerAssetFileUseCase copyPokerAssetFileUseCase, DownloadTaskParams downloadTaskParams, Continuation<? super CopyPokerAssetFileUseCase$copyAsset$2> continuation) {
        // this.this$0 = copyPokerAssetFileUseCase;
        // this.$downloadTaskParams = downloadTaskParams;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CopyPokerAssetFileUseCase$copyAsset$2(this.this$0, this.$downloadTaskParams, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CopyPokerAssetFileUseCase$copyAsset$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            TweetUtils.throwOnFailure(obj);
            MLogger.d("DownloadOfAssets", "Extract process initiated");
            CoroutineDispatcher dispatcher = this.this$0.getDispatcher();
            final CopyPokerAssetFileUseCase copyPokerAssetFileUseCase = this.this$0;
            final DownloadTaskParams downloadTaskParams = this.$downloadTaskParams;
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
