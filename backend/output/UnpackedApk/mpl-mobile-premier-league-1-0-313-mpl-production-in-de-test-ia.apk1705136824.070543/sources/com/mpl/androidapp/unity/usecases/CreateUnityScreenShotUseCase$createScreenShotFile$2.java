package com.mpl.androidapp.unity.usecases;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.PixelCopy;
import android.view.PixelCopy.OnPixelCopyFinishedListener;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.mpl.androidapp.unity.states.MPLUnityFeaturesState;
import com.mpl.androidapp.unity.states.MPLUnityFeaturesState.UnityScreenSnapshotSuccess;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Success;
import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.mpl.androidapp.unity.usecases.CreateUnityScreenShotUseCase$createScreenShotFile$2", f = "CreateUnityScreenShotUseCase.kt", l = {}, m = "invokeSuspend")
/* compiled from: CreateUnityScreenShotUseCase.kt */
public final class CreateUnityScreenShotUseCase$createScreenShotFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Activity $activity;
    public final /* synthetic */ CancellableContinuation<UseCaseResult<? extends MPLUnityFeaturesState>> $coroutine;
    public final /* synthetic */ ViewGroup $decorView;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ CreateUnityScreenShotUseCase this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CreateUnityScreenShotUseCase$createScreenShotFile$2(CreateUnityScreenShotUseCase createUnityScreenShotUseCase, Activity activity, CancellableContinuation<? super UseCaseResult<? extends MPLUnityFeaturesState>> cancellableContinuation, ViewGroup viewGroup, Continuation<? super CreateUnityScreenShotUseCase$createScreenShotFile$2> continuation) {
        // this.this$0 = createUnityScreenShotUseCase;
        // this.$activity = activity;
        // this.$coroutine = cancellableContinuation;
        // this.$decorView = viewGroup;
        super(2, continuation);
    }

    /* renamed from: invokeSuspend$lambda-5$lambda-3$lambda-2  reason: not valid java name */
    public static final void m23invokeSuspend$lambda5$lambda3$lambda2(CreateUnityScreenShotUseCase createUnityScreenShotUseCase, File file, Bitmap bitmap, CoroutineScope coroutineScope, CancellableContinuation cancellableContinuation, int i) {
        Unit unit;
        try {
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            if (createUnityScreenShotUseCase.compressImage(file, bitmap) == null) {
                unit = null;
            } else {
                if (!TextUtils.isEmpty(file.getAbsolutePath())) {
                    String absolutePath = file.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "imageFile.absolutePath");
                    cancellableContinuation.resumeWith(new Success(new UnityScreenSnapshotSuccess(absolutePath)));
                } else {
                    createUnityScreenShotUseCase.errorHandling("shareUnityScreenshot: Image path is empty", cancellableContinuation);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                createUnityScreenShotUseCase.errorHandling("Compressing the image returned null", cancellableContinuation);
            }
        } catch (IOException e2) {
            createUnityScreenShotUseCase.errorHandling(Intrinsics.stringPlus("Exception in onPixelCopyFinished--->", e2.getMessage()), cancellableContinuation);
        }
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CreateUnityScreenShotUseCase$createScreenShotFile$2 createUnityScreenShotUseCase$createScreenShotFile$2 = new CreateUnityScreenShotUseCase$createScreenShotFile$2(this.this$0, this.$activity, this.$coroutine, this.$decorView, continuation);
        createUnityScreenShotUseCase$createScreenShotFile$2.L$0 = obj;
        return createUnityScreenShotUseCase$createScreenShotFile$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateUnityScreenShotUseCase$createScreenShotFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            TweetUtils.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            MLogger.d("TakingScreenshotForUnityScreen", "createScreenShotFile: ");
            if (VERSION.SDK_INT >= 24) {
                File access$createSnapshotFile = this.this$0.createSnapshotFile(this.$activity);
                Unit unit = null;
                if (access$createSnapshotFile != null) {
                    CreateUnityScreenShotUseCase createUnityScreenShotUseCase = this.this$0;
                    ViewGroup viewGroup = this.$decorView;
                    CancellableContinuation<UseCaseResult<? extends MPLUnityFeaturesState>> cancellableContinuation = this.$coroutine;
                    createUnityScreenShotUseCase.getSurfaceView(viewGroup);
                    SurfaceView access$getSurfaceView = createUnityScreenShotUseCase.getSurfaceView(viewGroup);
                    if (access$getSurfaceView != null) {
                        Bitmap createBitmap = Bitmap.createBitmap(access$getSurfaceView.getWidth(), access$getSurfaceView.getHeight(), Config.ARGB_8888);
                        Handler handler = new Handler(Looper.getMainLooper());
                        $$Lambda$akvBpwXdwd1VBAaiBbeTwLfGPiI r0 = new OnPixelCopyFinishedListener(access$createSnapshotFile, createBitmap, coroutineScope, cancellableContinuation) {
                            public final /* synthetic */ File f$1;
                            public final /* synthetic */ Bitmap f$2;
                            public final /* synthetic */ CoroutineScope f$3;
                            public final /* synthetic */ CancellableContinuation f$4;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                                this.f$3 = r4;
                                this.f$4 = r5;
                            }

                            public final void onPixelCopyFinished(int i) {
                                CreateUnityScreenShotUseCase$createScreenShotFile$2.m23invokeSuspend$lambda5$lambda3$lambda2(CreateUnityScreenShotUseCase.this, this.f$1, this.f$2, this.f$3, this.f$4, i);
                            }
                        };
                        PixelCopy.request(access$getSurfaceView, createBitmap, r0, handler);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        createUnityScreenShotUseCase.errorHandling("Surface view is null in UserJourneyRecorder", cancellableContinuation);
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    this.this$0.errorHandling("Creating the file received null", this.$coroutine);
                }
            } else {
                this.this$0.errorHandling("Is below api 24", this.$coroutine);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
