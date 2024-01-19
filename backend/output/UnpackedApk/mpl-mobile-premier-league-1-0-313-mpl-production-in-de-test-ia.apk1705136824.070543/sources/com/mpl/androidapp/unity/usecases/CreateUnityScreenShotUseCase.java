package com.mpl.androidapp.unity.usecases;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.format.DateFormat;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.mpl.androidapp.unity.models.UnityScreenShotParams;
import com.mpl.androidapp.unity.states.MPLUnityFeaturesState;
import com.mpl.androidapp.updater.downloadmanager.di.qualifiers.IoDispatcher;
import com.mpl.androidapp.updater.downloadmanager.utils.SuspendUseCase;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult;
import com.mpl.androidapp.updater.downloadmanager.utils.UseCaseResult.Error;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MLogger;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001*B\u001b\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J5\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00172\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u001bH\u0002J\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010%\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u001fH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/mpl/androidapp/unity/usecases/CreateUnityScreenShotUseCase;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/SuspendUseCase;", "Lcom/mpl/androidapp/unity/models/UnityScreenShotParams;", "Lcom/mpl/androidapp/updater/downloadmanager/utils/UseCaseResult;", "Lcom/mpl/androidapp/unity/states/MPLUnityFeaturesState;", "context", "Landroid/content/Context;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "compressImage", "Ljava/io/FileOutputStream;", "imageFile", "Ljava/io/File;", "bitmap", "Landroid/graphics/Bitmap;", "createFileName", "", "createScreenShotFile", "", "coroutine", "Lkotlinx/coroutines/CancellableContinuation;", "activity", "Landroid/app/Activity;", "decorView", "Landroid/view/ViewGroup;", "(Lkotlinx/coroutines/CancellableContinuation;Landroid/app/Activity;Landroid/view/ViewGroup;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSnapshotFile", "errorHandling", "errorMessage", "execute", "parameters", "(Lcom/mpl/androidapp/unity/models/UnityScreenShotParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSurfaceView", "Landroid/view/SurfaceView;", "viewGroup", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CreateUnityScreenShotUseCase.kt */
public final class CreateUnityScreenShotUseCase extends SuspendUseCase<UnityScreenShotParams, UseCaseResult<? extends MPLUnityFeaturesState>> {
    public static final Companion Companion = new Companion(null);
    public static final String PROFILE_ID_NULL = "Profile id is null";
    public Context context;
    public final CoroutineDispatcher dispatcher;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/unity/usecases/CreateUnityScreenShotUseCase$Companion;", "", "()V", "PROFILE_ID_NULL", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CreateUnityScreenShotUseCase.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CreateUnityScreenShotUseCase(Context context2, @IoDispatcher CoroutineDispatcher coroutineDispatcher) {
        // Intrinsics.checkNotNullParameter(context2, "context");
        // Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        super(coroutineDispatcher);
        this.context = context2;
        this.dispatcher = coroutineDispatcher;
    }

    /* access modifiers changed from: private */
    public final FileOutputStream compressImage(File file, Bitmap bitmap) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(CompressFormat.JPEG, 50, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return fileOutputStream;
        } catch (Exception e2) {
            e2.printStackTrace();
            MLogger.d("TakingScreenshotForUnityScreen", e2.getMessage());
            return null;
        }
    }

    private final String createFileName() {
        Date date = new Date();
        DateFormat.format("yyyy-MM-dd_hh:mm:ss", date);
        return "MPL_" + date + ".jpg";
    }

    /* access modifiers changed from: private */
    public final Object createScreenShotFile(CancellableContinuation<? super UseCaseResult<? extends MPLUnityFeaturesState>> cancellableContinuation, Activity activity, ViewGroup viewGroup, Continuation<? super Unit> continuation) {
        CoroutineDispatcher coroutineDispatcher = Dispatchers.Default;
        CreateUnityScreenShotUseCase$createScreenShotFile$2 createUnityScreenShotUseCase$createScreenShotFile$2 = new CreateUnityScreenShotUseCase$createScreenShotFile$2(this, activity, cancellableContinuation, viewGroup, null);
        Object withContext = TypeUtilsKt.withContext(coroutineDispatcher, createUnityScreenShotUseCase$createScreenShotFile$2, continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final File createSnapshotFile(Activity activity) {
        try {
            return new File(FileUtils.getAppExternalScreenShotStoragePath(activity), createFileName());
        } catch (Exception e2) {
            e2.printStackTrace();
            MLogger.d("TakingScreenshotForUnityScreen", e2.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void errorHandling(String str, CancellableContinuation<? super UseCaseResult<? extends MPLUnityFeaturesState>> cancellableContinuation) {
        MLogger.d("TakingScreenshotForUnityScreen", str);
        cancellableContinuation.resumeWith(new Error(new Exception(str)));
    }

    /* access modifiers changed from: private */
    public final SurfaceView getSurfaceView(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (i < childCount) {
            int i2 = i + 1;
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                SurfaceView surfaceView = getSurfaceView((ViewGroup) childAt);
                if (surfaceView != null) {
                    return surfaceView;
                }
            } else if (childAt instanceof SurfaceView) {
                MLogger.d("TakingScreenshotForUnityScreen", Intrinsics.stringPlus("view of type", childAt.getClass().getName()));
                return (SurfaceView) childAt;
            }
            i = i2;
        }
        return null;
    }

    public final Context getContext() {
        return this.context;
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public Object execute(UnityScreenShotParams unityScreenShotParams, Continuation<? super UseCaseResult<? extends MPLUnityFeaturesState>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(TweetUtils.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        TypeUtilsKt.runBlocking(getDispatcher(), new CreateUnityScreenShotUseCase$execute$2$1(unityScreenShotParams, this, cancellableContinuationImpl, null));
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, "frame");
        }
        return result;
    }
}
